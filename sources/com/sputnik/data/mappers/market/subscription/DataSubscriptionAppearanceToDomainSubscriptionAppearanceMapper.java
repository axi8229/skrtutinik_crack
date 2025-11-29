package com.sputnik.data.mappers.market.subscription;

import com.sputnik.data.entities.market.DataBadgeStyle;
import com.sputnik.data.entities.market.DataDetailedLayout;
import com.sputnik.data.entities.market.subscription.DataSubscriptionAppearance;
import com.sputnik.data.mappers.market.DataDetailedLayoutToDomainDetailedLayoutMapper;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.market.appearance.DomainBadgeStyle;
import com.sputnik.domain.entities.market.subscription.DomainSubscriptionAppearance;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/sputnik/data/mappers/market/subscription/DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/market/subscription/DataSubscriptionAppearance;", "Lcom/sputnik/domain/entities/market/subscription/DomainSubscriptionAppearance;", "mapper", "Lcom/sputnik/data/mappers/market/DataDetailedLayoutToDomainDetailedLayoutMapper;", "(Lcom/sputnik/data/mappers/market/DataDetailedLayoutToDomainDetailedLayoutMapper;)V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper implements Mapper<DataSubscriptionAppearance, DomainSubscriptionAppearance> {
    private final DataDetailedLayoutToDomainDetailedLayoutMapper mapper;

    public DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper(DataDetailedLayoutToDomainDetailedLayoutMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.mapper = mapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public DomainSubscriptionAppearance map(DataSubscriptionAppearance input) {
        Intrinsics.checkNotNullParameter(input, "input");
        String title = input.getTitle();
        String description = input.getDescription();
        String specialDescription = input.getSpecialDescription();
        Boolean special = input.getSpecial();
        DataBadgeStyle badge = input.getBadge();
        String color = badge != null ? badge.getColor() : null;
        DataBadgeStyle badge2 = input.getBadge();
        DomainBadgeStyle domainBadgeStyle = new DomainBadgeStyle(color, badge2 != null ? badge2.getTitle() : null);
        List<String> list = input.getList();
        String finale = input.getFinale();
        String link = input.getLink();
        String priceVerbose = input.getPriceVerbose();
        DataDetailedLayout detailedLayout = input.getDetailedLayout();
        return new DomainSubscriptionAppearance(title, description, specialDescription, special, domainBadgeStyle, list, finale, link, priceVerbose, detailedLayout != null ? this.mapper.map(detailedLayout) : null);
    }
}
