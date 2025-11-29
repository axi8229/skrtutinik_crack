package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

/* loaded from: classes5.dex */
public final class Q extends S {
    public final int a;
    public final String b;
    public final M c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(int i, String yooMoneyLogoUrl, M content) {
        super(0);
        Intrinsics.checkNotNullParameter(yooMoneyLogoUrl, "yooMoneyLogoUrl");
        Intrinsics.checkNotNullParameter(content, "content");
        this.a = i;
        this.b = yooMoneyLogoUrl;
        this.c = content;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.paymentOptionList.S
    public final String a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Q)) {
            return false;
        }
        Q q = (Q) obj;
        return this.a == q.a && Intrinsics.areEqual(this.b, q.b) && Intrinsics.areEqual(this.c, q.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + AbstractC1553e.a(this.b, Integer.hashCode(this.a) * 31, 31);
    }

    public final String toString() {
        return "WaitingForAuthState(yoomoneyOptionId=" + this.a + ", yooMoneyLogoUrl=" + this.b + ", content=" + this.c + ")";
    }
}
