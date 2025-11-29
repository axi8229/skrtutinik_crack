package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b0 extends d0 {
    public final Throwable a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(Throwable value) {
        super(0);
        Intrinsics.checkNotNullParameter(value, "value");
        this.a = value;
    }

    public final Throwable a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b0) && Intrinsics.areEqual(this.a, ((b0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Fail(value=" + this.a + ")";
    }
}
