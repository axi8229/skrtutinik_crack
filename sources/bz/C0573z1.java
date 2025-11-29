package bz;

import java.util.Locale;

/* renamed from: bz.z1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0573z1 {
    public final T1 a;

    public C0573z1(T1 t1) {
        this.a = t1;
    }

    public final void a(zone.bi.mobile.fingerprint.api.f fVar, AbstractC0543p0 abstractC0543p0) {
        int i;
        zone.bi.mobile.fingerprint.api.g gVar = zone.bi.mobile.fingerprint.api.g.Info;
        if ((abstractC0543p0 instanceof H0) || (abstractC0543p0 instanceof C0564w1)) {
            gVar = zone.bi.mobile.fingerprint.api.g.Warning;
            i = 3;
        } else {
            i = 2;
        }
        T1 t1 = this.a;
        String message = abstractC0543p0.getMessage();
        Locale locale = Locale.ROOT;
        t1.a(gVar, fVar + ":" + message, i);
    }

    public final void a(zone.bi.mobile.fingerprint.api.g gVar, String str, int i) {
        zone.bi.mobile.fingerprint.api.f fVar = zone.bi.mobile.fingerprint.api.f.Compromised;
        T1 t1 = this.a;
        Locale locale = Locale.ROOT;
        t1.a(gVar, fVar + ":" + str, i);
    }
}
