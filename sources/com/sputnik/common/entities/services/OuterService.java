package com.sputnik.common.entities.services;

import com.sputnik.domain.entities.market.OuterServiceTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuterService.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/sputnik/common/entities/services/OuterService;", "", "", "identifier", "Lcom/sputnik/domain/entities/market/OuterServiceTypes;", "type", "", "order", "subscriptionDetails", "Lcom/sputnik/common/entities/services/OuterServiceAppearance;", "appearance", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/market/OuterServiceTypes;Ljava/lang/Integer;Ljava/lang/Object;Lcom/sputnik/common/entities/services/OuterServiceAppearance;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getIdentifier", "Lcom/sputnik/domain/entities/market/OuterServiceTypes;", "getType", "()Lcom/sputnik/domain/entities/market/OuterServiceTypes;", "Ljava/lang/Integer;", "getOrder", "()Ljava/lang/Integer;", "Ljava/lang/Object;", "getSubscriptionDetails", "()Ljava/lang/Object;", "Lcom/sputnik/common/entities/services/OuterServiceAppearance;", "getAppearance", "()Lcom/sputnik/common/entities/services/OuterServiceAppearance;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OuterService {
    private final OuterServiceAppearance appearance;
    private final String identifier;
    private final Integer order;
    private final Object subscriptionDetails;
    private final OuterServiceTypes type;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OuterService)) {
            return false;
        }
        OuterService outerService = (OuterService) other;
        return Intrinsics.areEqual(this.identifier, outerService.identifier) && this.type == outerService.type && Intrinsics.areEqual(this.order, outerService.order) && Intrinsics.areEqual(this.subscriptionDetails, outerService.subscriptionDetails) && Intrinsics.areEqual(this.appearance, outerService.appearance);
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
        OuterServiceAppearance outerServiceAppearance = this.appearance;
        return iHashCode4 + (outerServiceAppearance != null ? outerServiceAppearance.hashCode() : 0);
    }

    public String toString() {
        return "OuterService(identifier=" + this.identifier + ", type=" + this.type + ", order=" + this.order + ", subscriptionDetails=" + this.subscriptionDetails + ", appearance=" + this.appearance + ")";
    }

    public OuterService(String str, OuterServiceTypes outerServiceTypes, Integer num, Object obj, OuterServiceAppearance outerServiceAppearance) {
        this.identifier = str;
        this.type = outerServiceTypes;
        this.order = num;
        this.subscriptionDetails = obj;
        this.appearance = outerServiceAppearance;
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

    public final OuterServiceAppearance getAppearance() {
        return this.appearance;
    }
}
