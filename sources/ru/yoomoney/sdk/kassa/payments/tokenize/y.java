package ru.yoomoney.sdk.kassa.payments.tokenize;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class y extends z {
    public final ru.yoomoney.sdk.kassa.payments.payment.tokenize.l a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(ru.yoomoney.sdk.kassa.payments.payment.tokenize.l content) {
        super(0);
        Intrinsics.checkNotNullParameter(content, "content");
        this.a = content;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof y) && Intrinsics.areEqual(this.a, ((y) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "TokenizeSuccess(content=" + this.a + ")";
    }
}
