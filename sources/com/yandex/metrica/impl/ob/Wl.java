package com.yandex.metrica.impl.ob;

import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
class Wl implements Callable<String> {
    final /* synthetic */ Xl a;

    Wl(Xl xl) {
        this.a = xl;
    }

    @Override // java.util.concurrent.Callable
    public String call() throws Exception {
        return this.a.a();
    }
}
