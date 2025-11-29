package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class n extends o {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(String deeplink) {
        super(0);
        Intrinsics.checkNotNullParameter(deeplink, "deeplink");
        this.a = deeplink;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof n) && Intrinsics.areEqual(this.a, ((n) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "SelectBank(deeplink=" + this.a + ")";
    }
}
