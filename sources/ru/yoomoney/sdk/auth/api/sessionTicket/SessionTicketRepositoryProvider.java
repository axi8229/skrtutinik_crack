package ru.yoomoney.sdk.auth.api.sessionTicket;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.api.ApiClient;
import ru.yoomoney.sdk.auth.api.ApiClientUtilsKt;
import ru.yoomoney.sdk.auth.api.ClientAppParams;
import ru.yoomoney.sdk.auth.api.TokenUtils;
import ru.yoomoney.sdk.auth.api.core.CoreApiRepositoryImpl;
import ru.yoomoney.sdk.auth.api.crypt.ApiKeyProviderImpl;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepositoryImpl;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/auth/api/sessionTicket/SessionTicketRepositoryProvider;", "", "()V", "create", "Lru/yoomoney/sdk/auth/api/sessionTicket/SessionTicketRepository;", "context", "Landroid/content/Context;", "clientAppParams", "Lru/yoomoney/sdk/auth/api/ClientAppParams;", "baseUrl", "", "isDebugMode", "", QrAuthDeclineWorkerKt.KEY_APPLICATION_USER_AGENT, "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SessionTicketRepositoryProvider {
    public static final SessionTicketRepositoryProvider INSTANCE = new SessionTicketRepositoryProvider();

    public static final class a extends Lambda implements Function0<String> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ClientAppParams b;
        public final /* synthetic */ ServerTimeRepositoryImpl c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, ClientAppParams clientAppParams, ServerTimeRepositoryImpl serverTimeRepositoryImpl) {
            super(0);
            this.a = z;
            this.b = clientAppParams;
            this.c = serverTimeRepositoryImpl;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return TokenUtils.INSTANCE.generateTokenHeader(new ApiKeyProviderImpl(this.a), this.b, this.c);
        }
    }

    private SessionTicketRepositoryProvider() {
    }

    public static /* synthetic */ SessionTicketRepository create$default(SessionTicketRepositoryProvider sessionTicketRepositoryProvider, Context context, ClientAppParams clientAppParams, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 16) != 0) {
            str2 = null;
        }
        return sessionTicketRepositoryProvider.create(context, clientAppParams, str, z, str2);
    }

    public final SessionTicketRepository create(Context context, ClientAppParams clientAppParams, String baseUrl, boolean isDebugMode, String applicationUserAgent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clientAppParams, "clientAppParams");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        ApiClient apiClientCreateApiClient = ApiClientUtilsKt.createApiClient(context, baseUrl, isDebugMode, applicationUserAgent);
        return new SessionTicketRepositoryImpl(apiClientCreateApiClient.getSessionTicketApi(), new a(isDebugMode, clientAppParams, new ServerTimeRepositoryImpl(new CoreApiRepositoryImpl(apiClientCreateApiClient.getCoreApi()))));
    }
}
