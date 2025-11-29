package ru.yoomoney.sdk.kassa.payments.unbind;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.LinkedCard;
import ru.yoomoney.sdk.kassa.payments.model.Q;

/* loaded from: classes5.dex */
public final class b extends f {
    public final LinkedCard a;
    public final Q b;

    public b(LinkedCard linkedCard, Q q) {
        super(0);
        this.a = linkedCard;
        this.b = q;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual(this.a, bVar.a) && Intrinsics.areEqual(this.b, bVar.b);
    }

    public final int hashCode() {
        LinkedCard linkedCard = this.a;
        int iHashCode = (linkedCard == null ? 0 : linkedCard.hashCode()) * 31;
        Q q = this.b;
        return iHashCode + (q != null ? q.hashCode() : 0);
    }

    public final String toString() {
        return "StartDisplayData(linkedCard=" + this.a + ", instrumentBankCard=" + this.b + ")";
    }
}
