package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import com.yandex.metrica.CounterConfiguration;

/* loaded from: classes3.dex */
public class Q1 extends C1402z3 {
    protected C1351x0 c;
    protected C1000ie d;
    private boolean e;
    private final String f;

    protected Q1(A3 a3, CounterConfiguration counterConfiguration) {
        this(a3, counterConfiguration, null);
    }

    void a(C0834bn c0834bn) {
        this.c = new C1351x0(c0834bn);
    }

    Bundle c() {
        Bundle bundle = new Bundle();
        CounterConfiguration counterConfigurationB = b();
        synchronized (counterConfigurationB) {
            bundle.putParcelable("COUNTER_CFG_OBJ", counterConfigurationB);
        }
        A3 a3A = a();
        synchronized (a3A) {
            bundle.putParcelable("PROCESS_CFG_OBJ", a3A);
        }
        return bundle;
    }

    public String d() {
        return this.c.a();
    }

    public String e() {
        return this.f;
    }

    boolean f() {
        return this.e;
    }

    void g() {
        this.e = true;
    }

    void h() {
        this.e = false;
    }

    protected Q1(A3 a3, CounterConfiguration counterConfiguration, String str) {
        super(a3, counterConfiguration);
        this.e = true;
        this.f = str;
    }

    void a(InterfaceC1028ji interfaceC1028ji) {
        if (interfaceC1028ji != null) {
            b().d(((C0979hi) interfaceC1028ji).e());
        }
    }

    void a(C1000ie c1000ie) {
        this.d = c1000ie;
    }
}
