package sputnik.axmor.com.sputnik.di;

import com.sputnik.common.entities.market.subscription.Subscription;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.market.subscription.DomainSubscription;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import sputnik.axmor.com.sputnik.mappers.market.subscription.DomainSubscriptionToSubscriptionMapper;

/* loaded from: classes5.dex */
public final class DomainListMapperModule_ProvideDomainSubscriptionToSubscriptionFactory implements Factory<ListMapper<DomainSubscription, Subscription>> {
    public static ListMapper<DomainSubscription, Subscription> provideDomainSubscriptionToSubscription(DomainListMapperModule domainListMapperModule, DomainSubscriptionToSubscriptionMapper domainSubscriptionToSubscriptionMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(domainListMapperModule.provideDomainSubscriptionToSubscription(domainSubscriptionToSubscriptionMapper));
    }
}
