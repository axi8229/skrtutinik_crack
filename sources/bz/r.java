package bz;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import java.io.Serializable;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class r extends AbstractC0538n1 implements S0, B0 {
    public final Context c;
    public final Z0 d;
    public String e;
    public int f;

    public r(zone.bi.mobile.fingerprint.api.f fVar, Context context, Z0 z0) {
        super(fVar);
        this.e = "";
        this.c = context;
        this.d = z0;
    }

    @Override // bz.S0
    public final R0 b() {
        return new C0545q(this);
    }

    @Override // bz.B0
    public final HashSet c() {
        return N1.a(AbstractC0500b0.a, AbstractC0500b0.b, AbstractC0500b0.c, AbstractC0500b0.d, AbstractC0500b0.e);
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
            throw new C0564w1("!GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(mContext)");
        }
        S0.o.execute(new C0545q(this));
        throw new C0563w0("cachedValue == null");
    }
}
