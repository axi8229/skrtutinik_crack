package com.huawei.location.lite.common.util.country;

import android.text.TextUtils;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.TelephonyUtil;

/* loaded from: classes3.dex */
public class CountryCodeUtil {
    public static String getLocationCountryCode() {
        if (TelephonyUtil.isAirplaneModeOn()) {
            LogLocation.d("CountryCodeUtil", "airplane Mode is on");
            return "UNKNOWN";
        }
        String networkCountryCode = TelephonyUtil.getNetworkCountryCode();
        if (TextUtils.isEmpty(networkCountryCode) && !TelephonyUtil.isSimNetworkRoaming()) {
            networkCountryCode = TelephonyUtil.getSimCountryCode();
        }
        if (!TextUtils.isEmpty(networkCountryCode)) {
            return networkCountryCode;
        }
        LogLocation.d("CountryCodeUtil", "get countryCode is UNKNOWN");
        return "UNKNOWN";
    }

    public static boolean isCodeValidate(String str) {
        return (TextUtils.isEmpty(str) || "UNKNOWN".equals(str)) ? false : true;
    }
}
