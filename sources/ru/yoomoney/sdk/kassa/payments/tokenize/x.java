package ru.yoomoney.sdk.kassa.payments.tokenize;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class x extends z {
    public final Throwable a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(Throwable error) {
        super(0);
        Intrinsics.checkNotNullParameter(error, "error");
        this.a = error;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof x) && Intrinsics.areEqual(this.a, ((x) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "TokenizeFailed(error=" + this.a + ")";
    }
}
