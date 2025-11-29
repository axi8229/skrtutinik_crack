package com.yandex.metrica.uiaccessor;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

/* loaded from: classes3.dex */
public class a implements b {
    private final InterfaceC0296a a;
    private FragmentManager.FragmentLifecycleCallbacks b;

    /* renamed from: com.yandex.metrica.uiaccessor.a$a, reason: collision with other inner class name */
    public interface InterfaceC0296a {
        void fragmentAttached(Activity activity);
    }

    public a(InterfaceC0296a interfaceC0296a) throws Throwable {
        this.a = interfaceC0296a;
    }

    @Override // com.yandex.metrica.uiaccessor.b
    public void subscribe(Activity activity) throws Throwable {
        if (activity instanceof FragmentActivity) {
            if (this.b == null) {
                this.b = new FragmentLifecycleCallback(this.a, activity);
            }
            FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            supportFragmentManager.unregisterFragmentLifecycleCallbacks(this.b);
            supportFragmentManager.registerFragmentLifecycleCallbacks(this.b, true);
        }
    }

    @Override // com.yandex.metrica.uiaccessor.b
    public void unsubscribe(Activity activity) throws Throwable {
        if (!(activity instanceof FragmentActivity) || this.b == null) {
            return;
        }
        ((FragmentActivity) activity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this.b);
    }
}
