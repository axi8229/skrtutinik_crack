package androidx.constraintlayout.motion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import java.nio.CharBuffer;

@SuppressLint({"LogConditional"})
/* loaded from: classes.dex */
public class Debug {
    public static void logStack(String tag, String msg, int n) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int iMin = Math.min(n, stackTrace.length - 1);
        String str = " ";
        for (int i = 1; i <= iMin; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            str = str + " ";
            Log.v(tag, msg + str + (".(" + stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber() + ") " + stackTrace[i].getMethodName()) + str);
        }
    }

    public static String getName(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String getName(Context context, int id) {
        if (id != -1) {
            try {
                return context.getResources().getResourceEntryName(id);
            } catch (Exception unused) {
                return "?" + id;
            }
        }
        return "UNKNOWN";
    }

    public static String getState(MotionLayout layout, int stateId) {
        return getState(layout, stateId, -1);
    }

    public static String getState(MotionLayout layout, int stateId, int len) throws Resources.NotFoundException {
        int length;
        if (stateId == -1) {
            return "UNDEFINED";
        }
        String resourceEntryName = layout.getContext().getResources().getResourceEntryName(stateId);
        if (len == -1) {
            return resourceEntryName;
        }
        if (resourceEntryName.length() > len) {
            resourceEntryName = resourceEntryName.replaceAll("([^_])[aeiou]+", "$1");
        }
        if (resourceEntryName.length() <= len || (length = resourceEntryName.replaceAll("[^_]", "").length()) <= 0) {
            return resourceEntryName;
        }
        return resourceEntryName.replaceAll(CharBuffer.allocate((resourceEntryName.length() - len) / length).toString().replace((char) 0, '.') + "_", "_");
    }

    public static String getLoc() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "()";
    }
}
