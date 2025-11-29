package ru.yoomoney.sdk.auth.api;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.deserializer.ErrorResponseDeserializer;
import ru.yoomoney.sdk.auth.api.deserializer.OffsetDateTimeDeserializer;
import ru.yoomoney.sdk.auth.api.deserializer.ProcessErrorDeserializer;
import ru.yoomoney.sdk.auth.api.model.ErrorResponse;
import ru.yoomoney.sdk.auth.api.model.ProcessError;
import ru.yoomoney.sdk.auth.net.interceptor.AuthorizationInterceptor;
import ru.yoomoney.sdk.auth.net.utils.HttpClientUtilsKt;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.yoopinning.PinningHelper;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tH\u0000\u001a(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0013"}, d2 = {"gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "createApiClient", "Lru/yoomoney/sdk/auth/api/ApiClient;", "context", "Landroid/content/Context;", "baseUrl", "", "isDebugMode", "", QrAuthDeclineWorkerKt.KEY_APPLICATION_USER_AGENT, "createApiV2Client", "Lru/yoomoney/sdk/auth/api/ApiV2Client;", "authorizationInterceptor", "Lru/yoomoney/sdk/auth/net/interceptor/AuthorizationInterceptor;", "createOauthV2ApiClient", "Lru/yoomoney/sdk/auth/api/OauthV2ApiClient;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApiClientUtilsKt {
    private static final Gson gson;

    static {
        Gson gsonCreate = new GsonBuilder().registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeDeserializer()).registerTypeAdapter(ProcessError.class, new ProcessErrorDeserializer()).registerTypeAdapter(ErrorResponse.class, new ErrorResponseDeserializer()).create();
        Intrinsics.checkNotNullExpressionValue(gsonCreate, "create(...)");
        gson = gsonCreate;
    }

    public static final ApiClient createApiClient(Context context, String baseUrl, boolean z, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        return new ApiClient(HttpClientUtilsKt.createHttpClient$default(context, PinningHelper.INSTANCE.prepareCertsHostFromBaseUrl(baseUrl), z, str, null, 16, null), baseUrl, gson);
    }

    public static /* synthetic */ ApiClient createApiClient$default(Context context, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        return createApiClient(context, str, z, str2);
    }

    public static final ApiV2Client createApiV2Client(Context context, String baseUrl, boolean z, AuthorizationInterceptor authorizationInterceptor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(authorizationInterceptor, "authorizationInterceptor");
        return new ApiV2Client(HttpClientUtilsKt.createHttpClient$default(context, PinningHelper.INSTANCE.prepareCertsHostFromBaseUrl(baseUrl), z, null, authorizationInterceptor, 8, null), baseUrl);
    }

    public static final OauthV2ApiClient createOauthV2ApiClient(Context context, String baseUrl, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        return new OauthV2ApiClient(HttpClientUtilsKt.createHttpClient$default(context, PinningHelper.INSTANCE.prepareCertsHostFromBaseUrl(baseUrl), z, null, null, 24, null), baseUrl);
    }

    public static final Gson getGson() {
        return gson;
    }
}
