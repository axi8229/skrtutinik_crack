package com.sputnik.oboarding.ui.registration.viewmodel;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.connect_intercom.DomainActivationCode;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.usecases.registration.GetIntercomCodeForRegUseCase;
import com.sputnik.oboarding.mappers.connect_intercom.DomainActivationCodeToActivationCodeMapper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: ConnectIntercomViewModel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001aB\u0019\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/viewmodel/ConnectIntercomViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/oboarding/ui/registration/viewmodel/ConnectIntercomViewState;", "", "Lcom/sputnik/domain/usecases/registration/GetIntercomCodeForRegUseCase;", "getIntercomCodeForRegUseCase", "Lcom/sputnik/oboarding/mappers/connect_intercom/DomainActivationCodeToActivationCodeMapper;", "domainActivationCodeToActivationCodeMapper", "<init>", "(Lcom/sputnik/domain/usecases/registration/GetIntercomCodeForRegUseCase;Lcom/sputnik/oboarding/mappers/connect_intercom/DomainActivationCodeToActivationCodeMapper;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/connect_intercom/DomainActivationCode;", "getCodeForIntercom", "()Landroidx/lifecycle/LiveData;", "Lkotlinx/coroutines/Job;", "startNewTimer", "()Lkotlinx/coroutines/Job;", "", "startIntercomTimer", "()V", "connectToIntercom", "Lcom/sputnik/domain/usecases/registration/GetIntercomCodeForRegUseCase;", "Lcom/sputnik/oboarding/mappers/connect_intercom/DomainActivationCodeToActivationCodeMapper;", "countDownJob", "Lkotlinx/coroutines/Job;", "Companion", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConnectIntercomViewModel extends BaseViewModel<ConnectIntercomViewState> {
    private Job countDownJob;
    private final DomainActivationCodeToActivationCodeMapper domainActivationCodeToActivationCodeMapper;
    private final GetIntercomCodeForRegUseCase getIntercomCodeForRegUseCase;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int COUNTDOWN_INTERCOM_TIME = 300;

    public ConnectIntercomViewModel(GetIntercomCodeForRegUseCase getIntercomCodeForRegUseCase, DomainActivationCodeToActivationCodeMapper domainActivationCodeToActivationCodeMapper) {
        Intrinsics.checkNotNullParameter(getIntercomCodeForRegUseCase, "getIntercomCodeForRegUseCase");
        Intrinsics.checkNotNullParameter(domainActivationCodeToActivationCodeMapper, "domainActivationCodeToActivationCodeMapper");
        ConnectIntercomViewState connectIntercomViewState = new ConnectIntercomViewState(null, null, null, 0, 15, null);
        String name = ConnectIntercomViewModel.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        super(connectIntercomViewState, name);
        this.getIntercomCodeForRegUseCase = getIntercomCodeForRegUseCase;
        this.domainActivationCodeToActivationCodeMapper = domainActivationCodeToActivationCodeMapper;
        connectToIntercom();
    }

    private final LiveData<Resource<DomainActivationCode>> getCodeForIntercom() {
        return FlowLiveDataConversions.asLiveData$default(this.getIntercomCodeForRegUseCase.invoke(), null, 0L, 3, null);
    }

    /* compiled from: ConnectIntercomViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/viewmodel/ConnectIntercomViewModel$Companion;", "", "()V", "COUNTDOWN_INTERCOM_TIME", "", "getCOUNTDOWN_INTERCOM_TIME", "()I", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getCOUNTDOWN_INTERCOM_TIME() {
            return ConnectIntercomViewModel.COUNTDOWN_INTERCOM_TIME;
        }
    }

    /* compiled from: ConnectIntercomViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel$startNewTimer$1", f = "ConnectIntercomViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel$startNewTimer$1, reason: invalid class name and case insensitive filesystem */
    static final class C07661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07661(Continuation<? super C07661> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConnectIntercomViewModel.this.new C07661(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ConnectIntercomViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel$startNewTimer$1$1", f = "ConnectIntercomViewModel.kt", l = {43}, m = "invokeSuspend")
        /* renamed from: com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel$startNewTimer$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ConnectIntercomViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02771(ConnectIntercomViewModel connectIntercomViewModel, Continuation<? super C02771> continuation) {
                super(2, continuation);
                this.this$0 = connectIntercomViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02771(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0037 -> B:14:0x003a). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                /*
                    r11 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r11.label
                    r2 = 0
                    r3 = 1
                    if (r1 == 0) goto L18
                    if (r1 != r3) goto L10
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L3a
                L10:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r0)
                    throw r12
                L18:
                    kotlin.ResultKt.throwOnFailure(r12)
                L1b:
                    com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel r12 = r11.this$0
                    com.sputnik.common.base.VMState r12 = r12.getCurrentState()
                    com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewState r12 = (com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewState) r12
                    int r12 = r12.getCount()
                    com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel$Companion r1 = com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel.INSTANCE
                    int r1 = r1.getCOUNTDOWN_INTERCOM_TIME()
                    if (r12 > r1) goto L6e
                    r11.label = r3
                    r4 = 1000(0x3e8, double:4.94E-321)
                    java.lang.Object r12 = kotlinx.coroutines.DelayKt.delay(r4, r11)
                    if (r12 != r0) goto L3a
                    return r0
                L3a:
                    com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel r12 = r11.this$0
                    com.sputnik.common.base.VMState r1 = r12.getCurrentState()
                    r4 = r1
                    com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewState r4 = (com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewState) r4
                    com.sputnik.common.base.VMState r1 = r12.getCurrentState()
                    com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewState r1 = (com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewState) r1
                    int r1 = r1.getCount()
                    int r8 = r1 + 1
                    r9 = 7
                    r10 = 0
                    r5 = 0
                    r6 = 0
                    r7 = 0
                    com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewState r1 = com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewState.copy$default(r4, r5, r6, r7, r8, r9, r10)
                    kotlinx.coroutines.CoroutineScope r4 = androidx.lifecycle.ViewModelKt.getViewModelScope(r12)
                    com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel$startNewTimer$1$1$invokeSuspend$$inlined$updateState$1 r7 = new com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel$startNewTimer$1$1$invokeSuspend$$inlined$updateState$1
                    r7.<init>(r1, r12, r2)
                    r8 = 3
                    r9 = 0
                    kotlinx.coroutines.BuildersKt.launch$default(r4, r5, r6, r7, r8, r9)
                    androidx.lifecycle.MediatorLiveData r12 = r12.getState()
                    r12.setValue(r1)
                    goto L1b
                L6e:
                    com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel r12 = r11.this$0
                    r12.connectToIntercom()
                    com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel r12 = r11.this$0
                    com.sputnik.common.base.VMState r0 = r12.getCurrentState()
                    r3 = r0
                    com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewState r3 = (com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewState) r3
                    r8 = 7
                    r9 = 0
                    r4 = 0
                    r5 = 0
                    r6 = 0
                    r7 = 0
                    com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewState r0 = com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewState.copy$default(r3, r4, r5, r6, r7, r8, r9)
                    kotlinx.coroutines.CoroutineScope r3 = androidx.lifecycle.ViewModelKt.getViewModelScope(r12)
                    com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel$startNewTimer$1$1$invokeSuspend$$inlined$updateState$2 r6 = new com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel$startNewTimer$1$1$invokeSuspend$$inlined$updateState$2
                    r6.<init>(r0, r12, r2)
                    r7 = 3
                    r8 = 0
                    kotlinx.coroutines.BuildersKt.launch$default(r3, r4, r5, r6, r7, r8)
                    androidx.lifecycle.MediatorLiveData r12 = r12.getState()
                    r12.setValue(r0)
                    com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel r12 = r11.this$0
                    com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel.access$setCountDownJob$p(r12, r2)
                    kotlin.Unit r12 = kotlin.Unit.INSTANCE
                    return r12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel.C07661.C02771.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C02771(ConnectIntercomViewModel.this, null), 3, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final Job startNewTimer() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07661(null), 3, null);
    }

    public void startIntercomTimer() {
        if (this.countDownJob == null) {
            this.countDownJob = startNewTimer();
        }
    }

    public void connectToIntercom() {
        subscribeOnDataSource(getCodeForIntercom(), new Function2<Resource<? extends DomainActivationCode>, ConnectIntercomViewState, ConnectIntercomViewState>() { // from class: com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel.connectToIntercom.1

            /* compiled from: ConnectIntercomViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel$connectToIntercom$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.NONE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ ConnectIntercomViewState invoke(Resource<? extends DomainActivationCode> resource, ConnectIntercomViewState connectIntercomViewState) {
                return invoke2((Resource<DomainActivationCode>) resource, connectIntercomViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ConnectIntercomViewState invoke2(Resource<DomainActivationCode> serverData, ConnectIntercomViewState state) {
                String strValueOf;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return ConnectIntercomViewState.copy$default(state, Resource.Status.LOADING, null, null, 0, 14, null);
                }
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Job job = ConnectIntercomViewModel.this.countDownJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, null, 1, null);
                    }
                    ConnectIntercomViewModel.this.startIntercomTimer();
                    Resource.Status status = Resource.Status.SUCCESS;
                    DomainActivationCode data = serverData.getData();
                    return ConnectIntercomViewState.copy$default(state, status, data != null ? ConnectIntercomViewModel.this.domainActivationCodeToActivationCodeMapper.map(data) : null, null, 0, 12, null);
                }
                ConnectIntercomViewModel connectIntercomViewModel = ConnectIntercomViewModel.this;
                DomainEmpty errorMsg = serverData.getErrorMsg();
                if (errorMsg == null || (strValueOf = errorMsg.getError()) == null) {
                    strValueOf = String.valueOf(serverData.getError());
                }
                connectIntercomViewModel.notifyErrorMessage(strValueOf);
                Job job2 = ConnectIntercomViewModel.this.countDownJob;
                if (job2 != null) {
                    Job.DefaultImpls.cancel$default(job2, null, 1, null);
                }
                return ConnectIntercomViewState.copy$default(state, Resource.Status.ERROR, null, null, 0, 14, null);
            }
        });
    }
}
