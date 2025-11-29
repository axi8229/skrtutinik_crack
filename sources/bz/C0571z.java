package bz;

import android.content.Context;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import java.io.Serializable;
import java.util.HashSet;
import okio.Utf8;

/* renamed from: bz.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0571z extends AbstractC0538n1 implements S0, B0 {
    public final Context c;
    public final Z0 d;

    public C0571z(Context context, Z0 z0) {
        super(zone.bi.mobile.fingerprint.api.f.GooglePlayProtect);
        this.c = context;
        this.d = z0;
    }

    @Override // bz.S0
    public final R0 b() {
        return new C0568y(this);
    }

    @Override // bz.B0
    public final HashSet c() {
        return N1.a(AbstractC0569y0.a(new byte[]{102, 56, -95, 68, -54, -60, 13, -101, 17, ByteSourceJsonBootstrapper.UTF8_BOM_2, 55, 81, 104, -66, -89, 50, -12, 48, -126, 93, -18, -122, 58, -121, 33, -13, -128, -46, -44, 3, -47, -113, 37, 105, -37, -103, 33, -52, -50, -19, -29, 19, -5, 89, 85, -108, 82, 105}), AbstractC0569y0.a(new byte[]{102, 56, -95, 68, -54, -60, 13, -101, 17, ByteSourceJsonBootstrapper.UTF8_BOM_2, 55, 81, 104, -66, -89, 50, -12, 48, -126, 93, -18, -122, 58, -121, 33, -13, -128, -46, -44, 3, -47, -113, 119, 106, -36, -94, 77, 75, 15, 22, 16, ByteSourceJsonBootstrapper.UTF8_BOM_1, 37, -127, -31, -56, -60, 27}), AbstractC0569y0.a(new byte[]{102, 56, -95, 68, -54, -60, 13, -101, 17, ByteSourceJsonBootstrapper.UTF8_BOM_2, 55, 81, 104, -66, -89, 50, -12, 48, -126, 93, -18, -122, 58, -121, 33, -13, -128, -46, -44, 3, -47, -113, 110, -119, -89, 112, -72, -46, -125, -95, -95, 114, 9, -87, 96, 89, 54, -2, -8, -11, 10, 57, 80, 59, -98, 83, 46, 104, 114, 67, 89, -39, -110, -115}), AbstractC0569y0.a(new byte[]{102, 56, -95, 68, -54, -60, 13, -101, 17, ByteSourceJsonBootstrapper.UTF8_BOM_2, 55, 81, 104, -66, -89, 50, -91, 1, -8, -51, 23, -62, -107, 73, 28, 124, 84, -96, 79, -40, -93, 21, 86, -10, -119, 108, -82, 13, 36, 85, 78, 34, 97, 42, 73, -25, 59, -127}));
    }

    @Override // bz.A0
    public final Z0 f() {
        return this.d;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws C0563w0 {
        S0.o.execute(new C0568y(this));
        Integer num = (Integer) a(A0.n);
        if (num != null) {
            return num;
        }
        throw new C0563w0(AbstractC0569y0.a(new byte[]{100, 85, -60, 17, 72, -58, -122, 86, -54, 14, 27, 87, 80, -42, 31, -23, -59, 101, -67, 17, 7, -96, 100, 123, Utf8.REPLACEMENT_BYTE, 95, -117, 105, -33, -24, -10, 99}));
    }
}
