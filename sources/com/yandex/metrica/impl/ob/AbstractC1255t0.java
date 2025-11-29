package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.t0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1255t0<T> {
    private final Zl<EnumC1279u0, Integer> a;

    public AbstractC1255t0() {
        Zl<EnumC1279u0, Integer> zl = new Zl<>(0);
        zl.a(EnumC1279u0.UNDEFINED, 0);
        zl.a(EnumC1279u0.APP, 1);
        zl.a(EnumC1279u0.SATELLITE, 2);
        zl.a(EnumC1279u0.RETAIL, 3);
        this.a = zl;
    }

    protected final Zl<EnumC1279u0, Integer> a() {
        return this.a;
    }

    public abstract boolean a(T t, T t2);
}
