package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Qf implements Kn<Void> {
    private final Sf a;

    public Qf(Sf sf) {
        this.a = sf;
    }

    @Override // com.yandex.metrica.impl.ob.Kn
    public In a(Void r1) {
        this.a.getClass();
        return R2.h() ? In.a(this) : In.a(this, "YandexMetrica isn't initialized. Use YandexMetrica#activate(android.content.Context, String) method to activate.");
    }

    public In a() {
        this.a.getClass();
        if (R2.h()) {
            return In.a(this);
        }
        return In.a(this, "YandexMetrica isn't initialized. Use YandexMetrica#activate(android.content.Context, String) method to activate.");
    }
}
