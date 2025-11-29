package spay.sdk.domain.model.response;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Q1;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lspay/sdk/domain/model/response/CardAmountData;", "Landroid/os/Parcelable;", "amount", "", "currency", "", "(ILjava/lang/String;)V", "getAmount", "()I", "getCurrency", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CardAmountData implements Parcelable {
    public static final Parcelable.Creator<CardAmountData> CREATOR = new Creator();
    private final int amount;
    private final String currency;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CardAmountData> {
        @Override // android.os.Parcelable.Creator
        public final CardAmountData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CardAmountData(parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final CardAmountData[] newArray(int i) {
            return new CardAmountData[i];
        }
    }

    public CardAmountData(int i, String currency) {
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.amount = i;
        this.currency = currency;
    }

    public static /* synthetic */ CardAmountData copy$default(CardAmountData cardAmountData, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cardAmountData.amount;
        }
        if ((i2 & 2) != 0) {
            str = cardAmountData.currency;
        }
        return cardAmountData.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    public final CardAmountData copy(int amount, String currency) {
        Intrinsics.checkNotNullParameter(currency, "currency");
        return new CardAmountData(amount, currency);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardAmountData)) {
            return false;
        }
        CardAmountData cardAmountData = (CardAmountData) other;
        return this.amount == cardAmountData.amount && Intrinsics.areEqual(this.currency, cardAmountData.currency);
    }

    public final int getAmount() {
        return this.amount;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public int hashCode() {
        return this.currency.hashCode() + (Integer.hashCode(this.amount) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CardAmountData(amount=");
        sb.append(this.amount);
        sb.append(", currency=");
        return Q1.a(sb, this.currency, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.amount);
        parcel.writeString(this.currency);
    }
}
