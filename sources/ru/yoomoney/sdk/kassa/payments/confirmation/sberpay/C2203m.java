package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2203m extends AbstractC2205o {
    public final Throwable a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2203m(Throwable throwable) {
        super(0);
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        this.a = throwable;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2203m) && Intrinsics.areEqual(this.a, ((C2203m) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "LoadSberPayInfoFailed(throwable=" + this.a + ")";
    }
}
