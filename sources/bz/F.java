package bz;

import android.content.Context;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class F extends AbstractC0538n1 implements S0 {
    public static final String f = AbstractC0569y0.a(new byte[]{83, 21, -68, -78, ByteSourceJsonBootstrapper.UTF8_BOM_1, -29, 6, -110, -41, -34, 111, -30, 62, 32, -28, 105});
    public static final String g = AbstractC0569y0.a(new byte[]{-41, -82, -90, 33, 121, -106, 34, 49, -105, 23, 124, 126, 127, 14, 84, -39, 5, 48, -42, -104, 117, 46, -57, -70, 95, 36, 14, 15, 35, 72, 43, -41, -77, -55, 121, 111, 119, -108, -41, 33, 105, -31, 108, 56, 116, -19, -116, -82});
    public final String[] c;
    public final Context d;
    public final Z0 e;

    public F(Context context, Z0 z0) {
        super(zone.bi.mobile.fingerprint.api.f.GoogleServicesParameters);
        this.c = new String[]{f};
        this.d = context;
        this.e = z0;
    }

    @Override // bz.S0
    public final R0 b() {
        return new E(this);
    }

    @Override // bz.A0
    public final Z0 f() {
        return this.e;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        zone.bi.mobile.fingerprint.api.serialize.model.a aVar = new zone.bi.mobile.fingerprint.api.serialize.model.a();
        zone.bi.mobile.fingerprint.api.f fVar = zone.bi.mobile.fingerprint.api.f.GoogleServicesDeviceId;
        Z0 z0 = this.e;
        long millis = TimeUnit.DAYS.toMillis(30L);
        C0572z0 c0572z0A = z0.a(fVar);
        aVar.put("GoogleServicesDeviceId", (c0572z0A == null || c0572z0A.b + millis <= System.currentTimeMillis()) ? null : c0572z0A.a);
        return aVar;
    }
}
