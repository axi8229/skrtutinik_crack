package sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.entities.addresses.UserAddress;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.entities.camera.CameraObject;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.ProfileSettingsLocale;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.cameras.DomainCameraObject;
import com.sputnik.domain.entities.cameras.DomainCamerasOrder;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.usecases.manage_cameras.ClearCamerasPreferencesUseCase;
import com.sputnik.domain.usecases.manage_cameras.GetCamerasOrderUseCase;
import com.sputnik.domain.usecases.manage_cameras.GetCamerasPreferencesUseCase;
import com.sputnik.domain.usecases.manage_cameras.SetCameraParamsUseCase;
import com.sputnik.domain.usecases.manage_cameras.SetCamerasOrderUseCase;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import org.pjsip.pjsua2.pjmedia_tp_proto;
import sputnik.axmor.com.sputnik.entities.cameras.CamerasOrder;
import sputnik.axmor.com.sputnik.mappers.cameras.CameraObjectToDomainCameraObjectMapper;
import sputnik.axmor.com.sputnik.mappers.cameras.CamerasOrderToDomainCamerasOrderMapper;
import sputnik.axmor.com.sputnik.mappers.cameras.DomainCameraObjectToCameraObjectMapper;
import sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.ManageCamerasItem;

/* compiled from: ManageCamerasViewModel.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001XBc\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d0\u001cH\u0002¢\u0006\u0004\b \u0010!J+\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001d0\u001c2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J#\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001d0\u001c2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J+\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u001d0\u001c2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b0\u00101J\u001b\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020\u001d0\u001cH\u0002¢\u0006\u0004\b3\u0010!J\r\u00104\u001a\u000202¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u000202¢\u0006\u0004\b6\u00105J\r\u00107\u001a\u000202¢\u0006\u0004\b7\u00105J\r\u00108\u001a\u000202¢\u0006\u0004\b8\u00105J\u001d\u0010;\u001a\u0002022\f\u0010:\u001a\b\u0012\u0004\u0012\u0002090\u001eH\u0016¢\u0006\u0004\b;\u0010<J\u001d\u0010=\u001a\u0002022\f\u0010:\u001a\b\u0012\u0004\u0012\u0002090\u001eH\u0016¢\u0006\u0004\b=\u0010<J\u0017\u0010?\u001a\u0002022\u0006\u0010.\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u0002022\u0006\u0010A\u001a\u00020\u0004H\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u000202H\u0016¢\u0006\u0004\bD\u00105J\u001d\u0010G\u001a\u0002022\f\u0010F\u001a\b\u0012\u0004\u0012\u00020E0\u001eH\u0016¢\u0006\u0004\bG\u0010<J\u001d\u0010H\u001a\u0002022\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\bH\u0010IJ\u0015\u0010K\u001a\u0002022\u0006\u0010J\u001a\u00020$¢\u0006\u0004\bK\u0010LR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010MR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010NR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010OR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010PR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010QR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010RR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010SR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010TR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010UR\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010VR\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010W¨\u0006Y"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewState;", "", "", "errorInWidget", "Lcom/sputnik/domain/usecases/manage_cameras/SetCamerasOrderUseCase;", "setCamerasOrderUseCase", "Lcom/sputnik/domain/usecases/manage_cameras/GetCamerasOrderUseCase;", "getCamerasOrderUseCase", "Lcom/sputnik/domain/usecases/manage_cameras/SetCameraParamsUseCase;", "setCameraParamsUseCase", "Lcom/sputnik/domain/usecases/manage_cameras/GetCamerasPreferencesUseCase;", "getCameraPreferencesUseCase", "Lcom/sputnik/domain/usecases/manage_cameras/ClearCamerasPreferencesUseCase;", "clearCamerasPreferencesUseCase", "Lsputnik/axmor/com/sputnik/mappers/cameras/CamerasOrderToDomainCamerasOrderMapper;", "camerasOrderToDomainCamerasOrderMapper", "Lsputnik/axmor/com/sputnik/mappers/cameras/CameraObjectToDomainCameraObjectMapper;", "cameraObjectToDomainCameraObjectMapper", "Lsputnik/axmor/com/sputnik/mappers/cameras/DomainCameraObjectToCameraObjectMapper;", "domainCameraObjectToCameraObjectMapper", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/usecases/manage_cameras/SetCamerasOrderUseCase;Lcom/sputnik/domain/usecases/manage_cameras/GetCamerasOrderUseCase;Lcom/sputnik/domain/usecases/manage_cameras/SetCameraParamsUseCase;Lcom/sputnik/domain/usecases/manage_cameras/GetCamerasPreferencesUseCase;Lcom/sputnik/domain/usecases/manage_cameras/ClearCamerasPreferencesUseCase;Lsputnik/axmor/com/sputnik/mappers/cameras/CamerasOrderToDomainCamerasOrderMapper;Lsputnik/axmor/com/sputnik/mappers/cameras/CameraObjectToDomainCameraObjectMapper;Lsputnik/axmor/com/sputnik/mappers/cameras/DomainCameraObjectToCameraObjectMapper;Lcom/sputnik/common/localization/LocalizationStorage;Lcom/sputnik/data/local/PrefManager;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/cameras/DomainCamerasOrder;", "getCamerasPreferencesFromServer", "()Landroidx/lifecycle/LiveData;", "", "addressId", "", "callsEnabled", "setCallsEnabledOnServer", "(IZ)Landroidx/lifecycle/LiveData;", "Lsputnik/axmor/com/sputnik/entities/cameras/CamerasOrder;", "orderCameras", "setCamerasOrderToServer", "(Lsputnik/axmor/com/sputnik/entities/cameras/CamerasOrder;)Landroidx/lifecycle/LiveData;", "cameraUuid", "Lcom/sputnik/common/entities/camera/CameraObject;", "camera", "Lcom/sputnik/domain/entities/cameras/DomainCameraObject;", "setCameraParamsToServer", "(Ljava/lang/String;Lcom/sputnik/common/entities/camera/CameraObject;)Landroidx/lifecycle/LiveData;", "", "clearCamerasPreferencesOnServer", "resetOrder", "()V", "clearResetState", "clearSavedTitle", "clearSelectedTab", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/adapter/ManageCamerasItem;", "cameras", "handleSaveNewOrder", "(Ljava/util/List;)V", "handleSaveNewOrderForWidgets", "Lcom/sputnik/common/entities/camera/Camera;", "handleCurrentCamera", "(Lcom/sputnik/common/entities/camera/Camera;)V", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "handleTitle", "(Ljava/lang/String;)V", "handleSaveTitle", "Lcom/sputnik/common/entities/addresses/UserAddress;", "addresses", "getCamerasPreferences", "setCallsEnabledForAddress", "(IZ)V", "isSelected", "setWidgetTabSelected", "(Z)V", "Ljava/lang/String;", "Lcom/sputnik/domain/usecases/manage_cameras/SetCamerasOrderUseCase;", "Lcom/sputnik/domain/usecases/manage_cameras/GetCamerasOrderUseCase;", "Lcom/sputnik/domain/usecases/manage_cameras/SetCameraParamsUseCase;", "Lcom/sputnik/domain/usecases/manage_cameras/GetCamerasPreferencesUseCase;", "Lcom/sputnik/domain/usecases/manage_cameras/ClearCamerasPreferencesUseCase;", "Lsputnik/axmor/com/sputnik/mappers/cameras/CamerasOrderToDomainCamerasOrderMapper;", "Lsputnik/axmor/com/sputnik/mappers/cameras/CameraObjectToDomainCameraObjectMapper;", "Lsputnik/axmor/com/sputnik/mappers/cameras/DomainCameraObjectToCameraObjectMapper;", "Lcom/sputnik/common/localization/LocalizationStorage;", "Lcom/sputnik/data/local/PrefManager;", "Factory", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManageCamerasViewModel extends BaseViewModel<ManageCamerasViewState> {
    private final CameraObjectToDomainCameraObjectMapper cameraObjectToDomainCameraObjectMapper;
    private final CamerasOrderToDomainCamerasOrderMapper camerasOrderToDomainCamerasOrderMapper;
    private final ClearCamerasPreferencesUseCase clearCamerasPreferencesUseCase;
    private final DomainCameraObjectToCameraObjectMapper domainCameraObjectToCameraObjectMapper;
    private final String errorInWidget;
    private final GetCamerasPreferencesUseCase getCameraPreferencesUseCase;
    private final GetCamerasOrderUseCase getCamerasOrderUseCase;
    private final LocalizationStorage localizationStorage;
    private final PrefManager prefManager;
    private final SetCameraParamsUseCase setCameraParamsUseCase;
    private final SetCamerasOrderUseCase setCamerasOrderUseCase;

    public /* synthetic */ ManageCamerasViewModel(String str, SetCamerasOrderUseCase setCamerasOrderUseCase, GetCamerasOrderUseCase getCamerasOrderUseCase, SetCameraParamsUseCase setCameraParamsUseCase, GetCamerasPreferencesUseCase getCamerasPreferencesUseCase, ClearCamerasPreferencesUseCase clearCamerasPreferencesUseCase, CamerasOrderToDomainCamerasOrderMapper camerasOrderToDomainCamerasOrderMapper, CameraObjectToDomainCameraObjectMapper cameraObjectToDomainCameraObjectMapper, DomainCameraObjectToCameraObjectMapper domainCameraObjectToCameraObjectMapper, LocalizationStorage localizationStorage, PrefManager prefManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, setCamerasOrderUseCase, getCamerasOrderUseCase, setCameraParamsUseCase, getCamerasPreferencesUseCase, clearCamerasPreferencesUseCase, camerasOrderToDomainCamerasOrderMapper, cameraObjectToDomainCameraObjectMapper, domainCameraObjectToCameraObjectMapper, localizationStorage, prefManager);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageCamerasViewModel(String str, SetCamerasOrderUseCase setCamerasOrderUseCase, GetCamerasOrderUseCase getCamerasOrderUseCase, SetCameraParamsUseCase setCameraParamsUseCase, GetCamerasPreferencesUseCase getCameraPreferencesUseCase, ClearCamerasPreferencesUseCase clearCamerasPreferencesUseCase, CamerasOrderToDomainCamerasOrderMapper camerasOrderToDomainCamerasOrderMapper, CameraObjectToDomainCameraObjectMapper cameraObjectToDomainCameraObjectMapper, DomainCameraObjectToCameraObjectMapper domainCameraObjectToCameraObjectMapper, LocalizationStorage localizationStorage, PrefManager prefManager) {
        super(new ManageCamerasViewState(null, null, null, null, null, null, false, null, null, 511, null), "javaClass");
        Intrinsics.checkNotNullParameter(setCamerasOrderUseCase, "setCamerasOrderUseCase");
        Intrinsics.checkNotNullParameter(getCamerasOrderUseCase, "getCamerasOrderUseCase");
        Intrinsics.checkNotNullParameter(setCameraParamsUseCase, "setCameraParamsUseCase");
        Intrinsics.checkNotNullParameter(getCameraPreferencesUseCase, "getCameraPreferencesUseCase");
        Intrinsics.checkNotNullParameter(clearCamerasPreferencesUseCase, "clearCamerasPreferencesUseCase");
        Intrinsics.checkNotNullParameter(camerasOrderToDomainCamerasOrderMapper, "camerasOrderToDomainCamerasOrderMapper");
        Intrinsics.checkNotNullParameter(cameraObjectToDomainCameraObjectMapper, "cameraObjectToDomainCameraObjectMapper");
        Intrinsics.checkNotNullParameter(domainCameraObjectToCameraObjectMapper, "domainCameraObjectToCameraObjectMapper");
        Intrinsics.checkNotNullParameter(localizationStorage, "localizationStorage");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        this.errorInWidget = str;
        this.setCamerasOrderUseCase = setCamerasOrderUseCase;
        this.getCamerasOrderUseCase = getCamerasOrderUseCase;
        this.setCameraParamsUseCase = setCameraParamsUseCase;
        this.getCameraPreferencesUseCase = getCameraPreferencesUseCase;
        this.clearCamerasPreferencesUseCase = clearCamerasPreferencesUseCase;
        this.camerasOrderToDomainCamerasOrderMapper = camerasOrderToDomainCamerasOrderMapper;
        this.cameraObjectToDomainCameraObjectMapper = cameraObjectToDomainCameraObjectMapper;
        this.domainCameraObjectToCameraObjectMapper = domainCameraObjectToCameraObjectMapper;
        this.localizationStorage = localizationStorage;
        this.prefManager = prefManager;
    }

    /* compiled from: ManageCamerasViewModel.kt */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001fBc\b\u0007\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J%\u0010\u0019\u001a\u0002H\u001a\"\b\b\u0000\u0010\u001a*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0016¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "errorInWidget", "", "setCamerasOrderUseCase", "Lcom/sputnik/domain/usecases/manage_cameras/SetCamerasOrderUseCase;", "getCamerasOrderUseCase", "Lcom/sputnik/domain/usecases/manage_cameras/GetCamerasOrderUseCase;", "setCameraParamsUseCase", "Lcom/sputnik/domain/usecases/manage_cameras/SetCameraParamsUseCase;", "getCameraPreferencesUseCase", "Lcom/sputnik/domain/usecases/manage_cameras/GetCamerasPreferencesUseCase;", "clearCamerasPreferencesUseCase", "Lcom/sputnik/domain/usecases/manage_cameras/ClearCamerasPreferencesUseCase;", "camerasOrderToDomainCamerasOrderMapper", "Lsputnik/axmor/com/sputnik/mappers/cameras/CamerasOrderToDomainCamerasOrderMapper;", "cameraObjectToDomainCameraObjectMapper", "Lsputnik/axmor/com/sputnik/mappers/cameras/CameraObjectToDomainCameraObjectMapper;", "domainCameraObjectToCameraObjectMapper", "Lsputnik/axmor/com/sputnik/mappers/cameras/DomainCameraObjectToCameraObjectMapper;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "(Ljava/lang/String;Lcom/sputnik/domain/usecases/manage_cameras/SetCamerasOrderUseCase;Lcom/sputnik/domain/usecases/manage_cameras/GetCamerasOrderUseCase;Lcom/sputnik/domain/usecases/manage_cameras/SetCameraParamsUseCase;Lcom/sputnik/domain/usecases/manage_cameras/GetCamerasPreferencesUseCase;Lcom/sputnik/domain/usecases/manage_cameras/ClearCamerasPreferencesUseCase;Lsputnik/axmor/com/sputnik/mappers/cameras/CamerasOrderToDomainCamerasOrderMapper;Lsputnik/axmor/com/sputnik/mappers/cameras/CameraObjectToDomainCameraObjectMapper;Lsputnik/axmor/com/sputnik/mappers/cameras/DomainCameraObjectToCameraObjectMapper;Lcom/sputnik/common/localization/LocalizationStorage;Lcom/sputnik/data/local/PrefManager;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "AssistFactory", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Factory extends ViewModelProvider.NewInstanceFactory {
        private final CameraObjectToDomainCameraObjectMapper cameraObjectToDomainCameraObjectMapper;
        private final CamerasOrderToDomainCamerasOrderMapper camerasOrderToDomainCamerasOrderMapper;
        private final ClearCamerasPreferencesUseCase clearCamerasPreferencesUseCase;
        private final DomainCameraObjectToCameraObjectMapper domainCameraObjectToCameraObjectMapper;
        private final String errorInWidget;
        private final GetCamerasPreferencesUseCase getCameraPreferencesUseCase;
        private final GetCamerasOrderUseCase getCamerasOrderUseCase;
        private final LocalizationStorage localizationStorage;
        private final PrefManager prefManager;
        private final SetCameraParamsUseCase setCameraParamsUseCase;
        private final SetCamerasOrderUseCase setCamerasOrderUseCase;

        /* compiled from: ManageCamerasViewModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory$AssistFactory;", "", "create", "Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewModel$Factory;", "failureTitle", "", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public interface AssistFactory {
            Factory create(String failureTitle);
        }

        public Factory(String str, SetCamerasOrderUseCase setCamerasOrderUseCase, GetCamerasOrderUseCase getCamerasOrderUseCase, SetCameraParamsUseCase setCameraParamsUseCase, GetCamerasPreferencesUseCase getCameraPreferencesUseCase, ClearCamerasPreferencesUseCase clearCamerasPreferencesUseCase, CamerasOrderToDomainCamerasOrderMapper camerasOrderToDomainCamerasOrderMapper, CameraObjectToDomainCameraObjectMapper cameraObjectToDomainCameraObjectMapper, DomainCameraObjectToCameraObjectMapper domainCameraObjectToCameraObjectMapper, LocalizationStorage localizationStorage, PrefManager prefManager) {
            Intrinsics.checkNotNullParameter(setCamerasOrderUseCase, "setCamerasOrderUseCase");
            Intrinsics.checkNotNullParameter(getCamerasOrderUseCase, "getCamerasOrderUseCase");
            Intrinsics.checkNotNullParameter(setCameraParamsUseCase, "setCameraParamsUseCase");
            Intrinsics.checkNotNullParameter(getCameraPreferencesUseCase, "getCameraPreferencesUseCase");
            Intrinsics.checkNotNullParameter(clearCamerasPreferencesUseCase, "clearCamerasPreferencesUseCase");
            Intrinsics.checkNotNullParameter(camerasOrderToDomainCamerasOrderMapper, "camerasOrderToDomainCamerasOrderMapper");
            Intrinsics.checkNotNullParameter(cameraObjectToDomainCameraObjectMapper, "cameraObjectToDomainCameraObjectMapper");
            Intrinsics.checkNotNullParameter(domainCameraObjectToCameraObjectMapper, "domainCameraObjectToCameraObjectMapper");
            Intrinsics.checkNotNullParameter(localizationStorage, "localizationStorage");
            Intrinsics.checkNotNullParameter(prefManager, "prefManager");
            this.errorInWidget = str;
            this.setCamerasOrderUseCase = setCamerasOrderUseCase;
            this.getCamerasOrderUseCase = getCamerasOrderUseCase;
            this.setCameraParamsUseCase = setCameraParamsUseCase;
            this.getCameraPreferencesUseCase = getCameraPreferencesUseCase;
            this.clearCamerasPreferencesUseCase = clearCamerasPreferencesUseCase;
            this.camerasOrderToDomainCamerasOrderMapper = camerasOrderToDomainCamerasOrderMapper;
            this.cameraObjectToDomainCameraObjectMapper = cameraObjectToDomainCameraObjectMapper;
            this.domainCameraObjectToCameraObjectMapper = domainCameraObjectToCameraObjectMapper;
            this.localizationStorage = localizationStorage;
            this.prefManager = prefManager;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            if (!Intrinsics.areEqual(modelClass, ManageCamerasViewModel.class)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            return new ManageCamerasViewModel(this.errorInWidget, this.setCamerasOrderUseCase, this.getCamerasOrderUseCase, this.setCameraParamsUseCase, this.getCameraPreferencesUseCase, this.clearCamerasPreferencesUseCase, this.camerasOrderToDomainCamerasOrderMapper, this.cameraObjectToDomainCameraObjectMapper, this.domainCameraObjectToCameraObjectMapper, this.localizationStorage, this.prefManager);
        }
    }

    private final LiveData<Resource<List<DomainCamerasOrder>>> getCamerasPreferencesFromServer() {
        return FlowLiveDataConversions.asLiveData$default(this.getCameraPreferencesUseCase.invoke(), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainCamerasOrder>> setCallsEnabledOnServer(int addressId, boolean callsEnabled) {
        return FlowLiveDataConversions.asLiveData$default(this.setCamerasOrderUseCase.invoke(addressId, new DomainCamerasOrder(Integer.valueOf(addressId), null, Boolean.valueOf(callsEnabled))), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainCamerasOrder>> setCamerasOrderToServer(CamerasOrder orderCameras) {
        Integer id;
        SetCamerasOrderUseCase setCamerasOrderUseCase = this.setCamerasOrderUseCase;
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(setCamerasOrderUseCase.invoke((currentAddress == null || (id = currentAddress.getId()) == null) ? -1 : id.intValue(), this.camerasOrderToDomainCamerasOrderMapper.map(orderCameras)), null, 0L, 3, null);
    }

    private final LiveData<Resource<DomainCameraObject>> setCameraParamsToServer(String cameraUuid, CameraObject camera) {
        Integer id;
        SetCameraParamsUseCase setCameraParamsUseCase = this.setCameraParamsUseCase;
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(setCameraParamsUseCase.invoke((currentAddress == null || (id = currentAddress.getId()) == null) ? -1 : id.intValue(), cameraUuid, this.cameraObjectToDomainCameraObjectMapper.map(camera)), null, 0L, 3, null);
    }

    public final void clearResetState() {
        ManageCamerasViewState currentState = getCurrentState();
        ManageCamerasViewState manageCamerasViewStateCopy = currentState.copy((127 & 1) != 0 ? currentState.isSavedTitle : null, (127 & 2) != 0 ? currentState.isSavedOrder : null, (127 & 4) != 0 ? currentState.curCameraObject : null, (127 & 8) != 0 ? currentState.cameraUuid : null, (127 & 16) != 0 ? currentState.orderCameras : null, (127 & 32) != 0 ? currentState.clearCamerasState : Resource.Status.NONE, (127 & 64) != 0 ? currentState.isWidgetTabSelected : false, (127 & 128) != 0 ? currentState.loadCallsState : null, (127 & 256) != 0 ? currentState.callsState : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ManageCamerasViewModel$clearResetState$$inlined$updateState$1(manageCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(manageCamerasViewStateCopy);
    }

    public final void clearSavedTitle() {
        ManageCamerasViewState currentState = getCurrentState();
        ManageCamerasViewState manageCamerasViewStateCopy = currentState.copy((127 & 1) != 0 ? currentState.isSavedTitle : new Event(Boolean.FALSE), (127 & 2) != 0 ? currentState.isSavedOrder : null, (127 & 4) != 0 ? currentState.curCameraObject : null, (127 & 8) != 0 ? currentState.cameraUuid : null, (127 & 16) != 0 ? currentState.orderCameras : null, (127 & 32) != 0 ? currentState.clearCamerasState : null, (127 & 64) != 0 ? currentState.isWidgetTabSelected : false, (127 & 128) != 0 ? currentState.loadCallsState : null, (127 & 256) != 0 ? currentState.callsState : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ManageCamerasViewModel$clearSavedTitle$$inlined$updateState$1(manageCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(manageCamerasViewStateCopy);
    }

    public final void clearSelectedTab() {
        ManageCamerasViewState currentState = getCurrentState();
        ManageCamerasViewState manageCamerasViewStateCopy = currentState.copy((127 & 1) != 0 ? currentState.isSavedTitle : null, (127 & 2) != 0 ? currentState.isSavedOrder : null, (127 & 4) != 0 ? currentState.curCameraObject : null, (127 & 8) != 0 ? currentState.cameraUuid : null, (127 & 16) != 0 ? currentState.orderCameras : null, (127 & 32) != 0 ? currentState.clearCamerasState : null, (127 & 64) != 0 ? currentState.isWidgetTabSelected : false, (127 & 128) != 0 ? currentState.loadCallsState : null, (127 & 256) != 0 ? currentState.callsState : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ManageCamerasViewModel$clearSelectedTab$$inlined$updateState$1(manageCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(manageCamerasViewStateCopy);
    }

    public void getCamerasPreferences(final List<UserAddress> addresses) {
        Intrinsics.checkNotNullParameter(addresses, "addresses");
        ManageCamerasViewState currentState = getCurrentState();
        ManageCamerasViewState manageCamerasViewStateCopy = currentState.copy((127 & 1) != 0 ? currentState.isSavedTitle : null, (127 & 2) != 0 ? currentState.isSavedOrder : null, (127 & 4) != 0 ? currentState.curCameraObject : null, (127 & 8) != 0 ? currentState.cameraUuid : null, (127 & 16) != 0 ? currentState.orderCameras : null, (127 & 32) != 0 ? currentState.clearCamerasState : null, (127 & 64) != 0 ? currentState.isWidgetTabSelected : false, (127 & 128) != 0 ? currentState.loadCallsState : Resource.Status.LOADING, (127 & 256) != 0 ? currentState.callsState : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ManageCamerasViewModel$getCamerasPreferences$$inlined$updateState$1(manageCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(manageCamerasViewStateCopy);
        subscribeOnDataSource(getCamerasPreferencesFromServer(), new Function2<Resource<? extends List<? extends DomainCamerasOrder>>, ManageCamerasViewState, ManageCamerasViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel.getCamerasPreferences.2

            /* compiled from: ManageCamerasViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel$getCamerasPreferences$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ ManageCamerasViewState invoke(Resource<? extends List<? extends DomainCamerasOrder>> resource, ManageCamerasViewState manageCamerasViewState) {
                return invoke2((Resource<? extends List<DomainCamerasOrder>>) resource, manageCamerasViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ManageCamerasViewState invoke2(Resource<? extends List<DomainCamerasOrder>> serverData, ManageCamerasViewState state) {
                Unit unit;
                String message;
                List listEmptyList;
                Object next;
                Object next2;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i != 1 && i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        List<DomainCamerasOrder> data = serverData.getData();
                        if (data == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        } else {
                            List<UserAddress> list = addresses;
                            ArrayList<DomainCamerasOrder> arrayList = new ArrayList();
                            for (Object obj : data) {
                                DomainCamerasOrder domainCamerasOrder = (DomainCamerasOrder) obj;
                                Iterator<T> it = list.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        next2 = null;
                                        break;
                                    }
                                    next2 = it.next();
                                    if (Intrinsics.areEqual(((UserAddress) next2).getId(), domainCamerasOrder.getAddressId())) {
                                        break;
                                    }
                                }
                                if (next2 != null) {
                                    arrayList.add(obj);
                                }
                            }
                            List<UserAddress> list2 = addresses;
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                            for (DomainCamerasOrder domainCamerasOrder2 : arrayList) {
                                Integer addressId = domainCamerasOrder2.getAddressId();
                                Boolean callEnabled = domainCamerasOrder2.getCallEnabled();
                                Iterator<T> it2 = list2.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        next = null;
                                        break;
                                    }
                                    next = it2.next();
                                    if (Intrinsics.areEqual(((UserAddress) next).getId(), domainCamerasOrder2.getAddressId())) {
                                        break;
                                    }
                                }
                                arrayList2.add(new CamerasOrder(addressId, null, callEnabled, (UserAddress) next));
                            }
                            listEmptyList = arrayList2;
                        }
                        return state.copy((127 & 1) != 0 ? state.isSavedTitle : null, (127 & 2) != 0 ? state.isSavedOrder : null, (127 & 4) != 0 ? state.curCameraObject : null, (127 & 8) != 0 ? state.cameraUuid : null, (127 & 16) != 0 ? state.orderCameras : null, (127 & 32) != 0 ? state.clearCamerasState : null, (127 & 64) != 0 ? state.isWidgetTabSelected : false, (127 & 128) != 0 ? state.loadCallsState : Resource.Status.SUCCESS, (127 & 256) != 0 ? state.callsState : listEmptyList);
                    }
                    ManageCamerasViewModel manageCamerasViewModel = ManageCamerasViewModel.this;
                    ManageCamerasViewState currentState2 = manageCamerasViewModel.getCurrentState();
                    ManageCamerasViewState manageCamerasViewStateCopy2 = currentState2.copy((127 & 1) != 0 ? currentState2.isSavedTitle : null, (127 & 2) != 0 ? currentState2.isSavedOrder : null, (127 & 4) != 0 ? currentState2.curCameraObject : null, (127 & 8) != 0 ? currentState2.cameraUuid : null, (127 & 16) != 0 ? currentState2.orderCameras : null, (127 & 32) != 0 ? currentState2.clearCamerasState : null, (127 & 64) != 0 ? currentState2.isWidgetTabSelected : false, (127 & 128) != 0 ? currentState2.loadCallsState : Resource.Status.ERROR, (127 & 256) != 0 ? currentState2.callsState : null);
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(manageCamerasViewModel), null, null, new ManageCamerasViewModel$getCamerasPreferences$2$invoke$$inlined$updateState$1(manageCamerasViewStateCopy2, manageCamerasViewModel, null), 3, null);
                    manageCamerasViewModel.getState().setValue(manageCamerasViewStateCopy2);
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                        unit = null;
                    } else {
                        ManageCamerasViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        ManageCamerasViewModel manageCamerasViewModel2 = ManageCamerasViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        manageCamerasViewModel2.notifySimpleError(error);
                    }
                }
                return null;
            }
        });
    }

    public void handleCurrentCamera(Camera camera) {
        Intrinsics.checkNotNullParameter(camera, "camera");
        ManageCamerasViewState currentState = getCurrentState();
        String uuid = camera.getUuid();
        ManageCamerasViewState manageCamerasViewStateCopy = currentState.copy((127 & 1) != 0 ? currentState.isSavedTitle : null, (127 & 2) != 0 ? currentState.isSavedOrder : null, (127 & 4) != 0 ? currentState.curCameraObject : new CameraObject(camera.getOrder(), camera.getUuid(), camera.getTitle(), null, null, Boolean.valueOf(camera.getWidget()), 24, null), (127 & 8) != 0 ? currentState.cameraUuid : uuid, (127 & 16) != 0 ? currentState.orderCameras : null, (127 & 32) != 0 ? currentState.clearCamerasState : null, (127 & 64) != 0 ? currentState.isWidgetTabSelected : false, (127 & 128) != 0 ? currentState.loadCallsState : null, (127 & 256) != 0 ? currentState.callsState : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ManageCamerasViewModel$handleCurrentCamera$$inlined$updateState$1(manageCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(manageCamerasViewStateCopy);
    }

    public void handleSaveTitle() {
        ManageCamerasViewState currentState = getCurrentState();
        ManageCamerasViewState manageCamerasViewStateCopy = currentState.copy((127 & 1) != 0 ? currentState.isSavedTitle : new Event(Boolean.FALSE), (127 & 2) != 0 ? currentState.isSavedOrder : null, (127 & 4) != 0 ? currentState.curCameraObject : null, (127 & 8) != 0 ? currentState.cameraUuid : null, (127 & 16) != 0 ? currentState.orderCameras : null, (127 & 32) != 0 ? currentState.clearCamerasState : null, (127 & 64) != 0 ? currentState.isWidgetTabSelected : false, (127 & 128) != 0 ? currentState.loadCallsState : null, (127 & 256) != 0 ? currentState.callsState : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ManageCamerasViewModel$handleSaveTitle$$inlined$updateState$1(manageCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(manageCamerasViewStateCopy);
        String cameraUuid = getCurrentState().getCameraUuid();
        Intrinsics.checkNotNull(cameraUuid);
        subscribeOnDataSource(setCameraParamsToServer(cameraUuid, getCurrentState().getCurCameraObject()), new Function2<Resource<? extends DomainCameraObject>, ManageCamerasViewState, ManageCamerasViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel.handleSaveTitle.2

            /* compiled from: ManageCamerasViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel$handleSaveTitle$2$WhenMappings */
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
            public /* bridge */ /* synthetic */ ManageCamerasViewState invoke(Resource<? extends DomainCameraObject> resource, ManageCamerasViewState manageCamerasViewState) {
                return invoke2((Resource<DomainCameraObject>) resource, manageCamerasViewState);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ManageCamerasViewState invoke2(Resource<DomainCameraObject> serverData, ManageCamerasViewState state) {
                Unit unit;
                String message;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                CameraObject cameraObject = null;
                if (i != 1 && i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Event event = new Event(Boolean.TRUE);
                        List<CameraObject> cameras = state.getOrderCameras().getCameras();
                        ManageCamerasViewModel manageCamerasViewModel = ManageCamerasViewModel.this;
                        if (cameras != null) {
                            Iterator<T> it = cameras.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                Object next = it.next();
                                if (Intrinsics.areEqual(manageCamerasViewModel.getCurrentState().getCurCameraObject().getUuid(), ((CameraObject) next).getUuid())) {
                                    cameraObject = next;
                                    break;
                                }
                            }
                            cameraObject = cameraObject;
                        }
                        if (cameraObject != null && cameraObject.getTitle() != null) {
                            cameraObject.setTitle(manageCamerasViewModel.getCurrentState().getCurCameraObject().getTitle());
                        }
                        Unit unit2 = Unit.INSTANCE;
                        return state.copy((127 & 1) != 0 ? state.isSavedTitle : event, (127 & 2) != 0 ? state.isSavedOrder : null, (127 & 4) != 0 ? state.curCameraObject : null, (127 & 8) != 0 ? state.cameraUuid : null, (127 & 16) != 0 ? state.orderCameras : new CamerasOrder(null, cameras, null, null, 13, null), (127 & 32) != 0 ? state.clearCamerasState : null, (127 & 64) != 0 ? state.isWidgetTabSelected : false, (127 & 128) != 0 ? state.loadCallsState : null, (127 & 256) != 0 ? state.callsState : null);
                    }
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                        unit = null;
                    } else {
                        ManageCamerasViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        ManageCamerasViewModel manageCamerasViewModel2 = ManageCamerasViewModel.this;
                        Exception error = serverData.getError();
                        Intrinsics.checkNotNull(error);
                        manageCamerasViewModel2.notifySimpleError(error);
                    }
                }
                return null;
            }
        });
    }

    public void handleTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        ManageCamerasViewState currentState = getCurrentState();
        ManageCamerasViewState manageCamerasViewStateCopy = currentState.copy((127 & 1) != 0 ? currentState.isSavedTitle : null, (127 & 2) != 0 ? currentState.isSavedOrder : null, (127 & 4) != 0 ? currentState.curCameraObject : CameraObject.copy$default(currentState.getCurCameraObject(), null, null, title, null, null, null, 59, null), (127 & 8) != 0 ? currentState.cameraUuid : null, (127 & 16) != 0 ? currentState.orderCameras : null, (127 & 32) != 0 ? currentState.clearCamerasState : null, (127 & 64) != 0 ? currentState.isWidgetTabSelected : false, (127 & 128) != 0 ? currentState.loadCallsState : null, (127 & 256) != 0 ? currentState.callsState : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ManageCamerasViewModel$handleTitle$$inlined$updateState$1(manageCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(manageCamerasViewStateCopy);
    }

    public final void resetOrder() {
        ManageCamerasViewState currentState = getCurrentState();
        ManageCamerasViewState manageCamerasViewStateCopy = currentState.copy((127 & 1) != 0 ? currentState.isSavedTitle : null, (127 & 2) != 0 ? currentState.isSavedOrder : null, (127 & 4) != 0 ? currentState.curCameraObject : null, (127 & 8) != 0 ? currentState.cameraUuid : null, (127 & 16) != 0 ? currentState.orderCameras : null, (127 & 32) != 0 ? currentState.clearCamerasState : Resource.Status.LOADING, (127 & 64) != 0 ? currentState.isWidgetTabSelected : false, (127 & 128) != 0 ? currentState.loadCallsState : null, (127 & 256) != 0 ? currentState.callsState : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ManageCamerasViewModel$resetOrder$$inlined$updateState$1(manageCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(manageCamerasViewStateCopy);
        subscribeOnDataSource(clearCamerasPreferencesOnServer(), new Function2<Resource<? extends Unit>, ManageCamerasViewState, ManageCamerasViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel.resetOrder.2

            /* compiled from: ManageCamerasViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel$resetOrder$2$WhenMappings */
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

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ ManageCamerasViewState invoke(Resource<? extends Unit> resource, ManageCamerasViewState manageCamerasViewState) {
                return invoke2((Resource<Unit>) resource, manageCamerasViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ManageCamerasViewState invoke2(Resource<Unit> serverData, ManageCamerasViewState state) {
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                if (i == 1 || i == 2) {
                    return null;
                }
                if (i == 3) {
                    return state.copy((127 & 1) != 0 ? state.isSavedTitle : null, (127 & 2) != 0 ? state.isSavedOrder : null, (127 & 4) != 0 ? state.curCameraObject : null, (127 & 8) != 0 ? state.cameraUuid : null, (127 & 16) != 0 ? state.orderCameras : null, (127 & 32) != 0 ? state.clearCamerasState : Resource.Status.ERROR, (127 & 64) != 0 ? state.isWidgetTabSelected : false, (127 & 128) != 0 ? state.loadCallsState : null, (127 & 256) != 0 ? state.callsState : null);
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                return state.copy((127 & 1) != 0 ? state.isSavedTitle : null, (127 & 2) != 0 ? state.isSavedOrder : new Event(Boolean.TRUE), (127 & 4) != 0 ? state.curCameraObject : null, (127 & 8) != 0 ? state.cameraUuid : null, (127 & 16) != 0 ? state.orderCameras : new CamerasOrder(null, null, null, null, 15, null), (127 & 32) != 0 ? state.clearCamerasState : Resource.Status.SUCCESS, (127 & 64) != 0 ? state.isWidgetTabSelected : false, (127 & 128) != 0 ? state.loadCallsState : null, (127 & 256) != 0 ? state.callsState : null);
            }
        });
    }

    public final void setWidgetTabSelected(boolean isSelected) {
        ManageCamerasViewState currentState = getCurrentState();
        ManageCamerasViewState manageCamerasViewStateCopy = currentState.copy((127 & 1) != 0 ? currentState.isSavedTitle : null, (127 & 2) != 0 ? currentState.isSavedOrder : null, (127 & 4) != 0 ? currentState.curCameraObject : null, (127 & 8) != 0 ? currentState.cameraUuid : null, (127 & 16) != 0 ? currentState.orderCameras : null, (127 & 32) != 0 ? currentState.clearCamerasState : null, (127 & 64) != 0 ? currentState.isWidgetTabSelected : isSelected, (127 & 128) != 0 ? currentState.loadCallsState : null, (127 & 256) != 0 ? currentState.callsState : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ManageCamerasViewModel$setWidgetTabSelected$$inlined$updateState$1(manageCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(manageCamerasViewStateCopy);
    }

    private final LiveData<Resource<Unit>> clearCamerasPreferencesOnServer() {
        Integer id;
        ClearCamerasPreferencesUseCase clearCamerasPreferencesUseCase = this.clearCamerasPreferencesUseCase;
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(clearCamerasPreferencesUseCase.invoke((currentAddress == null || (id = currentAddress.getId()) == null) ? -1 : id.intValue()), null, 0L, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleSaveNewOrder(List<? extends ManageCamerasItem> cameras) {
        Camera cameraCopy;
        Intrinsics.checkNotNullParameter(cameras, "cameras");
        List<? extends ManageCamerasItem> list = cameras;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        int i = 0;
        boolean z = false;
        while (true) {
            cameraCopy = null;
            if (!it.hasNext()) {
                break;
            }
            ManageCamerasItem manageCamerasItem = (ManageCamerasItem) it.next();
            if (manageCamerasItem instanceof ManageCamerasItem.ManageTitle) {
                z = !z;
            } else {
                Intrinsics.checkNotNull(manageCamerasItem, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.ManageCamerasItem.ManageCamera");
                Camera item = ((ManageCamerasItem.ManageCamera) manageCamerasItem).getItem();
                cameraCopy = item.copy((3145727 & 1) != 0 ? item.uuid : null, (3145727 & 2) != 0 ? item.streamUrl : null, (3145727 & 4) != 0 ? item.previewUrl : null, (3145727 & 8) != 0 ? item.isIntercom : false, (3145727 & 16) != 0 ? item.intercomUuid : null, (3145727 & 32) != 0 ? item.intercomSerial : null, (3145727 & 64) != 0 ? item.width : 0, (3145727 & 128) != 0 ? item.height : 0, (3145727 & 256) != 0 ? item.title : null, (3145727 & 512) != 0 ? item.order : null, (3145727 & 1024) != 0 ? item.widget : false, (3145727 & 2048) != 0 ? item.address : null, (3145727 & 4096) != 0 ? item.isLoadPhotoFailed : false, (3145727 & 8192) != 0 ? item.isLoadVideoFailed : false, (3145727 & 16384) != 0 ? item.transitionName : null, (3145727 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? item.flussonicData : null, (3145727 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? item.extraKeyReader : null, (3145727 & 131072) != 0 ? item.mainScreen : z, (3145727 & 262144) != 0 ? item.subscriptionRequried : null, (3145727 & 524288) != 0 ? item.canOpen : null, (3145727 & 1048576) != 0 ? item.isLive : false, (3145727 & 2097152) != 0 ? item.isSelected : false);
            }
            arrayList.add(cameraCopy);
        }
        List listFilterNotNull = CollectionsKt.filterNotNull(arrayList);
        Iterator it2 = listFilterNotNull.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((Camera) next).getWidget()) {
                cameraCopy = next;
                break;
            }
        }
        if (cameraCopy != null) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFilterNotNull, 10));
            for (Object obj : listFilterNotNull) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Camera camera = (Camera) obj;
                arrayList2.add(new CameraObject(Integer.valueOf(i2), camera.getUuid(), camera.getTitle(), null, Boolean.valueOf(camera.getMainScreen()), null, 8, null));
                i = i2;
            }
            subscribeOnDataSource(setCamerasOrderToServer(new CamerasOrder(null, arrayList2, null, null, 8, null)), new Function2<Resource<? extends DomainCamerasOrder>, ManageCamerasViewState, ManageCamerasViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel.handleSaveNewOrder.1

                /* compiled from: ManageCamerasViewModel.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel$handleSaveNewOrder$1$WhenMappings */
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
                public /* bridge */ /* synthetic */ ManageCamerasViewState invoke(Resource<? extends DomainCamerasOrder> resource, ManageCamerasViewState manageCamerasViewState) {
                    return invoke2((Resource<DomainCamerasOrder>) resource, manageCamerasViewState);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final ManageCamerasViewState invoke2(Resource<DomainCamerasOrder> serverData, ManageCamerasViewState state) {
                    Unit unit;
                    String message;
                    List listEmptyList;
                    List<DomainCameraObject> cameras2;
                    Intrinsics.checkNotNullParameter(serverData, "serverData");
                    Intrinsics.checkNotNullParameter(state, "state");
                    ManageCamerasViewModel manageCamerasViewModel = ManageCamerasViewModel.this;
                    ManageCamerasViewState currentState = manageCamerasViewModel.getCurrentState();
                    ManageCamerasViewState manageCamerasViewStateCopy = currentState.copy((127 & 1) != 0 ? currentState.isSavedTitle : null, (127 & 2) != 0 ? currentState.isSavedOrder : new Event(Boolean.FALSE), (127 & 4) != 0 ? currentState.curCameraObject : null, (127 & 8) != 0 ? currentState.cameraUuid : null, (127 & 16) != 0 ? currentState.orderCameras : null, (127 & 32) != 0 ? currentState.clearCamerasState : null, (127 & 64) != 0 ? currentState.isWidgetTabSelected : false, (127 & 128) != 0 ? currentState.loadCallsState : null, (127 & 256) != 0 ? currentState.callsState : null);
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(manageCamerasViewModel), null, null, new ManageCamerasViewModel$handleSaveNewOrder$1$invoke$$inlined$updateState$1(manageCamerasViewStateCopy, manageCamerasViewModel, null), 3, null);
                    manageCamerasViewModel.getState().setValue(manageCamerasViewStateCopy);
                    int i3 = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                    if (i3 != 1 && i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                throw new NoWhenBranchMatchedException();
                            }
                            Event event = new Event(Boolean.TRUE);
                            DomainCamerasOrder data = serverData.getData();
                            if (data != null && (cameras2 = data.getCameras()) != null) {
                                List<DomainCameraObject> list2 = cameras2;
                                DomainCameraObjectToCameraObjectMapper domainCameraObjectToCameraObjectMapper = ManageCamerasViewModel.this.domainCameraObjectToCameraObjectMapper;
                                listEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                                Iterator<T> it3 = list2.iterator();
                                while (it3.hasNext()) {
                                    listEmptyList.add(domainCameraObjectToCameraObjectMapper.map((DomainCameraObject) it3.next()));
                                }
                            } else {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                            return state.copy((127 & 1) != 0 ? state.isSavedTitle : null, (127 & 2) != 0 ? state.isSavedOrder : event, (127 & 4) != 0 ? state.curCameraObject : null, (127 & 8) != 0 ? state.cameraUuid : null, (127 & 16) != 0 ? state.orderCameras : new CamerasOrder(null, listEmptyList, null, null, 8, null), (127 & 32) != 0 ? state.clearCamerasState : null, (127 & 64) != 0 ? state.isWidgetTabSelected : false, (127 & 128) != 0 ? state.loadCallsState : null, (127 & 256) != 0 ? state.callsState : null);
                        }
                        DomainEmpty errorMsg = serverData.getErrorMsg();
                        if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                            unit = null;
                        } else {
                            ManageCamerasViewModel.this.notifyErrorMessage(message.toString());
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            ManageCamerasViewModel manageCamerasViewModel2 = ManageCamerasViewModel.this;
                            Exception error = serverData.getError();
                            Intrinsics.checkNotNull(error);
                            manageCamerasViewModel2.notifySimpleError(error);
                        }
                    }
                    return null;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleSaveNewOrderForWidgets(List<? extends ManageCamerasItem> cameras) {
        Camera cameraCopy;
        Intrinsics.checkNotNullParameter(cameras, "cameras");
        List<? extends ManageCamerasItem> list = cameras;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        int i = 0;
        boolean z = false;
        while (true) {
            cameraCopy = null;
            if (!it.hasNext()) {
                break;
            }
            ManageCamerasItem manageCamerasItem = (ManageCamerasItem) it.next();
            if (manageCamerasItem instanceof ManageCamerasItem.ManageTitle) {
                z = !z;
            } else {
                Intrinsics.checkNotNull(manageCamerasItem, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.adapter.ManageCamerasItem.ManageCamera");
                Camera item = ((ManageCamerasItem.ManageCamera) manageCamerasItem).getItem();
                cameraCopy = item.copy((3145727 & 1) != 0 ? item.uuid : null, (3145727 & 2) != 0 ? item.streamUrl : null, (3145727 & 4) != 0 ? item.previewUrl : null, (3145727 & 8) != 0 ? item.isIntercom : false, (3145727 & 16) != 0 ? item.intercomUuid : null, (3145727 & 32) != 0 ? item.intercomSerial : null, (3145727 & 64) != 0 ? item.width : 0, (3145727 & 128) != 0 ? item.height : 0, (3145727 & 256) != 0 ? item.title : null, (3145727 & 512) != 0 ? item.order : null, (3145727 & 1024) != 0 ? item.widget : z, (3145727 & 2048) != 0 ? item.address : null, (3145727 & 4096) != 0 ? item.isLoadPhotoFailed : false, (3145727 & 8192) != 0 ? item.isLoadVideoFailed : false, (3145727 & 16384) != 0 ? item.transitionName : null, (3145727 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? item.flussonicData : null, (3145727 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? item.extraKeyReader : null, (3145727 & 131072) != 0 ? item.mainScreen : false, (3145727 & 262144) != 0 ? item.subscriptionRequried : null, (3145727 & 524288) != 0 ? item.canOpen : null, (3145727 & 1048576) != 0 ? item.isLive : false, (3145727 & 2097152) != 0 ? item.isSelected : false);
            }
            arrayList.add(cameraCopy);
        }
        List listFilterNotNull = CollectionsKt.filterNotNull(arrayList);
        Iterator it2 = listFilterNotNull.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((Camera) next).getWidget()) {
                cameraCopy = next;
                break;
            }
        }
        if (cameraCopy != null) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFilterNotNull, 10));
            for (Object obj : listFilterNotNull) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Camera camera = (Camera) obj;
                arrayList2.add(new CameraObject(null, camera.getUuid(), camera.getTitle(), Integer.valueOf(i2), null, Boolean.valueOf(camera.getWidget()), 17, null));
                i = i2;
            }
            subscribeOnDataSource(setCamerasOrderToServer(new CamerasOrder(null, arrayList2, null, null, 8, null)), new Function2<Resource<? extends DomainCamerasOrder>, ManageCamerasViewState, ManageCamerasViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel.handleSaveNewOrderForWidgets.1

                /* compiled from: ManageCamerasViewModel.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel$handleSaveNewOrderForWidgets$1$WhenMappings */
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
                public /* bridge */ /* synthetic */ ManageCamerasViewState invoke(Resource<? extends DomainCamerasOrder> resource, ManageCamerasViewState manageCamerasViewState) {
                    return invoke2((Resource<DomainCamerasOrder>) resource, manageCamerasViewState);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final ManageCamerasViewState invoke2(Resource<DomainCamerasOrder> serverData, ManageCamerasViewState state) {
                    Unit unit;
                    String message;
                    List listEmptyList;
                    List<DomainCameraObject> cameras2;
                    Intrinsics.checkNotNullParameter(serverData, "serverData");
                    Intrinsics.checkNotNullParameter(state, "state");
                    ManageCamerasViewModel manageCamerasViewModel = ManageCamerasViewModel.this;
                    ManageCamerasViewState currentState = manageCamerasViewModel.getCurrentState();
                    ManageCamerasViewState manageCamerasViewStateCopy = currentState.copy((127 & 1) != 0 ? currentState.isSavedTitle : null, (127 & 2) != 0 ? currentState.isSavedOrder : new Event(Boolean.FALSE), (127 & 4) != 0 ? currentState.curCameraObject : null, (127 & 8) != 0 ? currentState.cameraUuid : null, (127 & 16) != 0 ? currentState.orderCameras : null, (127 & 32) != 0 ? currentState.clearCamerasState : null, (127 & 64) != 0 ? currentState.isWidgetTabSelected : false, (127 & 128) != 0 ? currentState.loadCallsState : null, (127 & 256) != 0 ? currentState.callsState : null);
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(manageCamerasViewModel), null, null, new ManageCamerasViewModel$handleSaveNewOrderForWidgets$1$invoke$$inlined$updateState$1(manageCamerasViewStateCopy, manageCamerasViewModel, null), 3, null);
                    manageCamerasViewModel.getState().setValue(manageCamerasViewStateCopy);
                    int i3 = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                    if (i3 != 1 && i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                throw new NoWhenBranchMatchedException();
                            }
                            Event event = new Event(Boolean.TRUE);
                            DomainCamerasOrder data = serverData.getData();
                            if (data != null && (cameras2 = data.getCameras()) != null) {
                                List<DomainCameraObject> list2 = cameras2;
                                DomainCameraObjectToCameraObjectMapper domainCameraObjectToCameraObjectMapper = ManageCamerasViewModel.this.domainCameraObjectToCameraObjectMapper;
                                listEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                                Iterator<T> it3 = list2.iterator();
                                while (it3.hasNext()) {
                                    listEmptyList.add(domainCameraObjectToCameraObjectMapper.map((DomainCameraObject) it3.next()));
                                }
                            } else {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                            return state.copy((127 & 1) != 0 ? state.isSavedTitle : null, (127 & 2) != 0 ? state.isSavedOrder : event, (127 & 4) != 0 ? state.curCameraObject : null, (127 & 8) != 0 ? state.cameraUuid : null, (127 & 16) != 0 ? state.orderCameras : new CamerasOrder(null, listEmptyList, null, null, 13, null), (127 & 32) != 0 ? state.clearCamerasState : null, (127 & 64) != 0 ? state.isWidgetTabSelected : false, (127 & 128) != 0 ? state.loadCallsState : null, (127 & 256) != 0 ? state.callsState : null);
                        }
                        DomainEmpty errorMsg = serverData.getErrorMsg();
                        if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                            unit = null;
                        } else {
                            ManageCamerasViewModel.this.notifyErrorMessage(message.toString());
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            ManageCamerasViewModel manageCamerasViewModel2 = ManageCamerasViewModel.this;
                            Exception error = serverData.getError();
                            Intrinsics.checkNotNull(error);
                            manageCamerasViewModel2.notifySimpleError(error);
                        }
                    }
                    return null;
                }
            });
        }
    }

    public final void setCallsEnabledForAddress(final int addressId, final boolean callsEnabled) {
        subscribeOnDataSource(setCallsEnabledOnServer(addressId, callsEnabled), new Function2<Resource<? extends DomainCamerasOrder>, ManageCamerasViewState, ManageCamerasViewState>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel.setCallsEnabledForAddress.1

            /* compiled from: ManageCamerasViewModel.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel.ManageCamerasViewModel$setCallsEnabledForAddress$1$WhenMappings */
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
            public /* bridge */ /* synthetic */ ManageCamerasViewState invoke(Resource<? extends DomainCamerasOrder> resource, ManageCamerasViewState manageCamerasViewState) {
                return invoke2((Resource<DomainCamerasOrder>) resource, manageCamerasViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ManageCamerasViewState invoke2(Resource<DomainCamerasOrder> serverData, ManageCamerasViewState state) {
                Unit unit;
                String message;
                ProfileSettingsLocale profileSettings;
                List<String> messages;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                Intrinsics.checkNotNullParameter(state, "state");
                int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                String str = null;
                if (i != 1 && i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        ManageCamerasViewModel manageCamerasViewModel = ManageCamerasViewModel.this;
                        LocalizationLocalModel data = manageCamerasViewModel.localizationStorage.getData();
                        if (data != null && (profileSettings = data.getProfileSettings()) != null && (messages = profileSettings.getMessages()) != null) {
                            str = (String) CollectionsKt.firstOrNull((List) messages);
                        }
                        if (str == null) {
                            str = "";
                        }
                        manageCamerasViewModel.notifySuccessMessage(str);
                        List<CamerasOrder> callsState = state.getCallsState();
                        int i2 = addressId;
                        boolean z = callsEnabled;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(callsState, 10));
                        for (CamerasOrder camerasOrderCopy$default : callsState) {
                            Integer addressId2 = camerasOrderCopy$default.getAddressId();
                            if (addressId2 != null && addressId2.intValue() == i2) {
                                camerasOrderCopy$default = CamerasOrder.copy$default(camerasOrderCopy$default, null, null, Boolean.valueOf(z), null, 11, null);
                            }
                            arrayList.add(camerasOrderCopy$default);
                        }
                        return state.copy((127 & 1) != 0 ? state.isSavedTitle : null, (127 & 2) != 0 ? state.isSavedOrder : null, (127 & 4) != 0 ? state.curCameraObject : null, (127 & 8) != 0 ? state.cameraUuid : null, (127 & 16) != 0 ? state.orderCameras : null, (127 & 32) != 0 ? state.clearCamerasState : null, (127 & 64) != 0 ? state.isWidgetTabSelected : false, (127 & 128) != 0 ? state.loadCallsState : null, (127 & 256) != 0 ? state.callsState : arrayList);
                    }
                    Exception error = serverData.getError();
                    if (error != null) {
                        error.printStackTrace();
                    }
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    if (errorMsg == null || (message = errorMsg.getMessage()) == null) {
                        unit = null;
                    } else {
                        ManageCamerasViewModel.this.notifyErrorMessage(message.toString());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        ManageCamerasViewModel manageCamerasViewModel2 = ManageCamerasViewModel.this;
                        Exception error2 = serverData.getError();
                        Intrinsics.checkNotNull(error2);
                        manageCamerasViewModel2.notifySimpleError(error2);
                    }
                }
                return null;
            }
        });
    }
}
