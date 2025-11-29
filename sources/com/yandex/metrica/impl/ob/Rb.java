package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
class Rb {
    private C1097mc a;
    private final U7 b;
    private final T7 c;

    public Rb(C1097mc c1097mc, U7 u7, T7 t7) {
        this.a = c1097mc;
        this.b = u7;
        this.c = t7;
    }

    public void a() {
        C1097mc c1097mc = this.a;
        if (c1097mc != null) {
            long jC = this.b.c();
            int i = c1097mc.f;
            if (jC > i) {
                this.b.b((int) (i * 0.1f));
            }
            C1097mc c1097mc2 = this.a;
            long jC2 = this.c.c();
            int i2 = c1097mc2.f;
            if (jC2 > i2) {
                this.c.b((int) (i2 * 0.1f));
            }
        }
    }

    public void a(C1097mc c1097mc) {
        this.a = c1097mc;
    }
}
