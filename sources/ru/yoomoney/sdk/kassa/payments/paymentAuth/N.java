package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.C2326j;

/* loaded from: classes5.dex */
public final class N extends O {
    public final C2326j a;
    public final Integer b;
    public final Integer c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(C2326j data, Integer num, Integer num2) {
        super(0);
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = data;
        this.b = num;
        this.c = num2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N)) {
            return false;
        }
        N n = (N) obj;
        return Intrinsics.areEqual(this.a, n.a) && Intrinsics.areEqual(this.b, n.b) && Intrinsics.areEqual(this.c, n.c);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.c;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public final String toString() {
        return "WrongInputCode(data=" + this.a + ", attemptsCount=" + this.b + ", attemptsLeft=" + this.c + ")";
    }
}
