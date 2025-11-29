package sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.family.DomainFamily;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.usecases.family.DeleteFromFamilyUseCase;
import com.sputnik.domain.usecases.family.GetFamilyUseCase;
import com.sputnik.domain.usecases.family.MakeAdminUseCase;
import com.sputnik.domain.usecases.profile.ResetAddressUseCase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import sputnik.axmor.com.sputnik.entities.family.Family;

/* compiled from: FamilyViewModel.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003BE\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00160\u00150\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00150\u00142\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00150\u00142\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u001b\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00150\u0014H\u0002¢\u0006\u0004\b\u001f\u0010\u0018J\u000f\u0010 \u001a\u00020\u001bH\u0016¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010!J\u0017\u0010#\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u001bH\u0016¢\u0006\u0004\b%\u0010!J\u0017\u0010&\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b&\u0010$J\u000f\u0010'\u001a\u00020\u001bH\u0016¢\u0006\u0004\b'\u0010!J\r\u0010(\u001a\u00020\u001b¢\u0006\u0004\b(\u0010!R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010)R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010*R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010+R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010,R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010-R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010.¨\u0006/"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewState;", "", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/domain/usecases/family/GetFamilyUseCase;", "getFamilyUseCase", "Lcom/sputnik/domain/usecases/family/DeleteFromFamilyUseCase;", "deleteFromFamilyUseCase", "Lcom/sputnik/domain/usecases/family/MakeAdminUseCase;", "makeAdminUseCase", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/domain/entities/family/DomainFamily;", "Lsputnik/axmor/com/sputnik/entities/family/Family;", "domainFamilyToFamilyMapper", "Lcom/sputnik/domain/usecases/profile/ResetAddressUseCase;", "resetAddressUseCase", "<init>", "(Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/domain/usecases/family/GetFamilyUseCase;Lcom/sputnik/domain/usecases/family/DeleteFromFamilyUseCase;Lcom/sputnik/domain/usecases/family/MakeAdminUseCase;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/domain/usecases/profile/ResetAddressUseCase;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "getFamilyFromServer", "()Landroidx/lifecycle/LiveData;", "", "id", "", "deleteFromFamilyFromServer", "(I)Landroidx/lifecycle/LiveData;", "makeAdminToServer", "resetAddress", "loadFamily", "()V", "loadFamilyIfNeeded", "deleteFromFamily", "(I)V", "handleNeedUpdate", "makeAdmin", "leaveFromFamily", "logout", "Lcom/sputnik/data/local/PrefManager;", "Lcom/sputnik/domain/usecases/family/GetFamilyUseCase;", "Lcom/sputnik/domain/usecases/family/DeleteFromFamilyUseCase;", "Lcom/sputnik/domain/usecases/family/MakeAdminUseCase;", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/domain/usecases/profile/ResetAddressUseCase;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyViewModel extends BaseViewModel<FamilyViewState> {
    private final DeleteFromFamilyUseCase deleteFromFamilyUseCase;
    private final ListMapper<DomainFamily, Family> domainFamilyToFamilyMapper;
    private final GetFamilyUseCase getFamilyUseCase;
    private final MakeAdminUseCase makeAdminUseCase;
    private final PrefManager prefManager;
    private final ResetAddressUseCase resetAddressUseCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilyViewModel(PrefManager prefManager, GetFamilyUseCase getFamilyUseCase, DeleteFromFamilyUseCase deleteFromFamilyUseCase, MakeAdminUseCase makeAdminUseCase, ListMapper<DomainFamily, Family> domainFamilyToFamilyMapper, ResetAddressUseCase resetAddressUseCase) {
        super(new FamilyViewState(null, null, null, null, null, null, null, 127, null), "javaClass");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(getFamilyUseCase, "getFamilyUseCase");
        Intrinsics.checkNotNullParameter(deleteFromFamilyUseCase, "deleteFromFamilyUseCase");
        Intrinsics.checkNotNullParameter(makeAdminUseCase, "makeAdminUseCase");
        Intrinsics.checkNotNullParameter(domainFamilyToFamilyMapper, "domainFamilyToFamilyMapper");
        Intrinsics.checkNotNullParameter(resetAddressUseCase, "resetAddressUseCase");
        this.prefManager = prefManager;
        this.getFamilyUseCase = getFamilyUseCase;
        this.deleteFromFamilyUseCase = deleteFromFamilyUseCase;
        this.makeAdminUseCase = makeAdminUseCase;
        this.domainFamilyToFamilyMapper = domainFamilyToFamilyMapper;
        this.resetAddressUseCase = resetAddressUseCase;
        loadFamily();
    }

    private final LiveData<Resource<List<DomainFamily>>> getFamilyFromServer() {
        Integer id;
        GetFamilyUseCase getFamilyUseCase = this.getFamilyUseCase;
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(getFamilyUseCase.invoke((currentAddress == null || (id = currentAddress.getId()) == null) ? -1 : id.intValue()), null, 0L, 3, null);
    }

    private final LiveData<Resource<Unit>> deleteFromFamilyFromServer(int id) {
        Integer id2;
        DeleteFromFamilyUseCase deleteFromFamilyUseCase = this.deleteFromFamilyUseCase;
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(deleteFromFamilyUseCase.invoke((currentAddress == null || (id2 = currentAddress.getId()) == null) ? -1 : id2.intValue(), id), null, 0L, 3, null);
    }

    private final LiveData<Resource<Unit>> makeAdminToServer(int id) {
        Integer id2;
        MakeAdminUseCase makeAdminUseCase = this.makeAdminUseCase;
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(makeAdminUseCase.invoke((currentAddress == null || (id2 = currentAddress.getId()) == null) ? -1 : id2.intValue(), id), null, 0L, 3, null);
    }

    private final LiveData<Resource<Unit>> resetAddress() {
        return FlowLiveDataConversions.asLiveData$default(this.resetAddressUseCase.invoke(), null, 0L, 3, null);
    }

    public final void loadFamilyIfNeeded() {
        if (getCurrentState().getServerState() == Resource.Status.NONE) {
            loadFamily();
        }
    }

    public void deleteFromFamily(int id) {
        FamilyViewState familyViewStateCopy$default = FamilyViewState.copy$default(getCurrentState(), null, null, null, null, new Event(Boolean.FALSE), null, null, 111, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FamilyViewModel$deleteFromFamily$$inlined$updateState$1(familyViewStateCopy$default, this, null), 3, null);
        getState().setValue(familyViewStateCopy$default);
        subscribeOnDataSource(deleteFromFamilyFromServer(id), new Function2<Resource<? extends Unit>, FamilyViewState, FamilyViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel.deleteFromFamily.2

            /* compiled from: FamilyViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel$deleteFromFamily$2$WhenMappings */
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
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ FamilyViewState invoke(Resource<? extends Unit> resource, FamilyViewState familyViewState) {
                return invoke2((Resource<Unit>) resource, familyViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final FamilyViewState invoke2(Resource<Unit> familyData, FamilyViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(familyData, "familyData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[familyData.getStatus().ordinal()];
                Unit unit = null;
                if (i == 1 || i == 2) {
                    return null;
                }
                if (i == 3) {
                    DomainEmpty errorMsg = familyData.getErrorMsg();
                    if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                        FamilyViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        FamilyViewModel familyViewModel = FamilyViewModel.this;
                        Exception error = familyData.getError();
                        Intrinsics.checkNotNull(error);
                        familyViewModel.notifySimpleError(error);
                    }
                    return FamilyViewState.copy$default(state, familyData.getStatus(), null, null, familyData.getError(), null, null, null, 118, null);
                }
                return FamilyViewState.copy$default(state, familyData.getStatus(), null, null, null, new Event(Boolean.TRUE), null, null, 102, null);
            }
        });
    }

    public void handleNeedUpdate() {
        FamilyViewState familyViewStateCopy$default = FamilyViewState.copy$default(getCurrentState(), null, null, null, null, null, null, new Event(Boolean.TRUE), 63, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FamilyViewModel$handleNeedUpdate$$inlined$updateState$1(familyViewStateCopy$default, this, null), 3, null);
        getState().setValue(familyViewStateCopy$default);
    }

    public void leaveFromFamily() {
        FamilyViewState familyViewStateCopy$default = FamilyViewState.copy$default(getCurrentState(), null, Resource.Status.LOADING, null, null, null, null, null, 125, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FamilyViewModel$leaveFromFamily$$inlined$updateState$1(familyViewStateCopy$default, this, null), 3, null);
        getState().setValue(familyViewStateCopy$default);
        subscribeOnDataSource(resetAddress(), new Function2<Resource<? extends Unit>, FamilyViewState, FamilyViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel.leaveFromFamily.2

            /* compiled from: FamilyViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel$leaveFromFamily$2$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.NONE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Resource.Status.LOADING.ordinal()] = 2;
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
            public /* bridge */ /* synthetic */ FamilyViewState invoke(Resource<? extends Unit> resource, FamilyViewState familyViewState) {
                return invoke2((Resource<Unit>) resource, familyViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final FamilyViewState invoke2(Resource<Unit> data, FamilyViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1) {
                    return state;
                }
                if (i == 2) {
                    return FamilyViewState.copy$default(state, null, Resource.Status.LOADING, null, null, null, null, null, 125, null);
                }
                if (i != 3) {
                    if (i == 4) {
                        return FamilyViewState.copy$default(state, null, data.getStatus(), null, null, null, null, null, 117, null);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                DomainEmpty errorMsg = data.getErrorMsg();
                if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                    unit = null;
                } else {
                    FamilyViewModel.this.notifyErrorMessage(message.toString());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    FamilyViewModel familyViewModel = FamilyViewModel.this;
                    Exception error = data.getError();
                    Intrinsics.checkNotNull(error);
                    familyViewModel.notifySimpleError(error);
                }
                return FamilyViewState.copy$default(state, null, data.getStatus(), null, data.getError(), null, null, null, 117, null);
            }
        });
    }

    public void loadFamily() {
        FamilyViewState familyViewStateCopy$default = FamilyViewState.copy$default(getCurrentState(), Resource.Status.LOADING, null, null, null, null, null, null, 126, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FamilyViewModel$loadFamily$$inlined$updateState$1(familyViewStateCopy$default, this, null), 3, null);
        getState().setValue(familyViewStateCopy$default);
        subscribeOnDataSource(getFamilyFromServer(), new Function2<Resource<? extends List<? extends DomainFamily>>, FamilyViewState, FamilyViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel.loadFamily.2

            /* compiled from: FamilyViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel$loadFamily$2$WhenMappings */
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
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ FamilyViewState invoke(Resource<? extends List<? extends DomainFamily>> resource, FamilyViewState familyViewState) {
                return invoke2((Resource<? extends List<DomainFamily>>) resource, familyViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final FamilyViewState invoke2(Resource<? extends List<DomainFamily>> familyData, FamilyViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(familyData, "familyData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[familyData.getStatus().ordinal()];
                Unit unit = null;
                if (i == 1 || i == 2) {
                    return null;
                }
                if (i == 3) {
                    DomainEmpty errorMsg = familyData.getErrorMsg();
                    if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                        FamilyViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        FamilyViewModel familyViewModel = FamilyViewModel.this;
                        Exception error = familyData.getError();
                        Intrinsics.checkNotNull(error);
                        familyViewModel.notifySimpleError(error);
                    }
                    return FamilyViewState.copy$default(state, familyData.getStatus(), null, null, familyData.getError(), null, null, null, 118, null);
                }
                Resource.Status status = familyData.getStatus();
                Event event = new Event(Boolean.FALSE);
                ListMapper listMapper = FamilyViewModel.this.domainFamilyToFamilyMapper;
                List<DomainFamily> data = familyData.getData();
                Intrinsics.checkNotNull(data);
                List<DomainFamily> list = data;
                FamilyViewModel familyViewModel2 = FamilyViewModel.this;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (DomainFamily domainFamily : list) {
                    arrayList.add(DomainFamily.copy$default(domainFamily, null, null, null, false, Intrinsics.areEqual(domainFamily.getPhone(), familyViewModel2.prefManager.getPhone()), false, null, 111, null));
                }
                return FamilyViewState.copy$default(state, status, null, listMapper.map(arrayList), null, null, null, event, 50, null);
            }
        });
    }

    public final void logout() {
        getCurrentState();
        FamilyViewState familyViewState = new FamilyViewState(null, null, null, null, null, null, null, 127, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FamilyViewModel$logout$$inlined$updateState$1(familyViewState, this, null), 3, null);
        getState().setValue(familyViewState);
    }

    public void makeAdmin(int id) {
        FamilyViewState familyViewStateCopy$default = FamilyViewState.copy$default(getCurrentState(), null, null, null, null, null, new Event(Boolean.FALSE), null, 95, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FamilyViewModel$makeAdmin$$inlined$updateState$1(familyViewStateCopy$default, this, null), 3, null);
        getState().setValue(familyViewStateCopy$default);
        subscribeOnDataSource(makeAdminToServer(id), new Function2<Resource<? extends Unit>, FamilyViewState, FamilyViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel.makeAdmin.2

            /* compiled from: FamilyViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel$makeAdmin$2$WhenMappings */
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
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ FamilyViewState invoke(Resource<? extends Unit> resource, FamilyViewState familyViewState) {
                return invoke2((Resource<Unit>) resource, familyViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final FamilyViewState invoke2(Resource<Unit> familyData, FamilyViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(familyData, "familyData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[familyData.getStatus().ordinal()];
                Unit unit = null;
                if (i == 1 || i == 2) {
                    return null;
                }
                if (i == 3) {
                    DomainEmpty errorMsg = familyData.getErrorMsg();
                    if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                        FamilyViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        FamilyViewModel familyViewModel = FamilyViewModel.this;
                        Exception error = familyData.getError();
                        Intrinsics.checkNotNull(error);
                        familyViewModel.notifySimpleError(error);
                    }
                    return FamilyViewState.copy$default(state, familyData.getStatus(), null, null, familyData.getError(), null, null, null, 118, null);
                }
                return FamilyViewState.copy$default(state, familyData.getStatus(), null, null, null, null, new Event(Boolean.TRUE), null, 86, null);
            }
        });
    }
}
