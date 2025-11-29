package ru.yoomoney.sdk.kassa.payments.confirmation.sbp;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a extends f {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String confirmationData) {
        super(0);
        Intrinsics.checkNotNullParameter(confirmationData, "confirmationData");
        this.a = confirmationData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && Intrinsics.areEqual(this.a, ((a) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "GetConfirmationDetails(confirmationData=" + this.a + ")";
    }
}
