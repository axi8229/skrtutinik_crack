package ru.yoomoney.sdk.kassa.payments.userAuth;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.userAuth.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2550m extends AbstractC2554q {
    public final AbstractC2549l a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2550m(AbstractC2549l authorizeStrategy) {
        super(0);
        Intrinsics.checkNotNullParameter(authorizeStrategy, "authorizeStrategy");
        this.a = authorizeStrategy;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2550m) && Intrinsics.areEqual(this.a, ((C2550m) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Authorize(authorizeStrategy=" + this.a + ")";
    }
}
