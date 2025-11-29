package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.uj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1298uj {
    private Integer a;
    private final Integer b;
    private final Integer c;
    private final Integer d;
    private final Integer e;
    private final String f;
    private final String g;
    private final boolean h;
    private final int i;
    private final Integer j;
    private final Long k;
    private final Integer l;
    private final Integer m;
    private final Integer n;
    private final Integer o;
    private final Integer p;
    private final Integer q;

    /* renamed from: com.yandex.metrica.impl.ob.uj$a */
    public static class a {
        private Integer a;
        private Integer b;
        private Integer c;
        private Integer d;
        private Integer e;
        private String f;
        private String g;
        private boolean h;
        private int i;
        private Integer j;
        private Long k;
        private Integer l;
        private Integer m;
        private Integer n;
        private Integer o;
        private Integer p;
        private Integer q;

        public a a(int i) {
            this.i = i;
            return this;
        }

        public a b(Integer num) {
            this.e = num;
            return this;
        }

        public a c(Integer num) {
            this.d = num;
            return this;
        }

        public a d(Integer num) {
            this.p = num;
            return this;
        }

        public a e(Integer num) {
            this.q = num;
            return this;
        }

        public a f(Integer num) {
            this.l = num;
            return this;
        }

        public a g(Integer num) {
            this.n = num;
            return this;
        }

        public a h(Integer num) {
            this.m = num;
            return this;
        }

        public a i(Integer num) {
            this.b = num;
            return this;
        }

        public a j(Integer num) {
            this.c = num;
            return this;
        }

        public a k(Integer num) {
            this.j = num;
            return this;
        }

        public a l(Integer num) {
            this.a = num;
            return this;
        }

        public a a(String str) {
            this.g = str;
            return this;
        }

        public a b(String str) {
            this.f = str;
            return this;
        }

        public a a(boolean z) {
            this.h = z;
            return this;
        }

        public a a(Long l) {
            this.k = l;
            return this;
        }

        public a a(Integer num) {
            this.o = num;
            return this;
        }
    }

    public C1298uj(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
    }

    public void a(Integer num) {
        this.a = num;
    }

    public Integer b() {
        return this.e;
    }

    public int c() {
        return this.i;
    }

    public Long d() {
        return this.k;
    }

    public Integer e() {
        return this.d;
    }

    public Integer f() {
        return this.p;
    }

    public Integer g() {
        return this.q;
    }

    public Integer h() {
        return this.l;
    }

    public Integer i() {
        return this.n;
    }

    public Integer j() {
        return this.m;
    }

    public Integer k() {
        return this.b;
    }

    public Integer l() {
        return this.c;
    }

    public String m() {
        return this.g;
    }

    public String n() {
        return this.f;
    }

    public Integer o() {
        return this.j;
    }

    public Integer p() {
        return this.a;
    }

    public boolean q() {
        return this.h;
    }

    public String toString() {
        return "CellDescription{mSignalStrength=" + this.a + ", mMobileCountryCode=" + this.b + ", mMobileNetworkCode=" + this.c + ", mLocationAreaCode=" + this.d + ", mCellId=" + this.e + ", mOperatorName='" + this.f + "', mNetworkType='" + this.g + "', mConnected=" + this.h + ", mCellType=" + this.i + ", mPci=" + this.j + ", mLastVisibleTimeOffset=" + this.k + ", mLteRsrq=" + this.l + ", mLteRssnr=" + this.m + ", mLteRssi=" + this.n + ", mArfcn=" + this.o + ", mLteBandWidth=" + this.p + ", mLteCqi=" + this.q + '}';
    }

    public Integer a() {
        return this.o;
    }
}
