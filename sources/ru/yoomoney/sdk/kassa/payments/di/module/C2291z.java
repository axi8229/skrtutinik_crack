package ru.yoomoney.sdk.kassa.payments.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.yoopinning.PinningHelper;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.z, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2291z implements Factory {
    public final C2288w a;
    public final Provider b;
    public final Provider c;

    public C2291z(C2288w c2288w, dagger.internal.Provider provider, dagger.internal.Provider provider2) {
        this.a = c2288w;
        this.b = provider;
        this.c = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C2288w c2288w = this.a;
        Context context = (Context) this.b.get();
        TestParameters testParameters = (TestParameters) this.c.get();
        c2288w.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        boolean showLogs = testParameters.getShowLogs();
        String strPrepareCertsHostFromBaseUrl = PinningHelper.INSTANCE.prepareCertsHostFromBaseUrl(testParameters.getHostParameters().getHost());
        boolean isDevHost = testParameters.getHostParameters().getIsDevHost();
        Intrinsics.checkNotNullParameter(context, "context");
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(ru.yoomoney.sdk.kassa.payments.http.k.a(context, showLogs, strPrepareCertsHostFromBaseUrl, isDevHost).build());
    }
}
