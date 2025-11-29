package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.Wallet;

/* loaded from: classes5.dex */
public final class F0 extends H0 {
    public final Wallet a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F0(Wallet paymentOption, String str, String str2, boolean z, boolean z2) {
        super(0);
        Intrinsics.checkNotNullParameter(paymentOption, "paymentOption");
        this.a = paymentOption;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = z2;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.contract.H0
    public final ru.yoomoney.sdk.kassa.payments.model.T a() {
        return this.a;
    }

    public final Wallet b() {
        return this.a;
    }

    public final boolean c() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof F0)) {
            return false;
        }
        F0 f0 = (F0) obj;
        return Intrinsics.areEqual(this.a, f0.a) && Intrinsics.areEqual(this.b, f0.b) && Intrinsics.areEqual(this.c, f0.c) && this.d == f0.d && this.e == f0.e;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        return Boolean.hashCode(this.e) + ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.d, (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31, 31);
    }

    public final String toString() {
        return "WalletContractInfo(paymentOption=" + this.a + ", walletUserAuthName=" + this.b + ", walletUserAvatarUrl=" + this.c + ", showAllowWalletLinking=" + this.d + ", allowWalletLinking=" + this.e + ")";
    }
}
