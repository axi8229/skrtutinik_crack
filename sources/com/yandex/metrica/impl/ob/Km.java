package com.yandex.metrica.impl.ob;

import android.os.HandlerThread;
import com.yandex.metrica.core.api.executors.IInterruptionSafeThread;

/* loaded from: classes3.dex */
public class Km extends HandlerThread implements IInterruptionSafeThread {
    private volatile boolean a;

    public Km(String str) {
        super(str);
        this.a = true;
    }

    public synchronized boolean isRunning() {
        return this.a;
    }

    public synchronized void stopRunning() {
        this.a = false;
        interrupt();
    }
}
