package com.mocklets.pluto.modules.exceptions;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ANRException.kt */
@Keep
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/mocklets/pluto/modules/exceptions/ANRException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "thread", "Ljava/lang/Thread;", "(Ljava/lang/Thread;)V", "threadStateMap", "", "getThreadStateMap", "()Ljava/lang/String;", "pluto-no-op_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ANRException extends Exception {
    private final String threadStateMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ANRException(Thread thread) {
        super("ANR detected in Pluto-No-Op");
        Intrinsics.checkNotNullParameter(thread, "thread");
        setStackTrace(thread.getStackTrace());
        this.threadStateMap = "";
    }

    public final String getThreadStateMap() {
        return this.threadStateMap;
    }
}
