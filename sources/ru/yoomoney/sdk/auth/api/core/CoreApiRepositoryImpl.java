package ru.yoomoney.sdk.auth.api.core;

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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt;
import ru.yoomoney.sdk.auth.api.core.method.InstallationIdentifierResponse;
import ru.yoomoney.sdk.auth.api.core.model.UnixTime;
import ru.yoomoney.sdk.auth.api.model.Failure;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/auth/api/core/CoreApiRepositoryImpl;", "Lru/yoomoney/sdk/auth/api/core/CoreApiRepository;", "api", "Lru/yoomoney/sdk/auth/api/core/CoreApi;", "(Lru/yoomoney/sdk/auth/api/core/CoreApi;)V", "getInstallationIdentifier", "Lkotlin/Result;", "", "getInstallationIdentifier-d1pmJ48", "()Ljava/lang/Object;", "getUnixTime", "Lru/yoomoney/sdk/auth/api/core/model/UnixTime;", "getUnixTime-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CoreApiRepositoryImpl implements CoreApiRepository {
    private final CoreApi api;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.core.CoreApiRepositoryImpl$getInstallationIdentifier$1", f = "CoreApiRepositoryImpl.kt", l = {18}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends String>>, Object> {
        public int a;

        @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.core.CoreApiRepositoryImpl$getInstallationIdentifier$1$1", f = "CoreApiRepositoryImpl.kt", l = {19}, m = "invokeSuspend")
        /* renamed from: ru.yoomoney.sdk.auth.api.core.CoreApiRepositoryImpl$a$a, reason: collision with other inner class name */
        public static final class C0303a extends SuspendLambda implements Function1<Continuation<? super Result<? extends InstallationIdentifierResponse>>, Object> {
            public int a;
            public final /* synthetic */ CoreApiRepositoryImpl b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0303a(CoreApiRepositoryImpl coreApiRepositoryImpl, Continuation<? super C0303a> continuation) {
                super(1, continuation);
                this.b = coreApiRepositoryImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C0303a(this.b, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Result<? extends InstallationIdentifierResponse>> continuation) {
                return new C0303a(this.b, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoreApi coreApi = this.b.api;
                    this.a = 1;
                    obj = coreApi.installationIdentifier(this);
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

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CoreApiRepositoryImpl.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends String>> continuation) {
            return CoreApiRepositoryImpl.this.new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objExecuteWithResult;
            Object objCreateFailure;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C0303a c0303a = new C0303a(CoreApiRepositoryImpl.this, null);
                this.a = 1;
                objExecuteWithResult = ApiV2ExtentionsKt.executeWithResult(c0303a, this);
                if (objExecuteWithResult == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objExecuteWithResult = ((Result) obj).getValue();
            }
            Throwable thM2631exceptionOrNullimpl = Result.m2631exceptionOrNullimpl(objExecuteWithResult);
            if (thM2631exceptionOrNullimpl == null) {
                objCreateFailure = ((InstallationIdentifierResponse) objExecuteWithResult).getValue();
            } else {
                Intrinsics.checkNotNull(thM2631exceptionOrNullimpl, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure");
                objCreateFailure = ResultKt.createFailure((Failure) thM2631exceptionOrNullimpl);
            }
            return Result.m2627boximpl(Result.m2628constructorimpl(objCreateFailure));
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.core.CoreApiRepositoryImpl", f = "CoreApiRepositoryImpl.kt", l = {13}, m = "getUnixTime-IoAF18A")
    public static final class b extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3245getUnixTimeIoAF18A = CoreApiRepositoryImpl.this.mo3245getUnixTimeIoAF18A(this);
            return objMo3245getUnixTimeIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3245getUnixTimeIoAF18A : Result.m2627boximpl(objMo3245getUnixTimeIoAF18A);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.core.CoreApiRepositoryImpl$getUnixTime$2", f = "CoreApiRepositoryImpl.kt", l = {14}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements Function1<Continuation<? super Result<? extends UnixTime>>, Object> {
        public int a;

        public c(Continuation<? super c> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CoreApiRepositoryImpl.this.new c(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends UnixTime>> continuation) {
            return CoreApiRepositoryImpl.this.new c(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoreApi coreApi = CoreApiRepositoryImpl.this.api;
                this.a = 1;
                obj = coreApi.unixTime(this);
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

    public CoreApiRepositoryImpl(CoreApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // ru.yoomoney.sdk.auth.api.core.CoreApiRepository
    /* renamed from: getInstallationIdentifier-d1pmJ48 */
    public Object mo3244getInstallationIdentifierd1pmJ48() {
        return ((Result) BuildersKt__BuildersKt.runBlocking$default(null, new a(null), 1, null)).getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.core.CoreApiRepository
    /* renamed from: getUnixTime-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3245getUnixTimeIoAF18A(kotlin.coroutines.Continuation<? super kotlin.Result<ru.yoomoney.sdk.auth.api.core.model.UnixTime>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ru.yoomoney.sdk.auth.api.core.CoreApiRepositoryImpl.b
            if (r0 == 0) goto L13
            r0 = r5
            ru.yoomoney.sdk.auth.api.core.CoreApiRepositoryImpl$b r0 = (ru.yoomoney.sdk.auth.api.core.CoreApiRepositoryImpl.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.core.CoreApiRepositoryImpl$b r0 = new ru.yoomoney.sdk.auth.api.core.CoreApiRepositoryImpl$b
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
            ru.yoomoney.sdk.auth.api.core.CoreApiRepositoryImpl$c r5 = new ru.yoomoney.sdk.auth.api.core.CoreApiRepositoryImpl$c
            r2 = 0
            r5.<init>(r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r5, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.core.CoreApiRepositoryImpl.mo3245getUnixTimeIoAF18A(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
