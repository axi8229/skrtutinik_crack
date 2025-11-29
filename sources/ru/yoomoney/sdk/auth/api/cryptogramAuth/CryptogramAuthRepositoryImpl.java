package ru.yoomoney.sdk.auth.api.cryptogramAuth;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;
import ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt;
import ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthRequest;
import ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthResponse;
import ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthValidateRequest;
import ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthValidateResponse;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\t2\u0006\u0010\u000b\u001a\u00020\u0011H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/api/cryptogramAuth/CryptogramAuthRepositoryImpl;", "Lru/yoomoney/sdk/auth/api/cryptogramAuth/CryptogramAuthRepository;", "api", "Lru/yoomoney/sdk/auth/api/cryptogramAuth/CryptogramAuthApi;", "getToken", "Lkotlin/Function0;", "", "(Lru/yoomoney/sdk/auth/api/cryptogramAuth/CryptogramAuthApi;Lkotlin/jvm/functions/Function0;)V", "getAuthCryptogram", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthResponse;", "request", "Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthRequest;", "getAuthCryptogram-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateAuthCryptogram", "Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthValidateResponse;", "Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthValidateRequest;", "validateAuthCryptogram-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/cryptogramAuth/method/CryptogramAuthValidateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CryptogramAuthRepositoryImpl implements CryptogramAuthRepository {
    private final CryptogramAuthApi api;
    private final Function0<String> getToken;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl", f = "CryptogramAuthRepositoryImpl.kt", l = {17}, m = "getAuthCryptogram-gIAlu-s")
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
            Object objMo3246getAuthCryptogramgIAlus = CryptogramAuthRepositoryImpl.this.mo3246getAuthCryptogramgIAlus(null, this);
            return objMo3246getAuthCryptogramgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3246getAuthCryptogramgIAlus : Result.m2627boximpl(objMo3246getAuthCryptogramgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl$getAuthCryptogram$2", f = "CryptogramAuthRepositoryImpl.kt", l = {18}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function1<Continuation<? super Result<? extends CryptogramAuthResponse>>, Object> {
        public int a;
        public final /* synthetic */ CryptogramAuthRequest c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CryptogramAuthRequest cryptogramAuthRequest, Continuation<? super b> continuation) {
            super(1, continuation);
            this.c = cryptogramAuthRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CryptogramAuthRepositoryImpl.this.new b(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends CryptogramAuthResponse>> continuation) {
            return CryptogramAuthRepositoryImpl.this.new b(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CryptogramAuthApi cryptogramAuthApi = CryptogramAuthRepositoryImpl.this.api;
                String str = (String) CryptogramAuthRepositoryImpl.this.getToken.invoke();
                CryptogramAuthRequest cryptogramAuthRequest = this.c;
                this.a = 1;
                obj = cryptogramAuthApi.cryptogramAuth(str, cryptogramAuthRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl", f = "CryptogramAuthRepositoryImpl.kt", l = {26}, m = "validateAuthCryptogram-gIAlu-s")
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
            Object objMo3247validateAuthCryptogramgIAlus = CryptogramAuthRepositoryImpl.this.mo3247validateAuthCryptogramgIAlus(null, this);
            return objMo3247validateAuthCryptogramgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3247validateAuthCryptogramgIAlus : Result.m2627boximpl(objMo3247validateAuthCryptogramgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl$validateAuthCryptogram$2", f = "CryptogramAuthRepositoryImpl.kt", l = {27}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements Function1<Continuation<? super Result<? extends CryptogramAuthValidateResponse>>, Object> {
        public int a;
        public final /* synthetic */ CryptogramAuthValidateRequest c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(CryptogramAuthValidateRequest cryptogramAuthValidateRequest, Continuation<? super d> continuation) {
            super(1, continuation);
            this.c = cryptogramAuthValidateRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CryptogramAuthRepositoryImpl.this.new d(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends CryptogramAuthValidateResponse>> continuation) {
            return CryptogramAuthRepositoryImpl.this.new d(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CryptogramAuthApi cryptogramAuthApi = CryptogramAuthRepositoryImpl.this.api;
                String str = (String) CryptogramAuthRepositoryImpl.this.getToken.invoke();
                CryptogramAuthValidateRequest cryptogramAuthValidateRequest = this.c;
                this.a = 1;
                obj = cryptogramAuthApi.cryptogramAuthValidate(str, cryptogramAuthValidateRequest, this);
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

    public CryptogramAuthRepositoryImpl(CryptogramAuthApi api, Function0<String> getToken) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(getToken, "getToken");
        this.api = api;
        this.getToken = getToken;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepository
    /* renamed from: getAuthCryptogram-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3246getAuthCryptogramgIAlus(ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthRequest r5, kotlin.coroutines.Continuation<? super kotlin.Result<ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl.a
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl$a r0 = (ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl$a r0 = new ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl$a
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
            ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl$b r6 = new ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl$b
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl.mo3246getAuthCryptogramgIAlus(ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepository
    /* renamed from: validateAuthCryptogram-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3247validateAuthCryptogramgIAlus(ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthValidateRequest r5, kotlin.coroutines.Continuation<? super kotlin.Result<ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthValidateResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl.c
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl$c r0 = (ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl$c r0 = new ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl$c
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
            ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl$d r6 = new ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl$d
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.cryptogramAuth.CryptogramAuthRepositoryImpl.mo3247validateAuthCryptogramgIAlus(ru.yoomoney.sdk.auth.api.cryptogramAuth.method.CryptogramAuthValidateRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
