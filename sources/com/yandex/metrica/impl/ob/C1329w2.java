package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.P3;

/* renamed from: com.yandex.metrica.impl.ob.w2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1329w2<C extends P3> implements InterfaceC1062l2 {
    private C a;
    final Object b = new Object();
    boolean c = false;
    private final InterfaceC1393yi d;

    public C1329w2(C c, InterfaceC1393yi interfaceC1393yi) {
        this.a = c;
        this.d = interfaceC1393yi;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1062l2
    public void a() {
        synchronized (this.b) {
            try {
                if (this.c) {
                    this.c = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1062l2
    public void b() {
        synchronized (this.b) {
            try {
                if (!this.c) {
                    c();
                    this.c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void c() {
    }

    public void d() {
        synchronized (this.b) {
            if (!this.c) {
                synchronized (this.b) {
                    try {
                        if (!this.c) {
                            f();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                c();
            }
        }
    }

    public C e() {
        return this.a;
    }

    void f() {
        this.d.a();
    }
}
