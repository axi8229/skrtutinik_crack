package ru.yoomoney.sdk.two_fa.repository;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.core_api.ApiErrorBodyResponse;
import ru.yoomoney.sdk.core_api.ArgumentRuleViolationErrorResponse;
import ru.yoomoney.sdk.core_api.AuthenticationTokenErrorResponse;
import ru.yoomoney.sdk.two_fa.api.Class2faApi;
import ru.yoomoney.sdk.two_fa.api.model.CheckAuthSessionRuleViolationError;
import ru.yoomoney.sdk.two_fa.api.model.StartAuthSessionRuleViolationError;
import ru.yoomoney.sdk.two_fa.exception.Failure;
import ru.yoomoney.sdk.two_fa.exception.InvalidTokenFailure;
import ru.yoomoney.sdk.two_fa.exception.RulesViolationFailure;
import ru.yoomoney.sdk.two_fa.exception.TechnicalFailure;

/* compiled from: AuthenticatorRepository.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Lru/yoomoney/sdk/two_fa/repository/AuthenticatorRepositoryImpl;", "Lru/yoomoney/sdk/two_fa/repository/AuthenticatorRepository;", "authApi", "Lru/yoomoney/sdk/two_fa/api/Class2faApi;", "(Lru/yoomoney/sdk/two_fa/api/Class2faApi;)V", "checkAuthSession", "Lkotlin/Result;", "", "authProcessId", "secret", "checkAuthSession-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAuthContext", "Lru/yoomoney/sdk/two_fa/domain/AuthContext;", "getAuthContext-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAuthSessionList", "", "Lru/yoomoney/sdk/two_fa/domain/ActiveSession;", "sessionTypes", "Lru/yoomoney/sdk/two_fa/domain/ActiveSessionType;", "getAuthSessionList-gIAlu-s", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startAuthSession", "Lru/yoomoney/sdk/two_fa/domain/Session;", "type", "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "startAuthSession-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/two_fa/domain/SessionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toFailure", "Lru/yoomoney/sdk/two_fa/exception/Failure;", "Lru/yoomoney/sdk/core_api/ApiErrorBodyResponse;", "toRulesViolationFailure", "Lru/yoomoney/sdk/core_api/ArgumentRuleViolationErrorResponse;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AuthenticatorRepositoryImpl implements AuthenticatorRepository {
    public static final int $stable = 8;
    private final Class2faApi authApi;

    public AuthenticatorRepositoryImpl(Class2faApi authApi) {
        Intrinsics.checkNotNullParameter(authApi, "authApi");
        this.authApi = authApi;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepository
    /* renamed from: getAuthContext-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3512getAuthContextgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<ru.yoomoney.sdk.two_fa.domain.AuthContext>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthContext$1
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthContext$1 r0 = (ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthContext$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthContext$1 r0 = new ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthContext$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthContext$2 r6 = new ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthContext$2
            r2 = 0
            r6.<init>(r4, r5, r2)
            r0.label = r3
            java.lang.Object r5 = ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt.executeWithRetry(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl.mo3512getAuthContextgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepository
    /* renamed from: startAuthSession-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3514startAuthSession0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.two_fa.domain.SessionType r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.two_fa.domain.Session>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$startAuthSession$1
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$startAuthSession$1 r0 = (ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$startAuthSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$startAuthSession$1 r0 = new ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$startAuthSession$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$startAuthSession$2 r7 = new ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$startAuthSession$2
            r2 = 0
            r7.<init>(r4, r5, r6, r2)
            r0.label = r3
            java.lang.Object r5 = ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt.executeWithRetry(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl.mo3514startAuthSession0E7RQCE(java.lang.String, ru.yoomoney.sdk.two_fa.domain.SessionType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepository
    /* renamed from: checkAuthSession-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3511checkAuthSession0E7RQCE(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$checkAuthSession$1
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$checkAuthSession$1 r0 = (ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$checkAuthSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$checkAuthSession$1 r0 = new ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$checkAuthSession$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$checkAuthSession$2 r7 = new ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$checkAuthSession$2
            r2 = 0
            r7.<init>(r4, r5, r6, r2)
            r0.label = r3
            java.lang.Object r5 = ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt.executeWithRetry(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl.mo3511checkAuthSession0E7RQCE(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepository
    /* renamed from: getAuthSessionList-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3513getAuthSessionListgIAlus(java.util.List<? extends ru.yoomoney.sdk.two_fa.domain.ActiveSessionType> r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends java.util.List<? extends ru.yoomoney.sdk.two_fa.domain.ActiveSession>>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthSessionList$1
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthSessionList$1 r0 = (ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthSessionList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthSessionList$1 r0 = new ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthSessionList$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthSessionList$2 r6 = new ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthSessionList$2
            r2 = 0
            r6.<init>(r4, r5, r2)
            r0.label = r3
            java.lang.Object r5 = ru.yoomoney.sdk.two_fa.exception.ExecuteUtilKt.executeWithRetry(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl.mo3513getAuthSessionListgIAlus(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Failure toFailure(ApiErrorBodyResponse apiErrorBodyResponse) {
        return apiErrorBodyResponse instanceof AuthenticationTokenErrorResponse ? InvalidTokenFailure.INSTANCE : apiErrorBodyResponse instanceof ArgumentRuleViolationErrorResponse ? toRulesViolationFailure((ArgumentRuleViolationErrorResponse) apiErrorBodyResponse) : new TechnicalFailure(null, 1, null);
    }

    private final Failure toRulesViolationFailure(ArgumentRuleViolationErrorResponse<?> argumentRuleViolationErrorResponse) {
        Object rule = argumentRuleViolationErrorResponse.getRule();
        return rule == CheckAuthSessionRuleViolationError.ACTIVE_SESSION_IS_EXPIRED ? RulesViolationFailure.ActiveSessionIsExpiredFailure.INSTANCE : rule == CheckAuthSessionRuleViolationError.NO_ATTEMPTS_LEFT ? RulesViolationFailure.NoAttemptsLeftFailure.INSTANCE : rule == CheckAuthSessionRuleViolationError.INVALID_SECRET ? RulesViolationFailure.InvalidSecretFailure.INSTANCE : rule == StartAuthSessionRuleViolationError.VELOCITY_CHECK_ERROR ? RulesViolationFailure.VelocityCheckFailure.INSTANCE : new TechnicalFailure(null, 1, null);
    }
}
