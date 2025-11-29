package com.sputnik.data.entities.service_payments;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataPromisePayment.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/sputnik/data/entities/service_payments/DataPromisePayment;", "Landroid/os/Parcelable;", "Lcom/sputnik/data/entities/service_payments/DataPaymentHistory;", "accrual", "Lcom/sputnik/data/entities/service_payments/DataPromisedPayment;", "promisedPayment", "<init>", "(Lcom/sputnik/data/entities/service_payments/DataPaymentHistory;Lcom/sputnik/data/entities/service_payments/DataPromisedPayment;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/data/entities/service_payments/DataPaymentHistory;", "getAccrual", "()Lcom/sputnik/data/entities/service_payments/DataPaymentHistory;", "Lcom/sputnik/data/entities/service_payments/DataPromisedPayment;", "getPromisedPayment", "()Lcom/sputnik/data/entities/service_payments/DataPromisedPayment;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataPromisePayment implements Parcelable {
    public static final Parcelable.Creator<DataPromisePayment> CREATOR = new Creator();
    private final DataPaymentHistory accrual;

    @SerializedName("promised_payment")
    private final DataPromisedPayment promisedPayment;

    /* compiled from: DataPromisePayment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataPromisePayment> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPromisePayment createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataPromisePayment(parcel.readInt() == 0 ? null : DataPaymentHistory.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? DataPromisedPayment.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPromisePayment[] newArray(int i) {
            return new DataPromisePayment[i];
        }
    }

    public DataPromisePayment() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataPromisePayment)) {
            return false;
        }
        DataPromisePayment dataPromisePayment = (DataPromisePayment) other;
        return Intrinsics.areEqual(this.accrual, dataPromisePayment.accrual) && Intrinsics.areEqual(this.promisedPayment, dataPromisePayment.promisedPayment);
    }

    public int hashCode() {
        DataPaymentHistory dataPaymentHistory = this.accrual;
        int iHashCode = (dataPaymentHistory == null ? 0 : dataPaymentHistory.hashCode()) * 31;
        DataPromisedPayment dataPromisedPayment = this.promisedPayment;
        return iHashCode + (dataPromisedPayment != null ? dataPromisedPayment.hashCode() : 0);
    }

    public String toString() {
        return "DataPromisePayment(accrual=" + this.accrual + ", promisedPayment=" + this.promisedPayment + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        DataPaymentHistory dataPaymentHistory = this.accrual;
        if (dataPaymentHistory == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataPaymentHistory.writeToParcel(parcel, flags);
        }
        DataPromisedPayment dataPromisedPayment = this.promisedPayment;
        if (dataPromisedPayment == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataPromisedPayment.writeToParcel(parcel, flags);
        }
    }

    public DataPromisePayment(DataPaymentHistory dataPaymentHistory, DataPromisedPayment dataPromisedPayment) {
        this.accrual = dataPaymentHistory;
        this.promisedPayment = dataPromisedPayment;
    }

    public /* synthetic */ DataPromisePayment(DataPaymentHistory dataPaymentHistory, DataPromisedPayment dataPromisedPayment, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : dataPaymentHistory, (i & 2) != 0 ? null : dataPromisedPayment);
    }

    public final DataPaymentHistory getAccrual() {
        return this.accrual;
    }

    public final DataPromisedPayment getPromisedPayment() {
        return this.promisedPayment;
    }
}
