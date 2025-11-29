package com.segment.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
class AnalyticsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {
    private static LifecycleOwner stubOwner = new LifecycleOwner() { // from class: com.segment.analytics.AnalyticsActivityLifecycleCallbacks.1
        Lifecycle stubLifecycle = new Lifecycle() { // from class: com.segment.analytics.AnalyticsActivityLifecycleCallbacks.1.1
            @Override // androidx.lifecycle.Lifecycle
            public void addObserver(LifecycleObserver lifecycleObserver) {
            }

            @Override // androidx.lifecycle.Lifecycle
            public void removeObserver(LifecycleObserver lifecycleObserver) {
            }

            @Override // androidx.lifecycle.Lifecycle
            /* renamed from: getCurrentState */
            public Lifecycle.State getState() {
                return Lifecycle.State.DESTROYED;
            }
        };

        @Override // androidx.lifecycle.LifecycleOwner
        public Lifecycle getLifecycle() {
            return this.stubLifecycle;
        }
    };
    private ExecutorService analyticsExecutor;
    private AtomicBoolean firstLaunch;
    private AtomicBoolean isChangingActivityConfigurations;
    private AtomicInteger numberOfActivities;
    private PackageInfo packageInfo;
    private Boolean shouldRecordScreenViews;
    private Boolean shouldTrackApplicationLifecycleEvents;
    private Boolean trackDeepLinks;
    private AtomicBoolean trackedApplicationLifecycleEvents;
    private Boolean useNewLifecycleMethods;

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner lifecycleOwner) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner lifecycleOwner) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner lifecycleOwner) {
    }

    private AnalyticsActivityLifecycleCallbacks(Analytics analytics, ExecutorService executorService, Boolean bool, Boolean bool2, Boolean bool3, PackageInfo packageInfo, Boolean bool4) {
        this.trackedApplicationLifecycleEvents = new AtomicBoolean(false);
        this.numberOfActivities = new AtomicInteger(1);
        this.firstLaunch = new AtomicBoolean(false);
        this.analyticsExecutor = executorService;
        this.shouldTrackApplicationLifecycleEvents = bool;
        this.trackDeepLinks = bool2;
        this.shouldRecordScreenViews = bool3;
        this.packageInfo = packageInfo;
        this.useNewLifecycleMethods = bool4;
        this.isChangingActivityConfigurations = new AtomicBoolean(false);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner lifecycleOwner) {
        if (this.shouldTrackApplicationLifecycleEvents.booleanValue() && this.numberOfActivities.decrementAndGet() == 0 && !this.isChangingActivityConfigurations.get()) {
            throw null;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner lifecycleOwner) {
        if (this.shouldTrackApplicationLifecycleEvents.booleanValue() && this.numberOfActivities.incrementAndGet() == 1 && !this.isChangingActivityConfigurations.get()) {
            Properties properties = new Properties();
            if (this.firstLaunch.get()) {
                properties.putValue("version", (Object) this.packageInfo.versionName).putValue(JsonPOJOBuilder.DEFAULT_BUILD_METHOD, (Object) String.valueOf(this.packageInfo.versionCode));
            }
            properties.putValue("from_background", (Object) Boolean.valueOf(true ^ this.firstLaunch.getAndSet(false)));
            throw null;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onCreate(LifecycleOwner lifecycleOwner) {
        if (this.trackedApplicationLifecycleEvents.getAndSet(true) || !this.shouldTrackApplicationLifecycleEvents.booleanValue()) {
            return;
        }
        this.numberOfActivities.set(0);
        this.firstLaunch.set(true);
        throw null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        IntegrationOperation.onActivityCreated(activity, bundle);
        throw null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.shouldRecordScreenViews.booleanValue()) {
            throw null;
        }
        IntegrationOperation.onActivityStarted(activity);
        throw null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        IntegrationOperation.onActivityResumed(activity);
        throw null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        IntegrationOperation.onActivityPaused(activity);
        throw null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        IntegrationOperation.onActivityStopped(activity);
        throw null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        IntegrationOperation.onActivitySaveInstanceState(activity, bundle);
        throw null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        IntegrationOperation.onActivityDestroyed(activity);
        throw null;
    }
}
