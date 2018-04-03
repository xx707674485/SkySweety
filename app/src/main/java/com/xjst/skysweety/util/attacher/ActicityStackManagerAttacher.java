package com.xjst.skysweety.util.attacher;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ActicityStackManagerAttacher extends Attacher<Application> {
    private List<Activity> activities = new ArrayList<>();

    private ActivityStackCallback callback = new ActivityStackCallback();

    protected ActicityStackManagerAttacher(Application target) {
        super(target);
        init();
    }


    private void init() {
        if (target==null)return;
        target.registerActivityLifecycleCallbacks(callback);
    }

    public int getSize() {
        return activities.size();
    }

    public void finishTopActivity() {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        activity.finish();
    }

    public Activity findByClass(Class<? extends Activity> clazz) {
        for (Activity activity : activities) {
            if (activity == null) continue;
            if (activity.getClass().equals(clazz)) {
                return activity;
            }
        }
        return null;
    }

    public Activity getCurrentActivity() {
        return activities.get(getSize() - 1);
    }

    public static ActicityStackManagerAttacher attach(Application application) {
        return Attacher.attach(ActicityStackManagerAttacher.class, application);
    }

    private class ActivityStackCallback implements Application.ActivityLifecycleCallbacks {

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            activities.add(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            activities.remove(activity);
        }
    }

}
