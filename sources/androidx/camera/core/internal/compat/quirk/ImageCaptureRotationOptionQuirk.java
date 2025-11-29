package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Quirk;
import com.huawei.hms.android.SystemUtils;

/* loaded from: classes.dex */
public final class ImageCaptureRotationOptionQuirk implements Quirk {
    static boolean load() {
        return isHuaweiMate20Lite() || isHonor9X() || isEmulatorAndApi21();
    }

    private static boolean isHuaweiMate20Lite() {
        return SystemUtils.PRODUCT_HUAWEI.equalsIgnoreCase(Build.BRAND) && "SNE-LX1".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isHonor9X() {
        return SystemUtils.PRODUCT_HONOR.equalsIgnoreCase(Build.BRAND) && "STK-LX1".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isEmulatorAndApi21() {
        isEmulator();
        return false;
    }

    private static boolean isEmulator() {
        String str = Build.FINGERPRINT;
        if (!str.startsWith("generic") && !str.startsWith(SystemUtils.UNKNOWN)) {
            String str2 = Build.MODEL;
            if (!str2.contains("google_sdk") && !str2.contains("Emulator") && !str2.contains("Cuttlefish") && !str2.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && ((!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !Build.PRODUCT.equals("google_sdk") && !Build.HARDWARE.contains("ranchu"))) {
                return false;
            }
        }
        return true;
    }

    public boolean isSupported(Config.Option<?> option) {
        return option != CaptureConfig.OPTION_ROTATION;
    }
}
