package com.sputnik.common.entities.subscriptions;

import com.sputnik.domain.entities.subscriptions.subscriptions.SubscriptionStates;
import com.sputnik.domain.entities.subscriptions.subscriptions.SubscriptionTypes;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseSubscription.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u0016R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b+\u0010$R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b,\u0010\u0016R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b-\u0010\u0016R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b.\u0010\u0016R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b/\u0010\u0016R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u00100\u001a\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/sputnik/common/entities/subscriptions/BaseSubscription;", "", "Lcom/sputnik/common/entities/subscriptions/SubscriptionAppearance;", "appearance", "", "identifier", "", "order", "Lcom/sputnik/common/entities/subscriptions/SubscriptionDetails;", "subscriptionDetails", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionTypes;", "type", "version", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "expires", "plan", "productId", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionStates;", "state", "<init>", "(Lcom/sputnik/common/entities/subscriptions/SubscriptionAppearance;Ljava/lang/String;Ljava/lang/Integer;Lcom/sputnik/common/entities/subscriptions/SubscriptionDetails;Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionTypes;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionStates;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/common/entities/subscriptions/SubscriptionAppearance;", "getAppearance", "()Lcom/sputnik/common/entities/subscriptions/SubscriptionAppearance;", "Ljava/lang/String;", "getIdentifier", "Ljava/lang/Integer;", "getOrder", "()Ljava/lang/Integer;", "Lcom/sputnik/common/entities/subscriptions/SubscriptionDetails;", "getSubscriptionDetails", "()Lcom/sputnik/common/entities/subscriptions/SubscriptionDetails;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionTypes;", "getType", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionTypes;", "getVersion", "getDuration", "getExpires", "getPlan", "getProductId", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionStates;", "getState", "()Lcom/sputnik/domain/entities/subscriptions/subscriptions/SubscriptionStates;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BaseSubscription {
    private final SubscriptionAppearance appearance;
    private final String duration;
    private final String expires;
    private final String identifier;
    private final Integer order;
    private final String plan;
    private final String productId;
    private final SubscriptionStates state;
    private final SubscriptionDetails subscriptionDetails;
    private final SubscriptionTypes type;
    private final Integer version;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BaseSubscription)) {
            return false;
        }
        BaseSubscription baseSubscription = (BaseSubscription) other;
        return Intrinsics.areEqual(this.appearance, baseSubscription.appearance) && Intrinsics.areEqual(this.identifier, baseSubscription.identifier) && Intrinsics.areEqual(this.order, baseSubscription.order) && Intrinsics.areEqual(this.subscriptionDetails, baseSubscription.subscriptionDetails) && this.type == baseSubscription.type && Intrinsics.areEqual(this.version, baseSubscription.version) && Intrinsics.areEqual(this.duration, baseSubscription.duration) && Intrinsics.areEqual(this.expires, baseSubscription.expires) && Intrinsics.areEqual(this.plan, baseSubscription.plan) && Intrinsics.areEqual(this.productId, baseSubscription.productId) && this.state == baseSubscription.state;
    }

    public int hashCode() {
        SubscriptionAppearance subscriptionAppearance = this.appearance;
        int iHashCode = (subscriptionAppearance == null ? 0 : subscriptionAppearance.hashCode()) * 31;
        String str = this.identifier;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.order;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        SubscriptionDetails subscriptionDetails = this.subscriptionDetails;
        int iHashCode4 = (iHashCode3 + (subscriptionDetails == null ? 0 : subscriptionDetails.hashCode())) * 31;
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
        return "BaseSubscription(appearance=" + this.appearance + ", identifier=" + this.identifier + ", order=" + this.order + ", subscriptionDetails=" + this.subscriptionDetails + ", type=" + this.type + ", version=" + this.version + ", duration=" + this.duration + ", expires=" + this.expires + ", plan=" + this.plan + ", productId=" + this.productId + ", state=" + this.state + ")";
    }

    public BaseSubscription(SubscriptionAppearance subscriptionAppearance, String str, Integer num, SubscriptionDetails subscriptionDetails, SubscriptionTypes subscriptionTypes, Integer num2, String str2, String str3, String str4, String str5, SubscriptionStates subscriptionStates) {
        this.appearance = subscriptionAppearance;
        this.identifier = str;
        this.order = num;
        this.subscriptionDetails = subscriptionDetails;
        this.type = subscriptionTypes;
        this.version = num2;
        this.duration = str2;
        this.expires = str3;
        this.plan = str4;
        this.productId = str5;
        this.state = subscriptionStates;
    }

    public final SubscriptionAppearance getAppearance() {
        return this.appearance;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final SubscriptionDetails getSubscriptionDetails() {
        return this.subscriptionDetails;
    }

    public final SubscriptionTypes getType() {
        return this.type;
    }

    public final String getExpires() {
        return this.expires;
    }
}
