package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.y6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1381y6 implements A6 {
    private final a a;
    private final com.yandex.metrica.c b;
    private final A0 c;

    /* renamed from: com.yandex.metrica.impl.ob.y6$a */
    public interface a {
        boolean a(Throwable th);
    }

    AbstractC1381y6(a aVar, com.yandex.metrica.c cVar, A0 a0) {
        this.a = aVar;
        this.c = a0;
    }

    abstract void a(H6 h6);

    @Override // com.yandex.metrica.impl.ob.A6
    public void a(Throwable th, C1333w6 c1333w6) {
        if (this.a.a(th)) {
            a(I6.a(th, c1333w6, null, this.c.a(), this.c.b()));
        }
    }
}
