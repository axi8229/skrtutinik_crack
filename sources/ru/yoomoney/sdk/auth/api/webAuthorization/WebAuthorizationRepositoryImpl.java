package ru.yoomoney.sdk.auth.api.webAuthorization;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;
import ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.webAuthorization.method.WebAuthorizationRequest;
import ru.yoomoney.sdk.auth.api.webAuthorization.method.WebAuthorizationResponse;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/api/webAuthorization/WebAuthorizationRepositoryImpl;", "Lru/yoomoney/sdk/auth/api/webAuthorization/WebAuthorizationRepository;", "api", "Lru/yoomoney/sdk/auth/api/webAuthorization/WebAuthorizationApi;", "(Lru/yoomoney/sdk/auth/api/webAuthorization/WebAuthorizationApi;)V", "getLandingUrl", "Lkotlin/Result;", "", "token", "targetUrl", "getLandingUrl-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareAuthorizationHeader", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebAuthorizationRepositoryImpl implements WebAuthorizationRepository {
    private final WebAuthorizationApi api;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.webAuthorization.WebAuthorizationRepositoryImpl", f = "WebAuthorizationRepositoryImpl.kt", l = {12}, m = "getLandingUrl-0E7RQCE")
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3306getLandingUrl0E7RQCE = WebAuthorizationRepositoryImpl.this.mo3306getLandingUrl0E7RQCE(null, null, this);
            return objMo3306getLandingUrl0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3306getLandingUrl0E7RQCE : Result.m2627boximpl(objMo3306getLandingUrl0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.webAuthorization.WebAuthorizationRepositoryImpl$getLandingUrl$2", f = "WebAuthorizationRepositoryImpl.kt", l = {13}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function1<Continuation<? super Result<? extends String>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, Continuation<? super b> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return WebAuthorizationRepositoryImpl.this.new b(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends String>> continuation) {
            return ((b) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objCreateFailure;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                WebAuthorizationApi webAuthorizationApi = WebAuthorizationRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = WebAuthorizationRepositoryImpl.this.prepareAuthorizationHeader(this.c);
                WebAuthorizationRequest webAuthorizationRequest = new WebAuthorizationRequest(this.d);
                this.a = 1;
                obj = webAuthorizationApi.webAuthorization(strPrepareAuthorizationHeader, webAuthorizationRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Object responseToResult = ApiV2ExtentionsKt.parseResponseToResult((Response) obj);
            Throwable thM2631exceptionOrNullimpl = Result.m2631exceptionOrNullimpl(responseToResult);
            if (thM2631exceptionOrNullimpl == null) {
                objCreateFailure = ((WebAuthorizationResponse) responseToResult).getLandingUrl();
            } else {
                Intrinsics.checkNotNull(thM2631exceptionOrNullimpl, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure");
                objCreateFailure = ResultKt.createFailure((Failure) thM2631exceptionOrNullimpl);
            }
            return Result.m2627boximpl(Result.m2628constructorimpl(objCreateFailure));
        }
    }

    public WebAuthorizationRepositoryImpl(WebAuthorizationApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String prepareAuthorizationHeader(String token) {
        return "Bearer " + token;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.webAuthorization.WebAuthorizationRepository
    /* renamed from: getLandingUrl-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3306getLandingUrl0E7RQCE(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.webAuthorization.WebAuthorizationRepositoryImpl.a
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.webAuthorization.WebAuthorizationRepositoryImpl$a r0 = (ru.yoomoney.sdk.auth.api.webAuthorization.WebAuthorizationRepositoryImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.webAuthorization.WebAuthorizationRepositoryImpl$a r0 = new ru.yoomoney.sdk.auth.api.webAuthorization.WebAuthorizationRepositoryImpl$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
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
            ru.yoomoney.sdk.auth.api.webAuthorization.WebAuthorizationRepositoryImpl$b r7 = new ru.yoomoney.sdk.auth.api.webAuthorization.WebAuthorizationRepositoryImpl$b
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.webAuthorization.WebAuthorizationRepositoryImpl.mo3306getLandingUrl0E7RQCE(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
