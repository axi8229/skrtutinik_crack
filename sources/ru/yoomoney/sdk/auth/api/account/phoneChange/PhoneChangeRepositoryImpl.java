package ru.yoomoney.sdk.auth.api.account.phoneChange;

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
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeConfirmPhoneForgotResponse;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeConfirmPhoneRequest;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeConfirmPhoneResendResponse;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeConfirmPhoneResponse;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeSetPhoneRequest;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeSetPhoneResponse;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneSuccessResponse;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0016J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\fH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0005H\u0002J,\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020!H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeRepositoryImpl;", "Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeRepository;", "api", "Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeApi;", "token", "", "locationHeaderManager", "Lru/yoomoney/sdk/auth/location/LocationHeaderManager;", "(Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeApi;Ljava/lang/String;Lru/yoomoney/sdk/auth/location/LocationHeaderManager;)V", "getToken", "()Ljava/lang/String;", "confirmPhone", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeConfirmPhoneResponse;", "changePhoneProcessId", "request", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeConfirmPhoneRequest;", "confirmPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneForgot", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeConfirmPhoneForgotResponse;", "confirmPhoneForgot-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeConfirmPhoneResendResponse;", "confirmPhoneResend-gIAlu-s", "phone", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneSuccessResponse;", "phone-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareAuthorizationHeader", "setPhone", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeSetPhoneResponse;", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeSetPhoneRequest;", "setPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeSetPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneChangeRepositoryImpl implements PhoneChangeRepository {
    private final PhoneChangeApi api;
    private final LocationHeaderManager locationHeaderManager;
    private final String token;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl", f = "PhoneChangeRepositoryImpl.kt", l = {29}, m = "confirmPhone-0E7RQCE")
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
            Object objMo3233confirmPhone0E7RQCE = PhoneChangeRepositoryImpl.this.mo3233confirmPhone0E7RQCE(null, null, this);
            return objMo3233confirmPhone0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3233confirmPhone0E7RQCE : Result.m2627boximpl(objMo3233confirmPhone0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$confirmPhone$2", f = "PhoneChangeRepositoryImpl.kt", l = {30}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function1<Continuation<? super Result<? extends PhoneChangeConfirmPhoneResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ PhoneChangeConfirmPhoneRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, PhoneChangeConfirmPhoneRequest phoneChangeConfirmPhoneRequest, Continuation<? super b> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = phoneChangeConfirmPhoneRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PhoneChangeRepositoryImpl.this.new b(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PhoneChangeConfirmPhoneResponse>> continuation) {
            return ((b) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PhoneChangeApi phoneChangeApi = PhoneChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = PhoneChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                PhoneChangeConfirmPhoneRequest phoneChangeConfirmPhoneRequest = this.d;
                this.a = 1;
                obj = phoneChangeApi.confirmPhone(strPrepareAuthorizationHeader, str, phoneChangeConfirmPhoneRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl", f = "PhoneChangeRepositoryImpl.kt", l = {48}, m = "confirmPhoneForgot-gIAlu-s")
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
            Object objMo3234confirmPhoneForgotgIAlus = PhoneChangeRepositoryImpl.this.mo3234confirmPhoneForgotgIAlus(null, this);
            return objMo3234confirmPhoneForgotgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3234confirmPhoneForgotgIAlus : Result.m2627boximpl(objMo3234confirmPhoneForgotgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$confirmPhoneForgot$2", f = "PhoneChangeRepositoryImpl.kt", l = {49}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements Function1<Continuation<? super Result<? extends PhoneChangeConfirmPhoneForgotResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Continuation<? super d> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PhoneChangeRepositoryImpl.this.new d(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PhoneChangeConfirmPhoneForgotResponse>> continuation) {
            return PhoneChangeRepositoryImpl.this.new d(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PhoneChangeApi phoneChangeApi = PhoneChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = PhoneChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                this.a = 1;
                obj = phoneChangeApi.confirmPhoneForgot(strPrepareAuthorizationHeader, str, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl", f = "PhoneChangeRepositoryImpl.kt", l = {39}, m = "confirmPhoneResend-gIAlu-s")
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
            Object objMo3235confirmPhoneResendgIAlus = PhoneChangeRepositoryImpl.this.mo3235confirmPhoneResendgIAlus(null, this);
            return objMo3235confirmPhoneResendgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3235confirmPhoneResendgIAlus : Result.m2627boximpl(objMo3235confirmPhoneResendgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$confirmPhoneResend$2", f = "PhoneChangeRepositoryImpl.kt", l = {40}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements Function1<Continuation<? super Result<? extends PhoneChangeConfirmPhoneResendResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Continuation<? super f> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PhoneChangeRepositoryImpl.this.new f(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PhoneChangeConfirmPhoneResendResponse>> continuation) {
            return PhoneChangeRepositoryImpl.this.new f(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PhoneChangeApi phoneChangeApi = PhoneChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = PhoneChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                this.a = 1;
                obj = phoneChangeApi.confirmPhoneResend(strPrepareAuthorizationHeader, str, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl", f = "PhoneChangeRepositoryImpl.kt", l = {20}, m = "phone-IoAF18A")
    public static final class g extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3236phoneIoAF18A = PhoneChangeRepositoryImpl.this.mo3236phoneIoAF18A(this);
            return objMo3236phoneIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3236phoneIoAF18A : Result.m2627boximpl(objMo3236phoneIoAF18A);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$phone$2", f = "PhoneChangeRepositoryImpl.kt", l = {21}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements Function1<Continuation<? super Result<? extends PhoneSuccessResponse>>, Object> {
        public int a;

        public h(Continuation<? super h> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PhoneChangeRepositoryImpl.this.new h(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PhoneSuccessResponse>> continuation) {
            return PhoneChangeRepositoryImpl.this.new h(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PhoneChangeApi phoneChangeApi = PhoneChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = PhoneChangeRepositoryImpl.this.prepareAuthorizationHeader();
                this.a = 1;
                obj = phoneChangeApi.phone(strPrepareAuthorizationHeader, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl", f = "PhoneChangeRepositoryImpl.kt", l = {58}, m = "setPhone-0E7RQCE")
    public static final class i extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public i(Continuation<? super i> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3237setPhone0E7RQCE = PhoneChangeRepositoryImpl.this.mo3237setPhone0E7RQCE(null, null, this);
            return objMo3237setPhone0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3237setPhone0E7RQCE : Result.m2627boximpl(objMo3237setPhone0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$setPhone$2", f = "PhoneChangeRepositoryImpl.kt", l = {59}, m = "invokeSuspend")
    public static final class j extends SuspendLambda implements Function1<Continuation<? super Result<? extends PhoneChangeSetPhoneResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ PhoneChangeSetPhoneRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, PhoneChangeSetPhoneRequest phoneChangeSetPhoneRequest, Continuation<? super j> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = phoneChangeSetPhoneRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PhoneChangeRepositoryImpl.this.new j(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends PhoneChangeSetPhoneResponse>> continuation) {
            return ((j) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PhoneChangeApi phoneChangeApi = PhoneChangeRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = PhoneChangeRepositoryImpl.this.prepareAuthorizationHeader();
                String locationHeader = PhoneChangeRepositoryImpl.this.locationHeaderManager.getLocationHeader();
                String str = this.c;
                PhoneChangeSetPhoneRequest phoneChangeSetPhoneRequest = this.d;
                this.a = 1;
                obj = phoneChangeApi.setPhone(strPrepareAuthorizationHeader, locationHeader, str, phoneChangeSetPhoneRequest, this);
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

    public PhoneChangeRepositoryImpl(PhoneChangeApi api, String token, LocationHeaderManager locationHeaderManager) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(locationHeaderManager, "locationHeaderManager");
        this.api = api;
        this.token = token;
        this.locationHeaderManager = locationHeaderManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String prepareAuthorizationHeader() {
        return "Bearer " + getToken();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepository
    /* renamed from: confirmPhone-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3233confirmPhone0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeConfirmPhoneRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeConfirmPhoneResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl.a
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$a r0 = (ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$a r0 = new ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$a
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
            ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$b r7 = new ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$b
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl.mo3233confirmPhone0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeConfirmPhoneRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepository
    /* renamed from: confirmPhoneForgot-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3234confirmPhoneForgotgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeConfirmPhoneForgotResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl.c
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$c r0 = (ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$c r0 = new ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$c
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
            ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$d r6 = new ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$d
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl.mo3234confirmPhoneForgotgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepository
    /* renamed from: confirmPhoneResend-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3235confirmPhoneResendgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeConfirmPhoneResendResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl.e
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$e r0 = (ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$e r0 = new ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$e
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
            ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$f r6 = new ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$f
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl.mo3235confirmPhoneResendgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepository
    public String getToken() {
        return this.token;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepository
    /* renamed from: phone-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3236phoneIoAF18A(kotlin.coroutines.Continuation<? super kotlin.Result<ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneSuccessResponse>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl.g
            if (r0 == 0) goto L13
            r0 = r5
            ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$g r0 = (ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$g r0 = new ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$g
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
            ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$h r5 = new ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$h
            r2 = 0
            r5.<init>(r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r5, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl.mo3236phoneIoAF18A(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepository
    /* renamed from: setPhone-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3237setPhone0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeSetPhoneRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeSetPhoneResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl.i
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$i r0 = (ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl.i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$i r0 = new ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$i
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
            ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$j r7 = new ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl$j
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepositoryImpl.mo3237setPhone0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeSetPhoneRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
