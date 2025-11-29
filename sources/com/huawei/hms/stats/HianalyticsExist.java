package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes3.dex */
public class HianalyticsExist {
    private static final Object a = new Object();
    private static boolean b = false;
    private static boolean c = false;

    public static boolean isHianalyticsExist() {
        synchronized (a) {
            if (!b) {
                try {
                    Class.forName("com.huawei.hianalytics.process.HiAnalyticsInstance");
                } catch (ClassNotFoundException unused) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");
                }
                b = true;
                HMSLog.i("HianalyticsExist", "hianalytics exist: " + c);
            }
        }
        return c;
    }
}
