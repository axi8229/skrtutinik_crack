package com.huawei.location.crowdsourcing.common.util;

import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.ReflectionUtils;
import com.huawei.location.lite.common.util.TelephonyUtil;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class dC {
    private static final boolean yn;

    static {
        boolean z;
        if (ReflectionUtils.isSupportClass("android.telephony.TelephonyManager$CellInfoCallback")) {
            LogLocation.i("TelephonyService", "support CallBack");
            z = true;
        } else {
            LogLocation.w("TelephonyService", "not support CallBack");
            z = false;
        }
        yn = z;
    }

    private static TelephonyManager FB(Context context) {
        Object systemService = context.getSystemService("phone");
        if (systemService instanceof TelephonyManager) {
            return (TelephonyManager) systemService;
        }
        LogLocation.d("TelephonyService", "not get TELEPHONY_SERVICE");
        return null;
    }

    public static String Vw(Context context) {
        if (TelephonyUtil.isAirplaneModeOn()) {
            LogLocation.d("TelephonyService", "airplaneMode on, no mcc");
            return "";
        }
        TelephonyManager telephonyManagerFB = FB(context);
        if (telephonyManagerFB == null) {
            LogLocation.d("TelephonyService", "no TelephonyManager");
            return "";
        }
        String simOperator = telephonyManagerFB.getPhoneType() == 2 ? (telephonyManagerFB.getSimState() != 5 || telephonyManagerFB.isNetworkRoaming()) ? null : telephonyManagerFB.getSimOperator() : telephonyManagerFB.getNetworkOperator();
        if (simOperator != null && simOperator.length() >= 3) {
            return simOperator.substring(0, 3);
        }
        LogLocation.e("TelephonyService", "mcc is Empty");
        return "";
    }

    public static List<CellInfo> yn(Context context) {
        TelephonyManager telephonyManagerFB = FB(context);
        if (telephonyManagerFB == null) {
            LogLocation.d("TelephonyService", "no TelephonyManager");
            return new LinkedList();
        }
        if (Build.VERSION.SDK_INT >= 29 && yn) {
            LW.yn(telephonyManagerFB);
        }
        List<CellInfo> allCellInfo = telephonyManagerFB.getAllCellInfo();
        if (allCellInfo != null) {
            return allCellInfo;
        }
        LogLocation.d("TelephonyService", "cell info null");
        return new LinkedList();
    }
}
