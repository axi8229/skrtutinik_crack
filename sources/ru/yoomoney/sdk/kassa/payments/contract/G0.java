package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.LinkedCard;

/* loaded from: classes5.dex */
public final class G0 extends H0 {
    public final LinkedCard a;
    public final boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G0(LinkedCard paymentOption, boolean z) {
        super(0);
        Intrinsics.checkNotNullParameter(paymentOption, "paymentOption");
        this.a = paymentOption;
        this.b = z;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.contract.H0
    public final ru.yoomoney.sdk.kassa.payments.model.T a() {
        return this.a;
    }

    public final LinkedCard b() {
        return this.a;
    }

    public final boolean c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof G0)) {
            return false;
        }
        G0 g0 = (G0) obj;
        return Intrinsics.areEqual(this.a, g0.a) && this.b == g0.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.b, this.a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "WalletLinkedCardContractInfo(paymentOption=" + this.a + ", showAllowWalletLinking=" + this.b + ", allowWalletLinking=true)";
    }
}
