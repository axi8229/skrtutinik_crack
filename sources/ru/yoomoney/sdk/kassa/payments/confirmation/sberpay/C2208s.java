package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.s, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2208s extends AbstractC2210u {
    public final Throwable a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2208s(Throwable throwable) {
        super(0);
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        this.a = throwable;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2208s) && Intrinsics.areEqual(this.a, ((C2208s) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "LoadSberPayInfoFailed(throwable=" + this.a + ")";
    }
}
