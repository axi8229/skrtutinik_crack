package com.sputnik.common.viewmodels;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.common.entities.market.service.ServiceInfo;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.entities.subscriptions.DetailedLayout;
import com.sputnik.common.entities.subscriptions.IncludedServices;
import com.sputnik.common.entities.subscriptions.Service;
import com.sputnik.common.entities.subscriptions.SubscriptionAppearance;
import com.sputnik.common.entities.subscriptions.SubscriptionDetails;
import com.sputnik.common.mappers.subscriptions.DomainBaseSubscriptionToBaseSubscriptionMapper;
import com.sputnik.common.mappers.subscriptions.DomainMarketItemToMarketItemMapper;
import com.sputnik.common.mappers.subscriptions.DomainOuterServiceToOuterServiceMapper;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.subscriptions.DomainMarketV2;
import com.sputnik.domain.usecases.market.GetMarketV2UseCase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: SubscriptionsViewModel.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B1\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001aJ\r\u0010\u001e\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010\u001aJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b\"\u0010\u0017J\u0013\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0015¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010*R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010+R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010,R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010-R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010.¨\u0006/"}, d2 = {"Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/SubscriptionsViewState;", "", "Lcom/sputnik/domain/usecases/market/GetMarketV2UseCase;", "getMarketV2UseCase", "Lcom/sputnik/common/mappers/subscriptions/DomainBaseSubscriptionToBaseSubscriptionMapper;", "subscriptionsMapper", "Lcom/sputnik/common/mappers/subscriptions/DomainOuterServiceToOuterServiceMapper;", "servicesMapper", "Lcom/sputnik/common/mappers/subscriptions/DomainMarketItemToMarketItemMapper;", "marketItemsMapper", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "<init>", "(Lcom/sputnik/domain/usecases/market/GetMarketV2UseCase;Lcom/sputnik/common/mappers/subscriptions/DomainBaseSubscriptionToBaseSubscriptionMapper;Lcom/sputnik/common/mappers/subscriptions/DomainOuterServiceToOuterServiceMapper;Lcom/sputnik/common/mappers/subscriptions/DomainMarketItemToMarketItemMapper;Lcom/sputnik/data/local/PrefManager;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/subscriptions/DomainMarketV2;", "getMarketFromServer", "()Landroidx/lifecycle/LiveData;", "", "isMarketLocked", "()Z", "", "getSubscriptions", "()V", "setNeedToBuySubscription", "clearNeedToBuySubscription", "logout", "clearRedMarketPoint", "", "getSubscriptionInfo", "()Ljava/lang/String;", "hasSubscription", "", "Lcom/sputnik/common/entities/market/service/ServiceInfo;", "getServices", "()Ljava/util/List;", "available", "setRichFunctionalityAvailable", "(Z)V", "Lcom/sputnik/domain/usecases/market/GetMarketV2UseCase;", "Lcom/sputnik/common/mappers/subscriptions/DomainBaseSubscriptionToBaseSubscriptionMapper;", "Lcom/sputnik/common/mappers/subscriptions/DomainOuterServiceToOuterServiceMapper;", "Lcom/sputnik/common/mappers/subscriptions/DomainMarketItemToMarketItemMapper;", "Lcom/sputnik/data/local/PrefManager;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SubscriptionsViewModel extends BaseViewModel<SubscriptionsViewState> {
    private final GetMarketV2UseCase getMarketV2UseCase;
    private final DomainMarketItemToMarketItemMapper marketItemsMapper;
    private final PrefManager prefManager;
    private final DomainOuterServiceToOuterServiceMapper servicesMapper;
    private final DomainBaseSubscriptionToBaseSubscriptionMapper subscriptionsMapper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionsViewModel(GetMarketV2UseCase getMarketV2UseCase, DomainBaseSubscriptionToBaseSubscriptionMapper subscriptionsMapper, DomainOuterServiceToOuterServiceMapper servicesMapper, DomainMarketItemToMarketItemMapper marketItemsMapper, PrefManager prefManager) {
        super(new SubscriptionsViewState(null, null, null, null, null, false, false, false, false, false, false, false, 4095, null), "javaClass");
        Intrinsics.checkNotNullParameter(getMarketV2UseCase, "getMarketV2UseCase");
        Intrinsics.checkNotNullParameter(subscriptionsMapper, "subscriptionsMapper");
        Intrinsics.checkNotNullParameter(servicesMapper, "servicesMapper");
        Intrinsics.checkNotNullParameter(marketItemsMapper, "marketItemsMapper");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        this.getMarketV2UseCase = getMarketV2UseCase;
        this.subscriptionsMapper = subscriptionsMapper;
        this.servicesMapper = servicesMapper;
        this.marketItemsMapper = marketItemsMapper;
        this.prefManager = prefManager;
        getCurrentState().getMarketState();
        Resource.Status status = Resource.Status.SUCCESS;
    }

    private final LiveData<Resource<DomainMarketV2>> getMarketFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.getMarketV2UseCase.invoke(), null, 0L, 3, null);
    }

    public final boolean isMarketLocked() {
        List<BaseSubscription> subscriptions;
        return (getCurrentState().getSubscriptions() == null || ((subscriptions = getCurrentState().getSubscriptions()) != null && subscriptions.isEmpty())) && getCurrentState().getActiveSubscription() == null;
    }

    public void clearNeedToBuySubscription() {
        SubscriptionsViewState currentState = getCurrentState();
        SubscriptionsViewState subscriptionsViewStateCopy = currentState.copy((2240 & 1) != 0 ? currentState.marketState : null, (2240 & 2) != 0 ? currentState.activeSubscription : null, (2240 & 4) != 0 ? currentState.subscriptions : null, (2240 & 8) != 0 ? currentState.services : null, (2240 & 16) != 0 ? currentState.items : null, (2240 & 32) != 0 ? currentState.needShowButtonPromo : false, (2240 & 64) != 0 ? currentState.needShowButtonPromoEmpty : false, (2240 & 128) != 0 ? currentState.needToBuySubscription : false, (2240 & 256) != 0 ? currentState.needToLockAllViews : false, (2240 & 512) != 0 ? currentState.needToShowRedPoint : false, (2240 & 1024) != 0 ? currentState.needToShowRedPointOnServices : false, (2240 & 2048) != 0 ? currentState.richFunctionalityAvailable : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(subscriptionsViewStateCopy, this, null), 3, null);
        getState().setValue(subscriptionsViewStateCopy);
    }

    public final void clearRedMarketPoint() {
        SubscriptionsViewState currentState = getCurrentState();
        SubscriptionsViewState subscriptionsViewStateCopy = currentState.copy((2240 & 1) != 0 ? currentState.marketState : null, (2240 & 2) != 0 ? currentState.activeSubscription : null, (2240 & 4) != 0 ? currentState.subscriptions : null, (2240 & 8) != 0 ? currentState.services : null, (2240 & 16) != 0 ? currentState.items : null, (2240 & 32) != 0 ? currentState.needShowButtonPromo : false, (2240 & 64) != 0 ? currentState.needShowButtonPromoEmpty : false, (2240 & 128) != 0 ? currentState.needToBuySubscription : false, (2240 & 256) != 0 ? currentState.needToLockAllViews : false, (2240 & 512) != 0 ? currentState.needToShowRedPoint : false, (2240 & 1024) != 0 ? currentState.needToShowRedPointOnServices : false, (2240 & 2048) != 0 ? currentState.richFunctionalityAvailable : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(subscriptionsViewStateCopy, this, null), 3, null);
        getState().setValue(subscriptionsViewStateCopy);
    }

    public void getSubscriptions() {
        SubscriptionsViewState currentState = getCurrentState();
        SubscriptionsViewState subscriptionsViewStateCopy = currentState.copy((2240 & 1) != 0 ? currentState.marketState : Resource.Status.LOADING, (2240 & 2) != 0 ? currentState.activeSubscription : null, (2240 & 4) != 0 ? currentState.subscriptions : null, (2240 & 8) != 0 ? currentState.services : null, (2240 & 16) != 0 ? currentState.items : null, (2240 & 32) != 0 ? currentState.needShowButtonPromo : false, (2240 & 64) != 0 ? currentState.needShowButtonPromoEmpty : false, (2240 & 128) != 0 ? currentState.needToBuySubscription : false, (2240 & 256) != 0 ? currentState.needToLockAllViews : false, (2240 & 512) != 0 ? currentState.needToShowRedPoint : false, (2240 & 1024) != 0 ? currentState.needToShowRedPointOnServices : false, (2240 & 2048) != 0 ? currentState.richFunctionalityAvailable : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(subscriptionsViewStateCopy, this, null), 3, null);
        getState().setValue(subscriptionsViewStateCopy);
        subscribeOnDataSource(getMarketFromServer(), new Function2<Resource<? extends DomainMarketV2>, SubscriptionsViewState, SubscriptionsViewState>() { // from class: com.sputnik.common.viewmodels.SubscriptionsViewModel.getSubscriptions.2

            /* compiled from: SubscriptionsViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.SubscriptionsViewModel$getSubscriptions$2$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.ERROR.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ SubscriptionsViewState invoke(Resource<? extends DomainMarketV2> resource, SubscriptionsViewState subscriptionsViewState) {
                return invoke2((Resource<DomainMarketV2>) resource, subscriptionsViewState);
            }

            /* JADX WARN: Removed duplicated region for block: B:277:0x04e4  */
            /* JADX WARN: Removed duplicated region for block: B:283:0x04f8  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.sputnik.common.viewmodels.SubscriptionsViewState invoke2(com.sputnik.domain.common.Resource<com.sputnik.domain.entities.subscriptions.DomainMarketV2> r27, com.sputnik.common.viewmodels.SubscriptionsViewState r28) {
                /*
                    Method dump skipped, instructions count: 1349
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sputnik.common.viewmodels.SubscriptionsViewModel.AnonymousClass2.invoke2(com.sputnik.domain.common.Resource, com.sputnik.common.viewmodels.SubscriptionsViewState):com.sputnik.common.viewmodels.SubscriptionsViewState");
            }
        });
    }

    public void setNeedToBuySubscription() {
        SubscriptionsViewState currentState = getCurrentState();
        SubscriptionsViewState subscriptionsViewStateCopy = currentState.copy((2240 & 1) != 0 ? currentState.marketState : null, (2240 & 2) != 0 ? currentState.activeSubscription : null, (2240 & 4) != 0 ? currentState.subscriptions : null, (2240 & 8) != 0 ? currentState.services : null, (2240 & 16) != 0 ? currentState.items : null, (2240 & 32) != 0 ? currentState.needShowButtonPromo : false, (2240 & 64) != 0 ? currentState.needShowButtonPromoEmpty : false, (2240 & 128) != 0 ? currentState.needToBuySubscription : true, (2240 & 256) != 0 ? currentState.needToLockAllViews : false, (2240 & 512) != 0 ? currentState.needToShowRedPoint : false, (2240 & 1024) != 0 ? currentState.needToShowRedPointOnServices : false, (2240 & 2048) != 0 ? currentState.richFunctionalityAvailable : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(subscriptionsViewStateCopy, this, null), 3, null);
        getState().setValue(subscriptionsViewStateCopy);
    }

    public final void setRichFunctionalityAvailable(boolean available) {
        SubscriptionsViewState currentState = getCurrentState();
        SubscriptionsViewState subscriptionsViewStateCopy = currentState.copy((2240 & 1) != 0 ? currentState.marketState : null, (2240 & 2) != 0 ? currentState.activeSubscription : null, (2240 & 4) != 0 ? currentState.subscriptions : null, (2240 & 8) != 0 ? currentState.services : null, (2240 & 16) != 0 ? currentState.items : null, (2240 & 32) != 0 ? currentState.needShowButtonPromo : false, (2240 & 64) != 0 ? currentState.needShowButtonPromoEmpty : false, (2240 & 128) != 0 ? currentState.needToBuySubscription : false, (2240 & 256) != 0 ? currentState.needToLockAllViews : false, (2240 & 512) != 0 ? currentState.needToShowRedPoint : false, (2240 & 1024) != 0 ? currentState.needToShowRedPointOnServices : false, (2240 & 2048) != 0 ? currentState.richFunctionalityAvailable : available);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(subscriptionsViewStateCopy, this, null), 3, null);
        getState().setValue(subscriptionsViewStateCopy);
    }

    public void logout() {
        SubscriptionsInfo.INSTANCE.setActiveSubscription(null);
        SubscriptionsViewState currentState = getCurrentState();
        SubscriptionsViewState subscriptionsViewStateCopy = currentState.copy((2240 & 1) != 0 ? currentState.marketState : Resource.Status.NONE, (2240 & 2) != 0 ? currentState.activeSubscription : null, (2240 & 4) != 0 ? currentState.subscriptions : null, (2240 & 8) != 0 ? currentState.services : null, (2240 & 16) != 0 ? currentState.items : null, (2240 & 32) != 0 ? currentState.needShowButtonPromo : false, (2240 & 64) != 0 ? currentState.needShowButtonPromoEmpty : false, (2240 & 128) != 0 ? currentState.needToBuySubscription : false, (2240 & 256) != 0 ? currentState.needToLockAllViews : false, (2240 & 512) != 0 ? currentState.needToShowRedPoint : false, (2240 & 1024) != 0 ? currentState.needToShowRedPointOnServices : false, (2240 & 2048) != 0 ? currentState.richFunctionalityAvailable : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(subscriptionsViewStateCopy, this, null), 3, null);
        getState().setValue(subscriptionsViewStateCopy);
    }

    public final String getSubscriptionInfo() {
        BaseSubscription activeSubscription;
        SubscriptionDetails subscriptionDetails;
        String productId;
        SubscriptionsInfo subscriptionsInfo = SubscriptionsInfo.INSTANCE;
        return (subscriptionsInfo == null || (activeSubscription = subscriptionsInfo.getActiveSubscription()) == null || (subscriptionDetails = activeSubscription.getSubscriptionDetails()) == null || (productId = subscriptionDetails.getProductId()) == null) ? "отсутствует" : productId;
    }

    public final boolean hasSubscription() {
        return getCurrentState().getActiveSubscription() != null || getCurrentState().getRichFunctionalityAvailable();
    }

    public final List<ServiceInfo> getServices() {
        DetailedLayout detailedLayout;
        IncludedServices includedServices;
        List<Service> services;
        ArrayList arrayList = new ArrayList();
        List<BaseSubscription> subscriptions = getCurrentState().getSubscriptions();
        if (subscriptions != null) {
            Iterator<T> it = subscriptions.iterator();
            while (it.hasNext()) {
                SubscriptionAppearance appearance = ((BaseSubscription) it.next()).getAppearance();
                if (appearance != null && (detailedLayout = appearance.getDetailedLayout()) != null && (includedServices = detailedLayout.getIncludedServices()) != null && (services = includedServices.getServices()) != null) {
                    Iterator<T> it2 = services.iterator();
                    while (it2.hasNext()) {
                        String serviceConfigIdentifier = ((Service) it2.next()).getServiceConfigIdentifier();
                        if (serviceConfigIdentifier == null) {
                            serviceConfigIdentifier = "";
                        }
                        arrayList.add(new ServiceInfo(serviceConfigIdentifier, false));
                    }
                }
            }
        }
        return arrayList;
    }
}
