package ru.yoomoney.sdk.two_fa.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import ru.yoomoney.sdk.two_fa.api.Class2faApi;
import ru.yoomoney.sdk.two_fa.api.method.ListAuthSessionApiRequest;
import ru.yoomoney.sdk.two_fa.api.method.ListAuthSessionApiResponse;
import ru.yoomoney.sdk.two_fa.api.model.ActiveSessionApi;
import ru.yoomoney.sdk.two_fa.api.model.ActiveSessionApiType;
import ru.yoomoney.sdk.two_fa.domain.ActiveSession;
import ru.yoomoney.sdk.two_fa.domain.ActiveSessionType;
import ru.yoomoney.sdk.two_fa.domain.DomainExtensionKt;
import ru.yoomoney.sdk.two_fa.exception.ProcessingRequestFailure;

/* compiled from: AuthenticatorRepository.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lru/yoomoney/sdk/two_fa/domain/ActiveSession;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthSessionList$2", f = "AuthenticatorRepository.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class AuthenticatorRepositoryImpl$getAuthSessionList$2 extends SuspendLambda implements Function1<Continuation<? super Result<? extends List<? extends ActiveSession>>>, Object> {
    final /* synthetic */ List<ActiveSessionType> $sessionTypes;
    int label;
    final /* synthetic */ AuthenticatorRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AuthenticatorRepositoryImpl$getAuthSessionList$2(AuthenticatorRepositoryImpl authenticatorRepositoryImpl, List<? extends ActiveSessionType> list, Continuation<? super AuthenticatorRepositoryImpl$getAuthSessionList$2> continuation) {
        super(1, continuation);
        this.this$0 = authenticatorRepositoryImpl;
        this.$sessionTypes = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AuthenticatorRepositoryImpl$getAuthSessionList$2(this.this$0, this.$sessionTypes, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Result<? extends List<? extends ActiveSession>>> continuation) {
        return ((AuthenticatorRepositoryImpl$getAuthSessionList$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Class2faApi class2faApi = this.this$0.authApi;
            List<ActiveSessionType> list = this.$sessionTypes;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ActiveSessionApiType.valueOf(((ActiveSessionType) it.next()).name()));
            }
            ApiResponse<ListAuthSessionApiResponse, Object, Object> apiResponseAuthSessionListPost = class2faApi.authSessionListPost(new ListAuthSessionApiRequest(arrayList));
            AnonymousClass2 anonymousClass2 = new Function2<ListAuthSessionApiResponse, Headers, Result<? extends List<? extends ActiveSession>>>() { // from class: ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthSessionList$2.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Result<? extends List<? extends ActiveSession>> invoke(ListAuthSessionApiResponse listAuthSessionApiResponse, Headers headers) {
                    return Result.m2627boximpl(m3521invokegIAlus(listAuthSessionApiResponse, headers));
                }

                /* renamed from: invoke-gIAlu-s, reason: not valid java name */
                public final Object m3521invokegIAlus(ListAuthSessionApiResponse result, Headers headers) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Intrinsics.checkNotNullParameter(headers, "<anonymous parameter 1>");
                    Result.Companion companion = Result.INSTANCE;
                    List<ActiveSessionApi> activeSessions = result.getActiveSessions();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(activeSessions, 10));
                    Iterator<T> it2 = activeSessions.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(DomainExtensionKt.toDomainModel((ActiveSessionApi) it2.next()));
                    }
                    return Result.m2628constructorimpl(arrayList2);
                }
            };
            final AuthenticatorRepositoryImpl authenticatorRepositoryImpl = this.this$0;
            return ApiResponse.fold$default(apiResponseAuthSessionListPost, anonymousClass2, new Function1<ApiErrorBodyResponse, Result<? extends List<? extends ActiveSession>>>() { // from class: ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthSessionList$2.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Result<? extends List<? extends ActiveSession>> invoke(ApiErrorBodyResponse apiErrorBodyResponse) {
                    return Result.m2627boximpl(m3522invokeIoAF18A(apiErrorBodyResponse));
                }

                /* renamed from: invoke-IoAF18A, reason: not valid java name */
                public final Object m3522invokeIoAF18A(ApiErrorBodyResponse it2) {
                    Intrinsics.checkNotNullParameter(it2, "it");
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m2628constructorimpl(ResultKt.createFailure(authenticatorRepositoryImpl.toFailure(it2)));
                }
            }, new Function1<ProcessApiResponseBody, Result<? extends List<? extends ActiveSession>>>() { // from class: ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepositoryImpl$getAuthSessionList$2.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Result<? extends List<? extends ActiveSession>> invoke(ProcessApiResponseBody processApiResponseBody) {
                    return Result.m2627boximpl(m3523invokeIoAF18A(processApiResponseBody));
                }

                /* renamed from: invoke-IoAF18A, reason: not valid java name */
                public final Object m3523invokeIoAF18A(ProcessApiResponseBody it2) {
                    Intrinsics.checkNotNullParameter(it2, "it");
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m2628constructorimpl(ResultKt.createFailure(new ProcessingRequestFailure(null, Integer.valueOf(it2.getRetryAfter()), 1, null)));
                }
            }, null, 8, null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
