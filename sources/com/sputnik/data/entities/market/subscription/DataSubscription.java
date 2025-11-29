package com.sputnik.data.entities.market.subscription;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.data.entities.market.DataPlans;
import com.sputnik.data.entities.market.DataSmallService;
import com.sputnik.domain.entities.market.PlansDuration;
import com.sputnik.domain.entities.market.services.ServiceState;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataSubscription.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b$\b\u0087\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b&\u0010!J \u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b+\u0010,R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010/\u001a\u0004\b0\u00101R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u00102\u001a\u0004\b3\u00104R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010-\u001a\u0004\b5\u0010\u001fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010-\u001a\u0004\b6\u0010\u001fR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\n\u00102\u001a\u0004\b7\u00104R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u00102\u001a\u0004\b8\u00104R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010-\u001a\u0004\b9\u0010\u001fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u00102\u001a\u0004\b:\u00104R\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010;\u001a\u0004\b<\u0010=R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010>\u001a\u0004\b?\u0010@R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010A\u001a\u0004\bB\u0010CR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010-\u001a\u0004\bD\u0010\u001fR\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010E\u001a\u0004\bF\u0010GR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010H\u001a\u0004\bI\u0010JR\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010K\u001a\u0004\bL\u0010M¨\u0006N"}, d2 = {"Lcom/sputnik/data/entities/market/subscription/DataSubscription;", "Landroid/os/Parcelable;", "", "productId", "Lcom/sputnik/domain/entities/market/services/ServiceState;", "state", "", "autoRenewStatus", "subscribedFrom", "fullExpiresDate", "trial", "canManage", "expansion", "primeSubscription", "", "Lcom/sputnik/data/entities/market/DataSmallService;", "services", "Lcom/sputnik/domain/entities/market/PlansDuration;", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "Lcom/sputnik/data/entities/market/DataPlans;", "activePlan", "plan", "", "price", "", "refund", "Lcom/sputnik/data/entities/market/subscription/DataSubscriptionAppearance;", "appearance", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/market/services/ServiceState;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Lcom/sputnik/domain/entities/market/PlansDuration;Lcom/sputnik/data/entities/market/DataPlans;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Lcom/sputnik/data/entities/market/subscription/DataSubscriptionAppearance;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getProductId", "Lcom/sputnik/domain/entities/market/services/ServiceState;", "getState", "()Lcom/sputnik/domain/entities/market/services/ServiceState;", "Ljava/lang/Boolean;", "getAutoRenewStatus", "()Ljava/lang/Boolean;", "getSubscribedFrom", "getFullExpiresDate", "getTrial", "getCanManage", "getExpansion", "getPrimeSubscription", "Ljava/util/List;", "getServices", "()Ljava/util/List;", "Lcom/sputnik/domain/entities/market/PlansDuration;", "getDuration", "()Lcom/sputnik/domain/entities/market/PlansDuration;", "Lcom/sputnik/data/entities/market/DataPlans;", "getActivePlan", "()Lcom/sputnik/data/entities/market/DataPlans;", "getPlan", "Ljava/lang/Integer;", "getPrice", "()Ljava/lang/Integer;", "Ljava/lang/Double;", "getRefund", "()Ljava/lang/Double;", "Lcom/sputnik/data/entities/market/subscription/DataSubscriptionAppearance;", "getAppearance", "()Lcom/sputnik/data/entities/market/subscription/DataSubscriptionAppearance;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataSubscription implements Parcelable {
    public static final Parcelable.Creator<DataSubscription> CREATOR = new Creator();

    @SerializedName("active_plan")
    private final DataPlans activePlan;
    private final DataSubscriptionAppearance appearance;

    @SerializedName("auto_renew_status")
    private final Boolean autoRenewStatus;

    @SerializedName("can_manage")
    private final Boolean canManage;
    private final PlansDuration duration;
    private final String expansion;

    @SerializedName("expires_date")
    private final String fullExpiresDate;
    private final String plan;
    private final Integer price;

    @SerializedName("prime_subscription")
    private final Boolean primeSubscription;

    @SerializedName("product_id")
    private final String productId;
    private final Double refund;
    private final List<DataSmallService> services;
    private final ServiceState state;

    @SerializedName("subscribed_from")
    private final String subscribedFrom;
    private final Boolean trial;

    /* compiled from: DataSubscription.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataSubscription> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataSubscription createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            ServiceState serviceStateValueOf = ServiceState.valueOf(parcel.readString());
            Boolean boolValueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            Boolean boolValueOf2 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            Boolean boolValueOf3 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String string4 = parcel.readString();
            Boolean boolValueOf4 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(DataSmallService.CREATOR.createFromParcel(parcel));
                }
            }
            return new DataSubscription(string, serviceStateValueOf, boolValueOf, string2, string3, boolValueOf2, boolValueOf3, string4, boolValueOf4, arrayList, parcel.readInt() == 0 ? null : PlansDuration.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : DataPlans.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()), parcel.readInt() != 0 ? DataSubscriptionAppearance.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataSubscription[] newArray(int i) {
            return new DataSubscription[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataSubscription)) {
            return false;
        }
        DataSubscription dataSubscription = (DataSubscription) other;
        return Intrinsics.areEqual(this.productId, dataSubscription.productId) && this.state == dataSubscription.state && Intrinsics.areEqual(this.autoRenewStatus, dataSubscription.autoRenewStatus) && Intrinsics.areEqual(this.subscribedFrom, dataSubscription.subscribedFrom) && Intrinsics.areEqual(this.fullExpiresDate, dataSubscription.fullExpiresDate) && Intrinsics.areEqual(this.trial, dataSubscription.trial) && Intrinsics.areEqual(this.canManage, dataSubscription.canManage) && Intrinsics.areEqual(this.expansion, dataSubscription.expansion) && Intrinsics.areEqual(this.primeSubscription, dataSubscription.primeSubscription) && Intrinsics.areEqual(this.services, dataSubscription.services) && this.duration == dataSubscription.duration && Intrinsics.areEqual(this.activePlan, dataSubscription.activePlan) && Intrinsics.areEqual(this.plan, dataSubscription.plan) && Intrinsics.areEqual(this.price, dataSubscription.price) && Intrinsics.areEqual(this.refund, dataSubscription.refund) && Intrinsics.areEqual(this.appearance, dataSubscription.appearance);
    }

    public int hashCode() {
        String str = this.productId;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.state.hashCode()) * 31;
        Boolean bool = this.autoRenewStatus;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.subscribedFrom;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fullExpiresDate;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool2 = this.trial;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.canManage;
        int iHashCode6 = (iHashCode5 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str4 = this.expansion;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool4 = this.primeSubscription;
        int iHashCode8 = (iHashCode7 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        List<DataSmallService> list = this.services;
        int iHashCode9 = (iHashCode8 + (list == null ? 0 : list.hashCode())) * 31;
        PlansDuration plansDuration = this.duration;
        int iHashCode10 = (iHashCode9 + (plansDuration == null ? 0 : plansDuration.hashCode())) * 31;
        DataPlans dataPlans = this.activePlan;
        int iHashCode11 = (iHashCode10 + (dataPlans == null ? 0 : dataPlans.hashCode())) * 31;
        String str5 = this.plan;
        int iHashCode12 = (iHashCode11 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.price;
        int iHashCode13 = (iHashCode12 + (num == null ? 0 : num.hashCode())) * 31;
        Double d = this.refund;
        int iHashCode14 = (iHashCode13 + (d == null ? 0 : d.hashCode())) * 31;
        DataSubscriptionAppearance dataSubscriptionAppearance = this.appearance;
        return iHashCode14 + (dataSubscriptionAppearance != null ? dataSubscriptionAppearance.hashCode() : 0);
    }

    public String toString() {
        return "DataSubscription(productId=" + this.productId + ", state=" + this.state + ", autoRenewStatus=" + this.autoRenewStatus + ", subscribedFrom=" + this.subscribedFrom + ", fullExpiresDate=" + this.fullExpiresDate + ", trial=" + this.trial + ", canManage=" + this.canManage + ", expansion=" + this.expansion + ", primeSubscription=" + this.primeSubscription + ", services=" + this.services + ", duration=" + this.duration + ", activePlan=" + this.activePlan + ", plan=" + this.plan + ", price=" + this.price + ", refund=" + this.refund + ", appearance=" + this.appearance + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.productId);
        parcel.writeString(this.state.name());
        Boolean bool = this.autoRenewStatus;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.subscribedFrom);
        parcel.writeString(this.fullExpiresDate);
        Boolean bool2 = this.trial;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.canManage;
        if (bool3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.expansion);
        Boolean bool4 = this.primeSubscription;
        if (bool4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        List<DataSmallService> list = this.services;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<DataSmallService> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
        }
        PlansDuration plansDuration = this.duration;
        if (plansDuration == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(plansDuration.name());
        }
        DataPlans dataPlans = this.activePlan;
        if (dataPlans == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataPlans.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.plan);
        Integer num = this.price;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Double d = this.refund;
        if (d == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeDouble(d.doubleValue());
        }
        DataSubscriptionAppearance dataSubscriptionAppearance = this.appearance;
        if (dataSubscriptionAppearance == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataSubscriptionAppearance.writeToParcel(parcel, flags);
        }
    }

    public DataSubscription(String str, ServiceState state, Boolean bool, String str2, String str3, Boolean bool2, Boolean bool3, String str4, Boolean bool4, List<DataSmallService> list, PlansDuration plansDuration, DataPlans dataPlans, String str5, Integer num, Double d, DataSubscriptionAppearance dataSubscriptionAppearance) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.productId = str;
        this.state = state;
        this.autoRenewStatus = bool;
        this.subscribedFrom = str2;
        this.fullExpiresDate = str3;
        this.trial = bool2;
        this.canManage = bool3;
        this.expansion = str4;
        this.primeSubscription = bool4;
        this.services = list;
        this.duration = plansDuration;
        this.activePlan = dataPlans;
        this.plan = str5;
        this.price = num;
        this.refund = d;
        this.appearance = dataSubscriptionAppearance;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final ServiceState getState() {
        return this.state;
    }

    public final Boolean getAutoRenewStatus() {
        return this.autoRenewStatus;
    }

    public final String getSubscribedFrom() {
        return this.subscribedFrom;
    }

    public final String getFullExpiresDate() {
        return this.fullExpiresDate;
    }

    public final Boolean getTrial() {
        return this.trial;
    }

    public final Boolean getCanManage() {
        return this.canManage;
    }

    public final String getExpansion() {
        return this.expansion;
    }

    public final Boolean getPrimeSubscription() {
        return this.primeSubscription;
    }

    public final List<DataSmallService> getServices() {
        return this.services;
    }

    public final PlansDuration getDuration() {
        return this.duration;
    }

    public final DataPlans getActivePlan() {
        return this.activePlan;
    }

    public final String getPlan() {
        return this.plan;
    }

    public final Integer getPrice() {
        return this.price;
    }

    public final Double getRefund() {
        return this.refund;
    }

    public final DataSubscriptionAppearance getAppearance() {
        return this.appearance;
    }
}
