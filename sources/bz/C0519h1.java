package bz;

import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import zone.bi.mobile.fingerprint.impl.ntl.Brg;

/* renamed from: bz.h1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0519h1 implements InterfaceC0544p1 {
    public final G a = c();
    public Brg b;

    public static G c() {
        return new G();
    }

    public final synchronized boolean a() {
        return this.b != null;
    }

    public final Brg b() {
        if (a()) {
            return this.b;
        }
        throw new zone.bi.mobile.fingerprint.api.a(Q1.a(new byte[]{95, 120, -84, 52, -93, 62, ByteSourceJsonBootstrapper.UTF8_BOM_1, 79, 111, -107, -75, 115, 105, 55, -39, 60, 105, -104, ByteSourceJsonBootstrapper.UTF8_BOM_1, -81, -57, -44, 86, 117, -30, -81, 61, -41, 32, -24, 71, 38, 19, 26, 1, 78, 38, -87, 106, 5, -10, 112, 86, -92, 41, 86, -27, 3}));
    }
}
