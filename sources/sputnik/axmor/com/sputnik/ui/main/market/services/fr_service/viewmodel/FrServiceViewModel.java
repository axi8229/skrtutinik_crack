package sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.viewmodel;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.usecases.fr_service.UpdateFrUseCase;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import ru.roadar.facerecog.ByteUtils;
import ru.roadar.facerecog.FaceData;
import sputnik.axmor.com.sputnik.widgets.BaseOpenDoorWidget;

/* compiled from: FrServiceViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\b\u0007\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018¨\u0006\u0019"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/viewmodel/FrServiceViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lsputnik/axmor/com/sputnik/ui/main/market/services/fr_service/viewmodel/FrServiceViewState;", "", "Lcom/sputnik/domain/usecases/fr_service/UpdateFrUseCase;", "Lokhttp3/MultipartBody$Part;", "updateFrUseCase", "<init>", "(Lcom/sputnik/domain/usecases/fr_service/UpdateFrUseCase;)V", RemoteMessageConst.DATA, "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "updateFrToServer", "(Lokhttp3/MultipartBody$Part;)Landroidx/lifecycle/LiveData;", "Lru/roadar/facerecog/FaceData;", "Ljava/io/File;", "convertFaceDataToPart", "(Lru/roadar/facerecog/FaceData;)Ljava/io/File;", "file", "createFilePart", "(Ljava/io/File;)Lokhttp3/MultipartBody$Part;", "loadFrData", "(Lru/roadar/facerecog/FaceData;)V", "Lcom/sputnik/domain/usecases/fr_service/UpdateFrUseCase;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FrServiceViewModel extends BaseViewModel<FrServiceViewState> {
    private final UpdateFrUseCase<MultipartBody.Part> updateFrUseCase;

    public FrServiceViewModel(UpdateFrUseCase<MultipartBody.Part> updateFrUseCase) {
        Intrinsics.checkNotNullParameter(updateFrUseCase, "updateFrUseCase");
        FrServiceViewState frServiceViewState = new FrServiceViewState(null, null, null, null, 15, null);
        String name = FrServiceViewModel.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        super(frServiceViewState, name);
        this.updateFrUseCase = updateFrUseCase;
    }

    private final LiveData<Resource<Unit>> updateFrToServer(MultipartBody.Part data) {
        return FlowLiveDataConversions.asLiveData$default(this.updateFrUseCase.invoke(data), null, 0L, 3, null);
    }

    public void loadFrData(FaceData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Boolean contentIfNotHandled = getCurrentState().getHandleData().getContentIfNotHandled();
        if (contentIfNotHandled == null || contentIfNotHandled.booleanValue()) {
            return;
        }
        FrServiceViewState frServiceViewStateCopy$default = FrServiceViewState.copy$default(getCurrentState(), Resource.Status.LOADING, null, null, new Event(Boolean.TRUE), 6, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FrServiceViewModel$loadFrData$lambda$1$$inlined$updateState$1(frServiceViewStateCopy$default, this, null), 3, null);
        getState().setValue(frServiceViewStateCopy$default);
        subscribeOnDataSource(updateFrToServer(createFilePart(convertFaceDataToPart(data))), new Function2<Resource<? extends Unit>, FrServiceViewState, FrServiceViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.viewmodel.FrServiceViewModel$loadFrData$1$2

            /* compiled from: FrServiceViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
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

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ FrServiceViewState invoke(Resource<? extends Unit> resource, FrServiceViewState frServiceViewState) {
                return invoke2((Resource<Unit>) resource, frServiceViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final FrServiceViewState invoke2(Resource<Unit> serverData, FrServiceViewState state) {
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return FrServiceViewState.copy$default(state, Resource.Status.LOADING, null, null, null, 14, null);
                }
                if (i == 3) {
                    return FrServiceViewState.copy$default(state, Resource.Status.ERROR, null, new Event(Boolean.TRUE), null, 10, null);
                }
                if (i == 4) {
                    return FrServiceViewState.copy$default(state, Resource.Status.SUCCESS, new Event(Boolean.TRUE), null, null, 12, null);
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    private final File convertFaceDataToPart(FaceData data) throws IOException {
        File file = new File(BaseOpenDoorWidget.INSTANCE.getContext().getFilesDir(), "fr");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, "some_important_data.bin");
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            try {
                new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file2), 8192));
                ByteUtils.Companion companion = ByteUtils.INSTANCE;
                throw null;
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return file2;
        }
    }

    private final MultipartBody.Part createFilePart(File file) {
        return MultipartBody.Part.INSTANCE.createFormData("face_features_file", file.getName(), RequestBody.INSTANCE.create(file, MediaType.INSTANCE.get("octet/stream")));
    }
}
