package com.sputnik.data.entities.market.subscription;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.domain.entities.card.PaymentState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataSubscriptionStart.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0011J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b'\u0010\u000e¨\u0006("}, d2 = {"Lcom/sputnik/data/entities/market/subscription/DataSubscriptionStart;", "Landroid/os/Parcelable;", "", "Lcom/sputnik/data/entities/market/subscription/DataSubscriptionInfo;", "subscription", "", "delayed", "Lcom/sputnik/domain/entities/card/PaymentState;", "paymentState", "", "confirmationUrl", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Lcom/sputnik/domain/entities/card/PaymentState;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getSubscription", "()Ljava/util/List;", "Ljava/lang/Boolean;", "getDelayed", "()Ljava/lang/Boolean;", "Lcom/sputnik/domain/entities/card/PaymentState;", "getPaymentState", "()Lcom/sputnik/domain/entities/card/PaymentState;", "Ljava/lang/String;", "getConfirmationUrl", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataSubscriptionStart implements Parcelable {
    public static final Parcelable.Creator<DataSubscriptionStart> CREATOR = new Creator();

    @SerializedName("confirmation_url")
    private final String confirmationUrl;
    private final Boolean delayed;
    private final PaymentState paymentState;
    private final List<DataSubscriptionInfo> subscription;

    /* compiled from: DataSubscriptionStart.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataSubscriptionStart> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataSubscriptionStart createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(DataSubscriptionInfo.CREATOR.createFromParcel(parcel));
                }
            }
            return new DataSubscriptionStart(arrayList, parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() != 0 ? PaymentState.valueOf(parcel.readString()) : null, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataSubscriptionStart[] newArray(int i) {
            return new DataSubscriptionStart[i];
        }
    }

    public DataSubscriptionStart() {
        this(null, null, null, null, 15, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataSubscriptionStart)) {
            return false;
        }
        DataSubscriptionStart dataSubscriptionStart = (DataSubscriptionStart) other;
        return Intrinsics.areEqual(this.subscription, dataSubscriptionStart.subscription) && Intrinsics.areEqual(this.delayed, dataSubscriptionStart.delayed) && this.paymentState == dataSubscriptionStart.paymentState && Intrinsics.areEqual(this.confirmationUrl, dataSubscriptionStart.confirmationUrl);
    }

    public int hashCode() {
        List<DataSubscriptionInfo> list = this.subscription;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Boolean bool = this.delayed;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        PaymentState paymentState = this.paymentState;
        int iHashCode3 = (iHashCode2 + (paymentState == null ? 0 : paymentState.hashCode())) * 31;
        String str = this.confirmationUrl;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "DataSubscriptionStart(subscription=" + this.subscription + ", delayed=" + this.delayed + ", paymentState=" + this.paymentState + ", confirmationUrl=" + this.confirmationUrl + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<DataSubscriptionInfo> list = this.subscription;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<DataSubscriptionInfo> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
        }
        Boolean bool = this.delayed;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        PaymentState paymentState = this.paymentState;
        if (paymentState == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(paymentState.name());
        }
        parcel.writeString(this.confirmationUrl);
    }

    public DataSubscriptionStart(List<DataSubscriptionInfo> list, Boolean bool, PaymentState paymentState, String str) {
        this.subscription = list;
        this.delayed = bool;
        this.paymentState = paymentState;
        this.confirmationUrl = str;
    }

    public /* synthetic */ DataSubscriptionStart(List list, Boolean bool, PaymentState paymentState, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : paymentState, (i & 8) != 0 ? null : str);
    }

    public final List<DataSubscriptionInfo> getSubscription() {
        return this.subscription;
    }

    public final Boolean getDelayed() {
        return this.delayed;
    }

    public final PaymentState getPaymentState() {
        return this.paymentState;
    }

    public final String getConfirmationUrl() {
        return this.confirmationUrl;
    }
}
