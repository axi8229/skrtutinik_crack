package ru.yoomoney.sdk.auth.api.signIn;

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
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt;
import ru.yoomoney.sdk.auth.api.signIn.model.SigninQrCheckResponse;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\n\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\fJ$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\fJ\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/api/signIn/SignInRepositoryImpl;", "Lru/yoomoney/sdk/auth/api/signIn/SignInRepository;", "api", "Lru/yoomoney/sdk/auth/api/signIn/SignInApi;", YooMoneyAuth.KEY_ACCESS_TOKEN, "", "(Lru/yoomoney/sdk/auth/api/signIn/SignInApi;Ljava/lang/String;)V", "accept", "Lkotlin/Result;", "", "signinQrProcessId", "accept-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "check", "Lru/yoomoney/sdk/auth/api/signIn/model/SigninQrCheckResponse;", "check-gIAlu-s", "decline", "decline-gIAlu-s", "prepareAuthorizationHeader", "token", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SignInRepositoryImpl implements SignInRepository {
    private final String accessToken;
    private final SignInApi api;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl", f = "SignInRepositoryImpl.kt", l = {19}, m = "accept-gIAlu-s")
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
            Object objMo3303acceptgIAlus = SignInRepositoryImpl.this.mo3303acceptgIAlus(null, this);
            return objMo3303acceptgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3303acceptgIAlus : Result.m2627boximpl(objMo3303acceptgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$accept$2", f = "SignInRepositoryImpl.kt", l = {21}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function1<Continuation<? super Result<? extends Unit>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Continuation<? super b> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SignInRepositoryImpl.this.new b(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends Unit>> continuation) {
            return SignInRepositoryImpl.this.new b(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                SignInApi signInApi = SignInRepositoryImpl.this.api;
                SignInRepositoryImpl signInRepositoryImpl = SignInRepositoryImpl.this;
                String strPrepareAuthorizationHeader = signInRepositoryImpl.prepareAuthorizationHeader(signInRepositoryImpl.accessToken);
                String str = this.c;
                this.a = 1;
                if (signInApi.accept(strPrepareAuthorizationHeader, str, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(Result.m2628constructorimpl(Unit.INSTANCE));
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl", f = "SignInRepositoryImpl.kt", l = {12}, m = "check-gIAlu-s")
    public static final class c extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3304checkgIAlus = SignInRepositoryImpl.this.mo3304checkgIAlus(null, this);
            return objMo3304checkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3304checkgIAlus : Result.m2627boximpl(objMo3304checkgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$check$2", f = "SignInRepositoryImpl.kt", l = {13}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements Function1<Continuation<? super Result<? extends SigninQrCheckResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Continuation<? super d> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SignInRepositoryImpl.this.new d(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends SigninQrCheckResponse>> continuation) {
            return SignInRepositoryImpl.this.new d(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SignInApi signInApi = SignInRepositoryImpl.this.api;
                SignInRepositoryImpl signInRepositoryImpl = SignInRepositoryImpl.this;
                String strPrepareAuthorizationHeader = signInRepositoryImpl.prepareAuthorizationHeader(signInRepositoryImpl.accessToken);
                String str = this.c;
                this.a = 1;
                obj = signInApi.check(strPrepareAuthorizationHeader, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(ApiV2ExtentionsKt.parseResponseToResult((Response) obj));
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl", f = "SignInRepositoryImpl.kt", l = {28}, m = "decline-gIAlu-s")
    public static final class e extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3305declinegIAlus = SignInRepositoryImpl.this.mo3305declinegIAlus(null, this);
            return objMo3305declinegIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3305declinegIAlus : Result.m2627boximpl(objMo3305declinegIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$decline$2", f = "SignInRepositoryImpl.kt", l = {30}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements Function1<Continuation<? super Result<? extends Unit>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Continuation<? super f> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SignInRepositoryImpl.this.new f(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends Unit>> continuation) {
            return SignInRepositoryImpl.this.new f(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                SignInApi signInApi = SignInRepositoryImpl.this.api;
                SignInRepositoryImpl signInRepositoryImpl = SignInRepositoryImpl.this;
                String strPrepareAuthorizationHeader = signInRepositoryImpl.prepareAuthorizationHeader(signInRepositoryImpl.accessToken);
                String str = this.c;
                this.a = 1;
                if (signInApi.decline(strPrepareAuthorizationHeader, str, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(Result.m2628constructorimpl(Unit.INSTANCE));
        }
    }

    public SignInRepositoryImpl(SignInApi api, String accessToken) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        this.api = api;
        this.accessToken = accessToken;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String prepareAuthorizationHeader(String token) {
        return "Bearer " + token;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.signIn.SignInRepository
    /* renamed from: accept-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3303acceptgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl.a
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$a r0 = (ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$a r0 = new ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
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
            ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$b r6 = new ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$b
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl.mo3303acceptgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.signIn.SignInRepository
    /* renamed from: check-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3304checkgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<ru.yoomoney.sdk.auth.api.signIn.model.SigninQrCheckResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl.c
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$c r0 = (ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$c r0 = new ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
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
            ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$d r6 = new ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$d
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl.mo3304checkgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.signIn.SignInRepository
    /* renamed from: decline-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3305declinegIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl.e
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$e r0 = (ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$e r0 = new ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$e
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
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
            ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$f r6 = new ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl$f
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.signIn.SignInRepositoryImpl.mo3305declinegIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
