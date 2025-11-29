package ru.yoomoney.sdk.kassa.payments.payment.tokenize;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t;
import ru.yoomoney.sdk.kassa.payments.model.Q;
import ru.yoomoney.sdk.kassa.payments.model.U;

/* loaded from: classes5.dex */
public final class n extends i {
    public static final Parcelable.Creator<n> CREATOR = new m();
    public final int a;
    public final boolean b;
    public final boolean c;
    public final AbstractC2335t d;
    public final U e;
    public final boolean f;
    public final Q g;
    public final String h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(int i, boolean z, boolean z2, AbstractC2335t confirmation, U u, boolean z3, Q q, String str) {
        super(0);
        Intrinsics.checkNotNullParameter(confirmation, "confirmation");
        this.a = i;
        this.b = z;
        this.c = z2;
        this.d = confirmation;
        this.e = u;
        this.f = z3;
        this.g = q;
        this.h = str;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.payment.tokenize.i
    public final boolean a() {
        return this.f;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.payment.tokenize.i
    public final Q b() {
        return this.g;
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
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.a == nVar.a && this.b == nVar.b && this.c == nVar.c && Intrinsics.areEqual(this.d, nVar.d) && Intrinsics.areEqual(this.e, nVar.e) && this.f == nVar.f && Intrinsics.areEqual(this.g, nVar.g) && Intrinsics.areEqual(this.h, nVar.h);
    }

    public final int hashCode() {
        int iHashCode = (this.d.hashCode() + ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.c, ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.b, Integer.hashCode(this.a) * 31, 31), 31)) * 31;
        U u = this.e;
        int iA = ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.f, (iHashCode + (u == null ? 0 : u.hashCode())) * 31, 31);
        Q q = this.g;
        int iHashCode2 = (iA + (q == null ? 0 : q.hashCode())) * 31;
        String str = this.h;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "TokenizePaymentOptionInputModel(paymentOptionId=" + this.a + ", savePaymentMethod=" + this.b + ", savePaymentInstrument=" + this.c + ", confirmation=" + this.d + ", paymentOptionInfo=" + this.e + ", allowWalletLinking=" + this.f + ", instrumentBankCard=" + this.g + ", csc=" + this.h + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.a);
        out.writeInt(this.b ? 1 : 0);
        out.writeInt(this.c ? 1 : 0);
        out.writeParcelable(this.d, i);
        out.writeParcelable(this.e, i);
        out.writeInt(this.f ? 1 : 0);
        Q q = this.g;
        if (q == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            q.writeToParcel(out, i);
        }
        out.writeString(this.h);
    }
}
