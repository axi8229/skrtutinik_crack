package com.huawei.location.constant;

import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
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
        map.put(Integer.valueOf(LocationStatusCode.ARGUMENTS_EMPTY), "ARGUMENTS_EMPTY");
        map.put(10101, "ARGUMENTS_INVALID");
        map.put(Integer.valueOf(ActivityErrorCode.PERMISSION_DENIED), "PERMISSION_DENIED");
        map.put(10104, "NO_MATCHED_CALLBACK");
        map.put(Integer.valueOf(LocationStatusCode.NETWORK_LOCATION_SERVICES_DISABLED), "NETWORK_LOCATION_SERVICES_DISABLED");
        map.put(10803, "PERMISSION_DENIED");
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
