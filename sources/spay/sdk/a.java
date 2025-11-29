package spay.sdk;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import npi.spay.B0;
import npi.spay.C1456a2;
import npi.spay.C1543de;
import npi.spay.C1604g0;
import npi.spay.C1686j8;
import npi.spay.C1697jj;
import npi.spay.C1795nh;
import npi.spay.C1822oj;
import npi.spay.C1876qn;
import npi.spay.C1937ta;
import npi.spay.C1951u;
import npi.spay.C1955u3;
import npi.spay.C1970ui;
import npi.spay.C1987va;
import npi.spay.C1993vg;
import npi.spay.C2064yc;
import npi.spay.E7;
import npi.spay.Ei;
import npi.spay.Ga;
import npi.spay.Ih;
import npi.spay.InterfaceC1495bg;
import npi.spay.InterfaceC1626gm;
import npi.spay.InterfaceC1728l0;
import npi.spay.InterfaceC1997vk;
import npi.spay.K2;
import npi.spay.Lj;
import npi.spay.Nk;
import npi.spay.Qb;
import npi.spay.U5;
import npi.spay.Z3;
import npi.spay.r;
import org.pjsip.pjsua2.pjsip_status_code;
import spay.sdk.data.dto.MerchantDataWithOrderId;
import spay.sdk.domain.model.response.SessionIdResponseBody;

/* loaded from: classes5.dex */
public final class a extends ViewModel {
    public static final /* synthetic */ int A = 0;
    public final Ei a;
    public final Ih b;
    public final C1543de c;
    public final E7 d;
    public final r e;
    public final Nk f;
    public final Lj g;
    public final U5 h;
    public final C1937ta i;
    public final C1697jj j;
    public final C1993vg k;
    public final InterfaceC1626gm l;
    public final InterfaceC1495bg m;
    public final B0 n;
    public final Qb o;
    public final Ga p;
    public final C1876qn q;
    public final C1955u3 r;
    public final InterfaceC1997vk s;
    public final C1951u t;
    public final C1970ui u;
    public final MutableStateFlow<C2064yc> v;
    public final MutableStateFlow<SessionIdResponseBody> w;
    public C1686j8 x;
    public final StateFlow<C2064yc> y;
    public final MutableStateFlow<C2064yc> z;

    @DebugMetadata(c = "spay.sdk.RedirectActivityViewModel$1", f = "RedirectActivityViewModel.kt", l = {pjsip_status_code.PJSIP_SC_RINGING, pjsip_status_code.PJSIP_SC_CALL_BEING_FORWARDED, pjsip_status_code.PJSIP_SC_QUEUED}, m = "invokeSuspend")
    /* renamed from: spay.sdk.a$a, reason: collision with other inner class name */
    public static final class C0357a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ a b;
        public final /* synthetic */ InterfaceC1728l0 c;

        /* renamed from: spay.sdk.a$a$a, reason: collision with other inner class name */
        public static final class C0358a<T> implements FlowCollector {
            public final /* synthetic */ a a;
            public final /* synthetic */ InterfaceC1728l0 b;

            public C0358a(a aVar, InterfaceC1728l0 interfaceC1728l0) {
                this.a = aVar;
                this.b = interfaceC1728l0;
            }

            /* JADX WARN: Removed duplicated region for block: B:89:0x01b6  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(java.lang.Object r19, kotlin.coroutines.Continuation r20) throws java.security.NoSuchAlgorithmException, android.content.pm.PackageManager.NameNotFoundException, java.io.IOException, java.lang.SecurityException, java.security.KeyStoreException, java.security.cert.CertificateException, java.security.KeyManagementException {
                /*
                    Method dump skipped, instructions count: 1498
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: spay.sdk.a.C0357a.C0358a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0357a(Continuation continuation, a aVar, InterfaceC1728l0 interfaceC1728l0) {
            super(2, continuation);
            this.b = aVar;
            this.c = interfaceC1728l0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C0357a(continuation, this.b, this.c);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0357a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0084 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L25
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 == r2) goto L19
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L19:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L85
            L1d:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L6d
            L21:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L41
            L25:
                kotlin.ResultKt.throwOnFailure(r6)
                spay.sdk.a r6 = r5.b
                r5.a = r4
                npi.spay.ui r6 = r6.u
                kotlinx.coroutines.Dispatchers.getIO()
                java.lang.Object r6 = r6.a()
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                if (r6 != r1) goto L3c
                goto L3e
            L3c:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
            L3e:
                if (r6 != r0) goto L41
                return r0
            L41:
                spay.sdk.a r6 = r5.b
                r5.a = r3
                npi.spay.Lj r6 = r6.g
                kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()
                r6.getClass()
                npi.spay.Kj r3 = new npi.spay.Kj
                r4 = 0
                r3.<init>(r6, r4)
                java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r1, r3, r5)
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                if (r6 != r1) goto L5f
                goto L61
            L5f:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
            L61:
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                if (r6 != r1) goto L68
                goto L6a
            L68:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
            L6a:
                if (r6 != r0) goto L6d
                return r0
            L6d:
                spay.sdk.a r6 = r5.b
                npi.spay.Ei r1 = r6.a
                npi.spay.oj r1 = (npi.spay.C1822oj) r1
                kotlinx.coroutines.flow.StateFlow r1 = r1.b
                spay.sdk.a$a$a r3 = new spay.sdk.a$a$a
                npi.spay.l0 r4 = r5.c
                r3.<init>(r6, r4)
                r5.a = r2
                java.lang.Object r6 = r1.collect(r3, r5)
                if (r6 != r0) goto L85
                return r0
            L85:
                kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
                r6.<init>()
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: spay.sdk.a.C0357a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "spay.sdk.RedirectActivityViewModel$bottomSheetShowEvent$1", f = "RedirectActivityViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function2<C1604g0, Continuation<? super C2064yc>, Object> {
        public /* synthetic */ Object a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = new b(continuation);
            bVar.a = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(C1604g0 c1604g0, Continuation<? super C2064yc> continuation) {
            return ((b) create(c1604g0, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            return new C2064yc(Boxing.boxBoolean(!(((C1604g0) this.a).a instanceof C1456a2)));
        }
    }

    @DebugMetadata(c = "spay.sdk.RedirectActivityViewModel", f = "RedirectActivityViewModel.kt", l = {pjsip_status_code.PJSIP_SC_BAD_LOCATION_INFORMATION}, m = "getSessionIdWithOrderId")
    public static final class c extends ContinuationImpl {
        public MerchantDataWithOrderId a;
        public /* synthetic */ Object b;
        public int d;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return a.this.a(this);
        }
    }

    @DebugMetadata(c = "spay.sdk.RedirectActivityViewModel", f = "RedirectActivityViewModel.kt", l = {441}, m = "getSessionIdWithPurchase")
    public static final class d extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return a.this.b(this);
        }
    }

    @DebugMetadata(c = "spay.sdk.RedirectActivityViewModel", f = "RedirectActivityViewModel.kt", l = {610}, m = "paymentTokenFraudMonReview")
    public static final class e extends ContinuationImpl {
        public a a;
        public /* synthetic */ Object b;
        public int d;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return a.this.c(this);
        }
    }

    public a(Ei sPayStorage, Ih sPayDataContract, C1543de getSessionIdWithOrderIdUseCase, C1795nh getSessionIdWithPurchaseUseCase, E7 getPaymentTokenWithOrderIdUseCase, C1987va getPaymentTokenWithPurchaseUseCase, r getPaymentOrderUseCase, Nk getPayOnlineUseCase, Lj checkDeviceUseCase, U5 getDeviceInfoUseCase, C1937ta getIpAddressUseCase, C1697jj orderScreenInteractor, C1993vg featuresHandler, InterfaceC1626gm bankAuthenticationContract, InterfaceC1495bg sPaySdkReducer, B0 getAuthWithOrderIdUseCase, Z3 getAuthWithPurchaseUseCase, Qb authHandler, Ga paymentTokenFraudMonReviewUseCase, InterfaceC1728l0 sPaySdkConfigRepository, C1876qn resourceManager, C1955u3 metricFacade, InterfaceC1997vk sslInteractor, C1951u lazyNetworkModule, C1970ui getLocalSessionIdUseCase) {
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(getSessionIdWithOrderIdUseCase, "getSessionIdWithOrderIdUseCase");
        Intrinsics.checkNotNullParameter(getSessionIdWithPurchaseUseCase, "getSessionIdWithPurchaseUseCase");
        Intrinsics.checkNotNullParameter(getPaymentTokenWithOrderIdUseCase, "getPaymentTokenWithOrderIdUseCase");
        Intrinsics.checkNotNullParameter(getPaymentTokenWithPurchaseUseCase, "getPaymentTokenWithPurchaseUseCase");
        Intrinsics.checkNotNullParameter(getPaymentOrderUseCase, "getPaymentOrderUseCase");
        Intrinsics.checkNotNullParameter(getPayOnlineUseCase, "getPayOnlineUseCase");
        Intrinsics.checkNotNullParameter(checkDeviceUseCase, "checkDeviceUseCase");
        Intrinsics.checkNotNullParameter(getDeviceInfoUseCase, "getDeviceInfoUseCase");
        Intrinsics.checkNotNullParameter(getIpAddressUseCase, "getIpAddressUseCase");
        Intrinsics.checkNotNullParameter(orderScreenInteractor, "orderScreenInteractor");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        Intrinsics.checkNotNullParameter(bankAuthenticationContract, "bankAuthenticationContract");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(getAuthWithOrderIdUseCase, "getAuthWithOrderIdUseCase");
        Intrinsics.checkNotNullParameter(getAuthWithPurchaseUseCase, "getAuthWithPurchaseUseCase");
        Intrinsics.checkNotNullParameter(authHandler, "authHandler");
        Intrinsics.checkNotNullParameter(paymentTokenFraudMonReviewUseCase, "paymentTokenFraudMonReviewUseCase");
        Intrinsics.checkNotNullParameter(sPaySdkConfigRepository, "sPaySdkConfigRepository");
        Intrinsics.checkNotNullParameter(resourceManager, "resourceManager");
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sslInteractor, "sslInteractor");
        Intrinsics.checkNotNullParameter(lazyNetworkModule, "lazyNetworkModule");
        Intrinsics.checkNotNullParameter(getLocalSessionIdUseCase, "getLocalSessionIdUseCase");
        this.a = sPayStorage;
        this.b = sPayDataContract;
        this.c = getSessionIdWithOrderIdUseCase;
        this.d = getPaymentTokenWithOrderIdUseCase;
        this.e = getPaymentOrderUseCase;
        this.f = getPayOnlineUseCase;
        this.g = checkDeviceUseCase;
        this.h = getDeviceInfoUseCase;
        this.i = getIpAddressUseCase;
        this.j = orderScreenInteractor;
        this.k = featuresHandler;
        this.l = bankAuthenticationContract;
        this.m = sPaySdkReducer;
        this.n = getAuthWithOrderIdUseCase;
        this.o = authHandler;
        this.p = paymentTokenFraudMonReviewUseCase;
        this.q = resourceManager;
        this.r = metricFacade;
        this.s = sslInteractor;
        this.t = lazyNetworkModule;
        this.u = getLocalSessionIdUseCase;
        this.v = StateFlowKt.MutableStateFlow(new C2064yc(K2.a));
        this.w = StateFlowKt.MutableStateFlow(new SessionIdResponseBody(null, null, null, null, null, null, null, null, null, null, 1023, null));
        this.y = FlowKt.stateIn(FlowKt.mapLatest(a(), new b(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), null);
        this.z = StateFlowKt.MutableStateFlow(null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C0357a(null, this, sPaySdkConfigRepository), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof spay.sdk.a.c
            if (r0 == 0) goto L13
            r0 = r11
            spay.sdk.a$c r0 = (spay.sdk.a.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            spay.sdk.a$c r0 = new spay.sdk.a$c
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            spay.sdk.data.dto.MerchantDataWithOrderId r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r11)
            goto L68
        L2b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L33:
            kotlin.ResultKt.throwOnFailure(r11)
            npi.spay.Ih r11 = r10.b
            npi.spay.Di r11 = (npi.spay.Di) r11
            spay.sdk.data.dto.MerchantDataWithOrderId r11 = r11.i
            if (r11 == 0) goto L6d
            npi.spay.de r2 = r10.c
            npi.spay.Ye r4 = new npi.spay.Ye
            java.lang.String r5 = r11.getAuthorization()
            spay.sdk.domain.model.request.SessionIdWithOrderIdRequestBody r6 = new spay.sdk.domain.model.request.SessionIdWithOrderIdRequestBody
            java.lang.String r7 = r11.getMerchantLogin()
            java.lang.String r8 = r11.getOrderId()
            java.lang.String r9 = "spaysdk://payment"
            r6.<init>(r9, r7, r8)
            r4.<init>(r5, r6)
            r0.a = r11
            r0.d = r3
            kotlinx.coroutines.CoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getIO()
            java.lang.Object r0 = r2.a(r4, r3, r0)
            if (r0 != r1) goto L67
            return r1
        L67:
            r0 = r11
        L68:
            if (r0 == 0) goto L6d
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L6d:
            npi.spay.l6 r11 = npi.spay.C1734l6.a
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: spay.sdk.a.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof spay.sdk.a.d
            if (r0 == 0) goto L13
            r0 = r5
            spay.sdk.a$d r0 = (spay.sdk.a.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            spay.sdk.a$d r0 = new spay.sdk.a$d
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r0.c
            if (r0 == 0) goto L30
            r1 = 1
            if (r0 != r1) goto L28
            kotlin.ResultKt.throwOnFailure(r5)
            goto L38
        L28:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L30:
            kotlin.ResultKt.throwOnFailure(r5)
            npi.spay.Ih r5 = r4.b
            r5.getClass()
        L38:
            npi.spay.l6 r5 = npi.spay.C1734l6.a
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: spay.sdk.a.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r1 instanceof spay.sdk.a.e
            if (r2 == 0) goto L17
            r2 = r1
            spay.sdk.a$e r2 = (spay.sdk.a.e) r2
            int r3 = r2.d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.d = r3
            goto L1c
        L17:
            spay.sdk.a$e r2 = new spay.sdk.a$e
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.b
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.d
            r5 = 1
            if (r4 == 0) goto L37
            if (r4 != r5) goto L2f
            spay.sdk.a r2 = r2.a
            kotlin.ResultKt.throwOnFailure(r1)
            goto L81
        L2f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L37:
            kotlin.ResultKt.throwOnFailure(r1)
            npi.spay.j8 r1 = r0.x
            if (r1 == 0) goto L80
            npi.spay.Ga r4 = r0.p
            java.lang.String r6 = r1.a
            spay.sdk.domain.model.request.PaymentTokenWithOrderIdRequestBody r7 = r1.b
            npi.spay.Ih r1 = r0.b
            npi.spay.Di r1 = (npi.spay.Di) r1
            spay.sdk.domain.model.FraudMonInfo r14 = r1.q
            r15 = 63
            r16 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            spay.sdk.domain.model.request.PaymentTokenWithOrderIdRequestBody r1 = spay.sdk.domain.model.request.PaymentTokenWithOrderIdRequestBody.copy$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            java.lang.String r7 = "authorization"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r7)
            java.lang.String r7 = "paymentTokenWithOrderIdRequestBody"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r7)
            r2.a = r0
            r2.d = r5
            kotlinx.coroutines.Dispatchers.getIO()
            r4.getClass()
            npi.spay.yl r4 = r4.a
            npi.spay.Hm r4 = (npi.spay.Hm) r4
            java.lang.Object r1 = r4.b(r6, r1, r2)
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r1 != r2) goto L7b
            goto L7d
        L7b:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L7d:
            if (r1 != r3) goto L80
            return r3
        L80:
            r2 = r0
        L81:
            npi.spay.bg r1 = r2.m
            npi.spay.un r2 = npi.spay.C1975un.a
            npi.spay.Jh r1 = (npi.spay.Jh) r1
            r1.a(r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: spay.sdk.a.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(spay.sdk.a r4, kotlin.coroutines.Continuation r5) {
        /*
            r4.getClass()
            boolean r0 = r5 instanceof npi.spay.L7
            if (r0 == 0) goto L16
            r0 = r5
            npi.spay.L7 r0 = (npi.spay.L7) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.c = r1
            goto L1b
        L16:
            npi.spay.L7 r0 = new npi.spay.L7
            r0.<init>(r4, r5)
        L1b:
            java.lang.Object r5 = r0.a
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r0.c
            if (r0 == 0) goto L33
            r4 = 1
            if (r0 != r4) goto L2b
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3b
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            npi.spay.Ih r4 = r4.b
            r4.getClass()
        L3b:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: spay.sdk.a.b(spay.sdk.a, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(spay.sdk.a r10, kotlin.coroutines.Continuation r11) {
        /*
            r10.getClass()
            boolean r0 = r11 instanceof npi.spay.C1461a7
            if (r0 == 0) goto L16
            r0 = r11
            npi.spay.a7 r0 = (npi.spay.C1461a7) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.c = r1
            goto L1b
        L16:
            npi.spay.a7 r0 = new npi.spay.a7
            r0.<init>(r10, r11)
        L1b:
            java.lang.Object r11 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lc3
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            kotlin.ResultKt.throwOnFailure(r11)
            npi.spay.Ih r11 = r10.b
            npi.spay.Di r11 = (npi.spay.Di) r11
            spay.sdk.data.dto.MerchantDataWithOrderId r11 = r11.i
            if (r11 == 0) goto Lc3
            npi.spay.Uk r2 = new npi.spay.Uk
            kotlinx.coroutines.flow.MutableStateFlow<spay.sdk.domain.model.response.SessionIdResponseBody> r4 = r10.w
            kotlinx.coroutines.flow.StateFlow r4 = kotlinx.coroutines.flow.FlowKt.asStateFlow(r4)
            java.lang.Object r4 = r4.getValue()
            spay.sdk.domain.model.response.SessionIdResponseBody r4 = (spay.sdk.domain.model.response.SessionIdResponseBody) r4
            java.lang.String r4 = r4.getSessionId()
            java.lang.String r5 = r11.getMerchantLogin()
            java.lang.String r6 = r11.getOrderId()
            spay.sdk.domain.model.request.ListOfCardsWithOrderIdRequestBody r7 = new spay.sdk.domain.model.request.ListOfCardsWithOrderIdRequestBody
            r8 = 0
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            r7.<init>(r4, r5, r8, r6)
            npi.spay.vg r4 = r10.k
            npi.spay.h r5 = npi.spay.EnumC1628h.BNPL
            r4.getClass()
            java.lang.String r6 = "tag"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            java.util.Map r4 = r4.c
            java.lang.Object r4 = r4.get(r5)
            npi.spay.zc r4 = (npi.spay.InterfaceC2089zc) r4
            r5 = 0
            if (r4 == 0) goto La7
            npi.spay.s6 r6 = npi.spay.EnumC1908s6.BY_SYSTEM
            java.lang.Object r4 = r4.a(r6)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 != r3) goto La7
            spay.sdk.domain.model.request.PaymentBnplPlanRequestBody r4 = new spay.sdk.domain.model.request.PaymentBnplPlanRequestBody
            kotlinx.coroutines.flow.MutableStateFlow<spay.sdk.domain.model.response.SessionIdResponseBody> r6 = r10.w
            kotlinx.coroutines.flow.StateFlow r6 = kotlinx.coroutines.flow.FlowKt.asStateFlow(r6)
            java.lang.Object r6 = r6.getValue()
            spay.sdk.domain.model.response.SessionIdResponseBody r6 = (spay.sdk.domain.model.response.SessionIdResponseBody) r6
            java.lang.String r6 = r6.getSessionId()
            java.lang.String r8 = r11.getMerchantLogin()
            java.lang.String r9 = r11.getOrderId()
            r4.<init>(r6, r8, r9)
            goto La8
        La7:
            r4 = r5
        La8:
            java.lang.String r11 = r11.getAuthorization()
            r2.<init>(r7, r5, r4, r11)
            npi.spay.Ih r11 = r10.b
            r11.getClass()
            npi.spay.jj r10 = r10.j
            r0.c = r3
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()
            java.lang.Object r10 = r10.a(r2, r11, r0)
            if (r10 != r1) goto Lc3
            goto Lc5
        Lc3:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        Lc5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: spay.sdk.a.a(spay.sdk.a, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(spay.sdk.a r3, sberid.sdk.auth.model.SberIDResultModel r4, kotlin.coroutines.Continuation r5) {
        /*
            r3.getClass()
            boolean r4 = r5 instanceof npi.spay.Be
            if (r4 == 0) goto L16
            r4 = r5
            npi.spay.Be r4 = (npi.spay.Be) r4
            int r0 = r4.c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L16
            int r0 = r0 - r1
            r4.c = r0
            goto L1b
        L16:
            npi.spay.Be r4 = new npi.spay.Be
            r4.<init>(r3, r5)
        L1b:
            java.lang.Object r5 = r4.a
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r4.c
            if (r4 == 0) goto L3d
            r3 = 1
            if (r4 == r3) goto L36
            r3 = 2
            if (r4 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r5)
            goto L45
        L2e:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.String r5 = (java.lang.String) r5
            r3 = 0
            throw r3
        L3d:
            kotlin.ResultKt.throwOnFailure(r5)
            npi.spay.Ih r3 = r3.b
            r3.getClass()
        L45:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: spay.sdk.a.b(spay.sdk.a, sberid.sdk.auth.model.SberIDResultModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(spay.sdk.a r2, spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody.PaymentToolInfo.Tool r3, boolean r4, kotlin.coroutines.Continuation r5) {
        /*
            r2.getClass()
            boolean r3 = r5 instanceof npi.spay.Ha
            if (r3 == 0) goto L16
            r3 = r5
            npi.spay.Ha r3 = (npi.spay.Ha) r3
            int r4 = r3.c
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L16
            int r4 = r4 - r0
            r3.c = r4
            goto L1b
        L16:
            npi.spay.Ha r3 = new npi.spay.Ha
            r3.<init>(r2, r5)
        L1b:
            java.lang.Object r4 = r3.a
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r3.c
            if (r3 == 0) goto L3d
            r2 = 1
            if (r3 == r2) goto L36
            r2 = 2
            if (r3 != r2) goto L2e
            kotlin.ResultKt.throwOnFailure(r4)
            goto L45
        L2e:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
            r2.<init>(r3)
            throw r2
        L36:
            kotlin.ResultKt.throwOnFailure(r4)
            java.lang.String r4 = (java.lang.String) r4
            r2 = 0
            throw r2
        L3d:
            kotlin.ResultKt.throwOnFailure(r4)
            npi.spay.Ih r2 = r2.b
            r2.getClass()
        L45:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: spay.sdk.a.b(spay.sdk.a, spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(spay.sdk.a r18, sberid.sdk.auth.model.SberIDResultModel r19, kotlin.coroutines.Continuation r20) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: spay.sdk.a.a(spay.sdk.a, sberid.sdk.auth.model.SberIDResultModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(spay.sdk.a r19, spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody.PaymentToolInfo.Tool r20, boolean r21, kotlin.coroutines.Continuation r22) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: spay.sdk.a.a(spay.sdk.a, spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody$PaymentToolInfo$Tool, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final StateFlow<C1604g0> a() {
        return ((C1822oj) this.a).b;
    }
}
