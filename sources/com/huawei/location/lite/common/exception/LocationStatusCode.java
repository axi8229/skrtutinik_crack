package com.huawei.location.lite.common.exception;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class LocationStatusCode {
    private static final Map<Integer, String> CODE_MAPPING;

    static {
        HashMap map = new HashMap();
        map.put(0, "SUCCESS");
        map.put(10000, "INTERNAL_ERROR");
        map.put(Integer.valueOf(com.huawei.hms.support.api.location.common.exception.LocationStatusCode.ARGUMENTS_EMPTY), "ARGUMENTS_EMPTY");
        map.put(Integer.valueOf(com.huawei.hms.support.api.location.common.exception.LocationStatusCode.NOT_YET_SUPPORTED), "NOT_YET_SUPPORTED");
        map.put(Integer.valueOf(com.huawei.hms.support.api.location.common.exception.LocationStatusCode.AGC_CHECK_FAIL), "AGC_CHECK_FAIL");
        CODE_MAPPING = Collections.unmodifiableMap(map);
    }

    public static String getStatusCodeString(int i) {
        String str = CODE_MAPPING.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        return "unknown error code:" + i;
    }
}
