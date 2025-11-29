package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.o8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1811o8 {
    public final Bk a;

    public C1811o8(Bk amount) {
        Intrinsics.checkNotNullParameter(amount, "amount");
        this.a = amount;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1811o8) && Intrinsics.areEqual(this.a, ((C1811o8) obj).a) && Intrinsics.areEqual(null, null);
    }

    public final int hashCode() {
        return this.a.hashCode() * 31;
    }

    public final String toString() {
        return "PaymentAmountItem(amount=" + this.a + ", details=null)";
    }
}
