package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.wa, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2012wa {
    public final int a;
    public final Bk b;

    public C2012wa(int i, Bk text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.a = i;
        this.b = text;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2012wa)) {
            return false;
        }
        C2012wa c2012wa = (C2012wa) obj;
        return this.a == c2012wa.a && Intrinsics.areEqual(this.b, c2012wa.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "HintHelperItem(priority=" + this.a + ", text=" + this.b + ')';
    }
}
