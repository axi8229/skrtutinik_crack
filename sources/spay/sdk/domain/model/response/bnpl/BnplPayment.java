package spay.sdk.domain.model.response.bnpl;

import android.os.Parcel;
import android.os.Parcelable;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Q1;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001e"}, d2 = {"Lspay/sdk/domain/model/response/bnpl/BnplPayment;", "Landroid/os/Parcelable;", FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, "", "amount", "", "currencyCode", "(Ljava/lang/String;JLjava/lang/String;)V", "getAmount", "()J", "getCurrencyCode", "()Ljava/lang/String;", "getDate", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BnplPayment implements Parcelable {
    public static final Parcelable.Creator<BnplPayment> CREATOR = new Creator();
    private final long amount;
    private final String currencyCode;
    private final String date;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BnplPayment> {
        @Override // android.os.Parcelable.Creator
        public final BnplPayment createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BnplPayment(parcel.readString(), parcel.readLong(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final BnplPayment[] newArray(int i) {
            return new BnplPayment[i];
        }
    }

    public BnplPayment(String date, long j, String currencyCode) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
        this.date = date;
        this.amount = j;
        this.currencyCode = currencyCode;
    }

    public static /* synthetic */ BnplPayment copy$default(BnplPayment bnplPayment, String str, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bnplPayment.date;
        }
        if ((i & 2) != 0) {
            j = bnplPayment.amount;
        }
        if ((i & 4) != 0) {
            str2 = bnplPayment.currencyCode;
        }
        return bnplPayment.copy(str, j, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component2, reason: from getter */
    public final long getAmount() {
        return this.amount;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    public final BnplPayment copy(String date, long amount, String currencyCode) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
        return new BnplPayment(date, amount, currencyCode);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BnplPayment)) {
            return false;
        }
        BnplPayment bnplPayment = (BnplPayment) other;
        return Intrinsics.areEqual(this.date, bnplPayment.date) && this.amount == bnplPayment.amount && Intrinsics.areEqual(this.currencyCode, bnplPayment.currencyCode);
    }

    public final long getAmount() {
        return this.amount;
    }

    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    public final String getDate() {
        return this.date;
    }

    public int hashCode() {
        return this.currencyCode.hashCode() + ((Long.hashCode(this.amount) + (this.date.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BnplPayment(date=");
        sb.append(this.date);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", currencyCode=");
        return Q1.a(sb, this.currencyCode, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.date);
        parcel.writeLong(this.amount);
        parcel.writeString(this.currencyCode);
    }
}
