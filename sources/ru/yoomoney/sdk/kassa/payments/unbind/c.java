package ru.yoomoney.sdk.kassa.payments.unbind;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c extends f {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String instrumentId) {
        super(0);
        Intrinsics.checkNotNullParameter(instrumentId, "instrumentId");
        this.a = instrumentId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && Intrinsics.areEqual(this.a, ((c) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "StartUnbinding(instrumentId=" + this.a + ")";
    }
}
