package com.sputnik.data.mappers.market;

import com.sputnik.data.entities.market.DataBillDetails;
import com.sputnik.data.entities.market.DataMarket;
import com.sputnik.data.entities.market.DataOuterServiceDetails;
import com.sputnik.data.entities.market.subscription.DataSubscriptionAppearance;
import com.sputnik.data.entities.market.subscription.DataSubscriptionDetails;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionDetailsToDomainSubscriptionDetailsMapper;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.market.DomainBillDetails;
import com.sputnik.domain.entities.market.DomainMarket;
import com.sputnik.domain.entities.market.DomainOuterServiceDetails;
import com.sputnik.domain.entities.market.MarketTypes;
import com.sputnik.domain.entities.market.subscription.DomainSubscriptionAppearance;
import com.sputnik.domain.entities.market.subscription.DomainSubscriptionDetail;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataMarketToDomainMarketMapper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/sputnik/data/mappers/market/DataMarketToDomainMarketMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/market/DataMarket;", "Lcom/sputnik/domain/entities/market/DomainMarket;", "dataSubscriptionDetailsToDomainSubscriptionDetailsMapper", "Lcom/sputnik/data/mappers/market/subscription/DataSubscriptionDetailsToDomainSubscriptionDetailsMapper;", "dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper", "Lcom/sputnik/data/mappers/market/subscription/DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper;", "(Lcom/sputnik/data/mappers/market/subscription/DataSubscriptionDetailsToDomainSubscriptionDetailsMapper;Lcom/sputnik/data/mappers/market/subscription/DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper;)V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataMarketToDomainMarketMapper implements Mapper<DataMarket, DomainMarket> {
    private final DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper;
    private final DataSubscriptionDetailsToDomainSubscriptionDetailsMapper dataSubscriptionDetailsToDomainSubscriptionDetailsMapper;

    public DataMarketToDomainMarketMapper(DataSubscriptionDetailsToDomainSubscriptionDetailsMapper dataSubscriptionDetailsToDomainSubscriptionDetailsMapper, DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper) {
        Intrinsics.checkNotNullParameter(dataSubscriptionDetailsToDomainSubscriptionDetailsMapper, "dataSubscriptionDetailsToDomainSubscriptionDetailsMapper");
        Intrinsics.checkNotNullParameter(dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper, "dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper");
        this.dataSubscriptionDetailsToDomainSubscriptionDetailsMapper = dataSubscriptionDetailsToDomainSubscriptionDetailsMapper;
        this.dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper = dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public DomainMarket map(DataMarket input) {
        Intrinsics.checkNotNullParameter(input, "input");
        String identifier = input.getIdentifier();
        MarketTypes type = input.getType();
        Integer order = input.getOrder();
        DataSubscriptionDetails subscriptionDetails = input.getSubscriptionDetails();
        DomainSubscriptionDetail map = subscriptionDetails != null ? this.dataSubscriptionDetailsToDomainSubscriptionDetailsMapper.map(subscriptionDetails) : null;
        DataSubscriptionAppearance appearance = input.getAppearance();
        DomainSubscriptionAppearance map2 = appearance != null ? this.dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper.map(appearance) : null;
        DataBillDetails billDetails = input.getBillDetails();
        DomainBillDetails domainBillDetails = new DomainBillDetails(billDetails != null ? billDetails.getPrice() : null);
        DataOuterServiceDetails outerServiceDetails = input.getOuterServiceDetails();
        return new DomainMarket(identifier, type, order, map, map2, domainBillDetails, new DomainOuterServiceDetails(outerServiceDetails != null ? outerServiceDetails.getData() : null));
    }
}
