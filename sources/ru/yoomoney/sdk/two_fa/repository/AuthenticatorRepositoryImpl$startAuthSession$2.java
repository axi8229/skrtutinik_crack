package ru.yoomoney.sdk.two_fa.repository;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import ru.yoomoney.sdk.core_api.ApiErrorBodyResponse;
import ru.yoomoney.sdk.core_api.ApiResponse;
import ru.yoomoney.sdk.core_api.ProcessApiResponseBody;
import ru.yoomoney.sdk.two_fa.api.method.StartAuthSessionApiRequest;
import ru.yoomoney.sdk.two_fa.api.method.StartAuthSessionApiResponse;
import ru.yoomoney.sdk.two_fa.api.model.ApiSessionType;
import ru.yoomoney.sdk.two_fa.api.model.StartAuthSessionRuleViolationError;
import ru.yoomoney.sdk.two_fa.domain.DomainExtensionKt;
import ru.yoomoney.sdk.two_fa.domain.Session;
import ru.yoomoney.sdk.two_fa.domain.SessionType;
import ru.yoomoney.sdk.two_fa.exception.ProcessingRequestFailure;

/* compiled from: AuthenticatorRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lru/yoomoney/sdk/two_fa/domain/Session;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$startAuthSession$2", f = "AuthenticatorRepository.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class AuthenticatorRepositoryImpl$startAuthSession$2 extends SuspendLambda implements Function1<Continuation<? super Result<? extends Session>>, Object> {
    final /* synthetic */ String $authProcessId;
    final /* synthetic */ SessionType $type;
    int label;
    final /* synthetic */ AuthenticatorRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AuthenticatorRepositoryImpl$startAuthSession$2(AuthenticatorRepositoryImpl authenticatorRepositoryImpl, String str, SessionType sessionType, Continuation<? super AuthenticatorRepositoryImpl$startAuthSession$2> continuation) {
        super(1, continuation);
        this.this$0 = authenticatorRepositoryImpl;
        this.$authProcessId = str;
        this.$type = sessionType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AuthenticatorRepositoryImpl$startAuthSession$2(this.this$0, this.$authProcessId, this.$type, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Result<? extends Session>> continuation) {
        return ((AuthenticatorRepositoryImpl$startAuthSession$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ApiResponse<StartAuthSessionApiResponse, StartAuthSessionRuleViolationError, Object> apiResponseAuthSessionStartPost = this.this$0.authApi.authSessionStartPost(new StartAuthSessionApiRequest(this.$authProcessId, ApiSessionType.valueOf(this.$type.name())));
        AnonymousClass1 anonymousClass1 = new Function2<StartAuthSessionApiResponse, Headers, Result<? extends Session>>() { // from class: ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$startAuthSession$2.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Result<? extends Session> invoke(StartAuthSessionApiResponse startAuthSessionApiResponse, Headers headers) {
                return Result.m2627boximpl(m3524invokegIAlus(startAuthSessionApiResponse, headers));
            }

            /* renamed from: invoke-gIAlu-s, reason: not valid java name */
            public final Object m3524invokegIAlus(StartAuthSessionApiResponse result, Headers headers) {
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(headers, "<anonymous parameter 1>");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2628constructorimpl(DomainExtensionKt.toDomainModel(result));
            }
        };
        final AuthenticatorRepositoryImpl authenticatorRepositoryImpl = this.this$0;
        return ApiResponse.fold$default(apiResponseAuthSessionStartPost, anonymousClass1, new Function1<ApiErrorBodyResponse, Result<? extends Session>>() { // from class: ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$startAuthSession$2.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Result<? extends Session> invoke(ApiErrorBodyResponse apiErrorBodyResponse) {
                return Result.m2627boximpl(m3525invokeIoAF18A(apiErrorBodyResponse));
            }

            /* renamed from: invoke-IoAF18A, reason: not valid java name */
            public final Object m3525invokeIoAF18A(ApiErrorBodyResponse it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2628constructorimpl(ResultKt.createFailure(authenticatorRepositoryImpl.toFailure(it)));
            }
        }, new Function1<ProcessApiResponseBody, Result<? extends Session>>() { // from class: ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$startAuthSession$2.3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Result<? extends Session> invoke(ProcessApiResponseBody processApiResponseBody) {
                return Result.m2627boximpl(m3526invokeIoAF18A(processApiResponseBody));
            }

            /* renamed from: invoke-IoAF18A, reason: not valid java name */
            public final Object m3526invokeIoAF18A(ProcessApiResponseBody it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Result.Companion companion = Result.INSTANCE;
                return Result.m2628constructorimpl(ResultKt.createFailure(new ProcessingRequestFailure(null, Integer.valueOf(it.getRetryAfter()), 1, null)));
            }
        }, null, 8, null);
    }
}
