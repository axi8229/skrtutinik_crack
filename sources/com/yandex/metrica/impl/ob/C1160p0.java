package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1403z4;
import com.yandex.metrica.networktasks.api.NetworkServiceLocator;

/* renamed from: com.yandex.metrica.impl.ob.p0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1160p0<C extends C1403z4> extends C1329w2<C> {
    private final E4 e;
    private final C0819b8 f;

    public C1160p0(C c, InterfaceC1393yi interfaceC1393yi, E4 e4, C0819b8 c0819b8) {
        super(c, interfaceC1393yi);
        this.e = e4;
        this.f = c0819b8;
    }

    public void a(C0836c0 c0836c0) {
        if (this.c) {
            return;
        }
        synchronized (this.b) {
            try {
                if (!this.c) {
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        NetworkServiceLocator.getInstance().getNetworkCore().startTask(C1220rd.a(e().b(), e(), c0836c0, this.e, this.f));
    }
}
