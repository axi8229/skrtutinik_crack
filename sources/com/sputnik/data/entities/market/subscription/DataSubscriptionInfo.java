package com.sputnik.data.entities.market.subscription;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.domain.entities.card.PaymentState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataSubscriptionInfo.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/sputnik/data/entities/market/subscription/DataSubscriptionInfo;", "Landroid/os/Parcelable;", "", "productId", "Lcom/sputnik/domain/entities/card/PaymentState;", "state", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/card/PaymentState;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getProductId", "Lcom/sputnik/domain/entities/card/PaymentState;", "getState", "()Lcom/sputnik/domain/entities/card/PaymentState;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataSubscriptionInfo implements Parcelable {
    public static final Parcelable.Creator<DataSubscriptionInfo> CREATOR = new Creator();

    @SerializedName("product_id")
    private final String productId;
    private final PaymentState state;

    /* compiled from: DataSubscriptionInfo.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataSubscriptionInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataSubscriptionInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataSubscriptionInfo(parcel.readString(), parcel.readInt() == 0 ? null : PaymentState.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataSubscriptionInfo[] newArray(int i) {
            return new DataSubscriptionInfo[i];
        }
    }

    public DataSubscriptionInfo() {
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
        if (!(other instanceof DataSubscriptionInfo)) {
            return false;
        }
        DataSubscriptionInfo dataSubscriptionInfo = (DataSubscriptionInfo) other;
        return Intrinsics.areEqual(this.productId, dataSubscriptionInfo.productId) && this.state == dataSubscriptionInfo.state;
    }

    public int hashCode() {
        String str = this.productId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        PaymentState paymentState = this.state;
        return iHashCode + (paymentState != null ? paymentState.hashCode() : 0);
    }

    public String toString() {
        return "DataSubscriptionInfo(productId=" + this.productId + ", state=" + this.state + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.productId);
        PaymentState paymentState = this.state;
        if (paymentState == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(paymentState.name());
        }
    }

    public DataSubscriptionInfo(String str, PaymentState paymentState) {
        this.productId = str;
        this.state = paymentState;
    }

    public /* synthetic */ DataSubscriptionInfo(String str, PaymentState paymentState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : paymentState);
    }

    public final String getProductId() {
        return this.productId;
    }

    public final PaymentState getState() {
        return this.state;
    }
}
