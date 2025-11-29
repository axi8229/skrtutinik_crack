package bz;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.io.Serializable;
import java.util.HashSet;

/* renamed from: bz.o0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0540o0 extends AbstractC0538n1 implements T0, Q0 {
    public final Context c;
    public final TelephonyManager d;

    public C0540o0(Context context, TelephonyManager telephonyManager) {
        super(zone.bi.mobile.fingerprint.api.f.SIM_ID);
        this.c = context;
        this.d = telephonyManager;
    }

    @Override // bz.T0
    public final Context a() {
        return this.c;
    }

    @Override // bz.T0
    public final HashSet e() {
        return N1.a(R1.READ_PHONE_STATE);
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws C0564w1 {
        TelephonyManager telephonyManager = this.d;
        if (telephonyManager == null) {
            throw new C0564w1("tel == null");
        }
        String subscriberId = telephonyManager.getSubscriberId();
        if (subscriberId != null) {
            return subscriberId;
        }
        throw new C0564w1("subscriberId == null");
    }
}
