package com.sputnik.service_payments.ui;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.service_payments.DomainPaymentHistory;
import com.sputnik.domain.entities.service_payments.DomainPaymentReceipt;
import com.sputnik.domain.entities.service_payments.DomainPromisePayment;
import com.sputnik.domain.entities.service_payments.DomainServiceAccountInfo;
import com.sputnik.domain.entities.service_payments.ServicePaymentState;
import com.sputnik.domain.entities.service_payments.ServicePaymentType;
import com.sputnik.domain.usecases.service_payments.GetReceiptByAccrualUseCase;
import com.sputnik.domain.usecases.service_payments.GetServiceAccountInfoUseCase;
import com.sputnik.domain.usecases.service_payments.GetServicePaymentsUseCase;
import com.sputnik.domain.usecases.service_payments.PromisePaymentUseCase;
import com.sputnik.service_payments.entities.payments.PaymentHistory;
import com.sputnik.service_payments.entities.payments.PromisePayment;
import com.sputnik.service_payments.entities.payments.ServiceAccountInfo;
import com.sputnik.service_payments.mappers.DomainPaymentHistoryToPaymentHistoryMapper;
import com.sputnik.service_payments.mappers.DomainPromisedPaymentToPromisedPaymentMapper;
import com.sputnik.service_payments.mappers.DomainServiceAccountInfoToServiceAccountInfoMapper;
import com.sputnik.service_payments.ui.ServicePaymentsViewState;
import com.sputnik.service_payments.viewmodel.interfaces.IServicePaymentsViewModel;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: ServicePaymentsViewModel.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003BQ\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00190\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00190\u00182\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b!\u0010\"J\u001b\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00190\u0018H\u0002¢\u0006\u0004\b$\u0010\u001dJ#\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00190\u00182\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b&\u0010\"J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020'H\u0016¢\u0006\u0004\b*\u0010)J\u000f\u0010+\u001a\u00020'H\u0016¢\u0006\u0004\b+\u0010)J\u000f\u0010,\u001a\u00020'H\u0016¢\u0006\u0004\b,\u0010)J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u0019\u00101\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020'H\u0016¢\u0006\u0004\b3\u0010)J\u0017\u00105\u001a\u00020'2\u0006\u00104\u001a\u00020\u001eH\u0016¢\u0006\u0004\b5\u00102J\r\u00106\u001a\u00020'¢\u0006\u0004\b6\u0010)R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00107R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00108R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00109R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010:R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010;R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010<R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010=R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010>R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010?¨\u0006@"}, d2 = {"Lcom/sputnik/service_payments/ui/ServicePaymentsViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/service_payments/ui/ServicePaymentsViewState;", "Lcom/sputnik/service_payments/viewmodel/interfaces/IServicePaymentsViewModel;", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/IConfig;", "config", "Lcom/sputnik/domain/usecases/service_payments/GetServicePaymentsUseCase;", "getServicePaymentsUseCase", "Lcom/sputnik/domain/usecases/service_payments/GetServiceAccountInfoUseCase;", "getServiceAccountInfoUseCase", "Lcom/sputnik/domain/usecases/service_payments/GetReceiptByAccrualUseCase;", "getReceiptByAccrualUseCase", "Lcom/sputnik/domain/usecases/service_payments/PromisePaymentUseCase;", "promisePaymentUseCase", "Lcom/sputnik/service_payments/mappers/DomainPaymentHistoryToPaymentHistoryMapper;", "mapper", "Lcom/sputnik/service_payments/mappers/DomainPromisedPaymentToPromisedPaymentMapper;", "promiseMapper", "Lcom/sputnik/service_payments/mappers/DomainServiceAccountInfoToServiceAccountInfoMapper;", "accountInfoMapper", "<init>", "(Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/data/IConfig;Lcom/sputnik/domain/usecases/service_payments/GetServicePaymentsUseCase;Lcom/sputnik/domain/usecases/service_payments/GetServiceAccountInfoUseCase;Lcom/sputnik/domain/usecases/service_payments/GetReceiptByAccrualUseCase;Lcom/sputnik/domain/usecases/service_payments/PromisePaymentUseCase;Lcom/sputnik/service_payments/mappers/DomainPaymentHistoryToPaymentHistoryMapper;Lcom/sputnik/service_payments/mappers/DomainPromisedPaymentToPromisedPaymentMapper;Lcom/sputnik/service_payments/mappers/DomainServiceAccountInfoToServiceAccountInfoMapper;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/service_payments/DomainPaymentHistory;", "getPaymentsFromServer", "()Landroidx/lifecycle/LiveData;", "", "uuid", "Lcom/sputnik/domain/entities/service_payments/DomainPromisePayment;", "promisePaymentOnServer", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/entities/service_payments/DomainServiceAccountInfo;", "getServiceAccountInfoFromServer", "Lcom/sputnik/domain/entities/service_payments/DomainPaymentReceipt;", "getReceiptByAccrualOnServer", "", "getServiceAccountInfo", "()V", "getServicePayments", "promisePayment", "clearDebt", "", "needToShowDebt", "()Z", FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, "updateLastShowingDebtDate", "(Ljava/lang/String;)V", "clearReceipt", "accrualUuid", "getReceipt", "setNeedToReload", "Lcom/sputnik/data/local/PrefManager;", "Lcom/sputnik/data/IConfig;", "Lcom/sputnik/domain/usecases/service_payments/GetServicePaymentsUseCase;", "Lcom/sputnik/domain/usecases/service_payments/GetServiceAccountInfoUseCase;", "Lcom/sputnik/domain/usecases/service_payments/GetReceiptByAccrualUseCase;", "Lcom/sputnik/domain/usecases/service_payments/PromisePaymentUseCase;", "Lcom/sputnik/service_payments/mappers/DomainPaymentHistoryToPaymentHistoryMapper;", "Lcom/sputnik/service_payments/mappers/DomainPromisedPaymentToPromisedPaymentMapper;", "Lcom/sputnik/service_payments/mappers/DomainServiceAccountInfoToServiceAccountInfoMapper;", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServicePaymentsViewModel extends BaseViewModel<ServicePaymentsViewState> implements IServicePaymentsViewModel {
    private final DomainServiceAccountInfoToServiceAccountInfoMapper accountInfoMapper;
    private final IConfig config;
    private final GetReceiptByAccrualUseCase getReceiptByAccrualUseCase;
    private final GetServiceAccountInfoUseCase getServiceAccountInfoUseCase;
    private final GetServicePaymentsUseCase getServicePaymentsUseCase;
    private final DomainPaymentHistoryToPaymentHistoryMapper mapper;
    private final PrefManager prefManager;
    private final DomainPromisedPaymentToPromisedPaymentMapper promiseMapper;
    private final PromisePaymentUseCase promisePaymentUseCase;

    public ServicePaymentsViewModel(PrefManager prefManager, IConfig config, GetServicePaymentsUseCase getServicePaymentsUseCase, GetServiceAccountInfoUseCase getServiceAccountInfoUseCase, GetReceiptByAccrualUseCase getReceiptByAccrualUseCase, PromisePaymentUseCase promisePaymentUseCase, DomainPaymentHistoryToPaymentHistoryMapper mapper, DomainPromisedPaymentToPromisedPaymentMapper promiseMapper, DomainServiceAccountInfoToServiceAccountInfoMapper accountInfoMapper) {
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(getServicePaymentsUseCase, "getServicePaymentsUseCase");
        Intrinsics.checkNotNullParameter(getServiceAccountInfoUseCase, "getServiceAccountInfoUseCase");
        Intrinsics.checkNotNullParameter(getReceiptByAccrualUseCase, "getReceiptByAccrualUseCase");
        Intrinsics.checkNotNullParameter(promisePaymentUseCase, "promisePaymentUseCase");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(promiseMapper, "promiseMapper");
        Intrinsics.checkNotNullParameter(accountInfoMapper, "accountInfoMapper");
        ServicePaymentsViewState servicePaymentsViewState = new ServicePaymentsViewState(null, null, null, null, null, null, null, null, null, 511, null);
        String name = ServicePaymentsViewModel.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        super(servicePaymentsViewState, name);
        this.prefManager = prefManager;
        this.config = config;
        this.getServicePaymentsUseCase = getServicePaymentsUseCase;
        this.getServiceAccountInfoUseCase = getServiceAccountInfoUseCase;
        this.getReceiptByAccrualUseCase = getReceiptByAccrualUseCase;
        this.promisePaymentUseCase = promisePaymentUseCase;
        this.mapper = mapper;
        this.promiseMapper = promiseMapper;
        this.accountInfoMapper = accountInfoMapper;
    }

    private final LiveData<Resource<List<DomainPaymentHistory>>> getPaymentsFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.getServicePaymentsUseCase.invoke(), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainPromisePayment>> promisePaymentOnServer(String uuid) {
        return FlowLiveDataConversions.asLiveData$default(this.promisePaymentUseCase.invoke(uuid), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainServiceAccountInfo>> getServiceAccountInfoFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.getServiceAccountInfoUseCase.invoke(), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainPaymentReceipt>> getReceiptByAccrualOnServer(String uuid) {
        return FlowLiveDataConversions.asLiveData$default(this.getReceiptByAccrualUseCase.invoke(uuid), null, 0L, 3, null);
    }

    public void getServiceAccountInfo() {
        if (getCurrentState().getServerStateAccountInfo() == Resource.Status.NONE) {
            subscribeOnDataSource(getServiceAccountInfoFromServer(), new Function2<Resource<? extends DomainServiceAccountInfo>, ServicePaymentsViewState, ServicePaymentsViewState>() { // from class: com.sputnik.service_payments.ui.ServicePaymentsViewModel.getServiceAccountInfo.1

                /* compiled from: ServicePaymentsViewModel.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                /* renamed from: com.sputnik.service_payments.ui.ServicePaymentsViewModel$getServiceAccountInfo$1$WhenMappings */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[Resource.Status.values().length];
                        try {
                            iArr[Resource.Status.LOADING.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[Resource.Status.SUCCESS.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[Resource.Status.ERROR.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ ServicePaymentsViewState invoke(Resource<? extends DomainServiceAccountInfo> resource, ServicePaymentsViewState servicePaymentsViewState) {
                    return invoke2((Resource<DomainServiceAccountInfo>) resource, servicePaymentsViewState);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final ServicePaymentsViewState invoke2(Resource<DomainServiceAccountInfo> data, ServicePaymentsViewState state) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    Intrinsics.checkNotNullParameter(state, "state");
                    int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                    if (i == 1) {
                        return state.copy((383 & 1) != 0 ? state.serverStateAccountInfo : Resource.Status.LOADING, (383 & 2) != 0 ? state.serverStatePayments : null, (383 & 4) != 0 ? state.payments : null, (383 & 8) != 0 ? state.payment : null, (383 & 16) != 0 ? state.debtPayment : null, (383 & 32) != 0 ? state.accountInfo : null, (383 & 64) != 0 ? state.promisedPaymentInfo : null, (383 & 128) != 0 ? state.receiptState : null, (383 & 256) != 0 ? state.needToReload : null);
                    }
                    ServicePaymentsViewState servicePaymentsViewStateCopy = null;
                    if (i != 2) {
                        if (i == 3) {
                            servicePaymentsViewStateCopy = state.copy((383 & 1) != 0 ? state.serverStateAccountInfo : Resource.Status.ERROR, (383 & 2) != 0 ? state.serverStatePayments : null, (383 & 4) != 0 ? state.payments : null, (383 & 8) != 0 ? state.payment : null, (383 & 16) != 0 ? state.debtPayment : null, (383 & 32) != 0 ? state.accountInfo : null, (383 & 64) != 0 ? state.promisedPaymentInfo : null, (383 & 128) != 0 ? state.receiptState : null, (383 & 256) != 0 ? state.needToReload : null);
                        }
                        return servicePaymentsViewStateCopy;
                    }
                    Resource.Status status = Resource.Status.SUCCESS;
                    DomainServiceAccountInfo data2 = data.getData();
                    return state.copy((383 & 1) != 0 ? state.serverStateAccountInfo : status, (383 & 2) != 0 ? state.serverStatePayments : null, (383 & 4) != 0 ? state.payments : null, (383 & 8) != 0 ? state.payment : null, (383 & 16) != 0 ? state.debtPayment : null, (383 & 32) != 0 ? state.accountInfo : data2 != null ? ServicePaymentsViewModel.this.accountInfoMapper.map(data2) : null, (383 & 64) != 0 ? state.promisedPaymentInfo : null, (383 & 128) != 0 ? state.receiptState : null, (383 & 256) != 0 ? state.needToReload : null);
                }
            });
        }
    }

    public void getServicePayments() {
        subscribeOnDataSource(getPaymentsFromServer(), new Function2<Resource<? extends List<? extends DomainPaymentHistory>>, ServicePaymentsViewState, ServicePaymentsViewState>() { // from class: com.sputnik.service_payments.ui.ServicePaymentsViewModel.getServicePayments.1

            /* compiled from: ServicePaymentsViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.service_payments.ui.ServicePaymentsViewModel$getServicePayments$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ ServicePaymentsViewState invoke(Resource<? extends List<? extends DomainPaymentHistory>> resource, ServicePaymentsViewState servicePaymentsViewState) {
                return invoke2((Resource<? extends List<DomainPaymentHistory>>) resource, servicePaymentsViewState);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ServicePaymentsViewState invoke2(Resource<? extends List<DomainPaymentHistory>> data, ServicePaymentsViewState state) {
                List listEmptyList;
                Object next;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1) {
                    return state.copy((383 & 1) != 0 ? state.serverStateAccountInfo : null, (383 & 2) != 0 ? state.serverStatePayments : Resource.Status.LOADING, (383 & 4) != 0 ? state.payments : null, (383 & 8) != 0 ? state.payment : null, (383 & 16) != 0 ? state.debtPayment : null, (383 & 32) != 0 ? state.accountInfo : null, (383 & 64) != 0 ? state.promisedPaymentInfo : null, (383 & 128) != 0 ? state.receiptState : null, (383 & 256) != 0 ? state.needToReload : null);
                }
                ServicePaymentsViewState servicePaymentsViewStateCopy = null;
                if (i != 2) {
                    if (i == 3) {
                        servicePaymentsViewStateCopy = state.copy((383 & 1) != 0 ? state.serverStateAccountInfo : null, (383 & 2) != 0 ? state.serverStatePayments : Resource.Status.ERROR, (383 & 4) != 0 ? state.payments : null, (383 & 8) != 0 ? state.payment : null, (383 & 16) != 0 ? state.debtPayment : null, (383 & 32) != 0 ? state.accountInfo : null, (383 & 64) != 0 ? state.promisedPaymentInfo : null, (383 & 128) != 0 ? state.receiptState : null, (383 & 256) != 0 ? state.needToReload : null);
                    }
                    return servicePaymentsViewStateCopy;
                }
                List<DomainPaymentHistory> data2 = data.getData();
                if (data2 != null) {
                    List<DomainPaymentHistory> list = data2;
                    ServicePaymentsViewModel servicePaymentsViewModel = ServicePaymentsViewModel.this;
                    listEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        listEmptyList.add(servicePaymentsViewModel.mapper.map((DomainPaymentHistory) it.next()));
                    }
                } else {
                    listEmptyList = null;
                }
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List listSortedWith = CollectionsKt.sortedWith(listEmptyList, new Comparator() { // from class: com.sputnik.service_payments.ui.ServicePaymentsViewModel$getServicePayments$1$invoke$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((PaymentHistory) t2).getTimeInMillis()), Long.valueOf(((PaymentHistory) t).getTimeInMillis()));
                    }
                });
                Resource.Status status = Resource.Status.SUCCESS;
                List list2 = listSortedWith;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list2) {
                    if (((PaymentHistory) obj).getState() != ServicePaymentState.created) {
                        arrayList.add(obj);
                    }
                }
                Iterator it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    PaymentHistory paymentHistory = (PaymentHistory) next;
                    if (paymentHistory.getState() == ServicePaymentState.created && paymentHistory.getType() == ServicePaymentType.current) {
                        break;
                    }
                }
                PaymentHistory paymentHistory2 = (PaymentHistory) next;
                Iterator it3 = list2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Object next2 = it3.next();
                    PaymentHistory paymentHistory3 = (PaymentHistory) next2;
                    if (paymentHistory3.getState() == ServicePaymentState.created && paymentHistory3.getType() == ServicePaymentType.previous) {
                        servicePaymentsViewStateCopy = next2;
                        break;
                    }
                }
                return state.copy((383 & 1) != 0 ? state.serverStateAccountInfo : null, (383 & 2) != 0 ? state.serverStatePayments : status, (383 & 4) != 0 ? state.payments : arrayList, (383 & 8) != 0 ? state.payment : paymentHistory2, (383 & 16) != 0 ? state.debtPayment : (PaymentHistory) servicePaymentsViewStateCopy, (383 & 32) != 0 ? state.accountInfo : null, (383 & 64) != 0 ? state.promisedPaymentInfo : null, (383 & 128) != 0 ? state.receiptState : null, (383 & 256) != 0 ? state.needToReload : null);
            }
        });
    }

    public void promisePayment() {
        ServiceAccountInfo accountInfo = getCurrentState().getAccountInfo();
        subscribeOnDataSource(promisePaymentOnServer(String.valueOf(accountInfo != null ? accountInfo.getAccrualUuid() : null)), new Function2<Resource<? extends DomainPromisePayment>, ServicePaymentsViewState, ServicePaymentsViewState>() { // from class: com.sputnik.service_payments.ui.ServicePaymentsViewModel.promisePayment.1

            /* compiled from: ServicePaymentsViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.service_payments.ui.ServicePaymentsViewModel$promisePayment$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ ServicePaymentsViewState invoke(Resource<? extends DomainPromisePayment> resource, ServicePaymentsViewState servicePaymentsViewState) {
                return invoke2((Resource<DomainPromisePayment>) resource, servicePaymentsViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ServicePaymentsViewState invoke2(Resource<DomainPromisePayment> res, ServicePaymentsViewState state) {
                PromisePayment map;
                Intrinsics.checkNotNullParameter(res, "res");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[res.getStatus().ordinal()];
                if (i == 1) {
                    return null;
                }
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    ServicePaymentsViewModel servicePaymentsViewModel = ServicePaymentsViewModel.this;
                    DomainEmpty errorMsg = res.getErrorMsg();
                    servicePaymentsViewModel.notifyErrorMessage(errorMsg != null ? errorMsg.getError() : null);
                    return state.copy((383 & 1) != 0 ? state.serverStateAccountInfo : null, (383 & 2) != 0 ? state.serverStatePayments : Resource.Status.ERROR, (383 & 4) != 0 ? state.payments : null, (383 & 8) != 0 ? state.payment : null, (383 & 16) != 0 ? state.debtPayment : null, (383 & 32) != 0 ? state.accountInfo : null, (383 & 64) != 0 ? state.promisedPaymentInfo : null, (383 & 128) != 0 ? state.receiptState : null, (383 & 256) != 0 ? state.needToReload : null);
                }
                if (res.getData() != null) {
                    DomainPromisedPaymentToPromisedPaymentMapper domainPromisedPaymentToPromisedPaymentMapper = ServicePaymentsViewModel.this.promiseMapper;
                    DomainPromisePayment data = res.getData();
                    Intrinsics.checkNotNull(data);
                    map = domainPromisedPaymentToPromisedPaymentMapper.map(data);
                } else {
                    map = null;
                }
                return state.copy((383 & 1) != 0 ? state.serverStateAccountInfo : null, (383 & 2) != 0 ? state.serverStatePayments : null, (383 & 4) != 0 ? state.payments : null, (383 & 8) != 0 ? state.payment : null, (383 & 16) != 0 ? state.debtPayment : null, (383 & 32) != 0 ? state.accountInfo : null, (383 & 64) != 0 ? state.promisedPaymentInfo : map, (383 & 128) != 0 ? state.receiptState : null, (383 & 256) != 0 ? state.needToReload : null);
            }
        });
    }

    public void clearDebt() {
        ServicePaymentsViewState currentState = getCurrentState();
        ServiceAccountInfo accountInfo = currentState.getAccountInfo();
        ServicePaymentsViewState servicePaymentsViewStateCopy = currentState.copy((383 & 1) != 0 ? currentState.serverStateAccountInfo : null, (383 & 2) != 0 ? currentState.serverStatePayments : null, (383 & 4) != 0 ? currentState.payments : null, (383 & 8) != 0 ? currentState.payment : null, (383 & 16) != 0 ? currentState.debtPayment : null, (383 & 32) != 0 ? currentState.accountInfo : accountInfo != null ? accountInfo.copy((2031 & 1) != 0 ? accountInfo.id : null, (2031 & 2) != 0 ? accountInfo.type : null, (2031 & 4) != 0 ? accountInfo.number : null, (2031 & 8) != 0 ? accountInfo.fullAddress : null, (2031 & 16) != 0 ? accountInfo.debt : "0", (2031 & 32) != 0 ? accountInfo.accrualUuid : null, (2031 & 64) != 0 ? accountInfo.promiseAvailable : null, (2031 & 128) != 0 ? accountInfo.promiseExpiresAt : null, (2031 & 256) != 0 ? accountInfo.partner : null, (2031 & 512) != 0 ? accountInfo.lastAccruedAt : null, (2031 & 1024) != 0 ? accountInfo.offerAccepted : null) : null, (383 & 64) != 0 ? currentState.promisedPaymentInfo : null, (383 & 128) != 0 ? currentState.receiptState : null, (383 & 256) != 0 ? currentState.needToReload : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ServicePaymentsViewModel$clearDebt$$inlined$updateState$1(servicePaymentsViewStateCopy, this, null), 3, null);
        getState().setValue(servicePaymentsViewStateCopy);
    }

    public void clearReceipt() {
        ServicePaymentsViewState currentState = getCurrentState();
        ServicePaymentsViewState servicePaymentsViewStateCopy = currentState.copy((383 & 1) != 0 ? currentState.serverStateAccountInfo : null, (383 & 2) != 0 ? currentState.serverStatePayments : null, (383 & 4) != 0 ? currentState.payments : null, (383 & 8) != 0 ? currentState.payment : null, (383 & 16) != 0 ? currentState.debtPayment : null, (383 & 32) != 0 ? currentState.accountInfo : null, (383 & 64) != 0 ? currentState.promisedPaymentInfo : null, (383 & 128) != 0 ? currentState.receiptState : new ServicePaymentsViewState.ReceiptState(null, Resource.Status.NONE), (383 & 256) != 0 ? currentState.needToReload : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ServicePaymentsViewModel$clearReceipt$$inlined$updateState$1(servicePaymentsViewStateCopy, this, null), 3, null);
        getState().setValue(servicePaymentsViewStateCopy);
    }

    public void getReceipt(String accrualUuid) {
        Intrinsics.checkNotNullParameter(accrualUuid, "accrualUuid");
        ServicePaymentsViewState currentState = getCurrentState();
        ServicePaymentsViewState servicePaymentsViewStateCopy = currentState.copy((383 & 1) != 0 ? currentState.serverStateAccountInfo : null, (383 & 2) != 0 ? currentState.serverStatePayments : null, (383 & 4) != 0 ? currentState.payments : null, (383 & 8) != 0 ? currentState.payment : null, (383 & 16) != 0 ? currentState.debtPayment : null, (383 & 32) != 0 ? currentState.accountInfo : null, (383 & 64) != 0 ? currentState.promisedPaymentInfo : null, (383 & 128) != 0 ? currentState.receiptState : new ServicePaymentsViewState.ReceiptState(null, Resource.Status.LOADING), (383 & 256) != 0 ? currentState.needToReload : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ServicePaymentsViewModel$getReceipt$$inlined$updateState$1(servicePaymentsViewStateCopy, this, null), 3, null);
        getState().setValue(servicePaymentsViewStateCopy);
        subscribeOnDataSource(getReceiptByAccrualOnServer(accrualUuid), new Function2<Resource<? extends DomainPaymentReceipt>, ServicePaymentsViewState, ServicePaymentsViewState>() { // from class: com.sputnik.service_payments.ui.ServicePaymentsViewModel.getReceipt.2

            /* compiled from: ServicePaymentsViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.service_payments.ui.ServicePaymentsViewModel$getReceipt$2$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ ServicePaymentsViewState invoke(Resource<? extends DomainPaymentReceipt> resource, ServicePaymentsViewState servicePaymentsViewState) {
                return invoke2((Resource<DomainPaymentReceipt>) resource, servicePaymentsViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ServicePaymentsViewState invoke2(Resource<DomainPaymentReceipt> res, ServicePaymentsViewState state) {
                Intrinsics.checkNotNullParameter(res, "res");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[res.getStatus().ordinal()];
                if (i == 1) {
                    return state.copy((383 & 1) != 0 ? state.serverStateAccountInfo : null, (383 & 2) != 0 ? state.serverStatePayments : null, (383 & 4) != 0 ? state.payments : null, (383 & 8) != 0 ? state.payment : null, (383 & 16) != 0 ? state.debtPayment : null, (383 & 32) != 0 ? state.accountInfo : null, (383 & 64) != 0 ? state.promisedPaymentInfo : null, (383 & 128) != 0 ? state.receiptState : new ServicePaymentsViewState.ReceiptState(null, res.getStatus()), (383 & 256) != 0 ? state.needToReload : null);
                }
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    ServicePaymentsViewModel servicePaymentsViewModel = ServicePaymentsViewModel.this;
                    DomainEmpty errorMsg = res.getErrorMsg();
                    servicePaymentsViewModel.notifyErrorMessage(errorMsg != null ? errorMsg.getError() : null);
                    return state.copy((383 & 1) != 0 ? state.serverStateAccountInfo : null, (383 & 2) != 0 ? state.serverStatePayments : null, (383 & 4) != 0 ? state.payments : null, (383 & 8) != 0 ? state.payment : null, (383 & 16) != 0 ? state.debtPayment : null, (383 & 32) != 0 ? state.accountInfo : null, (383 & 64) != 0 ? state.promisedPaymentInfo : null, (383 & 128) != 0 ? state.receiptState : new ServicePaymentsViewState.ReceiptState(null, res.getStatus()), (383 & 256) != 0 ? state.needToReload : null);
                }
                String str = ServicePaymentsViewModel.this.config.getIsStage() ? "https://citizen-app.stage.sputnik.systems/payments/" : "https://api-mobile-gorod.sputnik.systems/payments/";
                DomainPaymentReceipt data = res.getData();
                return state.copy((383 & 1) != 0 ? state.serverStateAccountInfo : null, (383 & 2) != 0 ? state.serverStatePayments : null, (383 & 4) != 0 ? state.payments : null, (383 & 8) != 0 ? state.payment : null, (383 & 16) != 0 ? state.debtPayment : null, (383 & 32) != 0 ? state.accountInfo : null, (383 & 64) != 0 ? state.promisedPaymentInfo : null, (383 & 128) != 0 ? state.receiptState : new ServicePaymentsViewState.ReceiptState(str + (data != null ? data.getLinkToken() : null), res.getStatus()), (383 & 256) != 0 ? state.needToReload : null);
            }
        });
    }

    public final void setNeedToReload() {
        ServicePaymentsViewState currentState = getCurrentState();
        ServicePaymentsViewState servicePaymentsViewStateCopy = currentState.copy((383 & 1) != 0 ? currentState.serverStateAccountInfo : null, (383 & 2) != 0 ? currentState.serverStatePayments : null, (383 & 4) != 0 ? currentState.payments : null, (383 & 8) != 0 ? currentState.payment : null, (383 & 16) != 0 ? currentState.debtPayment : null, (383 & 32) != 0 ? currentState.accountInfo : null, (383 & 64) != 0 ? currentState.promisedPaymentInfo : null, (383 & 128) != 0 ? currentState.receiptState : null, (383 & 256) != 0 ? currentState.needToReload : new Event(Boolean.TRUE));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ServicePaymentsViewModel$setNeedToReload$$inlined$updateState$1(servicePaymentsViewStateCopy, this, null), 3, null);
        getState().setValue(servicePaymentsViewStateCopy);
    }

    public boolean needToShowDebt() {
        String lastAccruedAt;
        ServiceAccountInfo accountInfo = getCurrentState().getAccountInfo();
        if (accountInfo == null || (lastAccruedAt = accountInfo.getLastAccruedAt()) == null) {
            lastAccruedAt = "";
        }
        return !Intrinsics.areEqual(lastAccruedAt, this.prefManager.getLastAccruedDate());
    }

    @Override // com.sputnik.service_payments.viewmodel.interfaces.IServicePaymentsViewModel
    public void updateLastShowingDebtDate(String date) {
        PrefManager prefManager = this.prefManager;
        if (date == null) {
            ServiceAccountInfo accountInfo = getCurrentState().getAccountInfo();
            date = accountInfo != null ? accountInfo.getLastAccruedAt() : null;
            if (date == null) {
                date = "";
            }
        }
        prefManager.setLastAccruedDate(date);
    }
}
