package com.sputnik.data.entities.market;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.data.entities.market.subscription.DataSubscriptionAppearance;
import com.sputnik.data.entities.market.subscription.DataSubscriptionDetails;
import com.sputnik.domain.entities.market.MarketTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataMarket.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010 \u001a\u00020\tHÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\tHÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006&"}, d2 = {"Lcom/sputnik/data/entities/market/DataMarket;", "Landroid/os/Parcelable;", "identifier", "", "type", "Lcom/sputnik/domain/entities/market/MarketTypes;", "subscriptionDetails", "Lcom/sputnik/data/entities/market/subscription/DataSubscriptionDetails;", "order", "", "appearance", "Lcom/sputnik/data/entities/market/subscription/DataSubscriptionAppearance;", "billDetails", "Lcom/sputnik/data/entities/market/DataBillDetails;", "outerServiceDetails", "Lcom/sputnik/data/entities/market/DataOuterServiceDetails;", "(Ljava/lang/String;Lcom/sputnik/domain/entities/market/MarketTypes;Lcom/sputnik/data/entities/market/subscription/DataSubscriptionDetails;Ljava/lang/Integer;Lcom/sputnik/data/entities/market/subscription/DataSubscriptionAppearance;Lcom/sputnik/data/entities/market/DataBillDetails;Lcom/sputnik/data/entities/market/DataOuterServiceDetails;)V", "getAppearance", "()Lcom/sputnik/data/entities/market/subscription/DataSubscriptionAppearance;", "getBillDetails", "()Lcom/sputnik/data/entities/market/DataBillDetails;", "getIdentifier", "()Ljava/lang/String;", "getOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOuterServiceDetails", "()Lcom/sputnik/data/entities/market/DataOuterServiceDetails;", "getSubscriptionDetails", "()Lcom/sputnik/data/entities/market/subscription/DataSubscriptionDetails;", "getType", "()Lcom/sputnik/domain/entities/market/MarketTypes;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataMarket implements Parcelable {
    public static final Parcelable.Creator<DataMarket> CREATOR = new Creator();
    private final DataSubscriptionAppearance appearance;

    @SerializedName("bill_details")
    private final DataBillDetails billDetails;
    private final String identifier;
    private final Integer order;

    @SerializedName("outer_service_details")
    private final DataOuterServiceDetails outerServiceDetails;

    @SerializedName("subscription_details")
    private final DataSubscriptionDetails subscriptionDetails;
    private final MarketTypes type;

    /* compiled from: DataMarket.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataMarket> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataMarket createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataMarket(parcel.readString(), parcel.readInt() == 0 ? null : MarketTypes.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : DataSubscriptionDetails.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : DataSubscriptionAppearance.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : DataBillDetails.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? DataOuterServiceDetails.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataMarket[] newArray(int i) {
            return new DataMarket[i];
        }
    }

    public DataMarket() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.identifier);
        MarketTypes marketTypes = this.type;
        if (marketTypes == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(marketTypes.name());
        }
        DataSubscriptionDetails dataSubscriptionDetails = this.subscriptionDetails;
        if (dataSubscriptionDetails == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataSubscriptionDetails.writeToParcel(parcel, flags);
        }
        Integer num = this.order;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        DataSubscriptionAppearance dataSubscriptionAppearance = this.appearance;
        if (dataSubscriptionAppearance == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataSubscriptionAppearance.writeToParcel(parcel, flags);
        }
        DataBillDetails dataBillDetails = this.billDetails;
        if (dataBillDetails == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataBillDetails.writeToParcel(parcel, flags);
        }
        DataOuterServiceDetails dataOuterServiceDetails = this.outerServiceDetails;
        if (dataOuterServiceDetails == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataOuterServiceDetails.writeToParcel(parcel, flags);
        }
    }

    public DataMarket(String str, MarketTypes marketTypes, DataSubscriptionDetails dataSubscriptionDetails, Integer num, DataSubscriptionAppearance dataSubscriptionAppearance, DataBillDetails dataBillDetails, DataOuterServiceDetails dataOuterServiceDetails) {
        this.identifier = str;
        this.type = marketTypes;
        this.subscriptionDetails = dataSubscriptionDetails;
        this.order = num;
        this.appearance = dataSubscriptionAppearance;
        this.billDetails = dataBillDetails;
        this.outerServiceDetails = dataOuterServiceDetails;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final MarketTypes getType() {
        return this.type;
    }

    public final DataSubscriptionDetails getSubscriptionDetails() {
        return this.subscriptionDetails;
    }

    public /* synthetic */ DataMarket(String str, MarketTypes marketTypes, DataSubscriptionDetails dataSubscriptionDetails, Integer num, DataSubscriptionAppearance dataSubscriptionAppearance, DataBillDetails dataBillDetails, DataOuterServiceDetails dataOuterServiceDetails, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : marketTypes, (i & 4) != 0 ? null : dataSubscriptionDetails, (i & 8) != 0 ? 0 : num, (i & 16) != 0 ? null : dataSubscriptionAppearance, (i & 32) != 0 ? null : dataBillDetails, (i & 64) != 0 ? null : dataOuterServiceDetails);
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final DataSubscriptionAppearance getAppearance() {
        return this.appearance;
    }

    public final DataBillDetails getBillDetails() {
        return this.billDetails;
    }

    public final DataOuterServiceDetails getOuterServiceDetails() {
        return this.outerServiceDetails;
    }
}
