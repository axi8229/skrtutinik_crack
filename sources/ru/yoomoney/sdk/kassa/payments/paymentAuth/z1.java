package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.C2326j;

/* loaded from: classes5.dex */
public final class z1 implements A1 {
    public final C2326j a;
    public final Integer b;
    public final Integer c;

    public z1(C2326j data, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = data;
        this.b = num;
        this.c = num2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z1)) {
            return false;
        }
        z1 z1Var = (z1) obj;
        return Intrinsics.areEqual(this.a, z1Var.a) && Intrinsics.areEqual(this.b, z1Var.b) && Intrinsics.areEqual(this.c, z1Var.c);
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
