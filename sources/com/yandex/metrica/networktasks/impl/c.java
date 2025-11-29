package com.yandex.metrica.networktasks.impl;

/* loaded from: classes3.dex */
public class c extends Thread {
    private volatile boolean a = true;

    public synchronized boolean isRunning() {
        return this.a;
    }
}
