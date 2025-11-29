package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.coreutils.services.ActivationBarrier;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.coreutils.services.TimeProvider;
import com.yandex.metrica.coreutils.services.UtilityServiceLocator;
import com.yandex.metrica.networktasks.api.CacheControlHttpsConnectionPerformer;
import com.yandex.metrica.networktasks.api.IExecutionPolicy;
import java.io.File;

/* renamed from: com.yandex.metrica.impl.ob.uh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1296uh {
    private final Context a;
    private final B0 b;
    private final ICommonExecutor c;
    private final CacheControlHttpsConnectionPerformer d;
    private final InterfaceC1177ph e;
    private final TimeProvider f;
    private final IExecutionPolicy g;
    private final ActivationBarrier h;
    private boolean i;

    public C1296uh(Context context) {
        B0 b0 = new B0();
        F0.g().t().getClass();
        this(context, b0, new CacheControlHttpsConnectionPerformer(null), new SystemTimeProvider(), new C1148od(context), F0.g().q().g(), F0.g().s(), UtilityServiceLocator.getInstance().getActivationBarrier());
    }

    static void c(C1296uh c1296uh) {
        synchronized (c1296uh) {
            c1296uh.i = false;
        }
    }

    public synchronized void a(C1178pi c1178pi, Eh eh) {
        try {
            C0879di c0879diM = c1178pi.M();
            if (c0879diM == null) {
                return;
            }
            File fileA = this.b.a(this.a, "certificate.p12");
            boolean z = fileA != null && fileA.exists();
            if (z) {
                eh.a(fileA);
            }
            long jCurrentTimeSeconds = this.f.currentTimeSeconds();
            long jA = this.e.a();
            if ((!z || jCurrentTimeSeconds >= jA) && !this.i) {
                String strE = c1178pi.e();
                if (!TextUtils.isEmpty(strE) && this.g.canBeExecuted()) {
                    this.i = true;
                    this.h.subscribe(ActivationBarrier.ACTIVATION_DELAY, this.c, new C1248sh(this, strE, fileA, eh, c0879diM));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    C1296uh(Context context, B0 b0, CacheControlHttpsConnectionPerformer cacheControlHttpsConnectionPerformer, TimeProvider timeProvider, IExecutionPolicy iExecutionPolicy, ICommonExecutor iCommonExecutor, InterfaceC1177ph interfaceC1177ph, ActivationBarrier activationBarrier) {
        this.i = false;
        this.a = context;
        this.b = b0;
        this.d = cacheControlHttpsConnectionPerformer;
        this.f = timeProvider;
        this.g = iExecutionPolicy;
        this.c = iCommonExecutor;
        this.e = interfaceC1177ph;
        this.h = activationBarrier;
    }

    static void a(C1296uh c1296uh, long j) {
        c1296uh.e.a(c1296uh.f.currentTimeSeconds() + j);
    }
}
