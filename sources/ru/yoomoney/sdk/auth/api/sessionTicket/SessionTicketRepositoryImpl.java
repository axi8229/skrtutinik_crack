package ru.yoomoney.sdk.auth.api.sessionTicket;

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
import ru.yoomoney.sdk.auth.api.sessionTicket.method.SessionTicketResponse;
import ru.yoomoney.sdk.auth.api.sessionTicket.method.SessionTicketVerifyRequest;
import ru.yoomoney.sdk.auth.api.sessionTicket.method.SessionTicketVerifyResponse;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/api/sessionTicket/SessionTicketRepositoryImpl;", "Lru/yoomoney/sdk/auth/api/sessionTicket/SessionTicketRepository;", "api", "Lru/yoomoney/sdk/auth/api/sessionTicket/SessionTicketApi;", "getToken", "Lkotlin/Function0;", "", "(Lru/yoomoney/sdk/auth/api/sessionTicket/SessionTicketApi;Lkotlin/jvm/functions/Function0;)V", "sessionTicket", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/sessionTicket/method/SessionTicketResponse;", "sessionTicket-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verify", "Lru/yoomoney/sdk/auth/api/sessionTicket/method/SessionTicketVerifyResponse;", "request", "Lru/yoomoney/sdk/auth/api/sessionTicket/method/SessionTicketVerifyRequest;", "verify-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/sessionTicket/method/SessionTicketVerifyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SessionTicketRepositoryImpl implements SessionTicketRepository {
    private final SessionTicketApi api;
    private final Function0<String> getToken;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl", f = "SessionTicketRepositoryImpl.kt", l = {13}, m = "sessionTicket-IoAF18A")
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
            Object objMo3301sessionTicketIoAF18A = SessionTicketRepositoryImpl.this.mo3301sessionTicketIoAF18A(this);
            return objMo3301sessionTicketIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3301sessionTicketIoAF18A : Result.m2627boximpl(objMo3301sessionTicketIoAF18A);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl$sessionTicket$2", f = "SessionTicketRepositoryImpl.kt", l = {14}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function1<Continuation<? super Result<? extends SessionTicketResponse>>, Object> {
        public int a;

        public b(Continuation<? super b> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SessionTicketRepositoryImpl.this.new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends SessionTicketResponse>> continuation) {
            return SessionTicketRepositoryImpl.this.new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SessionTicketApi sessionTicketApi = SessionTicketRepositoryImpl.this.api;
                String str = (String) SessionTicketRepositoryImpl.this.getToken.invoke();
                this.a = 1;
                obj = sessionTicketApi.sessionTicket(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(SessionTicketApiExtensionsKt.parseSessionTicketResponse((Response) obj));
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl", f = "SessionTicketRepositoryImpl.kt", l = {19}, m = "verify-gIAlu-s")
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
            Object objMo3302verifygIAlus = SessionTicketRepositoryImpl.this.mo3302verifygIAlus(null, this);
            return objMo3302verifygIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3302verifygIAlus : Result.m2627boximpl(objMo3302verifygIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl$verify$2", f = "SessionTicketRepositoryImpl.kt", l = {20}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements Function1<Continuation<? super Result<? extends SessionTicketVerifyResponse>>, Object> {
        public int a;
        public final /* synthetic */ SessionTicketVerifyRequest c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SessionTicketVerifyRequest sessionTicketVerifyRequest, Continuation<? super d> continuation) {
            super(1, continuation);
            this.c = sessionTicketVerifyRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SessionTicketRepositoryImpl.this.new d(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends SessionTicketVerifyResponse>> continuation) {
            return SessionTicketRepositoryImpl.this.new d(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SessionTicketApi sessionTicketApi = SessionTicketRepositoryImpl.this.api;
                String str = (String) SessionTicketRepositoryImpl.this.getToken.invoke();
                SessionTicketVerifyRequest sessionTicketVerifyRequest = this.c;
                this.a = 1;
                obj = sessionTicketApi.verify(str, sessionTicketVerifyRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(SessionTicketApiExtensionsKt.parseSessionTicketResponse((Response) obj));
        }
    }

    public SessionTicketRepositoryImpl(SessionTicketApi api, Function0<String> getToken) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(getToken, "getToken");
        this.api = api;
        this.getToken = getToken;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepository
    /* renamed from: sessionTicket-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3301sessionTicketIoAF18A(kotlin.coroutines.Continuation<? super kotlin.Result<ru.yoomoney.sdk.auth.api.sessionTicket.method.SessionTicketResponse>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl.a
            if (r0 == 0) goto L13
            r0 = r5
            ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl$a r0 = (ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl$a r0 = new ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r5 = r5.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r5)
            ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl$b r5 = new ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl$b
            r2 = 0
            r5.<init>(r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r5, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl.mo3301sessionTicketIoAF18A(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepository
    /* renamed from: verify-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3302verifygIAlus(ru.yoomoney.sdk.auth.api.sessionTicket.method.SessionTicketVerifyRequest r5, kotlin.coroutines.Continuation<? super kotlin.Result<ru.yoomoney.sdk.auth.api.sessionTicket.method.SessionTicketVerifyResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl.c
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl$c r0 = (ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl$c r0 = new ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl$c
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
            ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl$d r6 = new ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl$d
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepositoryImpl.mo3302verifygIAlus(ru.yoomoney.sdk.auth.api.sessionTicket.method.SessionTicketVerifyRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
