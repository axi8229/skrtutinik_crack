package bz;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.io.Serializable;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class K1 extends AbstractC0538n1 implements T0 {
    public final Context c;
    public final TelephonyManager d;

    public K1(Context context, TelephonyManager telephonyManager) {
        super(zone.bi.mobile.fingerprint.api.f.CellTowerId);
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
                int cid = gsmCellLocation.getCid();
                if (cid != -1) {
                    return String.valueOf(cid);
                }
                throw new e2("cid == -1 == unknown");
            } catch (Exception unused) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) this.d.getCellLocation();
                if (cdmaCellLocation == null) {
                    throw new e2("cdmaCellLocation == null");
                }
                int baseStationId = cdmaCellLocation.getBaseStationId();
                if (baseStationId != -1) {
                    return String.valueOf(baseStationId);
                }
                throw new e2("cid == -1 == unknown");
            }
        } catch (Exception e) {
            throw new e2(e.getMessage());
        }
    }
}
