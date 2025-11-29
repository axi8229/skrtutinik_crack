package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class P extends S {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P(String yooMoneyLogoUrl) {
        super(0);
        Intrinsics.checkNotNullParameter(yooMoneyLogoUrl, "yooMoneyLogoUrl");
        this.a = yooMoneyLogoUrl;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.paymentOptionList.S
    public final String a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof P) && Intrinsics.areEqual(this.a, ((P) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Loading(yooMoneyLogoUrl=" + this.a + ")";
    }
}
