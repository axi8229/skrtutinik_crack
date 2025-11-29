package com.sputnik.common.viewmodels;

import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pj_ssl_sock_proto;

/* compiled from: AllCamerasViewModel.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b'\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0016\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0016\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u0016\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0013\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0016\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0013¢\u0006\u0004\b \u0010!J\u0090\u0002\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00162\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00162\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u00162\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00132\b\b\u0002\u0010\u001d\u001a\u00020\u00132\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00162\b\b\u0002\u0010\u001f\u001a\u00020\u0013HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010,\u001a\u0004\b/\u0010.R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b0\u0010.R\u001f\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0006¢\u0006\f\n\u0004\b\b\u00101\u001a\u0004\b2\u00103R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u00104\u001a\u0004\b5\u00106R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\f\u00104\u001a\u0004\b7\u00106R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\r\u00104\u001a\u0004\b8\u00106R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000e\u00109\u001a\u0004\b:\u0010;R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010<\u001a\u0004\b=\u0010'R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010A\u001a\u0004\b\u0014\u0010BR\u0017\u0010\u0015\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0015\u0010A\u001a\u0004\bC\u0010BR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010D\u001a\u0004\bE\u0010FR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00168\u0006¢\u0006\f\n\u0004\b\u0018\u0010D\u001a\u0004\bG\u0010FR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u00168\u0006¢\u0006\f\n\u0004\b\u0019\u0010D\u001a\u0004\bH\u0010FR\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010I\u001a\u0004\bJ\u0010%R\u0017\u0010\u001c\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u001c\u0010A\u001a\u0004\bK\u0010BR\u0017\u0010\u001d\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u001d\u0010A\u001a\u0004\bL\u0010BR\u001f\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00168\u0006¢\u0006\f\n\u0004\b\u001e\u0010D\u001a\u0004\bM\u0010FR\u0017\u0010\u001f\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u001f\u0010A\u001a\u0004\bN\u0010B¨\u0006O"}, d2 = {"Lcom/sputnik/common/viewmodels/AllCamerasViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "allCamerasState", "widgetState", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "", "Lcom/sputnik/common/entities/camera/Camera;", "mainCameras", "allCameras", "widgetCameras", "currentCamera", "", "currentIndex", "Lcom/sputnik/common/viewmodels/SingleCamera;", "singleCamera", "", "isLoadingCamera", "zoomMode", "Lcom/sputnik/domain/common/Event;", "needUpdate", "doorIsOpen", "camerasIsUpdated", "", "emergencyCode", "showBottomView", "needReloadCameras", "cameraToSelect", "needReloadAllCameras", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Ljava/lang/Exception;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/sputnik/common/entities/camera/Camera;ILcom/sputnik/common/viewmodels/SingleCamera;ZZLcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Ljava/lang/String;ZZLcom/sputnik/domain/common/Event;Z)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Ljava/lang/Exception;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/sputnik/common/entities/camera/Camera;ILcom/sputnik/common/viewmodels/SingleCamera;ZZLcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;Ljava/lang/String;ZZLcom/sputnik/domain/common/Event;Z)Lcom/sputnik/common/viewmodels/AllCamerasViewState;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "getAllCamerasState", "getWidgetState", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "Ljava/util/List;", "getMainCameras", "()Ljava/util/List;", "getAllCameras", "getWidgetCameras", "Lcom/sputnik/common/entities/camera/Camera;", "getCurrentCamera", "()Lcom/sputnik/common/entities/camera/Camera;", "I", "getCurrentIndex", "Lcom/sputnik/common/viewmodels/SingleCamera;", "getSingleCamera", "()Lcom/sputnik/common/viewmodels/SingleCamera;", "Z", "()Z", "getZoomMode", "Lcom/sputnik/domain/common/Event;", "getNeedUpdate", "()Lcom/sputnik/domain/common/Event;", "getDoorIsOpen", "getCamerasIsUpdated", "Ljava/lang/String;", "getEmergencyCode", "getShowBottomView", "getNeedReloadCameras", "getCameraToSelect", "getNeedReloadAllCameras", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AllCamerasViewState implements VMState {
    private final List<Camera> allCameras;
    private final Resource.Status allCamerasState;
    private final Event<Camera> cameraToSelect;
    private final Event<Boolean> camerasIsUpdated;
    private final Camera currentCamera;
    private final int currentIndex;
    private final Event<Boolean> doorIsOpen;
    private final String emergencyCode;
    private final Exception exception;
    private final boolean isLoadingCamera;
    private final List<Camera> mainCameras;
    private final boolean needReloadAllCameras;
    private final boolean needReloadCameras;
    private final Event<Boolean> needUpdate;
    private final Resource.Status serverState;
    private final boolean showBottomView;
    private final SingleCamera singleCamera;
    private final List<Camera> widgetCameras;
    private final Resource.Status widgetState;
    private final boolean zoomMode;

    public AllCamerasViewState() {
        this(null, null, null, null, null, null, null, null, 0, null, false, false, null, null, null, null, false, false, null, false, 1048575, null);
    }

    public final AllCamerasViewState copy(Resource.Status serverState, Resource.Status allCamerasState, Resource.Status widgetState, Exception exception, List<Camera> mainCameras, List<Camera> allCameras, List<Camera> widgetCameras, Camera currentCamera, int currentIndex, SingleCamera singleCamera, boolean isLoadingCamera, boolean zoomMode, Event<Boolean> needUpdate, Event<Boolean> doorIsOpen, Event<Boolean> camerasIsUpdated, String emergencyCode, boolean showBottomView, boolean needReloadCameras, Event<Camera> cameraToSelect, boolean needReloadAllCameras) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(allCamerasState, "allCamerasState");
        Intrinsics.checkNotNullParameter(widgetState, "widgetState");
        Intrinsics.checkNotNullParameter(mainCameras, "mainCameras");
        Intrinsics.checkNotNullParameter(allCameras, "allCameras");
        Intrinsics.checkNotNullParameter(widgetCameras, "widgetCameras");
        Intrinsics.checkNotNullParameter(singleCamera, "singleCamera");
        Intrinsics.checkNotNullParameter(needUpdate, "needUpdate");
        Intrinsics.checkNotNullParameter(doorIsOpen, "doorIsOpen");
        Intrinsics.checkNotNullParameter(camerasIsUpdated, "camerasIsUpdated");
        Intrinsics.checkNotNullParameter(cameraToSelect, "cameraToSelect");
        return new AllCamerasViewState(serverState, allCamerasState, widgetState, exception, mainCameras, allCameras, widgetCameras, currentCamera, currentIndex, singleCamera, isLoadingCamera, zoomMode, needUpdate, doorIsOpen, camerasIsUpdated, emergencyCode, showBottomView, needReloadCameras, cameraToSelect, needReloadAllCameras);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AllCamerasViewState)) {
            return false;
        }
        AllCamerasViewState allCamerasViewState = (AllCamerasViewState) other;
        return this.serverState == allCamerasViewState.serverState && this.allCamerasState == allCamerasViewState.allCamerasState && this.widgetState == allCamerasViewState.widgetState && Intrinsics.areEqual(this.exception, allCamerasViewState.exception) && Intrinsics.areEqual(this.mainCameras, allCamerasViewState.mainCameras) && Intrinsics.areEqual(this.allCameras, allCamerasViewState.allCameras) && Intrinsics.areEqual(this.widgetCameras, allCamerasViewState.widgetCameras) && Intrinsics.areEqual(this.currentCamera, allCamerasViewState.currentCamera) && this.currentIndex == allCamerasViewState.currentIndex && Intrinsics.areEqual(this.singleCamera, allCamerasViewState.singleCamera) && this.isLoadingCamera == allCamerasViewState.isLoadingCamera && this.zoomMode == allCamerasViewState.zoomMode && Intrinsics.areEqual(this.needUpdate, allCamerasViewState.needUpdate) && Intrinsics.areEqual(this.doorIsOpen, allCamerasViewState.doorIsOpen) && Intrinsics.areEqual(this.camerasIsUpdated, allCamerasViewState.camerasIsUpdated) && Intrinsics.areEqual(this.emergencyCode, allCamerasViewState.emergencyCode) && this.showBottomView == allCamerasViewState.showBottomView && this.needReloadCameras == allCamerasViewState.needReloadCameras && Intrinsics.areEqual(this.cameraToSelect, allCamerasViewState.cameraToSelect) && this.needReloadAllCameras == allCamerasViewState.needReloadAllCameras;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((((this.serverState.hashCode() * 31) + this.allCamerasState.hashCode()) * 31) + this.widgetState.hashCode()) * 31;
        Exception exc = this.exception;
        int iHashCode2 = (((((((iHashCode + (exc == null ? 0 : exc.hashCode())) * 31) + this.mainCameras.hashCode()) * 31) + this.allCameras.hashCode()) * 31) + this.widgetCameras.hashCode()) * 31;
        Camera camera = this.currentCamera;
        int iHashCode3 = (((((iHashCode2 + (camera == null ? 0 : camera.hashCode())) * 31) + Integer.hashCode(this.currentIndex)) * 31) + this.singleCamera.hashCode()) * 31;
        boolean z = this.isLoadingCamera;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        boolean z2 = this.zoomMode;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int iHashCode4 = (((((((i2 + i3) * 31) + this.needUpdate.hashCode()) * 31) + this.doorIsOpen.hashCode()) * 31) + this.camerasIsUpdated.hashCode()) * 31;
        String str = this.emergencyCode;
        int iHashCode5 = (iHashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z3 = this.showBottomView;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (iHashCode5 + i4) * 31;
        boolean z4 = this.needReloadCameras;
        int i6 = z4;
        if (z4 != 0) {
            i6 = 1;
        }
        int iHashCode6 = (((i5 + i6) * 31) + this.cameraToSelect.hashCode()) * 31;
        boolean z5 = this.needReloadAllCameras;
        return iHashCode6 + (z5 ? 1 : z5 ? 1 : 0);
    }

    public String toString() {
        return "AllCamerasViewState(serverState=" + this.serverState + ", allCamerasState=" + this.allCamerasState + ", widgetState=" + this.widgetState + ", exception=" + this.exception + ", mainCameras=" + this.mainCameras + ", allCameras=" + this.allCameras + ", widgetCameras=" + this.widgetCameras + ", currentCamera=" + this.currentCamera + ", currentIndex=" + this.currentIndex + ", singleCamera=" + this.singleCamera + ", isLoadingCamera=" + this.isLoadingCamera + ", zoomMode=" + this.zoomMode + ", needUpdate=" + this.needUpdate + ", doorIsOpen=" + this.doorIsOpen + ", camerasIsUpdated=" + this.camerasIsUpdated + ", emergencyCode=" + this.emergencyCode + ", showBottomView=" + this.showBottomView + ", needReloadCameras=" + this.needReloadCameras + ", cameraToSelect=" + this.cameraToSelect + ", needReloadAllCameras=" + this.needReloadAllCameras + ")";
    }

    public AllCamerasViewState(Resource.Status serverState, Resource.Status allCamerasState, Resource.Status widgetState, Exception exc, List<Camera> mainCameras, List<Camera> allCameras, List<Camera> widgetCameras, Camera camera, int i, SingleCamera singleCamera, boolean z, boolean z2, Event<Boolean> needUpdate, Event<Boolean> doorIsOpen, Event<Boolean> camerasIsUpdated, String str, boolean z3, boolean z4, Event<Camera> cameraToSelect, boolean z5) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(allCamerasState, "allCamerasState");
        Intrinsics.checkNotNullParameter(widgetState, "widgetState");
        Intrinsics.checkNotNullParameter(mainCameras, "mainCameras");
        Intrinsics.checkNotNullParameter(allCameras, "allCameras");
        Intrinsics.checkNotNullParameter(widgetCameras, "widgetCameras");
        Intrinsics.checkNotNullParameter(singleCamera, "singleCamera");
        Intrinsics.checkNotNullParameter(needUpdate, "needUpdate");
        Intrinsics.checkNotNullParameter(doorIsOpen, "doorIsOpen");
        Intrinsics.checkNotNullParameter(camerasIsUpdated, "camerasIsUpdated");
        Intrinsics.checkNotNullParameter(cameraToSelect, "cameraToSelect");
        this.serverState = serverState;
        this.allCamerasState = allCamerasState;
        this.widgetState = widgetState;
        this.exception = exc;
        this.mainCameras = mainCameras;
        this.allCameras = allCameras;
        this.widgetCameras = widgetCameras;
        this.currentCamera = camera;
        this.currentIndex = i;
        this.singleCamera = singleCamera;
        this.isLoadingCamera = z;
        this.zoomMode = z2;
        this.needUpdate = needUpdate;
        this.doorIsOpen = doorIsOpen;
        this.camerasIsUpdated = camerasIsUpdated;
        this.emergencyCode = str;
        this.showBottomView = z3;
        this.needReloadCameras = z4;
        this.cameraToSelect = cameraToSelect;
        this.needReloadAllCameras = z5;
    }

    public /* synthetic */ AllCamerasViewState(Resource.Status status, Resource.Status status2, Resource.Status status3, Exception exc, List list, List list2, List list3, Camera camera, int i, SingleCamera singleCamera, boolean z, boolean z2, Event event, Event event2, Event event3, String str, boolean z3, boolean z4, Event event4, boolean z5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        Event event5;
        Event event6;
        Event event7;
        String str2;
        Event event8;
        Resource.Status status4 = (i2 & 1) != 0 ? Resource.Status.NONE : status;
        Resource.Status status5 = (i2 & 2) != 0 ? Resource.Status.NONE : status2;
        Resource.Status status6 = (i2 & 4) != 0 ? Resource.Status.NONE : status3;
        Exception exc2 = (i2 & 8) != 0 ? null : exc;
        List listEmptyList = (i2 & 16) != 0 ? CollectionsKt.emptyList() : list;
        List listEmptyList2 = (i2 & 32) != 0 ? CollectionsKt.emptyList() : list2;
        List listEmptyList3 = (i2 & 64) != 0 ? CollectionsKt.emptyList() : list3;
        Camera camera2 = (i2 & 128) != 0 ? null : camera;
        int i3 = (i2 & 256) != 0 ? 0 : i;
        SingleCamera singleCamera2 = (i2 & 512) != 0 ? new SingleCamera(null, 0, 3, null) : singleCamera;
        boolean z6 = (i2 & 1024) != 0 ? true : z;
        boolean z7 = (i2 & 2048) != 0 ? false : z2;
        Event event9 = (i2 & 4096) != 0 ? new Event(Boolean.TRUE) : event;
        Event event10 = (i2 & 8192) != 0 ? new Event(Boolean.FALSE) : event2;
        if ((i2 & 16384) != 0) {
            event5 = event10;
            event6 = new Event(Boolean.FALSE);
        } else {
            event5 = event10;
            event6 = event3;
        }
        String str3 = (32768 & i2) != 0 ? null : str;
        boolean z8 = (i2 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? true : z3;
        boolean z9 = (i2 & 131072) != 0 ? false : z4;
        if ((i2 & 262144) != 0) {
            str2 = str3;
            event7 = event6;
            event8 = new Event(null);
        } else {
            event7 = event6;
            str2 = str3;
            event8 = event4;
        }
        this(status4, status5, status6, exc2, listEmptyList, listEmptyList2, listEmptyList3, camera2, i3, singleCamera2, z6, z7, event9, event5, event7, str2, z8, z9, event8, (i2 & 524288) != 0 ? false : z5);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final Resource.Status getAllCamerasState() {
        return this.allCamerasState;
    }

    public final Resource.Status getWidgetState() {
        return this.widgetState;
    }

    public final Exception getException() {
        return this.exception;
    }

    public final List<Camera> getMainCameras() {
        return this.mainCameras;
    }

    public final List<Camera> getAllCameras() {
        return this.allCameras;
    }

    public final List<Camera> getWidgetCameras() {
        return this.widgetCameras;
    }

    public final Camera getCurrentCamera() {
        return this.currentCamera;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    /* renamed from: isLoadingCamera, reason: from getter */
    public final boolean getIsLoadingCamera() {
        return this.isLoadingCamera;
    }

    public final boolean getZoomMode() {
        return this.zoomMode;
    }

    public final Event<Boolean> getNeedUpdate() {
        return this.needUpdate;
    }

    public final Event<Boolean> getDoorIsOpen() {
        return this.doorIsOpen;
    }

    public final String getEmergencyCode() {
        return this.emergencyCode;
    }

    public final boolean getNeedReloadCameras() {
        return this.needReloadCameras;
    }

    public final boolean getNeedReloadAllCameras() {
        return this.needReloadAllCameras;
    }
}
