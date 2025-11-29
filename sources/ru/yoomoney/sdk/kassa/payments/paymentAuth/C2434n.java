package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.n, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2434n extends AbstractC2438p {
    public final String a;
    public final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2434n(String str, String processId) {
        super(0);
        Intrinsics.checkNotNullParameter(processId, "processId");
        this.a = str;
        this.b = processId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2434n)) {
            return false;
        }
        C2434n c2434n = (C2434n) obj;
        return Intrinsics.areEqual(this.a, c2434n.a) && Intrinsics.areEqual(this.b, c2434n.b);
    }

    public final int hashCode() {
        String str = this.a;
        return this.b.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public final String toString() {
        return "AuthRequired(authContextId=" + this.a + ", processId=" + this.b + ")";
    }
}
