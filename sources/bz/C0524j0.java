package bz;

import android.os.Build;
import android.telephony.TelephonyManager;
import java.io.Serializable;

/* renamed from: bz.j0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0524j0 extends AbstractC0538n1 implements A0 {
    public final Z0 c;
    public final TelephonyManager d;

    public C0524j0(Z0 z0, TelephonyManager telephonyManager) {
        super(zone.bi.mobile.fingerprint.api.f.SimCard);
        this.c = z0;
        this.d = telephonyManager;
    }

    @Override // bz.A0
    public final Z0 f() {
        return this.c;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws e2 {
        if (this.d == null) {
            throw new e2("mTelephonyManager == null");
        }
        String str = (String) a(100L);
        if (str != null) {
            return str;
        }
        if (Build.VERSION.SDK_INT < 26) {
            int simState = this.d.getSimState();
            String str2 = (simState == 2 || simState == 3 || simState == 4 || simState == 5) ? "1" : "0";
            a(str2);
            return str2;
        }
        int simState2 = this.d.getSimState(0);
        int simState3 = this.d.getSimState(1);
        boolean z = simState2 == 2 || simState2 == 3 || simState2 == 4 || simState2 == 5;
        boolean z2 = simState3 == 2 || simState3 == 3 || simState3 == 4 || simState3 == 5;
        return (z || z2) ? ((!z || z2) && z) ? "2" : "1" : "0";
    }
}
