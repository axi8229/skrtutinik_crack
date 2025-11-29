package com.yandex.metrica.impl.ob;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes3.dex */
public final class Nl {
    public static final a c = new a(null);
    private final long a;
    private final int b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Nl(long j, int i) {
        this.a = j;
        this.b = i;
    }

    public final int a() {
        return this.b;
    }

    public final long b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Nl)) {
            return false;
        }
        Nl nl = (Nl) obj;
        return this.a == nl.a && this.b == nl.b;
    }

    public int hashCode() {
        long j = this.a;
        return (((int) (j ^ (j >>> 32))) * 31) + this.b;
    }

    public String toString() {
        return "DecimalProtoModel(mantissa=" + this.a + ", exponent=" + this.b + ")";
    }
}
