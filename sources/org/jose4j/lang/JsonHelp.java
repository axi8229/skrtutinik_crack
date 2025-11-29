package org.jose4j.lang;

import com.huawei.hms.android.SystemUtils;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class JsonHelp {
    public static String getString(Map<String, Object> map, String str) {
        return (String) map.get(str);
    }

    public static String getStringChecked(Map<String, Object> map, String str) throws JoseException {
        Object obj = map.get(str);
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            throw new JoseException("'" + str + "' parameter was " + jsonTypeName(obj) + " type but is required to be a String.");
        }
    }

    public static List<String> getStringArray(Map<String, Object> map, String str) {
        return (List) map.get(str);
    }

    public static String jsonTypeName(Object obj) {
        if (obj instanceof Number) {
            return "Number";
        }
        if (obj instanceof Boolean) {
            return "Boolean";
        }
        if (obj instanceof List) {
            return "Array";
        }
        if (obj instanceof Map) {
            return "Object";
        }
        if (obj instanceof String) {
            return "String";
        }
        return SystemUtils.UNKNOWN;
    }
}
