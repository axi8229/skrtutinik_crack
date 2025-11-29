package com.huawei.updatesdk.a.b.c.c;

import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.updatesdk.a.a.d.f;
import com.huawei.updatesdk.a.a.d.g;
import com.huawei.updatesdk.service.appmgr.bean.SDKNetTransmission;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class c {
    public static final String CLIENT_API = "clientApi";
    private static final String END_FLAG = "_";
    private static String url;

    @SDKNetTransmission
    private String method;

    @SDKNetTransmission
    private String ver = "1.1";

    private String a(Field field) throws IllegalAccessException, IllegalArgumentException {
        Object obj = field.get(this);
        if (obj instanceof b) {
            return ((b) obj).toJson();
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    public static void c(String str) {
        url = str;
    }

    public String a() throws IllegalAccessException, SecurityException, IllegalArgumentException {
        e();
        Map<String, Field> mapC = c();
        int size = mapC.size();
        String[] strArr = new String[size];
        mapC.keySet().toArray(strArr);
        Arrays.sort(strArr);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        do {
            String strA = a(mapC.get(strArr[i]));
            if (strA != null) {
                String strA2 = g.a(strA);
                sb.append(strArr[i]);
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(strA2);
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            i++;
        } while (i < size);
        int length = sb.length();
        if (length > 0) {
            int i2 = length - 1;
            if (sb.charAt(i2) == '&') {
                sb.deleteCharAt(i2);
            }
        }
        return sb.toString();
    }

    public void a(String str) {
        this.method = str;
    }

    public String b() {
        return this.method;
    }

    public void b(String str) {
        this.ver = str;
    }

    protected Map<String, Field> c() throws SecurityException {
        HashMap map = new HashMap();
        for (Field field : f.a(getClass())) {
            field.setAccessible(true);
            String name = field.getName();
            if (name.endsWith(END_FLAG) || field.isAnnotationPresent(SDKNetTransmission.class)) {
                if (name.endsWith(END_FLAG)) {
                    name = name.substring(0, name.length() - 1);
                }
                map.put(name, field);
            }
        }
        return map;
    }

    public String d() {
        return url + CLIENT_API;
    }

    protected void e() {
    }
}
