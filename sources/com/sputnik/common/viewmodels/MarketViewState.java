package com.sputnik.common.viewmodels;

import com.sputnik.common.base.VMState;
import com.sputnik.common.entities.market.market.Market;
import com.sputnik.common.entities.market.service.Service;
import com.sputnik.common.entities.market.subscription.Subscription;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarketViewModel.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0090\u0001\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b%\u0010$R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b&\u0010$R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010)R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b*\u0010)R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010'\u001a\u0004\b+\u0010)R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b,\u0010)R\u001f\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010-\u001a\u0004\b.\u0010/R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u00100\u001a\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/sputnik/common/viewmodels/MarketViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/domain/common/Resource$Status;", "marketState", "subscriptionState", "servicesState", "", "Lcom/sputnik/common/entities/market/market/Market;", "market", "Lcom/sputnik/common/entities/market/subscription/Subscription;", "subscriptions", "Lcom/sputnik/common/entities/market/service/Service;", "services", "newServices", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "Lcom/sputnik/domain/common/Event;", "", "needUpdate", "<init>", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Exception;Lcom/sputnik/domain/common/Event;)V", "copy", "(Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Lcom/sputnik/domain/common/Resource$Status;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Exception;Lcom/sputnik/domain/common/Event;)Lcom/sputnik/common/viewmodels/MarketViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/domain/common/Resource$Status;", "getMarketState", "()Lcom/sputnik/domain/common/Resource$Status;", "getSubscriptionState", "getServicesState", "Ljava/util/List;", "getMarket", "()Ljava/util/List;", "getSubscriptions", "getServices", "getNewServices", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "Lcom/sputnik/domain/common/Event;", "getNeedUpdate", "()Lcom/sputnik/domain/common/Event;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MarketViewState implements VMState {
    private final Exception exception;
    private final List<Market> market;
    private final Resource.Status marketState;
    private final Event<Boolean> needUpdate;
    private final List<Service> newServices;
    private final List<Service> services;
    private final Resource.Status servicesState;
    private final Resource.Status subscriptionState;
    private final List<Subscription> subscriptions;

    public MarketViewState() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public final MarketViewState copy(Resource.Status marketState, Resource.Status subscriptionState, Resource.Status servicesState, List<Market> market, List<Subscription> subscriptions, List<Service> services, List<Service> newServices, Exception exception, Event<Boolean> needUpdate) {
        Intrinsics.checkNotNullParameter(marketState, "marketState");
        Intrinsics.checkNotNullParameter(subscriptionState, "subscriptionState");
        Intrinsics.checkNotNullParameter(servicesState, "servicesState");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(subscriptions, "subscriptions");
        Intrinsics.checkNotNullParameter(services, "services");
        Intrinsics.checkNotNullParameter(newServices, "newServices");
        Intrinsics.checkNotNullParameter(needUpdate, "needUpdate");
        return new MarketViewState(marketState, subscriptionState, servicesState, market, subscriptions, services, newServices, exception, needUpdate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarketViewState)) {
            return false;
        }
        MarketViewState marketViewState = (MarketViewState) other;
        return this.marketState == marketViewState.marketState && this.subscriptionState == marketViewState.subscriptionState && this.servicesState == marketViewState.servicesState && Intrinsics.areEqual(this.market, marketViewState.market) && Intrinsics.areEqual(this.subscriptions, marketViewState.subscriptions) && Intrinsics.areEqual(this.services, marketViewState.services) && Intrinsics.areEqual(this.newServices, marketViewState.newServices) && Intrinsics.areEqual(this.exception, marketViewState.exception) && Intrinsics.areEqual(this.needUpdate, marketViewState.needUpdate);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.marketState.hashCode() * 31) + this.subscriptionState.hashCode()) * 31) + this.servicesState.hashCode()) * 31) + this.market.hashCode()) * 31) + this.subscriptions.hashCode()) * 31) + this.services.hashCode()) * 31) + this.newServices.hashCode()) * 31;
        Exception exc = this.exception;
        return ((iHashCode + (exc == null ? 0 : exc.hashCode())) * 31) + this.needUpdate.hashCode();
    }

    public String toString() {
        return "MarketViewState(marketState=" + this.marketState + ", subscriptionState=" + this.subscriptionState + ", servicesState=" + this.servicesState + ", market=" + this.market + ", subscriptions=" + this.subscriptions + ", services=" + this.services + ", newServices=" + this.newServices + ", exception=" + this.exception + ", needUpdate=" + this.needUpdate + ")";
    }

    public MarketViewState(Resource.Status marketState, Resource.Status subscriptionState, Resource.Status servicesState, List<Market> market, List<Subscription> subscriptions, List<Service> services, List<Service> newServices, Exception exc, Event<Boolean> needUpdate) {
        Intrinsics.checkNotNullParameter(marketState, "marketState");
        Intrinsics.checkNotNullParameter(subscriptionState, "subscriptionState");
        Intrinsics.checkNotNullParameter(servicesState, "servicesState");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(subscriptions, "subscriptions");
        Intrinsics.checkNotNullParameter(services, "services");
        Intrinsics.checkNotNullParameter(newServices, "newServices");
        Intrinsics.checkNotNullParameter(needUpdate, "needUpdate");
        this.marketState = marketState;
        this.subscriptionState = subscriptionState;
        this.servicesState = servicesState;
        this.market = market;
        this.subscriptions = subscriptions;
        this.services = services;
        this.newServices = newServices;
        this.exception = exc;
        this.needUpdate = needUpdate;
    }

    public /* synthetic */ MarketViewState(Resource.Status status, Resource.Status status2, Resource.Status status3, List list, List list2, List list3, List list4, Exception exc, Event event, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Resource.Status.NONE : status, (i & 2) != 0 ? Resource.Status.NONE : status2, (i & 4) != 0 ? Resource.Status.NONE : status3, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? CollectionsKt.emptyList() : list2, (i & 32) != 0 ? CollectionsKt.emptyList() : list3, (i & 64) != 0 ? CollectionsKt.emptyList() : list4, (i & 128) != 0 ? null : exc, (i & 256) != 0 ? new Event(Boolean.FALSE) : event);
    }

    public final Resource.Status getMarketState() {
        return this.marketState;
    }

    public final Resource.Status getSubscriptionState() {
        return this.subscriptionState;
    }

    public final Resource.Status getServicesState() {
        return this.servicesState;
    }

    public final List<Market> getMarket() {
        return this.market;
    }

    public final List<Subscription> getSubscriptions() {
        return this.subscriptions;
    }

    public final List<Service> getServices() {
        return this.services;
    }

    public final List<Service> getNewServices() {
        return this.newServices;
    }

    public final Event<Boolean> getNeedUpdate() {
        return this.needUpdate;
    }
}
