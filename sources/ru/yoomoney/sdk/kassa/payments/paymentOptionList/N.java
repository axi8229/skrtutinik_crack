package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* loaded from: classes5.dex */
public final class N extends S {
    public final String a;
    public final ru.yoomoney.sdk.kassa.payments.model.Q b;
    public final AbstractC2499n0 c;
    public final int d;
    public final Amount e;
    public final String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(String yooMoneyLogoUrl, ru.yoomoney.sdk.kassa.payments.model.Q instrumentBankCard, AbstractC2499n0 content, int i, Amount amount, String instrumentId) {
        super(0);
        Intrinsics.checkNotNullParameter(yooMoneyLogoUrl, "yooMoneyLogoUrl");
        Intrinsics.checkNotNullParameter(instrumentBankCard, "instrumentBankCard");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(instrumentId, "instrumentId");
        this.a = yooMoneyLogoUrl;
        this.b = instrumentBankCard;
        this.c = content;
        this.d = i;
        this.e = amount;
        this.f = instrumentId;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.paymentOptionList.S
    public final String a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N)) {
            return false;
        }
        N n = (N) obj;
        return Intrinsics.areEqual(this.a, n.a) && Intrinsics.areEqual(this.b, n.b) && Intrinsics.areEqual(this.c, n.c) && this.d == n.d && Intrinsics.areEqual(this.e, n.e) && Intrinsics.areEqual(this.f, n.f);
    }

    public final int hashCode() {
        return this.f.hashCode() + ((this.e.hashCode() + ((Integer.hashCode(this.d) + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ContentWithUnbindingAlert(yooMoneyLogoUrl=" + this.a + ", instrumentBankCard=" + this.b + ", content=" + this.c + ", optionId=" + this.d + ", amount=" + this.e + ", instrumentId=" + this.f + ")";
    }
}
