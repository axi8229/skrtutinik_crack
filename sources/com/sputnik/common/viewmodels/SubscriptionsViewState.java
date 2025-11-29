package com.sputnik.common.viewmodels;

import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.market.items.MarketItem;
import com.sputnik.common.entities.services.OuterService;
import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionsViewModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J¢\u0001\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010'R\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010(\u001a\u0004\b)\u0010*R\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010(\u001a\u0004\b+\u0010*R\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010(\u001a\u0004\b,\u0010*R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010-\u001a\u0004\b.\u0010/R\u0017\u0010\u000e\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010-\u001a\u0004\b0\u0010/R\u0017\u0010\u000f\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u000f\u0010-\u001a\u0004\b1\u0010/R\u0017\u0010\u0010\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010-\u001a\u0004\b2\u0010/R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010-\u001a\u0004\b3\u0010/R\u0017\u0010\u0012\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010-\u001a\u0004\b4\u0010/R\u0017\u0010\u0013\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\b5\u0010/¨\u00066"}, d2 = {"Lcom/sputnik/common/viewmodels/SubscriptionsViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "marketState", "Lcom/sputnik/common/entities/subscriptions/BaseSubscription;", "activeSubscription", "", "subscriptions", "Lcom/sputnik/common/entities/services/OuterService;", "services", "Lcom/sputnik/common/entities/market/items/MarketItem;", "items", "", "needShowButtonPromo", "needShowButtonPromoEmpty", "needToBuySubscription", "needToLockAllViews", "needToShowRedPoint", "needToShowRedPointOnServices", "richFunctionalityAvailable", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/common/entities/subscriptions/BaseSubscription;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZZZZZZZ)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/common/entities/subscriptions/BaseSubscription;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZZZZZZZ)Lcom/sputnik/common/viewmodels/SubscriptionsViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getMarketState", "()Lcom/sputnik/domain/common/Resource$Status;", "Lcom/sputnik/common/entities/subscriptions/BaseSubscription;", "getActiveSubscription", "()Lcom/sputnik/common/entities/subscriptions/BaseSubscription;", "Ljava/util/List;", "getSubscriptions", "()Ljava/util/List;", "getServices", "getItems", "Z", "getNeedShowButtonPromo", "()Z", "getNeedShowButtonPromoEmpty", "getNeedToBuySubscription", "getNeedToLockAllViews", "getNeedToShowRedPoint", "getNeedToShowRedPointOnServices", "getRichFunctionalityAvailable", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SubscriptionsViewState implements VMState {
    private final BaseSubscription activeSubscription;
    private final List<MarketItem> items;
    private final Resource.Status marketState;
    private final boolean needShowButtonPromo;
    private final boolean needShowButtonPromoEmpty;
    private final boolean needToBuySubscription;
    private final boolean needToLockAllViews;
    private final boolean needToShowRedPoint;
    private final boolean needToShowRedPointOnServices;
    private final boolean richFunctionalityAvailable;
    private final List<OuterService> services;
    private final List<BaseSubscription> subscriptions;

    public SubscriptionsViewState() {
        this(null, null, null, null, null, false, false, false, false, false, false, false, 4095, null);
    }

    public final SubscriptionsViewState copy(Resource.Status marketState, BaseSubscription activeSubscription, List<BaseSubscription> subscriptions, List<OuterService> services, List<MarketItem> items, boolean needShowButtonPromo, boolean needShowButtonPromoEmpty, boolean needToBuySubscription, boolean needToLockAllViews, boolean needToShowRedPoint, boolean needToShowRedPointOnServices, boolean richFunctionalityAvailable) {
        Intrinsics.checkNotNullParameter(marketState, "marketState");
        return new SubscriptionsViewState(marketState, activeSubscription, subscriptions, services, items, needShowButtonPromo, needShowButtonPromoEmpty, needToBuySubscription, needToLockAllViews, needToShowRedPoint, needToShowRedPointOnServices, richFunctionalityAvailable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionsViewState)) {
            return false;
        }
        SubscriptionsViewState subscriptionsViewState = (SubscriptionsViewState) other;
        return this.marketState == subscriptionsViewState.marketState && Intrinsics.areEqual(this.activeSubscription, subscriptionsViewState.activeSubscription) && Intrinsics.areEqual(this.subscriptions, subscriptionsViewState.subscriptions) && Intrinsics.areEqual(this.services, subscriptionsViewState.services) && Intrinsics.areEqual(this.items, subscriptionsViewState.items) && this.needShowButtonPromo == subscriptionsViewState.needShowButtonPromo && this.needShowButtonPromoEmpty == subscriptionsViewState.needShowButtonPromoEmpty && this.needToBuySubscription == subscriptionsViewState.needToBuySubscription && this.needToLockAllViews == subscriptionsViewState.needToLockAllViews && this.needToShowRedPoint == subscriptionsViewState.needToShowRedPoint && this.needToShowRedPointOnServices == subscriptionsViewState.needToShowRedPointOnServices && this.richFunctionalityAvailable == subscriptionsViewState.richFunctionalityAvailable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.marketState.hashCode() * 31;
        BaseSubscription baseSubscription = this.activeSubscription;
        int iHashCode2 = (iHashCode + (baseSubscription == null ? 0 : baseSubscription.hashCode())) * 31;
        List<BaseSubscription> list = this.subscriptions;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<OuterService> list2 = this.services;
        int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<MarketItem> list3 = this.items;
        int iHashCode5 = (iHashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31;
        boolean z = this.needShowButtonPromo;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode5 + i) * 31;
        boolean z2 = this.needShowButtonPromoEmpty;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z3 = this.needToBuySubscription;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean z4 = this.needToLockAllViews;
        int i7 = z4;
        if (z4 != 0) {
            i7 = 1;
        }
        int i8 = (i6 + i7) * 31;
        boolean z5 = this.needToShowRedPoint;
        int i9 = z5;
        if (z5 != 0) {
            i9 = 1;
        }
        int i10 = (i8 + i9) * 31;
        boolean z6 = this.needToShowRedPointOnServices;
        int i11 = z6;
        if (z6 != 0) {
            i11 = 1;
        }
        int i12 = (i10 + i11) * 31;
        boolean z7 = this.richFunctionalityAvailable;
        return i12 + (z7 ? 1 : z7 ? 1 : 0);
    }

    public String toString() {
        return "SubscriptionsViewState(marketState=" + this.marketState + ", activeSubscription=" + this.activeSubscription + ", subscriptions=" + this.subscriptions + ", services=" + this.services + ", items=" + this.items + ", needShowButtonPromo=" + this.needShowButtonPromo + ", needShowButtonPromoEmpty=" + this.needShowButtonPromoEmpty + ", needToBuySubscription=" + this.needToBuySubscription + ", needToLockAllViews=" + this.needToLockAllViews + ", needToShowRedPoint=" + this.needToShowRedPoint + ", needToShowRedPointOnServices=" + this.needToShowRedPointOnServices + ", richFunctionalityAvailable=" + this.richFunctionalityAvailable + ")";
    }

    public SubscriptionsViewState(Resource.Status marketState, BaseSubscription baseSubscription, List<BaseSubscription> list, List<OuterService> list2, List<MarketItem> list3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Intrinsics.checkNotNullParameter(marketState, "marketState");
        this.marketState = marketState;
        this.activeSubscription = baseSubscription;
        this.subscriptions = list;
        this.services = list2;
        this.items = list3;
        this.needShowButtonPromo = z;
        this.needShowButtonPromoEmpty = z2;
        this.needToBuySubscription = z3;
        this.needToLockAllViews = z4;
        this.needToShowRedPoint = z5;
        this.needToShowRedPointOnServices = z6;
        this.richFunctionalityAvailable = z7;
    }

    public /* synthetic */ SubscriptionsViewState(Resource.Status status, BaseSubscription baseSubscription, List list, List list2, List list3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? null : baseSubscription, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2, (i & 16) == 0 ? list3 : null, (i & 32) != 0 ? false : z, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? false : z3, (i & 256) != 0 ? false : z4, (i & 512) != 0 ? false : z5, (i & 1024) != 0 ? false : z6, (i & 2048) == 0 ? z7 : false);
    }

    public final Resource.Status getMarketState() {
        return this.marketState;
    }

    public final BaseSubscription getActiveSubscription() {
        return this.activeSubscription;
    }

    public final List<BaseSubscription> getSubscriptions() {
        return this.subscriptions;
    }

    public final List<OuterService> getServices() {
        return this.services;
    }

    public final List<MarketItem> getItems() {
        return this.items;
    }

    public final boolean getNeedShowButtonPromo() {
        return this.needShowButtonPromo;
    }

    public final boolean getNeedToBuySubscription() {
        return this.needToBuySubscription;
    }

    public final boolean getNeedToLockAllViews() {
        return this.needToLockAllViews;
    }

    public final boolean getNeedToShowRedPoint() {
        return this.needToShowRedPoint;
    }

    public final boolean getNeedToShowRedPointOnServices() {
        return this.needToShowRedPointOnServices;
    }

    public final boolean getRichFunctionalityAvailable() {
        return this.richFunctionalityAvailable;
    }
}
