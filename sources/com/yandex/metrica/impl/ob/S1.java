package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.impl.ob.L3;
import com.yandex.metrica.networktasks.api.NetworkServiceLocator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class S1<C extends L3> extends C1329w2<C> {
    private Runnable e;
    private final ICommonExecutor f;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            S1.this.d();
        }
    }

    public S1(C c, InterfaceC1393yi interfaceC1393yi, ICommonExecutor iCommonExecutor) {
        super(c, interfaceC1393yi);
        this.e = new a();
        this.f = iCommonExecutor;
    }

    @Override // com.yandex.metrica.impl.ob.C1329w2
    void c() {
        this.f.remove(this.e);
    }

    @Override // com.yandex.metrica.impl.ob.C1329w2
    void f() {
        super.f();
        Lg lgM = e().m();
        if (lgM.F()) {
            String strB = lgM.B();
            if (TextUtils.isEmpty(strB) || "-1".equals(strB)) {
                return;
            }
            try {
                NetworkServiceLocator.getInstance().getNetworkCore().startTask(C1220rd.a(e()));
            } catch (Throwable unused) {
            }
        }
    }

    public void g() {
        synchronized (this.b) {
            try {
                if (!this.c) {
                    c();
                    if (e().m().G() > 0) {
                        this.f.executeDelayed(this.e, TimeUnit.SECONDS.toMillis(e().m().G()));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
