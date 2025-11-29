package ru.yoomoney.sdk.auth.api.oauth;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.ApiClientUtilsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\f¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/api/oauth/OauthV2RepositoryProvider;", "", "()V", "create", "Lru/yoomoney/sdk/auth/api/oauth/OauthV2Repository;", "context", "Landroid/content/Context;", "baseUrl", "", "isDebugMode", "", "getToken", "Lkotlin/Function0;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OauthV2RepositoryProvider {
    public static final OauthV2RepositoryProvider INSTANCE = new OauthV2RepositoryProvider();

    private OauthV2RepositoryProvider() {
    }

    public final OauthV2Repository create(Context context, String baseUrl, boolean isDebugMode, Function0<String> getToken) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(getToken, "getToken");
        return new OauthV2RepositoryImpl(ApiClientUtilsKt.createOauthV2ApiClient(context, baseUrl, isDebugMode).getOauthV2Api(), getToken);
    }
}
