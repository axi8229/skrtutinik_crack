package bz;

import android.content.Context;
import android.os.Process;

/* loaded from: classes.dex */
public abstract class K0 {
    public static boolean a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}
