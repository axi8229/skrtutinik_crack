package com.sputnik.data.entities.service_payments;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.domain.entities.service_payments.IntercomPaymentState;
import com.sputnik.domain.entities.service_payments.ServicePaymentType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataPaymentItem.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b#\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b'\u0010\u000eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b(\u0010\u000e¨\u0006)"}, d2 = {"Lcom/sputnik/data/entities/service_payments/DataPaymentItem;", "Landroid/os/Parcelable;", "", "id", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "type", "amount", "Lcom/sputnik/domain/entities/service_payments/IntercomPaymentState;", "state", "paymentDate", "linkToken", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;Ljava/lang/String;Lcom/sputnik/domain/entities/service_payments/IntercomPaymentState;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getId", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "getType", "()Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "getAmount", "Lcom/sputnik/domain/entities/service_payments/IntercomPaymentState;", "getState", "()Lcom/sputnik/domain/entities/service_payments/IntercomPaymentState;", "getPaymentDate", "getLinkToken", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataPaymentItem implements Parcelable {
    public static final Parcelable.Creator<DataPaymentItem> CREATOR = new Creator();
    private final String amount;
    private final String id;

    @SerializedName("link_token")
    private final String linkToken;

    @SerializedName("accrued_at")
    private final String paymentDate;

    @SerializedName("state")
    private final IntercomPaymentState state;
    private final ServicePaymentType type;

    /* compiled from: DataPaymentItem.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataPaymentItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPaymentItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataPaymentItem(parcel.readString(), parcel.readInt() == 0 ? null : ServicePaymentType.valueOf(parcel.readString()), parcel.readString(), parcel.readInt() == 0 ? null : IntercomPaymentState.valueOf(parcel.readString()), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPaymentItem[] newArray(int i) {
            return new DataPaymentItem[i];
        }
    }

    public DataPaymentItem() {
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
        if (!(other instanceof DataPaymentItem)) {
            return false;
        }
        DataPaymentItem dataPaymentItem = (DataPaymentItem) other;
        return Intrinsics.areEqual(this.id, dataPaymentItem.id) && this.type == dataPaymentItem.type && Intrinsics.areEqual(this.amount, dataPaymentItem.amount) && this.state == dataPaymentItem.state && Intrinsics.areEqual(this.paymentDate, dataPaymentItem.paymentDate) && Intrinsics.areEqual(this.linkToken, dataPaymentItem.linkToken);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        ServicePaymentType servicePaymentType = this.type;
        int iHashCode2 = (iHashCode + (servicePaymentType == null ? 0 : servicePaymentType.hashCode())) * 31;
        String str2 = this.amount;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        IntercomPaymentState intercomPaymentState = this.state;
        int iHashCode4 = (iHashCode3 + (intercomPaymentState == null ? 0 : intercomPaymentState.hashCode())) * 31;
        String str3 = this.paymentDate;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.linkToken;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "DataPaymentItem(id=" + this.id + ", type=" + this.type + ", amount=" + this.amount + ", state=" + this.state + ", paymentDate=" + this.paymentDate + ", linkToken=" + this.linkToken + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        ServicePaymentType servicePaymentType = this.type;
        if (servicePaymentType == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(servicePaymentType.name());
        }
        parcel.writeString(this.amount);
        IntercomPaymentState intercomPaymentState = this.state;
        if (intercomPaymentState == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(intercomPaymentState.name());
        }
        parcel.writeString(this.paymentDate);
        parcel.writeString(this.linkToken);
    }

    public DataPaymentItem(String str, ServicePaymentType servicePaymentType, String str2, IntercomPaymentState intercomPaymentState, String str3, String str4) {
        this.id = str;
        this.type = servicePaymentType;
        this.amount = str2;
        this.state = intercomPaymentState;
        this.paymentDate = str3;
        this.linkToken = str4;
    }

    public /* synthetic */ DataPaymentItem(String str, ServicePaymentType servicePaymentType, String str2, IntercomPaymentState intercomPaymentState, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : servicePaymentType, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : intercomPaymentState, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
    }

    public final String getId() {
        return this.id;
    }

    public final ServicePaymentType getType() {
        return this.type;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final IntercomPaymentState getState() {
        return this.state;
    }

    public final String getPaymentDate() {
        return this.paymentDate;
    }

    public final String getLinkToken() {
        return this.linkToken;
    }
}
