package com.huawei.location.lite.common.log.logwrite;

import android.os.Process;
import android.util.Log;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* loaded from: classes3.dex */
public class LogWriteApi {
    private static String compositeTag(String str, int i, int i2) {
        return "(" + i + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + i2 + ")" + str;
    }

    public static void d(String str, String str2, Throwable th) {
        if (LogWrite.isEnableWriteLog()) {
            LogWriteManager.getInstance().appendLog(new AppLog("D", compositeTag(str, Process.myPid(), Process.myTid()), str2, th));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (LogWrite.isEnableWriteLog()) {
            LogWriteManager.getInstance().appendLog(new AppLog("E", compositeTag(str, Process.myPid(), Process.myTid()), str2, th));
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (LogWrite.isEnableWriteLog()) {
            LogWriteManager.getInstance().appendLog(new AppLog("I", compositeTag(str, Process.myPid(), Process.myTid()), str2, th));
        }
    }

    public static void init(LogWriteParam logWriteParam) {
        if (logWriteParam != null) {
            LogWriteManager.getInstance().init(logWriteParam);
        } else {
            Log.e("LogWriteApi", "logWriteParam is null stop init LogWriteManager");
        }
    }

    public static void printLocationInfo(String str, boolean z) {
        if (LogWrite.isEnableWriteLog() && z) {
            LogWriteManager.getInstance().appendLog(new AppLog(str, "location"));
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (LogWrite.isEnableWriteLog()) {
            LogWriteManager.getInstance().appendLog(new AppLog("W", compositeTag(str, Process.myPid(), Process.myTid()), str2, th));
        }
    }
}
