package bz;

import android.content.Context;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.google.android.gms.common.GoogleApiAvailability;
import java.io.Serializable;
import java.util.HashSet;
import okio.Utf8;

/* renamed from: bz.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0499b extends AbstractC0538n1 implements S0, B0 {
    public final Context c;
    public final Z0 d;

    public C0499b(Context context, Z0 z0) {
        super(zone.bi.mobile.fingerprint.api.f.AdvertiserId);
        this.c = context;
        this.d = z0;
    }

    @Override // bz.S0
    public final R0 b() {
        return new C0496a(this);
    }

    @Override // bz.B0
    public final HashSet c() {
        return N1.a(AbstractC0569y0.a(new byte[]{102, 56, -95, 68, -54, -60, 13, -101, 17, ByteSourceJsonBootstrapper.UTF8_BOM_2, 55, 81, 104, -66, -89, 50, 32, -82, 22, -127, -13, ByteSourceJsonBootstrapper.UTF8_BOM_3, 35, -48, -90, 19, 81, 111, -73, 29, -95, -86, -122, -45, 121, 114, -39, 43, 3, 9, -92, 43, 86, 115, 14, 124, 64, -71, -37, 70, 73, 124, -5, -115, 40, 118, 127, -72, -13, 47, -63, 125, 14, -91}), AbstractC0569y0.a(new byte[]{102, 56, -95, 68, -54, -60, 13, -101, 17, ByteSourceJsonBootstrapper.UTF8_BOM_2, 55, 81, 104, -66, -89, 50, 123, -92, 114, -11, -88, -67, 46, -25, 0, -115, 99, -43, 45, -10, -81, -6, 47, 32, 28, 23, -1, 76, -88, 96, -102, -103, 126, 3, 16, -103, -113, 23, -93, 121, 27, 12, 116, 52, 38, 86, 20, 64, -73, -97, 42, 82, 50, 77}), AbstractC0569y0.a(new byte[]{102, 56, -95, 68, -54, -60, 13, -101, 17, ByteSourceJsonBootstrapper.UTF8_BOM_2, 55, 81, 104, -66, -89, 50, 22, 48, 61, -22, -87, -23, 121, 0, 46, -12, -125, -60, 107, 102, 91, -12, -85, 62, -37, 51, -24, -76, 16, 24, 117, ByteSourceJsonBootstrapper.UTF8_BOM_3, -83, 107, -43, -44, -29, 26}), AbstractC0569y0.a(new byte[]{102, 56, -95, 68, -54, -60, 13, -101, 17, ByteSourceJsonBootstrapper.UTF8_BOM_2, 55, 81, 104, -66, -89, 50, 32, -82, 22, -127, -13, ByteSourceJsonBootstrapper.UTF8_BOM_3, 35, -48, -90, 19, 81, 111, -73, 29, -95, -86, -46, 39, 13, 95, 59, 23, -35, 44, -70, -119, 70, 43, 107, 13, 111, 59, -34, 115, 29, 121, ByteSourceJsonBootstrapper.UTF8_BOM_3, 78, -53, -88, 19, ByteSourceJsonBootstrapper.UTF8_BOM_1, -83, 66, -76, 39, -56, 85, 9, -128, -119, 117, 110, -81, 83, 29, 46, -62, 96, 85, 32, 19, -24, -52}), AbstractC0569y0.a(new byte[]{102, 56, -95, 68, -54, -60, 13, -101, 17, ByteSourceJsonBootstrapper.UTF8_BOM_2, 55, 81, 104, -66, -89, 50, 32, -82, 22, -127, -13, ByteSourceJsonBootstrapper.UTF8_BOM_3, 35, -48, -90, 19, 81, 111, -73, 29, -95, -86, -46, 39, 13, 95, 59, 23, -35, 44, -70, -119, 70, 43, 107, 13, 111, 59, 21, -97, 122, 68, -64, 19, -24, Utf8.REPLACEMENT_BYTE, -121, -100, 43, -109, 123, 111, 116, 28, 52, -51, 57, -33, 109, -18, 31, -121, 79, -21, 11, -25, -50, -43, -54, 41}));
    }

    @Override // bz.A0
    public final Z0 f() {
        return this.d;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws C0563w0, C0564w1 {
        String str = (String) a(A0.n);
        if (str != null && !str.equals("0")) {
            return str;
        }
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.c) != 0) {
            throw new C0564w1(AbstractC0569y0.a(new byte[]{66, 69, 13, -59, -16, -103, -25, -32, 89, 21, -123, 104, -62, -98, 31, -43, 53, -5, -77, 24, -47, -42, -77, 87, -15, 92, 104, -111, 80, 36, 11, -6, 95, -73, 15, -9, -41, -2, 43, 103, 6, -108, -6, 115, -9, -45, -107, -67, 89, -124, 16, -95, 34, -27, 81, -38, 41, -31, -31, -42, 23, 122, -13, -52, -114, -10, 112, 8, -48, -106, -119, -55, -110, -83, 36, -45, -51, -68, 14, 88}));
        }
        S0.o.execute(new C0496a(this));
        throw new C0563w0(AbstractC0569y0.a(new byte[]{100, 85, -60, 17, 72, -58, -122, 86, -54, 14, 27, 87, 80, -42, 31, -23, -59, 101, -67, 17, 7, -96, 100, 123, Utf8.REPLACEMENT_BYTE, 95, -117, 105, -33, -24, -10, 99}));
    }
}
