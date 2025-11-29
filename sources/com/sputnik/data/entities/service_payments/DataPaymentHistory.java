package com.sputnik.data.entities.service_payments;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.domain.entities.service_payments.ServicePaymentState;
import com.sputnik.domain.entities.service_payments.ServicePaymentType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataPaymentHistory.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b#\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b'\u0010\u000eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b(\u0010\u000e¨\u0006)"}, d2 = {"Lcom/sputnik/data/entities/service_payments/DataPaymentHistory;", "Landroid/os/Parcelable;", "", "id", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "type", "amount", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentState;", "state", "paymentDate", "payUntil", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;Ljava/lang/String;Lcom/sputnik/domain/entities/service_payments/ServicePaymentState;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getId", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "getType", "()Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "getAmount", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentState;", "getState", "()Lcom/sputnik/domain/entities/service_payments/ServicePaymentState;", "getPaymentDate", "getPayUntil", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataPaymentHistory implements Parcelable {
    public static final Parcelable.Creator<DataPaymentHistory> CREATOR = new Creator();
    private final String amount;

    @SerializedName("uuid")
    private final String id;

    @SerializedName("pay_until")
    private final String payUntil;

    @SerializedName("paid_at")
    private final String paymentDate;

    @SerializedName("state")
    private final ServicePaymentState state;

    @SerializedName("type_of")
    private final ServicePaymentType type;

    /* compiled from: DataPaymentHistory.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataPaymentHistory> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPaymentHistory createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataPaymentHistory(parcel.readString(), parcel.readInt() == 0 ? null : ServicePaymentType.valueOf(parcel.readString()), parcel.readString(), parcel.readInt() == 0 ? null : ServicePaymentState.valueOf(parcel.readString()), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPaymentHistory[] newArray(int i) {
            return new DataPaymentHistory[i];
        }
    }

    public DataPaymentHistory() {
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
        if (!(other instanceof DataPaymentHistory)) {
            return false;
        }
        DataPaymentHistory dataPaymentHistory = (DataPaymentHistory) other;
        return Intrinsics.areEqual(this.id, dataPaymentHistory.id) && this.type == dataPaymentHistory.type && Intrinsics.areEqual(this.amount, dataPaymentHistory.amount) && this.state == dataPaymentHistory.state && Intrinsics.areEqual(this.paymentDate, dataPaymentHistory.paymentDate) && Intrinsics.areEqual(this.payUntil, dataPaymentHistory.payUntil);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        ServicePaymentType servicePaymentType = this.type;
        int iHashCode2 = (iHashCode + (servicePaymentType == null ? 0 : servicePaymentType.hashCode())) * 31;
        String str2 = this.amount;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        ServicePaymentState servicePaymentState = this.state;
        int iHashCode4 = (iHashCode3 + (servicePaymentState == null ? 0 : servicePaymentState.hashCode())) * 31;
        String str3 = this.paymentDate;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.payUntil;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "DataPaymentHistory(id=" + this.id + ", type=" + this.type + ", amount=" + this.amount + ", state=" + this.state + ", paymentDate=" + this.paymentDate + ", payUntil=" + this.payUntil + ")";
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
        ServicePaymentState servicePaymentState = this.state;
        if (servicePaymentState == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(servicePaymentState.name());
        }
        parcel.writeString(this.paymentDate);
        parcel.writeString(this.payUntil);
    }

    public DataPaymentHistory(String str, ServicePaymentType servicePaymentType, String str2, ServicePaymentState servicePaymentState, String str3, String str4) {
        this.id = str;
        this.type = servicePaymentType;
        this.amount = str2;
        this.state = servicePaymentState;
        this.paymentDate = str3;
        this.payUntil = str4;
    }

    public /* synthetic */ DataPaymentHistory(String str, ServicePaymentType servicePaymentType, String str2, ServicePaymentState servicePaymentState, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : servicePaymentType, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : servicePaymentState, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
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

    public final ServicePaymentState getState() {
        return this.state;
    }

    public final String getPaymentDate() {
        return this.paymentDate;
    }

    public final String getPayUntil() {
        return this.payUntil;
    }
}
