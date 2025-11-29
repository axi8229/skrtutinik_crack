package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.l0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2493l0 {
    public final int a;
    public final String b;
    public final String c;
    public final Drawable d;
    public final CharSequence e;
    public final CharSequence f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public C2493l0(int i, String str, String str2, Drawable logo, CharSequence title, CharSequence charSequence, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(logo, "logo");
        Intrinsics.checkNotNullParameter(title, "title");
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = logo;
        this.e = title;
        this.f = charSequence;
        this.g = z;
        this.h = z2;
        this.i = z3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2493l0)) {
            return false;
        }
        C2493l0 c2493l0 = (C2493l0) obj;
        return this.a == c2493l0.a && Intrinsics.areEqual(this.b, c2493l0.b) && Intrinsics.areEqual(this.c, c2493l0.c) && Intrinsics.areEqual(this.d, c2493l0.d) && Intrinsics.areEqual(this.e, c2493l0.e) && Intrinsics.areEqual(this.f, c2493l0.f) && this.g == c2493l0.g && this.h == c2493l0.h && this.i == c2493l0.i;
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (this.e.hashCode() + ((this.d.hashCode() + ((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31)) * 31;
        CharSequence charSequence = this.f;
        return Boolean.hashCode(this.i) + ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.h, ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.g, (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31, 31), 31);
    }

    public final String toString() {
        int i = this.a;
        String str = this.b;
        String str2 = this.c;
        Drawable drawable = this.d;
        CharSequence charSequence = this.e;
        CharSequence charSequence2 = this.f;
        return "PaymentOptionListItem(optionId=" + i + ", instrumentId=" + str + ", urlLogo=" + str2 + ", logo=" + drawable + ", title=" + ((Object) charSequence) + ", additionalInfo=" + ((Object) charSequence2) + ", canLogout=" + this.g + ", hasOptions=" + this.h + ", isWalletLinked=" + this.i + ")";
    }
}
