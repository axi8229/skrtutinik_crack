package com.huawei.hms.support.api.location.common.exception;

import com.huawei.hms.common.api.CommonStatusCodes;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class LocationStatusCode extends CommonStatusCodes {
    public static final int AGC_CHECK_FAIL = 10808;
    public static final int ARGUMENTS_EMPTY = 10100;
    public static final int ARGUMENTS_INVALID = 10101;
    private static final Map<Integer, String> CODE_MAPPING;
    public static final int GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION = 10204;
    public static final int GEOFENCE_NOT_AVAILABLE = 10200;
    public static final int GEOFENCE_REQUEST_TOO_FREQUENT = 10205;
    public static final int GEOFENCE_TOO_MANY_GEOFENCES = 10201;
    public static final int GEOFENCE_TOO_MANY_PENDING_INTENTS = 10202;
    public static final int LOCATION_ENABLE_OFF = 10106;
    public static final int LOCATION_INTERNAL_ERROR = 10000;
    public static final int METHOD_INVOKE_ERROR = 10807;
    public static final int NAVIGATION_EMPTY_RESULT = 10110;
    public static final int NAVIGATION_NOT_AVAILABLE = 10109;
    public static final int NETWORK_LOCATION_SERVICES_DISABLED = 10105;
    public static final int NOT_IN_WHITELIST = 10111;
    public static final int NOT_SUPPORT_WATCH = 10601;
    public static final int NOT_YET_SUPPORTED = 10806;
    public static final int NO_MATCHED_CALLBACK = 10804;
    public static final int NO_MATCHED_INTENT = 10805;
    public static final int NO_PRECISE_LOCATION_PERMISSION = 10809;
    public static final int OFFLINE_LOCATION_MODE_OFF = 10112;
    public static final int PARAM_ERROR_EMPTY = 10801;
    public static final int PARAM_ERROR_INVALID = 10802;
    public static final int PERMISSION_DENIED = 10803;
    public static final int SUCCESS = 0;

    static {
        HashMap map = new HashMap(0);
        map.put(0, "SUCCESS");
        map.put(Integer.valueOf(LOCATION_ENABLE_OFF), "LOCATION_ENABLE_OFF");
        map.put(8, "INTERNAL_ERROR");
        map.put(Integer.valueOf(ARGUMENTS_EMPTY), "ARGUMENTS_EMPTY");
        map.put(10101, "ARGUMENTS_INVALID");
        map.put(10802, "PARAM_ERROR_INVALID");
        map.put(10803, "PERMISSION_DENIED");
        map.put(Integer.valueOf(NO_MATCHED_CALLBACK), "NO_MATCHED_CALLBACK");
        map.put(Integer.valueOf(NOT_YET_SUPPORTED), "NOT_YET_SUPPORTED");
        map.put(Integer.valueOf(NETWORK_LOCATION_SERVICES_DISABLED), "NETWORK_LOCATION_SERVICES_DISABLED");
        map.put(Integer.valueOf(NO_MATCHED_INTENT), "NO_MATCHED_INTENT");
        map.put(Integer.valueOf(PARAM_ERROR_EMPTY), "PARAM_ERROR_EMPTY");
        map.put(Integer.valueOf(METHOD_INVOKE_ERROR), "METHOD_INVOKE_ERROR");
        map.put(Integer.valueOf(AGC_CHECK_FAIL), "AGC_CHECK_FAIL");
        map.put(Integer.valueOf(NO_PRECISE_LOCATION_PERMISSION), "NO_PRECISE_LOCATION_PERMISSION");
        map.put(10200, "GEOFENCE_NOT_AVAILABLE");
        map.put(10201, "GEOFENCE_TOO_MANY_GEOFENCES");
        map.put(10202, "GEOFENCE_TOO_MANY_PENDING_INTENTS");
        map.put(10204, "GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION");
        map.put(10205, "GEOFENCE_REQUEST_TOO_FREQUENT");
        map.put(Integer.valueOf(NOT_SUPPORT_WATCH), "NOT_SUPPORT_WATCH");
        map.put(Integer.valueOf(NOT_IN_WHITELIST), "NOT_IN_WHITELIST");
        map.put(Integer.valueOf(NAVIGATION_NOT_AVAILABLE), "NAVIGATION_NOT_AVAILABLE");
        map.put(Integer.valueOf(NAVIGATION_EMPTY_RESULT), "NAVIGATION_EMPTY_RESULT");
        map.put(Integer.valueOf(OFFLINE_LOCATION_MODE_OFF), "OFFLINE_LOCATION_MODE_OFF");
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
