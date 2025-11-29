package com.sputnik.domain.entities.subscriptions;

import com.sputnik.domain.entities.subscriptions.items.DomainMarketItem;
import com.sputnik.domain.entities.subscriptions.services.DomainOuterService;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainBaseSubscription;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainMarketV2.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/sputnik/domain/entities/subscriptions/DomainMarketV2;", "", "", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBaseSubscription;", "subscriptions", "Lcom/sputnik/domain/entities/subscriptions/services/DomainOuterService;", "services", "Lcom/sputnik/domain/entities/subscriptions/items/DomainMarketItem;", "items", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getSubscriptions", "()Ljava/util/List;", "getServices", "getItems", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DomainMarketV2 {
    private final List<DomainMarketItem> items;
    private final List<DomainOuterService> services;
    private final List<DomainBaseSubscription> subscriptions;

    public DomainMarketV2() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainMarketV2)) {
            return false;
        }
        DomainMarketV2 domainMarketV2 = (DomainMarketV2) other;
        return Intrinsics.areEqual(this.subscriptions, domainMarketV2.subscriptions) && Intrinsics.areEqual(this.services, domainMarketV2.services) && Intrinsics.areEqual(this.items, domainMarketV2.items);
    }

    public int hashCode() {
        List<DomainBaseSubscription> list = this.subscriptions;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<DomainOuterService> list2 = this.services;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<DomainMarketItem> list3 = this.items;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        return "DomainMarketV2(subscriptions=" + this.subscriptions + ", services=" + this.services + ", items=" + this.items + ")";
    }

    public DomainMarketV2(List<DomainBaseSubscription> list, List<DomainOuterService> list2, List<DomainMarketItem> list3) {
        this.subscriptions = list;
        this.services = list2;
        this.items = list3;
    }

    public /* synthetic */ DomainMarketV2(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3);
    }

    public final List<DomainBaseSubscription> getSubscriptions() {
        return this.subscriptions;
    }

    public final List<DomainOuterService> getServices() {
        return this.services;
    }

    public final List<DomainMarketItem> getItems() {
        return this.items;
    }
}
