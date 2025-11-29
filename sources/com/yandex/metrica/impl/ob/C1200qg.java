package com.yandex.metrica.impl.ob;

import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.impl.ob.C0877dg;

/* renamed from: com.yandex.metrica.impl.ob.qg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1200qg implements InterfaceC1051kg {
    private final InstallReferrerClient a;
    private final ICommonExecutor b;

    /* renamed from: com.yandex.metrica.impl.ob.qg$a */
    class a implements InstallReferrerStateListener {
        final /* synthetic */ InterfaceC1319vg a;

        /* renamed from: com.yandex.metrica.impl.ob.qg$a$a, reason: collision with other inner class name */
        class RunnableC0294a implements Runnable {
            final /* synthetic */ C0877dg a;

            RunnableC0294a(C0877dg c0877dg) {
                this.a = c0877dg;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.a(this.a);
            }
        }

        a(InterfaceC1319vg interfaceC1319vg) {
            this.a = interfaceC1319vg;
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerServiceDisconnected() {
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerSetupFinished(int i) {
            if (i == 0) {
                try {
                    ReferrerDetails installReferrer = C1200qg.this.a.getInstallReferrer();
                    C1200qg.this.b.execute(new RunnableC0294a(new C0877dg(installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds(), installReferrer.getInstallBeginTimestampSeconds(), C0877dg.a.GP)));
                } catch (Throwable th) {
                    C1200qg.a(C1200qg.this, this.a, th);
                }
            } else {
                C1200qg.a(C1200qg.this, this.a, new IllegalStateException("Referrer check failed with error " + i));
            }
            try {
                C1200qg.this.a.endConnection();
            } catch (Throwable unused) {
            }
        }
    }

    C1200qg(InstallReferrerClient installReferrerClient, ICommonExecutor iCommonExecutor) {
        this.a = installReferrerClient;
        this.b = iCommonExecutor;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1051kg
    public void a(InterfaceC1319vg interfaceC1319vg) throws Throwable {
        this.a.startConnection(new a(interfaceC1319vg));
    }

    static void a(C1200qg c1200qg, InterfaceC1319vg interfaceC1319vg, Throwable th) {
        c1200qg.b.execute(new RunnableC1223rg(c1200qg, interfaceC1319vg, th));
    }
}
