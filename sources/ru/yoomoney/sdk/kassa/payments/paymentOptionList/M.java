package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class M extends S {
    public final String a;
    public final AbstractC2499n0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(String yooMoneyLogoUrl, AbstractC2499n0 content) {
        super(0);
        Intrinsics.checkNotNullParameter(yooMoneyLogoUrl, "yooMoneyLogoUrl");
        Intrinsics.checkNotNullParameter(content, "content");
        this.a = yooMoneyLogoUrl;
        this.b = content;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.paymentOptionList.S
    public final String a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof M)) {
            return false;
        }
        M m = (M) obj;
        return Intrinsics.areEqual(this.a, m.a) && Intrinsics.areEqual(this.b, m.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Content(yooMoneyLogoUrl=" + this.a + ", content=" + this.b + ")";
    }
}
