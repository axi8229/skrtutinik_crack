package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
class S2 implements Runnable {
    final /* synthetic */ R2 a;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1152oh.a(S2.this.a.a);
        }
    }

    S2(R2 r2) {
        this.a = r2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.e.a().execute(new a());
    }
}
