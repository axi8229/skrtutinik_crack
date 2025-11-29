package ru.yoomoney.sdk.two_fa.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.yoomoney.sdk.core_api.EnumJecksonRetrofitConverterFactory;
import ru.yoomoney.sdk.core_api.Serializer;
import ru.yoomoney.sdk.core_api.calladapter.ApiResponseAdapterFactory;

/* compiled from: AuthenticatorServiceFactory.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"create2faApi", "Lru/yoomoney/sdk/two_fa/api/Class2faApi;", "host", "", "httpClient", "Lokhttp3/OkHttpClient;", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AuthenticatorServiceFactoryKt {
    public static final Class2faApi create2faApi(String host, OkHttpClient httpClient) throws SecurityException {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Object objCreate = new Retrofit.Builder().baseUrl(host + "/api/authenticator/v1/").client(httpClient).addConverterFactory(new EnumJecksonRetrofitConverterFactory()).addConverterFactory(JacksonConverterFactory.create(Serializer.getJacksonObjectMapper())).addCallAdapterFactory(ApiResponseAdapterFactory.INSTANCE).build().create(Class2faApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (Class2faApi) objCreate;
    }
}
