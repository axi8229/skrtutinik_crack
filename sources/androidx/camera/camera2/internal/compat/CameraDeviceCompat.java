package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraDevice;
import android.os.Build;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class CameraDeviceCompat {
    private final CameraDeviceCompatImpl mImpl;

    interface CameraDeviceCompatImpl {
        void createCaptureSession(SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessExceptionCompat;
    }

    private CameraDeviceCompat(CameraDevice cameraDevice, Handler handler) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mImpl = new CameraDeviceCompatApi28Impl(cameraDevice);
        } else {
            this.mImpl = CameraDeviceCompatApi24Impl.create(cameraDevice, handler);
        }
    }

    public static CameraDeviceCompat toCameraDeviceCompat(CameraDevice cameraDevice, Handler handler) {
        return new CameraDeviceCompat(cameraDevice, handler);
    }

    public void createCaptureSession(SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessExceptionCompat {
        this.mImpl.createCaptureSession(sessionConfigurationCompat);
    }

    static final class StateCallbackExecutorWrapper extends CameraDevice.StateCallback {
        private final Executor mExecutor;
        final CameraDevice.StateCallback mWrappedCallback;

        StateCallbackExecutorWrapper(Executor executor, CameraDevice.StateCallback stateCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = stateCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onOpened$0(CameraDevice cameraDevice) {
            this.mWrappedCallback.onOpened(cameraDevice);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(final CameraDevice cameraDevice) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraDeviceCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onOpened$0(cameraDevice);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDisconnected$1(CameraDevice cameraDevice) {
            this.mWrappedCallback.onDisconnected(cameraDevice);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(final CameraDevice cameraDevice) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraDeviceCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDisconnected$1(cameraDevice);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$2(CameraDevice cameraDevice, int i) {
            this.mWrappedCallback.onError(cameraDevice, i);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(final CameraDevice cameraDevice, final int i) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraDeviceCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onError$2(cameraDevice, i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClosed$3(CameraDevice cameraDevice) {
            this.mWrappedCallback.onClosed(cameraDevice);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(final CameraDevice cameraDevice) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraDeviceCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onClosed$3(cameraDevice);
                }
            });
        }
    }
}
