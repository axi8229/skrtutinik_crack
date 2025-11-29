package androidx.camera.core.impl;

import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import java.util.Collection;

/* loaded from: classes.dex */
public interface CameraInternal extends Camera, UseCase.StateChangeCallback {
    void attachUseCases(Collection<UseCase> collection);

    void detachUseCases(Collection<UseCase> collection);

    CameraControlInternal getCameraControlInternal();

    CameraInfoInternal getCameraInfoInternal();

    Observable<State> getCameraState();

    default boolean getHasTransform() {
        return true;
    }

    default void setActiveResumingMode(boolean z) {
    }

    default void setExtendedConfig(CameraConfig cameraConfig) {
    }

    public enum State {
        PENDING_OPEN(false),
        OPENING(true),
        OPEN(true),
        CONFIGURED(true),
        CLOSING(true),
        CLOSED(false),
        RELEASING(true),
        RELEASED(false);

        private final boolean mHoldsCameraSlot;

        State(boolean z) {
            this.mHoldsCameraSlot = z;
        }

        boolean holdsCameraSlot() {
            return this.mHoldsCameraSlot;
        }
    }

    default boolean isFrontFacing() {
        return getCameraInfo().getLensFacing() == 0;
    }

    @Override // androidx.camera.core.Camera
    default CameraInfo getCameraInfo() {
        return getCameraInfoInternal();
    }

    default CameraConfig getExtendedConfig() {
        return CameraConfigs.emptyConfig();
    }
}
