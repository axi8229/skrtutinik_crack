package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Pn extends co {
    public final Ae a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pn(Ae result) {
        super(0);
        Intrinsics.checkNotNullParameter(result, "result");
        this.a = result;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Pn) && Intrinsics.areEqual(this.a, ((Pn) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "HandlePaymentTokenStatus(result=" + this.a + ')';
    }
}
