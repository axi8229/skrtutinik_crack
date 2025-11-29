package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2230h extends AbstractC2236k {
    public final ru.yoomoney.sdk.kassa.payments.model.U a;

    public C2230h(ru.yoomoney.sdk.kassa.payments.model.U u) {
        super(0);
        this.a = u;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2230h) && Intrinsics.areEqual(this.a, ((C2230h) obj).a);
    }

    public final int hashCode() {
        ru.yoomoney.sdk.kassa.payments.model.U u = this.a;
        if (u == null) {
            return 0;
        }
        return u.hashCode();
    }

    public final String toString() {
        return "Tokenize(paymentOptionInfo=" + this.a + ")";
    }
}
