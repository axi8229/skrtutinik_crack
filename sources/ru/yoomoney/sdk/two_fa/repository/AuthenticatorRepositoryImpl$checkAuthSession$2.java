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
import ru.yoomoney.sdk.two_fa.api.method.CheckAuthSessionApiRequest;
import ru.yoomoney.sdk.two_fa.api.method.CheckAuthSessionApiResponse;
import ru.yoomoney.sdk.two_fa.api.model.CheckAuthSessionRuleViolationError;
import ru.yoomoney.sdk.two_fa.exception.ProcessingRequestFailure;

/* compiled from: AuthenticatorRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$checkAuthSession$2", f = "AuthenticatorRepository.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class AuthenticatorRepositoryImpl$checkAuthSession$2 extends SuspendLambda implements Function1<Continuation<? super Result<? extends String>>, Object> {
    final /* synthetic */ String $authProcessId;
    final /* synthetic */ String $secret;
    int label;
    final /* synthetic */ AuthenticatorRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AuthenticatorRepositoryImpl$checkAuthSession$2(AuthenticatorRepositoryImpl authenticatorRepositoryImpl, String str, String str2, Continuation<? super AuthenticatorRepositoryImpl$checkAuthSession$2> continuation) {
        super(1, continuation);
        this.this$0 = authenticatorRepositoryImpl;
        this.$authProcessId = str;
        this.$secret = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AuthenticatorRepositoryImpl$checkAuthSession$2(this.this$0, this.$authProcessId, this.$secret, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Result<? extends String>> continuation) {
        return invoke2((Continuation<? super Result<String>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Result<String>> continuation) {
        return ((AuthenticatorRepositoryImpl$checkAuthSession$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ApiResponse<CheckAuthSessionApiResponse, CheckAuthSessionRuleViolationError, Object> apiResponseAuthSessionCheckPost = this.this$0.authApi.authSessionCheckPost(new CheckAuthSessionApiRequest(this.$authProcessId, this.$secret));
            AnonymousClass1 anonymousClass1 = new Function2<CheckAuthSessionApiResponse, Headers, Result<? extends String>>() { // from class: ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$checkAuthSession$2.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Result<? extends String> invoke(CheckAuthSessionApiResponse checkAuthSessionApiResponse, Headers headers) {
                    return Result.m2627boximpl(m3515invokegIAlus(checkAuthSessionApiResponse, headers));
                }

                /* renamed from: invoke-gIAlu-s, reason: not valid java name */
                public final Object m3515invokegIAlus(CheckAuthSessionApiResponse result, Headers headers) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Intrinsics.checkNotNullParameter(headers, "<anonymous parameter 1>");
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m2628constructorimpl(result.getAuthProcessId());
                }
            };
            final AuthenticatorRepositoryImpl authenticatorRepositoryImpl = this.this$0;
            return ApiResponse.fold$default(apiResponseAuthSessionCheckPost, anonymousClass1, new Function1<ApiErrorBodyResponse, Result<? extends String>>() { // from class: ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$checkAuthSession$2.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Result<? extends String> invoke(ApiErrorBodyResponse apiErrorBodyResponse) {
                    return Result.m2627boximpl(m3516invokeIoAF18A(apiErrorBodyResponse));
                }

                /* renamed from: invoke-IoAF18A, reason: not valid java name */
                public final Object m3516invokeIoAF18A(ApiErrorBodyResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m2628constructorimpl(ResultKt.createFailure(authenticatorRepositoryImpl.toFailure(it)));
                }
            }, new Function1<ProcessApiResponseBody, Result<? extends String>>() { // from class: ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$checkAuthSession$2.3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Result<? extends String> invoke(ProcessApiResponseBody processApiResponseBody) {
                    return Result.m2627boximpl(m3517invokeIoAF18A(processApiResponseBody));
                }

                /* renamed from: invoke-IoAF18A, reason: not valid java name */
                public final Object m3517invokeIoAF18A(ProcessApiResponseBody it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m2628constructorimpl(ResultKt.createFailure(new ProcessingRequestFailure(null, Integer.valueOf(it.getRetryAfter()), 1, null)));
                }
            }, null, 8, null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
