package com.group_ib.sdk;

import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public abstract class U0 {
    public static final ExecutorService a = Executors.newCachedThreadPool();
    public static final R0 b = new R0().a(Looper.getMainLooper());
    public static final R0 c = new R0();
}
