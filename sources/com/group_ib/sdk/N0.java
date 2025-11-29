package com.group_ib.sdk;

import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class N0 extends FragmentManager.FragmentLifecycleCallbacks {
    public static final /* synthetic */ boolean b = true;
    public final C0588b0 a;

    public N0(C0588b0 c0588b0) {
        if (!b && c0588b0 == null) {
            throw new AssertionError();
        }
        this.a = c0588b0;
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentResumed(fragmentManager, fragment);
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            c1.a(4, 4, "FragmentLifecycleHandler", "Fragment resumed: ".concat(fragment.getClass().getSimpleName()));
            try {
                V v = this.a.c;
                if (v != null) {
                    ((HandlerC0598g0) v).a(new L(new U(activity, fragment), new JSONObject().put("t", System.currentTimeMillis())));
                }
            } catch (Exception e) {
                c1.b("FragmentLifecycleHandler", "Failed to add fragment navigation event", e);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentStarted(fragmentManager, fragment);
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            C0588b0 c0588b0 = this.a;
            c0588b0.getClass();
            if (activity.getWindow().getCallback() instanceof WindowCallbackC0627w) {
                return;
            }
            HashMap map = c0588b0.a;
            V v = c0588b0.c;
            Window window = activity.getWindow();
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof WindowCallbackC0627w)) {
                WindowCallbackC0627w windowCallbackC0627w = new WindowCallbackC0627w(v, activity, callback);
                window.setCallback(windowCallbackC0627w);
                callback = windowCallbackC0627w;
            }
            map.put(activity, (WindowCallbackC0627w) callback);
        }
    }
}
