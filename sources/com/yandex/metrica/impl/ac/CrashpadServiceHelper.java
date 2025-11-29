package com.yandex.metrica.impl.ac;

import android.os.Bundle;
import java.util.List;

/* loaded from: classes3.dex */
public class CrashpadServiceHelper {
    public static boolean a(String str) {
        return markCrashCompleted(str) && deleteCompletedReports();
    }

    public static native void cancelSetUpServiceHelper();

    public static native boolean deleteCompletedReports();

    private static native boolean markCrashCompleted(String str);

    public static native Bundle readCrash(String str);

    public static native List<Bundle> readOldCrashes();

    public static native void setUpServiceHelper(String str);
}
