package com.sputnik.data.entities.service_payments;

import android.os.Parcel;
import android.os.Parcelable;
import com.sputnik.domain.usecases.service_payments.PromisePaymentStates;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataPromisedPayment.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u001d\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001e\u0010\rR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010\u001d\u0012\u0004\b\"\u0010 \u001a\u0004\b!\u0010\rR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u001d\u0012\u0004\b$\u0010 \u001a\u0004\b#\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b(\u0010\rR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b)\u0010\r¨\u0006*"}, d2 = {"Lcom/sputnik/data/entities/service_payments/DataPromisedPayment;", "Landroid/os/Parcelable;", "", "accrualUuid", "activatedAt", "expiresAt", "Lcom/sputnik/domain/usecases/service_payments/PromisePaymentStates;", "state", "type", "uuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/usecases/service_payments/PromisePaymentStates;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAccrualUuid", "getAccrualUuid$annotations", "()V", "getActivatedAt", "getActivatedAt$annotations", "getExpiresAt", "getExpiresAt$annotations", "Lcom/sputnik/domain/usecases/service_payments/PromisePaymentStates;", "getState", "()Lcom/sputnik/domain/usecases/service_payments/PromisePaymentStates;", "getType", "getUuid", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataPromisedPayment implements Parcelable {
    public static final Parcelable.Creator<DataPromisedPayment> CREATOR = new Creator();
    private final String accrualUuid;
    private final String activatedAt;
    private final String expiresAt;
    private final PromisePaymentStates state;
    private final String type;
    private final String uuid;

    /* compiled from: DataPromisedPayment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataPromisedPayment> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPromisedPayment createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataPromisedPayment(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : PromisePaymentStates.valueOf(parcel.readString()), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPromisedPayment[] newArray(int i) {
            return new DataPromisedPayment[i];
        }
    }

    public DataPromisedPayment() {
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
        if (!(other instanceof DataPromisedPayment)) {
            return false;
        }
        DataPromisedPayment dataPromisedPayment = (DataPromisedPayment) other;
        return Intrinsics.areEqual(this.accrualUuid, dataPromisedPayment.accrualUuid) && Intrinsics.areEqual(this.activatedAt, dataPromisedPayment.activatedAt) && Intrinsics.areEqual(this.expiresAt, dataPromisedPayment.expiresAt) && this.state == dataPromisedPayment.state && Intrinsics.areEqual(this.type, dataPromisedPayment.type) && Intrinsics.areEqual(this.uuid, dataPromisedPayment.uuid);
    }

    public int hashCode() {
        String str = this.accrualUuid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.activatedAt;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.expiresAt;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        PromisePaymentStates promisePaymentStates = this.state;
        int iHashCode4 = (iHashCode3 + (promisePaymentStates == null ? 0 : promisePaymentStates.hashCode())) * 31;
        String str4 = this.type;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.uuid;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "DataPromisedPayment(accrualUuid=" + this.accrualUuid + ", activatedAt=" + this.activatedAt + ", expiresAt=" + this.expiresAt + ", state=" + this.state + ", type=" + this.type + ", uuid=" + this.uuid + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.accrualUuid);
        parcel.writeString(this.activatedAt);
        parcel.writeString(this.expiresAt);
        PromisePaymentStates promisePaymentStates = this.state;
        if (promisePaymentStates == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(promisePaymentStates.name());
        }
        parcel.writeString(this.type);
        parcel.writeString(this.uuid);
    }

    public DataPromisedPayment(String str, String str2, String str3, PromisePaymentStates promisePaymentStates, String str4, String str5) {
        this.accrualUuid = str;
        this.activatedAt = str2;
        this.expiresAt = str3;
        this.state = promisePaymentStates;
        this.type = str4;
        this.uuid = str5;
    }

    public /* synthetic */ DataPromisedPayment(String str, String str2, String str3, PromisePaymentStates promisePaymentStates, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : promisePaymentStates, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }

    public final String getAccrualUuid() {
        return this.accrualUuid;
    }

    public final String getActivatedAt() {
        return this.activatedAt;
    }

    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public final PromisePaymentStates getState() {
        return this.state;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUuid() {
        return this.uuid;
    }
}
