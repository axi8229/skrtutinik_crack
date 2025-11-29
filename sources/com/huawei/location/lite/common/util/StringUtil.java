package com.huawei.location.lite.common.util;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class StringUtil {
    private static final Pattern INT_PATTERN = Pattern.compile("\\d+");
    private static final Pattern VALID_PATTERN = Pattern.compile("^[.0-9a-zA-Z_-]{1,}$");

    public static boolean isAnyBlank(List<String> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (isEmpty(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
