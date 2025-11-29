package com.yandex.metrica.impl.ob;

import android.os.Handler;
import com.yandex.metrica.DeferredDeeplinkListener;
import com.yandex.metrica.DeferredDeeplinkParametersListener;

/* renamed from: com.yandex.metrica.impl.ob.bg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0827bg implements InterfaceC0852cg {
    private final boolean a;
    private final T1 b;
    private final C0820b9 c;
    private final C1135o0 d;
    private final K1 e;
    private final Handler f;

    public C0827bg(T1 t1, C0820b9 c0820b9, Handler handler) {
        this(t1, c0820b9, handler, c0820b9.w());
    }

    public void a() {
        if (this.a) {
            return;
        }
        this.b.a(new ResultReceiverC0902eg(this.f, this));
    }

    private C0827bg(T1 t1, C0820b9 c0820b9, Handler handler, boolean z) {
        this(t1, c0820b9, handler, z, new C1135o0(z), new K1());
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0852cg
    public void a(C0877dg c0877dg) {
        String str = c0877dg == null ? null : c0877dg.a;
        if (this.a) {
            return;
        }
        synchronized (this) {
            this.d.a(this.e.a(str));
        }
    }

    C0827bg(T1 t1, C0820b9 c0820b9, Handler handler, boolean z, C1135o0 c1135o0, K1 k1) {
        this.b = t1;
        this.c = c0820b9;
        this.a = z;
        this.d = c1135o0;
        this.e = k1;
        this.f = handler;
    }

    public synchronized void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        try {
            this.d.a(deferredDeeplinkParametersListener);
        } finally {
            this.c.y();
        }
    }

    public synchronized void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        try {
            this.d.a(deferredDeeplinkListener);
        } finally {
            this.c.y();
        }
    }
}
