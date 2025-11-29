package ru.yoomoney.sdk.kassa.payments.navigation;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class q extends v {
    public final ru.yoomoney.sdk.kassa.payments.payment.tokenize.l a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(ru.yoomoney.sdk.kassa.payments.payment.tokenize.l tokenOutputModel) {
        super(0);
        Intrinsics.checkNotNullParameter(tokenOutputModel, "tokenOutputModel");
        this.a = tokenOutputModel;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q) && Intrinsics.areEqual(this.a, ((q) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "TokenizeSuccessful(tokenOutputModel=" + this.a + ")";
    }
}
