package ru.yoomoney.sdk.kassa.payments.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.io.InputStream;
import java.util.Scanner;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import ru.yoomoney.sdk.kassa.payments.R$raw;
import ru.yoomoney.sdk.kassa.payments.api.JacksonBaseObjectMapperKt;
import ru.yoomoney.sdk.kassa.payments.api.YooKassaJacksonConverterFactory;
import ru.yoomoney.sdk.kassa.payments.api.k;
import ru.yoomoney.sdk.kassa.payments.api.l;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.HostParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.metrics.InterfaceC2308q;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2334s;
import ru.yoomoney.sdk.kassa.payments.model.Config;

/* loaded from: classes5.dex */
public final class e implements Factory {
    public final d a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;

    public e(d dVar, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3, dagger.internal.Provider provider4, dagger.internal.Provider provider5) {
        this.a = dVar;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
    }

    @Override // javax.inject.Provider
    public final Object get() throws Resources.NotFoundException, SecurityException {
        Object bVar;
        d dVar = this.a;
        Context context = (Context) this.b.get();
        InterfaceC2308q errorReporter = (InterfaceC2308q) this.c.get();
        TestParameters testParameters = (TestParameters) this.d.get();
        OkHttpClient okHttpClient = (OkHttpClient) this.e.get();
        ru.yoomoney.sdk.kassa.payments.api.failures.a apiErrorMapper = (ru.yoomoney.sdk.kassa.payments.api.failures.a) this.f.get();
        dVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(apiErrorMapper, "apiErrorMapper");
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(R$raw.ym_default_config);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
        Intrinsics.checkNotNullParameter(inputStreamOpenRawResource, "<this>");
        String next = new Scanner(inputStreamOpenRawResource).useDelimiter("\\A").next();
        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
        Config configA = AbstractC2334s.a(next, testParameters.getHostParameters());
        if (testParameters.getMockConfiguration() != null) {
            bVar = new g(configA);
        } else {
            HostParameters hostParameters = testParameters.getHostParameters();
            SharedPreferences sharedPreferences = context.getSharedPreferences("configPrefs", 0);
            c cVar = new c(testParameters);
            ru.yoomoney.sdk.kassa.payments.api.config.b bVar2 = new ru.yoomoney.sdk.kassa.payments.api.config.b(JacksonBaseObjectMapperKt.getJacksonBaseObjectMapper(), apiErrorMapper);
            Retrofit.Builder builderBaseUrl = new Retrofit.Builder().client(okHttpClient).baseUrl(cVar.invoke());
            l lVar = YooKassaJacksonConverterFactory.Companion;
            ObjectMapper jacksonBaseObjectMapper = JacksonBaseObjectMapperKt.getJacksonBaseObjectMapper();
            lVar.getClass();
            Object objCreate = builderBaseUrl.addConverterFactory(l.a(jacksonBaseObjectMapper)).addCallAdapterFactory(new k(bVar2)).build().create(ru.yoomoney.sdk.kassa.payments.api.config.c.class);
            Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
            Intrinsics.checkNotNull(sharedPreferences);
            bVar = new b(hostParameters, configA, (ru.yoomoney.sdk.kassa.payments.api.config.c) objCreate, sharedPreferences, errorReporter);
        }
        return (f) Preconditions.checkNotNullFromProvides(bVar);
    }
}
