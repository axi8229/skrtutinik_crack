package bz;

import android.content.Context;
import android.telephony.TelephonyManager;

/* renamed from: bz.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0562w extends AbstractC0538n1 {
    public final Context c;
    public final Z0 d;
    public final TelephonyManager e;

    public C0562w(Context context, Z0 z0, TelephonyManager telephonyManager) {
        super(zone.bi.mobile.fingerprint.api.f.AgentSignalStrengthCellular);
        this.c = context;
        this.d = z0;
        this.e = telephonyManager;
    }

    public final void a(String str) {
        C0572z0 c0572z0;
        Z0 z0 = this.d;
        zone.bi.mobile.fingerprint.api.f fVar = zone.bi.mobile.fingerprint.api.f.AgentSignalTypeCellular;
        if (str != null) {
            z0.getClass();
            c0572z0 = new C0572z0(str);
        } else {
            c0572z0 = null;
        }
        z0.a(fVar, c0572z0);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0184 A[SYNTHETIC] */
    @Override // bz.AbstractC0538n1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.Serializable h() throws bz.C0563w0, javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, bz.e2, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instructions count: 762
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bz.C0562w.h():java.io.Serializable");
    }

    public final String l() {
        Z0 z0 = this.d;
        zone.bi.mobile.fingerprint.api.f fVar = zone.bi.mobile.fingerprint.api.f.AgentSignalTypeCellular;
        long j = A0.n;
        C0572z0 c0572z0A = z0.a(fVar);
        return (String) ((c0572z0A == null || c0572z0A.b + j <= System.currentTimeMillis()) ? null : c0572z0A.a);
    }
}
