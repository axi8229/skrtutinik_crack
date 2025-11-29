package com.sputnik.data.entities.preferences;

import com.sputnik.domain.entities.subscriptions.subscriptions.DomainBaseSubscription;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarketRedPointPreferences.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$BQ\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0003\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR*\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001d¨\u0006%"}, d2 = {"Lcom/sputnik/data/entities/preferences/MarketRedPointPreferences;", "", "", "isMarketAvailable", "", "", "subscriptionsIdentifiers", "servicesIdentifiers", "marketItemsIdentifiers", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBaseSubscription;", "subscriptions", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setMarketAvailable", "(Ljava/lang/Boolean;)V", "Ljava/util/List;", "getSubscriptionsIdentifiers", "()Ljava/util/List;", "setSubscriptionsIdentifiers", "(Ljava/util/List;)V", "getServicesIdentifiers", "setServicesIdentifiers", "getMarketItemsIdentifiers", "setMarketItemsIdentifiers", "getSubscriptions", "setSubscriptions", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MarketRedPointPreferences {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Boolean isMarketAvailable;
    private List<String> marketItemsIdentifiers;
    private List<String> servicesIdentifiers;
    private List<DomainBaseSubscription> subscriptions;
    private List<String> subscriptionsIdentifiers;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarketRedPointPreferences)) {
            return false;
        }
        MarketRedPointPreferences marketRedPointPreferences = (MarketRedPointPreferences) other;
        return Intrinsics.areEqual(this.isMarketAvailable, marketRedPointPreferences.isMarketAvailable) && Intrinsics.areEqual(this.subscriptionsIdentifiers, marketRedPointPreferences.subscriptionsIdentifiers) && Intrinsics.areEqual(this.servicesIdentifiers, marketRedPointPreferences.servicesIdentifiers) && Intrinsics.areEqual(this.marketItemsIdentifiers, marketRedPointPreferences.marketItemsIdentifiers) && Intrinsics.areEqual(this.subscriptions, marketRedPointPreferences.subscriptions);
    }

    public int hashCode() {
        Boolean bool = this.isMarketAvailable;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        List<String> list = this.subscriptionsIdentifiers;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.servicesIdentifiers;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.marketItemsIdentifiers;
        int iHashCode4 = (iHashCode3 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<DomainBaseSubscription> list4 = this.subscriptions;
        return iHashCode4 + (list4 != null ? list4.hashCode() : 0);
    }

    public String toString() {
        return "MarketRedPointPreferences(isMarketAvailable=" + this.isMarketAvailable + ", subscriptionsIdentifiers=" + this.subscriptionsIdentifiers + ", servicesIdentifiers=" + this.servicesIdentifiers + ", marketItemsIdentifiers=" + this.marketItemsIdentifiers + ", subscriptions=" + this.subscriptions + ")";
    }

    public MarketRedPointPreferences(Boolean bool, List<String> list, List<String> list2, List<String> list3, List<DomainBaseSubscription> list4) {
        this.isMarketAvailable = bool;
        this.subscriptionsIdentifiers = list;
        this.servicesIdentifiers = list2;
        this.marketItemsIdentifiers = list3;
        this.subscriptions = list4;
    }

    /* renamed from: isMarketAvailable, reason: from getter */
    public final Boolean getIsMarketAvailable() {
        return this.isMarketAvailable;
    }

    public final List<String> getSubscriptionsIdentifiers() {
        return this.subscriptionsIdentifiers;
    }

    public final List<String> getServicesIdentifiers() {
        return this.servicesIdentifiers;
    }

    public final List<String> getMarketItemsIdentifiers() {
        return this.marketItemsIdentifiers;
    }

    public final List<DomainBaseSubscription> getSubscriptions() {
        return this.subscriptions;
    }

    /* compiled from: MarketRedPointPreferences.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/sputnik/data/entities/preferences/MarketRedPointPreferences$Companion;", "", "()V", "default", "Lcom/sputnik/data/entities/preferences/MarketRedPointPreferences;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: default, reason: not valid java name */
        public final MarketRedPointPreferences m2506default() {
            return new MarketRedPointPreferences(Boolean.FALSE, CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());
        }
    }
}
