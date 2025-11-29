package ru.yoomoney.sdk.auth.api.oauth;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt;
import ru.yoomoney.sdk.auth.api.oauth.domain.CreateAuthorizationCodeRequestApi;
import ru.yoomoney.sdk.auth.api.oauth.domain.CreateAuthorizationCodeResponse;
import ru.yoomoney.sdk.auth.api.oauth.domain.CreateAuthorizationCodeResponseApiKt;
import ru.yoomoney.sdk.auth.api.oauth.domain.CreateProcessRequestApi;
import ru.yoomoney.sdk.auth.api.oauth.domain.CreateProcessResponseApi;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\rJ\b\u0010\u0011\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/auth/api/oauth/OauthV2RepositoryImpl;", "Lru/yoomoney/sdk/auth/api/oauth/OauthV2Repository;", "api", "Lru/yoomoney/sdk/auth/api/oauth/OauthV2Api;", "getToken", "Lkotlin/Function0;", "", "(Lru/yoomoney/sdk/auth/api/oauth/OauthV2Api;Lkotlin/jvm/functions/Function0;)V", "authorizationCode", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/oauth/domain/CreateAuthorizationCodeResponse;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "authorizationCode-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "createAuthorizationCode", "clientId", "createAuthorizationCode-IoAF18A", "prepareAuthorizationHeader", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OauthV2RepositoryImpl implements OauthV2Repository {
    private final OauthV2Api api;
    private final Function0<String> getToken;

    public static final class a extends Lambda implements Function0<Result<? extends CreateAuthorizationCodeResponse>> {
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(0);
            this.b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Result<? extends CreateAuthorizationCodeResponse> invoke() {
            return Result.m2627boximpl(CreateAuthorizationCodeResponseApiKt.toResultCreateAuthorizationCodeResponse(ApiV2ExtentionsKt.parseResponseToResult(OauthV2RepositoryImpl.this.api.authorizationCode(OauthV2RepositoryImpl.this.prepareAuthorizationHeader(), new CreateAuthorizationCodeRequestApi(this.b)))));
        }
    }

    public static final class b extends Lambda implements Function0<Result<? extends CreateAuthorizationCodeResponse>> {
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(0);
            this.b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Result<? extends CreateAuthorizationCodeResponse> invoke() {
            Object responseToResult = ApiV2ExtentionsKt.parseResponseToResult(OauthV2RepositoryImpl.this.api.createProcess(OauthV2RepositoryImpl.this.prepareAuthorizationHeader(), new CreateProcessRequestApi(this.b)));
            OauthV2RepositoryImpl oauthV2RepositoryImpl = OauthV2RepositoryImpl.this;
            Throwable thM2631exceptionOrNullimpl = Result.m2631exceptionOrNullimpl(responseToResult);
            return Result.m2627boximpl(thM2631exceptionOrNullimpl == null ? oauthV2RepositoryImpl.m3285authorizationCodeIoAF18A(((CreateProcessResponseApi) responseToResult).getProcessId()) : Result.m2628constructorimpl(ResultKt.createFailure(thM2631exceptionOrNullimpl)));
        }
    }

    public OauthV2RepositoryImpl(OauthV2Api api, Function0<String> getToken) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(getToken, "getToken");
        this.api = api;
        this.getToken = getToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: authorizationCode-IoAF18A, reason: not valid java name */
    public final Object m3285authorizationCodeIoAF18A(String processId) {
        return ApiV2ExtentionsKt.executeNotSuspendWithResult(new a(processId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String prepareAuthorizationHeader() {
        return "Bearer " + ((Object) this.getToken.invoke());
    }

    @Override // ru.yoomoney.sdk.auth.api.oauth.OauthV2Repository
    /* renamed from: createAuthorizationCode-IoAF18A */
    public Object mo3283createAuthorizationCodeIoAF18A(String clientId) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        return ApiV2ExtentionsKt.executeNotSuspendWithResult(new b(clientId));
    }
}
