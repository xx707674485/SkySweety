/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xjst.skysweety.util.delegate.component;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class DelegateEmitter implements DelegateComponent {


  private final Map<Event<?>, List<Listener>> listenerMap;

  // Only used for fast removal of listeners
  private final Map<Listener, Event<?>> eventMap;

  public DelegateEmitter() {
    this.listenerMap = new ConcurrentHashMap<>();
    this.eventMap = new ConcurrentHashMap<>();
  }



  @Override
  public final <T> void addListener(@NonNull Event<T> event, @NonNull Listener<T> listener) {

    // Check that we're not adding the same listener in multiple places
    // For the same event, it's idempotent; for different events, it's an error
    if (eventMap.containsKey(listener)) {
      final Event otherEvent = eventMap.get(listener);
      if (!event.equals(otherEvent)) {
        throw new IllegalStateException(
            "Cannot use the same listener for two events! e1: " + event + " e2: " + otherEvent);
      }
      return;
    }

    eventMap.put(listener, event);

    if (!listenerMap.containsKey(event)) {
      listenerMap.put(event, new CopyOnWriteArrayList<>());
    }

    List<Listener> listeners = listenerMap.get(event);
    listeners.add(listener);
  }

  @Override public final <T> void removeListener(@NonNull Listener<T> listener) {
    final Event event = eventMap.remove(listener);
    if (event != null && listenerMap.containsKey(event)) {
      listenerMap.get(event).remove(listener);
    }
  }


  public  <T> void emitEvent( Event<T> event,  T data) {
    // We gather listener iterators  all at once so adding/removing listeners during emission
    // doesn't change the listener list.
    final List<Listener> listeners = listenerMap.get(event);
    final Iterator<Listener> listenersIterator =
        listeners != null ? listeners.listIterator() : null;

    if (listeners != null) {
      while (listenersIterator.hasNext()) {
        listenersIterator.next().call(data);
      }
    }
  }


}
