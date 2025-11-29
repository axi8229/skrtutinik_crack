package com.sputnik.service_payments.entities.payments;

import android.os.Parcel;
import android.os.Parcelable;
import com.sputnik.domain.entities.service_payments.ServicePaymentState;
import com.sputnik.domain.entities.service_payments.ServicePaymentType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PaymentHistory.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0010R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010 \u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010'R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b+\u0010\u0010R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b,\u0010\u0010R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010-\u001a\u0004\b.\u0010/R\u0011\u00101\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b0\u0010\u0010¨\u00062"}, d2 = {"Lcom/sputnik/service_payments/entities/payments/PaymentHistory;", "Landroid/os/Parcelable;", "", "id", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "type", "_amount", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentState;", "state", "paymentDate", "payUntil", "", "timeInMillis", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;Ljava/lang/String;Lcom/sputnik/domain/entities/service_payments/ServicePaymentState;Ljava/lang/String;Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getId", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "getType", "()Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "get_amount", "set_amount", "(Ljava/lang/String;)V", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentState;", "getState", "()Lcom/sputnik/domain/entities/service_payments/ServicePaymentState;", "getPaymentDate", "getPayUntil", "J", "getTimeInMillis", "()J", "getAmount", "amount", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PaymentHistory implements Parcelable {
    public static final Parcelable.Creator<PaymentHistory> CREATOR = new Creator();
    private String _amount;
    private final String id;
    private final String payUntil;
    private final String paymentDate;
    private final ServicePaymentState state;
    private final long timeInMillis;
    private final ServicePaymentType type;

    /* compiled from: PaymentHistory.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PaymentHistory> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PaymentHistory createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PaymentHistory(parcel.readString(), parcel.readInt() == 0 ? null : ServicePaymentType.valueOf(parcel.readString()), parcel.readString(), parcel.readInt() == 0 ? null : ServicePaymentState.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PaymentHistory[] newArray(int i) {
            return new PaymentHistory[i];
        }
    }

    public PaymentHistory() {
        this(null, null, null, null, null, null, 0L, 127, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentHistory)) {
            return false;
        }
        PaymentHistory paymentHistory = (PaymentHistory) other;
        return Intrinsics.areEqual(this.id, paymentHistory.id) && this.type == paymentHistory.type && Intrinsics.areEqual(this._amount, paymentHistory._amount) && this.state == paymentHistory.state && Intrinsics.areEqual(this.paymentDate, paymentHistory.paymentDate) && Intrinsics.areEqual(this.payUntil, paymentHistory.payUntil) && this.timeInMillis == paymentHistory.timeInMillis;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        ServicePaymentType servicePaymentType = this.type;
        int iHashCode2 = (iHashCode + (servicePaymentType == null ? 0 : servicePaymentType.hashCode())) * 31;
        String str2 = this._amount;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        ServicePaymentState servicePaymentState = this.state;
        int iHashCode4 = (iHashCode3 + (servicePaymentState == null ? 0 : servicePaymentState.hashCode())) * 31;
        String str3 = this.paymentDate;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.payUntil;
        return ((iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31) + Long.hashCode(this.timeInMillis);
    }

    public String toString() {
        return "PaymentHistory(id=" + this.id + ", type=" + this.type + ", _amount=" + this._amount + ", state=" + this.state + ", paymentDate=" + this.paymentDate + ", payUntil=" + this.payUntil + ", timeInMillis=" + this.timeInMillis + ")";
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
        parcel.writeString(this._amount);
        ServicePaymentState servicePaymentState = this.state;
        if (servicePaymentState == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(servicePaymentState.name());
        }
        parcel.writeString(this.paymentDate);
        parcel.writeString(this.payUntil);
        parcel.writeLong(this.timeInMillis);
    }

    public PaymentHistory(String str, ServicePaymentType servicePaymentType, String str2, ServicePaymentState servicePaymentState, String str3, String str4, long j) {
        this.id = str;
        this.type = servicePaymentType;
        this._amount = str2;
        this.state = servicePaymentState;
        this.paymentDate = str3;
        this.payUntil = str4;
        this.timeInMillis = j;
    }

    public /* synthetic */ PaymentHistory(String str, ServicePaymentType servicePaymentType, String str2, ServicePaymentState servicePaymentState, String str3, String str4, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : servicePaymentType, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : servicePaymentState, (i & 16) != 0 ? null : str3, (i & 32) == 0 ? str4 : null, (i & 64) != 0 ? 0L : j);
    }

    public final String getId() {
        return this.id;
    }

    public final ServicePaymentType getType() {
        return this.type;
    }

    public final String get_amount() {
        return this._amount;
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

    public final long getTimeInMillis() {
        return this.timeInMillis;
    }

    public final String getAmount() {
        String str = this._amount;
        if (str == null) {
            str = "0";
        }
        return str + " ₽";
    }
}
