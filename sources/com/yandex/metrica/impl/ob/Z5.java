package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public final class Z5 {
    private final EnumC0917f6 a;
    private final Integer b;

    static final class b {
        private EnumC0917f6 a;
        private Integer b;

        private b(EnumC0917f6 enumC0917f6) {
            this.a = enumC0917f6;
        }

        public b a(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        public Z5 a() {
            return new Z5(this);
        }
    }

    public static final b a(EnumC0917f6 enumC0917f6) {
        return new b(enumC0917f6);
    }

    public EnumC0917f6 b() {
        return this.a;
    }

    private Z5(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
    }

    public Integer a() {
        return this.b;
    }
}
