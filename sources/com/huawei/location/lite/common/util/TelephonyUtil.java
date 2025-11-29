package com.huawei.location.lite.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.grs.LocationNlpGrsHelper;
import com.huawei.location.lite.common.log.LogLocation;

/* loaded from: classes3.dex */
public class TelephonyUtil {
    public static boolean checkWLANScan(Context context) {
        try {
            Object systemService = context.getApplicationContext().getSystemService("wifi");
            if (systemService instanceof WifiManager) {
                return ((WifiManager) systemService).isScanAlwaysAvailable();
            }
            return false;
        } catch (Exception unused) {
            LogLocation.e("TelephonyUtil", "isWLANScan error, system exception");
            return false;
        }
    }

    public static boolean checkWifiIsEnable(Context context) {
        try {
            Object systemService = context.getApplicationContext().getSystemService("wifi");
            if (systemService instanceof WifiManager) {
                return ((WifiManager) systemService).isWifiEnabled();
            }
            return false;
        } catch (Exception unused) {
            LogLocation.e("TelephonyUtil", "checkWifiIsEnable exception");
            return false;
        }
    }

    private static String checkedCountryCode(String str) {
        return (TextUtils.isEmpty(str) || str.length() != 2) ? "" : str;
    }

    private static String getCarMcc() {
        String str;
        if (DeviceInfoUtil.getDeviceFeature(ContextUtil.getContext()) != 8) {
            return "";
        }
        String locationIPAddress = LocationNlpGrsHelper.getLocationIPAddress();
        if (TextUtils.isEmpty(locationIPAddress)) {
            str = "getCarMcc--getLocationIPAddress--host is empty";
        } else {
            if (locationIPAddress.contains("cn")) {
                return "460";
            }
            str = "getCarMcc--host is empty";
        }
        LogLocation.w("TelephonyUtil", str);
        return "";
    }

    public static String getMcc() {
        String networkOperator;
        try {
            if (isAirplaneModeOn()) {
                LogLocation.d("TelephonyUtil", "airplaneMode on, no mcc");
                return getCarMcc();
            }
            Object systemService = ContextUtil.getHMSContext().getApplicationContext().getSystemService("phone");
            if (systemService == null) {
                LogLocation.d("TelephonyUtil", "systemService is null");
                return getCarMcc();
            }
            String str = null;
            TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
            if (telephonyManager == null) {
                LogLocation.d("TelephonyUtil", "no TelephonyManager");
                return getCarMcc();
            }
            if (telephonyManager.getPhoneType() == 2) {
                if (telephonyManager.getSimState() == 5 && !telephonyManager.isNetworkRoaming()) {
                    networkOperator = telephonyManager.getSimOperator();
                }
                return (str != null || str.length() < 3) ? getCarMcc() : str.substring(0, 3);
            }
            networkOperator = telephonyManager.getNetworkOperator();
            str = networkOperator;
            if (str != null) {
            }
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getNetworkCountryCode() {
        Object systemService;
        try {
            if (hasNoSimCard() || (systemService = ContextUtil.getHMSContext().getApplicationContext().getSystemService("phone")) == null || !(systemService instanceof TelephonyManager)) {
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            return telephonyManager.getPhoneType() != 2 ? checkedCountryCode(telephonyManager.getNetworkCountryIso()) : "";
        } catch (Exception unused) {
            LogLocation.e("TelephonyUtil", "getNetworkCountryCode exception", true);
            return "";
        }
    }

    public static String getSimCountryCode() {
        try {
            Object systemService = ContextUtil.getHMSContext().getApplicationContext().getSystemService("phone");
            if (!(systemService instanceof TelephonyManager)) {
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            return checkedCountryCode(telephonyManager.getSimState() == 5 ? telephonyManager.getSimCountryIso() : null);
        } catch (Exception unused) {
            LogLocation.e("TelephonyUtil", "getSimCountryCode exception", true);
            return "";
        }
    }

    public static boolean hasNoSimCard() {
        Object systemService = ContextUtil.getHMSContext().getApplicationContext().getSystemService("phone");
        if (systemService instanceof TelephonyManager) {
            int simState = ((TelephonyManager) systemService).getSimState();
            z = simState == 0 || simState == 1 || simState == 2 || simState == 3 || simState == 6 || simState == 7 || simState == 8;
            LogLocation.d("TelephonyUtil", "simState:" + simState);
        }
        return z;
    }

    @TargetApi(17)
    public static boolean isAirplaneModeOn() {
        return Settings.Global.getInt(ContextUtil.getContext().getApplicationContext().getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    public static boolean isSimNetworkRoaming() {
        try {
            Object systemService = ContextUtil.getHMSContext().getApplicationContext().getSystemService("phone");
            if (systemService instanceof TelephonyManager) {
                return ((TelephonyManager) systemService).isNetworkRoaming();
            }
            return false;
        } catch (Exception unused) {
            LogLocation.e("TelephonyUtil", "isSimRoaming exception", true);
            return false;
        }
    }
}
