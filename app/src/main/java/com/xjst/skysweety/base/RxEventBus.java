package com.xjst.skysweety.base;


import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;


/**
 *
 */

public class RxEventBus {
    private static RxEventBus instance;

    public static synchronized RxEventBus getInstance() {
        if (instance == null) {
            instance = new RxEventBus();
        }
        return instance;
    }

    private RxEventBus() {
    }

    private ConcurrentHashMap<Object, List<Subject>> subjectMapper = new ConcurrentHashMap<>();

    /**
     * 订阅事件源
     *
     * @param mObservable
     * @param mAction1
     * @return
     */
    public RxEventBus onEvent(Observable<?> mObservable, Consumer<Object> mAction1) {
        mObservable.observeOn(AndroidSchedulers.mainThread()).subscribe(mAction1, (e) -> e.printStackTrace());
        return getInstance();
    }

    /**
     * 注册事件源
     *
     * @param tag
     * @param <T>
     * @return
     */
    public <T> Observable<T> register(Object tag) {
        List<Subject> subjectList = subjectMapper.get(tag);
        if (subjectList == null) {
            subjectList = new ArrayList<Subject>();
            subjectMapper.put(tag, subjectList);
        }
        Subject<T> subject;
        subjectList.add(subject = PublishSubject.create());
        Log.d("register", tag + " size:" + subjectList.size());
        return subject;
    }

    public void unregister(Object tag) {
        List<Subject> subjects = subjectMapper.get(tag);
        if (subjects != null) {
            subjectMapper.remove(tag);
        }
    }

    public RxEventBus unregister(Object tag, Observable<?> observable) {
        if (observable == null) {
            return getInstance();
        }

        List<Subject> subjects = subjectMapper.get(tag);
        if (subjects != null) {
            subjects.remove((Subject<?>) observable);
            if (isEmpty(subjects)) {
                subjectMapper.remove(tag);
                Log.d("unregister", tag + " size:" + subjects.size());
            }
        }
        return getInstance();
    }

    public void post(Object content) {
        post(content.getClass().getName(), content);
    }

    /**
     * 触发事件
     *
     * @param tag
     * @param content
     */
    public void post(Object tag, Object content) {
        Log.d("post", "eventName:" + tag);
        List<Subject> subjectList = subjectMapper.get(tag);
        if (!isEmpty(subjectList)) {
            for (Subject subject : subjectList) {
                subject.onNext(content);
                Log.d("onEvent", "eventName:" + tag);
            }
        }
    }

    public static boolean isEmpty(Collection<Subject> collection) {
        return collection == null || collection.isEmpty();
    }

}
