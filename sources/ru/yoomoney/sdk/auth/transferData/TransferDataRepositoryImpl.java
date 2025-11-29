package ru.yoomoney.sdk.auth.transferData;

import android.util.Log;
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
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.TechnicalFailure;
import ru.yoomoney.sdk.auth.api.sessionTicket.SessionTicketRepository;
import ru.yoomoney.sdk.auth.api.sessionTicket.method.SessionTicketResponse;
import ru.yoomoney.sdk.auth.api.sessionTicket.method.SessionTicketVerifyRequest;
import ru.yoomoney.sdk.auth.api.sessionTicket.method.SessionTicketVerifyResponse;
import ru.yoomoney.sdk.auth.utils.CipherChaCha20Poly1305Kt;
import ru.yoomoney.sdk.auth.utils.DecodedCryptogram;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JI\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\"\u0010\t\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b0\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0014\u001a\u00020\u000fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/transferData/TransferDataRepositoryImpl;", "Lru/yoomoney/sdk/auth/transferData/TransferDataRepository;", "sessionTicketRepository", "Lru/yoomoney/sdk/auth/api/sessionTicket/SessionTicketRepository;", "(Lru/yoomoney/sdk/auth/api/sessionTicket/SessionTicketRepository;)V", "executeBlocking", "Lkotlin/Result;", "T", "", "function", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "executeBlocking-IoAF18A", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getData", "", YooMoneyAuth.KEY_CRYPTOGRAM, "getData-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "prepareData", "json", "prepareData-IoAF18A", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TransferDataRepositoryImpl implements TransferDataRepository {
    private final SessionTicketRepository sessionTicketRepository;

    /* JADX INFO: Add missing generic type declarations: [T] */
    @DebugMetadata(c = "ru.yoomoney.sdk.auth.transferData.TransferDataRepositoryImpl$executeBlocking$1", f = "TransferDataRepositoryImpl.kt", l = {57}, m = "invokeSuspend")
    public static final class a<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends T>>, Object> {
        public int a;
        public final /* synthetic */ Function1<Continuation<? super Result<? extends T>>, Object> b;

        @DebugMetadata(c = "ru.yoomoney.sdk.auth.transferData.TransferDataRepositoryImpl$executeBlocking$1$1", f = "TransferDataRepositoryImpl.kt", l = {57}, m = "invokeSuspend")
        /* renamed from: ru.yoomoney.sdk.auth.transferData.TransferDataRepositoryImpl$a$a, reason: collision with other inner class name */
        public static final class C0306a extends SuspendLambda implements Function1<Continuation<? super Result<? extends T>>, Object> {
            public int a;
            public final /* synthetic */ Function1<Continuation<? super Result<? extends T>>, Object> b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0306a(Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, Continuation<? super C0306a> continuation) {
                super(1, continuation);
                this.b = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C0306a(this.b, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return new C0306a(this.b, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function1<Continuation<? super Result<? extends T>>, Object> function1 = this.b;
                    this.a = 1;
                    obj = function1.invoke(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return obj;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Object obj) {
            return new a(this.b, (Continuation) obj).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objExecuteWithResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C0306a c0306a = new C0306a(this.b, null);
                this.a = 1;
                objExecuteWithResult = ApiV2ExtentionsKt.executeWithResult(c0306a, this);
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
            return Result.m2627boximpl(objExecuteWithResult);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.transferData.TransferDataRepositoryImpl$getData$1", f = "TransferDataRepositoryImpl.kt", l = {50}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function1<Continuation<? super Result<? extends String>>, Object> {
        public DecodedCryptogram a;
        public int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ TransferDataRepositoryImpl d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Continuation continuation, TransferDataRepositoryImpl transferDataRepositoryImpl) {
            super(1, continuation);
            this.c = str;
            this.d = transferDataRepositoryImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new b(this.c, continuation, this.d);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends String>> continuation) {
            return new b(this.c, continuation, this.d).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IllegalStateException {
            DecodedCryptogram decodedCryptogram;
            Object value;
            Object objCreateFailure;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DecodedCryptogram decodedCryptogramDecodeCryptogram = CipherChaCha20Poly1305Kt.decodeCryptogram(this.c);
                SessionTicketRepository sessionTicketRepository = this.d.sessionTicketRepository;
                SessionTicketVerifyRequest sessionTicketVerifyRequest = new SessionTicketVerifyRequest(decodedCryptogramDecodeCryptogram.getSessionTicket());
                this.a = decodedCryptogramDecodeCryptogram;
                this.b = 1;
                Object objMo3302verifygIAlus = sessionTicketRepository.mo3302verifygIAlus(sessionTicketVerifyRequest, this);
                if (objMo3302verifygIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                decodedCryptogram = decodedCryptogramDecodeCryptogram;
                value = objMo3302verifygIAlus;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                decodedCryptogram = this.a;
                ResultKt.throwOnFailure(obj);
                value = ((Result) obj).getValue();
            }
            Throwable thM2631exceptionOrNullimpl = Result.m2631exceptionOrNullimpl(value);
            if (thM2631exceptionOrNullimpl == null) {
                objCreateFailure = CipherChaCha20Poly1305Kt.decryptCryptogram(decodedCryptogram, ((SessionTicketVerifyResponse) value).getSecret());
            } else {
                Intrinsics.checkNotNull(thM2631exceptionOrNullimpl, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure");
                objCreateFailure = ResultKt.createFailure((Failure) thM2631exceptionOrNullimpl);
            }
            return Result.m2627boximpl(Result.m2628constructorimpl(objCreateFailure));
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.transferData.TransferDataRepositoryImpl$prepareData$1", f = "TransferDataRepositoryImpl.kt", l = {}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements Function1<Continuation<? super Result<? extends String>>, Object> {
        public final /* synthetic */ TransferDataRepositoryImpl a;
        public final /* synthetic */ String b;

        public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Continuation<? super Result<? extends SessionTicketResponse>>, Object> {
            public a(SessionTicketRepository sessionTicketRepository) {
                super(1, sessionTicketRepository, SessionTicketRepository.class, "sessionTicket", "sessionTicket-IoAF18A(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Result<? extends SessionTicketResponse>> continuation) {
                Object objMo3301sessionTicketIoAF18A = ((SessionTicketRepository) this.receiver).mo3301sessionTicketIoAF18A(continuation);
                return objMo3301sessionTicketIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3301sessionTicketIoAF18A : Result.m2627boximpl(objMo3301sessionTicketIoAF18A);
            }
        }

        @DebugMetadata(c = "ru.yoomoney.sdk.auth.transferData.TransferDataRepositoryImpl$prepareData$1$2$1", f = "TransferDataRepositoryImpl.kt", l = {23}, m = "invokeSuspend")
        public static final class b extends SuspendLambda implements Function1<Continuation<? super Result<? extends SessionTicketVerifyResponse>>, Object> {
            public int a;
            public final /* synthetic */ TransferDataRepositoryImpl b;
            public final /* synthetic */ String c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, Continuation continuation, TransferDataRepositoryImpl transferDataRepositoryImpl) {
                super(1, continuation);
                this.b = transferDataRepositoryImpl;
                this.c = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new b(this.c, continuation, this.b);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Result<? extends SessionTicketVerifyResponse>> continuation) {
                TransferDataRepositoryImpl transferDataRepositoryImpl = this.b;
                return new b(this.c, continuation, transferDataRepositoryImpl).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object objMo3302verifygIAlus;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SessionTicketRepository sessionTicketRepository = this.b.sessionTicketRepository;
                    SessionTicketVerifyRequest sessionTicketVerifyRequest = new SessionTicketVerifyRequest(this.c);
                    this.a = 1;
                    objMo3302verifygIAlus = sessionTicketRepository.mo3302verifygIAlus(sessionTicketVerifyRequest, this);
                    if (objMo3302verifygIAlus == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    objMo3302verifygIAlus = ((Result) obj).getValue();
                }
                return Result.m2627boximpl(objMo3302verifygIAlus);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Continuation continuation, TransferDataRepositoryImpl transferDataRepositoryImpl) {
            super(1, continuation);
            this.a = transferDataRepositoryImpl;
            this.b = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new c(this.b, continuation, this.a);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends String>> continuation) {
            TransferDataRepositoryImpl transferDataRepositoryImpl = this.a;
            return new c(this.b, continuation, transferDataRepositoryImpl).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objCreateFailure;
            Object objM2628constructorimpl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            Object objM3351executeBlockingIoAF18A = this.a.m3351executeBlockingIoAF18A(new a(this.a.sessionTicketRepository));
            TransferDataRepositoryImpl transferDataRepositoryImpl = this.a;
            String str = this.b;
            Throwable thM2631exceptionOrNullimpl = Result.m2631exceptionOrNullimpl(objM3351executeBlockingIoAF18A);
            if (thM2631exceptionOrNullimpl == null) {
                String sessionTicket = ((SessionTicketResponse) objM3351executeBlockingIoAF18A).getSessionTicket();
                Object objM3351executeBlockingIoAF18A2 = transferDataRepositoryImpl.m3351executeBlockingIoAF18A(new b(sessionTicket, null, transferDataRepositoryImpl));
                Throwable thM2631exceptionOrNullimpl2 = Result.m2631exceptionOrNullimpl(objM3351executeBlockingIoAF18A2);
                if (thM2631exceptionOrNullimpl2 == null) {
                    try {
                        objM2628constructorimpl = Result.m2628constructorimpl(CipherChaCha20Poly1305Kt.encryptCryptogram(str, sessionTicket, ((SessionTicketVerifyResponse) objM3351executeBlockingIoAF18A2).getSecret()));
                    } catch (Throwable th) {
                        Log.e("", "Could not prepare data", th);
                        Result.Companion companion = Result.INSTANCE;
                        objCreateFailure = ResultKt.createFailure(new TechnicalFailure(null, 1, null));
                    }
                    return Result.m2627boximpl(objM2628constructorimpl);
                }
                Intrinsics.checkNotNull(thM2631exceptionOrNullimpl2, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure");
                objCreateFailure = ResultKt.createFailure((Failure) thM2631exceptionOrNullimpl2);
            } else {
                Intrinsics.checkNotNull(thM2631exceptionOrNullimpl, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure");
                objCreateFailure = ResultKt.createFailure((Failure) thM2631exceptionOrNullimpl);
            }
            objM2628constructorimpl = Result.m2628constructorimpl(objCreateFailure);
            return Result.m2627boximpl(objM2628constructorimpl);
        }
    }

    public TransferDataRepositoryImpl(SessionTicketRepository sessionTicketRepository) {
        Intrinsics.checkNotNullParameter(sessionTicketRepository, "sessionTicketRepository");
        this.sessionTicketRepository = sessionTicketRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: executeBlocking-IoAF18A, reason: not valid java name */
    public final <T> Object m3351executeBlockingIoAF18A(Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function) {
        return ((Result) BuildersKt__BuildersKt.runBlocking$default(null, new a(function, null), 1, null)).getValue();
    }

    @Override // ru.yoomoney.sdk.auth.transferData.TransferDataRepository
    /* renamed from: getData-IoAF18A */
    public Object mo3348getDataIoAF18A(String cryptogram) {
        Intrinsics.checkNotNullParameter(cryptogram, "cryptogram");
        return m3351executeBlockingIoAF18A(new b(cryptogram, null, this));
    }

    @Override // ru.yoomoney.sdk.auth.transferData.TransferDataRepository
    /* renamed from: prepareData-IoAF18A */
    public Object mo3349prepareDataIoAF18A(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        return m3351executeBlockingIoAF18A(new c(json, null, this));
    }
}
