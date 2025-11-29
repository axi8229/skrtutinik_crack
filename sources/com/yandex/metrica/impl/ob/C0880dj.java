package com.yandex.metrica.impl.ob;

import android.text.TextUtils;

/* renamed from: com.yandex.metrica.impl.ob.dj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0880dj {
    private final InterfaceC0830bj a;
    private final C1253sm b;
    private final C0930fj c;
    private final InterfaceC0855cj d;

    C0880dj(InterfaceC0830bj interfaceC0830bj, InterfaceC0855cj interfaceC0855cj, C1253sm c1253sm, C0930fj c0930fj) {
        this.a = interfaceC0830bj;
        this.d = interfaceC0855cj;
        this.b = c1253sm;
        this.c = c0930fj;
    }

    public W0 a() {
        String strA;
        try {
            this.b.a();
            strA = this.c.a();
            try {
                if (TextUtils.isEmpty(strA)) {
                    strA = this.a.a();
                    if (!TextUtils.isEmpty(strA) || this.d.a()) {
                        strA = this.c.a(strA);
                    }
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strA = null;
        }
        this.b.b();
        return strA == null ? new W0(null, U0.UNKNOWN, "Uuid must be obtained via async API YandexMetricaInternal#requestStartupIdentifiers(@NonNull Context context, @NonNull IIdentifierCallback callback,@NonNull String... identifiers)") : new W0(strA, U0.OK, null);
    }
}
