package sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.viewmodel;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.ViewModelKt;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.entities.archive.Flussonic;
import com.sputnik.common.entities.localization.ArchiveMainLocale;
import com.sputnik.common.entities.localization.ArchiveMainView;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.archive.DomainArchiveUrls;
import com.sputnik.domain.entities.archive.DomainFlussonic;
import com.sputnik.domain.usecases.archive.GetArchiveSdkUrlUseCase;
import com.sputnik.domain.usecases.archive.GetArchiveUrlsUseCase;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: ArchiveViewModel.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B=\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001dR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001e¨\u0006\u001f"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/viewmodel/ArchiveViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lsputnik/axmor/com/sputnik/ui/main/market/services/archive_service/viewmodel/ArchiveViewState;", "", "Lcom/sputnik/domain/usecases/archive/GetArchiveSdkUrlUseCase;", "getArchiveSdkUrlUseCase", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/domain/entities/archive/DomainFlussonic;", "Lcom/sputnik/common/entities/archive/Flussonic;", "mapper", "Lcom/sputnik/common/localization/LocalizationStorage;", "localization", "Lcom/sputnik/domain/usecases/archive/GetArchiveUrlsUseCase;", "getArchiveUrlsUseCase", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "<init>", "(Lcom/sputnik/domain/usecases/archive/GetArchiveSdkUrlUseCase;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/common/localization/LocalizationStorage;Lcom/sputnik/domain/usecases/archive/GetArchiveUrlsUseCase;Lcom/sputnik/data/local/PrefManager;)V", "", "loadArchiveLinks", "()V", "loadArchiveLinksIfNeeded", "Lcom/sputnik/domain/common/Resource$Status;", UpdateKey.STATUS, "handleStatus", "(Lcom/sputnik/domain/common/Resource$Status;)V", "Lcom/sputnik/domain/usecases/archive/GetArchiveSdkUrlUseCase;", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/common/localization/LocalizationStorage;", "Lcom/sputnik/domain/usecases/archive/GetArchiveUrlsUseCase;", "Lcom/sputnik/data/local/PrefManager;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ArchiveViewModel extends BaseViewModel<ArchiveViewState> {
    private final GetArchiveSdkUrlUseCase getArchiveSdkUrlUseCase;
    private GetArchiveUrlsUseCase getArchiveUrlsUseCase;
    private final LocalizationStorage localization;
    private final ListMapper<DomainFlussonic, Flussonic> mapper;
    private final PrefManager prefManager;

    public ArchiveViewModel(GetArchiveSdkUrlUseCase getArchiveSdkUrlUseCase, ListMapper<DomainFlussonic, Flussonic> mapper, LocalizationStorage localization, GetArchiveUrlsUseCase getArchiveUrlsUseCase, PrefManager prefManager) {
        Intrinsics.checkNotNullParameter(getArchiveSdkUrlUseCase, "getArchiveSdkUrlUseCase");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(getArchiveUrlsUseCase, "getArchiveUrlsUseCase");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        ArchiveViewState archiveViewState = new ArchiveViewState(null, null, null, 7, null);
        String name = ArchiveViewModel.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        super(archiveViewState, name);
        this.getArchiveSdkUrlUseCase = getArchiveSdkUrlUseCase;
        this.mapper = mapper;
        this.localization = localization;
        this.getArchiveUrlsUseCase = getArchiveUrlsUseCase;
        this.prefManager = prefManager;
    }

    public final void loadArchiveLinks() {
        subscribeOnDataSource(FlowLiveDataConversions.asLiveData$default(this.getArchiveUrlsUseCase.invoke(), null, 0L, 3, null), new Function2<Resource<? extends DomainArchiveUrls>, ArchiveViewState, ArchiveViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.viewmodel.ArchiveViewModel.loadArchiveLinks.1

            /* compiled from: ArchiveViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.market.services.archive_service.viewmodel.ArchiveViewModel$loadArchiveLinks$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ ArchiveViewState invoke(Resource<? extends DomainArchiveUrls> resource, ArchiveViewState archiveViewState) {
                return invoke2((Resource<DomainArchiveUrls>) resource, archiveViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ArchiveViewState invoke2(Resource<DomainArchiveUrls> result, ArchiveViewState state) {
                ArchiveMainLocale archiveMain;
                ArchiveMainView body;
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[result.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return ArchiveViewState.copy$default(state, Resource.Status.LOADING, null, null, 6, null);
                }
                if (i != 3) {
                    if (i == 4) {
                        return ArchiveViewState.copy$default(state, Resource.Status.SUCCESS, null, result.getData(), 2, null);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                ArchiveViewModel archiveViewModel = ArchiveViewModel.this;
                LocalizationLocalModel data = archiveViewModel.localization.getData();
                archiveViewModel.notifyErrorMessage((data == null || (archiveMain = data.getArchiveMain()) == null || (body = archiveMain.getBody()) == null) ? null : body.getError());
                return ArchiveViewState.copy$default(state, Resource.Status.ERROR, null, null, 6, null);
            }
        });
    }

    public final void loadArchiveLinksIfNeeded() {
        if (getCurrentState().getServerState() == Resource.Status.NONE) {
            loadArchiveLinks();
        }
    }

    public void handleStatus(Resource.Status status) {
        Intrinsics.checkNotNullParameter(status, "status");
        ArchiveViewState archiveViewStateCopy$default = ArchiveViewState.copy$default(getCurrentState(), status, null, null, 6, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ArchiveViewModel$handleStatus$$inlined$updateState$1(archiveViewStateCopy$default, this, null), 3, null);
        getState().setValue(archiveViewStateCopy$default);
    }
}
