package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.SavePaymentMethod;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t;
import ru.yoomoney.sdk.kassa.payments.model.SavePaymentMethodOptionTexts;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.p, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2246p extends AbstractC2251s {
    public final CharSequence a;
    public final CharSequence b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final SavePaymentMethod f;
    public final H0 g;
    public final AbstractC2335t h;
    public final boolean i;
    public final String j;
    public final SavePaymentMethodOptionTexts k;
    public final String l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2246p(CharSequence shopTitle, CharSequence shopSubtitle, boolean z, boolean z2, boolean z3, SavePaymentMethod savePaymentMethod, H0 contractInfo, AbstractC2335t confirmation, boolean z4, String str, SavePaymentMethodOptionTexts savePaymentMethodOptionTexts, String str2) {
        super(0);
        Intrinsics.checkNotNullParameter(shopTitle, "shopTitle");
        Intrinsics.checkNotNullParameter(shopSubtitle, "shopSubtitle");
        Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
        Intrinsics.checkNotNullParameter(contractInfo, "contractInfo");
        Intrinsics.checkNotNullParameter(confirmation, "confirmation");
        Intrinsics.checkNotNullParameter(savePaymentMethodOptionTexts, "savePaymentMethodOptionTexts");
        this.a = shopTitle;
        this.b = shopSubtitle;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = savePaymentMethod;
        this.g = contractInfo;
        this.h = confirmation;
        this.i = z4;
        this.j = str;
        this.k = savePaymentMethodOptionTexts;
        this.l = str2;
    }

    public static C2246p a(C2246p c2246p, boolean z, boolean z2, F0 f0, int i) {
        CharSequence shopTitle = c2246p.a;
        CharSequence shopSubtitle = c2246p.b;
        boolean z3 = c2246p.c;
        boolean z4 = (i & 8) != 0 ? c2246p.d : z;
        boolean z5 = (i & 16) != 0 ? c2246p.e : z2;
        SavePaymentMethod savePaymentMethod = c2246p.f;
        H0 contractInfo = (i & 64) != 0 ? c2246p.g : f0;
        AbstractC2335t confirmation = c2246p.h;
        boolean z6 = c2246p.i;
        String str = c2246p.j;
        SavePaymentMethodOptionTexts savePaymentMethodOptionTexts = c2246p.k;
        String str2 = c2246p.l;
        Intrinsics.checkNotNullParameter(shopTitle, "shopTitle");
        Intrinsics.checkNotNullParameter(shopSubtitle, "shopSubtitle");
        Intrinsics.checkNotNullParameter(savePaymentMethod, "savePaymentMethod");
        Intrinsics.checkNotNullParameter(contractInfo, "contractInfo");
        Intrinsics.checkNotNullParameter(confirmation, "confirmation");
        Intrinsics.checkNotNullParameter(savePaymentMethodOptionTexts, "savePaymentMethodOptionTexts");
        return new C2246p(shopTitle, shopSubtitle, z3, z4, z5, savePaymentMethod, contractInfo, confirmation, z6, str, savePaymentMethodOptionTexts, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2246p)) {
            return false;
        }
        C2246p c2246p = (C2246p) obj;
        return Intrinsics.areEqual(this.a, c2246p.a) && Intrinsics.areEqual(this.b, c2246p.b) && this.c == c2246p.c && this.d == c2246p.d && this.e == c2246p.e && this.f == c2246p.f && Intrinsics.areEqual(this.g, c2246p.g) && Intrinsics.areEqual(this.h, c2246p.h) && this.i == c2246p.i && Intrinsics.areEqual(this.j, c2246p.j) && Intrinsics.areEqual(this.k, c2246p.k) && Intrinsics.areEqual(this.l, c2246p.l);
    }

    public final int hashCode() {
        int iA = ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.i, (this.h.hashCode() + ((this.g.hashCode() + ((this.f.hashCode() + ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.e, ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.d, ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.c, (this.b.hashCode() + (this.a.hashCode() * 31)) * 31, 31), 31), 31)) * 31)) * 31)) * 31, 31);
        String str = this.j;
        int iHashCode = (this.k.hashCode() + ((iA + (str == null ? 0 : str.hashCode())) * 31)) * 31;
        String str2 = this.l;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        CharSequence charSequence = this.a;
        CharSequence charSequence2 = this.b;
        return "Content(shopTitle=" + ((Object) charSequence) + ", shopSubtitle=" + ((Object) charSequence2) + ", isSinglePaymentMethod=" + this.c + ", shouldSavePaymentMethod=" + this.d + ", shouldSavePaymentInstrument=" + this.e + ", savePaymentMethod=" + this.f + ", contractInfo=" + this.g + ", confirmation=" + this.h + ", isSplitPayment=" + this.i + ", customerId=" + this.j + ", savePaymentMethodOptionTexts=" + this.k + ", userAgreementUrl=" + this.l + ")";
    }
}
