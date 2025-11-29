package bz;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class V1 extends AbstractC0538n1 {
    public final Context c;
    public final TelephonyManager d;

    public V1(Context context, TelephonyManager telephonyManager) {
        super(zone.bi.mobile.fingerprint.api.f.MCC);
        this.c = context;
        this.d = telephonyManager;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws e2 {
        TelephonyManager telephonyManager = this.d;
        if (telephonyManager == null) {
            throw new e2("mTelephonyManager == null");
        }
        if (telephonyManager.getSimState() == 1) {
            throw new e2("Sim card is not inserted");
        }
        String networkOperator = this.d.getNetworkOperator();
        if (networkOperator.equals("00000")) {
            return "000";
        }
        int i = 0;
        try {
            i = !networkOperator.isEmpty() ? Integer.parseInt(networkOperator.substring(0, 3)) : this.c.getResources().getConfiguration().mcc;
        } catch (Exception unused) {
        }
        if (i != 0) {
            return String.valueOf(i);
        }
        throw new e2("mcc == 0");
    }
}
