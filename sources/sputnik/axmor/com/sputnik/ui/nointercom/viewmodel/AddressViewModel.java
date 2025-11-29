package sputnik.axmor.com.sputnik.ui.nointercom.viewmodel;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.address.DomainCustomAddress;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.usecases.address.DeleteCustomAddressUseCase;
import com.sputnik.domain.usecases.address.GetCustomAddressUseCase;
import com.sputnik.domain.usecases.address.SetCustomAddressUseCase;
import com.sputnik.domain.usecases.address.UpdateCustomAddressUseCase;
import java.util.List;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: AddressViewModel.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f0\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013JC\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000f0\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJK\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000f0\u000e2\u0006\u0010\u001b\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\"\u0010 J\u0017\u0010#\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016¢\u0006\u0004\b%\u0010$J\u0017\u0010&\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b&\u0010$J\u0017\u0010'\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0014H\u0016¢\u0006\u0004\b'\u0010$R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010.\u001a\u0004\b/\u00100R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00101\u001a\u0004\b2\u00103¨\u00064"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/nointercom/viewmodel/AddressViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lsputnik/axmor/com/sputnik/ui/nointercom/viewmodel/AddressViewState;", "", "Lcom/sputnik/domain/usecases/address/GetCustomAddressUseCase;", "getCustomAddressUseCase", "Lcom/sputnik/domain/usecases/address/DeleteCustomAddressUseCase;", "deleteCustomAddressUseCase", "Lcom/sputnik/domain/usecases/address/SetCustomAddressUseCase;", "setNewCustomAddressUseCase", "Lcom/sputnik/domain/usecases/address/UpdateCustomAddressUseCase;", "updateCustomAddressUseCase", "<init>", "(Lcom/sputnik/domain/usecases/address/GetCustomAddressUseCase;Lcom/sputnik/domain/usecases/address/DeleteCustomAddressUseCase;Lcom/sputnik/domain/usecases/address/SetCustomAddressUseCase;Lcom/sputnik/domain/usecases/address/UpdateCustomAddressUseCase;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/address/DomainCustomAddress;", "getCustomAddressFromServer", "()Landroidx/lifecycle/LiveData;", "", "city", "street", "house", "flat", "setNewCustomAddressToServer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "uuid", "updateCustomAddressToServer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "", "loadCustomAddress", "()V", "setCustomAddress", "updateCustomAddress", "handleCity", "(Ljava/lang/String;)V", "handleStreet", "handleHouse", "handleFlat", "Lcom/sputnik/domain/usecases/address/GetCustomAddressUseCase;", "getGetCustomAddressUseCase", "()Lcom/sputnik/domain/usecases/address/GetCustomAddressUseCase;", "Lcom/sputnik/domain/usecases/address/DeleteCustomAddressUseCase;", "getDeleteCustomAddressUseCase", "()Lcom/sputnik/domain/usecases/address/DeleteCustomAddressUseCase;", "Lcom/sputnik/domain/usecases/address/SetCustomAddressUseCase;", "getSetNewCustomAddressUseCase", "()Lcom/sputnik/domain/usecases/address/SetCustomAddressUseCase;", "Lcom/sputnik/domain/usecases/address/UpdateCustomAddressUseCase;", "getUpdateCustomAddressUseCase", "()Lcom/sputnik/domain/usecases/address/UpdateCustomAddressUseCase;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddressViewModel extends BaseViewModel<AddressViewState> {
    private final DeleteCustomAddressUseCase deleteCustomAddressUseCase;
    private final GetCustomAddressUseCase getCustomAddressUseCase;
    private final SetCustomAddressUseCase setNewCustomAddressUseCase;
    private final UpdateCustomAddressUseCase updateCustomAddressUseCase;

    public AddressViewModel(GetCustomAddressUseCase getCustomAddressUseCase, DeleteCustomAddressUseCase deleteCustomAddressUseCase, SetCustomAddressUseCase setNewCustomAddressUseCase, UpdateCustomAddressUseCase updateCustomAddressUseCase) {
        Intrinsics.checkNotNullParameter(getCustomAddressUseCase, "getCustomAddressUseCase");
        Intrinsics.checkNotNullParameter(deleteCustomAddressUseCase, "deleteCustomAddressUseCase");
        Intrinsics.checkNotNullParameter(setNewCustomAddressUseCase, "setNewCustomAddressUseCase");
        Intrinsics.checkNotNullParameter(updateCustomAddressUseCase, "updateCustomAddressUseCase");
        AddressViewState addressViewState = new AddressViewState(null, null, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
        String name = AddressViewModel.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        super(addressViewState, name);
        this.getCustomAddressUseCase = getCustomAddressUseCase;
        this.deleteCustomAddressUseCase = deleteCustomAddressUseCase;
        this.setNewCustomAddressUseCase = setNewCustomAddressUseCase;
        this.updateCustomAddressUseCase = updateCustomAddressUseCase;
    }

    private final LiveData<Resource<List<DomainCustomAddress>>> getCustomAddressFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.getCustomAddressUseCase.invoke(), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainCustomAddress>> setNewCustomAddressToServer(String city, String street, String house, String flat) {
        return FlowLiveDataConversions.asLiveData$default(this.setNewCustomAddressUseCase.invoke(city, street, house, flat), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainCustomAddress>> updateCustomAddressToServer(String uuid, String city, String street, String house, String flat) {
        return FlowLiveDataConversions.asLiveData$default(this.updateCustomAddressUseCase.invoke(uuid, city, street, house, flat), null, 0L, 3, null);
    }

    public void loadCustomAddress() {
        subscribeOnDataSource(getCustomAddressFromServer(), new Function2<Resource<? extends List<? extends DomainCustomAddress>>, AddressViewState, AddressViewState>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.viewmodel.AddressViewModel.loadCustomAddress.1

            /* compiled from: AddressViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.nointercom.viewmodel.AddressViewModel$loadCustomAddress$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ AddressViewState invoke(Resource<? extends List<? extends DomainCustomAddress>> resource, AddressViewState addressViewState) {
                return invoke2((Resource<? extends List<DomainCustomAddress>>) resource, addressViewState);
            }

            /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final sputnik.axmor.com.sputnik.ui.nointercom.viewmodel.AddressViewState invoke2(com.sputnik.domain.common.Resource<? extends java.util.List<com.sputnik.domain.entities.address.DomainCustomAddress>> r13, sputnik.axmor.com.sputnik.ui.nointercom.viewmodel.AddressViewState r14) {
                /*
                    Method dump skipped, instructions count: 245
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.nointercom.viewmodel.AddressViewModel.AnonymousClass1.invoke2(com.sputnik.domain.common.Resource, sputnik.axmor.com.sputnik.ui.nointercom.viewmodel.AddressViewState):sputnik.axmor.com.sputnik.ui.nointercom.viewmodel.AddressViewState");
            }
        });
    }

    public void handleCity(String city) {
        Intrinsics.checkNotNullParameter(city, "city");
        AddressViewState currentState = getCurrentState();
        AddressViewState addressViewStateCopy = currentState.copy((128 & 1) != 0 ? currentState.serverState : null, (128 & 2) != 0 ? currentState.customAddress : null, (128 & 4) != 0 ? currentState.uuid : null, (128 & 8) != 0 ? currentState.city : city, (128 & 16) != 0 ? currentState.street : null, (128 & 32) != 0 ? currentState.house : null, (128 & 64) != 0 ? currentState.flat : null, (128 & 128) != 0 ? currentState.isDeleted : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AddressViewModel$handleCity$$inlined$updateState$1(addressViewStateCopy, this, null), 3, null);
        getState().setValue(addressViewStateCopy);
    }

    public void handleFlat(String flat) {
        Intrinsics.checkNotNullParameter(flat, "flat");
        AddressViewState currentState = getCurrentState();
        AddressViewState addressViewStateCopy = currentState.copy((128 & 1) != 0 ? currentState.serverState : null, (128 & 2) != 0 ? currentState.customAddress : null, (128 & 4) != 0 ? currentState.uuid : null, (128 & 8) != 0 ? currentState.city : null, (128 & 16) != 0 ? currentState.street : null, (128 & 32) != 0 ? currentState.house : null, (128 & 64) != 0 ? currentState.flat : flat, (128 & 128) != 0 ? currentState.isDeleted : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AddressViewModel$handleFlat$$inlined$updateState$1(addressViewStateCopy, this, null), 3, null);
        getState().setValue(addressViewStateCopy);
    }

    public void handleHouse(String house) {
        Intrinsics.checkNotNullParameter(house, "house");
        AddressViewState currentState = getCurrentState();
        AddressViewState addressViewStateCopy = currentState.copy((128 & 1) != 0 ? currentState.serverState : null, (128 & 2) != 0 ? currentState.customAddress : null, (128 & 4) != 0 ? currentState.uuid : null, (128 & 8) != 0 ? currentState.city : null, (128 & 16) != 0 ? currentState.street : null, (128 & 32) != 0 ? currentState.house : house, (128 & 64) != 0 ? currentState.flat : null, (128 & 128) != 0 ? currentState.isDeleted : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AddressViewModel$handleHouse$$inlined$updateState$1(addressViewStateCopy, this, null), 3, null);
        getState().setValue(addressViewStateCopy);
    }

    public void handleStreet(String street) {
        Intrinsics.checkNotNullParameter(street, "street");
        AddressViewState currentState = getCurrentState();
        AddressViewState addressViewStateCopy = currentState.copy((128 & 1) != 0 ? currentState.serverState : null, (128 & 2) != 0 ? currentState.customAddress : null, (128 & 4) != 0 ? currentState.uuid : null, (128 & 8) != 0 ? currentState.city : null, (128 & 16) != 0 ? currentState.street : street, (128 & 32) != 0 ? currentState.house : null, (128 & 64) != 0 ? currentState.flat : null, (128 & 128) != 0 ? currentState.isDeleted : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AddressViewModel$handleStreet$$inlined$updateState$1(addressViewStateCopy, this, null), 3, null);
        getState().setValue(addressViewStateCopy);
    }

    public void setCustomAddress() {
        if (getCurrentState().getUuid() != null) {
            updateCustomAddress();
        } else {
            AddressViewState currentState = getCurrentState();
            subscribeOnDataSource(setNewCustomAddressToServer(currentState.getCity(), currentState.getStreet(), currentState.getHouse(), currentState.getFlat()), new Function2<Resource<? extends DomainCustomAddress>, AddressViewState, AddressViewState>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.viewmodel.AddressViewModel.setCustomAddress.2

                /* compiled from: AddressViewModel.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                /* renamed from: sputnik.axmor.com.sputnik.ui.nointercom.viewmodel.AddressViewModel$setCustomAddress$2$WhenMappings */
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
                public /* bridge */ /* synthetic */ AddressViewState invoke(Resource<? extends DomainCustomAddress> resource, AddressViewState addressViewState) {
                    return invoke2((Resource<DomainCustomAddress>) resource, addressViewState);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final AddressViewState invoke2(Resource<DomainCustomAddress> serverData, AddressViewState state) {
                    Unit unit;
                    String message;
                    Intrinsics.checkNotNullParameter(serverData, "serverData");
                    Intrinsics.checkNotNullParameter(state, "state");
                    int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                    if (i == 1 || i == 2) {
                        return state.copy((128 & 1) != 0 ? state.serverState : Resource.Status.LOADING, (128 & 2) != 0 ? state.customAddress : null, (128 & 4) != 0 ? state.uuid : null, (128 & 8) != 0 ? state.city : null, (128 & 16) != 0 ? state.street : null, (128 & 32) != 0 ? state.house : null, (128 & 64) != 0 ? state.flat : null, (128 & 128) != 0 ? state.isDeleted : null);
                    }
                    if (i != 3) {
                        if (i != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        AddressViewModel.this.loadCustomAddress();
                        return state.copy((128 & 1) != 0 ? state.serverState : Resource.Status.SUCCESS, (128 & 2) != 0 ? state.customAddress : null, (128 & 4) != 0 ? state.uuid : null, (128 & 8) != 0 ? state.city : null, (128 & 16) != 0 ? state.street : null, (128 & 32) != 0 ? state.house : null, (128 & 64) != 0 ? state.flat : null, (128 & 128) != 0 ? state.isDeleted : null);
                    }
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                        unit = null;
                    } else {
                        AddressViewModel.this.notifyErrorMessage(message);
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        AddressViewModel addressViewModel = AddressViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        addressViewModel.notifySimpleError(error);
                    }
                    return state.copy((128 & 1) != 0 ? state.serverState : Resource.Status.ERROR, (128 & 2) != 0 ? state.customAddress : null, (128 & 4) != 0 ? state.uuid : null, (128 & 8) != 0 ? state.city : null, (128 & 16) != 0 ? state.street : null, (128 & 32) != 0 ? state.house : null, (128 & 64) != 0 ? state.flat : null, (128 & 128) != 0 ? state.isDeleted : null);
                }
            });
        }
    }

    public void updateCustomAddress() {
        AddressViewState currentState = getCurrentState();
        String uuid = currentState.getUuid();
        Intrinsics.checkNotNull(uuid);
        subscribeOnDataSource(updateCustomAddressToServer(uuid, currentState.getCity(), currentState.getStreet(), currentState.getHouse(), currentState.getFlat()), new Function2<Resource<? extends DomainCustomAddress>, AddressViewState, AddressViewState>() { // from class: sputnik.axmor.com.sputnik.ui.nointercom.viewmodel.AddressViewModel.updateCustomAddress.2

            /* compiled from: AddressViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.nointercom.viewmodel.AddressViewModel$updateCustomAddress$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ AddressViewState invoke(Resource<? extends DomainCustomAddress> resource, AddressViewState addressViewState) {
                return invoke2((Resource<DomainCustomAddress>) resource, addressViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final AddressViewState invoke2(Resource<DomainCustomAddress> serverData, AddressViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return state.copy((128 & 1) != 0 ? state.serverState : Resource.Status.LOADING, (128 & 2) != 0 ? state.customAddress : null, (128 & 4) != 0 ? state.uuid : null, (128 & 8) != 0 ? state.city : null, (128 & 16) != 0 ? state.street : null, (128 & 32) != 0 ? state.house : null, (128 & 64) != 0 ? state.flat : null, (128 & 128) != 0 ? state.isDeleted : null);
                }
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    AddressViewModel.this.loadCustomAddress();
                    return state.copy((128 & 1) != 0 ? state.serverState : Resource.Status.SUCCESS, (128 & 2) != 0 ? state.customAddress : null, (128 & 4) != 0 ? state.uuid : null, (128 & 8) != 0 ? state.city : null, (128 & 16) != 0 ? state.street : null, (128 & 32) != 0 ? state.house : null, (128 & 64) != 0 ? state.flat : null, (128 & 128) != 0 ? state.isDeleted : null);
                }
                DomainEmpty errorMsg = serverData.getErrorMsg();
                if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                    unit = null;
                } else {
                    AddressViewModel.this.notifyErrorMessage(message);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    AddressViewModel addressViewModel = AddressViewModel.this;
                    Exception error = serverData.getError();
                    Intrinsics.checkNotNull(error);
                    addressViewModel.notifySimpleError(error);
                }
                return state.copy((128 & 1) != 0 ? state.serverState : Resource.Status.ERROR, (128 & 2) != 0 ? state.customAddress : null, (128 & 4) != 0 ? state.uuid : null, (128 & 8) != 0 ? state.city : null, (128 & 16) != 0 ? state.street : null, (128 & 32) != 0 ? state.house : null, (128 & 64) != 0 ? state.flat : null, (128 & 128) != 0 ? state.isDeleted : null);
            }
        });
    }
}
