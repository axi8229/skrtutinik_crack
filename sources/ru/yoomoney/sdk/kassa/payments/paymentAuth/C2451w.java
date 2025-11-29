package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.w, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2451w extends E {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2451w(String passphrase) {
        super(0);
        Intrinsics.checkNotNullParameter(passphrase, "passphrase");
        this.a = passphrase;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2451w) && Intrinsics.areEqual(this.a, ((C2451w) obj).a);
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "ProcessAuthRequired(passphrase=" + this.a + ", linkWalletToApp=true)";
    }
}
