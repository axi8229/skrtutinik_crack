package com.sputnik.common.viewmodels;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.common.entities.tiles.Tile;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.tiles.DomainTile;
import com.sputnik.domain.usecases.tiles.GetTilesUseCase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: TilesViewModel.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0019\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/sputnik/common/viewmodels/TilesViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/TilesState;", "", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/domain/usecases/tiles/GetTilesUseCase;", "getTilesUseCase", "<init>", "(Lcom/sputnik/data/local/PrefManager;Lcom/sputnik/domain/usecases/tiles/GetTilesUseCase;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/tiles/DomainTile;", "getTilesFromServer", "()Landroidx/lifecycle/LiveData;", "", "loadTiles", "()V", "Lcom/sputnik/data/local/PrefManager;", "Lcom/sputnik/domain/usecases/tiles/GetTilesUseCase;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TilesViewModel extends BaseViewModel<TilesState> {
    private final GetTilesUseCase getTilesUseCase;
    private final PrefManager prefManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TilesViewModel(PrefManager prefManager, GetTilesUseCase getTilesUseCase) {
        super(new TilesState(null, null, 3, null), "javaClass");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        Intrinsics.checkNotNullParameter(getTilesUseCase, "getTilesUseCase");
        this.prefManager = prefManager;
        this.getTilesUseCase = getTilesUseCase;
        loadTiles();
    }

    private final LiveData<Resource<List<DomainTile>>> getTilesFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.getTilesUseCase.invoke(), null, 0L, 3, null);
    }

    public void loadTiles() {
        TilesState tilesStateCopy$default = TilesState.copy$default(getCurrentState(), null, null, 1, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(tilesStateCopy$default, this, null), 3, null);
        getState().setValue(tilesStateCopy$default);
        final boolean zAreEqual = Intrinsics.areEqual(this.prefManager.getAppSettings().getBleSettings().getEnabled(), Boolean.TRUE);
        subscribeOnDataSource(getTilesFromServer(), new Function2<Resource<? extends List<? extends DomainTile>>, TilesState, TilesState>() { // from class: com.sputnik.common.viewmodels.TilesViewModel.loadTiles.2

            /* compiled from: TilesViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.common.viewmodels.TilesViewModel$loadTiles$2$WhenMappings */
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ TilesState invoke(Resource<? extends List<? extends DomainTile>> resource, TilesState tilesState) {
                return invoke2((Resource<? extends List<DomainTile>>) resource, tilesState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final TilesState invoke2(Resource<? extends List<DomainTile>> serverData, TilesState state) {
                Unit unit;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                ArrayList arrayList = null;
                if (i == 1 || i == 2) {
                    return TilesState.copy$default(state, Resource.Status.LOADING, null, 2, null);
                }
                if (i == 3) {
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg != null) {
                        TilesViewModel.this.notifyErrorMessage(errorMsg.getError());
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        TilesViewModel tilesViewModel = TilesViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        tilesViewModel.notifySimpleError(error);
                    }
                    return TilesState.copy$default(state, Resource.Status.ERROR, null, 2, null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                Resource.Status status = Resource.Status.SUCCESS;
                List<DomainTile> data = serverData.getData();
                if (data != null) {
                    List<DomainTile> list = data;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (DomainTile domainTile : list) {
                        arrayList2.add(new Tile(domainTile.getId(), domainTile.getIdentifier(), domainTile.getImgLink(), domainTile.getDeeplink(), domainTile.getPinned()));
                    }
                    boolean z = zAreEqual;
                    arrayList = new ArrayList();
                    for (Object obj : arrayList2) {
                        if (z ? Intrinsics.areEqual(((Tile) obj).getIdentifier(), "ble") : true) {
                            arrayList.add(obj);
                        }
                    }
                }
                return state.copy(status, arrayList);
            }
        });
    }
}
