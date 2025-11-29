package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class CameraDeviceCompatBaseImpl implements CameraDeviceCompat.CameraDeviceCompatImpl {
    final CameraDevice mCameraDevice;
    final Object mImplParams;

    CameraDeviceCompatBaseImpl(CameraDevice cameraDevice, Object obj) {
        this.mCameraDevice = (CameraDevice) Preconditions.checkNotNull(cameraDevice);
        this.mImplParams = obj;
    }

    static List<Surface> unpackSurfaces(List<OutputConfigurationCompat> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<OutputConfigurationCompat> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getSurface());
        }
        return arrayList;
    }

    static void checkPreconditions(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat) {
        Preconditions.checkNotNull(cameraDevice);
        Preconditions.checkNotNull(sessionConfigurationCompat);
        Preconditions.checkNotNull(sessionConfigurationCompat.getStateCallback());
        List<OutputConfigurationCompat> outputConfigurations = sessionConfigurationCompat.getOutputConfigurations();
        if (outputConfigurations == null) {
            throw new IllegalArgumentException("Invalid output configurations");
        }
        if (sessionConfigurationCompat.getExecutor() == null) {
            throw new IllegalArgumentException("Invalid executor");
        }
        checkPhysicalCameraIdValid(cameraDevice, outputConfigurations);
    }

    private static void checkPhysicalCameraIdValid(CameraDevice cameraDevice, List<OutputConfigurationCompat> list) {
        String id = cameraDevice.getId();
        Iterator<OutputConfigurationCompat> it = list.iterator();
        while (it.hasNext()) {
            String physicalCameraId = it.next().getPhysicalCameraId();
            if (physicalCameraId != null && !physicalCameraId.isEmpty()) {
                Logger.w("CameraDeviceCompat", "Camera " + id + ": Camera doesn't support physicalCameraId " + physicalCameraId + ". Ignoring.");
            }
        }
    }

    static class CameraDeviceCompatParamsApi21 {
        final Handler mCompatHandler;

        CameraDeviceCompatParamsApi21(Handler handler) {
            this.mCompatHandler = handler;
        }
    }
}
