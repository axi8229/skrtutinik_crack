package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.model.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2326j extends AbstractC2330n {
    public final int a;
    public final int b;
    public final Integer c;
    public final Integer d;

    public C2326j(int i, int i2, Integer num, Integer num2) {
        super(0);
        this.a = i;
        this.b = i2;
        this.c = num;
        this.d = num2;
    }

    public final Integer b() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2326j)) {
            return false;
        }
        C2326j c2326j = (C2326j) obj;
        return this.a == c2326j.a && this.b == c2326j.b && Intrinsics.areEqual(this.c, c2326j.c) && Intrinsics.areEqual(this.d, c2326j.d);
    }

    public final int hashCode() {
        int iHashCode = (Integer.hashCode(this.b) + (Integer.hashCode(this.a) * 31)) * 31;
        Integer num = this.c;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.d;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public final String toString() {
        return "SMS(nextSessionTimeLeft=" + this.a + ", codeLength=" + this.b + ", attemptsCount=" + this.c + ", attemptsLeft=" + this.d + ")";
    }
}
