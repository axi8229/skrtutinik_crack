package com.sputnik.data.entities.service_payments;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.domain.entities.service_payments.IntercomPaymentState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataIntercomPaymentInfo.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\"\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b#\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b$\u0010\rR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b%\u0010\r¨\u0006&"}, d2 = {"Lcom/sputnik/data/entities/service_payments/DataIntercomPaymentInfo;", "Landroid/os/Parcelable;", "", "uuid", "Lcom/sputnik/domain/entities/service_payments/IntercomPaymentState;", "state", "amount", "paidAt", "paymentSystem", "confirmationUrl", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/service_payments/IntercomPaymentState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getUuid", "Lcom/sputnik/domain/entities/service_payments/IntercomPaymentState;", "getState", "()Lcom/sputnik/domain/entities/service_payments/IntercomPaymentState;", "getAmount", "getPaidAt", "getPaymentSystem", "getConfirmationUrl", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataIntercomPaymentInfo implements Parcelable {
    public static final Parcelable.Creator<DataIntercomPaymentInfo> CREATOR = new Creator();
    private final String amount;

    @SerializedName("confirmation")
    private final String confirmationUrl;

    @SerializedName("paid_at")
    private final String paidAt;

    @SerializedName("payment_system")
    private final String paymentSystem;
    private final IntercomPaymentState state;
    private final String uuid;

    /* compiled from: DataIntercomPaymentInfo.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataIntercomPaymentInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataIntercomPaymentInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataIntercomPaymentInfo(parcel.readString(), parcel.readInt() == 0 ? null : IntercomPaymentState.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataIntercomPaymentInfo[] newArray(int i) {
            return new DataIntercomPaymentInfo[i];
        }
    }

    public DataIntercomPaymentInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataIntercomPaymentInfo)) {
            return false;
        }
        DataIntercomPaymentInfo dataIntercomPaymentInfo = (DataIntercomPaymentInfo) other;
        return Intrinsics.areEqual(this.uuid, dataIntercomPaymentInfo.uuid) && this.state == dataIntercomPaymentInfo.state && Intrinsics.areEqual(this.amount, dataIntercomPaymentInfo.amount) && Intrinsics.areEqual(this.paidAt, dataIntercomPaymentInfo.paidAt) && Intrinsics.areEqual(this.paymentSystem, dataIntercomPaymentInfo.paymentSystem) && Intrinsics.areEqual(this.confirmationUrl, dataIntercomPaymentInfo.confirmationUrl);
    }

    public int hashCode() {
        String str = this.uuid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        IntercomPaymentState intercomPaymentState = this.state;
        int iHashCode2 = (iHashCode + (intercomPaymentState == null ? 0 : intercomPaymentState.hashCode())) * 31;
        String str2 = this.amount;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.paidAt;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.paymentSystem;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.confirmationUrl;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "DataIntercomPaymentInfo(uuid=" + this.uuid + ", state=" + this.state + ", amount=" + this.amount + ", paidAt=" + this.paidAt + ", paymentSystem=" + this.paymentSystem + ", confirmationUrl=" + this.confirmationUrl + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.uuid);
        IntercomPaymentState intercomPaymentState = this.state;
        if (intercomPaymentState == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(intercomPaymentState.name());
        }
        parcel.writeString(this.amount);
        parcel.writeString(this.paidAt);
        parcel.writeString(this.paymentSystem);
        parcel.writeString(this.confirmationUrl);
    }

    public DataIntercomPaymentInfo(String str, IntercomPaymentState intercomPaymentState, String str2, String str3, String str4, String str5) {
        this.uuid = str;
        this.state = intercomPaymentState;
        this.amount = str2;
        this.paidAt = str3;
        this.paymentSystem = str4;
        this.confirmationUrl = str5;
    }

    public /* synthetic */ DataIntercomPaymentInfo(String str, IntercomPaymentState intercomPaymentState, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : intercomPaymentState, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final IntercomPaymentState getState() {
        return this.state;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getPaidAt() {
        return this.paidAt;
    }

    public final String getPaymentSystem() {
        return this.paymentSystem;
    }

    public final String getConfirmationUrl() {
        return this.confirmationUrl;
    }
}
