package sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras.viewmodel;

import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.camera.CameraObject;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.entities.cameras.CamerasOrder;

/* compiled from: ManageCamerasViewModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0004\b\u0012\u0010\u0013J~\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0010HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b\u0004\u0010 R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b\u0005\u0010 R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b%\u0010\u0017R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u000e\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u000e\u0010,\u001a\u0004\b\u000e\u0010-R\u0017\u0010\u000f\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u000f\u0010)\u001a\u0004\b.\u0010+R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010/\u001a\u0004\b0\u00101¨\u00062"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Event;", "", "isSavedTitle", "isSavedOrder", "Lcom/sputnik/common/entities/camera/CameraObject;", "curCameraObject", "", "cameraUuid", "Lsputnik/axmor/com/sputnik/entities/cameras/CamerasOrder;", "orderCameras", "Lcom/sputnik/domain/common/Resource$Status;", "clearCamerasState", "isWidgetTabSelected", "loadCallsState", "", "callsState", "<init>", "(Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/common/entities/camera/CameraObject;Ljava/lang/String;Lsputnik/axmor/com/sputnik/entities/cameras/CamerasOrder;Lcom/sputnik/domain/common/Resource$Status;ZLcom/sputnik/domain/common/Resource$Status;Ljava/util/List;)V", "copy", "(Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/common/entities/camera/CameraObject;Ljava/lang/String;Lsputnik/axmor/com/sputnik/entities/cameras/CamerasOrder;Lcom/sputnik/domain/common/Resource$Status;ZLcom/sputnik/domain/common/Resource$Status;Ljava/util/List;)Lsputnik/axmor/com/sputnik/ui/main/profile/manage_cameras/viewmodel/ManageCamerasViewState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Event;", "()Lcom/sputnik/domain/common/Event;", "Lcom/sputnik/common/entities/camera/CameraObject;", "getCurCameraObject", "()Lcom/sputnik/common/entities/camera/CameraObject;", "Ljava/lang/String;", "getCameraUuid", "Lsputnik/axmor/com/sputnik/entities/cameras/CamerasOrder;", "getOrderCameras", "()Lsputnik/axmor/com/sputnik/entities/cameras/CamerasOrder;", "Lcom/sputnik/domain/common/Resource$Status;", "getClearCamerasState", "()Lcom/sputnik/domain/common/Resource$Status;", "Z", "()Z", "getLoadCallsState", "Ljava/util/List;", "getCallsState", "()Ljava/util/List;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ManageCamerasViewState implements VMState {
    private final List<CamerasOrder> callsState;
    private final String cameraUuid;
    private final Resource.Status clearCamerasState;
    private final CameraObject curCameraObject;
    private final Event<Boolean> isSavedOrder;
    private final Event<Boolean> isSavedTitle;
    private final boolean isWidgetTabSelected;
    private final Resource.Status loadCallsState;
    private final CamerasOrder orderCameras;

    public ManageCamerasViewState() {
        this(null, null, null, null, null, null, false, null, null, 511, null);
    }

    public final ManageCamerasViewState copy(Event<Boolean> isSavedTitle, Event<Boolean> isSavedOrder, CameraObject curCameraObject, String cameraUuid, CamerasOrder orderCameras, Resource.Status clearCamerasState, boolean isWidgetTabSelected, Resource.Status loadCallsState, List<CamerasOrder> callsState) {
        Intrinsics.checkNotNullParameter(isSavedTitle, "isSavedTitle");
        Intrinsics.checkNotNullParameter(isSavedOrder, "isSavedOrder");
        Intrinsics.checkNotNullParameter(curCameraObject, "curCameraObject");
        Intrinsics.checkNotNullParameter(orderCameras, "orderCameras");
        Intrinsics.checkNotNullParameter(clearCamerasState, "clearCamerasState");
        Intrinsics.checkNotNullParameter(loadCallsState, "loadCallsState");
        Intrinsics.checkNotNullParameter(callsState, "callsState");
        return new ManageCamerasViewState(isSavedTitle, isSavedOrder, curCameraObject, cameraUuid, orderCameras, clearCamerasState, isWidgetTabSelected, loadCallsState, callsState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ManageCamerasViewState)) {
            return false;
        }
        ManageCamerasViewState manageCamerasViewState = (ManageCamerasViewState) other;
        return Intrinsics.areEqual(this.isSavedTitle, manageCamerasViewState.isSavedTitle) && Intrinsics.areEqual(this.isSavedOrder, manageCamerasViewState.isSavedOrder) && Intrinsics.areEqual(this.curCameraObject, manageCamerasViewState.curCameraObject) && Intrinsics.areEqual(this.cameraUuid, manageCamerasViewState.cameraUuid) && Intrinsics.areEqual(this.orderCameras, manageCamerasViewState.orderCameras) && this.clearCamerasState == manageCamerasViewState.clearCamerasState && this.isWidgetTabSelected == manageCamerasViewState.isWidgetTabSelected && this.loadCallsState == manageCamerasViewState.loadCallsState && Intrinsics.areEqual(this.callsState, manageCamerasViewState.callsState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((((this.isSavedTitle.hashCode() * 31) + this.isSavedOrder.hashCode()) * 31) + this.curCameraObject.hashCode()) * 31;
        String str = this.cameraUuid;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.orderCameras.hashCode()) * 31) + this.clearCamerasState.hashCode()) * 31;
        boolean z = this.isWidgetTabSelected;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((((iHashCode2 + i) * 31) + this.loadCallsState.hashCode()) * 31) + this.callsState.hashCode();
    }

    public String toString() {
        return "ManageCamerasViewState(isSavedTitle=" + this.isSavedTitle + ", isSavedOrder=" + this.isSavedOrder + ", curCameraObject=" + this.curCameraObject + ", cameraUuid=" + this.cameraUuid + ", orderCameras=" + this.orderCameras + ", clearCamerasState=" + this.clearCamerasState + ", isWidgetTabSelected=" + this.isWidgetTabSelected + ", loadCallsState=" + this.loadCallsState + ", callsState=" + this.callsState + ")";
    }

    public ManageCamerasViewState(Event<Boolean> isSavedTitle, Event<Boolean> isSavedOrder, CameraObject curCameraObject, String str, CamerasOrder orderCameras, Resource.Status clearCamerasState, boolean z, Resource.Status loadCallsState, List<CamerasOrder> callsState) {
        Intrinsics.checkNotNullParameter(isSavedTitle, "isSavedTitle");
        Intrinsics.checkNotNullParameter(isSavedOrder, "isSavedOrder");
        Intrinsics.checkNotNullParameter(curCameraObject, "curCameraObject");
        Intrinsics.checkNotNullParameter(orderCameras, "orderCameras");
        Intrinsics.checkNotNullParameter(clearCamerasState, "clearCamerasState");
        Intrinsics.checkNotNullParameter(loadCallsState, "loadCallsState");
        Intrinsics.checkNotNullParameter(callsState, "callsState");
        this.isSavedTitle = isSavedTitle;
        this.isSavedOrder = isSavedOrder;
        this.curCameraObject = curCameraObject;
        this.cameraUuid = str;
        this.orderCameras = orderCameras;
        this.clearCamerasState = clearCamerasState;
        this.isWidgetTabSelected = z;
        this.loadCallsState = loadCallsState;
        this.callsState = callsState;
    }

    public /* synthetic */ ManageCamerasViewState(Event event, Event event2, CameraObject cameraObject, String str, CamerasOrder camerasOrder, Resource.Status status, boolean z, Resource.Status status2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Event(Boolean.FALSE) : event, (i & 2) != 0 ? new Event(Boolean.FALSE) : event2, (i & 4) != 0 ? new CameraObject(null, null, null, null, null, null, 63, null) : cameraObject, (i & 8) != 0 ? null : str, (i & 16) != 0 ? new CamerasOrder(null, null, null, null, 15, null) : camerasOrder, (i & 32) != 0 ? Resource.Status.NONE : status, (i & 64) != 0 ? false : z, (i & 128) != 0 ? Resource.Status.NONE : status2, (i & 256) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final Event<Boolean> isSavedTitle() {
        return this.isSavedTitle;
    }

    public final Event<Boolean> isSavedOrder() {
        return this.isSavedOrder;
    }

    public final CameraObject getCurCameraObject() {
        return this.curCameraObject;
    }

    public final String getCameraUuid() {
        return this.cameraUuid;
    }

    public final CamerasOrder getOrderCameras() {
        return this.orderCameras;
    }

    public final Resource.Status getClearCamerasState() {
        return this.clearCamerasState;
    }

    /* renamed from: isWidgetTabSelected, reason: from getter */
    public final boolean getIsWidgetTabSelected() {
        return this.isWidgetTabSelected;
    }

    public final Resource.Status getLoadCallsState() {
        return this.loadCallsState;
    }

    public final List<CamerasOrder> getCallsState() {
        return this.callsState;
    }
}
