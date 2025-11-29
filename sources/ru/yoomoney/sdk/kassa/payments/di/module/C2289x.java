package ru.yoomoney.sdk.kassa.payments.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.yoopinning.PinningHelper;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.x, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2289x implements Factory {
    public final C2288w a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;

    public C2289x(C2288w c2288w, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3, dagger.internal.Provider provider4) {
        this.a = c2288w;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    @Override // javax.inject.Provider
    public final Object get() throws NoSuchAlgorithmException, KeyManagementException {
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
        OkHttpClient.Builder builderA = ru.yoomoney.sdk.kassa.payments.http.k.a(context, showLogs, strPrepareCertsHostFromBaseUrl, isDevHost);
        Intrinsics.checkNotNullParameter(builderA, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(builderA.addInterceptor(new ru.yoomoney.sdk.kassa.payments.http.m(ru.yoomoney.sdk.kassa.payments.http.l.a(context))).addInterceptor(new ru.yoomoney.sdk.kassa.payments.http.h()).addInterceptor(new ru.yoomoney.sdk.kassa.payments.http.i()).addInterceptor(new ru.yoomoney.sdk.kassa.payments.http.e(shopToken)).addInterceptor(new ru.yoomoney.sdk.kassa.payments.http.g(tokensStorage)).build());
    }
}
