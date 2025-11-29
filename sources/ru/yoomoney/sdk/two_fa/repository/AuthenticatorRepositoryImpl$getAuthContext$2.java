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
import ru.yoomoney.sdk.two_fa.api.method.GetAuthContextApiResponse;
import ru.yoomoney.sdk.two_fa.domain.AuthContext;
import ru.yoomoney.sdk.two_fa.domain.DomainExtensionKt;
import ru.yoomoney.sdk.two_fa.exception.ProcessingRequestFailure;

/* compiled from: AuthenticatorRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lru/yoomoney/sdk/two_fa/domain/AuthContext;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthContext$2", f = "AuthenticatorRepository.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class AuthenticatorRepositoryImpl$getAuthContext$2 extends SuspendLambda implements Function1<Continuation<? super Result<? extends AuthContext>>, Object> {
    final /* synthetic */ String $authProcessId;
    int label;
    final /* synthetic */ AuthenticatorRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AuthenticatorRepositoryImpl$getAuthContext$2(AuthenticatorRepositoryImpl authenticatorRepositoryImpl, String str, Continuation<? super AuthenticatorRepositoryImpl$getAuthContext$2> continuation) {
        super(1, continuation);
        this.this$0 = authenticatorRepositoryImpl;
        this.$authProcessId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AuthenticatorRepositoryImpl$getAuthContext$2(this.this$0, this.$authProcessId, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Result<? extends AuthContext>> continuation) {
        return invoke2((Continuation<? super Result<AuthContext>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Result<AuthContext>> continuation) {
        return ((AuthenticatorRepositoryImpl$getAuthContext$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ApiResponse<GetAuthContextApiResponse, Object, Object> apiResponseAuthContextAuthProcessIdGet = this.this$0.authApi.authContextAuthProcessIdGet(this.$authProcessId);
            AnonymousClass1 anonymousClass1 = new Function2<GetAuthContextApiResponse, Headers, Result<? extends AuthContext>>() { // from class: ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthContext$2.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Result<? extends AuthContext> invoke(GetAuthContextApiResponse getAuthContextApiResponse, Headers headers) {
                    return Result.m2627boximpl(m3518invokegIAlus(getAuthContextApiResponse, headers));
                }

                /* renamed from: invoke-gIAlu-s, reason: not valid java name */
                public final Object m3518invokegIAlus(GetAuthContextApiResponse result, Headers headers) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Intrinsics.checkNotNullParameter(headers, "<anonymous parameter 1>");
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m2628constructorimpl(DomainExtensionKt.toDomainModel(result));
                }
            };
            final AuthenticatorRepositoryImpl authenticatorRepositoryImpl = this.this$0;
            return ApiResponse.fold$default(apiResponseAuthContextAuthProcessIdGet, anonymousClass1, new Function1<ApiErrorBodyResponse, Result<? extends AuthContext>>() { // from class: ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthContext$2.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Result<? extends AuthContext> invoke(ApiErrorBodyResponse apiErrorBodyResponse) {
                    return Result.m2627boximpl(m3519invokeIoAF18A(apiErrorBodyResponse));
                }

                /* renamed from: invoke-IoAF18A, reason: not valid java name */
                public final Object m3519invokeIoAF18A(ApiErrorBodyResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m2628constructorimpl(ResultKt.createFailure(authenticatorRepositoryImpl.toFailure(it)));
                }
            }, new Function1<ProcessApiResponseBody, Result<? extends AuthContext>>() { // from class: ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthContext$2.3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Result<? extends AuthContext> invoke(ProcessApiResponseBody processApiResponseBody) {
                    return Result.m2627boximpl(m3520invokeIoAF18A(processApiResponseBody));
                }

                /* renamed from: invoke-IoAF18A, reason: not valid java name */
                public final Object m3520invokeIoAF18A(ProcessApiResponseBody it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m2628constructorimpl(ResultKt.createFailure(new ProcessingRequestFailure(null, Integer.valueOf(it.getRetryAfter()), 1, null)));
                }
            }, null, 8, null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
