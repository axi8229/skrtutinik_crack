package com.mocklets.pluto;

import androidx.annotation.Keep;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlutoLog.kt */
@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJ$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJB\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062*\u0010\f\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\rj\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u000eJ$\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJ$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJ$\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\u0012"}, d2 = {"Lcom/mocklets/pluto/PlutoLog;", "", "()V", "d", "", RemoteMessageConst.Notification.TAG, "", CrashHianalyticsData.MESSAGE, "tr", "", "e", "event", "attributes", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "i", "v", "w", "pluto-no-op_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PlutoLog {
    public static final PlutoLog INSTANCE = new PlutoLog();

    public final void d(String tag, String message, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    public final void e(String tag, String message, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    public final void event(String tag, String event, HashMap<String, Object> attributes) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public final void i(String tag, String message, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    public final void v(String tag, String message, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    public final void w(String tag, String message, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    private PlutoLog() {
    }

    public static /* synthetic */ void v$default(PlutoLog plutoLog, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        plutoLog.v(str, str2, th);
    }

    public static /* synthetic */ void d$default(PlutoLog plutoLog, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        plutoLog.d(str, str2, th);
    }

    public static /* synthetic */ void i$default(PlutoLog plutoLog, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        plutoLog.i(str, str2, th);
    }

    public static /* synthetic */ void w$default(PlutoLog plutoLog, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        plutoLog.w(str, str2, th);
    }

    public static /* synthetic */ void e$default(PlutoLog plutoLog, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        plutoLog.e(str, str2, th);
    }
}
