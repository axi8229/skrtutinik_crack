package sputnik.axmor.com.sputnik.ui.main.help.viewmodel;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.entities.help.Announce;
import com.sputnik.common.entities.help.CompanyContacts;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.company.DomainCompany;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.entities.support.DomainAnnounce;
import com.sputnik.domain.entities.support.DomainCompanyContacts;
import com.sputnik.domain.usecases.help.GetCompaniesUseCase;
import com.sputnik.domain.usecases.support.GetAnnounceUseCase;
import com.sputnik.domain.usecases.support.GetCompanyContactsUseCase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import sputnik.axmor.com.sputnik.entities.company.Company;

/* compiled from: HelpViewModel.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B=\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00140\u00130\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00130\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u001b\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00130\u0012H\u0002¢\u0006\u0004\b\u001a\u0010\u0016J\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010\u001dJ\r\u0010 \u001a\u00020\u001b¢\u0006\u0004\b \u0010\u001dJ\r\u0010!\u001a\u00020\u001b¢\u0006\u0004\b!\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\"R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010#R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010$R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010%R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010&¨\u0006'"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lsputnik/axmor/com/sputnik/ui/main/help/viewmodel/HelpViewState;", "", "Lcom/sputnik/data/local/PrefManager;", "prefs", "Lcom/sputnik/domain/usecases/help/GetCompaniesUseCase;", "getCompaniesUseCase", "Lcom/sputnik/domain/usecases/support/GetAnnounceUseCase;", "getAnnounceUseCase", "Lcom/sputnik/domain/usecases/support/GetCompanyContactsUseCase;", "getCompanyContactsUseCase", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/domain/entities/company/DomainCompany;", "Lsputnik/axmor/com/sputnik/entities/company/Company;", "mapper", "<init>", "(Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/domain/usecases/help/GetCompaniesUseCase;Lcom/sputnik/domain/usecases/support/GetAnnounceUseCase;Lcom/sputnik/domain/usecases/support/GetCompanyContactsUseCase;Lcom/sputnik/domain/common/ListMapper;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "getCompaniesFromServer", "()Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/entities/support/DomainAnnounce;", "getAnnounceFromServer", "Lcom/sputnik/domain/entities/support/DomainCompanyContacts;", "getCompanyContactsFromServer", "", "loadCompaniesList", "()V", "loadAnnounce", "loadCompanyContactsIfNeeded", "loadCompanyContacts", "logout", "Lcom/sputnik/data/local/PrefManager;", "Lcom/sputnik/domain/usecases/help/GetCompaniesUseCase;", "Lcom/sputnik/domain/usecases/support/GetAnnounceUseCase;", "Lcom/sputnik/domain/usecases/support/GetCompanyContactsUseCase;", "Lcom/sputnik/domain/common/ListMapper;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HelpViewModel extends BaseViewModel<HelpViewState> {
    private final GetAnnounceUseCase getAnnounceUseCase;
    private final GetCompaniesUseCase getCompaniesUseCase;
    private final GetCompanyContactsUseCase getCompanyContactsUseCase;
    private final ListMapper<DomainCompany, Company> mapper;
    private final PrefManager prefs;

    public HelpViewModel(PrefManager prefs, GetCompaniesUseCase getCompaniesUseCase, GetAnnounceUseCase getAnnounceUseCase, GetCompanyContactsUseCase getCompanyContactsUseCase, ListMapper<DomainCompany, Company> mapper) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(getCompaniesUseCase, "getCompaniesUseCase");
        Intrinsics.checkNotNullParameter(getAnnounceUseCase, "getAnnounceUseCase");
        Intrinsics.checkNotNullParameter(getCompanyContactsUseCase, "getCompanyContactsUseCase");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        HelpViewState helpViewState = new HelpViewState(null, null, null, null, null, 31, null);
        String name = HelpViewModel.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        super(helpViewState, name);
        this.prefs = prefs;
        this.getCompaniesUseCase = getCompaniesUseCase;
        this.getAnnounceUseCase = getAnnounceUseCase;
        this.getCompanyContactsUseCase = getCompanyContactsUseCase;
        this.mapper = mapper;
    }

    private final LiveData<Resource<List<DomainCompany>>> getCompaniesFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.getCompaniesUseCase.invoke(), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainAnnounce>> getAnnounceFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.getAnnounceUseCase.invoke(this.prefs.getCurLocale()), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainCompanyContacts>> getCompanyContactsFromServer() {
        Integer id;
        GetCompanyContactsUseCase getCompanyContactsUseCase = this.getCompanyContactsUseCase;
        LoginState.Session.Address currentAddress = this.prefs.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(getCompanyContactsUseCase.invoke((currentAddress == null || (id = currentAddress.getId()) == null) ? -1 : id.intValue()), null, 0L, 3, null);
    }

    public void loadCompaniesList() {
        subscribeOnDataSource(getCompaniesFromServer(), new Function2<Resource<? extends List<? extends DomainCompany>>, HelpViewState, HelpViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.viewmodel.HelpViewModel.loadCompaniesList.1

            /* compiled from: HelpViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.help.viewmodel.HelpViewModel$loadCompaniesList$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ HelpViewState invoke(Resource<? extends List<? extends DomainCompany>> resource, HelpViewState helpViewState) {
                return invoke2((Resource<? extends List<DomainCompany>>) resource, helpViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final HelpViewState invoke2(Resource<? extends List<DomainCompany>> serverData, HelpViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return HelpViewState.copy$default(state, Resource.Status.LOADING, null, null, null, null, 30, null);
                }
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Resource.Status status = Resource.Status.SUCCESS;
                    ListMapper listMapper = HelpViewModel.this.mapper;
                    List<DomainCompany> data = serverData.getData();
                    Intrinsics.checkNotNull(data);
                    return HelpViewState.copy$default(state, status, null, listMapper.map(data), null, null, 26, null);
                }
                DomainEmpty errorMsg = serverData.getErrorMsg();
                if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                    unit = null;
                } else {
                    HelpViewModel.this.notifyErrorMessage(message);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    HelpViewModel helpViewModel = HelpViewModel.this;
                    Exception error = serverData.getError();
                    Intrinsics.checkNotNull(error);
                    helpViewModel.notifySimpleError(error);
                }
                return HelpViewState.copy$default(state, Resource.Status.ERROR, null, null, null, null, 30, null);
            }
        });
    }

    public final void loadAnnounce() {
        subscribeOnDataSource(getAnnounceFromServer(), new Function2<Resource<? extends DomainAnnounce>, HelpViewState, HelpViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.viewmodel.HelpViewModel.loadAnnounce.1

            /* compiled from: HelpViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.help.viewmodel.HelpViewModel$loadAnnounce$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ HelpViewState invoke(Resource<? extends DomainAnnounce> resource, HelpViewState helpViewState) {
                return invoke2((Resource<DomainAnnounce>) resource, helpViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final HelpViewState invoke2(Resource<DomainAnnounce> serverData, HelpViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                if (WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()] != 1) {
                    return state;
                }
                Announce.Companion companion = Announce.INSTANCE;
                DomainAnnounce data = serverData.getData();
                Announce.AnnounceType type = companion.parseType(data != null ? data.getType() : null);
                DomainAnnounce data2 = serverData.getData();
                if (data2 == null || (message = data2.getMessage()) == null) {
                    message = "";
                }
                return HelpViewState.copy$default(state, null, null, null, new Announce(type, message), null, 23, null);
            }
        });
    }

    public final void loadCompanyContactsIfNeeded() {
        if ((getCurrentState().getCompanyContactsServerState() == Resource.Status.SUCCESS || getCurrentState().getCompanyContactsServerState() == Resource.Status.LOADING) && getCurrentState().getCompanyContactsServerState() != Resource.Status.NONE) {
            return;
        }
        loadCompanyContacts();
    }

    public final void loadCompanyContacts() {
        HelpViewState helpViewStateCopy$default = HelpViewState.copy$default(getCurrentState(), null, Resource.Status.LOADING, null, null, null, 29, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HelpViewModel$loadCompanyContacts$$inlined$updateState$1(helpViewStateCopy$default, this, null), 3, null);
        getState().setValue(helpViewStateCopy$default);
        subscribeOnDataSource(getCompanyContactsFromServer(), new Function2<Resource<? extends DomainCompanyContacts>, HelpViewState, HelpViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.help.viewmodel.HelpViewModel.loadCompanyContacts.2

            /* compiled from: HelpViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.help.viewmodel.HelpViewModel$loadCompanyContacts$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ HelpViewState invoke(Resource<? extends DomainCompanyContacts> resource, HelpViewState helpViewState) {
                return invoke2((Resource<DomainCompanyContacts>) resource, helpViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final HelpViewState invoke2(Resource<DomainCompanyContacts> serverData, HelpViewState state) {
                String message;
                List listEmptyList;
                List<DomainCompanyContacts.Schedule> schedule;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1) {
                    return HelpViewState.copy$default(state, null, Resource.Status.LOADING, null, null, null, 29, null);
                }
                Unit unit = null;
                unit = null;
                if (i == 2) {
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                        HelpViewModel.this.notifyErrorMessage(message);
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        HelpViewModel helpViewModel = HelpViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        helpViewModel.notifySimpleError(error);
                    }
                    return HelpViewState.copy$default(state, null, Resource.Status.ERROR, null, null, null, 29, null);
                }
                if (i != 3) {
                    return state;
                }
                Resource.Status status = Resource.Status.SUCCESS;
                DomainCompanyContacts data = serverData.getData();
                String organization = data != null ? data.getOrganization() : null;
                DomainCompanyContacts data2 = serverData.getData();
                String address = data2 != null ? data2.getAddress() : null;
                DomainCompanyContacts data3 = serverData.getData();
                String supportPhone = data3 != null ? data3.getSupportPhone() : null;
                DomainCompanyContacts data4 = serverData.getData();
                String additionalPhone = data4 != null ? data4.getAdditionalPhone() : null;
                DomainCompanyContacts data5 = serverData.getData();
                if (data5 == null || (schedule = data5.getSchedule()) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    List<DomainCompanyContacts.Schedule> list = schedule;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (DomainCompanyContacts.Schedule schedule2 : list) {
                        arrayList.add(new CompanyContacts.Schedule(schedule2.getDays(), schedule2.getHours()));
                    }
                    listEmptyList = arrayList;
                }
                return HelpViewState.copy$default(state, null, status, null, null, new CompanyContacts(organization, address, supportPhone, additionalPhone, listEmptyList), 13, null);
            }
        });
    }

    public final void logout() {
        HelpViewState currentState = getCurrentState();
        Resource.Status status = Resource.Status.NONE;
        HelpViewState helpViewStateCopy = currentState.copy(status, status, CollectionsKt.emptyList(), null, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HelpViewModel$logout$$inlined$updateState$1(helpViewStateCopy, this, null), 3, null);
        getState().setValue(helpViewStateCopy);
    }
}
