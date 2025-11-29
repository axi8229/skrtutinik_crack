package com.huawei.location.lite.common.util;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class SystemPropertiesUtil {
    private static volatile String androidVersion;
    private static volatile String characteristics;
    private static volatile String emuiVerion;
    private static volatile String fullVersionId;
    private static Map<String, String> honorProMap;
    private static volatile String platform;
    private static volatile String region;

    public static String get(String str, String str2) {
        Object objInvoke;
        try {
            objInvoke = ReflectionUtils.invoke(null, ReflectionUtils.getMethod(ReflectionUtils.getClass("android.os.SystemProperties"), "get", String.class, String.class), str, str2);
        } catch (Exception unused) {
            LogLocation.e("SystemPropertiesUtil", "get SystemProperties Exception");
        }
        String str3 = objInvoke instanceof String ? (String) objInvoke : str2;
        if (TextUtils.equals(str3, str2)) {
            String honorProKey = getHonorProKey(str);
            if (!TextUtils.isEmpty(honorProKey)) {
                return get(honorProKey, str2);
            }
        }
        return str3;
    }

    public static String getAndroidVersion() {
        if (!TextUtils.isEmpty(androidVersion)) {
            return androidVersion;
        }
        androidVersion = get("ro.build.version.release", "NULL");
        return androidVersion;
    }

    public static String getCharacter() {
        if (!TextUtils.isEmpty(characteristics)) {
            return characteristics;
        }
        characteristics = get("ro.build.characteristics", "");
        return characteristics;
    }

    public static String getEMUIVersion() {
        if (!TextUtils.isEmpty(emuiVerion)) {
            return emuiVerion;
        }
        emuiVerion = get("ro.build.version.emui", "NULL");
        return emuiVerion;
    }

    private static synchronized String getHonorProKey(String str) {
        try {
            if (honorProMap == null) {
                initHonorProMapMap();
            }
        } catch (Throwable th) {
            throw th;
        }
        return honorProMap.get(str);
    }

    public static String getPlatform() {
        if (!TextUtils.isEmpty(platform)) {
            return platform;
        }
        platform = get("ro.board.platform", "");
        return platform;
    }

    public static String getProRegion() {
        if (!TextUtils.isEmpty(region)) {
            return region;
        }
        region = get("ro.product.locale.region", "");
        return region;
    }

    public static String getProperty(String str, String str2) {
        return get(str, str2);
    }

    public static String getVersion() {
        if (!TextUtils.isEmpty(fullVersionId)) {
            return fullVersionId;
        }
        String[] strArr = {get("ro.build.realversion.id", "NULL"), get("ro.build.cust.id", "NULL"), get("ro.build.display.id", "NULL")};
        fullVersionId = Build.DISPLAY;
        int i = 0;
        while (true) {
            if (i >= 3) {
                break;
            }
            String str = strArr[i];
            if (!"NULL".equals(str)) {
                fullVersionId = str;
                break;
            }
            i++;
        }
        return fullVersionId;
    }

    private static void initHonorProMapMap() {
        HashMap map = new HashMap(4);
        honorProMap = map;
        map.put("ro.hw.country", "msc.sys.country");
        honorProMap.put("ro.build.hw_emui_api_level", "ro.build.magic_api_level");
        honorProMap.put("ro.build.version.emui", "ro.build.version.magic");
        honorProMap.put("ro.config.hw_nlp", "msc.config.nlp");
    }
}
