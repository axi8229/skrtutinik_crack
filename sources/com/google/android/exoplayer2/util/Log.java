package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import java.net.UnknownHostException;

/* loaded from: classes2.dex */
public final class Log {
    private static int logLevel = 0;
    private static boolean logStackTraces = true;

    public static void d(String tag, String message) {
        if (logLevel == 0) {
            android.util.Log.d(tag, message);
        }
    }

    public static void i(String tag, String message) {
        if (logLevel <= 1) {
            android.util.Log.i(tag, message);
        }
    }

    public static void w(String tag, String message) {
        if (logLevel <= 2) {
            android.util.Log.w(tag, message);
        }
    }

    public static void w(String tag, String message, Throwable throwable) {
        w(tag, appendThrowableString(message, throwable));
    }

    public static void e(String tag, String message) {
        if (logLevel <= 3) {
            android.util.Log.e(tag, message);
        }
    }

    public static void e(String tag, String message, Throwable throwable) {
        e(tag, appendThrowableString(message, throwable));
    }

    public static String getThrowableString(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        if (isCausedByUnknownHostException(throwable)) {
            return "UnknownHostException (no network)";
        }
        if (!logStackTraces) {
            return throwable.getMessage();
        }
        return android.util.Log.getStackTraceString(throwable).trim().replace("\t", "    ");
    }

    private static String appendThrowableString(String message, Throwable throwable) {
        String throwableString = getThrowableString(throwable);
        if (TextUtils.isEmpty(throwableString)) {
            return message;
        }
        return message + "\n  " + throwableString.replace("\n", "\n  ") + '\n';
    }

    private static boolean isCausedByUnknownHostException(Throwable throwable) {
        while (throwable != null) {
            if (throwable instanceof UnknownHostException) {
                return true;
            }
            throwable = throwable.getCause();
        }
        return false;
    }
}
