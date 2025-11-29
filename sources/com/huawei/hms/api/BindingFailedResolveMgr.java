package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
class BindingFailedResolveMgr {
    static final BindingFailedResolveMgr b = new BindingFailedResolveMgr();
    private static final Object c = new Object();
    List<Activity> a = new ArrayList(1);

    BindingFailedResolveMgr() {
    }

    void a(Activity activity) {
        synchronized (c) {
            try {
                for (Activity activity2 : this.a) {
                    if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                        activity2.finish();
                    }
                }
                this.a.add(activity);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void b(Activity activity) {
        synchronized (c) {
            this.a.remove(activity);
        }
    }
}
