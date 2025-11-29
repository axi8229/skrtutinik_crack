package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public abstract class Uc<T> implements Lb<T> {
    private final C1353x2 a;
    private final InterfaceC0948gc b;

    public Uc(InterfaceC0948gc interfaceC0948gc, C1353x2 c1353x2) {
        this.b = interfaceC0948gc;
        this.a = c1353x2;
    }

    protected abstract String a();

    protected boolean a(long j) {
        return this.a.b(this.b.getLastAttemptTimeSeconds(), j, "last " + a() + " scan attempt");
    }
}
