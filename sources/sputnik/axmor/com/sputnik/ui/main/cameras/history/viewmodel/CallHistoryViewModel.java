package sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.PagingData;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.api.FailedBinderCallBack;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.call.DomainCall;
import com.sputnik.domain.entities.call_history.DomainCallHistory;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.subscriptions.analytics.OnlySubscriptionEvents;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import sputnik.axmor.com.sputnik.di.use_cases.call_history.DeleteCallHistoryUseCase;
import sputnik.axmor.com.sputnik.di.use_cases.call_history.GetCallHistoryUseCase;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistory;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistoryUi;
import sputnik.axmor.com.sputnik.mappers.call_history.DomainCallHistoryToCallHistoryMapper;

/* compiled from: CallHistoryViewModel.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001/B;\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00132\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010 R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010!R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\"R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010#R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010$R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010%R \u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040'0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R \u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00060"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/history/viewmodel/CallHistoryViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lsputnik/axmor/com/sputnik/ui/main/cameras/history/viewmodel/CallHistoryViewState;", "", "", "localization", "Lsputnik/axmor/com/sputnik/di/use_cases/call_history/GetCallHistoryUseCase;", "loadCallHistoryByPagingUseCase", "Lsputnik/axmor/com/sputnik/di/use_cases/call_history/DeleteCallHistoryUseCase;", "deleteCallFromHistoryUseCase", "Lsputnik/axmor/com/sputnik/mappers/call_history/DomainCallHistoryToCallHistoryMapper;", "domainCallHistoryToCallHistoryMapper", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "<init>", "(Ljava/lang/String;Lsputnik/axmor/com/sputnik/di/use_cases/call_history/GetCallHistoryUseCase;Lsputnik/axmor/com/sputnik/di/use_cases/call_history/DeleteCallHistoryUseCase;Lsputnik/axmor/com/sputnik/mappers/call_history/DomainCallHistoryToCallHistoryMapper;Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/common/analytics/Analytics;)V", FailedBinderCallBack.CALLER_ID, "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/call/DomainCall;", "deleteCallFromServer", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "", "loadCallHistory", "()V", "deleteCall", "(Ljava/lang/String;)V", "", "needToShowPopup", "()Z", "Ljava/lang/String;", "Lsputnik/axmor/com/sputnik/di/use_cases/call_history/GetCallHistoryUseCase;", "Lsputnik/axmor/com/sputnik/di/use_cases/call_history/DeleteCallHistoryUseCase;", "Lsputnik/axmor/com/sputnik/mappers/call_history/DomainCallHistoryToCallHistoryMapper;", "Lcom/sputnik/data/local/PrefManager;", "Lcom/sputnik/common/analytics/Analytics;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "removedItems", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi;", "callHistory", "Lkotlinx/coroutines/flow/Flow;", "Factory", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallHistoryViewModel extends BaseViewModel<CallHistoryViewState> {
    private final Analytics analytics;
    private final Flow<PagingData<CallHistoryUi>> callHistory;
    private final DeleteCallHistoryUseCase deleteCallFromHistoryUseCase;
    private final DomainCallHistoryToCallHistoryMapper domainCallHistoryToCallHistoryMapper;
    private final GetCallHistoryUseCase loadCallHistoryByPagingUseCase;
    private final String localization;
    private final PrefManager prefManager;
    private final MutableStateFlow<List<String>> removedItems;

    public /* synthetic */ CallHistoryViewModel(String str, GetCallHistoryUseCase getCallHistoryUseCase, DeleteCallHistoryUseCase deleteCallHistoryUseCase, DomainCallHistoryToCallHistoryMapper domainCallHistoryToCallHistoryMapper, PrefManager prefManager, Analytics analytics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, getCallHistoryUseCase, deleteCallHistoryUseCase, domainCallHistoryToCallHistoryMapper, prefManager, analytics);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallHistoryViewModel(String str, GetCallHistoryUseCase loadCallHistoryByPagingUseCase, DeleteCallHistoryUseCase deleteCallFromHistoryUseCase, DomainCallHistoryToCallHistoryMapper domainCallHistoryToCallHistoryMapper, PrefManager prefManager, Analytics analytics) {
        super(new CallHistoryViewState(null, null, false, 7, null), "javaClass");
        Intrinsics.checkNotNullParameter(loadCallHistoryByPagingUseCase, "loadCallHistoryByPagingUseCase");
        Intrinsics.checkNotNullParameter(deleteCallFromHistoryUseCase, "deleteCallFromHistoryUseCase");
        Intrinsics.checkNotNullParameter(domainCallHistoryToCallHistoryMapper, "domainCallHistoryToCallHistoryMapper");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.localization = str;
        this.loadCallHistoryByPagingUseCase = loadCallHistoryByPagingUseCase;
        this.deleteCallFromHistoryUseCase = deleteCallFromHistoryUseCase;
        this.domainCallHistoryToCallHistoryMapper = domainCallHistoryToCallHistoryMapper;
        this.prefManager = prefManager;
        this.analytics = analytics;
        MutableStateFlow<List<String>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this.removedItems = MutableStateFlow;
        final Flow<PagingData<DomainCallHistory>> flowInvoke = loadCallHistoryByPagingUseCase.invoke();
        final Flow<PagingData<CallHistory>> flow = new Flow<PagingData<CallHistory>>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ CallHistoryViewModel this$0;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$1$2", f = "CallHistoryViewModel.kt", l = {223}, m = "emit")
                /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, CallHistoryViewModel callHistoryViewModel) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = callHistoryViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$1$2$1 r0 = (sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$1$2$1 r0 = new sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L50
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow
                        androidx.paging.PagingData r6 = (androidx.paging.PagingData) r6
                        sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$callHistory$1$1 r2 = new sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$callHistory$1$1
                        sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel r4 = r5.this$0
                        sputnik.axmor.com.sputnik.mappers.call_history.DomainCallHistoryToCallHistoryMapper r4 = sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel.access$getDomainCallHistoryToCallHistoryMapper$p(r4)
                        r2.<init>(r4)
                        androidx.paging.PagingData r6 = androidx.paging.PagingDataTransforms.map(r6, r2)
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L50
                        return r1
                    L50:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super PagingData<CallHistory>> flowCollector, Continuation continuation) {
                Object objCollect = flowInvoke.collect(new AnonymousClass2(flowCollector, this), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        final Flow flowFlowCombine = FlowKt.flowCombine(CachedPagingDataKt.cachedIn(new Flow<PagingData<CallHistoryUi>>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$2

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$2$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ CallHistoryViewModel this$0;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$2$2", f = "CallHistoryViewModel.kt", l = {223}, m = "emit")
                /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$2$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, CallHistoryViewModel callHistoryViewModel) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = callHistoryViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$2$2$1 r0 = (sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$2$2$1 r0 = new sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$2$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L4d
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        kotlin.ResultKt.throwOnFailure(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.$this_unsafeFlow
                        androidx.paging.PagingData r7 = (androidx.paging.PagingData) r7
                        sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$callHistory$2$1 r2 = new sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$callHistory$2$1
                        sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel r4 = r6.this$0
                        r5 = 0
                        r2.<init>(r4, r5)
                        androidx.paging.PagingData r7 = androidx.paging.PagingDataTransforms.map(r7, r2)
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r7, r0)
                        if (r7 != r1) goto L4d
                        return r1
                    L4d:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super PagingData<CallHistoryUi>> flowCollector, Continuation continuation) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector, this), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, ViewModelKt.getViewModelScope(this)), MutableStateFlow, new CallHistoryViewModel$callHistory$3(null));
        this.callHistory = new Flow<PagingData<CallHistoryUi>>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$3

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$3$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$3$2", f = "CallHistoryViewModel.kt", l = {223}, m = "emit")
                /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$3$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$3.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$3$2$1 r0 = (sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$3.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$3$2$1 r0 = new sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$3$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L4b
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow
                        androidx.paging.PagingData r6 = (androidx.paging.PagingData) r6
                        sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$callHistory$4$1 r2 = new sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$callHistory$4$1
                        r4 = 0
                        r2.<init>(r4)
                        androidx.paging.PagingData r6 = androidx.paging.PagingDataTransforms.insertSeparators$default(r6, r4, r2, r3, r4)
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L4b
                        return r1
                    L4b:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$special$$inlined$map$3.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super PagingData<CallHistoryUi>> flowCollector, Continuation continuation) {
                Object objCollect = flowFlowCombine.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        loadCallHistory();
    }

    /* compiled from: CallHistoryViewModel.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0015B;\b\u0007\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/history/viewmodel/CallHistoryViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "localization", "", "loadCallHistoryByPagingUseCase", "Lsputnik/axmor/com/sputnik/di/use_cases/call_history/GetCallHistoryUseCase;", "deleteCallFromHistoryUseCase", "Lsputnik/axmor/com/sputnik/di/use_cases/call_history/DeleteCallHistoryUseCase;", "domainCallHistoryToCallHistoryMapper", "Lsputnik/axmor/com/sputnik/mappers/call_history/DomainCallHistoryToCallHistoryMapper;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "(Ljava/lang/String;Lsputnik/axmor/com/sputnik/di/use_cases/call_history/GetCallHistoryUseCase;Lsputnik/axmor/com/sputnik/di/use_cases/call_history/DeleteCallHistoryUseCase;Lsputnik/axmor/com/sputnik/mappers/call_history/DomainCallHistoryToCallHistoryMapper;Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/common/analytics/Analytics;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "AssistFactory", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Factory extends ViewModelProvider.NewInstanceFactory {
        private final Analytics analytics;
        private final DeleteCallHistoryUseCase deleteCallFromHistoryUseCase;
        private final DomainCallHistoryToCallHistoryMapper domainCallHistoryToCallHistoryMapper;
        private final GetCallHistoryUseCase loadCallHistoryByPagingUseCase;
        private final String localization;
        private final PrefManager prefManager;

        /* compiled from: CallHistoryViewModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/cameras/history/viewmodel/CallHistoryViewModel$Factory$AssistFactory;", "", "create", "Lsputnik/axmor/com/sputnik/ui/main/cameras/history/viewmodel/CallHistoryViewModel$Factory;", "localization", "", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public interface AssistFactory {
            Factory create(String localization);
        }

        public Factory(String str, GetCallHistoryUseCase loadCallHistoryByPagingUseCase, DeleteCallHistoryUseCase deleteCallFromHistoryUseCase, DomainCallHistoryToCallHistoryMapper domainCallHistoryToCallHistoryMapper, PrefManager prefManager, Analytics analytics) {
            Intrinsics.checkNotNullParameter(loadCallHistoryByPagingUseCase, "loadCallHistoryByPagingUseCase");
            Intrinsics.checkNotNullParameter(deleteCallFromHistoryUseCase, "deleteCallFromHistoryUseCase");
            Intrinsics.checkNotNullParameter(domainCallHistoryToCallHistoryMapper, "domainCallHistoryToCallHistoryMapper");
            Intrinsics.checkNotNullParameter(prefManager, "prefManager");
            Intrinsics.checkNotNullParameter(analytics, "analytics");
            this.localization = str;
            this.loadCallHistoryByPagingUseCase = loadCallHistoryByPagingUseCase;
            this.deleteCallFromHistoryUseCase = deleteCallFromHistoryUseCase;
            this.domainCallHistoryToCallHistoryMapper = domainCallHistoryToCallHistoryMapper;
            this.prefManager = prefManager;
            this.analytics = analytics;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            if (!Intrinsics.areEqual(modelClass, CallHistoryViewModel.class)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            return new CallHistoryViewModel(this.localization, this.loadCallHistoryByPagingUseCase, this.deleteCallFromHistoryUseCase, this.domainCallHistoryToCallHistoryMapper, this.prefManager, this.analytics);
        }
    }

    private final LiveData<Resource<DomainCall>> deleteCallFromServer(String callId) {
        return FlowLiveDataConversions.asLiveData$default(this.deleteCallFromHistoryUseCase.invoke(callId), null, 0L, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object callHistory$lambda$0$map(DomainCallHistoryToCallHistoryMapper domainCallHistoryToCallHistoryMapper, DomainCallHistory domainCallHistory, Continuation continuation) {
        return domainCallHistoryToCallHistoryMapper.map(domainCallHistory);
    }

    public void loadCallHistory() {
        CallHistoryViewState callHistoryViewStateCopy$default = CallHistoryViewState.copy$default(getCurrentState(), this.callHistory, null, false, 6, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CallHistoryViewModel$loadCallHistory$$inlined$updateState$1(callHistoryViewStateCopy$default, this, null), 3, null);
        getState().setValue(callHistoryViewStateCopy$default);
    }

    public void deleteCall(String callId) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        final List<String> value = this.removedItems.getValue();
        MutableStateFlow<List<String>> mutableStateFlow = this.removedItems;
        mutableStateFlow.setValue(CollectionsKt.plus((Collection<? extends String>) mutableStateFlow.getValue(), callId));
        subscribeOnDataSource(deleteCallFromServer(callId), new Function2<Resource<? extends DomainCall>, CallHistoryViewState, CallHistoryViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel.deleteCall.1

            /* compiled from: CallHistoryViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$deleteCall$1$WhenMappings */
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ CallHistoryViewState invoke(Resource<? extends DomainCall> resource, CallHistoryViewState callHistoryViewState) {
                return invoke2((Resource<DomainCall>) resource, callHistoryViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CallHistoryViewState invoke2(Resource<DomainCall> serverData, CallHistoryViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return CallHistoryViewState.copy$default(state, null, Resource.Status.LOADING, false, 5, null);
                }
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    String str = CallHistoryViewModel.this.localization;
                    if (str != null) {
                        CallHistoryViewModel.this.notifySuccessMessage(str);
                    }
                    CallHistoryViewModel.this.analytics.trackLogEvent(new OnlySubscriptionEvents.ClickDeleteCallLogEvent());
                    return CallHistoryViewState.copy$default(state, null, Resource.Status.SUCCESS, false, 5, null);
                }
                DomainEmpty errorMsg = serverData.getErrorMsg();
                if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                    unit = null;
                } else {
                    CallHistoryViewModel.this.notifyErrorMessage(message);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    CallHistoryViewModel callHistoryViewModel = CallHistoryViewModel.this;
                    Exception error = serverData.getError();
                    Intrinsics.checkNotNull(error);
                    callHistoryViewModel.notifySimpleError(error);
                }
                CallHistoryViewModel.this.removedItems.setValue(value);
                return CallHistoryViewState.copy$default(state, null, Resource.Status.ERROR, false, 5, null);
            }
        });
    }

    public boolean needToShowPopup() {
        this.prefManager.getIsCallHistoryBottomSheetShowed();
        this.prefManager.updateCallHistoryBottomSheetShowed(true);
        return false;
    }
}
