package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import com.yandex.metrica.core.api.executors.ICommonExecutor;

/* renamed from: com.yandex.metrica.impl.ob.wg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1343wg {
    private final InterfaceC1051kg a;

    /* renamed from: com.yandex.metrica.impl.ob.wg$a */
    class a implements InterfaceC1051kg {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1051kg
        public void a(InterfaceC1319vg interfaceC1319vg) throws Throwable {
            throw new IllegalStateException("No class: com.android.installreferrer.api.InstallReferrerClient");
        }
    }

    public C1343wg(Context context, ICommonExecutor iCommonExecutor) {
        this(a(context, iCommonExecutor));
    }

    public void a(InterfaceC1319vg interfaceC1319vg) {
        try {
            this.a.a(interfaceC1319vg);
        } catch (Throwable th) {
            interfaceC1319vg.a(th);
        }
    }

    C1343wg(InterfaceC1051kg interfaceC1051kg) {
        this.a = interfaceC1051kg;
    }

    private static InterfaceC1051kg a(Context context, ICommonExecutor iCommonExecutor) {
        C1200qg c1200qg;
        if (C0963h2.a("com.android.installreferrer.api.InstallReferrerClient")) {
            try {
                c1200qg = new C1200qg(InstallReferrerClient.newBuilder(context).build(), iCommonExecutor);
            } catch (Throwable unused) {
            }
        } else {
            c1200qg = null;
        }
        return c1200qg == null ? new a() : c1200qg;
    }
}
