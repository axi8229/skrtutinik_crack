package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.concurrent.Executor;

/* renamed from: com.yandex.metrica.impl.ob.d3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0864d3 {
    public final InterfaceC1034k a(Context context, Executor executor, Executor executor2, com.yandex.metrica.billing_interface.b bVar, InterfaceC1109n interfaceC1109n, InterfaceC1084m interfaceC1084m) {
        int iOrdinal = bVar.ordinal();
        return iOrdinal != 0 ? iOrdinal != 1 ? new C0939g3() : new com.yandex.metrica.billing.v4.library.c(context, executor, executor2, interfaceC1109n, interfaceC1084m, new C0910f(interfaceC1109n), new C0960h(null, 1)) : new com.yandex.metrica.billing.v3.library.c(context, executor, executor2, new C0835c(interfaceC1109n), new C0860d(), interfaceC1084m);
    }
}
