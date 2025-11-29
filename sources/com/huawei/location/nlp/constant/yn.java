package com.huawei.location.nlp.constant;

import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class yn {
    private static final Map<Integer, String> yn;

    static {
        HashMap map = new HashMap();
        map.put(0, "SUCCESS");
        map.put(10000, "INTERNAL_ERROR");
        map.put(Integer.valueOf(LocationStatusCode.ARGUMENTS_EMPTY), "SCAN_RESULT_ERROR");
        map.put(11000, "LOCATION_CLOUD_ERROR");
        yn = Collections.unmodifiableMap(map);
    }

    public static String yn(int i) {
        String str = yn.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        return "unknown error code:" + i;
    }
}
