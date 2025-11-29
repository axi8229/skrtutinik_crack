package com.sputnik.common.utils;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.mocklets.pluto.PlutoLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: LogUtils.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"", RemoteMessageConst.MessageBody.MSG, "", "writeLog", "(Ljava/lang/String;)V", RemoteMessageConst.Notification.TAG, "(Ljava/lang/String;Ljava/lang/String;)V", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LogUtilsKt {
    public static final void writeLog(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Timber.INSTANCE.d(msg, new Object[0]);
    }

    public static final void writeLog(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Timber.INSTANCE.tag(tag).d(msg, new Object[0]);
        PlutoLog.i$default(PlutoLog.INSTANCE, tag, msg, null, 4, null);
    }
}
