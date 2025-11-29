package com.yandex.metrica.networktasks.impl;

import com.yandex.metrica.networktasks.api.NetworkTask;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class e {
    public final f a(NetworkTask networkTask, c rootThreadStateSource) {
        Intrinsics.checkNotNullParameter(networkTask, "networkTask");
        Intrinsics.checkNotNullParameter(rootThreadStateSource, "rootThreadStateSource");
        Intrinsics.checkNotNullParameter(networkTask, "networkTask");
        Intrinsics.checkNotNullParameter(rootThreadStateSource, "rootThreadStateSource");
        return new f(networkTask, rootThreadStateSource, new d());
    }
}
