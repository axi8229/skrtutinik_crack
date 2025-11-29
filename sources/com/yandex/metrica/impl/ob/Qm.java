package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Qm extends Gm {
    @Override // com.yandex.metrica.impl.ob.Gm, java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }
}
