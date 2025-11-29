package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c0 extends d0 {
    public final Object a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(Object value) {
        super(0);
        Intrinsics.checkNotNullParameter(value, "value");
        this.a = value;
    }

    public final Object a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c0) && Intrinsics.areEqual(this.a, ((c0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Success(value=" + this.a + ")";
    }
}
