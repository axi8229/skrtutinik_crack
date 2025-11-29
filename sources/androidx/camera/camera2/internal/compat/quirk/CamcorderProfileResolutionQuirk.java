package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Size;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat;
import androidx.camera.core.impl.Quirk;
import java.util.List;

/* loaded from: classes.dex */
public class CamcorderProfileResolutionQuirk implements Quirk {
    private final StreamConfigurationMapCompat mStreamConfigurationMapCompat;
    private List<Size> mSupportedResolutions = null;

    static boolean load(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Integer num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2;
    }

    public CamcorderProfileResolutionQuirk(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        this.mStreamConfigurationMapCompat = cameraCharacteristicsCompat.getStreamConfigurationMapCompat();
    }
}
