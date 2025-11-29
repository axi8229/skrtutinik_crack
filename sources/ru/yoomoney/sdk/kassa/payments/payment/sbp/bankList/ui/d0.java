package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d0 extends e0 {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(String title) {
        super(0);
        Intrinsics.checkNotNullParameter(title, "title");
        this.a = title;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d0) && Intrinsics.areEqual(this.a, ((d0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "SelectAnotherBankViewEntity(title=" + this.a + ")";
    }
}
