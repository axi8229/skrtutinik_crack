package com.shopgun.android.utils;

/* loaded from: classes3.dex */
public class Tag {
    public static final String TAG = from((Class<?>) Tag.class);

    private Tag() {
    }

    public static String from(Class<?> cls) {
        return from(cls.getSimpleName());
    }

    public static String from(String str) {
        return "sgn:utils:" + str;
    }
}
