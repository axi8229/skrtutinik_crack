package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2436o extends AbstractC2438p {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2436o(String processId) {
        super(0);
        Intrinsics.checkNotNullParameter(processId, "processId");
        this.a = processId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2436o) && Intrinsics.areEqual(this.a, ((C2436o) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Success(processId=" + this.a + ")";
    }
}
