package androidx.paging;

import android.util.Log;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PagingLogger.android.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\r"}, d2 = {"Landroidx/paging/PagingLogger;", "", "()V", "isLoggable", "", "level", "", "log", "", CrashHianalyticsData.MESSAGE, "", "tr", "", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagingLogger {
    public static final PagingLogger INSTANCE = new PagingLogger();

    private PagingLogger() {
    }

    public final boolean isLoggable(int level) {
        return Log.isLoggable("Paging", level);
    }

    public final void log(int level, String message, Throwable tr) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (level == 2) {
            Log.v("Paging", message, tr);
            return;
        }
        if (level == 3) {
            Log.d("Paging", message, tr);
            return;
        }
        throw new IllegalArgumentException("debug level " + level + " is requested but Paging only supports default logging for level 2 (VERBOSE) or level 3 (DEBUG)");
    }
}
