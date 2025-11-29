package ru.yoomoney.sdk.auth.api.webAuthorization;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.ApiClientUtilsKt;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/api/webAuthorization/WebAuthorizationRepositoryProvider;", "", "()V", "create", "Lru/yoomoney/sdk/auth/api/webAuthorization/WebAuthorizationRepository;", "context", "Landroid/content/Context;", "baseUrl", "", "isDebugMode", "", QrAuthDeclineWorkerKt.KEY_APPLICATION_USER_AGENT, "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebAuthorizationRepositoryProvider {
    public static final WebAuthorizationRepositoryProvider INSTANCE = new WebAuthorizationRepositoryProvider();

    private WebAuthorizationRepositoryProvider() {
    }

    public static /* synthetic */ WebAuthorizationRepository create$default(WebAuthorizationRepositoryProvider webAuthorizationRepositoryProvider, Context context, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        return webAuthorizationRepositoryProvider.create(context, str, z, str2);
    }

    public final WebAuthorizationRepository create(Context context, String baseUrl, boolean isDebugMode, String applicationUserAgent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        return new WebAuthorizationRepositoryImpl(ApiClientUtilsKt.createApiClient(context, baseUrl, isDebugMode, applicationUserAgent).getWebAuthorizationApi());
    }
}
