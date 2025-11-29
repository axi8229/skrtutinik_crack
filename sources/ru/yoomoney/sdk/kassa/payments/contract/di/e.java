package ru.yoomoney.sdk.kassa.payments.contract.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.r1;
import ru.yoomoney.sdk.kassa.payments.secure.i;
import ru.yoomoney.sdk.kassa.payments.secure.j;

/* loaded from: classes5.dex */
public final class e implements Factory {
    public final c a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;
    public final Provider h;
    public final Provider i;
    public final Provider j;
    public final Provider k;
    public final Provider l;
    public final Provider m;

    public e(c cVar, Factory factory, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3, dagger.internal.Provider provider4, dagger.internal.Provider provider5, dagger.internal.Provider provider6, dagger.internal.Provider provider7, dagger.internal.Provider provider8, dagger.internal.Provider provider9, dagger.internal.Provider provider10, dagger.internal.Provider provider11) {
        this.a = cVar;
        this.b = factory;
        this.c = provider;
        this.d = provider2;
        this.e = provider3;
        this.f = provider4;
        this.g = provider5;
        this.h = provider6;
        this.i = provider7;
        this.j = provider8;
        this.k = provider9;
        this.l = provider10;
        this.m = provider11;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        c cVar = this.a;
        Context context = (Context) this.b.get();
        ru.yoomoney.sdk.kassa.payments.http.a hostProvider = (ru.yoomoney.sdk.kassa.payments.http.a) this.c.get();
        ru.yoomoney.sdk.kassa.payments.payment.b currentUserRepository = (ru.yoomoney.sdk.kassa.payments.payment.b) this.d.get();
        j userAuthInfoRepository = (j) this.e.get();
        r1 paymentAuthTokenRepository = (r1) this.f.get();
        ru.yoomoney.sdk.kassa.payments.tmx.a profilingSessionIdStorage = (ru.yoomoney.sdk.kassa.payments.tmx.a) this.g.get();
        PaymentParameters paymentParameters = (PaymentParameters) this.h.get();
        i ivStorage = (i) this.i.get();
        ru.yoomoney.sdk.kassa.payments.secure.g encrypt = (ru.yoomoney.sdk.kassa.payments.secure.g) this.j.get();
        ru.yoomoney.sdk.kassa.payments.secure.a keyStorage = (ru.yoomoney.sdk.kassa.payments.secure.a) this.k.get();
        ru.yoomoney.sdk.kassa.payments.secure.f decrypt = (ru.yoomoney.sdk.kassa.payments.secure.f) this.l.get();
        ru.yoomoney.sdk.kassa.payments.payment.c loadedPaymentOptionListRepository = (ru.yoomoney.sdk.kassa.payments.payment.c) this.m.get();
        cVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hostProvider, "hostProvider");
        Intrinsics.checkNotNullParameter(currentUserRepository, "currentUserRepository");
        Intrinsics.checkNotNullParameter(userAuthInfoRepository, "userAuthInfoRepository");
        Intrinsics.checkNotNullParameter(paymentAuthTokenRepository, "paymentAuthTokenRepository");
        Intrinsics.checkNotNullParameter(profilingSessionIdStorage, "profilingSessionIdStorage");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        Intrinsics.checkNotNullParameter(ivStorage, "ivStorage");
        Intrinsics.checkNotNullParameter(encrypt, "encrypt");
        Intrinsics.checkNotNullParameter(keyStorage, "keyStorage");
        Intrinsics.checkNotNullParameter(decrypt, "decrypt");
        Intrinsics.checkNotNullParameter(loadedPaymentOptionListRepository, "loadedPaymentOptionListRepository");
        return (ru.yoomoney.sdk.kassa.payments.logout.a) Preconditions.checkNotNullFromProvides(new ru.yoomoney.sdk.kassa.payments.logout.b(currentUserRepository, userAuthInfoRepository, paymentAuthTokenRepository, loadedPaymentOptionListRepository, profilingSessionIdStorage, new a(ivStorage, keyStorage, encrypt, decrypt), new b(context, paymentParameters, hostProvider)));
    }
}
