package com.sputnik.common.viewmodels;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.entities.camera.Camera;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AllCamerasViewModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/sputnik/common/viewmodels/SingleCamera;", "", "Lcom/sputnik/common/entities/camera/Camera;", "currentCamera", "", "currentIndex", "<init>", "(Lcom/sputnik/common/entities/camera/Camera;I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/common/entities/camera/Camera;", "getCurrentCamera", "()Lcom/sputnik/common/entities/camera/Camera;", "I", "getCurrentIndex", "Companion", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SingleCamera {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Camera currentCamera;
    private final int currentIndex;

    public SingleCamera() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SingleCamera)) {
            return false;
        }
        SingleCamera singleCamera = (SingleCamera) other;
        return Intrinsics.areEqual(this.currentCamera, singleCamera.currentCamera) && this.currentIndex == singleCamera.currentIndex;
    }

    public int hashCode() {
        Camera camera = this.currentCamera;
        return ((camera == null ? 0 : camera.hashCode()) * 31) + Integer.hashCode(this.currentIndex);
    }

    public String toString() {
        return "SingleCamera(currentCamera=" + this.currentCamera + ", currentIndex=" + this.currentIndex + ")";
    }

    public SingleCamera(Camera camera, int i) {
        this.currentCamera = camera;
        this.currentIndex = i;
    }

    public /* synthetic */ SingleCamera(Camera camera, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : camera, (i2 & 2) != 0 ? 0 : i);
    }

    public final Camera getCurrentCamera() {
        return this.currentCamera;
    }

    /* compiled from: AllCamerasViewModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/viewmodels/SingleCamera$Companion;", "", "()V", "toSingleCamera", "Lcom/sputnik/common/viewmodels/SingleCamera;", RemoteMessageConst.DATA, "Lcom/sputnik/common/viewmodels/AllCamerasViewState;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SingleCamera toSingleCamera(AllCamerasViewState data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new SingleCamera(data.getCurrentCamera(), data.getCurrentIndex());
        }
    }
}
