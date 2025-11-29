package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.model.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2320d extends C2319c {
    public final C2337v b;
    public final AbstractC2330n c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2320d(C2337v error, AbstractC2330n abstractC2330n) {
        super(error);
        Intrinsics.checkNotNullParameter(error, "error");
        this.b = error;
        this.c = abstractC2330n;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.model.C2319c
    public final C2337v a() {
        return this.b;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.model.C2319c
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2320d)) {
            return false;
        }
        C2320d c2320d = (C2320d) obj;
        return Intrinsics.areEqual(this.b, c2320d.b) && Intrinsics.areEqual(this.c, c2320d.c);
    }

    @Override // ru.yoomoney.sdk.kassa.payments.model.C2319c
    public final int hashCode() {
        int iHashCode = this.b.hashCode() * 31;
        AbstractC2330n abstractC2330n = this.c;
        return iHashCode + (abstractC2330n == null ? 0 : abstractC2330n.hashCode());
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return "AuthCheckApiMethodException(error=" + this.b + ", authState=" + this.c + ")";
    }
}
