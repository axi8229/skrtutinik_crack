package com.huawei.location.lite.common.util;

import android.text.TextUtils;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.lite.common.exception.LocationServiceException;

/* loaded from: classes3.dex */
public class ObjectCheckUtils {
    public static void checkEmptyString(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            throw new LocationServiceException(LocationStatusCode.ARGUMENTS_EMPTY, com.huawei.location.lite.common.exception.LocationStatusCode.getStatusCodeString(LocationStatusCode.ARGUMENTS_EMPTY) + ":for String");
        }
    }

    public static void checkNullObject(String str, Object obj, int i, String str2) {
        if (obj == null) {
            throw new LocationServiceException(i, str2);
        }
    }

    public static void checkNullObject(String str, Object obj, Class cls) {
        if (obj != null) {
            return;
        }
        throw new LocationServiceException(LocationStatusCode.ARGUMENTS_EMPTY, com.huawei.location.lite.common.exception.LocationStatusCode.getStatusCodeString(LocationStatusCode.ARGUMENTS_EMPTY) + ":for object name is " + cls);
    }
}
