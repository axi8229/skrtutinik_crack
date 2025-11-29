package ru.yoomoney.sdk.kassa.payments.unbind.ui;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.LinkedCard;

/* loaded from: classes5.dex */
public final class w implements y {
    public final LinkedCard a;

    public w(LinkedCard linkedCard) {
        Intrinsics.checkNotNullParameter(linkedCard, "linkedCard");
        this.a = linkedCard;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof w) && Intrinsics.areEqual(this.a, ((w) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ContentLinkedWallet(linkedCard=" + this.a + ")";
    }
}
