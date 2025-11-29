package com.sputnik.common.viewmodels;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.entities.camera.Camera;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AllCamerasViewModel.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB3\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/sputnik/common/viewmodels/CamerasState;", "", "Lcom/sputnik/domain/common/Resource$Status;", "serverState", "", "Lcom/sputnik/common/entities/camera/Camera;", "cameras", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;Ljava/lang/Exception;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getServerState", "()Lcom/sputnik/domain/common/Resource$Status;", "Ljava/util/List;", "getCameras", "()Ljava/util/List;", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "Companion", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CamerasState {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Camera> cameras;
    private final Exception exception;
    private final Resource.Status serverState;

    public CamerasState() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CamerasState)) {
            return false;
        }
        CamerasState camerasState = (CamerasState) other;
        return this.serverState == camerasState.serverState && Intrinsics.areEqual(this.cameras, camerasState.cameras) && Intrinsics.areEqual(this.exception, camerasState.exception);
    }

    public int hashCode() {
        int iHashCode = ((this.serverState.hashCode() * 31) + this.cameras.hashCode()) * 31;
        Exception exc = this.exception;
        return iHashCode + (exc == null ? 0 : exc.hashCode());
    }

    public String toString() {
        return "CamerasState(serverState=" + this.serverState + ", cameras=" + this.cameras + ", exception=" + this.exception + ")";
    }

    public CamerasState(Resource.Status serverState, List<Camera> cameras, Exception exc) {
        Intrinsics.checkNotNullParameter(serverState, "serverState");
        Intrinsics.checkNotNullParameter(cameras, "cameras");
        this.serverState = serverState;
        this.cameras = cameras;
        this.exception = exc;
    }

    public /* synthetic */ CamerasState(Resource.Status status, List list, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.LOADING : status, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : exc);
    }

    public final Resource.Status getServerState() {
        return this.serverState;
    }

    public final List<Camera> getCameras() {
        return this.cameras;
    }

    /* compiled from: AllCamerasViewModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/viewmodels/CamerasState$Companion;", "", "()V", "toCamerasState", "Lcom/sputnik/common/viewmodels/CamerasState;", RemoteMessageConst.DATA, "Lcom/sputnik/common/viewmodels/AllCamerasViewState;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CamerasState toCamerasState(AllCamerasViewState data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new CamerasState(data.getServerState(), data.getMainCameras(), data.getException());
        }
    }
}
