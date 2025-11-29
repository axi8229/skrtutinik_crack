package com.sputnik.common.viewmodels;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.BaseViewModel$updateState$1;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.entities.camera.CameraObject;
import com.sputnik.common.entities.camera.CamerasFiltering$ListTypes;
import com.sputnik.common.entities.camera.CamerasFiltering$OrderTypes;
import com.sputnik.common.mappers.cameras.DomainCameraToCameraMapper;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.viewmodels.interfaces.ICamerasViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.cameras.DomainCamera;
import com.sputnik.domain.entities.door.OpenDoorProducers;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.usecases.cameras.GetAllCamerasUseCase;
import com.sputnik.domain.usecases.cameras.GetCamerasDemoUseCase;
import com.sputnik.domain.usecases.cameras.OpenDoorUseCase;
import com.sputnik.domain.usecases.cameras.OpenSecondDoorUseCase;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import org.pjsip.pjsua2.pjmedia_tp_proto;

/* compiled from: AllCamerasViewModel.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001SBW\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001c0\u001b0\u001a2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001c0\u001b0\u001aH\u0002¢\u0006\u0004\b\u001f\u0010 J9\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001b0\u001a2\u0006\u0010!\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\"2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b&\u0010'J-\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001b0\u001a2\u0006\u0010!\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020%H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020%H\u0016¢\u0006\u0004\b,\u0010+J\u000f\u0010-\u001a\u00020%H\u0016¢\u0006\u0004\b-\u0010+J\u000f\u0010.\u001a\u00020%H\u0016¢\u0006\u0004\b.\u0010+J\u000f\u0010/\u001a\u00020%H\u0016¢\u0006\u0004\b/\u0010+J\u0017\u00102\u001a\u00020%2\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J#\u00105\u001a\u00020%2\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020%H\u0016¢\u0006\u0004\b7\u0010+J\u0017\u00109\u001a\u00020%2\u0006\u00108\u001a\u00020\"H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020%2\u0006\u0010;\u001a\u00020\"H\u0016¢\u0006\u0004\b<\u0010:J\u0017\u0010>\u001a\u00020%2\u0006\u0010=\u001a\u00020\"H\u0016¢\u0006\u0004\b>\u0010:J\u0017\u0010@\u001a\u00020%2\u0006\u0010?\u001a\u00020\"H\u0016¢\u0006\u0004\b@\u0010:J\r\u0010A\u001a\u00020%¢\u0006\u0004\bA\u0010+J\r\u0010B\u001a\u00020%¢\u0006\u0004\bB\u0010+J\u0013\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00120\u001c¢\u0006\u0004\bC\u0010DJ\u001b\u0010G\u001a\u00020%2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020E0\u001c¢\u0006\u0004\bG\u0010HJ\u0015\u0010J\u001a\u00020%2\u0006\u0010I\u001a\u00020\"¢\u0006\u0004\bJ\u0010:R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010KR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010LR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010MR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010NR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010OR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010PR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010QR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010R¨\u0006T"}, d2 = {"Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lcom/sputnik/common/viewmodels/AllCamerasViewState;", "Lcom/sputnik/common/viewmodels/interfaces/ICamerasViewModel;", "", "failureTitle", "Lcom/sputnik/domain/usecases/cameras/GetAllCamerasUseCase;", "getAllCamerasUseCase", "Lcom/sputnik/domain/usecases/cameras/GetCamerasDemoUseCase;", "getDemoCamerasUseCase", "Lcom/sputnik/domain/usecases/cameras/OpenDoorUseCase;", "openDoorUseCase", "Lcom/sputnik/domain/usecases/cameras/OpenSecondDoorUseCase;", "openSecondDoorUseCase", "Lcom/sputnik/common/mappers/cameras/DomainCameraToCameraMapper;", "domainCameraToCameraMapper", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/domain/entities/cameras/DomainCamera;", "Lcom/sputnik/common/entities/camera/Camera;", "listMapper", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/usecases/cameras/GetAllCamerasUseCase;Lcom/sputnik/domain/usecases/cameras/GetCamerasDemoUseCase;Lcom/sputnik/domain/usecases/cameras/OpenDoorUseCase;Lcom/sputnik/domain/usecases/cameras/OpenSecondDoorUseCase;Lcom/sputnik/common/mappers/cameras/DomainCameraToCameraMapper;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/data/local/PrefManager;)V", "listType", "orderType", "Landroidx/lifecycle/LiveData;", "Lcom/sputnik/domain/common/Resource;", "", "getCameras", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "getDemoCameras", "()Landroidx/lifecycle/LiveData;", "uuid", "", "isWidget", "addressId", "", "openDoorToServer", "(Ljava/lang/String;ZLjava/lang/String;)Landroidx/lifecycle/LiveData;", "openSecondDoorToServer", "(Ljava/lang/String;Z)Landroidx/lifecycle/LiveData;", "loadCamerasIfNeeded", "()V", "loadMainCameras", "loadDemoCameras", "loadAllCameras", "loadWidgetCameras", "", "position", "handleCamera", "(I)V", "flatUUID", "openDoor", "(Ljava/lang/String;Ljava/lang/String;)V", "openSecondDoor", "isLoading", "handleLoading", "(Z)V", "isZoomMode", "handleZoomMode", "needUpdate", "handleNeedUpdate", AppMeasurementSdk.ConditionalUserProperty.VALUE, "setNeedLoadCameras", "clearCamerasState", "logout", "getCurrentCameras", "()Ljava/util/List;", "Lcom/sputnik/common/entities/camera/CameraObject;", "list", "updateCamerasList", "(Ljava/util/List;)V", "isLive", "setCurrentCameraLiveState", "Ljava/lang/String;", "Lcom/sputnik/domain/usecases/cameras/GetAllCamerasUseCase;", "Lcom/sputnik/domain/usecases/cameras/GetCamerasDemoUseCase;", "Lcom/sputnik/domain/usecases/cameras/OpenDoorUseCase;", "Lcom/sputnik/domain/usecases/cameras/OpenSecondDoorUseCase;", "Lcom/sputnik/common/mappers/cameras/DomainCameraToCameraMapper;", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/data/local/PrefManager;", "Factory", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AllCamerasViewModel extends BaseViewModel<AllCamerasViewState> implements ICamerasViewModel {
    private final DomainCameraToCameraMapper domainCameraToCameraMapper;
    private final String failureTitle;
    private final GetAllCamerasUseCase getAllCamerasUseCase;
    private final GetCamerasDemoUseCase getDemoCamerasUseCase;
    private final ListMapper<DomainCamera, Camera> listMapper;
    private final OpenDoorUseCase openDoorUseCase;
    private final OpenSecondDoorUseCase openSecondDoorUseCase;
    private final PrefManager prefManager;

    public /* synthetic */ AllCamerasViewModel(String str, GetAllCamerasUseCase getAllCamerasUseCase, GetCamerasDemoUseCase getCamerasDemoUseCase, OpenDoorUseCase openDoorUseCase, OpenSecondDoorUseCase openSecondDoorUseCase, DomainCameraToCameraMapper domainCameraToCameraMapper, ListMapper listMapper, PrefManager prefManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, getAllCamerasUseCase, getCamerasDemoUseCase, openDoorUseCase, openSecondDoorUseCase, domainCameraToCameraMapper, listMapper, prefManager);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AllCamerasViewModel(String str, GetAllCamerasUseCase getAllCamerasUseCase, GetCamerasDemoUseCase getDemoCamerasUseCase, OpenDoorUseCase openDoorUseCase, OpenSecondDoorUseCase openSecondDoorUseCase, DomainCameraToCameraMapper domainCameraToCameraMapper, ListMapper<DomainCamera, Camera> listMapper, PrefManager prefManager) {
        super(new AllCamerasViewState(null, null, null, null, null, null, null, null, 0, null, false, false, null, null, null, null, false, false, null, false, 1048575, null), "javaClass");
        Intrinsics.checkNotNullParameter(getAllCamerasUseCase, "getAllCamerasUseCase");
        Intrinsics.checkNotNullParameter(getDemoCamerasUseCase, "getDemoCamerasUseCase");
        Intrinsics.checkNotNullParameter(openDoorUseCase, "openDoorUseCase");
        Intrinsics.checkNotNullParameter(openSecondDoorUseCase, "openSecondDoorUseCase");
        Intrinsics.checkNotNullParameter(domainCameraToCameraMapper, "domainCameraToCameraMapper");
        Intrinsics.checkNotNullParameter(listMapper, "listMapper");
        Intrinsics.checkNotNullParameter(prefManager, "prefManager");
        this.failureTitle = str;
        this.getAllCamerasUseCase = getAllCamerasUseCase;
        this.getDemoCamerasUseCase = getDemoCamerasUseCase;
        this.openDoorUseCase = openDoorUseCase;
        this.openSecondDoorUseCase = openSecondDoorUseCase;
        this.domainCameraToCameraMapper = domainCameraToCameraMapper;
        this.listMapper = listMapper;
        this.prefManager = prefManager;
        if (getCurrentState().getServerState() == Resource.Status.NONE) {
            if (prefManager.getIsNoDomofon()) {
                loadDemoCameras();
            } else {
                loadMainCameras();
            }
        }
    }

    /* compiled from: AllCamerasViewModel.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001bBW\b\u0007\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J%\u0010\u0015\u001a\u0002H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019H\u0016¢\u0006\u0002\u0010\u001aR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "failureTitle", "", "getAllCamerasUseCase", "Lcom/sputnik/domain/usecases/cameras/GetAllCamerasUseCase;", "getDemoCamerasUseCase", "Lcom/sputnik/domain/usecases/cameras/GetCamerasDemoUseCase;", "openDoorUseCase", "Lcom/sputnik/domain/usecases/cameras/OpenDoorUseCase;", "openSecondDoorUseCase", "Lcom/sputnik/domain/usecases/cameras/OpenSecondDoorUseCase;", "domainCameraToCameraMapper", "Lcom/sputnik/common/mappers/cameras/DomainCameraToCameraMapper;", "listMapper", "Lcom/sputnik/domain/common/ListMapper;", "Lcom/sputnik/domain/entities/cameras/DomainCamera;", "Lcom/sputnik/common/entities/camera/Camera;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "(Ljava/lang/String;Lcom/sputnik/domain/usecases/cameras/GetAllCamerasUseCase;Lcom/sputnik/domain/usecases/cameras/GetCamerasDemoUseCase;Lcom/sputnik/domain/usecases/cameras/OpenDoorUseCase;Lcom/sputnik/domain/usecases/cameras/OpenSecondDoorUseCase;Lcom/sputnik/common/mappers/cameras/DomainCameraToCameraMapper;Lcom/sputnik/domain/common/ListMapper;Lcom/sputnik/data/local/PrefManager;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "AssistFactory", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Factory extends ViewModelProvider.NewInstanceFactory {
        private final DomainCameraToCameraMapper domainCameraToCameraMapper;
        private final String failureTitle;
        private final GetAllCamerasUseCase getAllCamerasUseCase;
        private final GetCamerasDemoUseCase getDemoCamerasUseCase;
        private final ListMapper<DomainCamera, Camera> listMapper;
        private final OpenDoorUseCase openDoorUseCase;
        private final OpenSecondDoorUseCase openSecondDoorUseCase;
        private final PrefManager prefManager;

        /* compiled from: AllCamerasViewModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "", "create", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory;", "failureTitle", "", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public interface AssistFactory {
            Factory create(String failureTitle);
        }

        public Factory(String str, GetAllCamerasUseCase getAllCamerasUseCase, GetCamerasDemoUseCase getDemoCamerasUseCase, OpenDoorUseCase openDoorUseCase, OpenSecondDoorUseCase openSecondDoorUseCase, DomainCameraToCameraMapper domainCameraToCameraMapper, ListMapper<DomainCamera, Camera> listMapper, PrefManager prefManager) {
            Intrinsics.checkNotNullParameter(getAllCamerasUseCase, "getAllCamerasUseCase");
            Intrinsics.checkNotNullParameter(getDemoCamerasUseCase, "getDemoCamerasUseCase");
            Intrinsics.checkNotNullParameter(openDoorUseCase, "openDoorUseCase");
            Intrinsics.checkNotNullParameter(openSecondDoorUseCase, "openSecondDoorUseCase");
            Intrinsics.checkNotNullParameter(domainCameraToCameraMapper, "domainCameraToCameraMapper");
            Intrinsics.checkNotNullParameter(listMapper, "listMapper");
            Intrinsics.checkNotNullParameter(prefManager, "prefManager");
            this.failureTitle = str;
            this.getAllCamerasUseCase = getAllCamerasUseCase;
            this.getDemoCamerasUseCase = getDemoCamerasUseCase;
            this.openDoorUseCase = openDoorUseCase;
            this.openSecondDoorUseCase = openSecondDoorUseCase;
            this.domainCameraToCameraMapper = domainCameraToCameraMapper;
            this.listMapper = listMapper;
            this.prefManager = prefManager;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            if (!Intrinsics.areEqual(modelClass, AllCamerasViewModel.class)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            return new AllCamerasViewModel(this.failureTitle, this.getAllCamerasUseCase, this.getDemoCamerasUseCase, this.openDoorUseCase, this.openSecondDoorUseCase, this.domainCameraToCameraMapper, this.listMapper, this.prefManager);
        }
    }

    private final LiveData<Resource<List<DomainCamera>>> getCameras(String listType, String orderType) {
        Integer id;
        GetAllCamerasUseCase getAllCamerasUseCase = this.getAllCamerasUseCase;
        LoginState.Session.Address currentAddress = this.prefManager.getCurrentAddress();
        return FlowLiveDataConversions.asLiveData$default(getAllCamerasUseCase.invoke((currentAddress == null || (id = currentAddress.getId()) == null) ? -1 : id.intValue(), listType, orderType), null, 0L, 3, null);
    }

    private final LiveData<Resource<List<DomainCamera>>> getDemoCameras() {
        return FlowLiveDataConversions.asLiveData$default(this.getDemoCamerasUseCase.invoke(), null, 0L, 3, null);
    }

    static /* synthetic */ LiveData openDoorToServer$default(AllCamerasViewModel allCamerasViewModel, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return allCamerasViewModel.openDoorToServer(str, z, str2);
    }

    private final LiveData<Resource<Unit>> openDoorToServer(String uuid, boolean isWidget, String addressId) {
        return FlowLiveDataConversions.asLiveData$default(this.openDoorUseCase.invoke(uuid, isWidget, OpenDoorProducers.app, addressId), null, 0L, 3, null);
    }

    static /* synthetic */ LiveData openSecondDoorToServer$default(AllCamerasViewModel allCamerasViewModel, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return allCamerasViewModel.openSecondDoorToServer(str, z);
    }

    private final LiveData<Resource<Unit>> openSecondDoorToServer(String uuid, boolean isWidget) {
        return FlowLiveDataConversions.asLiveData$default(this.openSecondDoorUseCase.invoke(uuid, isWidget), null, 0L, 3, null);
    }

    public final void clearCamerasState() {
        AllCamerasViewState currentState = getCurrentState();
        AllCamerasViewState allCamerasViewStateCopy = currentState.copy((1048573 & 1) != 0 ? currentState.serverState : null, (1048573 & 2) != 0 ? currentState.allCamerasState : null, (1048573 & 4) != 0 ? currentState.widgetState : null, (1048573 & 8) != 0 ? currentState.exception : null, (1048573 & 16) != 0 ? currentState.mainCameras : CollectionsKt.emptyList(), (1048573 & 32) != 0 ? currentState.allCameras : null, (1048573 & 64) != 0 ? currentState.widgetCameras : null, (1048573 & 128) != 0 ? currentState.currentCamera : null, (1048573 & 256) != 0 ? currentState.currentIndex : 0, (1048573 & 512) != 0 ? currentState.singleCamera : null, (1048573 & 1024) != 0 ? currentState.isLoadingCamera : false, (1048573 & 2048) != 0 ? currentState.zoomMode : false, (1048573 & 4096) != 0 ? currentState.needUpdate : null, (1048573 & 8192) != 0 ? currentState.doorIsOpen : null, (1048573 & 16384) != 0 ? currentState.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.showBottomView : false, (1048573 & 131072) != 0 ? currentState.needReloadCameras : false, (1048573 & 262144) != 0 ? currentState.cameraToSelect : null, (1048573 & 524288) != 0 ? currentState.needReloadAllCameras : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(allCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(allCamerasViewStateCopy);
    }

    public void handleCamera(int position) {
        AllCamerasViewState allCamerasViewStateCopy;
        AllCamerasViewState currentState = getCurrentState();
        try {
            Camera camera = (Camera) CollectionsKt.getOrNull(currentState.getMainCameras(), position);
            if (camera != null) {
                camera.setSelected(true);
            }
            Unit unit = Unit.INSTANCE;
            allCamerasViewStateCopy = currentState.copy((1048573 & 1) != 0 ? currentState.serverState : null, (1048573 & 2) != 0 ? currentState.allCamerasState : null, (1048573 & 4) != 0 ? currentState.widgetState : null, (1048573 & 8) != 0 ? currentState.exception : null, (1048573 & 16) != 0 ? currentState.mainCameras : null, (1048573 & 32) != 0 ? currentState.allCameras : null, (1048573 & 64) != 0 ? currentState.widgetCameras : null, (1048573 & 128) != 0 ? currentState.currentCamera : camera, (1048573 & 256) != 0 ? currentState.currentIndex : position, (1048573 & 512) != 0 ? currentState.singleCamera : null, (1048573 & 1024) != 0 ? currentState.isLoadingCamera : false, (1048573 & 2048) != 0 ? currentState.zoomMode : false, (1048573 & 4096) != 0 ? currentState.needUpdate : null, (1048573 & 8192) != 0 ? currentState.doorIsOpen : null, (1048573 & 16384) != 0 ? currentState.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.showBottomView : false, (1048573 & 131072) != 0 ? currentState.needReloadCameras : false, (1048573 & 262144) != 0 ? currentState.cameraToSelect : null, (1048573 & 524288) != 0 ? currentState.needReloadAllCameras : false);
        } catch (Exception e) {
            allCamerasViewStateCopy = currentState.copy((1048573 & 1) != 0 ? currentState.serverState : Resource.Status.ERROR, (1048573 & 2) != 0 ? currentState.allCamerasState : null, (1048573 & 4) != 0 ? currentState.widgetState : null, (1048573 & 8) != 0 ? currentState.exception : e, (1048573 & 16) != 0 ? currentState.mainCameras : null, (1048573 & 32) != 0 ? currentState.allCameras : null, (1048573 & 64) != 0 ? currentState.widgetCameras : null, (1048573 & 128) != 0 ? currentState.currentCamera : null, (1048573 & 256) != 0 ? currentState.currentIndex : 0, (1048573 & 512) != 0 ? currentState.singleCamera : null, (1048573 & 1024) != 0 ? currentState.isLoadingCamera : false, (1048573 & 2048) != 0 ? currentState.zoomMode : false, (1048573 & 4096) != 0 ? currentState.needUpdate : null, (1048573 & 8192) != 0 ? currentState.doorIsOpen : null, (1048573 & 16384) != 0 ? currentState.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.showBottomView : false, (1048573 & 131072) != 0 ? currentState.needReloadCameras : false, (1048573 & 262144) != 0 ? currentState.cameraToSelect : null, (1048573 & 524288) != 0 ? currentState.needReloadAllCameras : false);
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(allCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(allCamerasViewStateCopy);
    }

    public void handleLoading(boolean isLoading) {
        AllCamerasViewState currentState = getCurrentState();
        AllCamerasViewState allCamerasViewStateCopy = currentState.copy((1048573 & 1) != 0 ? currentState.serverState : null, (1048573 & 2) != 0 ? currentState.allCamerasState : null, (1048573 & 4) != 0 ? currentState.widgetState : null, (1048573 & 8) != 0 ? currentState.exception : null, (1048573 & 16) != 0 ? currentState.mainCameras : null, (1048573 & 32) != 0 ? currentState.allCameras : null, (1048573 & 64) != 0 ? currentState.widgetCameras : null, (1048573 & 128) != 0 ? currentState.currentCamera : null, (1048573 & 256) != 0 ? currentState.currentIndex : 0, (1048573 & 512) != 0 ? currentState.singleCamera : null, (1048573 & 1024) != 0 ? currentState.isLoadingCamera : isLoading, (1048573 & 2048) != 0 ? currentState.zoomMode : false, (1048573 & 4096) != 0 ? currentState.needUpdate : null, (1048573 & 8192) != 0 ? currentState.doorIsOpen : null, (1048573 & 16384) != 0 ? currentState.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.showBottomView : false, (1048573 & 131072) != 0 ? currentState.needReloadCameras : false, (1048573 & 262144) != 0 ? currentState.cameraToSelect : null, (1048573 & 524288) != 0 ? currentState.needReloadAllCameras : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(allCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(allCamerasViewStateCopy);
    }

    public void handleNeedUpdate(boolean needUpdate) {
        AllCamerasViewState currentState = getCurrentState();
        AllCamerasViewState allCamerasViewStateCopy = currentState.copy((1048573 & 1) != 0 ? currentState.serverState : null, (1048573 & 2) != 0 ? currentState.allCamerasState : null, (1048573 & 4) != 0 ? currentState.widgetState : null, (1048573 & 8) != 0 ? currentState.exception : null, (1048573 & 16) != 0 ? currentState.mainCameras : null, (1048573 & 32) != 0 ? currentState.allCameras : null, (1048573 & 64) != 0 ? currentState.widgetCameras : null, (1048573 & 128) != 0 ? currentState.currentCamera : null, (1048573 & 256) != 0 ? currentState.currentIndex : 0, (1048573 & 512) != 0 ? currentState.singleCamera : null, (1048573 & 1024) != 0 ? currentState.isLoadingCamera : false, (1048573 & 2048) != 0 ? currentState.zoomMode : false, (1048573 & 4096) != 0 ? currentState.needUpdate : new Event(Boolean.valueOf(needUpdate)), (1048573 & 8192) != 0 ? currentState.doorIsOpen : null, (1048573 & 16384) != 0 ? currentState.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.showBottomView : false, (1048573 & 131072) != 0 ? currentState.needReloadCameras : false, (1048573 & 262144) != 0 ? currentState.cameraToSelect : null, (1048573 & 524288) != 0 ? currentState.needReloadAllCameras : true);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(allCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(allCamerasViewStateCopy);
    }

    public void handleZoomMode(boolean isZoomMode) {
        AllCamerasViewState currentState = getCurrentState();
        AllCamerasViewState allCamerasViewStateCopy = currentState.copy((1048573 & 1) != 0 ? currentState.serverState : null, (1048573 & 2) != 0 ? currentState.allCamerasState : null, (1048573 & 4) != 0 ? currentState.widgetState : null, (1048573 & 8) != 0 ? currentState.exception : null, (1048573 & 16) != 0 ? currentState.mainCameras : null, (1048573 & 32) != 0 ? currentState.allCameras : null, (1048573 & 64) != 0 ? currentState.widgetCameras : null, (1048573 & 128) != 0 ? currentState.currentCamera : null, (1048573 & 256) != 0 ? currentState.currentIndex : 0, (1048573 & 512) != 0 ? currentState.singleCamera : null, (1048573 & 1024) != 0 ? currentState.isLoadingCamera : false, (1048573 & 2048) != 0 ? currentState.zoomMode : isZoomMode, (1048573 & 4096) != 0 ? currentState.needUpdate : null, (1048573 & 8192) != 0 ? currentState.doorIsOpen : null, (1048573 & 16384) != 0 ? currentState.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.showBottomView : false, (1048573 & 131072) != 0 ? currentState.needReloadCameras : false, (1048573 & 262144) != 0 ? currentState.cameraToSelect : null, (1048573 & 524288) != 0 ? currentState.needReloadAllCameras : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(allCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(allCamerasViewStateCopy);
    }

    public void loadAllCameras() {
        AllCamerasViewState currentState = getCurrentState();
        AllCamerasViewState allCamerasViewStateCopy = currentState.copy((1048573 & 1) != 0 ? currentState.serverState : null, (1048573 & 2) != 0 ? currentState.allCamerasState : Resource.Status.LOADING, (1048573 & 4) != 0 ? currentState.widgetState : null, (1048573 & 8) != 0 ? currentState.exception : null, (1048573 & 16) != 0 ? currentState.mainCameras : null, (1048573 & 32) != 0 ? currentState.allCameras : null, (1048573 & 64) != 0 ? currentState.widgetCameras : null, (1048573 & 128) != 0 ? currentState.currentCamera : null, (1048573 & 256) != 0 ? currentState.currentIndex : 0, (1048573 & 512) != 0 ? currentState.singleCamera : null, (1048573 & 1024) != 0 ? currentState.isLoadingCamera : false, (1048573 & 2048) != 0 ? currentState.zoomMode : false, (1048573 & 4096) != 0 ? currentState.needUpdate : null, (1048573 & 8192) != 0 ? currentState.doorIsOpen : null, (1048573 & 16384) != 0 ? currentState.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.showBottomView : false, (1048573 & 131072) != 0 ? currentState.needReloadCameras : false, (1048573 & 262144) != 0 ? currentState.cameraToSelect : null, (1048573 & 524288) != 0 ? currentState.needReloadAllCameras : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(allCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(allCamerasViewStateCopy);
        subscribeOnDataSource(getCameras(CamerasFiltering$ListTypes.all.toString(), CamerasFiltering$OrderTypes.main_screen.toString()), new Function2<Resource<? extends List<? extends DomainCamera>>, AllCamerasViewState, AllCamerasViewState>() { // from class: com.sputnik.common.viewmodels.AllCamerasViewModel.loadAllCameras.2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ AllCamerasViewState invoke(Resource<? extends List<? extends DomainCamera>> resource, AllCamerasViewState allCamerasViewState) {
                return invoke2((Resource<? extends List<DomainCamera>>) resource, allCamerasViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final AllCamerasViewState invoke2(Resource<? extends List<DomainCamera>> camerasResponse, AllCamerasViewState state) {
                Intrinsics.checkNotNullParameter(camerasResponse, "camerasResponse");
                Intrinsics.checkNotNullParameter(state, "state");
                Resource.Status status = camerasResponse.getStatus();
                Resource.Status status2 = Resource.Status.LOADING;
                if (status == status2) {
                    return state.copy((1048573 & 1) != 0 ? state.serverState : null, (1048573 & 2) != 0 ? state.allCamerasState : status2, (1048573 & 4) != 0 ? state.widgetState : null, (1048573 & 8) != 0 ? state.exception : null, (1048573 & 16) != 0 ? state.mainCameras : null, (1048573 & 32) != 0 ? state.allCameras : null, (1048573 & 64) != 0 ? state.widgetCameras : null, (1048573 & 128) != 0 ? state.currentCamera : null, (1048573 & 256) != 0 ? state.currentIndex : 0, (1048573 & 512) != 0 ? state.singleCamera : null, (1048573 & 1024) != 0 ? state.isLoadingCamera : false, (1048573 & 2048) != 0 ? state.zoomMode : false, (1048573 & 4096) != 0 ? state.needUpdate : null, (1048573 & 8192) != 0 ? state.doorIsOpen : null, (1048573 & 16384) != 0 ? state.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.showBottomView : false, (1048573 & 131072) != 0 ? state.needReloadCameras : false, (1048573 & 262144) != 0 ? state.cameraToSelect : null, (1048573 & 524288) != 0 ? state.needReloadAllCameras : false);
                }
                Resource.Status status3 = camerasResponse.getStatus();
                Resource.Status status4 = Resource.Status.ERROR;
                if (status3 == status4) {
                    Exception error = camerasResponse.getError();
                    Intrinsics.checkNotNull(error);
                    return state.copy((1048573 & 1) != 0 ? state.serverState : null, (1048573 & 2) != 0 ? state.allCamerasState : status4, (1048573 & 4) != 0 ? state.widgetState : null, (1048573 & 8) != 0 ? state.exception : error, (1048573 & 16) != 0 ? state.mainCameras : null, (1048573 & 32) != 0 ? state.allCameras : null, (1048573 & 64) != 0 ? state.widgetCameras : null, (1048573 & 128) != 0 ? state.currentCamera : null, (1048573 & 256) != 0 ? state.currentIndex : 0, (1048573 & 512) != 0 ? state.singleCamera : null, (1048573 & 1024) != 0 ? state.isLoadingCamera : false, (1048573 & 2048) != 0 ? state.zoomMode : false, (1048573 & 4096) != 0 ? state.needUpdate : null, (1048573 & 8192) != 0 ? state.doorIsOpen : null, (1048573 & 16384) != 0 ? state.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.showBottomView : false, (1048573 & 131072) != 0 ? state.needReloadCameras : false, (1048573 & 262144) != 0 ? state.cameraToSelect : null, (1048573 & 524288) != 0 ? state.needReloadAllCameras : false);
                }
                Resource.Status status5 = Resource.Status.SUCCESS;
                List<DomainCamera> data = camerasResponse.getData();
                Intrinsics.checkNotNull(data);
                return state.copy((1048573 & 1) != 0 ? state.serverState : null, (1048573 & 2) != 0 ? state.allCamerasState : status5, (1048573 & 4) != 0 ? state.widgetState : null, (1048573 & 8) != 0 ? state.exception : null, (1048573 & 16) != 0 ? state.mainCameras : null, (1048573 & 32) != 0 ? state.allCameras : CollectionsKt.sortedWith(AllCamerasViewModel.this.listMapper.map(data), new Comparator() { // from class: com.sputnik.common.viewmodels.AllCamerasViewModel$loadAllCameras$2$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((Camera) t).getOrder(), ((Camera) t2).getOrder());
                    }
                }), (1048573 & 64) != 0 ? state.widgetCameras : null, (1048573 & 128) != 0 ? state.currentCamera : null, (1048573 & 256) != 0 ? state.currentIndex : 0, (1048573 & 512) != 0 ? state.singleCamera : null, (1048573 & 1024) != 0 ? state.isLoadingCamera : false, (1048573 & 2048) != 0 ? state.zoomMode : false, (1048573 & 4096) != 0 ? state.needUpdate : null, (1048573 & 8192) != 0 ? state.doorIsOpen : null, (1048573 & 16384) != 0 ? state.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.showBottomView : false, (1048573 & 131072) != 0 ? state.needReloadCameras : false, (1048573 & 262144) != 0 ? state.cameraToSelect : null, (1048573 & 524288) != 0 ? state.needReloadAllCameras : false);
            }
        });
        AllCamerasViewState currentState2 = getCurrentState();
        AllCamerasViewState allCamerasViewStateCopy2 = currentState2.copy((1048573 & 1) != 0 ? currentState2.serverState : null, (1048573 & 2) != 0 ? currentState2.allCamerasState : null, (1048573 & 4) != 0 ? currentState2.widgetState : null, (1048573 & 8) != 0 ? currentState2.exception : null, (1048573 & 16) != 0 ? currentState2.mainCameras : null, (1048573 & 32) != 0 ? currentState2.allCameras : null, (1048573 & 64) != 0 ? currentState2.widgetCameras : null, (1048573 & 128) != 0 ? currentState2.currentCamera : null, (1048573 & 256) != 0 ? currentState2.currentIndex : 0, (1048573 & 512) != 0 ? currentState2.singleCamera : null, (1048573 & 1024) != 0 ? currentState2.isLoadingCamera : false, (1048573 & 2048) != 0 ? currentState2.zoomMode : false, (1048573 & 4096) != 0 ? currentState2.needUpdate : null, (1048573 & 8192) != 0 ? currentState2.doorIsOpen : null, (1048573 & 16384) != 0 ? currentState2.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState2.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState2.showBottomView : false, (1048573 & 131072) != 0 ? currentState2.needReloadCameras : false, (1048573 & 262144) != 0 ? currentState2.cameraToSelect : null, (1048573 & 524288) != 0 ? currentState2.needReloadAllCameras : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(allCamerasViewStateCopy2, this, null), 3, null);
        getState().setValue(allCamerasViewStateCopy2);
    }

    public void loadDemoCameras() {
        AllCamerasViewState currentState = getCurrentState();
        AllCamerasViewState allCamerasViewStateCopy = currentState.copy((1048573 & 1) != 0 ? currentState.serverState : Resource.Status.LOADING, (1048573 & 2) != 0 ? currentState.allCamerasState : null, (1048573 & 4) != 0 ? currentState.widgetState : null, (1048573 & 8) != 0 ? currentState.exception : null, (1048573 & 16) != 0 ? currentState.mainCameras : null, (1048573 & 32) != 0 ? currentState.allCameras : null, (1048573 & 64) != 0 ? currentState.widgetCameras : null, (1048573 & 128) != 0 ? currentState.currentCamera : null, (1048573 & 256) != 0 ? currentState.currentIndex : 0, (1048573 & 512) != 0 ? currentState.singleCamera : null, (1048573 & 1024) != 0 ? currentState.isLoadingCamera : false, (1048573 & 2048) != 0 ? currentState.zoomMode : false, (1048573 & 4096) != 0 ? currentState.needUpdate : null, (1048573 & 8192) != 0 ? currentState.doorIsOpen : null, (1048573 & 16384) != 0 ? currentState.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.showBottomView : false, (1048573 & 131072) != 0 ? currentState.needReloadCameras : false, (1048573 & 262144) != 0 ? currentState.cameraToSelect : null, (1048573 & 524288) != 0 ? currentState.needReloadAllCameras : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(allCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(allCamerasViewStateCopy);
        subscribeOnDataSource(getDemoCameras(), new Function2<Resource<? extends List<? extends DomainCamera>>, AllCamerasViewState, AllCamerasViewState>() { // from class: com.sputnik.common.viewmodels.AllCamerasViewModel.loadDemoCameras.2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ AllCamerasViewState invoke(Resource<? extends List<? extends DomainCamera>> resource, AllCamerasViewState allCamerasViewState) {
                return invoke2((Resource<? extends List<DomainCamera>>) resource, allCamerasViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final AllCamerasViewState invoke2(Resource<? extends List<DomainCamera>> camerasResponse, AllCamerasViewState state) {
                Intrinsics.checkNotNullParameter(camerasResponse, "camerasResponse");
                Intrinsics.checkNotNullParameter(state, "state");
                Resource.Status status = camerasResponse.getStatus();
                Resource.Status status2 = Resource.Status.LOADING;
                if (status == status2) {
                    return state.copy((1048573 & 1) != 0 ? state.serverState : status2, (1048573 & 2) != 0 ? state.allCamerasState : null, (1048573 & 4) != 0 ? state.widgetState : null, (1048573 & 8) != 0 ? state.exception : null, (1048573 & 16) != 0 ? state.mainCameras : null, (1048573 & 32) != 0 ? state.allCameras : null, (1048573 & 64) != 0 ? state.widgetCameras : null, (1048573 & 128) != 0 ? state.currentCamera : null, (1048573 & 256) != 0 ? state.currentIndex : 0, (1048573 & 512) != 0 ? state.singleCamera : null, (1048573 & 1024) != 0 ? state.isLoadingCamera : false, (1048573 & 2048) != 0 ? state.zoomMode : false, (1048573 & 4096) != 0 ? state.needUpdate : null, (1048573 & 8192) != 0 ? state.doorIsOpen : null, (1048573 & 16384) != 0 ? state.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.showBottomView : false, (1048573 & 131072) != 0 ? state.needReloadCameras : false, (1048573 & 262144) != 0 ? state.cameraToSelect : null, (1048573 & 524288) != 0 ? state.needReloadAllCameras : false);
                }
                Resource.Status status3 = camerasResponse.getStatus();
                Resource.Status status4 = Resource.Status.ERROR;
                if (status3 == status4) {
                    Exception error = camerasResponse.getError();
                    Intrinsics.checkNotNull(error);
                    return state.copy((1048573 & 1) != 0 ? state.serverState : status4, (1048573 & 2) != 0 ? state.allCamerasState : null, (1048573 & 4) != 0 ? state.widgetState : null, (1048573 & 8) != 0 ? state.exception : error, (1048573 & 16) != 0 ? state.mainCameras : null, (1048573 & 32) != 0 ? state.allCameras : null, (1048573 & 64) != 0 ? state.widgetCameras : null, (1048573 & 128) != 0 ? state.currentCamera : null, (1048573 & 256) != 0 ? state.currentIndex : 0, (1048573 & 512) != 0 ? state.singleCamera : null, (1048573 & 1024) != 0 ? state.isLoadingCamera : false, (1048573 & 2048) != 0 ? state.zoomMode : false, (1048573 & 4096) != 0 ? state.needUpdate : null, (1048573 & 8192) != 0 ? state.doorIsOpen : null, (1048573 & 16384) != 0 ? state.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.showBottomView : false, (1048573 & 131072) != 0 ? state.needReloadCameras : false, (1048573 & 262144) != 0 ? state.cameraToSelect : null, (1048573 & 524288) != 0 ? state.needReloadAllCameras : false);
                }
                Resource.Status status5 = Resource.Status.SUCCESS;
                Event event = new Event(Boolean.FALSE);
                List<DomainCamera> data = camerasResponse.getData();
                Intrinsics.checkNotNull(data);
                List listSortedWith = CollectionsKt.sortedWith(AllCamerasViewModel.this.listMapper.map(data), new Comparator() { // from class: com.sputnik.common.viewmodels.AllCamerasViewModel$loadDemoCameras$2$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((Camera) t).getOrder(), ((Camera) t2).getOrder());
                    }
                });
                List<DomainCamera> data2 = camerasResponse.getData();
                Intrinsics.checkNotNull(data2);
                DomainCamera domainCamera = (DomainCamera) CollectionsKt.getOrNull(data2, state.getCurrentIndex());
                return state.copy((1048573 & 1) != 0 ? state.serverState : status5, (1048573 & 2) != 0 ? state.allCamerasState : null, (1048573 & 4) != 0 ? state.widgetState : null, (1048573 & 8) != 0 ? state.exception : null, (1048573 & 16) != 0 ? state.mainCameras : listSortedWith, (1048573 & 32) != 0 ? state.allCameras : null, (1048573 & 64) != 0 ? state.widgetCameras : null, (1048573 & 128) != 0 ? state.currentCamera : domainCamera != null ? AllCamerasViewModel.this.domainCameraToCameraMapper.map(domainCamera) : null, (1048573 & 256) != 0 ? state.currentIndex : 0, (1048573 & 512) != 0 ? state.singleCamera : null, (1048573 & 1024) != 0 ? state.isLoadingCamera : false, (1048573 & 2048) != 0 ? state.zoomMode : false, (1048573 & 4096) != 0 ? state.needUpdate : event, (1048573 & 8192) != 0 ? state.doorIsOpen : null, (1048573 & 16384) != 0 ? state.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.showBottomView : false, (1048573 & 131072) != 0 ? state.needReloadCameras : false, (1048573 & 262144) != 0 ? state.cameraToSelect : null, (1048573 & 524288) != 0 ? state.needReloadAllCameras : false);
            }
        });
        AllCamerasViewState currentState2 = getCurrentState();
        AllCamerasViewState allCamerasViewStateCopy2 = currentState2.copy((1048573 & 1) != 0 ? currentState2.serverState : null, (1048573 & 2) != 0 ? currentState2.allCamerasState : null, (1048573 & 4) != 0 ? currentState2.widgetState : null, (1048573 & 8) != 0 ? currentState2.exception : null, (1048573 & 16) != 0 ? currentState2.mainCameras : null, (1048573 & 32) != 0 ? currentState2.allCameras : null, (1048573 & 64) != 0 ? currentState2.widgetCameras : null, (1048573 & 128) != 0 ? currentState2.currentCamera : null, (1048573 & 256) != 0 ? currentState2.currentIndex : 0, (1048573 & 512) != 0 ? currentState2.singleCamera : null, (1048573 & 1024) != 0 ? currentState2.isLoadingCamera : false, (1048573 & 2048) != 0 ? currentState2.zoomMode : false, (1048573 & 4096) != 0 ? currentState2.needUpdate : new Event(Boolean.FALSE), (1048573 & 8192) != 0 ? currentState2.doorIsOpen : null, (1048573 & 16384) != 0 ? currentState2.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState2.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState2.showBottomView : false, (1048573 & 131072) != 0 ? currentState2.needReloadCameras : false, (1048573 & 262144) != 0 ? currentState2.cameraToSelect : null, (1048573 & 524288) != 0 ? currentState2.needReloadAllCameras : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(allCamerasViewStateCopy2, this, null), 3, null);
        getState().setValue(allCamerasViewStateCopy2);
    }

    public void loadWidgetCameras() {
        AllCamerasViewState currentState = getCurrentState();
        AllCamerasViewState allCamerasViewStateCopy = currentState.copy((1048573 & 1) != 0 ? currentState.serverState : null, (1048573 & 2) != 0 ? currentState.allCamerasState : null, (1048573 & 4) != 0 ? currentState.widgetState : Resource.Status.LOADING, (1048573 & 8) != 0 ? currentState.exception : null, (1048573 & 16) != 0 ? currentState.mainCameras : null, (1048573 & 32) != 0 ? currentState.allCameras : null, (1048573 & 64) != 0 ? currentState.widgetCameras : null, (1048573 & 128) != 0 ? currentState.currentCamera : null, (1048573 & 256) != 0 ? currentState.currentIndex : 0, (1048573 & 512) != 0 ? currentState.singleCamera : null, (1048573 & 1024) != 0 ? currentState.isLoadingCamera : false, (1048573 & 2048) != 0 ? currentState.zoomMode : false, (1048573 & 4096) != 0 ? currentState.needUpdate : null, (1048573 & 8192) != 0 ? currentState.doorIsOpen : null, (1048573 & 16384) != 0 ? currentState.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.showBottomView : false, (1048573 & 131072) != 0 ? currentState.needReloadCameras : false, (1048573 & 262144) != 0 ? currentState.cameraToSelect : null, (1048573 & 524288) != 0 ? currentState.needReloadAllCameras : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(allCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(allCamerasViewStateCopy);
        subscribeOnDataSource(getCameras(CamerasFiltering$ListTypes.widget.toString(), CamerasFiltering$OrderTypes.widget.toString()), new Function2<Resource<? extends List<? extends DomainCamera>>, AllCamerasViewState, AllCamerasViewState>() { // from class: com.sputnik.common.viewmodels.AllCamerasViewModel.loadWidgetCameras.2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ AllCamerasViewState invoke(Resource<? extends List<? extends DomainCamera>> resource, AllCamerasViewState allCamerasViewState) {
                return invoke2((Resource<? extends List<DomainCamera>>) resource, allCamerasViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final AllCamerasViewState invoke2(Resource<? extends List<DomainCamera>> camerasResponse, AllCamerasViewState state) {
                Intrinsics.checkNotNullParameter(camerasResponse, "camerasResponse");
                Intrinsics.checkNotNullParameter(state, "state");
                Resource.Status status = camerasResponse.getStatus();
                Resource.Status status2 = Resource.Status.LOADING;
                if (status == status2) {
                    return state.copy((1048573 & 1) != 0 ? state.serverState : null, (1048573 & 2) != 0 ? state.allCamerasState : null, (1048573 & 4) != 0 ? state.widgetState : status2, (1048573 & 8) != 0 ? state.exception : null, (1048573 & 16) != 0 ? state.mainCameras : null, (1048573 & 32) != 0 ? state.allCameras : null, (1048573 & 64) != 0 ? state.widgetCameras : null, (1048573 & 128) != 0 ? state.currentCamera : null, (1048573 & 256) != 0 ? state.currentIndex : 0, (1048573 & 512) != 0 ? state.singleCamera : null, (1048573 & 1024) != 0 ? state.isLoadingCamera : false, (1048573 & 2048) != 0 ? state.zoomMode : false, (1048573 & 4096) != 0 ? state.needUpdate : null, (1048573 & 8192) != 0 ? state.doorIsOpen : null, (1048573 & 16384) != 0 ? state.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.showBottomView : false, (1048573 & 131072) != 0 ? state.needReloadCameras : false, (1048573 & 262144) != 0 ? state.cameraToSelect : null, (1048573 & 524288) != 0 ? state.needReloadAllCameras : false);
                }
                Resource.Status status3 = camerasResponse.getStatus();
                Resource.Status status4 = Resource.Status.ERROR;
                if (status3 == status4) {
                    Exception error = camerasResponse.getError();
                    Intrinsics.checkNotNull(error);
                    return state.copy((1048573 & 1) != 0 ? state.serverState : null, (1048573 & 2) != 0 ? state.allCamerasState : null, (1048573 & 4) != 0 ? state.widgetState : status4, (1048573 & 8) != 0 ? state.exception : error, (1048573 & 16) != 0 ? state.mainCameras : null, (1048573 & 32) != 0 ? state.allCameras : null, (1048573 & 64) != 0 ? state.widgetCameras : null, (1048573 & 128) != 0 ? state.currentCamera : null, (1048573 & 256) != 0 ? state.currentIndex : 0, (1048573 & 512) != 0 ? state.singleCamera : null, (1048573 & 1024) != 0 ? state.isLoadingCamera : false, (1048573 & 2048) != 0 ? state.zoomMode : false, (1048573 & 4096) != 0 ? state.needUpdate : null, (1048573 & 8192) != 0 ? state.doorIsOpen : null, (1048573 & 16384) != 0 ? state.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.showBottomView : false, (1048573 & 131072) != 0 ? state.needReloadCameras : false, (1048573 & 262144) != 0 ? state.cameraToSelect : null, (1048573 & 524288) != 0 ? state.needReloadAllCameras : false);
                }
                Resource.Status status5 = Resource.Status.SUCCESS;
                List<DomainCamera> data = camerasResponse.getData();
                Intrinsics.checkNotNull(data);
                return state.copy((1048573 & 1) != 0 ? state.serverState : null, (1048573 & 2) != 0 ? state.allCamerasState : null, (1048573 & 4) != 0 ? state.widgetState : status5, (1048573 & 8) != 0 ? state.exception : null, (1048573 & 16) != 0 ? state.mainCameras : null, (1048573 & 32) != 0 ? state.allCameras : null, (1048573 & 64) != 0 ? state.widgetCameras : CollectionsKt.sortedWith(AllCamerasViewModel.this.listMapper.map(data), new Comparator() { // from class: com.sputnik.common.viewmodels.AllCamerasViewModel$loadWidgetCameras$2$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((Camera) t).getOrder(), ((Camera) t2).getOrder());
                    }
                }), (1048573 & 128) != 0 ? state.currentCamera : null, (1048573 & 256) != 0 ? state.currentIndex : 0, (1048573 & 512) != 0 ? state.singleCamera : null, (1048573 & 1024) != 0 ? state.isLoadingCamera : false, (1048573 & 2048) != 0 ? state.zoomMode : false, (1048573 & 4096) != 0 ? state.needUpdate : null, (1048573 & 8192) != 0 ? state.doorIsOpen : null, (1048573 & 16384) != 0 ? state.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.showBottomView : false, (1048573 & 131072) != 0 ? state.needReloadCameras : false, (1048573 & 262144) != 0 ? state.cameraToSelect : null, (1048573 & 524288) != 0 ? state.needReloadAllCameras : false);
            }
        });
    }

    public final void logout() {
        getCurrentState();
        AllCamerasViewState allCamerasViewState = new AllCamerasViewState(null, null, null, null, null, null, null, null, 0, null, false, false, null, null, null, null, false, false, null, false, 1048575, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(allCamerasViewState, this, null), 3, null);
        getState().setValue(allCamerasViewState);
    }

    @Override // com.sputnik.common.viewmodels.interfaces.ICamerasViewModel
    public void openDoor(String uuid, String flatUUID) {
        String str;
        Object next;
        Integer id;
        AllCamerasViewState currentState = getCurrentState();
        AllCamerasViewState allCamerasViewStateCopy = currentState.copy((1048573 & 1) != 0 ? currentState.serverState : null, (1048573 & 2) != 0 ? currentState.allCamerasState : null, (1048573 & 4) != 0 ? currentState.widgetState : null, (1048573 & 8) != 0 ? currentState.exception : null, (1048573 & 16) != 0 ? currentState.mainCameras : null, (1048573 & 32) != 0 ? currentState.allCameras : null, (1048573 & 64) != 0 ? currentState.widgetCameras : null, (1048573 & 128) != 0 ? currentState.currentCamera : null, (1048573 & 256) != 0 ? currentState.currentIndex : 0, (1048573 & 512) != 0 ? currentState.singleCamera : null, (1048573 & 1024) != 0 ? currentState.isLoadingCamera : false, (1048573 & 2048) != 0 ? currentState.zoomMode : false, (1048573 & 4096) != 0 ? currentState.needUpdate : null, (1048573 & 8192) != 0 ? currentState.doorIsOpen : null, (1048573 & 16384) != 0 ? currentState.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.showBottomView : false, (1048573 & 131072) != 0 ? currentState.needReloadCameras : false, (1048573 & 262144) != 0 ? currentState.cameraToSelect : null, (1048573 & 524288) != 0 ? currentState.needReloadAllCameras : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(allCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(allCamerasViewStateCopy);
        Camera currentCamera = getCurrentState().getCurrentCamera();
        if ((currentCamera != null ? currentCamera.getIntercomUuid() : null) != null || uuid != null) {
            if (uuid == null) {
                Camera currentCamera2 = getCurrentState().getCurrentCamera();
                String intercomUuid = currentCamera2 != null ? currentCamera2.getIntercomUuid() : null;
                Intrinsics.checkNotNull(intercomUuid);
                str = intercomUuid;
            } else {
                str = uuid;
            }
            Iterator<T> it = this.prefManager.getCurrentAddresses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((LoginState.Session.Address) next).getFlatUUID(), flatUUID)) {
                        break;
                    }
                }
            }
            LoginState.Session.Address address = (LoginState.Session.Address) next;
            subscribeOnDataSource(openDoorToServer$default(this, str, false, (address == null || (id = address.getId()) == null) ? null : StringUtilsKt.orNull(id), 2, null), new Function2<Resource<? extends Unit>, AllCamerasViewState, AllCamerasViewState>() { // from class: com.sputnik.common.viewmodels.AllCamerasViewModel.openDoor.3

                /* compiled from: AllCamerasViewModel.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                /* renamed from: com.sputnik.common.viewmodels.AllCamerasViewModel$openDoor$3$WhenMappings */
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
                public /* bridge */ /* synthetic */ AllCamerasViewState invoke(Resource<? extends Unit> resource, AllCamerasViewState allCamerasViewState) {
                    return invoke2((Resource<Unit>) resource, allCamerasViewState);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final AllCamerasViewState invoke2(Resource<Unit> serverData, AllCamerasViewState state) {
                    Intrinsics.checkNotNullParameter(serverData, "serverData");
                    Intrinsics.checkNotNullParameter(state, "state");
                    int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                    if (i == 1 || i == 2) {
                        return null;
                    }
                    if (i != 3) {
                        if (i == 4) {
                            return state.copy((1048573 & 1) != 0 ? state.serverState : null, (1048573 & 2) != 0 ? state.allCamerasState : null, (1048573 & 4) != 0 ? state.widgetState : null, (1048573 & 8) != 0 ? state.exception : null, (1048573 & 16) != 0 ? state.mainCameras : null, (1048573 & 32) != 0 ? state.allCameras : null, (1048573 & 64) != 0 ? state.widgetCameras : null, (1048573 & 128) != 0 ? state.currentCamera : null, (1048573 & 256) != 0 ? state.currentIndex : 0, (1048573 & 512) != 0 ? state.singleCamera : null, (1048573 & 1024) != 0 ? state.isLoadingCamera : false, (1048573 & 2048) != 0 ? state.zoomMode : false, (1048573 & 4096) != 0 ? state.needUpdate : null, (1048573 & 8192) != 0 ? state.doorIsOpen : new Event(Boolean.TRUE), (1048573 & 16384) != 0 ? state.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.showBottomView : false, (1048573 & 131072) != 0 ? state.needReloadCameras : false, (1048573 & 262144) != 0 ? state.cameraToSelect : null, (1048573 & 524288) != 0 ? state.needReloadAllCameras : false);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    String str2 = AllCamerasViewModel.this.failureTitle;
                    if (str2 != null) {
                        AllCamerasViewModel allCamerasViewModel = AllCamerasViewModel.this;
                        DomainEmpty errorMsg = serverData.getErrorMsg();
                        if ((errorMsg != null ? errorMsg.getEmergencyCode() : null) == null) {
                            allCamerasViewModel.notifyErrorMessage(str2);
                        }
                    }
                    Event event = new Event(Boolean.FALSE);
                    Exception error = serverData.getError();
                    DomainEmpty errorMsg2 = serverData.getErrorMsg();
                    return state.copy((1048573 & 1) != 0 ? state.serverState : null, (1048573 & 2) != 0 ? state.allCamerasState : null, (1048573 & 4) != 0 ? state.widgetState : null, (1048573 & 8) != 0 ? state.exception : error, (1048573 & 16) != 0 ? state.mainCameras : null, (1048573 & 32) != 0 ? state.allCameras : null, (1048573 & 64) != 0 ? state.widgetCameras : null, (1048573 & 128) != 0 ? state.currentCamera : null, (1048573 & 256) != 0 ? state.currentIndex : 0, (1048573 & 512) != 0 ? state.singleCamera : null, (1048573 & 1024) != 0 ? state.isLoadingCamera : false, (1048573 & 2048) != 0 ? state.zoomMode : false, (1048573 & 4096) != 0 ? state.needUpdate : null, (1048573 & 8192) != 0 ? state.doorIsOpen : event, (1048573 & 16384) != 0 ? state.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.emergencyCode : errorMsg2 != null ? errorMsg2.getEmergencyCode() : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.showBottomView : false, (1048573 & 131072) != 0 ? state.needReloadCameras : false, (1048573 & 262144) != 0 ? state.cameraToSelect : null, (1048573 & 524288) != 0 ? state.needReloadAllCameras : false);
                }
            });
            return;
        }
        loadMainCameras();
    }

    public void openSecondDoor() {
        AllCamerasViewState currentState = getCurrentState();
        AllCamerasViewState allCamerasViewStateCopy = currentState.copy((1048573 & 1) != 0 ? currentState.serverState : null, (1048573 & 2) != 0 ? currentState.allCamerasState : null, (1048573 & 4) != 0 ? currentState.widgetState : null, (1048573 & 8) != 0 ? currentState.exception : null, (1048573 & 16) != 0 ? currentState.mainCameras : null, (1048573 & 32) != 0 ? currentState.allCameras : null, (1048573 & 64) != 0 ? currentState.widgetCameras : null, (1048573 & 128) != 0 ? currentState.currentCamera : null, (1048573 & 256) != 0 ? currentState.currentIndex : 0, (1048573 & 512) != 0 ? currentState.singleCamera : null, (1048573 & 1024) != 0 ? currentState.isLoadingCamera : false, (1048573 & 2048) != 0 ? currentState.zoomMode : false, (1048573 & 4096) != 0 ? currentState.needUpdate : null, (1048573 & 8192) != 0 ? currentState.doorIsOpen : null, (1048573 & 16384) != 0 ? currentState.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.showBottomView : false, (1048573 & 131072) != 0 ? currentState.needReloadCameras : false, (1048573 & 262144) != 0 ? currentState.cameraToSelect : null, (1048573 & 524288) != 0 ? currentState.needReloadAllCameras : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(allCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(allCamerasViewStateCopy);
        Camera currentCamera = getCurrentState().getCurrentCamera();
        if ((currentCamera != null ? currentCamera.getIntercomUuid() : null) != null) {
            Camera currentCamera2 = getCurrentState().getCurrentCamera();
            String intercomUuid = currentCamera2 != null ? currentCamera2.getIntercomUuid() : null;
            Intrinsics.checkNotNull(intercomUuid);
            subscribeOnDataSource(openSecondDoorToServer$default(this, intercomUuid, false, 2, null), new Function2<Resource<? extends Unit>, AllCamerasViewState, AllCamerasViewState>() { // from class: com.sputnik.common.viewmodels.AllCamerasViewModel.openSecondDoor.2

                /* compiled from: AllCamerasViewModel.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                /* renamed from: com.sputnik.common.viewmodels.AllCamerasViewModel$openSecondDoor$2$WhenMappings */
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
                public /* bridge */ /* synthetic */ AllCamerasViewState invoke(Resource<? extends Unit> resource, AllCamerasViewState allCamerasViewState) {
                    return invoke2((Resource<Unit>) resource, allCamerasViewState);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final AllCamerasViewState invoke2(Resource<Unit> serverData, AllCamerasViewState state) {
                    Intrinsics.checkNotNullParameter(serverData, "serverData");
                    Intrinsics.checkNotNullParameter(state, "state");
                    int i = WhenMappings.$EnumSwitchMapping$0[serverData.getStatus().ordinal()];
                    if (i == 1 || i == 2) {
                        return null;
                    }
                    if (i != 3) {
                        if (i == 4) {
                            return state.copy((1048573 & 1) != 0 ? state.serverState : null, (1048573 & 2) != 0 ? state.allCamerasState : null, (1048573 & 4) != 0 ? state.widgetState : null, (1048573 & 8) != 0 ? state.exception : null, (1048573 & 16) != 0 ? state.mainCameras : null, (1048573 & 32) != 0 ? state.allCameras : null, (1048573 & 64) != 0 ? state.widgetCameras : null, (1048573 & 128) != 0 ? state.currentCamera : null, (1048573 & 256) != 0 ? state.currentIndex : 0, (1048573 & 512) != 0 ? state.singleCamera : null, (1048573 & 1024) != 0 ? state.isLoadingCamera : false, (1048573 & 2048) != 0 ? state.zoomMode : false, (1048573 & 4096) != 0 ? state.needUpdate : null, (1048573 & 8192) != 0 ? state.doorIsOpen : new Event(Boolean.TRUE), (1048573 & 16384) != 0 ? state.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.showBottomView : false, (1048573 & 131072) != 0 ? state.needReloadCameras : false, (1048573 & 262144) != 0 ? state.cameraToSelect : null, (1048573 & 524288) != 0 ? state.needReloadAllCameras : false);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    String unused = AllCamerasViewModel.this.failureTitle;
                    Event event = new Event(Boolean.FALSE);
                    Exception error = serverData.getError();
                    DomainEmpty errorMsg = serverData.getErrorMsg();
                    return state.copy((1048573 & 1) != 0 ? state.serverState : null, (1048573 & 2) != 0 ? state.allCamerasState : null, (1048573 & 4) != 0 ? state.widgetState : null, (1048573 & 8) != 0 ? state.exception : error, (1048573 & 16) != 0 ? state.mainCameras : null, (1048573 & 32) != 0 ? state.allCameras : null, (1048573 & 64) != 0 ? state.widgetCameras : null, (1048573 & 128) != 0 ? state.currentCamera : null, (1048573 & 256) != 0 ? state.currentIndex : 0, (1048573 & 512) != 0 ? state.singleCamera : null, (1048573 & 1024) != 0 ? state.isLoadingCamera : false, (1048573 & 2048) != 0 ? state.zoomMode : false, (1048573 & 4096) != 0 ? state.needUpdate : null, (1048573 & 8192) != 0 ? state.doorIsOpen : event, (1048573 & 16384) != 0 ? state.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.emergencyCode : errorMsg != null ? errorMsg.getEmergencyCode() : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.showBottomView : false, (1048573 & 131072) != 0 ? state.needReloadCameras : false, (1048573 & 262144) != 0 ? state.cameraToSelect : null, (1048573 & 524288) != 0 ? state.needReloadAllCameras : false);
                }
            });
            return;
        }
        loadMainCameras();
    }

    public final void setCurrentCameraLiveState(boolean isLive) {
        AllCamerasViewState currentState = getCurrentState();
        Camera currentCamera = currentState.getCurrentCamera();
        AllCamerasViewState allCamerasViewStateCopy = currentState.copy((1048573 & 1) != 0 ? currentState.serverState : null, (1048573 & 2) != 0 ? currentState.allCamerasState : null, (1048573 & 4) != 0 ? currentState.widgetState : null, (1048573 & 8) != 0 ? currentState.exception : null, (1048573 & 16) != 0 ? currentState.mainCameras : null, (1048573 & 32) != 0 ? currentState.allCameras : null, (1048573 & 64) != 0 ? currentState.widgetCameras : null, (1048573 & 128) != 0 ? currentState.currentCamera : currentCamera != null ? currentCamera.copy((3145727 & 1) != 0 ? currentCamera.uuid : null, (3145727 & 2) != 0 ? currentCamera.streamUrl : null, (3145727 & 4) != 0 ? currentCamera.previewUrl : null, (3145727 & 8) != 0 ? currentCamera.isIntercom : false, (3145727 & 16) != 0 ? currentCamera.intercomUuid : null, (3145727 & 32) != 0 ? currentCamera.intercomSerial : null, (3145727 & 64) != 0 ? currentCamera.width : 0, (3145727 & 128) != 0 ? currentCamera.height : 0, (3145727 & 256) != 0 ? currentCamera.title : null, (3145727 & 512) != 0 ? currentCamera.order : null, (3145727 & 1024) != 0 ? currentCamera.widget : false, (3145727 & 2048) != 0 ? currentCamera.address : null, (3145727 & 4096) != 0 ? currentCamera.isLoadPhotoFailed : false, (3145727 & 8192) != 0 ? currentCamera.isLoadVideoFailed : false, (3145727 & 16384) != 0 ? currentCamera.transitionName : null, (3145727 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentCamera.flussonicData : null, (3145727 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentCamera.extraKeyReader : null, (3145727 & 131072) != 0 ? currentCamera.mainScreen : false, (3145727 & 262144) != 0 ? currentCamera.subscriptionRequried : null, (3145727 & 524288) != 0 ? currentCamera.canOpen : null, (3145727 & 1048576) != 0 ? currentCamera.isLive : isLive, (3145727 & 2097152) != 0 ? currentCamera.isSelected : false) : null, (1048573 & 256) != 0 ? currentState.currentIndex : 0, (1048573 & 512) != 0 ? currentState.singleCamera : null, (1048573 & 1024) != 0 ? currentState.isLoadingCamera : false, (1048573 & 2048) != 0 ? currentState.zoomMode : false, (1048573 & 4096) != 0 ? currentState.needUpdate : null, (1048573 & 8192) != 0 ? currentState.doorIsOpen : null, (1048573 & 16384) != 0 ? currentState.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.showBottomView : false, (1048573 & 131072) != 0 ? currentState.needReloadCameras : false, (1048573 & 262144) != 0 ? currentState.cameraToSelect : null, (1048573 & 524288) != 0 ? currentState.needReloadAllCameras : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(allCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(allCamerasViewStateCopy);
    }

    public void setNeedLoadCameras(boolean value) {
        AllCamerasViewState currentState = getCurrentState();
        AllCamerasViewState allCamerasViewStateCopy = currentState.copy((1048573 & 1) != 0 ? currentState.serverState : null, (1048573 & 2) != 0 ? currentState.allCamerasState : null, (1048573 & 4) != 0 ? currentState.widgetState : null, (1048573 & 8) != 0 ? currentState.exception : null, (1048573 & 16) != 0 ? currentState.mainCameras : null, (1048573 & 32) != 0 ? currentState.allCameras : null, (1048573 & 64) != 0 ? currentState.widgetCameras : null, (1048573 & 128) != 0 ? currentState.currentCamera : null, (1048573 & 256) != 0 ? currentState.currentIndex : 0, (1048573 & 512) != 0 ? currentState.singleCamera : null, (1048573 & 1024) != 0 ? currentState.isLoadingCamera : false, (1048573 & 2048) != 0 ? currentState.zoomMode : false, (1048573 & 4096) != 0 ? currentState.needUpdate : null, (1048573 & 8192) != 0 ? currentState.doorIsOpen : null, (1048573 & 16384) != 0 ? currentState.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.showBottomView : false, (1048573 & 131072) != 0 ? currentState.needReloadCameras : value, (1048573 & 262144) != 0 ? currentState.cameraToSelect : null, (1048573 & 524288) != 0 ? currentState.needReloadAllCameras : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(allCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(allCamerasViewStateCopy);
    }

    public void loadCamerasIfNeeded() {
        if (getCurrentState().getServerState() == Resource.Status.NONE) {
            if (this.prefManager.getIsNoDomofon()) {
                loadDemoCameras();
            } else {
                loadMainCameras();
            }
        }
    }

    public void loadMainCameras() {
        subscribeOnDataSource(getCameras(CamerasFiltering$ListTypes.main_screen.toString(), CamerasFiltering$OrderTypes.main_screen.toString()), new Function2<Resource<? extends List<? extends DomainCamera>>, AllCamerasViewState, AllCamerasViewState>() { // from class: com.sputnik.common.viewmodels.AllCamerasViewModel.loadMainCameras.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ AllCamerasViewState invoke(Resource<? extends List<? extends DomainCamera>> resource, AllCamerasViewState allCamerasViewState) {
                return invoke2((Resource<? extends List<DomainCamera>>) resource, allCamerasViewState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final AllCamerasViewState invoke2(Resource<? extends List<DomainCamera>> camerasResponse, AllCamerasViewState state) {
                Intrinsics.checkNotNullParameter(camerasResponse, "camerasResponse");
                Intrinsics.checkNotNullParameter(state, "state");
                Resource.Status status = camerasResponse.getStatus();
                Resource.Status status2 = Resource.Status.LOADING;
                if (status == status2) {
                    return state.copy((1048573 & 1) != 0 ? state.serverState : status2, (1048573 & 2) != 0 ? state.allCamerasState : null, (1048573 & 4) != 0 ? state.widgetState : null, (1048573 & 8) != 0 ? state.exception : null, (1048573 & 16) != 0 ? state.mainCameras : null, (1048573 & 32) != 0 ? state.allCameras : null, (1048573 & 64) != 0 ? state.widgetCameras : null, (1048573 & 128) != 0 ? state.currentCamera : null, (1048573 & 256) != 0 ? state.currentIndex : 0, (1048573 & 512) != 0 ? state.singleCamera : null, (1048573 & 1024) != 0 ? state.isLoadingCamera : false, (1048573 & 2048) != 0 ? state.zoomMode : false, (1048573 & 4096) != 0 ? state.needUpdate : null, (1048573 & 8192) != 0 ? state.doorIsOpen : null, (1048573 & 16384) != 0 ? state.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.showBottomView : false, (1048573 & 131072) != 0 ? state.needReloadCameras : false, (1048573 & 262144) != 0 ? state.cameraToSelect : null, (1048573 & 524288) != 0 ? state.needReloadAllCameras : false);
                }
                Resource.Status status3 = camerasResponse.getStatus();
                Resource.Status status4 = Resource.Status.ERROR;
                if (status3 == status4) {
                    Exception error = camerasResponse.getError();
                    Intrinsics.checkNotNull(error);
                    return state.copy((1048573 & 1) != 0 ? state.serverState : status4, (1048573 & 2) != 0 ? state.allCamerasState : null, (1048573 & 4) != 0 ? state.widgetState : null, (1048573 & 8) != 0 ? state.exception : error, (1048573 & 16) != 0 ? state.mainCameras : null, (1048573 & 32) != 0 ? state.allCameras : null, (1048573 & 64) != 0 ? state.widgetCameras : null, (1048573 & 128) != 0 ? state.currentCamera : null, (1048573 & 256) != 0 ? state.currentIndex : 0, (1048573 & 512) != 0 ? state.singleCamera : null, (1048573 & 1024) != 0 ? state.isLoadingCamera : false, (1048573 & 2048) != 0 ? state.zoomMode : false, (1048573 & 4096) != 0 ? state.needUpdate : null, (1048573 & 8192) != 0 ? state.doorIsOpen : null, (1048573 & 16384) != 0 ? state.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.showBottomView : false, (1048573 & 131072) != 0 ? state.needReloadCameras : false, (1048573 & 262144) != 0 ? state.cameraToSelect : null, (1048573 & 524288) != 0 ? state.needReloadAllCameras : false);
                }
                Resource.Status status5 = Resource.Status.SUCCESS;
                Event event = new Event(Boolean.FALSE);
                List<DomainCamera> data = camerasResponse.getData();
                Intrinsics.checkNotNull(data);
                List listSortedWith = CollectionsKt.sortedWith(AllCamerasViewModel.this.listMapper.map(data), new Comparator() { // from class: com.sputnik.common.viewmodels.AllCamerasViewModel$loadMainCameras$1$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((Camera) t).getOrder(), ((Camera) t2).getOrder());
                    }
                });
                List<DomainCamera> data2 = camerasResponse.getData();
                Intrinsics.checkNotNull(data2);
                DomainCamera domainCamera = (DomainCamera) CollectionsKt.getOrNull(data2, state.getCurrentIndex());
                return state.copy((1048573 & 1) != 0 ? state.serverState : status5, (1048573 & 2) != 0 ? state.allCamerasState : null, (1048573 & 4) != 0 ? state.widgetState : null, (1048573 & 8) != 0 ? state.exception : null, (1048573 & 16) != 0 ? state.mainCameras : listSortedWith, (1048573 & 32) != 0 ? state.allCameras : null, (1048573 & 64) != 0 ? state.widgetCameras : null, (1048573 & 128) != 0 ? state.currentCamera : domainCamera != null ? AllCamerasViewModel.this.domainCameraToCameraMapper.map(domainCamera) : null, (1048573 & 256) != 0 ? state.currentIndex : 0, (1048573 & 512) != 0 ? state.singleCamera : null, (1048573 & 1024) != 0 ? state.isLoadingCamera : false, (1048573 & 2048) != 0 ? state.zoomMode : false, (1048573 & 4096) != 0 ? state.needUpdate : event, (1048573 & 8192) != 0 ? state.doorIsOpen : null, (1048573 & 16384) != 0 ? state.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? state.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? state.showBottomView : false, (1048573 & 131072) != 0 ? state.needReloadCameras : false, (1048573 & 262144) != 0 ? state.cameraToSelect : null, (1048573 & 524288) != 0 ? state.needReloadAllCameras : false);
            }
        });
        AllCamerasViewState currentState = getCurrentState();
        AllCamerasViewState allCamerasViewStateCopy = currentState.copy((1048573 & 1) != 0 ? currentState.serverState : null, (1048573 & 2) != 0 ? currentState.allCamerasState : null, (1048573 & 4) != 0 ? currentState.widgetState : null, (1048573 & 8) != 0 ? currentState.exception : null, (1048573 & 16) != 0 ? currentState.mainCameras : null, (1048573 & 32) != 0 ? currentState.allCameras : null, (1048573 & 64) != 0 ? currentState.widgetCameras : null, (1048573 & 128) != 0 ? currentState.currentCamera : null, (1048573 & 256) != 0 ? currentState.currentIndex : 0, (1048573 & 512) != 0 ? currentState.singleCamera : null, (1048573 & 1024) != 0 ? currentState.isLoadingCamera : false, (1048573 & 2048) != 0 ? currentState.zoomMode : false, (1048573 & 4096) != 0 ? currentState.needUpdate : new Event(Boolean.FALSE), (1048573 & 8192) != 0 ? currentState.doorIsOpen : null, (1048573 & 16384) != 0 ? currentState.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.showBottomView : false, (1048573 & 131072) != 0 ? currentState.needReloadCameras : false, (1048573 & 262144) != 0 ? currentState.cameraToSelect : null, (1048573 & 524288) != 0 ? currentState.needReloadAllCameras : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(allCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(allCamerasViewStateCopy);
    }

    public final List<Camera> getCurrentCameras() {
        return CollectionsKt.sortedWith(getCurrentState().getMainCameras(), new Comparator() { // from class: com.sputnik.common.viewmodels.AllCamerasViewModel$getCurrentCameras$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((Camera) t).getOrder(), ((Camera) t2).getOrder());
            }
        });
    }

    public final void updateCamerasList(List<CameraObject> list) {
        Object next;
        Intrinsics.checkNotNullParameter(list, "list");
        Iterator<T> it = getCurrentState().getMainCameras().iterator();
        while (true) {
            Object obj = null;
            if (!it.hasNext()) {
                break;
            }
            Camera camera = (Camera) it.next();
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                if (Intrinsics.areEqual(((CameraObject) next2).getUuid(), camera.getUuid())) {
                    obj = next2;
                    break;
                }
            }
            CameraObject cameraObject = (CameraObject) obj;
            if (cameraObject != null) {
                String title = cameraObject.getTitle();
                if (title != null) {
                    camera.setTitle(title);
                }
                Boolean mainScreen = cameraObject.getMainScreen();
                if (mainScreen != null) {
                    camera.setMainScreen(mainScreen.booleanValue());
                }
                Boolean widget = cameraObject.getWidget();
                if (widget != null) {
                    camera.setWidget(widget.booleanValue());
                }
                Integer mainScreenOrder = cameraObject.getMainScreenOrder();
                if (mainScreenOrder != null) {
                    camera.setOrder(Integer.valueOf(mainScreenOrder.intValue()));
                }
            }
        }
        for (Camera camera2 : getCurrentState().getAllCameras()) {
            Iterator<T> it3 = list.iterator();
            while (true) {
                if (it3.hasNext()) {
                    next = it3.next();
                    if (Intrinsics.areEqual(((CameraObject) next).getUuid(), camera2.getUuid())) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            CameraObject cameraObject2 = (CameraObject) next;
            if (cameraObject2 != null) {
                String title2 = cameraObject2.getTitle();
                if (title2 != null) {
                    camera2.setTitle(title2);
                }
                Boolean mainScreen2 = cameraObject2.getMainScreen();
                if (mainScreen2 != null) {
                    camera2.setMainScreen(mainScreen2.booleanValue());
                }
                Boolean widget2 = cameraObject2.getWidget();
                if (widget2 != null) {
                    camera2.setWidget(widget2.booleanValue());
                }
                Integer mainScreenOrder2 = cameraObject2.getMainScreenOrder();
                if (mainScreenOrder2 != null) {
                    camera2.setOrder(Integer.valueOf(mainScreenOrder2.intValue()));
                }
            }
        }
        AllCamerasViewState currentState = getCurrentState();
        AllCamerasViewState allCamerasViewStateCopy = currentState.copy((1048573 & 1) != 0 ? currentState.serverState : null, (1048573 & 2) != 0 ? currentState.allCamerasState : null, (1048573 & 4) != 0 ? currentState.widgetState : null, (1048573 & 8) != 0 ? currentState.exception : null, (1048573 & 16) != 0 ? currentState.mainCameras : CollectionsKt.sortedWith(currentState.getMainCameras(), new Comparator() { // from class: com.sputnik.common.viewmodels.AllCamerasViewModel$updateCamerasList$lambda$32$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((Camera) t).getOrder(), ((Camera) t2).getOrder());
            }
        }), (1048573 & 32) != 0 ? currentState.allCameras : null, (1048573 & 64) != 0 ? currentState.widgetCameras : null, (1048573 & 128) != 0 ? currentState.currentCamera : null, (1048573 & 256) != 0 ? currentState.currentIndex : 0, (1048573 & 512) != 0 ? currentState.singleCamera : null, (1048573 & 1024) != 0 ? currentState.isLoadingCamera : false, (1048573 & 2048) != 0 ? currentState.zoomMode : false, (1048573 & 4096) != 0 ? currentState.needUpdate : null, (1048573 & 8192) != 0 ? currentState.doorIsOpen : null, (1048573 & 16384) != 0 ? currentState.camerasIsUpdated : null, (1048573 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? currentState.emergencyCode : null, (1048573 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? currentState.showBottomView : false, (1048573 & 131072) != 0 ? currentState.needReloadCameras : false, (1048573 & 262144) != 0 ? currentState.cameraToSelect : null, (1048573 & 524288) != 0 ? currentState.needReloadAllCameras : false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$updateState$1(allCamerasViewStateCopy, this, null), 3, null);
        getState().setValue(allCamerasViewStateCopy);
    }
}
