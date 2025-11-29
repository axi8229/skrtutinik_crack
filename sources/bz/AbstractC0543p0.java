package bz;

import java.io.Serializable;

/* renamed from: bz.p0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0543p0 extends Exception {
    public final String a;
    public final int b;

    public AbstractC0543p0(String str, Exception exc) {
        super(str, exc);
        this.a = "";
        this.b = -1;
    }

    public final Serializable a(zone.bi.mobile.fingerprint.api.f fVar) {
        Class cls = fVar.a;
        if (cls == String.class) {
            return this.a;
        }
        if (cls == Integer.class) {
            return Integer.valueOf(this.b);
        }
        if (cls == Boolean.class) {
            return Boolean.FALSE;
        }
        if (cls == zone.bi.mobile.fingerprint.api.serialize.model.d.class) {
            return new zone.bi.mobile.fingerprint.api.serialize.model.d();
        }
        if (cls == zone.bi.mobile.fingerprint.api.serialize.model.a.class) {
            return new zone.bi.mobile.fingerprint.api.serialize.model.a();
        }
        throw new zone.bi.mobile.fingerprint.api.a("Unsupported valueClass: " + cls.getCanonicalName());
    }

    public AbstractC0543p0(String str, String str2, int i) {
        super(str);
        this.a = str2;
        this.b = i;
    }
}
