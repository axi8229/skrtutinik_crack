package com.group_ib.sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.group_ib.sdk.b0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0588b0 implements Application.ActivityLifecycleCallbacks {
    public final HashMap a = new HashMap();
    public final N0 b = new N0(this);
    public V c = null;
    public int d = 0;
    public boolean e = false;

    public final void a(Activity activity) {
        if (activity == null) {
            return;
        }
        if (this.c == null) {
            this.a.put(activity, null);
            return;
        }
        if (this.a.get(activity) == null) {
            HashMap map = this.a;
            V v = this.c;
            Window window = activity.getWindow();
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof WindowCallbackC0627w)) {
                WindowCallbackC0627w windowCallbackC0627w = new WindowCallbackC0627w(v, activity, callback);
                window.setCallback(windowCallbackC0627w);
                callback = windowCallbackC0627w;
            }
            map.put(activity, (WindowCallbackC0627w) callback);
            N0 n0 = this.b;
            n0.getClass();
            if (activity instanceof FragmentActivity) {
                ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(n0, true);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        if (T.y == 1) {
            U0.b.a(4, (Object) null);
        }
        T.y = 2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        T.y = 7;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        c1.a(4, 4, "ActivityLifecycleHandler", "Application activity paused: " + activity.getLocalClassName());
        T.y = 5;
        if (this.d == 0) {
            a(activity);
            U0.c.a(5, Boolean.TRUE);
            this.e = true;
            this.d = 1;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        c1.a(4, 4, "ActivityLifecycleHandler", "Application activity resumed: " + activity.getLocalClassName());
        T.y = 4;
        V v = this.c;
        if (v != null) {
            try {
                ((HandlerC0598g0) v).a(new L(new C(activity), new JSONObject().put("t", System.currentTimeMillis())));
            } catch (Exception e) {
                c1.a("ActivityLifecycleHandler", "failed to add navigation event", e);
            }
        }
        if (this.d == 0) {
            a(activity);
            U0.c.a(5, Boolean.TRUE);
            this.e = true;
            this.d = 1;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        c1.a(4, 4, "ActivityLifecycleHandler", "Application activity started: " + activity.getLocalClassName());
        T.y = 3;
        a(activity);
        if (!this.e) {
            U0.c.a(5, Boolean.TRUE);
            this.e = true;
        }
        this.d++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        c1.a(4, 4, "ActivityLifecycleHandler", "Application activity stopped: " + activity.getLocalClassName());
        T.y = 6;
        WindowCallbackC0627w windowCallbackC0627w = (WindowCallbackC0627w) this.a.get(activity);
        if (windowCallbackC0627w != null) {
            activity.getWindow().setCallback(windowCallbackC0627w.b);
            N0 n0 = this.b;
            n0.getClass();
            if (activity instanceof FragmentActivity) {
                ((FragmentActivity) activity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(n0);
            }
        }
        if (this.a.containsKey(activity)) {
            this.a.remove(activity);
            this.d--;
        }
        if (this.d <= 0) {
            this.e = false;
            this.d = 0;
            U0.c.a(5, Boolean.FALSE);
        }
    }
}
