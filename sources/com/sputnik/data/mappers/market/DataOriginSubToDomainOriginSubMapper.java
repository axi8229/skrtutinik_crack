package com.sputnik.data.mappers.market;

import com.sputnik.data.entities.market.service.DataOriginSub;
import com.sputnik.data.entities.subscriptions.services.DataServiceAppearance;
import com.sputnik.data.entities.subscriptions.subscriptions.DataBadge;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.market.services.DomainOriginSub;
import com.sputnik.domain.entities.market.services.OriginType;
import com.sputnik.domain.entities.subscriptions.services.DomainServiceAppearance;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainBadge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataOriginSubToDomainOriginSubMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/market/DataOriginSubToDomainOriginSubMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/market/service/DataOriginSub;", "Lcom/sputnik/domain/entities/market/services/DomainOriginSub;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataOriginSubToDomainOriginSubMapper implements Mapper<DataOriginSub, DomainOriginSub> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainOriginSub map(DataOriginSub input) {
        DataBadge badge;
        DataBadge badge2;
        Intrinsics.checkNotNullParameter(input, "input");
        OriginType type = input.getType();
        String productId = input.getProductId();
        String title = input.getTitle();
        Integer price = input.getPrice();
        String fullExpires = input.getFullExpires();
        String phone = input.getPhone();
        String website = input.getWebsite();
        String originTitle = input.getOriginTitle();
        boolean showBadge = input.getShowBadge();
        DataServiceAppearance appearance = input.getAppearance();
        String description = appearance != null ? appearance.getDescription() : null;
        DataServiceAppearance appearance2 = input.getAppearance();
        String finale = appearance2 != null ? appearance2.getFinale() : null;
        DataServiceAppearance appearance3 = input.getAppearance();
        String color = (appearance3 == null || (badge2 = appearance3.getBadge()) == null) ? null : badge2.getColor();
        DataServiceAppearance appearance4 = input.getAppearance();
        DomainBadge domainBadge = new DomainBadge(color, (appearance4 == null || (badge = appearance4.getBadge()) == null) ? null : badge.getTitle());
        DataServiceAppearance appearance5 = input.getAppearance();
        String link = appearance5 != null ? appearance5.getLink() : null;
        DataServiceAppearance appearance6 = input.getAppearance();
        return new DomainOriginSub(type, productId, title, price, fullExpires, phone, website, originTitle, showBadge, new DomainServiceAppearance(description, finale, link, appearance6 != null ? appearance6.getTitle() : null, domainBadge));
    }
}
