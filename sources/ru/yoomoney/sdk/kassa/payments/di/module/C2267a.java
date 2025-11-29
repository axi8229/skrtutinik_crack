package ru.yoomoney.sdk.kassa.payments.di.module;

import com.fasterxml.jackson.databind.ObjectMapper;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import ru.yoomoney.sdk.kassa.payments.api.JacksonBaseObjectMapperKt;
import ru.yoomoney.sdk.kassa.payments.api.YooKassaJacksonConverterFactory;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2267a {
    public static ru.yoomoney.sdk.kassa.payments.api.d a(ru.yoomoney.sdk.kassa.payments.http.a hostProvider, OkHttpClient okHttpClient, ru.yoomoney.sdk.kassa.payments.api.failures.a apiErrorMapper) throws SecurityException {
        Intrinsics.checkNotNullParameter(hostProvider, "hostProvider");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(apiErrorMapper, "apiErrorMapper");
        Retrofit.Builder builderBaseUrl = new Retrofit.Builder().client(okHttpClient).baseUrl(((ru.yoomoney.sdk.kassa.payments.http.b) hostProvider).b() + "/");
        ru.yoomoney.sdk.kassa.payments.api.l lVar = YooKassaJacksonConverterFactory.Companion;
        ObjectMapper jacksonBaseObjectMapper = JacksonBaseObjectMapperKt.getJacksonBaseObjectMapper();
        lVar.getClass();
        Object objCreate = builderBaseUrl.addConverterFactory(ru.yoomoney.sdk.kassa.payments.api.l.a(jacksonBaseObjectMapper)).addCallAdapterFactory(new ru.yoomoney.sdk.kassa.payments.api.k(apiErrorMapper)).build().create(ru.yoomoney.sdk.kassa.payments.api.d.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (ru.yoomoney.sdk.kassa.payments.api.d) objCreate;
    }
}
