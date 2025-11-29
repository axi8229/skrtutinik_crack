package com.sputnik.data.entities.subscriptions.subscriptions;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataSubscriptionDetails.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/subscriptions/DataSubscriptionDetails;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataPlan;", "plans", "Ljava/util/List;", "getPlans", "()Ljava/util/List;", "productId", "Ljava/lang/String;", "getProductId", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataSubscriptionDetails {

    @SerializedName("plans")
    private final List<DataPlan> plans;

    @SerializedName("product_id")
    private final String productId;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataSubscriptionDetails)) {
            return false;
        }
        DataSubscriptionDetails dataSubscriptionDetails = (DataSubscriptionDetails) other;
        return Intrinsics.areEqual(this.plans, dataSubscriptionDetails.plans) && Intrinsics.areEqual(this.productId, dataSubscriptionDetails.productId);
    }

    public int hashCode() {
        List<DataPlan> list = this.plans;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.productId;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "DataSubscriptionDetails(plans=" + this.plans + ", productId=" + this.productId + ")";
    }

    public final List<DataPlan> getPlans() {
        return this.plans;
    }

    public final String getProductId() {
        return this.productId;
    }
}
