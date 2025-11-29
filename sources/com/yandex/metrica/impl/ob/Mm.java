package com.yandex.metrica.impl.ob;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class Mm implements ThreadFactory {
    private static final AtomicInteger b = new AtomicInteger(0);
    private final String a;

    public Mm(String str) {
        this.a = str;
    }

    private String a() {
        return this.a + "-" + b.incrementAndGet();
    }

    public static int c() {
        return b.incrementAndGet();
    }

    public Km b() {
        return new Km(a());
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Lm(runnable, a());
    }

    public static Lm a(String str, Runnable runnable) {
        return new Lm(runnable, new Mm(str).a());
    }
}
