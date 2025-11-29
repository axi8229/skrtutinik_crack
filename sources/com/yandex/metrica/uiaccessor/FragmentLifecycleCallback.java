package com.yandex.metrica.uiaccessor;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.yandex.metrica.uiaccessor.a;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class FragmentLifecycleCallback extends FragmentManager.FragmentLifecycleCallbacks {
    private final a.InterfaceC0296a a;
    private final WeakReference<Activity> b;

    public FragmentLifecycleCallback(a.InterfaceC0296a interfaceC0296a, Activity activity) {
        this.a = interfaceC0296a;
        this.b = new WeakReference<>(activity);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        super.onFragmentAttached(fragmentManager, fragment, context);
        Activity activity = this.b.get();
        if (activity != null) {
            this.a.fragmentAttached(activity);
        }
    }
}
