package com.sputnik.common.viewmodels;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.common.mappers.gorserv.DomainGorservCatalogToGorservCatalogMapper;
import com.sputnik.common.mappers.gorserv.DomainGorservCreateTicketToGorservCreateTicketMapper;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.gorserv.DomainGorservCatalog;
import com.sputnik.domain.entities.gorserv.DomainGorservTicket;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.entities.prefs.OnboardingSettings;
import com.sputnik.domain.usecases.gorserv.CreateGorservTicketUseCase;
import com.sputnik.domain.usecases.gorserv.GetGorservCatalogsUseCase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: GorservViewModel.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B9\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011JI\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00190\u00182\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ9\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00190\u00182\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00142\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u001aH\u0002¢\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020\u0014¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020%¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020%¢\u0006\u0004\b*\u0010)J\u001d\u0010+\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0014¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020%2\b\b\u0002\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020%¢\u0006\u0004\b1\u0010)R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00102R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00103R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00104R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00105R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u00106R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u00107¨\u00068"}, d2 = {"Lcom/sputnik/common/viewmodels/GorservViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/GorservViewState;", "", "Lcom/sputnik/domain/usecases/gorserv/GetGorservCatalogsUseCase;", "getGorservCatalogsUseCase", "Lcom/sputnik/domain/usecases/gorserv/CreateGorservTicketUseCase;", "createGorservTicketUseCase", "Lcom/sputnik/common/mappers/gorserv/DomainGorservCatalogToGorservCatalogMapper;", "domainGorservCatalogToGorservCatalogMapper", "Lcom/sputnik/common/mappers/gorserv/DomainGorservCreateTicketToGorservCreateTicketMapper;", "domainGorservCreateTicketToGorservCreateTicketMapper", "Lcom/sputnik/data/IConfig;", "config", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "<init>", "(Lcom/sputnik/domain/usecases/gorserv/GetGorservCatalogsUseCase;Lcom/sputnik/domain/usecases/gorserv/CreateGorservTicketUseCase;Lcom/sputnik/common/mappers/gorserv/DomainGorservCatalogToGorservCatalogMapper;Lcom/sputnik/common/mappers/gorserv/DomainGorservCreateTicketToGorservCreateTicketMapper;Lcom/sputnik/data/IConfig;Lcom/sputnik/data/local/PrefManager;)V", "", "version", "", "platform", "app", "locale", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/gorserv/DomainGorservCatalog;", "getGorservCatalogsFromServer", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "category", CrashHianalyticsData.MESSAGE, "phones", "Lcom/sputnik/domain/entities/gorserv/DomainGorservTicket;", "createTicketOnServer", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Landroidx/lifecycle/LiveData;", "phone", "", "handlePhone", "(Ljava/lang/String;)V", "closeHowItWorks", "()V", "loadCatalogs", "createTicket", "(Ljava/lang/String;Ljava/lang/String;)V", "", "full", "clearCreateTicketState", "(Z)V", "loadNotificationsEmpty", "Lcom/sputnik/domain/usecases/gorserv/GetGorservCatalogsUseCase;", "Lcom/sputnik/domain/usecases/gorserv/CreateGorservTicketUseCase;", "Lcom/sputnik/common/mappers/gorserv/DomainGorservCatalogToGorservCatalogMapper;", "Lcom/sputnik/common/mappers/gorserv/DomainGorservCreateTicketToGorservCreateTicketMapper;", "Lcom/sputnik/data/IConfig;", "Lcom/sputnik/data/local/PrefManager;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GorservViewModel extends BaseViewModel<GorservViewState> {
    private final IConfig config;
    private final CreateGorservTicketUseCase createGorservTicketUseCase;
    private final DomainGorservCatalogToGorservCatalogMapper domainGorservCatalogToGorservCatalogMapper;
    private final DomainGorservCreateTicketToGorservCreateTicketMapper domainGorservCreateTicketToGorservCreateTicketMapper;
    private final GetGorservCatalogsUseCase getGorservCatalogsUseCase;
    private final PrefManager prefManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GorservViewModel(GetGorservCatalogsUseCase getGorservCatalogsUseCase, CreateGorservTicketUseCase createGorservTicketUseCase, DomainGorservCatalogToGorservCatalogMapper domainGorservCatalogToGorservCatalogMapper, DomainGorservCreateTicketToGorservCreateTicketMapper domainGorservCreateTicketToGorservCreateTicketMapper, IConfig config, PrefManager prefManager) {
        LoginState.Session session;
        Object next;
        super(new GorservViewState(null, null, null, null, null, 31, null), "javaClass");
        Intrinsics.checkNotNullParameter(getGorservCatalogsUseCase, "getGorservCatalogsUseCase");
        Intrinsics.checkNotNullParameter(createGorservTicketUseCase, "createGorservTicketUseCase");
        Intrinsics.checkNotNullParameter(domainGorservCatalogToGorservCatalogMapper, "domainGorservCatalogToGorservCatalogMapper");
        Intrinsics.checkNotNullParameter(domainGorservCreateTicketToGorservCreateTicketMapper, "domainGorservCreateTicketToGorservCreateTicketMapper");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        this.getGorservCatalogsUseCase = getGorservCatalogsUseCase;
        this.createGorservTicketUseCase = createGorservTicketUseCase;
        this.domainGorservCatalogToGorservCatalogMapper = domainGorservCatalogToGorservCatalogMapper;
        this.domainGorservCreateTicketToGorservCreateTicketMapper = domainGorservCreateTicketToGorservCreateTicketMapper;
        this.config = config;
        this.prefManager = prefManager;
        GorservViewState currentState = getCurrentState();
        List<LoginState.Session> sessions = prefManager.getLoginState().getSessions();
        if (sessions != null) {
            Iterator<T> it = sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                LoginState.Session session2 = (LoginState.Session) next;
                if (Intrinsics.areEqual(StringUtilsKt.toPhoneHash(session2.getCountryCode() + session2.getPhone()), StringUtilsKt.toPhoneHash(this.prefManager.getPhone()))) {
                    break;
                }
            }
            session = (LoginState.Session) next;
        } else {
            session = null;
        }
        GorservViewState gorservViewStateCopy$default = GorservViewState.copy$default(currentState, null, null, (session != null ? session.getCountryCode() : null) + (session != null ? session.getPhone() : null), this.prefManager.getOnboardingSettings().getGorservOnboardingSettings(), null, 19, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(gorservViewStateCopy$default, this, null), 3, null);
        getState().setValue(gorservViewStateCopy$default);
    }

    public final void closeHowItWorks() {
        PrefManager prefManager = this.prefManager;
        OnboardingSettings onboardingSettings = prefManager.getOnboardingSettings();
        onboardingSettings.setGorservOnboardingSettings(onboardingSettings.getGorservOnboardingSettings().copy(false));
        prefManager.setOnboardingSettings(onboardingSettings);
        GorservViewState gorservViewStateCopy$default = GorservViewState.copy$default(getCurrentState(), null, null, null, this.prefManager.getOnboardingSettings().getGorservOnboardingSettings(), null, 23, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(gorservViewStateCopy$default, this, null), 3, null);
        getState().setValue(gorservViewStateCopy$default);
    }

    static /* synthetic */ LiveData getGorservCatalogsFromServer$default(GorservViewModel gorservViewModel, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            str = gorservViewModel.config.getPlatformKeyName();
        }
        if ((i2 & 4) != 0) {
            str2 = "default";
        }
        if ((i2 & 8) != 0) {
            str3 = gorservViewModel.prefManager.getCurLocale();
        }
        return gorservViewModel.getGorservCatalogsFromServer(i, str, str2, str3);
    }

    private final LiveData<Resource<List<DomainGorservCatalog>>> getGorservCatalogsFromServer(int version, String platform, String app, String locale) {
        return FlowLiveDataConversions.asLiveData$default(this.getGorservCatalogsUseCase.invoke(version, platform, app, locale), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainGorservTicket>> createTicketOnServer(String category, String message, List<String> phones) {
        return FlowLiveDataConversions.asLiveData$default(this.createGorservTicketUseCase.invoke(category, message, phones), null, 0L, 3, null);
    }

    public final void createTicket(String message, String category) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(category, "category");
        GorservViewState gorservViewStateCopy$default = GorservViewState.copy$default(getCurrentState(), null, Resource.Status.LOADING, null, null, null, 29, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(gorservViewStateCopy$default, this, null), 3, null);
        getState().setValue(gorservViewStateCopy$default);
        subscribeOnDataSource(createTicketOnServer(category, message, CollectionsKt.listOf(StringUtilsKt.toPhoneHash(String.valueOf(getCurrentState().getCurrentPhone())))), new Function2<Resource<? extends DomainGorservTicket>, GorservViewState, GorservViewState>() { // from class: com.sputnik.common.viewmodels.GorservViewModel.createTicket.2

            /* compiled from: GorservViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.GorservViewModel$createTicket$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ GorservViewState invoke(Resource<? extends DomainGorservTicket> resource, GorservViewState gorservViewState) {
                return invoke2((Resource<DomainGorservTicket>) resource, gorservViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final GorservViewState invoke2(Resource<DomainGorservTicket> data, GorservViewState state) {
                Unit unit;
                String message2;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return GorservViewState.copy$default(state, null, state.getServerState(), null, null, null, 29, null);
                }
                if (i != 3) {
                    if (i == 4) {
                        return GorservViewState.copy$default(state, null, Resource.Status.SUCCESS, null, null, null, 29, null);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                DomainEmpty errorMsg = data.getErrorMsg();
                if (errorMsg == null || (message2 = errorMsg.getMessage()) == null) {
                    unit = null;
                } else {
                    GorservViewModel.this.notifyErrorMessage(message2.toString());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    GorservViewModel gorservViewModel = GorservViewModel.this;
                    Exception error = data.getError();
                    Intrinsics.checkNotNull(error);
                    gorservViewModel.notifySimpleError(error);
                }
                return GorservViewState.copy$default(state, null, Resource.Status.ERROR, null, null, null, 29, null);
            }
        });
    }

    public final void handlePhone(String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        GorservViewState gorservViewStateCopy$default = GorservViewState.copy$default(getCurrentState(), null, null, phone, null, null, 27, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(gorservViewStateCopy$default, this, null), 3, null);
        getState().setValue(gorservViewStateCopy$default);
    }

    public final void loadCatalogs() {
        GorservViewState gorservViewStateCopy$default = GorservViewState.copy$default(getCurrentState(), Resource.Status.LOADING, null, null, null, null, 30, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(gorservViewStateCopy$default, this, null), 3, null);
        getState().setValue(gorservViewStateCopy$default);
        subscribeOnDataSource(getGorservCatalogsFromServer$default(this, 0, null, null, null, 15, null), new Function2<Resource<? extends List<? extends DomainGorservCatalog>>, GorservViewState, GorservViewState>() { // from class: com.sputnik.common.viewmodels.GorservViewModel.loadCatalogs.2

            /* compiled from: GorservViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.GorservViewModel$loadCatalogs$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ GorservViewState invoke(Resource<? extends List<? extends DomainGorservCatalog>> resource, GorservViewState gorservViewState) {
                return invoke2((Resource<? extends List<DomainGorservCatalog>>) resource, gorservViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final GorservViewState invoke2(Resource<? extends List<DomainGorservCatalog>> data, GorservViewState state) {
                Unit unit;
                String message;
                List listEmptyList;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return GorservViewState.copy$default(state, state.getServerState(), null, null, null, null, 30, null);
                }
                if (i == 3) {
                    DomainEmpty errorMsg = data.getErrorMsg();
                    if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                        unit = null;
                    } else {
                        GorservViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        GorservViewModel gorservViewModel = GorservViewModel.this;
                        Exception error = data.getError();
                        Intrinsics.checkNotNull(error);
                        gorservViewModel.notifySimpleError(error);
                    }
                    return GorservViewState.copy$default(state, Resource.Status.ERROR, null, null, null, null, 30, null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                Resource.Status status = Resource.Status.SUCCESS;
                List<DomainGorservCatalog> data2 = data.getData();
                if (data2 != null) {
                    List<DomainGorservCatalog> list = data2;
                    DomainGorservCatalogToGorservCatalogMapper domainGorservCatalogToGorservCatalogMapper = GorservViewModel.this.domainGorservCatalogToGorservCatalogMapper;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(domainGorservCatalogToGorservCatalogMapper.map((DomainGorservCatalog) it.next()));
                    }
                    listEmptyList = arrayList;
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                return GorservViewState.copy$default(state, status, null, null, null, listEmptyList, 14, null);
            }
        });
    }

    public final void loadNotificationsEmpty() {
        GorservViewState gorservViewStateCopy$default = GorservViewState.copy$default(getCurrentState(), Resource.Status.SUCCESS, null, null, null, null, 30, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(gorservViewStateCopy$default, this, null), 3, null);
        getState().setValue(gorservViewStateCopy$default);
    }

    public static /* synthetic */ void clearCreateTicketState$default(GorservViewModel gorservViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        gorservViewModel.clearCreateTicketState(z);
    }

    public final void clearCreateTicketState(boolean full) {
        LoginState.Session session;
        String currentPhone;
        Object next;
        List<LoginState.Session> sessions = this.prefManager.getLoginState().getSessions();
        if (sessions != null) {
            Iterator<T> it = sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                LoginState.Session session2 = (LoginState.Session) next;
                if (Intrinsics.areEqual(StringUtilsKt.toPhoneHash(session2.getCountryCode() + session2.getPhone()), StringUtilsKt.toPhoneHash(this.prefManager.getPhone()))) {
                    break;
                }
            }
            session = (LoginState.Session) next;
        } else {
            session = null;
        }
        GorservViewState currentState = getCurrentState();
        if (full) {
            currentPhone = (session != null ? session.getCountryCode() : null) + (session != null ? session.getPhone() : null);
        } else {
            currentPhone = currentState.getCurrentPhone();
        }
        GorservViewState gorservViewStateCopy$default = GorservViewState.copy$default(currentState, null, Resource.Status.NONE, currentPhone, null, null, 25, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(gorservViewStateCopy$default, this, null), 3, null);
        getState().setValue(gorservViewStateCopy$default);
    }
}
