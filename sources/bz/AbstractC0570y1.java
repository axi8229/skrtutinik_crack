package bz;

import android.content.Context;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;

/* renamed from: bz.y1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0570y1 {
    public static final String a = AbstractC0569y0.a(new byte[]{33, -13, -31, 105, 73, 55, -8, 64, 75, -57, -103, 6, -123, -38, -35, 99});
    public static C0549r1 b;
    public static C0509e0 c;

    public static Z0 a(int i, Context context) {
        int i2 = AbstractC0567x1.a[J1.a(i)];
        if (i2 == 1) {
            if (b == null) {
                b = new C0549r1();
            }
            return b;
        }
        if (i2 == 2) {
            if (c == null) {
                c = new C0509e0(context, a);
            }
            return c;
        }
        throw new IllegalArgumentException(AbstractC0569y0.a(new byte[]{27, ByteSourceJsonBootstrapper.UTF8_BOM_1, -14, 118, -15, -125, -103, 116, 110, 60, ByteSourceJsonBootstrapper.UTF8_BOM_2, 10, -51, 91, -21, 16, 78, 114, -39, -116, -31, -86, 109, 59, 112, -98, -11, -111, -101, 53, -57, -84}) + I1.a(i) + AbstractC0569y0.a(new byte[]{91, 12, ByteSourceJsonBootstrapper.UTF8_BOM_2, -4, -104, -21, -29, 120, 68, -111, 62, 20, -58, -43, 101, 77}));
    }
}
