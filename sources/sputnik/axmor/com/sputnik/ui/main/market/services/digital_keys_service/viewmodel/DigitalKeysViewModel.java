package sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.viewmodel;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.digital_keys.DomainDigitalKey;
import com.sputnik.domain.entities.digital_keys.TypeDigitalKey;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.usecases.digital_keys.DeleteDigitalKeyForAddressUseCase;
import com.sputnik.domain.usecases.digital_keys.GetDigitalKeysForAddressUseCase;
import com.sputnik.domain.usecases.digital_keys.SetDigitalKeyForAddressUseCase;
import com.sputnik.subscriptions.analytics.OnlySubscriptionEvents;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import sputnik.axmor.com.sputnik.entities.digital_keys.DigitalKey;
import sputnik.axmor.com.sputnik.mappers.digital_keys.DomainDigitalKeyToDigitalKeyMapper;

/* compiled from: DigitalKeysViewModel.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B9\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00130\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00130\u00122\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00130\u00122\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010\"J\u000f\u0010$\u001a\u00020 H\u0016¢\u0006\u0004\b$\u0010\"J\u000f\u0010%\u001a\u00020 H\u0016¢\u0006\u0004\b%\u0010\"J\u000f\u0010&\u001a\u00020 H\u0016¢\u0006\u0004\b&\u0010\"J\r\u0010'\u001a\u00020 ¢\u0006\u0004\b'\u0010\"R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010(R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010)R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010*R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010+R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010,R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010-¨\u0006."}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/viewmodel/DigitalKeysViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lsputnik/axmor/com/sputnik/ui/main/market/services/digital_keys_service/viewmodel/DigitalKeysViewState;", "", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/domain/usecases/digital_keys/GetDigitalKeysForAddressUseCase;", "getDigitalKeysForAddressUseCase", "Lcom/sputnik/domain/usecases/digital_keys/SetDigitalKeyForAddressUseCase;", "setDigitalKeyForAddressUseCase", "Lcom/sputnik/domain/usecases/digital_keys/DeleteDigitalKeyForAddressUseCase;", "deleteDigitalKeyForAddressUseCase", "Lsputnik/axmor/com/sputnik/mappers/digital_keys/DomainDigitalKeyToDigitalKeyMapper;", "domainDigitalKeyToDigitalKeyMapper", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "<init>", "(Lcom/sputnik/common/analytics/Analytics;Lcom/sputnik/domain/usecases/digital_keys/GetDigitalKeysForAddressUseCase;Lcom/sputnik/domain/usecases/digital_keys/SetDigitalKeyForAddressUseCase;Lcom/sputnik/domain/usecases/digital_keys/DeleteDigitalKeyForAddressUseCase;Lsputnik/axmor/com/sputnik/mappers/digital_keys/DomainDigitalKeyToDigitalKeyMapper;Lcom/sputnik/data/local/PrefManager;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/digital_keys/DomainDigitalKey;", "getDigitalKeysForAddressFromServer", "()Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;", "type", "setDigitalKeysForAddressToServer", "(Lcom/sputnik/domain/entities/digital_keys/TypeDigitalKey;)Landroidx/lifecycle/LiveData;", "", "uuid", "deleteDigitalKeyForAddressFromServer", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "", "loadDigitalKeys", "()V", "createDigitalTempKey", "updateDigitalTempKey", "deleteDigitalTempKey", "updateDigitalPermKey", "clearState", "Lcom/sputnik/common/analytics/Analytics;", "Lcom/sputnik/domain/usecases/digital_keys/GetDigitalKeysForAddressUseCase;", "Lcom/sputnik/domain/usecases/digital_keys/SetDigitalKeyForAddressUseCase;", "Lcom/sputnik/domain/usecases/digital_keys/DeleteDigitalKeyForAddressUseCase;", "Lsputnik/axmor/com/sputnik/mappers/digital_keys/DomainDigitalKeyToDigitalKeyMapper;", "Lcom/sputnik/data/local/PrefManager;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DigitalKeysViewModel extends BaseViewModel<DigitalKeysViewState> {
    private final Analytics analytics;
    private final DeleteDigitalKeyForAddressUseCase deleteDigitalKeyForAddressUseCase;
    private final DomainDigitalKeyToDigitalKeyMapper domainDigitalKeyToDigitalKeyMapper;
    private final GetDigitalKeysForAddressUseCase getDigitalKeysForAddressUseCase;
    private final PrefManager prefManager;
    private final SetDigitalKeyForAddressUseCase setDigitalKeyForAddressUseCase;

    public DigitalKeysViewModel(Analytics analytics, GetDigitalKeysForAddressUseCase getDigitalKeysForAddressUseCase, SetDigitalKeyForAddressUseCase setDigitalKeyForAddressUseCase, DeleteDigitalKeyForAddressUseCase deleteDigitalKeyForAddressUseCase, DomainDigitalKeyToDigitalKeyMapper domainDigitalKeyToDigitalKeyMapper, PrefManager prefManager) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(getDigitalKeysForAddressUseCase, "getDigitalKeysForAddressUseCase");
        Intrinsics.checkNotNullParameter(setDigitalKeyForAddressUseCase, "setDigitalKeyForAddressUseCase");
        Intrinsics.checkNotNullParameter(deleteDigitalKeyForAddressUseCase, "deleteDigitalKeyForAddressUseCase");
        Intrinsics.checkNotNullParameter(domainDigitalKeyToDigitalKeyMapper, "domainDigitalKeyToDigitalKeyMapper");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        DigitalKeysViewState digitalKeysViewState = new DigitalKeysViewState(null, null, null, null, null, null, 63, null);
        String name = DigitalKeysViewState.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        super(digitalKeysViewState, name);
        this.analytics = analytics;
        this.getDigitalKeysForAddressUseCase = getDigitalKeysForAddressUseCase;
        this.setDigitalKeyForAddressUseCase = setDigitalKeyForAddressUseCase;
        this.deleteDigitalKeyForAddressUseCase = deleteDigitalKeyForAddressUseCase;
        this.domainDigitalKeyToDigitalKeyMapper = domainDigitalKeyToDigitalKeyMapper;
        this.prefManager = prefManager;
    }

    private final LiveData<Resource<List<DomainDigitalKey>>> getDigitalKeysForAddressFromServer() {
        Integer id;
        GetDigitalKeysForAddressUseCase getDigitalKeysForAddressUseCase = this.getDigitalKeysForAddressUseCase;
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(getDigitalKeysForAddressUseCase.invoke((currentAddress == null || (id = currentAddress.getId()) == null) ? -1 : id.intValue()), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainDigitalKey>> setDigitalKeysForAddressToServer(TypeDigitalKey type) {
        Integer id;
        SetDigitalKeyForAddressUseCase setDigitalKeyForAddressUseCase = this.setDigitalKeyForAddressUseCase;
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(setDigitalKeyForAddressUseCase.invoke((currentAddress == null || (id = currentAddress.getId()) == null) ? -1 : id.intValue(), type), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainDigitalKey>> deleteDigitalKeyForAddressFromServer(String uuid) {
        Integer id;
        DeleteDigitalKeyForAddressUseCase deleteDigitalKeyForAddressUseCase = this.deleteDigitalKeyForAddressUseCase;
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(deleteDigitalKeyForAddressUseCase.invoke((currentAddress == null || (id = currentAddress.getId()) == null) ? -1 : id.intValue(), uuid), null, 0L, 3, null);
    }

    public final void loadDigitalKeys() {
        subscribeOnDataSource(getDigitalKeysForAddressFromServer(), new Function2<Resource<? extends List<? extends DomainDigitalKey>>, DigitalKeysViewState, DigitalKeysViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.viewmodel.DigitalKeysViewModel.loadDigitalKeys.1

            /* compiled from: DigitalKeysViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.viewmodel.DigitalKeysViewModel$loadDigitalKeys$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ DigitalKeysViewState invoke(Resource<? extends List<? extends DomainDigitalKey>> resource, DigitalKeysViewState digitalKeysViewState) {
                return invoke2((Resource<? extends List<DomainDigitalKey>>) resource, digitalKeysViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final DigitalKeysViewState invoke2(Resource<? extends List<DomainDigitalKey>> serverData, DigitalKeysViewState state) {
                String message;
                Object next;
                Object next2;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return DigitalKeysViewState.copy$default(state, Resource.Status.LOADING, null, null, null, null, null, 62, null);
                }
                Unit unit = null;
                unit = null;
                if (i == 3) {
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                        DigitalKeysViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        DigitalKeysViewModel digitalKeysViewModel = DigitalKeysViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        digitalKeysViewModel.notifySimpleError(error);
                    }
                    return DigitalKeysViewState.copy$default(state, Resource.Status.ERROR, null, null, null, null, null, 62, null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                List<DomainDigitalKey> data = serverData.getData();
                Intrinsics.checkNotNull(data);
                Iterator<T> it = data.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (((DomainDigitalKey) next).getType() == TypeDigitalKey.temp) {
                        break;
                    }
                }
                DomainDigitalKey domainDigitalKey = (DomainDigitalKey) next;
                List<DomainDigitalKey> data2 = serverData.getData();
                Intrinsics.checkNotNull(data2);
                Iterator<T> it2 = data2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    if (((DomainDigitalKey) next2).getType() == TypeDigitalKey.perm) {
                        break;
                    }
                }
                DomainDigitalKey domainDigitalKey2 = (DomainDigitalKey) next2;
                return DigitalKeysViewState.copy$default(state, Resource.Status.SUCCESS, domainDigitalKey != null ? DigitalKeysViewModel.this.domainDigitalKeyToDigitalKeyMapper.map(domainDigitalKey) : null, domainDigitalKey2 != null ? DigitalKeysViewModel.this.domainDigitalKeyToDigitalKeyMapper.map(domainDigitalKey2) : null, null, null, null, 56, null);
            }
        });
    }

    public void createDigitalTempKey() {
        subscribeOnDataSource(setDigitalKeysForAddressToServer(TypeDigitalKey.temp), new Function2<Resource<? extends DomainDigitalKey>, DigitalKeysViewState, DigitalKeysViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.viewmodel.DigitalKeysViewModel.createDigitalTempKey.1

            /* compiled from: DigitalKeysViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.viewmodel.DigitalKeysViewModel$createDigitalTempKey$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ DigitalKeysViewState invoke(Resource<? extends DomainDigitalKey> resource, DigitalKeysViewState digitalKeysViewState) {
                return invoke2((Resource<DomainDigitalKey>) resource, digitalKeysViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final DigitalKeysViewState invoke2(Resource<DomainDigitalKey> serverData, DigitalKeysViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return DigitalKeysViewState.copy$default(state, Resource.Status.LOADING, null, null, null, null, null, 62, null);
                }
                Unit unit = null;
                unit = null;
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    DigitalKeysViewModel.this.analytics.trackLogEvent(new OnlySubscriptionEvents.ClickAddNewTempCode());
                    Event event = new Event(Boolean.TRUE);
                    DomainDigitalKey data = serverData.getData();
                    return DigitalKeysViewState.copy$default(state, Resource.Status.SUCCESS, data != null ? DigitalKeysViewModel.this.domainDigitalKeyToDigitalKeyMapper.map(data) : null, null, event, null, null, 52, null);
                }
                DomainEmpty errorMsg = serverData.getErrorMsg();
                if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                    DigitalKeysViewModel.this.notifyErrorMessage(message.toString());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    DigitalKeysViewModel digitalKeysViewModel = DigitalKeysViewModel.this;
                    Exception error = serverData.getError();
                    Intrinsics.checkNotNull(error);
                    digitalKeysViewModel.notifySimpleError(error);
                }
                return DigitalKeysViewState.copy$default(state, Resource.Status.ERROR, null, null, null, null, null, 62, null);
            }
        });
    }

    public final void clearState() {
        DigitalKeysViewState currentState = getCurrentState();
        Resource.Status status = Resource.Status.LOADING;
        Boolean bool = Boolean.FALSE;
        Event<Boolean> event = new Event<>(bool);
        DigitalKeysViewState digitalKeysViewStateCopy = currentState.copy(status, null, null, new Event<>(bool), new Event<>(bool), event);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DigitalKeysViewModel$clearState$$inlined$updateState$1(digitalKeysViewStateCopy, this, null), 3, null);
        getState().setValue(digitalKeysViewStateCopy);
    }

    public void updateDigitalTempKey() {
        subscribeOnDataSource(setDigitalKeysForAddressToServer(TypeDigitalKey.temp), new Function2<Resource<? extends DomainDigitalKey>, DigitalKeysViewState, DigitalKeysViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.viewmodel.DigitalKeysViewModel.updateDigitalTempKey.1

            /* compiled from: DigitalKeysViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.viewmodel.DigitalKeysViewModel$updateDigitalTempKey$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ DigitalKeysViewState invoke(Resource<? extends DomainDigitalKey> resource, DigitalKeysViewState digitalKeysViewState) {
                return invoke2((Resource<DomainDigitalKey>) resource, digitalKeysViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final DigitalKeysViewState invoke2(Resource<DomainDigitalKey> serverData, DigitalKeysViewState state) {
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return DigitalKeysViewState.copy$default(state, Resource.Status.LOADING, null, null, null, null, null, 62, null);
                }
                Unit unit = null;
                unit = null;
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    DigitalKeysViewModel.this.analytics.trackLogEvent(new OnlySubscriptionEvents.ClickRenewTempCode());
                    Event event = new Event(Boolean.TRUE);
                    DomainDigitalKey data = serverData.getData();
                    return DigitalKeysViewState.copy$default(state, Resource.Status.SUCCESS, data != null ? DigitalKeysViewModel.this.domainDigitalKeyToDigitalKeyMapper.map(data) : null, null, event, null, null, 52, null);
                }
                DomainEmpty errorMsg = serverData.getErrorMsg();
                if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                    DigitalKeysViewModel.this.notifyErrorMessage(message.toString());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    DigitalKeysViewModel digitalKeysViewModel = DigitalKeysViewModel.this;
                    Exception error = serverData.getError();
                    Intrinsics.checkNotNull(error);
                    digitalKeysViewModel.notifySimpleError(error);
                }
                return DigitalKeysViewState.copy$default(state, Resource.Status.ERROR, null, null, null, null, null, 62, null);
            }
        });
    }

    public void deleteDigitalTempKey() {
        DigitalKey tempCode = getCurrentState().getTempCode();
        if (tempCode == null || tempCode.getUuid() == null) {
            return;
        }
        DigitalKey tempCode2 = getCurrentState().getTempCode();
        String uuid = tempCode2 != null ? tempCode2.getUuid() : null;
        Intrinsics.checkNotNull(uuid);
        subscribeOnDataSource(deleteDigitalKeyForAddressFromServer(uuid), new Function2<Resource<? extends DomainDigitalKey>, DigitalKeysViewState, DigitalKeysViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.viewmodel.DigitalKeysViewModel.deleteDigitalTempKey.1

            /* compiled from: DigitalKeysViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.viewmodel.DigitalKeysViewModel$deleteDigitalTempKey$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ DigitalKeysViewState invoke(Resource<? extends DomainDigitalKey> resource, DigitalKeysViewState digitalKeysViewState) {
                return invoke2((Resource<DomainDigitalKey>) resource, digitalKeysViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final DigitalKeysViewState invoke2(Resource<DomainDigitalKey> serverData, DigitalKeysViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return DigitalKeysViewState.copy$default(state, Resource.Status.LOADING, null, null, null, null, null, 62, null);
                }
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Intrinsics.checkNotNull(serverData.getData());
                    DigitalKeysViewModel.this.analytics.trackLogEvent(new OnlySubscriptionEvents.ClickDeleteTempCode());
                    return DigitalKeysViewState.copy$default(state, Resource.Status.SUCCESS, null, null, null, null, new Event(Boolean.TRUE), 28, null);
                }
                DomainEmpty errorMsg = serverData.getErrorMsg();
                if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                    unit = null;
                } else {
                    DigitalKeysViewModel.this.notifyErrorMessage(message.toString());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    DigitalKeysViewModel digitalKeysViewModel = DigitalKeysViewModel.this;
                    Exception error = serverData.getError();
                    Intrinsics.checkNotNull(error);
                    digitalKeysViewModel.notifySimpleError(error);
                }
                return DigitalKeysViewState.copy$default(state, Resource.Status.ERROR, null, null, null, null, null, 62, null);
            }
        });
    }

    public void updateDigitalPermKey() {
        subscribeOnDataSource(setDigitalKeysForAddressToServer(TypeDigitalKey.perm), new Function2<Resource<? extends DomainDigitalKey>, DigitalKeysViewState, DigitalKeysViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.viewmodel.DigitalKeysViewModel.updateDigitalPermKey.1

            /* compiled from: DigitalKeysViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.viewmodel.DigitalKeysViewModel$updateDigitalPermKey$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ DigitalKeysViewState invoke(Resource<? extends DomainDigitalKey> resource, DigitalKeysViewState digitalKeysViewState) {
                return invoke2((Resource<DomainDigitalKey>) resource, digitalKeysViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final DigitalKeysViewState invoke2(Resource<DomainDigitalKey> serverData, DigitalKeysViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return DigitalKeysViewState.copy$default(state, Resource.Status.LOADING, null, null, null, null, null, 62, null);
                }
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    DomainDigitalKey data = serverData.getData();
                    Intrinsics.checkNotNull(data);
                    DigitalKeysViewModel.this.analytics.trackLogEvent(new OnlySubscriptionEvents.ClickRenewPermCode());
                    return DigitalKeysViewState.copy$default(state, Resource.Status.SUCCESS, null, DigitalKeysViewModel.this.domainDigitalKeyToDigitalKeyMapper.map(data), null, new Event(Boolean.TRUE), null, 42, null);
                }
                DomainEmpty errorMsg = serverData.getErrorMsg();
                if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                    unit = null;
                } else {
                    DigitalKeysViewModel.this.notifyErrorMessage(message.toString());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    DigitalKeysViewModel digitalKeysViewModel = DigitalKeysViewModel.this;
                    Exception error = serverData.getError();
                    Intrinsics.checkNotNull(error);
                    digitalKeysViewModel.notifySimpleError(error);
                }
                return DigitalKeysViewState.copy$default(state, Resource.Status.ERROR, null, null, null, null, null, 62, null);
            }
        });
    }
}
