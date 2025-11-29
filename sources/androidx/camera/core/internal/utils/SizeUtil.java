package androidx.camera.core.internal.utils;

import android.util.Size;
import org.pjsip.pjsua2.pjsip_status_code;

/* loaded from: classes.dex */
public final class SizeUtil {
    public static final Size RESOLUTION_ZERO = new Size(0, 0);
    public static final Size RESOLUTION_QVGA = new Size(320, 240);
    public static final Size RESOLUTION_VGA = new Size(640, pjsip_status_code.PJSIP_SC_TEMPORARILY_UNAVAILABLE);
    public static final Size RESOLUTION_480P = new Size(720, pjsip_status_code.PJSIP_SC_TEMPORARILY_UNAVAILABLE);
    public static final Size RESOLUTION_720P = new Size(1280, 720);
    public static final Size RESOLUTION_1080P = new Size(1920, 1080);
    public static final Size RESOLUTION_1440P = new Size(1920, 1440);

    public static int getArea(Size size) {
        return size.getWidth() * size.getHeight();
    }

    public static boolean isSmallerByArea(Size size, Size size2) {
        return getArea(size) < getArea(size2);
    }
}
