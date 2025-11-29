package com.sputnik.data.entities.subscriptions.subscriptions;

import com.google.gson.annotations.SerializedName;
import com.sputnik.domain.entities.subscriptions.subscriptions.SubscriptionStates;
import com.sputnik.domain.entities.subscriptions.subscriptions.SubscriptionTypes;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataBaseSubscription.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010\u0017R\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010\u0004R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b'\u0010\u0004R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b)\u0010\u0004R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010\u0004R\u001c\u0010-\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/subscriptions/DataBaseSubscription;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataSubscriptionAppearance;", "appearance", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataSubscriptionAppearance;", "getAppearance", "()Lcom/sputnik/data/entities/subscriptions/subscriptions/DataSubscriptionAppearance;", "identifier", "Ljava/lang/String;", "getIdentifier", "order", "Ljava/lang/Integer;", "getOrder", "()Ljava/lang/Integer;", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataSubscriptionDetails;", "subscriptionDetails", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataSubscriptionDetails;", "getSubscriptionDetails", "()Lcom/sputnik/data/entities/subscriptions/subscriptions/DataSubscriptionDetails;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionTypes;", "type", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionTypes;", "getType", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionTypes;", "version", "getVersion", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "getDuration", "expires", "getExpires", "plan", "getPlan", "productId", "getProductId", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionStates;", "state", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionStates;", "getState", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionStates;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataBaseSubscription {

    @SerializedName("appearance")
    private final DataSubscriptionAppearance appearance;

    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION)
    private final String duration;

    @SerializedName("expires")
    private final String expires;

    @SerializedName("identifier")
    private final String identifier;

    @SerializedName("order")
    private final Integer order;

    @SerializedName("plan")
    private final String plan;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("state")
    private final SubscriptionStates state;

    @SerializedName("subscription_details")
    private final DataSubscriptionDetails subscriptionDetails;

    @SerializedName("type")
    private final SubscriptionTypes type;

    @SerializedName("version")
    private final Integer version;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataBaseSubscription)) {
            return false;
        }
        DataBaseSubscription dataBaseSubscription = (DataBaseSubscription) other;
        return Intrinsics.areEqual(this.appearance, dataBaseSubscription.appearance) && Intrinsics.areEqual(this.identifier, dataBaseSubscription.identifier) && Intrinsics.areEqual(this.order, dataBaseSubscription.order) && Intrinsics.areEqual(this.subscriptionDetails, dataBaseSubscription.subscriptionDetails) && this.type == dataBaseSubscription.type && Intrinsics.areEqual(this.version, dataBaseSubscription.version) && Intrinsics.areEqual(this.duration, dataBaseSubscription.duration) && Intrinsics.areEqual(this.expires, dataBaseSubscription.expires) && Intrinsics.areEqual(this.plan, dataBaseSubscription.plan) && Intrinsics.areEqual(this.productId, dataBaseSubscription.productId) && this.state == dataBaseSubscription.state;
    }

    public int hashCode() {
        DataSubscriptionAppearance dataSubscriptionAppearance = this.appearance;
        int iHashCode = (dataSubscriptionAppearance == null ? 0 : dataSubscriptionAppearance.hashCode()) * 31;
        String str = this.identifier;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.order;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        DataSubscriptionDetails dataSubscriptionDetails = this.subscriptionDetails;
        int iHashCode4 = (iHashCode3 + (dataSubscriptionDetails == null ? 0 : dataSubscriptionDetails.hashCode())) * 31;
        SubscriptionTypes subscriptionTypes = this.type;
        int iHashCode5 = (iHashCode4 + (subscriptionTypes == null ? 0 : subscriptionTypes.hashCode())) * 31;
        Integer num2 = this.version;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.duration;
        int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.expires;
        int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.plan;
        int iHashCode9 = (iHashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.productId;
        int iHashCode10 = (iHashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        SubscriptionStates subscriptionStates = this.state;
        return iHashCode10 + (subscriptionStates != null ? subscriptionStates.hashCode() : 0);
    }

    public String toString() {
        return "DataBaseSubscription(appearance=" + this.appearance + ", identifier=" + this.identifier + ", order=" + this.order + ", subscriptionDetails=" + this.subscriptionDetails + ", type=" + this.type + ", version=" + this.version + ", duration=" + this.duration + ", expires=" + this.expires + ", plan=" + this.plan + ", productId=" + this.productId + ", state=" + this.state + ")";
    }

    public final DataSubscriptionAppearance getAppearance() {
        return this.appearance;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final DataSubscriptionDetails getSubscriptionDetails() {
        return this.subscriptionDetails;
    }

    public final SubscriptionTypes getType() {
        return this.type;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getExpires() {
        return this.expires;
    }

    public final String getPlan() {
        return this.plan;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final SubscriptionStates getState() {
        return this.state;
    }
}
