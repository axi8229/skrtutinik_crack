package ru.yoomoney.sdk.kassa.payments.unbind;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.Q;

/* loaded from: classes5.dex */
public final class h extends i {
    public final Q a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Q instrumentBankCard) {
        super(0);
        Intrinsics.checkNotNullParameter(instrumentBankCard, "instrumentBankCard");
        this.a = instrumentBankCard;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && Intrinsics.areEqual(this.a, ((h) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "UnbindFailed(instrumentBankCard=" + this.a + ")";
    }
}
