package bz;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import java.io.File;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.Callable;
import okio.Utf8;

/* loaded from: classes.dex */
public final class C1 extends AbstractC0538n1 implements S0, P1 {
    public static final String[] g = {AbstractC0569y0.a(new byte[]{-4, 96, -28, -119, 69, 108, -55, 83, 86, 12, -106, -20, 39, -72, 98, -30}), AbstractC0569y0.a(new byte[]{68, -22, -23, -68, 121, 28, 46, 119, 78, 0, -105, -121, -63, 71, -57, 45}), AbstractC0569y0.a(new byte[]{-125, -23, 114, 23, -100, 31, 117, 45, -26, 95, -45, 31, -118, -90, -4, 27}), AbstractC0569y0.a(new byte[]{49, 50, 118, 34, -117, Utf8.REPLACEMENT_BYTE, -71, -18, 103, 52, 23, 71, -1, 15, -34, 67}), AbstractC0569y0.a(new byte[]{-34, -100, -67, -33, -19, 31, 61, 75, 125, 5, -24, 80, -106, -100, 23, 28}), AbstractC0569y0.a(new byte[]{-77, -106, -22, -120, -38, ByteSourceJsonBootstrapper.UTF8_BOM_2, -95, -68, -13, 4, 110, 76, -99, 52, -113, 119}), AbstractC0569y0.a(new byte[]{0, 60, -52, 2, -58, -18, -122, 36, 103, 28, -116, -35, 125, 120, -104, -38}), AbstractC0569y0.a(new byte[]{-118, -66, 21, 62, -44, 5, -84, 91, -108, 68, 11, -68, 8, 107, 108, 21}), AbstractC0569y0.a(new byte[]{-87, -32, 123, 89, -22, 9, 64, -23, 20, -23, -81, 57, -24, -121, 117, -16}), AbstractC0569y0.a(new byte[]{58, -47, 98, -61, -93, 10, -64, 112, 55, 126, -72, -97, -28, 64, 124, 84}), AbstractC0569y0.a(new byte[]{65, ByteSourceJsonBootstrapper.UTF8_BOM_1, -15, 93, -88, -78, 91, -121, -82, -45, -50, -36, -68, 27, -120, 124}), AbstractC0569y0.a(new byte[]{-77, 53, -36, -89, 126, -63, 39, -84, 8, 36, 22, 24, -55, -39, -70, 0}), AbstractC0569y0.a(new byte[]{-79, -116, 91, -37, 119, -50, 102, 107, -49, -74, 40, 47, 93, -76, -56, -120}), AbstractC0569y0.a(new byte[]{ByteSourceJsonBootstrapper.UTF8_BOM_2, -41, -77, 24, 45, 54, -96, -117, 93, 81, -42, 18, -26, -90, 106, -73}), AbstractC0569y0.a(new byte[]{-8, -16, -79, -82, -103, 59, -107, 36, 126, 81, 86, 121, 52, 57, -24, 103}), AbstractC0569y0.a(new byte[]{54, -11, Utf8.REPLACEMENT_BYTE, 25, -71, 101, 85, -97, -34, -21, -124, -56, 34, 33, -47, 89})};
    public static final String[] h = {AbstractC0569y0.a(new byte[]{99, 112, 86, 87, 115, -11, -13, -9, 123, -8, -32, 61, 50, 72, -117, 13}), AbstractC0569y0.a(new byte[]{-22, -47, 7, 96, -76, 15, 119, -61, -55, -66, -39, 123, -67, 74, -60, -3, -83, -106, -97, -10, 10, -54, -38, -46, 55, -107, -32, -91, 35, 77, -118, -127}), AbstractC0569y0.a(new byte[]{93, 12, 90, -126, 9, 48, -23, 50, -74, 77, -42, 116, -26, 85, 54, -105})};
    public static final String[] i = {AbstractC0569y0.a(new byte[]{78, -38, -6, 9, 40, 106, -73, 112, -106, 18, -96, -100, -23, 72, 87, 96})};
    public static final String[] j = {AbstractC0569y0.a(new byte[]{64, -28, 69, 60, 73, -34, 40, -60, -18, 11, -5, 45, 81, -71, -11, 69, -83, 1, -97, -114, -84, 49, -21, -35, -96, -107, 77, -98, 43, -7, 99, 92}), AbstractC0569y0.a(new byte[]{-26, 30, -112, -71, -40, -124, -86, ByteSourceJsonBootstrapper.UTF8_BOM_3, -48, 94, -110, 126, 27, 1, -48, 49, -10, 6, 67, -23, -25, 64, -109, 39, 39, -119, -25, 12, -64, 117, -86, -90})};
    public static final String[] k = {AbstractC0569y0.a(new byte[]{7, 117, 44, 36, -23, 74, -50, -54, -2, 91, -10, -120, 86, 12, 108, -118})};
    public static final String[] l = {AbstractC0569y0.a(new byte[]{-44, -46, -122, 123, -83, -26, 43, -67, 38, 86, 96, -8, -122, -42, -41, -45, 93, 100, 11, 70, 18, -112, -102, 107, 18, -94, 86, -104, -26, -84, -68, -24}), AbstractC0569y0.a(new byte[]{-10, 9, 64, -104, -71, -5, 94, -62, -61, 93, -66, 118, -21, -96, 86, -24})};
    public static final String[] m = {AbstractC0569y0.a(new byte[]{17, -86, 112, 18, -68, 36, -97, 100, 72, -52, 17, -41, 38, 123, -5, -106}), AbstractC0569y0.a(new byte[]{-14, -3, -122, -123, -45, 37, -84, 25, -34, -40, 115, -79, 111, -108, -14, 125})};
    public static final String[] p = {AbstractC0569y0.a(new byte[]{-72, -72, -100, -34, -28, -75, 124, -85, -18, 126, 84, 46, 120, -30, 28, -71}), AbstractC0569y0.a(new byte[]{48, 74, -21, -88, -89, 123, 21, 62, 103, 14, -85, -128, -41, -88, 118, 120}), AbstractC0569y0.a(new byte[]{13, 8, 84, -110, -128, 19, -37, -89, 7, 32, 32, -106, 16, 39, -53, -47})};
    public static final String q = AbstractC0569y0.a(new byte[]{-73, 82, 40, -103, 31, 86, 108, 95, 20, -42, -87, -13, 40, -34, -39, -38});
    public static final B1[] r = {new B1(AbstractC0569y0.a(new byte[]{-100, 124, 23, 96, 78, 109, 96, 6, -121, 56, 90, -66, 99, 38, 8, 59}), null), new B1(AbstractC0569y0.a(new byte[]{122, 58, 100, ByteSourceJsonBootstrapper.UTF8_BOM_3, 25, -108, 54, 22, 46, -96, -6, -105, -6, -109, -53, -117, -45, -47, 19, 93, -50, -117, 121, 21, -83, -104, 80, -94, 36, 96, -51, 89}), null), new B1(AbstractC0569y0.a(new byte[]{-56, -83, -120, 8, -77, 74, 108, 2, -45, -112, -25, -122, -83, 110, 84, 40, -90, 61, 25, 23, 59, -19, 11, -5, 120, -55, -73, -4, -94, 79, -58, -54}), null), new B1(AbstractC0569y0.a(new byte[]{75, -48, -115, 116, -115, -22, 84, -127, 58, 84, 76, 113, -23, -111, 73, 44, -127, 56, -28, -24, -46, 121, -8, 37, -64, -54, 120, 75, 60, 13, -51, 32}), null), new B1(AbstractC0569y0.a(new byte[]{10, 66, -3, 1, -102, 75, -24, -85, 11, -4, -26, 123, -113, -91, 24, 84, 88, -48, -70, 47, -48, -77, 58, -49, 36, 127, -28, 121, 76, 18, -19, -44}), null), new B1(AbstractC0569y0.a(new byte[]{-111, 109, -113, -33, -9, -60, -107, -55, -87, 24, 18, 72, 51, -97, 66, -93}), AbstractC0569y0.a(new byte[]{-42, 112, -12, -114, 58, -61, 48, 45, 64, -57, -25, -104, -11, -10, -64, -53})), new B1(AbstractC0569y0.a(new byte[]{-73, 74, -80, 9, 37, -122, 35, 29, 70, 109, -109, 99, -10, -9, -83, 97}), AbstractC0569y0.a(new byte[]{-42, 112, -12, -114, 58, -61, 48, 45, 64, -57, -25, -104, -11, -10, -64, -53})), new B1(AbstractC0569y0.a(new byte[]{15, -73, -59, 52, 3, -115, 26, 117, -125, -126, 55, 28, 9, Utf8.REPLACEMENT_BYTE, -114, 101}), AbstractC0569y0.a(new byte[]{7, 117, 44, 36, -23, 74, -50, -54, -2, 91, -10, -120, 86, 12, 108, -118})), new B1(AbstractC0569y0.a(new byte[]{-114, 51, 122, -39, -124, -83, -112, 15, -5, 74, -121, -38, 4, ByteSourceJsonBootstrapper.UTF8_BOM_1, 83, -12, 27, -82, 43, 9, -9, -42, Utf8.REPLACEMENT_BYTE, -57, -22, ByteSourceJsonBootstrapper.UTF8_BOM_2, -99, -24, -7, 40, -120, -10}), null), new B1(AbstractC0569y0.a(new byte[]{102, 39, -40, -51, -106, 39, 112, 123, -52, -16, -55, -19, -84, -28, 61, 74, 97, 71, 102, 36, 118, -66, -72, 53, -28, 6, 97, ByteSourceJsonBootstrapper.UTF8_BOM_2, -21, 92, -39, 40}), null), new B1(AbstractC0569y0.a(new byte[]{21, 122, 36, -80, 61, -76, 77, -8, 106, -9, 28, 8, 15, 118, -91, -47}), AbstractC0569y0.a(new byte[]{-77, 86, -116, 124, 95, -28, -38, 31, 38, -28, -70, 38, 83, 89, -40, 83})), new B1(AbstractC0569y0.a(new byte[]{42, -9, 82, -61, 88, 110, -101, 121, 104, 29, -26, -2, 56, 59, -33, -92, -103, 120, 108, 100, 1, 7, -111, 102, 23, -59, 89, -33, -124, 3, -43, -112}), AbstractC0569y0.a(new byte[]{110, 66, 32, 1, -126, 85, 51, -42, 28, 34, -119, 103, -88, -43, 36, 9})), new B1(AbstractC0569y0.a(new byte[]{-91, -83, 83, -11, 72, -107, 71, -95, -117, -100, -55, -83, 55, 95, 98, -93, 2, -31, -49, -104, -73, 23, -58, 4, 123, 119, 7, 31, -43, 85, 89, 30}), AbstractC0569y0.a(new byte[]{-3, 100, -52, 92, -38, -83, -74, -126, 38, 32, -72, -30, 51, 104, -125, 35})), new B1(AbstractC0569y0.a(new byte[]{28, -28, -54, -84, -16, 14, -59, -83, 41, 103, 74, 106, 49, 98, 54, ByteSourceJsonBootstrapper.UTF8_BOM_3}), AbstractC0569y0.a(new byte[]{-3, 100, -52, 92, -38, -83, -74, -126, 38, 32, -72, -30, 51, 104, -125, 35})), new B1(AbstractC0569y0.a(new byte[]{-81, -90, -81, -3, -113, 39, -89, 4, -71, -120, -50, 4, -62, -46, -15, 100}), null)};
    public static final String[] s = {AbstractC0569y0.a(new byte[]{102, 56, -95, 68, -54, -60, 13, -101, 17, ByteSourceJsonBootstrapper.UTF8_BOM_2, 55, 81, 104, -66, -89, 50, -75, -91, 38, -44, 19, -51, -94, 120, 120, 81, -66, 102, 74, 38, 38, -26, 0, -14, -64, 35, -23, 72, 35, 119, -18, -54, 58, 100, 81, -126, -86, -80}), AbstractC0569y0.a(new byte[]{-48, -49, -82, 76, -50, 12, -58, 3, 118, 6, -10, 40, -125, 54, 3, -122}), AbstractC0569y0.a(new byte[]{17, -74, 100, -64, 7, -14, 42, -122, 112, -5, 87, 19, -67, -96, 13, -112})};
    public static final File[] t = {new File(AbstractC0569y0.a(new byte[]{-90, 37, -40, 127, -116, 106, 18, 50, 62, 49, -12, 50, 60, 122, -6, 58, -41, 59, -113, -51, 100, -117, 45, -108, 50, 124, 0, 58, 52, 80, 123, 114})), new File(AbstractC0569y0.a(new byte[]{47, -93, -91, -61, 78, -46, 65, -18, -103, 84, 105, 27, -84, 70, 49, 14}))};
    public final Context c;
    public final Z0 d;
    public final TelephonyManager e;
    public final zone.bi.mobile.fingerprint.api.settings.a f;

    public C1(Context context, Z0 z0, TelephonyManager telephonyManager, zone.bi.mobile.fingerprint.api.settings.a aVar) {
        super(zone.bi.mobile.fingerprint.api.f.Emulator);
        this.c = context;
        this.d = z0;
        this.e = telephonyManager;
        this.f = aVar;
    }

    @Override // bz.S0
    public final R0 b() {
        return new A1(this);
    }

    public final Boolean c(final PackageManager packageManager) {
        return (Boolean) a(new Callable() { // from class: bz.C1$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C1.b(packageManager);
            }
        });
    }

    @Override // bz.A0
    public final Z0 f() {
        return this.d;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws C0563w0 {
        Integer num = (Integer) a(A0.n);
        if (num != null) {
            return num;
        }
        S0.o.execute(new A1(this));
        throw new C0563w0(AbstractC0569y0.a(new byte[]{100, 85, -60, 17, 72, -58, -122, 86, -54, 14, 27, 87, 80, -42, 31, -23, -59, 101, -67, 17, 7, -96, 100, 123, Utf8.REPLACEMENT_BYTE, 95, -117, 105, -33, -24, -10, 99}));
    }

    public final boolean l() {
        if (Build.VERSION.SDK_INT > 28) {
            return false;
        }
        final PackageManager packageManager = this.c.getPackageManager();
        Boolean bool = (Boolean) a(new Callable() { // from class: bz.C1$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.telephony"));
            }
        });
        Objects.requireNonNull(bool);
        return bool.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x019b A[EXC_TOP_SPLITTER, PHI: r7
  0x019b: PHI (r7v12 java.io.BufferedReader) = (r7v9 java.io.BufferedReader), (r7v14 java.io.BufferedReader) binds: [B:110:0x01b4, B:95:0x0198] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0263 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(bz.C1 r13) {
        /*
            Method dump skipped, instructions count: 722
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bz.C1.a(bz.C1):boolean");
    }

    public static /* synthetic */ Boolean b(PackageManager packageManager) throws PackageManager.NameNotFoundException {
        for (String str : s) {
            try {
                packageManager.getPackageInfo(str, 128);
                return Boolean.TRUE;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return Boolean.FALSE;
    }

    @Override // bz.P1
    /* renamed from: b, reason: collision with other method in class */
    public final zone.bi.mobile.fingerprint.api.settings.a mo2257b() {
        return this.f;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(bz.C1 r7) {
        /*
            Method dump skipped, instructions count: 670
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bz.C1.b(bz.C1):boolean");
    }

    public static boolean a(String[] strArr) {
        for (String str : strArr) {
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }
}
