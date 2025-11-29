package ru.yoomoney.sdk.kassa.payments.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.yoopinning.PinningHelper;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.y, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2290y implements Factory {
    public final C2288w a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;

    public C2290y(C2288w c2288w, dagger.internal.Provider provider, dagger.internal.Provider provider2, Factory factory, dagger.internal.Provider provider3) {
        this.a = c2288w;
        this.b = provider;
        this.c = provider2;
        this.d = factory;
        this.e = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C2288w c2288w = this.a;
        Context context = (Context) this.b.get();
        TestParameters testParameters = (TestParameters) this.c.get();
        String shopToken = (String) this.d.get();
        ru.yoomoney.sdk.kassa.payments.secure.j tokensStorage = (ru.yoomoney.sdk.kassa.payments.secure.j) this.e.get();
        c2288w.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        Intrinsics.checkNotNullParameter(shopToken, "clientApplicationKey");
        Intrinsics.checkNotNullParameter(tokensStorage, "tokensStorage");
        boolean showLogs = testParameters.getShowLogs();
        String strPrepareCertsHostFromBaseUrl = PinningHelper.INSTANCE.prepareCertsHostFromBaseUrl(testParameters.getHostParameters().getHost());
        boolean isDevHost = testParameters.getHostParameters().getIsDevHost();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(shopToken, "shopToken");
        Intrinsics.checkNotNullParameter(tokensStorage, "tokensStorage");
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(ru.yoomoney.sdk.kassa.payments.http.k.a(context, showLogs, strPrepareCertsHostFromBaseUrl, isDevHost).addInterceptor(new ru.yoomoney.sdk.kassa.payments.http.d(shopToken)).addInterceptor(new ru.yoomoney.sdk.kassa.payments.http.f(tokensStorage)).build());
    }
}
