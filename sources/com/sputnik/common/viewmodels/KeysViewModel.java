package com.sputnik.common.viewmodels;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.KeysEvents;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.common.di.use_cases.keys.BlockPhysicalKeyUseCase;
import com.sputnik.common.di.use_cases.keys.CreatePhysicalKeyUseCase;
import com.sputnik.common.di.use_cases.keys.DeletePhysicalKeyUseCase;
import com.sputnik.common.di.use_cases.keys.GetPhysicalKeysUseCase;
import com.sputnik.common.di.use_cases.keys.UnblockPhysicalKeyUseCase;
import com.sputnik.common.di.use_cases.keys.UpdatePhysicalKeyCommentUseCase;
import com.sputnik.common.entities.keys.PhysicalKey;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.keys.PhysicalKeysLocale;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.mappers.keys.DomainPhysicalKeyToPhysicalKeyMapper;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.keys.DomainPhysicalKey;
import com.sputnik.domain.entities.prefs.LoginState;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: KeysViewModel.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003Ba\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d0\u001cH\u0002¢\u0006\u0004\b \u0010!J+\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001d0\u001c2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002¢\u0006\u0004\b%\u0010&J#\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001d0\u001c2\u0006\u0010'\u001a\u00020\"H\u0002¢\u0006\u0004\b(\u0010)J#\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001d0\u001c2\u0006\u0010'\u001a\u00020\"H\u0002¢\u0006\u0004\b*\u0010)J#\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001d0\u001c2\u0006\u0010'\u001a\u00020\"H\u0002¢\u0006\u0004\b+\u0010)J+\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001d0\u001c2\u0006\u0010'\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002¢\u0006\u0004\b,\u0010&J\r\u0010.\u001a\u00020-¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020-H\u0016¢\u0006\u0004\b0\u0010/J\u0017\u00103\u001a\u00020-2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u001f\u00105\u001a\u00020-2\u0006\u00102\u001a\u0002012\u0006\u0010$\u001a\u00020\"H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020-2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b7\u00104J\u0017\u00108\u001a\u00020-2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b8\u00104J\r\u00109\u001a\u00020-¢\u0006\u0004\b9\u0010/J\r\u0010:\u001a\u00020-¢\u0006\u0004\b:\u0010/R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010;R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010<R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010=R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010>R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010?R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010@R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010AR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010BR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010CR\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010DR\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010E¨\u0006F"}, d2 = {"Lcom/sputnik/common/viewmodels/KeysViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/KeysViewState;", "", "Lcom/sputnik/common/di/use_cases/keys/GetPhysicalKeysUseCase;", "getPhysicalKeysUseCase", "Lcom/sputnik/common/di/use_cases/keys/CreatePhysicalKeyUseCase;", "createPhysicalKeyUseCase", "Lcom/sputnik/common/di/use_cases/keys/BlockPhysicalKeyUseCase;", "blockPhysicalKeyUseCase", "Lcom/sputnik/common/di/use_cases/keys/UnblockPhysicalKeyUseCase;", "unblockPhysicalKeyUseCase", "Lcom/sputnik/common/di/use_cases/keys/DeletePhysicalKeyUseCase;", "deletePhysicalKeyUseCase", "Lcom/sputnik/common/di/use_cases/keys/UpdatePhysicalKeyCommentUseCase;", "updatePhysicalKeyCommentUseCase", "Lcom/sputnik/common/mappers/keys/DomainPhysicalKeyToPhysicalKeyMapper;", "domainMapper", "Lcom/sputnik/data/IConfig;", "config", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/common/localization/LocalizationStorage;", "localization", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "<init>", "(Lcom/sputnik/common/di/use_cases/keys/GetPhysicalKeysUseCase;Lcom/sputnik/common/di/use_cases/keys/CreatePhysicalKeyUseCase;Lcom/sputnik/common/di/use_cases/keys/BlockPhysicalKeyUseCase;Lcom/sputnik/common/di/use_cases/keys/UnblockPhysicalKeyUseCase;Lcom/sputnik/common/di/use_cases/keys/DeletePhysicalKeyUseCase;Lcom/sputnik/common/di/use_cases/keys/UpdatePhysicalKeyCommentUseCase;Lcom/sputnik/common/mappers/keys/DomainPhysicalKeyToPhysicalKeyMapper;Lcom/sputnik/data/IConfig;Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/common/localization/LocalizationStorage;Lcom/sputnik/common/analytics/Analytics;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/keys/DomainPhysicalKey;", "getKeysFromServer", "()Landroidx/lifecycle/LiveData;", "", "hex", FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, "createKeyOnServer", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "uuid", "blockKeyOnServer", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "unblockKeyOnServer", "deleteKeyOnServer", "updateKeyCommentOnServer", "", "getKeysIfNeeded", "()V", "getKeys", "Lcom/sputnik/common/entities/keys/PhysicalKey;", "key", "addKey", "(Lcom/sputnik/common/entities/keys/PhysicalKey;)V", "updateKeyComment", "(Lcom/sputnik/common/entities/keys/PhysicalKey;Ljava/lang/String;)V", "deleteKey", "lockOrUnlockKey", "clearKeyManageState", "logout", "Lcom/sputnik/common/di/use_cases/keys/GetPhysicalKeysUseCase;", "Lcom/sputnik/common/di/use_cases/keys/CreatePhysicalKeyUseCase;", "Lcom/sputnik/common/di/use_cases/keys/BlockPhysicalKeyUseCase;", "Lcom/sputnik/common/di/use_cases/keys/UnblockPhysicalKeyUseCase;", "Lcom/sputnik/common/di/use_cases/keys/DeletePhysicalKeyUseCase;", "Lcom/sputnik/common/di/use_cases/keys/UpdatePhysicalKeyCommentUseCase;", "Lcom/sputnik/common/mappers/keys/DomainPhysicalKeyToPhysicalKeyMapper;", "Lcom/sputnik/data/IConfig;", "Lcom/sputnik/data/local/PrefManager;", "Lcom/sputnik/common/localization/LocalizationStorage;", "Lcom/sputnik/common/analytics/Analytics;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KeysViewModel extends BaseViewModel<KeysViewState> {
    private final Analytics analytics;
    private final BlockPhysicalKeyUseCase blockPhysicalKeyUseCase;
    private final IConfig config;
    private final CreatePhysicalKeyUseCase createPhysicalKeyUseCase;
    private final DeletePhysicalKeyUseCase deletePhysicalKeyUseCase;
    private final DomainPhysicalKeyToPhysicalKeyMapper domainMapper;
    private final GetPhysicalKeysUseCase getPhysicalKeysUseCase;
    private final LocalizationStorage localization;
    private final PrefManager prefManager;
    private final UnblockPhysicalKeyUseCase unblockPhysicalKeyUseCase;
    private final UpdatePhysicalKeyCommentUseCase updatePhysicalKeyCommentUseCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeysViewModel(GetPhysicalKeysUseCase getPhysicalKeysUseCase, CreatePhysicalKeyUseCase createPhysicalKeyUseCase, BlockPhysicalKeyUseCase blockPhysicalKeyUseCase, UnblockPhysicalKeyUseCase unblockPhysicalKeyUseCase, DeletePhysicalKeyUseCase deletePhysicalKeyUseCase, UpdatePhysicalKeyCommentUseCase updatePhysicalKeyCommentUseCase, DomainPhysicalKeyToPhysicalKeyMapper domainMapper, IConfig config, PrefManager prefManager, LocalizationStorage localization, Analytics analytics) {
        super(new KeysViewState(null, null, null, null, null, null, null, 127, null), "javaClass");
        Intrinsics.checkNotNullParameter(getPhysicalKeysUseCase, "getPhysicalKeysUseCase");
        Intrinsics.checkNotNullParameter(createPhysicalKeyUseCase, "createPhysicalKeyUseCase");
        Intrinsics.checkNotNullParameter(blockPhysicalKeyUseCase, "blockPhysicalKeyUseCase");
        Intrinsics.checkNotNullParameter(unblockPhysicalKeyUseCase, "unblockPhysicalKeyUseCase");
        Intrinsics.checkNotNullParameter(deletePhysicalKeyUseCase, "deletePhysicalKeyUseCase");
        Intrinsics.checkNotNullParameter(updatePhysicalKeyCommentUseCase, "updatePhysicalKeyCommentUseCase");
        Intrinsics.checkNotNullParameter(domainMapper, "domainMapper");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.getPhysicalKeysUseCase = getPhysicalKeysUseCase;
        this.createPhysicalKeyUseCase = createPhysicalKeyUseCase;
        this.blockPhysicalKeyUseCase = blockPhysicalKeyUseCase;
        this.unblockPhysicalKeyUseCase = unblockPhysicalKeyUseCase;
        this.deletePhysicalKeyUseCase = deletePhysicalKeyUseCase;
        this.updatePhysicalKeyCommentUseCase = updatePhysicalKeyCommentUseCase;
        this.domainMapper = domainMapper;
        this.config = config;
        this.prefManager = prefManager;
        this.localization = localization;
        this.analytics = analytics;
        if (getCurrentState().getServerState() == Resource.Status.NONE) {
            getKeys();
        }
    }

    private final LiveData<Resource<List<DomainPhysicalKey>>> getKeysFromServer() {
        Integer id;
        GetPhysicalKeysUseCase getPhysicalKeysUseCase = this.getPhysicalKeysUseCase;
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(getPhysicalKeysUseCase.invoke((currentAddress == null || (id = currentAddress.getId()) == null) ? -1 : id.intValue()), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainPhysicalKey>> createKeyOnServer(String hex, String comment) {
        Integer id;
        CreatePhysicalKeyUseCase createPhysicalKeyUseCase = this.createPhysicalKeyUseCase;
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(createPhysicalKeyUseCase.invoke((currentAddress == null || (id = currentAddress.getId()) == null) ? -1 : id.intValue(), hex, comment), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainPhysicalKey>> blockKeyOnServer(String uuid) {
        return FlowLiveDataConversions.asLiveData$default(this.blockPhysicalKeyUseCase.invoke(uuid), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainPhysicalKey>> unblockKeyOnServer(String uuid) {
        return FlowLiveDataConversions.asLiveData$default(this.unblockPhysicalKeyUseCase.invoke(uuid), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainPhysicalKey>> deleteKeyOnServer(String uuid) {
        return FlowLiveDataConversions.asLiveData$default(this.deletePhysicalKeyUseCase.invoke(uuid), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainPhysicalKey>> updateKeyCommentOnServer(String uuid, String comment) {
        return FlowLiveDataConversions.asLiveData$default(this.updatePhysicalKeyCommentUseCase.invoke(uuid, comment), null, 0L, 3, null);
    }

    public final void getKeysIfNeeded() {
        if (getCurrentState().getServerState() == Resource.Status.NONE) {
            getKeys();
        }
    }

    public final void clearKeyManageState() {
        KeysViewState currentState = getCurrentState();
        Resource.Status status = Resource.Status.NONE;
        KeysViewState keysViewStateCopy$default = KeysViewState.copy$default(currentState, null, status, status, status, status, null, null, 97, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(keysViewStateCopy$default, this, null), 3, null);
        getState().setValue(keysViewStateCopy$default);
    }

    public void getKeys() {
        KeysViewState keysViewStateCopy$default = KeysViewState.copy$default(getCurrentState(), Resource.Status.LOADING, null, null, null, null, null, null, 126, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(keysViewStateCopy$default, this, null), 3, null);
        getState().setValue(keysViewStateCopy$default);
        subscribeOnDataSource(getKeysFromServer(), new Function2<Resource<? extends List<? extends DomainPhysicalKey>>, KeysViewState, KeysViewState>() { // from class: com.sputnik.common.viewmodels.KeysViewModel.getKeys.2

            /* compiled from: KeysViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.KeysViewModel$getKeys$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ KeysViewState invoke(Resource<? extends List<? extends DomainPhysicalKey>> resource, KeysViewState keysViewState) {
                return invoke2((Resource<? extends List<DomainPhysicalKey>>) resource, keysViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final KeysViewState invoke2(Resource<? extends List<DomainPhysicalKey>> data, KeysViewState state) {
                Unit unit;
                String message;
                Collection collectionEmptyList;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return KeysViewState.copy$default(state, state.getServerState(), null, null, null, null, null, null, 126, null);
                }
                if (i == 3) {
                    DomainEmpty errorMsg = data.getErrorMsg();
                    if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                        unit = null;
                    } else {
                        KeysViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        KeysViewModel keysViewModel = KeysViewModel.this;
                        Exception error = data.getError();
                        Intrinsics.checkNotNull(error);
                        keysViewModel.notifySimpleError(error);
                    }
                    return KeysViewState.copy$default(state, Resource.Status.ERROR, null, null, null, null, null, null, 126, null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                Resource.Status status = Resource.Status.SUCCESS;
                List<DomainPhysicalKey> data2 = data.getData();
                if (data2 == null) {
                    collectionEmptyList = CollectionsKt.emptyList();
                } else {
                    List<DomainPhysicalKey> list = data2;
                    KeysViewModel keysViewModel2 = KeysViewModel.this;
                    collectionEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        collectionEmptyList.add(keysViewModel2.domainMapper.map((DomainPhysicalKey) it.next()));
                    }
                }
                return KeysViewState.copy$default(state, status, null, null, null, null, null, new Event(collectionEmptyList), 62, null);
            }
        });
    }

    public void lockOrUnlockKey(final PhysicalKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        KeysViewState keysViewStateCopy$default = KeysViewState.copy$default(getCurrentState(), null, null, Resource.Status.LOADING, null, null, null, null, 123, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(keysViewStateCopy$default, this, null), 3, null);
        getState().setValue(keysViewStateCopy$default);
        subscribeOnDataSource(Intrinsics.areEqual(key.getBlocked(), Boolean.TRUE) ? unblockKeyOnServer(StringUtilsKt.orEmpty(key.getUuid())) : blockKeyOnServer(StringUtilsKt.orEmpty(key.getUuid())), new Function2<Resource<? extends DomainPhysicalKey>, KeysViewState, KeysViewState>() { // from class: com.sputnik.common.viewmodels.KeysViewModel.lockOrUnlockKey.2

            /* compiled from: KeysViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.KeysViewModel$lockOrUnlockKey$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ KeysViewState invoke(Resource<? extends DomainPhysicalKey> resource, KeysViewState keysViewState) {
                return invoke2((Resource<DomainPhysicalKey>) resource, keysViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final KeysViewState invoke2(Resource<DomainPhysicalKey> data, KeysViewState state) {
                String message;
                PhysicalKeysLocale physicalKeys;
                PhysicalKeysLocale.Notifications notifications;
                Object next;
                PhysicalKeysLocale physicalKeys2;
                PhysicalKeysLocale.Notifications notifications2;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return KeysViewState.copy$default(state, null, null, state.getServerState(), null, null, null, null, 123, null);
                }
                Unit unit = null;
                unit = null;
                if (i == 3) {
                    DomainEmpty errorMsg = data.getErrorMsg();
                    if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                        KeysViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        KeysViewModel keysViewModel = KeysViewModel.this;
                        Exception error = data.getError();
                        Intrinsics.checkNotNull(error);
                        keysViewModel.notifySimpleError(error);
                    }
                    return KeysViewState.copy$default(state, null, null, Resource.Status.ERROR, null, null, null, null, 123, null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                DomainPhysicalKey data2 = data.getData();
                if (data2 != null ? Intrinsics.areEqual(data2.getBlocked(), Boolean.TRUE) : false) {
                    KeysViewModel.this.analytics.trackLogEvent(new KeysEvents.StateBlockKeySuccessfull());
                    KeysViewModel keysViewModel2 = KeysViewModel.this;
                    LocalizationLocalModel data3 = keysViewModel2.localization.getData();
                    keysViewModel2.notifySuccessMessage(StringUtilsKt.orEmpty((data3 == null || (physicalKeys2 = data3.getPhysicalKeys()) == null || (notifications2 = physicalKeys2.getNotifications()) == null) ? null : notifications2.getKeyBlockedSuccess()));
                } else {
                    KeysViewModel.this.analytics.trackLogEvent(new KeysEvents.StateUnlockKeySuccessfull());
                    KeysViewModel keysViewModel3 = KeysViewModel.this;
                    LocalizationLocalModel data4 = keysViewModel3.localization.getData();
                    keysViewModel3.notifySuccessMessage(StringUtilsKt.orEmpty((data4 == null || (physicalKeys = data4.getPhysicalKeys()) == null || (notifications = physicalKeys.getNotifications()) == null) ? null : notifications.getKeyUnblockedSuccess()));
                }
                Resource.Status status = Resource.Status.SUCCESS;
                List mutableList = CollectionsKt.toMutableList((Collection) state.getKeys().peekContent());
                PhysicalKey physicalKey = key;
                Iterator it = mutableList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(((PhysicalKey) next).getUuid(), physicalKey.getUuid())) {
                        break;
                    }
                }
                PhysicalKey physicalKey2 = (PhysicalKey) next;
                if (physicalKey2 != null) {
                    DomainPhysicalKey data5 = data.getData();
                    physicalKey2.setBlocked(data5 != null ? data5.getBlocked() : null);
                }
                Unit unit2 = Unit.INSTANCE;
                return KeysViewState.copy$default(state, null, null, status, null, null, null, new Event(mutableList), 59, null);
            }
        });
    }

    public final void logout() {
        KeysViewState currentState = getCurrentState();
        Resource.Status status = Resource.Status.NONE;
        KeysViewState keysViewStateCopy = currentState.copy(status, status, status, status, status, "", new Event<>(CollectionsKt.emptyList()));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(keysViewStateCopy, this, null), 3, null);
        getState().setValue(keysViewStateCopy);
    }

    public void addKey(PhysicalKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        subscribeOnDataSource(createKeyOnServer(StringUtilsKt.orEmpty(key.getHex()), StringUtilsKt.orEmpty(key.getComment())), new Function2<Resource<? extends DomainPhysicalKey>, KeysViewState, KeysViewState>() { // from class: com.sputnik.common.viewmodels.KeysViewModel.addKey.1

            /* compiled from: KeysViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.KeysViewModel$addKey$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ KeysViewState invoke(Resource<? extends DomainPhysicalKey> resource, KeysViewState keysViewState) {
                return invoke2((Resource<DomainPhysicalKey>) resource, keysViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final KeysViewState invoke2(Resource<DomainPhysicalKey> data, KeysViewState state) {
                String message;
                Integer code;
                String hex;
                LocalizationLocalModel data2;
                PhysicalKeysLocale physicalKeys;
                PhysicalKeysLocale.Notifications notifications;
                String keyAddSuccess;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return KeysViewState.copy$default(state, null, null, null, null, state.getServerState(), null, null, 111, null);
                }
                if (i == 3) {
                    DomainEmpty errorMsg = data.getErrorMsg();
                    if (errorMsg != null && (code = errorMsg.getCode()) != null) {
                        KeysViewModel keysViewModel = KeysViewModel.this;
                        int iIntValue = code.intValue();
                        if (iIntValue == 18001) {
                            keysViewModel.analytics.trackLogEvent(new KeysEvents.StateKeyAlreadyRegistredPopup());
                        } else if (iIntValue != 18002) {
                            keysViewModel.analytics.trackLogEvent(new KeysEvents.StateServerProblemPopup());
                        } else {
                            keysViewModel.analytics.trackLogEvent(new KeysEvents.StateNumberIncorrectPopup());
                        }
                    }
                    Resource.Status status = Resource.Status.ERROR;
                    DomainEmpty errorMsg2 = data.getErrorMsg();
                    if (errorMsg2 == null || (message = errorMsg2.getMessage()) == null) {
                        message = "";
                    }
                    return KeysViewState.copy$default(state, null, null, null, null, status, message, null, 79, null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                LocalizationStorage localizationStorage = KeysViewModel.this.localization;
                if (localizationStorage != null && (data2 = localizationStorage.getData()) != null && (physicalKeys = data2.getPhysicalKeys()) != null && (notifications = physicalKeys.getNotifications()) != null && (keyAddSuccess = notifications.getKeyAddSuccess()) != null) {
                    KeysViewModel.this.notifySuccessMessage(keyAddSuccess);
                }
                Resource.Status status2 = Resource.Status.SUCCESS;
                List mutableList = CollectionsKt.toMutableList((Collection) state.getKeys().peekContent());
                DomainPhysicalKey data3 = data.getData();
                String uuid = data3 != null ? data3.getUuid() : null;
                DomainPhysicalKey data4 = data.getData();
                String createdAt = data4 != null ? data4.getCreatedAt() : null;
                DomainPhysicalKey data5 = data.getData();
                String strRemoveSpaces = (data5 == null || (hex = data5.getHex()) == null) ? null : StringUtilsKt.removeSpaces(hex);
                DomainPhysicalKey data6 = data.getData();
                Boolean blocked = data6 != null ? data6.getBlocked() : null;
                DomainPhysicalKey data7 = data.getData();
                mutableList.add(new PhysicalKey(uuid, createdAt, strRemoveSpaces, blocked, data7 != null ? data7.getComment() : null));
                Unit unit = Unit.INSTANCE;
                return KeysViewState.copy$default(state, null, null, null, null, status2, null, new Event(mutableList), 47, null);
            }
        });
    }

    public void updateKeyComment(final PhysicalKey key, final String comment) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(comment, "comment");
        subscribeOnDataSource(updateKeyCommentOnServer(StringUtilsKt.orEmpty(key.getUuid()), comment), new Function2<Resource<? extends DomainPhysicalKey>, KeysViewState, KeysViewState>() { // from class: com.sputnik.common.viewmodels.KeysViewModel.updateKeyComment.1

            /* compiled from: KeysViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.KeysViewModel$updateKeyComment$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ KeysViewState invoke(Resource<? extends DomainPhysicalKey> resource, KeysViewState keysViewState) {
                return invoke2((Resource<DomainPhysicalKey>) resource, keysViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final KeysViewState invoke2(Resource<DomainPhysicalKey> data, KeysViewState state) {
                String message;
                PhysicalKeysLocale physicalKeys;
                PhysicalKeysLocale.Notifications notifications;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return KeysViewState.copy$default(state, null, state.getServerState(), null, null, null, null, null, 125, null);
                }
                Object obj = null;
                if (i == 3) {
                    DomainEmpty errorMsg = data.getErrorMsg();
                    if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                        KeysViewModel.this.notifyErrorMessage(message.toString());
                        obj = Unit.INSTANCE;
                    }
                    if (obj == null) {
                        KeysViewModel keysViewModel = KeysViewModel.this;
                        Exception error = data.getError();
                        Intrinsics.checkNotNull(error);
                        keysViewModel.notifySimpleError(error);
                    }
                    return KeysViewState.copy$default(state, null, Resource.Status.ERROR, null, null, null, null, null, 125, null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                KeysViewModel.this.analytics.trackLogEvent(new KeysEvents.StateSaveKeyName());
                KeysViewModel keysViewModel2 = KeysViewModel.this;
                LocalizationLocalModel data2 = keysViewModel2.localization.getData();
                keysViewModel2.notifySuccessMessage(StringUtilsKt.orEmpty((data2 == null || (physicalKeys = data2.getPhysicalKeys()) == null || (notifications = physicalKeys.getNotifications()) == null) ? null : notifications.getKeyCommentUpdatesSuccess()));
                Resource.Status status = Resource.Status.SUCCESS;
                List<PhysicalKey> listPeekContent = state.getKeys().peekContent();
                String str = comment;
                PhysicalKey physicalKey = key;
                Iterator<T> it = listPeekContent.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.areEqual(physicalKey, (PhysicalKey) next)) {
                        obj = next;
                        break;
                    }
                }
                PhysicalKey physicalKey2 = (PhysicalKey) obj;
                if (physicalKey2 != null) {
                    physicalKey2.setComment(str);
                }
                Unit unit = Unit.INSTANCE;
                return KeysViewState.copy$default(state, null, status, null, null, null, null, new Event(listPeekContent), 61, null);
            }
        });
    }

    public void deleteKey(final PhysicalKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        subscribeOnDataSource(deleteKeyOnServer(StringUtilsKt.orEmpty(key.getUuid())), new Function2<Resource<? extends DomainPhysicalKey>, KeysViewState, KeysViewState>() { // from class: com.sputnik.common.viewmodels.KeysViewModel.deleteKey.1

            /* compiled from: KeysViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.KeysViewModel$deleteKey$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ KeysViewState invoke(Resource<? extends DomainPhysicalKey> resource, KeysViewState keysViewState) {
                return invoke2((Resource<DomainPhysicalKey>) resource, keysViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final KeysViewState invoke2(Resource<DomainPhysicalKey> data, KeysViewState state) {
                String message;
                PhysicalKeysLocale physicalKeys;
                PhysicalKeysLocale.Notifications notifications;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[data.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return KeysViewState.copy$default(state, null, null, null, state.getServerState(), null, null, null, 119, null);
                }
                Unit unit = null;
                keyDeletedSuccess = null;
                keyDeletedSuccess = null;
                String keyDeletedSuccess = null;
                unit = null;
                if (i == 3) {
                    DomainEmpty errorMsg = data.getErrorMsg();
                    if (errorMsg != null && (message = errorMsg.getMessage()) != null) {
                        KeysViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        KeysViewModel keysViewModel = KeysViewModel.this;
                        Exception error = data.getError();
                        Intrinsics.checkNotNull(error);
                        keysViewModel.notifySimpleError(error);
                    }
                    return KeysViewState.copy$default(state, null, null, null, Resource.Status.ERROR, null, null, null, 119, null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                KeysViewModel.this.analytics.trackLogEvent(new KeysEvents.StateDeleteKey());
                KeysViewModel keysViewModel2 = KeysViewModel.this;
                LocalizationLocalModel data2 = keysViewModel2.localization.getData();
                if (data2 != null && (physicalKeys = data2.getPhysicalKeys()) != null && (notifications = physicalKeys.getNotifications()) != null) {
                    keyDeletedSuccess = notifications.getKeyDeletedSuccess();
                }
                keysViewModel2.notifySuccessMessage(StringUtilsKt.orEmpty(keyDeletedSuccess));
                Resource.Status status = Resource.Status.SUCCESS;
                List<PhysicalKey> listPeekContent = state.getKeys().peekContent();
                PhysicalKey physicalKey = key;
                ArrayList arrayList = new ArrayList();
                for (Object obj : listPeekContent) {
                    if (!Intrinsics.areEqual(((PhysicalKey) obj).getUuid(), physicalKey.getUuid())) {
                        arrayList.add(obj);
                    }
                }
                return KeysViewState.copy$default(state, null, null, null, status, null, null, new Event(arrayList), 55, null);
            }
        });
    }
}
