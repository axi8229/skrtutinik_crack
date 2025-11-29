package com.sputnik.data.entities.profile;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.ui.view.BankCardViewKt;

/* compiled from: DataProfileCardInfo.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b \u0010\rR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b!\u0010\rR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\"\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b#\u0010\rR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b$\u0010\r¨\u0006%"}, d2 = {"Lcom/sputnik/data/entities/profile/DataProfileCardInfo;", "Landroid/os/Parcelable;", "", "first6", "last4", BankCardViewKt.EXTRA_EXPIRY_MONTH, BankCardViewKt.EXTRA_EXPIRY_YEAR, "cardType", "issuerCountry", "issuerName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getFirst6", "getLast4", "getExpiryMonth", "getExpiryYear", "getCardType", "getIssuerCountry", "getIssuerName", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataProfileCardInfo implements Parcelable {
    public static final Parcelable.Creator<DataProfileCardInfo> CREATOR = new Creator();

    @SerializedName("card_type")
    private final String cardType;

    @SerializedName("expiry_month")
    private final String expiryMonth;

    @SerializedName("expiry_year")
    private final String expiryYear;
    private final String first6;

    @SerializedName("issuer_country")
    private final String issuerCountry;

    @SerializedName("issuer_name")
    private final String issuerName;
    private final String last4;

    /* compiled from: DataProfileCardInfo.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataProfileCardInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataProfileCardInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataProfileCardInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataProfileCardInfo[] newArray(int i) {
            return new DataProfileCardInfo[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataProfileCardInfo)) {
            return false;
        }
        DataProfileCardInfo dataProfileCardInfo = (DataProfileCardInfo) other;
        return Intrinsics.areEqual(this.first6, dataProfileCardInfo.first6) && Intrinsics.areEqual(this.last4, dataProfileCardInfo.last4) && Intrinsics.areEqual(this.expiryMonth, dataProfileCardInfo.expiryMonth) && Intrinsics.areEqual(this.expiryYear, dataProfileCardInfo.expiryYear) && Intrinsics.areEqual(this.cardType, dataProfileCardInfo.cardType) && Intrinsics.areEqual(this.issuerCountry, dataProfileCardInfo.issuerCountry) && Intrinsics.areEqual(this.issuerName, dataProfileCardInfo.issuerName);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.first6.hashCode() * 31) + this.last4.hashCode()) * 31) + this.expiryMonth.hashCode()) * 31) + this.expiryYear.hashCode()) * 31) + this.cardType.hashCode()) * 31;
        String str = this.issuerCountry;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.issuerName;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DataProfileCardInfo(first6=" + this.first6 + ", last4=" + this.last4 + ", expiryMonth=" + this.expiryMonth + ", expiryYear=" + this.expiryYear + ", cardType=" + this.cardType + ", issuerCountry=" + this.issuerCountry + ", issuerName=" + this.issuerName + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.first6);
        parcel.writeString(this.last4);
        parcel.writeString(this.expiryMonth);
        parcel.writeString(this.expiryYear);
        parcel.writeString(this.cardType);
        parcel.writeString(this.issuerCountry);
        parcel.writeString(this.issuerName);
    }

    public DataProfileCardInfo(String first6, String last4, String expiryMonth, String expiryYear, String cardType, String str, String str2) {
        Intrinsics.checkNotNullParameter(first6, "first6");
        Intrinsics.checkNotNullParameter(last4, "last4");
        Intrinsics.checkNotNullParameter(expiryMonth, "expiryMonth");
        Intrinsics.checkNotNullParameter(expiryYear, "expiryYear");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        this.first6 = first6;
        this.last4 = last4;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.cardType = cardType;
        this.issuerCountry = str;
        this.issuerName = str2;
    }

    public final String getFirst6() {
        return this.first6;
    }

    public final String getLast4() {
        return this.last4;
    }

    public final String getExpiryMonth() {
        return this.expiryMonth;
    }

    public final String getExpiryYear() {
        return this.expiryYear;
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final String getIssuerCountry() {
        return this.issuerCountry;
    }

    public final String getIssuerName() {
        return this.issuerName;
    }
}
