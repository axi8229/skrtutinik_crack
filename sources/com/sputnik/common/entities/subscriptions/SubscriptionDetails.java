package com.sputnik.common.entities.subscriptions;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionDetails.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/sputnik/common/entities/subscriptions/SubscriptionDetails;", "", "", "Lcom/sputnik/common/entities/subscriptions/Plan;", "plans", "", "productId", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getPlans", "()Ljava/util/List;", "Ljava/lang/String;", "getProductId", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SubscriptionDetails {
    private final List<Plan> plans;
    private final String productId;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionDetails)) {
            return false;
        }
        SubscriptionDetails subscriptionDetails = (SubscriptionDetails) other;
        return Intrinsics.areEqual(this.plans, subscriptionDetails.plans) && Intrinsics.areEqual(this.productId, subscriptionDetails.productId);
    }

    public int hashCode() {
        List<Plan> list = this.plans;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.productId;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "SubscriptionDetails(plans=" + this.plans + ", productId=" + this.productId + ")";
    }

    public SubscriptionDetails(List<Plan> list, String str) {
        this.plans = list;
        this.productId = str;
    }

    public final List<Plan> getPlans() {
        return this.plans;
    }

    public final String getProductId() {
        return this.productId;
    }
}
