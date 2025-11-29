package bz;

import android.os.Build;
import java.io.Serializable;
import okio.Utf8;

/* loaded from: classes.dex */
public final class X extends AbstractC0538n1 {
    public X() {
        super(zone.bi.mobile.fingerprint.api.f.OSCodeName);
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        int i = Build.VERSION.SDK_INT;
        return i == 33 ? AbstractC0569y0.a(new byte[]{11, -21, -60, 117, 105, 116, -50, -66, -82, -97, 51, 80, -5, -117, -87, -29}) : i == 32 ? AbstractC0569y0.a(new byte[]{12, -86, 13, -43, -109, -16, -104, -3, 114, -113, 77, -112, 0, 113, -80, -127}) : i == 31 ? AbstractC0569y0.a(new byte[]{-39, 78, 72, 38, 49, Utf8.REPLACEMENT_BYTE, -70, -64, 89, 4, -89, -75, -84, 29, 95, 96}) : i == 30 ? AbstractC0569y0.a(new byte[]{98, -100, -85, 119, -70, 90, -52, 56, 24, 47, -3, 114, 7, 95, -33, -126}) : i == 29 ? AbstractC0569y0.a(new byte[]{-31, -40, -108, -113, 46, 49, -107, 24, -62, 34, -59, 29, -20, 61, 33, 14}) : i == 28 ? AbstractC0569y0.a(new byte[]{14, -85, 56, -107, 39, 95, 100, -64, 7, -44, -115, 65, -95, -78, -98, 74}) : (i == 26 || i == 27) ? AbstractC0569y0.a(new byte[]{-16, -38, -83, 8, -37, 86, 68, 106, 65, 102, 1, -4, -59, -12, -124, 13}) : (i == 24 || i == 25) ? AbstractC0569y0.a(new byte[]{53, 114, -104, -55, -49, 78, -19, -28, -101, -32, -29, -41, -88, Utf8.REPLACEMENT_BYTE, 54, 37}) : AbstractC0569y0.a(new byte[]{13, -15, -105, 56, 96, -121, 114, -81, 102, 109, -128, -60, 80, -14, -66, -23});
    }
}
