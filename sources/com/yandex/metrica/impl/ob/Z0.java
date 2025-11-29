package com.yandex.metrica.impl.ob;

import com.huawei.hms.android.SystemUtils;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes3.dex */
public class Z0 {

    static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static String a(int i) {
        Map<String, Integer> map = C0938g2.a;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Integer> entry : C0938g2.a.entrySet()) {
            if (entry.getValue().intValue() == i) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList.size() == 1 ? (String) arrayList.get(0) : arrayList.size() != 0 ? String.format("One of %s", arrayList) : SystemUtils.UNKNOWN;
    }

    public static boolean a(String str) throws ClassNotFoundException {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
