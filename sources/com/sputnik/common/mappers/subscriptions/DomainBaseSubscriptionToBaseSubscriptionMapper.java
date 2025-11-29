package com.sputnik.common.mappers.subscriptions;

import com.sputnik.common.entities.subscriptions.BaseSubscription;
import com.sputnik.common.entities.subscriptions.Plan;
import com.sputnik.common.entities.subscriptions.SubscriptionAppearance;
import com.sputnik.common.entities.subscriptions.SubscriptionDetails;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainBaseSubscription;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainPlan;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainSubscriptionAppearance;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainSubscriptionDetails;
import com.sputnik.domain.entities.subscriptions.subscriptions.SubscriptionStates;
import com.sputnik.domain.entities.subscriptions.subscriptions.SubscriptionTypes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DomainBaseSubscriptionToBaseSubscriptionMapper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/sputnik/common/mappers/subscriptions/DomainBaseSubscriptionToBaseSubscriptionMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/subscriptions/subscriptions/DomainBaseSubscription;", "Lcom/sputnik/common/entities/subscriptions/BaseSubscription;", "domainBaseSubscriptionToBaseSubscriptionMapper", "Lcom/sputnik/common/mappers/subscriptions/DomainBaseAppearanceToBaseAppearanceMapper;", "(Lcom/sputnik/common/mappers/subscriptions/DomainBaseAppearanceToBaseAppearanceMapper;)V", "map", "input", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DomainBaseSubscriptionToBaseSubscriptionMapper implements Mapper<DomainBaseSubscription, BaseSubscription> {
    private final DomainBaseAppearanceToBaseAppearanceMapper domainBaseSubscriptionToBaseSubscriptionMapper;

    public DomainBaseSubscriptionToBaseSubscriptionMapper(DomainBaseAppearanceToBaseAppearanceMapper domainBaseSubscriptionToBaseSubscriptionMapper) {
        Intrinsics.checkNotNullParameter(domainBaseSubscriptionToBaseSubscriptionMapper, "domainBaseSubscriptionToBaseSubscriptionMapper");
        this.domainBaseSubscriptionToBaseSubscriptionMapper = domainBaseSubscriptionToBaseSubscriptionMapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public BaseSubscription map(DomainBaseSubscription input) {
        SubscriptionStates subscriptionStates;
        ArrayList arrayList;
        List<DomainPlan> plans;
        Iterator it;
        Integer discountPrice;
        SubscriptionStates subscriptionStates2;
        String link;
        Plan.Promo promo;
        Intrinsics.checkNotNullParameter(input, "input");
        String identifier = input.getIdentifier();
        Integer order = input.getOrder();
        Integer version = input.getVersion();
        String duration = input.getDuration();
        String expires = input.getExpires();
        String plan = input.getPlan();
        String productId = input.getProductId();
        SubscriptionStates state = input.getState();
        SubscriptionTypes type = input.getType();
        DomainSubscriptionAppearance appearance = input.getAppearance();
        SubscriptionAppearance map = appearance != null ? this.domainBaseSubscriptionToBaseSubscriptionMapper.map(appearance) : null;
        DomainSubscriptionDetails subscriptionDetails = input.getSubscriptionDetails();
        if (subscriptionDetails == null || (plans = subscriptionDetails.getPlans()) == null) {
            subscriptionStates = state;
            arrayList = null;
        } else {
            List<DomainPlan> list = plans;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                DomainPlan domainPlan = (DomainPlan) it2.next();
                String appstoreProductId = domainPlan.getAppstoreProductId();
                String duration2 = domainPlan.getDuration();
                String identifier2 = domainPlan.getIdentifier();
                Integer price = domainPlan.getPrice();
                if (domainPlan.getPromo() == null) {
                    it = it2;
                    subscriptionStates2 = state;
                    promo = null;
                } else {
                    DomainPlan.DomainPromo promo2 = domainPlan.getPromo();
                    if (promo2 != null) {
                        it = it2;
                        discountPrice = promo2.getDiscountPrice();
                    } else {
                        it = it2;
                        discountPrice = null;
                    }
                    DomainPlan.DomainPromo promo3 = domainPlan.getPromo();
                    String description = promo3 != null ? promo3.getDescription() : null;
                    DomainPlan.DomainPromo promo4 = domainPlan.getPromo();
                    if (promo4 != null) {
                        subscriptionStates2 = state;
                        link = promo4.getLink();
                    } else {
                        subscriptionStates2 = state;
                        link = null;
                    }
                    DomainPlan.DomainPromo promo5 = domainPlan.getPromo();
                    promo = new Plan.Promo(discountPrice, description, link, promo5 != null ? promo5.getLinkText() : null);
                }
                arrayList.add(new Plan(appstoreProductId, duration2, identifier2, price, promo));
                it2 = it;
                state = subscriptionStates2;
            }
            subscriptionStates = state;
        }
        DomainSubscriptionDetails subscriptionDetails2 = input.getSubscriptionDetails();
        return new BaseSubscription(map, identifier, order, new SubscriptionDetails(arrayList, subscriptionDetails2 != null ? subscriptionDetails2.getProductId() : null), type, version, duration, expires, plan, productId, subscriptionStates);
    }
}
