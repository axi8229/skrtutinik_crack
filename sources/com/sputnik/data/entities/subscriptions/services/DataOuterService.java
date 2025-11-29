package com.sputnik.data.entities.subscriptions.services;

import com.google.gson.annotations.SerializedName;
import com.sputnik.domain.entities.market.OuterServiceTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataOuterService.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/services/DataOuterService;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "identifier", "Ljava/lang/String;", "getIdentifier", "Lcom/sputnik/domain/entities/market/OuterServiceTypes;", "type", "Lcom/sputnik/domain/entities/market/OuterServiceTypes;", "getType", "()Lcom/sputnik/domain/entities/market/OuterServiceTypes;", "order", "Ljava/lang/Integer;", "getOrder", "()Ljava/lang/Integer;", "subscriptionDetails", "Ljava/lang/Object;", "getSubscriptionDetails", "()Ljava/lang/Object;", "Lcom/sputnik/data/entities/subscriptions/services/DataOuterServiceAppearance;", "appearance", "Lcom/sputnik/data/entities/subscriptions/services/DataOuterServiceAppearance;", "getAppearance", "()Lcom/sputnik/data/entities/subscriptions/services/DataOuterServiceAppearance;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataOuterService {
    private final DataOuterServiceAppearance appearance;
    private final String identifier;
    private final Integer order;

    @SerializedName("subscription_details")
    private final Object subscriptionDetails;
    private final OuterServiceTypes type;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataOuterService)) {
            return false;
        }
        DataOuterService dataOuterService = (DataOuterService) other;
        return Intrinsics.areEqual(this.identifier, dataOuterService.identifier) && this.type == dataOuterService.type && Intrinsics.areEqual(this.order, dataOuterService.order) && Intrinsics.areEqual(this.subscriptionDetails, dataOuterService.subscriptionDetails) && Intrinsics.areEqual(this.appearance, dataOuterService.appearance);
    }

    public int hashCode() {
        String str = this.identifier;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        OuterServiceTypes outerServiceTypes = this.type;
        int iHashCode2 = (iHashCode + (outerServiceTypes == null ? 0 : outerServiceTypes.hashCode())) * 31;
        Integer num = this.order;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Object obj = this.subscriptionDetails;
        int iHashCode4 = (iHashCode3 + (obj == null ? 0 : obj.hashCode())) * 31;
        DataOuterServiceAppearance dataOuterServiceAppearance = this.appearance;
        return iHashCode4 + (dataOuterServiceAppearance != null ? dataOuterServiceAppearance.hashCode() : 0);
    }

    public String toString() {
        return "DataOuterService(identifier=" + this.identifier + ", type=" + this.type + ", order=" + this.order + ", subscriptionDetails=" + this.subscriptionDetails + ", appearance=" + this.appearance + ")";
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final OuterServiceTypes getType() {
        return this.type;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final Object getSubscriptionDetails() {
        return this.subscriptionDetails;
    }

    public final DataOuterServiceAppearance getAppearance() {
        return this.appearance;
    }
}
