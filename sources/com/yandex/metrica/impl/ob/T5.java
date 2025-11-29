package com.yandex.metrica.impl.ob;

import com.yandex.metrica.coreutils.services.SystemTimeProvider;

/* loaded from: classes3.dex */
public class T5 extends R5 {
    T5(L3 l3, C0792a6 c0792a6) {
        this(l3, c0792a6, new C0892e6(l3.f(), "foreground"), C1152oh.a(), new SystemTimeProvider());
    }

    T5(L3 l3, C0792a6 c0792a6, C0892e6 c0892e6, M0 m0, SystemTimeProvider systemTimeProvider) {
        super(l3, c0792a6, c0892e6, Z5.a(EnumC0917f6.FOREGROUND).a(), m0, systemTimeProvider);
    }
}
