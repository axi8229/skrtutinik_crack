package ru.yoomoney.sdk.auth.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.yoomoney.sdk.auth.api.registrationV2.api.RegistrationV2Api;
import ru.yoomoney.sdk.core_api.EnumJecksonRetrofitConverterFactory;
import ru.yoomoney.sdk.core_api.Serializer;
import ru.yoomoney.sdk.core_api.calladapter.ApiResponseAdapterFactory;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bR\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/api/ApiV2Client;", "", "httpClient", "Lokhttp3/OkHttpClient;", "baseUrl", "", "(Lokhttp3/OkHttpClient;Ljava/lang/String;)V", "retrofit", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "getRegistrationV2Api", "Lru/yoomoney/sdk/auth/api/registrationV2/api/RegistrationV2Api;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApiV2Client {
    private final Retrofit retrofit;

    public ApiV2Client(OkHttpClient httpClient, String baseUrl) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        this.retrofit = new Retrofit.Builder().baseUrl(baseUrl + "/api/yooid/v2/").addConverterFactory(new EnumJecksonRetrofitConverterFactory()).addConverterFactory(JacksonConverterFactory.create(Serializer.getJacksonObjectMapper())).addCallAdapterFactory(ApiResponseAdapterFactory.INSTANCE).client(httpClient).build();
    }

    public final RegistrationV2Api getRegistrationV2Api() throws SecurityException {
        Object objCreate = this.retrofit.create(RegistrationV2Api.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (RegistrationV2Api) objCreate;
    }
}
