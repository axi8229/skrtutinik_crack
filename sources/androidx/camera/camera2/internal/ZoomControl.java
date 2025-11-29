package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Looper;
import android.util.Range;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.ZoomState;
import androidx.camera.core.internal.ImmutableZoomState;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class ZoomControl {
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;
    private final ZoomStateImpl mCurrentZoomState;
    private final Executor mExecutor;
    final ZoomImpl mZoomImpl;
    private final MutableLiveData<ZoomState> mZoomStateLiveData;
    private boolean mIsActive = false;
    private Camera2CameraControlImpl.CaptureResultListener mCaptureResultListener = new Camera2CameraControlImpl.CaptureResultListener() { // from class: androidx.camera.camera2.internal.ZoomControl.1
        @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
        public boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
            ZoomControl.this.mZoomImpl.onCaptureResult(totalCaptureResult);
            return false;
        }
    };

    interface ZoomImpl {
        void addRequestOption(Camera2ImplConfig.Builder builder);

        float getMaxZoom();

        float getMinZoom();

        void onCaptureResult(TotalCaptureResult totalCaptureResult);

        void resetZoom();
    }

    ZoomControl(Camera2CameraControlImpl camera2CameraControlImpl, CameraCharacteristicsCompat cameraCharacteristicsCompat, Executor executor) throws IllegalArgumentException {
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = executor;
        ZoomImpl zoomImplCreateZoomImpl = createZoomImpl(cameraCharacteristicsCompat);
        this.mZoomImpl = zoomImplCreateZoomImpl;
        ZoomStateImpl zoomStateImpl = new ZoomStateImpl(zoomImplCreateZoomImpl.getMaxZoom(), zoomImplCreateZoomImpl.getMinZoom());
        this.mCurrentZoomState = zoomStateImpl;
        zoomStateImpl.setZoomRatio(1.0f);
        this.mZoomStateLiveData = new MutableLiveData<>(ImmutableZoomState.create(zoomStateImpl));
        camera2CameraControlImpl.addCaptureResultListener(this.mCaptureResultListener);
    }

    private static ZoomImpl createZoomImpl(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        if (isAndroidRZoomSupported(cameraCharacteristicsCompat)) {
            return new AndroidRZoomImpl(cameraCharacteristicsCompat);
        }
        return new CropRegionZoomImpl(cameraCharacteristicsCompat);
    }

    static boolean isAndroidRZoomSupported(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        return Build.VERSION.SDK_INT >= 30 && getZoomRatioRange(cameraCharacteristicsCompat) != null;
    }

    private static Range<Float> getZoomRatioRange(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        try {
            return (Range) cameraCharacteristicsCompat.get(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
        } catch (AssertionError e) {
            Logger.w("ZoomControl", "AssertionError, fail to get camera characteristic.", e);
            return null;
        }
    }

    void addZoomOption(Camera2ImplConfig.Builder builder) {
        this.mZoomImpl.addRequestOption(builder);
    }

    void setActive(boolean z) {
        ZoomState zoomStateCreate;
        if (this.mIsActive == z) {
            return;
        }
        this.mIsActive = z;
        if (z) {
            return;
        }
        synchronized (this.mCurrentZoomState) {
            this.mCurrentZoomState.setZoomRatio(1.0f);
            zoomStateCreate = ImmutableZoomState.create(this.mCurrentZoomState);
        }
        updateLiveData(zoomStateCreate);
        this.mZoomImpl.resetZoom();
        this.mCamera2CameraControlImpl.updateSessionConfigSynchronous();
    }

    private void updateLiveData(ZoomState zoomState) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.mZoomStateLiveData.setValue(zoomState);
        } else {
            this.mZoomStateLiveData.postValue(zoomState);
        }
    }

    LiveData<ZoomState> getZoomState() {
        return this.mZoomStateLiveData;
    }
}
