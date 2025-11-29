package com.shopgun.android.utils;

import android.content.Context;

/* loaded from: classes3.dex */
public class UnitUtils {
    public static final String TAG = Tag.from((Class<?>) UnitUtils.class);

    private UnitUtils() {
    }

    public static int dpToPx(int i, Context context) {
        return (int) (i * context.getResources().getDisplayMetrics().density);
    }
}
