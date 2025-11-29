package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class O extends S {
    public final String a;
    public final Throwable b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O(String yooMoneyLogoUrl, Throwable error) {
        super(0);
        Intrinsics.checkNotNullParameter(yooMoneyLogoUrl, "yooMoneyLogoUrl");
        Intrinsics.checkNotNullParameter(error, "error");
        this.a = yooMoneyLogoUrl;
        this.b = error;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.paymentOptionList.S
    public final String a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof O)) {
            return false;
        }
        O o = (O) obj;
        return Intrinsics.areEqual(this.a, o.a) && Intrinsics.areEqual(this.b, o.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Error(yooMoneyLogoUrl=" + this.a + ", error=" + this.b + ")";
    }
}
