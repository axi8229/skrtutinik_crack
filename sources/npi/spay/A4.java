package npi.spay;

/* loaded from: classes4.dex */
public final class A4 {
    public final int a;
    public final int b;

    public A4(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A4)) {
            return false;
        }
        A4 a4 = (A4) obj;
        return this.a == a4.a && this.b == a4.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Integer.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "SubstringIndexes(firstIndex=" + this.a + ", lastIndex=" + this.b + ')';
    }
}
