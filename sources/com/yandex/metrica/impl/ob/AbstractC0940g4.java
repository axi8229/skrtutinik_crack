package com.yandex.metrica.impl.ob;

import android.content.Context;

/* renamed from: com.yandex.metrica.impl.ob.g4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0940g4 implements InterfaceC1039k4 {
    private final X3 a;
    private final Vc b;

    public AbstractC0940g4(Context context, X3 x3) {
        this(context, x3, new Vc(C1315vc.a(context), H2.a(context), F0.g().s()));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1039k4
    public void a(C0836c0 c0836c0, D3 d3) {
        b(c0836c0, d3);
    }

    public X3 b() {
        return this.a;
    }

    protected abstract void b(C0836c0 c0836c0, D3 d3);

    public Vc c() {
        return this.b;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1039k4
    public void a() {
        this.a.b(this);
        this.b.b(this);
    }

    AbstractC0940g4(Context context, X3 x3, Vc vc) {
        context.getApplicationContext();
        this.a = x3;
        this.b = vc;
        x3.a(this);
        vc.a(this);
    }
}
