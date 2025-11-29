package com.sputnik.data.mappers.market;

import com.sputnik.data.entities.market.service.DataServiceAppearance;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.market.services.DomainServiceAppearance;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataServiceAppearanceToDomainServiceAppearanceMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/market/DataServiceAppearanceToDomainServiceAppearanceMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/market/service/DataServiceAppearance;", "Lcom/sputnik/domain/entities/market/services/DomainServiceAppearance;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataServiceAppearanceToDomainServiceAppearanceMapper implements Mapper<DataServiceAppearance, DomainServiceAppearance> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainServiceAppearance map(DataServiceAppearance input) {
        Intrinsics.checkNotNullParameter(input, "input");
        String title = input.getTitle();
        String description = input.getDescription();
        String origin = input.getOrigin();
        DataServiceAppearance.DataServiceBadge serviceBadge = input.getServiceBadge();
        String title2 = serviceBadge != null ? serviceBadge.getTitle() : null;
        DataServiceAppearance.DataServiceBadge serviceBadge2 = input.getServiceBadge();
        return new DomainServiceAppearance(title, description, origin, new DomainServiceAppearance.DomainServiceBadge(title2, serviceBadge2 != null ? serviceBadge2.getColor() : null));
    }
}
