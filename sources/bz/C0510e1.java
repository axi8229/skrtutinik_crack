package bz;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.io.Serializable;
import java.util.HashSet;

/* renamed from: bz.e1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0510e1 extends AbstractC0538n1 implements T0 {
    public final Context c;
    public final TelephonyManager d;

    public C0510e1(Context context, TelephonyManager telephonyManager) {
        super(zone.bi.mobile.fingerprint.api.f.LocationAreaCode);
        this.c = context;
        this.d = telephonyManager;
    }

    @Override // bz.T0
    public final Context a() {
        return this.c;
    }

    @Override // bz.T0
    public final HashSet e() {
        return N1.a(R1.ACCESS_FINE_LOCATION);
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws e2 {
        TelephonyManager telephonyManager = this.d;
        if (telephonyManager == null) {
            throw new e2("mTelephonyManager == null");
        }
        try {
            try {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                if (gsmCellLocation == null) {
                    throw new e2("gsmCellLocation == null");
                }
                int lac = gsmCellLocation.getLac();
                if (lac != -1) {
                    return String.valueOf(lac);
                }
                throw new e2("lac == -1 == unknown");
            } catch (Exception unused) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) this.d.getCellLocation();
                if (cdmaCellLocation == null) {
                    throw new e2("cdmaCellLocation == null");
                }
                int networkId = cdmaCellLocation.getNetworkId();
                if (networkId != -1) {
                    return String.valueOf(networkId);
                }
                throw new e2("lac == -1 == unknown");
            }
        } catch (Exception e) {
            throw new e2(e.getMessage());
        }
    }
}
