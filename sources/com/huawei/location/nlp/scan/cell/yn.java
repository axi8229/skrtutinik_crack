package com.huawei.location.nlp.scan.cell;

import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import android.telephony.TelephonyManager$CellInfoCallback;
import com.huawei.location.lite.common.android.context.ContextUtil;
import java.util.List;

/* loaded from: classes3.dex */
public class yn {
    private TelephonyManager Vw;
    private Context yn;

    public interface Vw {
        void yn(List<CellInfo> list);
    }

    /* renamed from: com.huawei.location.nlp.scan.cell.yn$yn, reason: collision with other inner class name */
    class C0093yn extends TelephonyManager$CellInfoCallback {
        final /* synthetic */ Vw yn;

        C0093yn(yn ynVar, Vw vw) {
            this.yn = vw;
        }

        public void onCellInfo(List<CellInfo> list) {
            this.yn.yn(list);
        }
    }

    public yn() {
        Context context = ContextUtil.getContext();
        this.yn = context;
        Object systemService = context.getSystemService("phone");
        if (systemService instanceof TelephonyManager) {
            this.Vw = (TelephonyManager) systemService;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void yn(com.huawei.location.nlp.scan.cell.yn.Vw r5) {
        /*
            r4 = this;
            android.telephony.TelephonyManager r0 = r4.Vw
            java.lang.String r1 = "CellScanManager"
            if (r0 != 0) goto L1d
            android.content.Context r0 = r4.yn
            java.lang.String r2 = "phone"
            java.lang.Object r0 = r0.getSystemService(r2)
            boolean r2 = r0 instanceof android.telephony.TelephonyManager
            if (r2 == 0) goto L17
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            r4.Vw = r0
            goto L1d
        L17:
            java.lang.String r5 = "telephonyManager is null"
        L19:
            com.huawei.location.lite.common.log.LogLocation.e(r1, r5)
            return
        L1d:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r0 < r2) goto L48
            android.content.Context r0 = r4.yn
            java.lang.String r2 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r0 = com.huawei.location.lite.common.util.PermissionUtil.checkSelfPermission(r0, r2)
            if (r0 != 0) goto L30
            java.lang.String r5 = "do not ACCESS_FINE_LOCATION"
            goto L19
        L30:
            android.telephony.TelephonyManager r0 = r4.Vw     // Catch: java.lang.Exception -> L43
            com.huawei.location.lite.common.util.ExecutorUtil r2 = com.huawei.location.lite.common.util.ExecutorUtil.getInstance()     // Catch: java.lang.Exception -> L43
            java.util.concurrent.ExecutorService r2 = r2.getExecutor()     // Catch: java.lang.Exception -> L43
            com.huawei.location.nlp.scan.cell.yn$yn r3 = new com.huawei.location.nlp.scan.cell.yn$yn     // Catch: java.lang.Exception -> L43
            r3.<init>(r4, r5)     // Catch: java.lang.Exception -> L43
            com.group_ib.sdk.w0$$ExternalSyntheticApiModelOutline0.m(r0, r2, r3)     // Catch: java.lang.Exception -> L43
            goto L51
        L43:
            java.lang.String r0 = "requestCellInfoUpdate exception"
            com.huawei.location.lite.common.log.LogLocation.e(r1, r0)
        L48:
            android.telephony.TelephonyManager r0 = r4.Vw
            java.util.List r0 = r0.getAllCellInfo()
            r5.yn(r0)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.nlp.scan.cell.yn.yn(com.huawei.location.nlp.scan.cell.yn$Vw):void");
    }
}
