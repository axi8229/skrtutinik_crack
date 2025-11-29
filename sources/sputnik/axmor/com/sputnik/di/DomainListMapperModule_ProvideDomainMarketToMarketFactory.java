package sputnik.axmor.com.sputnik.di;

import com.sputnik.common.entities.market.market.Market;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.market.DomainMarket;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import sputnik.axmor.com.sputnik.mappers.market.market.DomainMarketToMarketMapper;

/* loaded from: classes5.dex */
public final class DomainListMapperModule_ProvideDomainMarketToMarketFactory implements Factory<ListMapper<DomainMarket, Market>> {
    public static ListMapper<DomainMarket, Market> provideDomainMarketToMarket(DomainListMapperModule domainListMapperModule, DomainMarketToMarketMapper domainMarketToMarketMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(domainListMapperModule.provideDomainMarketToMarket(domainMarketToMarketMapper));
    }
}
