package bz;

import android.content.Context;
import java.io.Serializable;

/* renamed from: bz.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0511f extends AbstractC0538n1 implements S0, P1 {
    public final Context c;
    public final Z0 d;
    public final zone.bi.mobile.fingerprint.api.settings.a e;

    public C0511f(Context context, Z0 z0, zone.bi.mobile.fingerprint.api.settings.a aVar) {
        super(zone.bi.mobile.fingerprint.api.f.ApplicationMD5);
        this.c = context;
        this.d = z0;
        this.e = aVar;
    }

    @Override // bz.S0
    public final R0 b() {
        return new C0508e(this);
    }

    @Override // bz.A0
    public final Z0 f() {
        return this.d;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws C0563w0 {
        String str = (String) a(A0.n);
        if (str != null) {
            return str;
        }
        S0.o.execute(new C0508e(this));
        throw new C0563w0("cachedValue == null");
    }

    @Override // bz.P1
    /* renamed from: b */
    public final zone.bi.mobile.fingerprint.api.settings.a mo2257b() {
        return this.e;
    }
}
