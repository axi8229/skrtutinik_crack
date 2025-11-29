package com.sputnik.common.viewmodels;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.common.entities.market.market.Market;
import com.sputnik.common.entities.market.service.Service;
import com.sputnik.common.entities.market.service.ServiceInfo;
import com.sputnik.common.entities.market.subscription.Subscription;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.market.DomainMarket;
import com.sputnik.domain.entities.market.appearance.DomainBaseAppearance;
import com.sputnik.domain.entities.market.services.DomainService;
import com.sputnik.domain.entities.market.services.DomainSmallServices;
import com.sputnik.domain.entities.market.subscription.DomainSubscription;
import com.sputnik.domain.entities.prefs.AppSettings;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.usecases.market.GetMarketUseCase;
import com.sputnik.domain.usecases.market.GetServicesUseCase;
import com.sputnik.domain.usecases.market.GetSubscriptionUseCase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: MarketViewModel.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003Be\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\n\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\n\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001a0\u00190\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001a0\u00190\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ!\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001a0\u00190\u0018H\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010!J\u000f\u0010#\u001a\u00020\u001fH\u0016¢\u0006\u0004\b#\u0010!J\u000f\u0010$\u001a\u00020\u001fH\u0016¢\u0006\u0004\b$\u0010!J\u000f\u0010%\u001a\u00020\u001fH\u0016¢\u0006\u0004\b%\u0010!J\u0017\u0010(\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u001f¢\u0006\u0004\b*\u0010!J\u0013\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u001a¢\u0006\u0004\b,\u0010-R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010.R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010/R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00100R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u00101R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u00101R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u00101R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u00102R\u0016\u00103\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/sputnik/common/viewmodels/MarketViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/MarketViewState;", "", "Lcom/sputnik/domain/usecases/market/GetMarketUseCase;", "getMarketUseCase", "Lcom/sputnik/domain/usecases/market/GetSubscriptionUseCase;", "getSubscriptionUseCase", "Lcom/sputnik/domain/usecases/market/GetServicesUseCase;", "getServicesUseCase", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/domain/entities/market/services/DomainService;", "Lcom/sputnik/common/entities/market/service/Service;", "domainServiceToServiceMapper", "Lcom/sputnik/domain/entities/market/DomainMarket;", "Lcom/sputnik/common/entities/market/market/Market;", "domainMarketToMarketMapper", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscription;", "Lcom/sputnik/common/entities/market/subscription/Subscription;", "domainSubscriptionToSubscriptionMapper", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "<init>", "(Lcom/sputnik/domain/usecases/market/GetMarketUseCase;Lcom/sputnik/domain/usecases/market/GetSubscriptionUseCase;Lcom/sputnik/domain/usecases/market/GetServicesUseCase;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/data/local/PrefManager;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "getMarketFromServer", "()Landroidx/lifecycle/LiveData;", "getServicesFromServer", "getSubscriptionsFromServer", "", "updateMarketIfNeeded", "()V", "loadServices", "loadSubscriptions", "loadMarket", "updateAllMarket", "", "isNeedUpdate", "handleNeedUpdate", "(Z)V", "logout", "Lcom/sputnik/common/entities/market/service/ServiceInfo;", "getActiveServices", "()Ljava/util/List;", "Lcom/sputnik/domain/usecases/market/GetMarketUseCase;", "Lcom/sputnik/domain/usecases/market/GetSubscriptionUseCase;", "Lcom/sputnik/domain/usecases/market/GetServicesUseCase;", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/local/PrefManager;", "isUpdateMarketStarted", "Z", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MarketViewModel extends BaseViewModel<MarketViewState> {
    private final ListMapper<DomainMarket, Market> domainMarketToMarketMapper;
    private final ListMapper<DomainService, Service> domainServiceToServiceMapper;
    private final ListMapper<DomainSubscription, Subscription> domainSubscriptionToSubscriptionMapper;
    private final GetMarketUseCase getMarketUseCase;
    private final GetServicesUseCase getServicesUseCase;
    private final GetSubscriptionUseCase getSubscriptionUseCase;
    private boolean isUpdateMarketStarted;
    private final PrefManager prefManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketViewModel(GetMarketUseCase getMarketUseCase, GetSubscriptionUseCase getSubscriptionUseCase, GetServicesUseCase getServicesUseCase, ListMapper<DomainService, Service> domainServiceToServiceMapper, ListMapper<DomainMarket, Market> domainMarketToMarketMapper, ListMapper<DomainSubscription, Subscription> domainSubscriptionToSubscriptionMapper, PrefManager prefManager) {
        super(new MarketViewState(null, null, null, null, null, null, null, null, null, 511, null), "javaClass");
        Intrinsics.checkNotNullParameter(getMarketUseCase, "getMarketUseCase");
        Intrinsics.checkNotNullParameter(getSubscriptionUseCase, "getSubscriptionUseCase");
        Intrinsics.checkNotNullParameter(getServicesUseCase, "getServicesUseCase");
        Intrinsics.checkNotNullParameter(domainServiceToServiceMapper, "domainServiceToServiceMapper");
        Intrinsics.checkNotNullParameter(domainMarketToMarketMapper, "domainMarketToMarketMapper");
        Intrinsics.checkNotNullParameter(domainSubscriptionToSubscriptionMapper, "domainSubscriptionToSubscriptionMapper");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        this.getMarketUseCase = getMarketUseCase;
        this.getSubscriptionUseCase = getSubscriptionUseCase;
        this.getServicesUseCase = getServicesUseCase;
        this.domainServiceToServiceMapper = domainServiceToServiceMapper;
        this.domainMarketToMarketMapper = domainMarketToMarketMapper;
        this.domainSubscriptionToSubscriptionMapper = domainSubscriptionToSubscriptionMapper;
        this.prefManager = prefManager;
        updateMarketIfNeeded();
    }

    private final LiveData<Resource<List<DomainMarket>>> getMarketFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.getMarketUseCase.invoke(), null, 0L, 3, null);
    }

    private final LiveData<Resource<List<DomainService>>> getServicesFromServer() {
        Integer id;
        GetServicesUseCase getServicesUseCase = this.getServicesUseCase;
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(getServicesUseCase.invoke((currentAddress == null || (id = currentAddress.getId()) == null) ? -1 : id.intValue()), null, 0L, 3, null);
    }

    private final LiveData<Resource<List<DomainSubscription>>> getSubscriptionsFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.getSubscriptionUseCase.invoke(), null, 0L, 3, null);
    }

    public final void updateMarketIfNeeded() {
        if (getCurrentState().getMarketState() == Resource.Status.NONE) {
            updateAllMarket();
        }
    }

    public void loadServices() {
        subscribeOnDataSource(getServicesFromServer(), new Function2<Resource<? extends List<? extends DomainService>>, MarketViewState, MarketViewState>() { // from class: com.sputnik.common.viewmodels.MarketViewModel.loadServices.1

            /* compiled from: MarketViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.MarketViewModel$loadServices$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ MarketViewState invoke(Resource<? extends List<? extends DomainService>> resource, MarketViewState marketViewState) {
                return invoke2((Resource<? extends List<DomainService>>) resource, marketViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final MarketViewState invoke2(Resource<? extends List<DomainService>> servicesData, MarketViewState state) {
                Object next;
                Intrinsics.checkNotNullParameter(servicesData, "servicesData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[servicesData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((374 & 1) != 0 ? state.marketState : null, (374 & 2) != 0 ? state.subscriptionState : null, (374 & 4) != 0 ? state.servicesState : Resource.Status.LOADING, (374 & 8) != 0 ? state.market : null, (374 & 16) != 0 ? state.subscriptions : null, (374 & 32) != 0 ? state.services : null, (374 & 64) != 0 ? state.newServices : null, (374 & 128) != 0 ? state.exception : null, (374 & 256) != 0 ? state.needUpdate : null);
                }
                if (i == 3) {
                    Resource.Status status = Resource.Status.ERROR;
                    Exception error = servicesData.getError();
                    Intrinsics.checkNotNull(error);
                    return state.copy((374 & 1) != 0 ? state.marketState : null, (374 & 2) != 0 ? state.subscriptionState : null, (374 & 4) != 0 ? state.servicesState : status, (374 & 8) != 0 ? state.market : null, (374 & 16) != 0 ? state.subscriptions : null, (374 & 32) != 0 ? state.services : null, (374 & 64) != 0 ? state.newServices : null, (374 & 128) != 0 ? state.exception : error, (374 & 256) != 0 ? state.needUpdate : null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                ListMapper listMapper = MarketViewModel.this.domainServiceToServiceMapper;
                List<DomainService> data = servicesData.getData();
                Intrinsics.checkNotNull(data);
                List map = listMapper.map(data);
                Intrinsics.areEqual(MarketViewModel.this.prefManager.m2507getDebugToolsSettings().getIsBleServiceAvailable(), Boolean.TRUE);
                Iterator it = map.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(((Service) next).getServiceConfigIdentifier(), AndroidConstants.ServicesNames.INSTANCE.getBLE_IDENTIFIER())) {
                        break;
                    }
                }
                boolean z = next != null;
                AppSettings appSettings = MarketViewModel.this.prefManager.getAppSettings();
                PrefManager prefManager = MarketViewModel.this.prefManager;
                appSettings.getBleSettings().setBleServiceAvailable(Boolean.valueOf(z));
                prefManager.updateAppSettings(appSettings);
                return state.copy((374 & 1) != 0 ? state.marketState : null, (374 & 2) != 0 ? state.subscriptionState : null, (374 & 4) != 0 ? state.servicesState : Resource.Status.SUCCESS, (374 & 8) != 0 ? state.market : null, (374 & 16) != 0 ? state.subscriptions : null, (374 & 32) != 0 ? state.services : map, (374 & 64) != 0 ? state.newServices : null, (374 & 128) != 0 ? state.exception : null, (374 & 256) != 0 ? state.needUpdate : null);
            }
        });
    }

    public void handleNeedUpdate(boolean isNeedUpdate) {
        MarketViewState currentState = getCurrentState();
        MarketViewState marketViewStateCopy = currentState.copy((374 & 1) != 0 ? currentState.marketState : null, (374 & 2) != 0 ? currentState.subscriptionState : null, (374 & 4) != 0 ? currentState.servicesState : null, (374 & 8) != 0 ? currentState.market : null, (374 & 16) != 0 ? currentState.subscriptions : null, (374 & 32) != 0 ? currentState.services : null, (374 & 64) != 0 ? currentState.newServices : null, (374 & 128) != 0 ? currentState.exception : null, (374 & 256) != 0 ? currentState.needUpdate : new Event(Boolean.TRUE));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(marketViewStateCopy, this, null), 3, null);
        getState().setValue(marketViewStateCopy);
    }

    public final void logout() {
        MarketViewState currentState = getCurrentState();
        Resource.Status status = Resource.Status.NONE;
        MarketViewState marketViewStateCopy = currentState.copy((374 & 1) != 0 ? currentState.marketState : status, (374 & 2) != 0 ? currentState.subscriptionState : status, (374 & 4) != 0 ? currentState.servicesState : status, (374 & 8) != 0 ? currentState.market : CollectionsKt.emptyList(), (374 & 16) != 0 ? currentState.subscriptions : CollectionsKt.emptyList(), (374 & 32) != 0 ? currentState.services : CollectionsKt.emptyList(), (374 & 64) != 0 ? currentState.newServices : CollectionsKt.emptyList(), (374 & 128) != 0 ? currentState.exception : null, (374 & 256) != 0 ? currentState.needUpdate : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(marketViewStateCopy, this, null), 3, null);
        getState().setValue(marketViewStateCopy);
    }

    public void loadSubscriptions() {
        subscribeOnDataSource(getSubscriptionsFromServer(), new Function2<Resource<? extends List<? extends DomainSubscription>>, MarketViewState, MarketViewState>() { // from class: com.sputnik.common.viewmodels.MarketViewModel.loadSubscriptions.1

            /* compiled from: MarketViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.MarketViewModel$loadSubscriptions$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ MarketViewState invoke(Resource<? extends List<? extends DomainSubscription>> resource, MarketViewState marketViewState) {
                return invoke2((Resource<? extends List<DomainSubscription>>) resource, marketViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final MarketViewState invoke2(Resource<? extends List<DomainSubscription>> subscriptionData, MarketViewState state) {
                ArrayList arrayList;
                DomainSubscription domainSubscription;
                List<DomainSmallServices> services;
                LoginState.Session session;
                LoginState.Session session2;
                Object next;
                Intrinsics.checkNotNullParameter(subscriptionData, "subscriptionData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[subscriptionData.getStatus().ordinal()];
                boolean z = true;
                if (i == 1 || i == 2) {
                    return state.copy((374 & 1) != 0 ? state.marketState : null, (374 & 2) != 0 ? state.subscriptionState : Resource.Status.LOADING, (374 & 4) != 0 ? state.servicesState : null, (374 & 8) != 0 ? state.market : null, (374 & 16) != 0 ? state.subscriptions : null, (374 & 32) != 0 ? state.services : null, (374 & 64) != 0 ? state.newServices : null, (374 & 128) != 0 ? state.exception : null, (374 & 256) != 0 ? state.needUpdate : null);
                }
                if (i == 3) {
                    Resource.Status status = Resource.Status.ERROR;
                    Exception error = subscriptionData.getError();
                    Intrinsics.checkNotNull(error);
                    return state.copy((374 & 1) != 0 ? state.marketState : null, (374 & 2) != 0 ? state.subscriptionState : status, (374 & 4) != 0 ? state.servicesState : null, (374 & 8) != 0 ? state.market : null, (374 & 16) != 0 ? state.subscriptions : null, (374 & 32) != 0 ? state.services : null, (374 & 64) != 0 ? state.newServices : null, (374 & 128) != 0 ? state.exception : error, (374 & 256) != 0 ? state.needUpdate : null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                MarketViewModel marketViewModel = MarketViewModel.this;
                try {
                    List<DomainSubscription> data = subscriptionData.getData();
                    DomainSubscription domainSubscription2 = data != null ? (DomainSubscription) CollectionsKt.firstOrNull((List) data) : null;
                    LoginState loginState = marketViewModel.prefManager.getLoginState();
                    List<LoginState.Session> sessions = loginState.getSessions();
                    if (sessions != null) {
                        Iterator<T> it = sessions.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            LoginState.Session session3 = (LoginState.Session) next;
                            if (Intrinsics.areEqual(StringUtilsKt.toPhoneHash(session3.getCountryCode() + session3.getPhone()), marketViewModel.prefManager.getPhone())) {
                                break;
                            }
                        }
                        session = (LoginState.Session) next;
                    } else {
                        session = null;
                    }
                    if (session != null) {
                        List<LoginState.Session> sessions2 = loginState.getSessions();
                        Integer numValueOf = sessions2 != null ? Integer.valueOf(sessions2.indexOf(session)) : null;
                        PrefManager prefManager = marketViewModel.prefManager;
                        LoginState loginState2 = marketViewModel.prefManager.getLoginState();
                        try {
                            List<LoginState.Session> sessions3 = loginState2.getSessions();
                            if (sessions3 != null) {
                                Intrinsics.checkNotNull(numValueOf);
                                session2 = sessions3.get(numValueOf.intValue());
                            } else {
                                session2 = null;
                            }
                            if (session2 != null) {
                                if (domainSubscription2 == null) {
                                    z = false;
                                }
                                session2.setHaveSubscription(Boolean.valueOf(z));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        prefManager.setLoginState(loginState2);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                List<DomainSubscription> data2 = subscriptionData.getData();
                if (data2 == null || (domainSubscription = (DomainSubscription) CollectionsKt.firstOrNull((List) data2)) == null || (services = domainSubscription.getServices()) == null) {
                    arrayList = null;
                } else {
                    List<DomainSmallServices> list = services;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (DomainSmallServices domainSmallServices : list) {
                        DomainBaseAppearance appearance = domainSmallServices.getAppearance();
                        String title = appearance != null ? appearance.getTitle() : null;
                        DomainBaseAppearance appearance2 = domainSmallServices.getAppearance();
                        arrayList2.add(new Service(title, appearance2 != null ? appearance2.getDescription() : null, null, null, null, domainSmallServices.getServiceConfigIdentifier(), null, null, null, null, null, 2012, null));
                    }
                    arrayList = arrayList2;
                }
                List listEmptyList = arrayList == null ? CollectionsKt.emptyList() : arrayList;
                Resource.Status status2 = Resource.Status.SUCCESS;
                ListMapper listMapper = MarketViewModel.this.domainSubscriptionToSubscriptionMapper;
                List<DomainSubscription> data3 = subscriptionData.getData();
                Intrinsics.checkNotNull(data3);
                return state.copy((374 & 1) != 0 ? state.marketState : null, (374 & 2) != 0 ? state.subscriptionState : status2, (374 & 4) != 0 ? state.servicesState : null, (374 & 8) != 0 ? state.market : null, (374 & 16) != 0 ? state.subscriptions : listMapper.map(data3), (374 & 32) != 0 ? state.services : null, (374 & 64) != 0 ? state.newServices : listEmptyList, (374 & 128) != 0 ? state.exception : null, (374 & 256) != 0 ? state.needUpdate : null);
            }
        });
    }

    public void loadMarket() {
        subscribeOnDataSource(getMarketFromServer(), new Function2<Resource<? extends List<? extends DomainMarket>>, MarketViewState, MarketViewState>() { // from class: com.sputnik.common.viewmodels.MarketViewModel.loadMarket.1

            /* compiled from: MarketViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.MarketViewModel$loadMarket$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ MarketViewState invoke(Resource<? extends List<? extends DomainMarket>> resource, MarketViewState marketViewState) {
                return invoke2((Resource<? extends List<DomainMarket>>) resource, marketViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final MarketViewState invoke2(Resource<? extends List<DomainMarket>> marketData, MarketViewState state) {
                Intrinsics.checkNotNullParameter(marketData, "marketData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[marketData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((374 & 1) != 0 ? state.marketState : Resource.Status.LOADING, (374 & 2) != 0 ? state.subscriptionState : null, (374 & 4) != 0 ? state.servicesState : null, (374 & 8) != 0 ? state.market : null, (374 & 16) != 0 ? state.subscriptions : null, (374 & 32) != 0 ? state.services : null, (374 & 64) != 0 ? state.newServices : null, (374 & 128) != 0 ? state.exception : null, (374 & 256) != 0 ? state.needUpdate : null);
                }
                if (i == 3) {
                    Resource.Status status = Resource.Status.ERROR;
                    Exception error = marketData.getError();
                    Intrinsics.checkNotNull(error);
                    return state.copy((374 & 1) != 0 ? state.marketState : status, (374 & 2) != 0 ? state.subscriptionState : null, (374 & 4) != 0 ? state.servicesState : null, (374 & 8) != 0 ? state.market : null, (374 & 16) != 0 ? state.subscriptions : null, (374 & 32) != 0 ? state.services : null, (374 & 64) != 0 ? state.newServices : null, (374 & 128) != 0 ? state.exception : error, (374 & 256) != 0 ? state.needUpdate : null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                Resource.Status status2 = Resource.Status.SUCCESS;
                ListMapper listMapper = MarketViewModel.this.domainMarketToMarketMapper;
                List<DomainMarket> data = marketData.getData();
                Intrinsics.checkNotNull(data);
                return state.copy((374 & 1) != 0 ? state.marketState : status2, (374 & 2) != 0 ? state.subscriptionState : null, (374 & 4) != 0 ? state.servicesState : null, (374 & 8) != 0 ? state.market : listMapper.map(data), (374 & 16) != 0 ? state.subscriptions : null, (374 & 32) != 0 ? state.services : null, (374 & 64) != 0 ? state.newServices : null, (374 & 128) != 0 ? state.exception : null, (374 & 256) != 0 ? state.needUpdate : null);
            }
        });
    }

    public void updateAllMarket() {
        if (this.isUpdateMarketStarted) {
            return;
        }
        loadServices();
        loadSubscriptions();
        this.isUpdateMarketStarted = true;
        delayRequest(3000L, new Function0<Unit>() { // from class: com.sputnik.common.viewmodels.MarketViewModel.updateAllMarket.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MarketViewModel.this.isUpdateMarketStarted = false;
            }
        });
        MarketViewState currentState = getCurrentState();
        MarketViewState marketViewStateCopy = currentState.copy((374 & 1) != 0 ? currentState.marketState : Resource.Status.SUCCESS, (374 & 2) != 0 ? currentState.subscriptionState : null, (374 & 4) != 0 ? currentState.servicesState : null, (374 & 8) != 0 ? currentState.market : null, (374 & 16) != 0 ? currentState.subscriptions : null, (374 & 32) != 0 ? currentState.services : null, (374 & 64) != 0 ? currentState.newServices : null, (374 & 128) != 0 ? currentState.exception : null, (374 & 256) != 0 ? currentState.needUpdate : new Event(Boolean.FALSE));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(marketViewStateCopy, this, null), 3, null);
        getState().setValue(marketViewStateCopy);
    }

    public final List<ServiceInfo> getActiveServices() {
        List<Service> services = getCurrentState().getServices();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(services, 10));
        Iterator<T> it = services.iterator();
        while (it.hasNext()) {
            String serviceConfigIdentifier = ((Service) it.next()).getServiceConfigIdentifier();
            if (serviceConfigIdentifier == null) {
                serviceConfigIdentifier = "";
            }
            arrayList.add(new ServiceInfo(serviceConfigIdentifier, true));
        }
        return arrayList;
    }
}
