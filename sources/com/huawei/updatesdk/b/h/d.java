package com.huawei.updatesdk.b.h;

import android.content.Context;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/* loaded from: classes3.dex */
public class d {
    public static int a(long j, long j2) {
        if (j2 <= 0) {
            return 0;
        }
        return Math.min((int) Math.round((j / j2) * 100.0d), 100);
    }

    public static String a(int i) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMinimumFractionDigits(0);
        return percentInstance.format(i / 100.0d);
    }

    public static String a(Context context, long j) {
        if (j == 0) {
            return context.getString(c.c(context, "upsdk_storage_utils"), "0");
        }
        DecimalFormat decimalFormat = j > 104857 ? new DecimalFormat("###.#") : j > 10485 ? new DecimalFormat("###.##") : null;
        return decimalFormat != null ? context.getString(c.c(context, "upsdk_storage_utils"), decimalFormat.format(j / 1048576.0d)) : context.getString(c.c(context, "upsdk_storage_utils"), "0.01");
    }

    public static boolean a(List list) {
        return list == null || list.size() <= 0;
    }
}
