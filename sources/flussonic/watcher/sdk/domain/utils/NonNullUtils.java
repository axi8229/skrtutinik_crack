package flussonic.watcher.sdk.domain.utils;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class NonNullUtils {
    public static int intValue(Integer value) {
        if (value == null) {
            return 0;
        }
        return value.intValue();
    }

    public static long longValue(Long value) {
        if (value == null) {
            return 0L;
        }
        return value.longValue();
    }

    public static boolean booleanValue(Boolean value) {
        if (value == null) {
            return false;
        }
        return value.booleanValue();
    }

    public static String stringValue(String value) {
        return TextUtils.isEmpty(value) ? "" : value;
    }
}
