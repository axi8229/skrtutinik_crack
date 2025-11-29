package ru.yoomoney.sdk.kassa.payments.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.metrics.C2310t;
import ru.yoomoney.sdk.kassa.payments.metrics.InterfaceC2309s;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.l, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2278l implements Factory {
    public final C2277k a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public C2278l(C2277k c2277k, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3) {
        this.a = c2277k;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C2277k c2277k = this.a;
        ru.yoomoney.sdk.kassa.payments.metrics.F reporter = (ru.yoomoney.sdk.kassa.payments.metrics.F) this.b.get();
        ru.yoomoney.sdk.kassa.payments.metrics.e0 userAuthTypeParamProvider = (ru.yoomoney.sdk.kassa.payments.metrics.e0) this.c.get();
        ru.yoomoney.sdk.kassa.payments.metrics.V tokenizeSchemeParamProvider = (ru.yoomoney.sdk.kassa.payments.metrics.V) this.d.get();
        c2277k.getClass();
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(userAuthTypeParamProvider, "userAuthTypeParamProvider");
        Intrinsics.checkNotNullParameter(tokenizeSchemeParamProvider, "tokenizeSchemeParamProvider");
        return (InterfaceC2309s) Preconditions.checkNotNullFromProvides(new C2310t(userAuthTypeParamProvider, tokenizeSchemeParamProvider, reporter));
    }
}
