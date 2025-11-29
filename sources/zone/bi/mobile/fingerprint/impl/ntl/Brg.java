package zone.bi.mobile.fingerprint.impl.ntl;

import android.content.Context;
import bz.C0;
import bz.Q1;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes5.dex */
public final class Brg {
    public static final String a = Q1.a(new byte[]{-1, 40, -94, 5, 77, -11, 103, -31, -41, -55, 57, 18, 89, 110, 74, 79});
    public static final String b = Q1.a(new byte[]{-100, -40, -104, 25, -127, 73, -43, 31, -115, -18, -110, -127, -127, 6, -35, -64, 37, 32, -110, -21, 1, -42, -123, 58, 64, 13, 120, -8, 32, 100, -9, -13});
    public static final String[] c = {Q1.a(new byte[]{-37, -68, 47, 74, 78, 24, 9, 61, 112, 10, 11, -123, 122, 123, 20, 33}), Q1.a(new byte[]{-58, 59, 96, 36, -122, 6, 112, -26, -79, -114, 101, -126, 90, 90, -67, 51}), Q1.a(new byte[]{-34, -118, -110, 119, 106, -8, 12, 127, ByteSourceJsonBootstrapper.UTF8_BOM_1, 34, 6, -75, -71, -36, -124, -109})};

    private static native int ff();

    private static native int fm();

    private static native int fs();

    public final int a() {
        try {
            Iterator it = C0.a(new File(b)).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                for (String str2 : c) {
                    if (str.contains(str2)) {
                        return 2;
                    }
                }
            }
            return fm();
        } catch (IOException unused) {
            return -1;
        }
    }

    public final int b() {
        return fs();
    }

    public final int c() {
        return ff();
    }

    public final boolean a(Context context) {
        boolean z;
        String str = context.getApplicationInfo().nativeLibraryDir;
        try {
            System.loadLibrary(a);
            z = true;
        } catch (UnsatisfiedLinkError unused) {
            z = false;
        }
        if (z) {
            return z;
        }
        try {
            System.load(String.format(Locale.ROOT, Q1.a(new byte[]{3, 91, -7, -72, -3, 114, -61, 100, -36, 97, 93, 87, 95, -5, 43, -88}), str, a));
            return true;
        } catch (UnsatisfiedLinkError unused2) {
            return false;
        }
    }
}
