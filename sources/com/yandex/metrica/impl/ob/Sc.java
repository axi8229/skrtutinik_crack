package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.coreutils.services.ActivationBarrier;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.coreutils.services.TimeProvider;
import com.yandex.metrica.coreutils.services.UtilityServiceLocator;
import com.yandex.metrica.networktasks.api.NetworkServiceLocator;

/* loaded from: classes3.dex */
class Sc implements Fc {
    private final Context a;
    private C1178pi b;
    private volatile C1097mc c;
    private final U7 d;
    private final T7 e;
    private final TimeProvider f;
    private final C0924fd g;
    private final ActivationBarrier h;
    private final ActivationBarrier.IActivationBarrierCallback i;
    private final ICommonExecutor j;
    private boolean k;

    class a implements ActivationBarrier.IActivationBarrierCallback {
        a() {
        }

        @Override // com.yandex.metrica.coreutils.services.ActivationBarrier.IActivationBarrierCallback
        public void onWaitFinished() {
            Sc.this.k = true;
            Sc.a(Sc.this);
        }
    }

    public Sc(Context context, C1178pi c1178pi, C1097mc c1097mc, U7 u7, T7 t7, ICommonExecutor iCommonExecutor) {
        this(context, c1178pi, c1097mc, u7, t7, iCommonExecutor, new SystemTimeProvider(), new C0924fd(), UtilityServiceLocator.getInstance().getActivationBarrier());
    }

    static void a(Sc sc) {
        C1097mc c1097mc = sc.c;
        if (c1097mc != null) {
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(sc.g.a(sc.a, sc.b, c1097mc, sc));
        }
    }

    Sc(Context context, C1178pi c1178pi, C1097mc c1097mc, U7 u7, T7 t7, ICommonExecutor iCommonExecutor, TimeProvider timeProvider, C0924fd c0924fd, ActivationBarrier activationBarrier) {
        this.k = false;
        this.a = context;
        this.c = c1097mc;
        this.b = c1178pi;
        this.d = u7;
        this.e = t7;
        this.j = iCommonExecutor;
        this.f = timeProvider;
        this.g = c0924fd;
        this.h = activationBarrier;
        this.i = new a();
    }

    @Override // com.yandex.metrica.impl.ob.Fc
    public void a() {
        boolean zA = a(this.d);
        boolean zA2 = a(this.e);
        if (zA || zA2) {
            if (!this.k) {
                this.h.subscribe(ActivationBarrier.ACTIVATION_DELAY, this.j, this.i);
                return;
            }
            C1097mc c1097mc = this.c;
            if (c1097mc != null) {
                NetworkServiceLocator.getInstance().getNetworkCore().startTask(this.g.a(this.a, this.b, c1097mc, this));
            }
        }
    }

    private boolean a(J7 j7) {
        if (this.c != null) {
            if (this.c != null) {
                if (j7.c() < r0.c) {
                }
                return true;
            }
            C1097mc c1097mc = this.c;
            if (c1097mc != null) {
                if (this.f.currentTimeMillis() - j7.b() > c1097mc.e) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a(C1178pi c1178pi) {
        this.b = c1178pi;
    }

    public void a(C1097mc c1097mc) {
        this.c = c1097mc;
    }
}
