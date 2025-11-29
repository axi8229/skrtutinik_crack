package com.huawei.location.lite.common.android.context;

import android.content.Context;

/* loaded from: classes3.dex */
public class ContextUtil {
    private static Context mContext;
    private static Context mHMSContext;

    public static Context getContext() {
        Context context = mContext;
        if (context != null) {
            return context;
        }
        throw new NullPointerException("Context is null , must init first!");
    }

    public static Context getHMSContext() {
        Context context = mHMSContext;
        return context == null ? mContext : context;
    }

    public static void setContext(Context context) {
        if (mContext == null) {
            mContext = context.getApplicationContext();
        }
    }
}
