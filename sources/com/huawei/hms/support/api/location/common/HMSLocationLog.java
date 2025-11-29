package com.huawei.hms.support.api.location.common;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.location.lite.common.log.logwrite.LogWriteApi;

/* loaded from: classes3.dex */
public class HMSLocationLog {
    private static String compositeMessage(String str, String str2) {
        return HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str2;
    }

    private static String compositeTagForHMSLog(String str) {
        return "HwLocation_" + str;
    }

    public static void d(String str, String str2, String str3) {
        HMSLog.d(compositeTagForHMSLog(str), compositeMessage(str2, str3));
        LogWriteApi.d(str, compositeMessage(str2, str3), null);
    }

    public static void e(String str, String str2, long j, String str3) {
        HMSLog.e(compositeTagForHMSLog(str), j, compositeMessage(str2, str3));
        LogWriteApi.e(str, compositeMessage(str2, str3), null);
    }

    public static void e(String str, String str2, long j, String str3, Throwable th) {
        HMSLog.e(compositeTagForHMSLog(str), j, compositeMessage(str2, str3), th);
        LogWriteApi.e(str, compositeMessage(str2, str3), null);
    }

    public static void e(String str, String str2, String str3) {
        HMSLog.e(compositeTagForHMSLog(str), compositeMessage(str2, str3));
        LogWriteApi.e(str, compositeMessage(str2, str3), null);
    }

    public static void e(String str, String str2, String str3, Throwable th) {
        HMSLog.e(compositeTagForHMSLog(str), compositeMessage(str2, str3), th);
        LogWriteApi.e(str, compositeMessage(str2, str3), null);
    }

    public static void i(String str, String str2, String str3) {
        HMSLog.i(compositeTagForHMSLog(str), compositeMessage(str2, str3));
        LogWriteApi.i(str, compositeMessage(str2, str3), null);
    }

    public static void w(String str, String str2, String str3) {
        HMSLog.w(compositeTagForHMSLog(str), compositeMessage(str2, str3));
        LogWriteApi.w(str, compositeMessage(str2, str3), null);
    }
}
