package ru.yoomoney.sdk.kassa.payments.userAuth;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.userAuth.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2544g extends AbstractC2546i {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2544g(String cryptogram) {
        super(0);
        Intrinsics.checkNotNullParameter(cryptogram, "cryptogram");
        this.a = cryptogram;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2544g) && Intrinsics.areEqual(this.a, ((C2544g) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "GetTransferData(cryptogram=" + this.a + ")";
    }
}
