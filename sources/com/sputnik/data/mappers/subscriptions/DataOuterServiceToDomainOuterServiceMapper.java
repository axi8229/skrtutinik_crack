package com.sputnik.data.mappers.subscriptions;

import com.sputnik.data.entities.subscriptions.services.DataOuterService;
import com.sputnik.data.entities.subscriptions.services.DataOuterServiceAppearance;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.market.OuterServiceTypes;
import com.sputnik.domain.entities.subscriptions.services.DomainOuterService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataOuterServiceToDomainOuterServiceMapper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/sputnik/data/mappers/subscriptions/DataOuterServiceToDomainOuterServiceMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/subscriptions/services/DataOuterService;", "Lcom/sputnik/domain/entities/subscriptions/services/DomainOuterService;", "dataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper", "Lcom/sputnik/data/mappers/subscriptions/DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper;", "(Lcom/sputnik/data/mappers/subscriptions/DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper;)V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataOuterServiceToDomainOuterServiceMapper implements Mapper<DataOuterService, DomainOuterService> {
    private final DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper dataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper;

    public DataOuterServiceToDomainOuterServiceMapper(DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper dataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper) {
        Intrinsics.checkNotNullParameter(dataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper, "dataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper");
        this.dataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper = dataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public DomainOuterService map(DataOuterService input) {
        Intrinsics.checkNotNullParameter(input, "input");
        String identifier = input.getIdentifier();
        Integer order = input.getOrder();
        OuterServiceTypes type = input.getType();
        DataOuterServiceAppearance appearance = input.getAppearance();
        return new DomainOuterService(identifier, type, order, input.getSubscriptionDetails(), appearance != null ? this.dataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper.map(appearance) : null);
    }
}
