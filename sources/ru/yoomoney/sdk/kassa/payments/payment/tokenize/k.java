package ru.yoomoney.sdk.kassa.payments.payment.tokenize;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t;
import ru.yoomoney.sdk.kassa.payments.model.Q;

/* loaded from: classes5.dex */
public final class k extends i {
    public static final Parcelable.Creator<k> CREATOR = new j();
    public final int a;
    public final boolean b;
    public final Q c;
    public final boolean d;
    public final AbstractC2335t e;
    public final String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(int i, boolean z, Q instrumentBankCard, boolean z2, AbstractC2335t confirmation, String str) {
        super(0);
        Intrinsics.checkNotNullParameter(instrumentBankCard, "instrumentBankCard");
        Intrinsics.checkNotNullParameter(confirmation, "confirmation");
        this.a = i;
        this.b = z;
        this.c = instrumentBankCard;
        this.d = z2;
        this.e = confirmation;
        this.f = str;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.payment.tokenize.i
    public final boolean a() {
        return this.d;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.payment.tokenize.i
    public final Q b() {
        return this.c;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.payment.tokenize.i
    public final int c() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.a == kVar.a && this.b == kVar.b && Intrinsics.areEqual(this.c, kVar.c) && this.d == kVar.d && Intrinsics.areEqual(this.e, kVar.e) && Intrinsics.areEqual(this.f, kVar.f);
    }

    public final int hashCode() {
        int iHashCode = (this.e.hashCode() + ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.d, (this.c.hashCode() + ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.b, Integer.hashCode(this.a) * 31, 31)) * 31, 31)) * 31;
        String str = this.f;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "TokenizeInstrumentInputModel(paymentOptionId=" + this.a + ", savePaymentMethod=" + this.b + ", instrumentBankCard=" + this.c + ", allowWalletLinking=" + this.d + ", confirmation=" + this.e + ", csc=" + this.f + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.a);
        out.writeInt(this.b ? 1 : 0);
        this.c.writeToParcel(out, i);
        out.writeInt(this.d ? 1 : 0);
        out.writeParcelable(this.e, i);
        out.writeString(this.f);
    }
}
