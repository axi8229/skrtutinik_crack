package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2222d extends AbstractC2236k {
    public final Throwable a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2222d(ru.yoomoney.sdk.kassa.payments.model.p0 error) {
        super(0);
        Intrinsics.checkNotNullParameter(error, "error");
        this.a = error;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2222d) && Intrinsics.areEqual(this.a, ((C2222d) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "LoadContractFailed(error=" + this.a + ")";
    }
}
