package com.sputnik.common.entities.market.subscription;

import android.os.Parcel;
import android.os.Parcelable;
import com.sputnik.common.entities.market.market.Badge;
import com.sputnik.domain.entities.market.PlansDuration;
import com.sputnik.domain.entities.market.services.ServiceState;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Subscription.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u001aJ \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u0017R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010&\u001a\u0004\b(\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010,\u001a\u0004\b-\u0010.R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010)\u001a\u0004\b/\u0010+R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b0\u0010\u0017R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u00101\u001a\u0004\b2\u00103R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b4\u0010\u0017R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b5\u0010\u0017R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u00106\u001a\u0004\b7\u00108R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u00109\u001a\u0004\b:\u0010;R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b<\u0010+¨\u0006="}, d2 = {"Lcom/sputnik/common/entities/market/subscription/Subscription;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "description", "", "canManage", "Lcom/sputnik/domain/entities/market/services/ServiceState;", "state", "primeSubscription", "expiresDate", "Lcom/sputnik/common/entities/market/subscription/ActivePlan;", "activePlan", "refund", "productId", "Lcom/sputnik/common/entities/market/market/Badge;", "badge", "Lcom/sputnik/domain/entities/market/PlansDuration;", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "autoRenewStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/sputnik/domain/entities/market/services/ServiceState;Ljava/lang/Boolean;Ljava/lang/String;Lcom/sputnik/common/entities/market/subscription/ActivePlan;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/market/market/Badge;Lcom/sputnik/domain/entities/market/PlansDuration;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getDescription", "Ljava/lang/Boolean;", "getCanManage", "()Ljava/lang/Boolean;", "Lcom/sputnik/domain/entities/market/services/ServiceState;", "getState", "()Lcom/sputnik/domain/entities/market/services/ServiceState;", "getPrimeSubscription", "getExpiresDate", "Lcom/sputnik/common/entities/market/subscription/ActivePlan;", "getActivePlan", "()Lcom/sputnik/common/entities/market/subscription/ActivePlan;", "getRefund", "getProductId", "Lcom/sputnik/common/entities/market/market/Badge;", "getBadge", "()Lcom/sputnik/common/entities/market/market/Badge;", "Lcom/sputnik/domain/entities/market/PlansDuration;", "getDuration", "()Lcom/sputnik/domain/entities/market/PlansDuration;", "getAutoRenewStatus", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Subscription implements Parcelable {
    public static final Parcelable.Creator<Subscription> CREATOR = new Creator();
    private final ActivePlan activePlan;
    private final Boolean autoRenewStatus;
    private final Badge badge;
    private final Boolean canManage;
    private final String description;
    private final PlansDuration duration;
    private final String expiresDate;
    private final Boolean primeSubscription;
    private final String productId;
    private final String refund;
    private final ServiceState state;
    private final String title;

    /* compiled from: Subscription.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Subscription> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Subscription createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Boolean boolValueOf2;
            Boolean boolValueOf3;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            ServiceState serviceStateValueOf = parcel.readInt() == 0 ? null : ServiceState.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                boolValueOf2 = null;
            } else {
                boolValueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String string3 = parcel.readString();
            ActivePlan activePlanCreateFromParcel = parcel.readInt() == 0 ? null : ActivePlan.CREATOR.createFromParcel(parcel);
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            Badge badgeCreateFromParcel = parcel.readInt() == 0 ? null : Badge.CREATOR.createFromParcel(parcel);
            PlansDuration plansDurationValueOf = parcel.readInt() == 0 ? null : PlansDuration.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                boolValueOf3 = null;
            } else {
                boolValueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new Subscription(string, string2, boolValueOf, serviceStateValueOf, boolValueOf2, string3, activePlanCreateFromParcel, string4, string5, badgeCreateFromParcel, plansDurationValueOf, boolValueOf3);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Subscription[] newArray(int i) {
            return new Subscription[i];
        }
    }

    public Subscription() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) other;
        return Intrinsics.areEqual(this.title, subscription.title) && Intrinsics.areEqual(this.description, subscription.description) && Intrinsics.areEqual(this.canManage, subscription.canManage) && this.state == subscription.state && Intrinsics.areEqual(this.primeSubscription, subscription.primeSubscription) && Intrinsics.areEqual(this.expiresDate, subscription.expiresDate) && Intrinsics.areEqual(this.activePlan, subscription.activePlan) && Intrinsics.areEqual(this.refund, subscription.refund) && Intrinsics.areEqual(this.productId, subscription.productId) && Intrinsics.areEqual(this.badge, subscription.badge) && this.duration == subscription.duration && Intrinsics.areEqual(this.autoRenewStatus, subscription.autoRenewStatus);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.canManage;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        ServiceState serviceState = this.state;
        int iHashCode4 = (iHashCode3 + (serviceState == null ? 0 : serviceState.hashCode())) * 31;
        Boolean bool2 = this.primeSubscription;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str3 = this.expiresDate;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ActivePlan activePlan = this.activePlan;
        int iHashCode7 = (iHashCode6 + (activePlan == null ? 0 : activePlan.hashCode())) * 31;
        String str4 = this.refund;
        int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.productId;
        int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Badge badge = this.badge;
        int iHashCode10 = (iHashCode9 + (badge == null ? 0 : badge.hashCode())) * 31;
        PlansDuration plansDuration = this.duration;
        int iHashCode11 = (iHashCode10 + (plansDuration == null ? 0 : plansDuration.hashCode())) * 31;
        Boolean bool3 = this.autoRenewStatus;
        return iHashCode11 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        return "Subscription(title=" + this.title + ", description=" + this.description + ", canManage=" + this.canManage + ", state=" + this.state + ", primeSubscription=" + this.primeSubscription + ", expiresDate=" + this.expiresDate + ", activePlan=" + this.activePlan + ", refund=" + this.refund + ", productId=" + this.productId + ", badge=" + this.badge + ", duration=" + this.duration + ", autoRenewStatus=" + this.autoRenewStatus + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        Boolean bool = this.canManage;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        ServiceState serviceState = this.state;
        if (serviceState == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(serviceState.name());
        }
        Boolean bool2 = this.primeSubscription;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.expiresDate);
        ActivePlan activePlan = this.activePlan;
        if (activePlan == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            activePlan.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.refund);
        parcel.writeString(this.productId);
        Badge badge = this.badge;
        if (badge == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            badge.writeToParcel(parcel, flags);
        }
        PlansDuration plansDuration = this.duration;
        if (plansDuration == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(plansDuration.name());
        }
        Boolean bool3 = this.autoRenewStatus;
        if (bool3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        }
    }

    public Subscription(String str, String str2, Boolean bool, ServiceState serviceState, Boolean bool2, String str3, ActivePlan activePlan, String str4, String str5, Badge badge, PlansDuration plansDuration, Boolean bool3) {
        this.title = str;
        this.description = str2;
        this.canManage = bool;
        this.state = serviceState;
        this.primeSubscription = bool2;
        this.expiresDate = str3;
        this.activePlan = activePlan;
        this.refund = str4;
        this.productId = str5;
        this.badge = badge;
        this.duration = plansDuration;
        this.autoRenewStatus = bool3;
    }

    public /* synthetic */ Subscription(String str, String str2, Boolean bool, ServiceState serviceState, Boolean bool2, String str3, ActivePlan activePlan, String str4, String str5, Badge badge, PlansDuration plansDuration, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : serviceState, (i & 16) != 0 ? null : bool2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : activePlan, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : badge, (i & 1024) != 0 ? null : plansDuration, (i & 2048) == 0 ? bool3 : null);
    }

    public final String getTitle() {
        return this.title;
    }

    public final Boolean getCanManage() {
        return this.canManage;
    }

    public final ServiceState getState() {
        return this.state;
    }

    public final Boolean getPrimeSubscription() {
        return this.primeSubscription;
    }

    public final String getExpiresDate() {
        return this.expiresDate;
    }

    public final ActivePlan getActivePlan() {
        return this.activePlan;
    }

    public final String getRefund() {
        return this.refund;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final Badge getBadge() {
        return this.badge;
    }

    public final PlansDuration getDuration() {
        return this.duration;
    }

    public final Boolean getAutoRenewStatus() {
        return this.autoRenewStatus;
    }
}
