package com.huawei.location.lite.common.log.logwrite;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public class DateUtil {
    private static ThreadLocal<Map<String, SimpleDateFormat>> dateFormat = new ThreadLocal<Map<String, SimpleDateFormat>>() { // from class: com.huawei.location.lite.common.log.logwrite.DateUtil.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Map<String, SimpleDateFormat> initialValue() {
            return new HashMap(0);
        }
    };

    public static String formate(Date date, String str) {
        return getSimpleDateFormat(str).format(date);
    }

    private static SimpleDateFormat getSimpleDateFormat(String str) {
        Map<String, SimpleDateFormat> map = dateFormat.get();
        SimpleDateFormat simpleDateFormat = map.get(str);
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str, Locale.getDefault());
        map.put(str, simpleDateFormat2);
        return simpleDateFormat2;
    }
}
