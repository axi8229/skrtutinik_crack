package com.yandex.metrica.impl.ob;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
class Nm implements Executor {
    final /* synthetic */ Handler a;

    Nm(Om om, Handler handler) {
        this.a = handler;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
