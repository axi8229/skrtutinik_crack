package com.sputnik.data.entities.subscriptions;

import com.google.gson.annotations.SerializedName;
import com.sputnik.data.entities.subscriptions.items.DataMarketItem;
import com.sputnik.data.entities.subscriptions.services.DataOuterService;
import com.sputnik.data.entities.subscriptions.subscriptions.DataBaseSubscription;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataMarketV2.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/DataMarketV2;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataBaseSubscription;", "subscriptions", "Ljava/util/List;", "getSubscriptions", "()Ljava/util/List;", "Lcom/sputnik/data/entities/subscriptions/services/DataOuterService;", "services", "getServices", "Lcom/sputnik/data/entities/subscriptions/items/DataMarketItem;", "items", "getItems", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataMarketV2 {

    @SerializedName("tab_items")
    private final List<DataMarketItem> items;

    @SerializedName("tab_services")
    private final List<DataOuterService> services;

    @SerializedName("tab_subscriptions")
    private final List<DataBaseSubscription> subscriptions;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataMarketV2)) {
            return false;
        }
        DataMarketV2 dataMarketV2 = (DataMarketV2) other;
        return Intrinsics.areEqual(this.subscriptions, dataMarketV2.subscriptions) && Intrinsics.areEqual(this.services, dataMarketV2.services) && Intrinsics.areEqual(this.items, dataMarketV2.items);
    }

    public int hashCode() {
        int iHashCode = this.subscriptions.hashCode() * 31;
        List<DataOuterService> list = this.services;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<DataMarketItem> list2 = this.items;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "DataMarketV2(subscriptions=" + this.subscriptions + ", services=" + this.services + ", items=" + this.items + ")";
    }

    public final List<DataBaseSubscription> getSubscriptions() {
        return this.subscriptions;
    }

    public final List<DataOuterService> getServices() {
        return this.services;
    }

    public final List<DataMarketItem> getItems() {
        return this.items;
    }
}
