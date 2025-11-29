package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.Quirk;
import org.pjsip.pjsua2.pjsip_status_code;

/* loaded from: classes.dex */
public class ExtraSupportedOutputSizeQuirk implements Quirk {
    static boolean load() {
        return isMotoE5Play();
    }

    private static boolean isMotoE5Play() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL);
    }

    public Size[] getExtraSupportedResolutions(int i) {
        if (i == 34 && isMotoE5Play()) {
            return getMotoE5PlayExtraSupportedResolutions();
        }
        return new Size[0];
    }

    private Size[] getMotoE5PlayExtraSupportedResolutions() {
        return new Size[]{new Size(1920, 1080), new Size(1440, 1080), new Size(1280, 720), new Size(960, 720), new Size(864, pjsip_status_code.PJSIP_SC_TEMPORARILY_UNAVAILABLE), new Size(720, pjsip_status_code.PJSIP_SC_TEMPORARILY_UNAVAILABLE)};
    }
}
