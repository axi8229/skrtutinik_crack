package com.huawei.location.crowdsourcing.common.util;

import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import android.telephony.TelephonyManager$CellInfoCallback;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager$Api33Ext5Impl$$ExternalSyntheticLambda11;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.List;

/* loaded from: classes3.dex */
class LW {
    private static final byte[] yn = new byte[0];

    static class yn extends TelephonyManager$CellInfoCallback {
        yn() {
        }

        public void onCellInfo(List<CellInfo> list) {
            synchronized (LW.yn) {
                LW.yn.notifyAll();
            }
        }
    }

    static void yn(TelephonyManager telephonyManager) {
        String str;
        String str2;
        yn ynVar = new yn();
        byte[] bArr = yn;
        synchronized (bArr) {
            try {
                telephonyManager.requestCellInfoUpdate(new MeasurementManager$Api33Ext5Impl$$ExternalSyntheticLambda11(), ynVar);
                bArr.wait(1000L);
            } catch (InterruptedException unused) {
                str = "RefreshByCellInfoCallback";
                str2 = "Get cell sleep interrupted!";
                LogLocation.e(str, str2);
            } catch (Exception unused2) {
                str = "RefreshByCellInfoCallback";
                str2 = "Request cellInfoUpdate failed";
                LogLocation.e(str, str2);
            }
        }
    }
}
