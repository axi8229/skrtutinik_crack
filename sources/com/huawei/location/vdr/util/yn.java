package com.huawei.location.vdr.util;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class yn {
    private static final Map<String, String> Vw;
    private static final Map<String, String> yn;

    static {
        HashMap map = new HashMap();
        map.put("kirin990", "Kirin990");
        map.put("kirin980", "Kirin980");
        map.put("lahaina", "Snapdragon888");
        map.put("kona", "Snapdragon865");
        map.put("lito", "Snapdragon765");
        map.put("mt6873", "Dimensity800");
        map.put("mt6853", "Dimensity720");
        map.put("mt6885", "Dimensity1000p");
        map.put("erd9815_r", "Exynos1080");
        yn = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("kirin990", "Kirin990");
        map2.put("kirin980", "Kirin980");
        map2.put("lahaina", "snapdragon888");
        map2.put("kona", "snapdragon865");
        map2.put("lito", "snapdragon765");
        map2.put("mt6873", "tj800");
        map2.put("mt6853", "tj720");
        map2.put("mt6885", "tj1000");
        map2.put("erd9815_r", "exynos1080");
        Vw = Collections.unmodifiableMap(map2);
    }

    public static String Vw(String str) {
        String str2 = Vw.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }

    public static String yn(String str) {
        String str2 = yn.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
