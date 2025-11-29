package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class H9 {
    public final int a;
    public final Bk b;

    public H9(int i, Bk text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.a = i;
        this.b = text;
    }

    public final int a() {
        return this.a;
    }

    public final Bk b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H9)) {
            return false;
        }
        H9 h9 = (H9) obj;
        return this.a == h9.a && Intrinsics.areEqual(this.b, h9.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "HintHelper(priority=" + this.a + ", text=" + this.b + ')';
    }
}
