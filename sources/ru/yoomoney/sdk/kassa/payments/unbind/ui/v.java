package ru.yoomoney.sdk.kassa.payments.unbind.ui;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.Q;

/* loaded from: classes5.dex */
public final class v implements y {
    public final boolean a;
    public final Q b;

    public v(Q instrumentBankCard, boolean z) {
        Intrinsics.checkNotNullParameter(instrumentBankCard, "instrumentBankCard");
        this.a = z;
        this.b = instrumentBankCard;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.a == vVar.a && Intrinsics.areEqual(this.b, vVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Boolean.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "ContentLinkedBankCard(showProgress=" + this.a + ", instrumentBankCard=" + this.b + ")";
    }
}
