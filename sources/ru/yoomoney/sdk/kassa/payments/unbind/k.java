package ru.yoomoney.sdk.kassa.payments.unbind;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.LinkedCard;

/* loaded from: classes5.dex */
public final class k extends n {
    public final LinkedCard a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(LinkedCard linkedCard) {
        super(0);
        Intrinsics.checkNotNullParameter(linkedCard, "linkedCard");
        this.a = linkedCard;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && Intrinsics.areEqual(this.a, ((k) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ContentLinkedWallet(linkedCard=" + this.a + ")";
    }
}
