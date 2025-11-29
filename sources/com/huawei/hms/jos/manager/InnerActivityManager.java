package com.huawei.hms.jos.manager;

import android.app.Activity;
import com.huawei.hms.support.common.ActivityMgr;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class InnerActivityManager {
    private static InnerActivityManager b;
    private WeakReference<Activity> a;

    public static synchronized InnerActivityManager get() {
        try {
            if (b == null) {
                b = new InnerActivityManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    public Activity getCurrentActivity() {
        Activity activity;
        WeakReference<Activity> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null || (activity = this.a.get()) == null || activity.isFinishing() || activity.isDestroyed()) ? ActivityMgr.INST.getCurrentActivity() : activity;
    }

    public void setCurrentActivity(Activity activity) {
        this.a = new WeakReference<>(activity);
    }
}
