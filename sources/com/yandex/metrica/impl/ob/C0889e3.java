package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ob.C1326w;
import java.util.concurrent.Executor;

/* renamed from: com.yandex.metrica.impl.ob.e3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0889e3 {
    private InterfaceC1034k a;
    private final Context b;
    private final Executor c;
    private final Executor d;
    private final com.yandex.metrica.billing_interface.b e;
    private final InterfaceC1109n f;
    private final InterfaceC1084m g;
    private final C1326w h;
    private final C0864d3 i;

    /* renamed from: com.yandex.metrica.impl.ob.e3$a */
    class a implements C1326w.b {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.C1326w.b
        public void a(C1326w.a aVar) {
            C0889e3.a(C0889e3.this, aVar);
        }
    }

    public C0889e3(Context context, Executor executor, Executor executor2, com.yandex.metrica.billing_interface.b bVar, InterfaceC1109n interfaceC1109n, InterfaceC1084m interfaceC1084m, C1326w c1326w, C0864d3 c0864d3) {
        this.b = context;
        this.c = executor;
        this.d = executor2;
        this.e = bVar;
        this.f = interfaceC1109n;
        this.g = interfaceC1084m;
        this.h = c1326w;
        this.i = c0864d3;
    }

    static void a(C0889e3 c0889e3, C1326w.a aVar) {
        c0889e3.getClass();
        if (aVar == C1326w.a.VISIBLE) {
            try {
                InterfaceC1034k interfaceC1034k = c0889e3.a;
                if (interfaceC1034k != null) {
                    interfaceC1034k.b();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(C1178pi c1178pi, Boolean bool) {
        InterfaceC1034k interfaceC1034kA;
        Boolean bool2 = Boolean.TRUE;
        if (bool == null) {
            bool = bool2;
        }
        if (bool.booleanValue()) {
            synchronized (this) {
                interfaceC1034kA = this.i.a(this.b, this.c, this.d, this.e, this.f, this.g);
                this.a = interfaceC1034kA;
            }
            interfaceC1034kA.a(c1178pi.c());
            if (this.h.a(new a()) == C1326w.a.VISIBLE) {
                try {
                    InterfaceC1034k interfaceC1034k = this.a;
                    if (interfaceC1034k != null) {
                        interfaceC1034k.b();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public synchronized void a(C1178pi c1178pi) {
        InterfaceC1034k interfaceC1034k;
        synchronized (this) {
            interfaceC1034k = this.a;
        }
        if (interfaceC1034k != null) {
            interfaceC1034k.a(c1178pi.c());
        }
    }
}
