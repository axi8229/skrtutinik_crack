package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.executors.IInterruptionSafeThread;

/* loaded from: classes3.dex */
public class Lm extends Thread implements IInterruptionSafeThread {
    private volatile boolean a;

    public Lm() {
        this.a = true;
    }

    public synchronized boolean isRunning() {
        return this.a;
    }

    public synchronized void stopRunning() {
        this.a = false;
        interrupt();
    }

    public Lm(Runnable runnable, String str) {
        super(runnable, str);
        this.a = true;
    }

    public Lm(String str) {
        super(str);
        this.a = true;
    }
}
