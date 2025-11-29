package ru.yoomoney.sdk.kassa.payments.di.module;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.MockConfiguration;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2276j implements Factory {
    public final C2275i a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public C2276j(C2275i c2275i, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3) {
        this.a = c2275i;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C2275i c2275i = this.a;
        ru.yoomoney.sdk.kassa.payments.secure.j tokensStorage = (ru.yoomoney.sdk.kassa.payments.secure.j) this.b.get();
        SharedPreferences sharedPreferences = (SharedPreferences) this.c.get();
        TestParameters testParameters = (TestParameters) this.d.get();
        c2275i.getClass();
        Intrinsics.checkNotNullParameter(tokensStorage, "tokensStorage");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        MockConfiguration mockConfiguration = testParameters.getMockConfiguration();
        return (ru.yoomoney.sdk.kassa.payments.payment.b) Preconditions.checkNotNullFromProvides((mockConfiguration == null || !mockConfiguration.getPaymentAuthPassed()) ? new ru.yoomoney.sdk.kassa.payments.payment.f(tokensStorage, sharedPreferences) : new C2274h());
    }
}
