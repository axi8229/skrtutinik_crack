package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2248q extends AbstractC2251s {
    public final Throwable a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2248q(Throwable error) {
        super(0);
        Intrinsics.checkNotNullParameter(error, "error");
        this.a = error;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2248q) && Intrinsics.areEqual(this.a, ((C2248q) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Error(error=" + this.a + ")";
    }
}
