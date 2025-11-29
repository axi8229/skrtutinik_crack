package com.group_ib.sdk;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: com.group_ib.sdk.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class ExecutorC0607l implements Executor {
    public final Handler a;

    public ExecutorC0607l(Handler handler) {
        this.a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
