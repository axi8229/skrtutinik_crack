package com.sputnik.data.mappers.market;

import com.sputnik.data.entities.market.DataPlanAppearance;
import com.sputnik.data.entities.market.DataPlans;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.market.PlansDuration;
import com.sputnik.domain.entities.market.subscription.DomainPlans;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataPlansToDomainPlansMapper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/sputnik/data/mappers/market/DataPlansToDomainPlansMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/market/DataPlans;", "Lcom/sputnik/domain/entities/market/subscription/DomainPlans;", "dataPlanAppearanceToDomainPlanAppearanceMapper", "Lcom/sputnik/data/mappers/market/DataPlanAppearanceToDomainPlanAppearanceMapper;", "(Lcom/sputnik/data/mappers/market/DataPlanAppearanceToDomainPlanAppearanceMapper;)V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataPlansToDomainPlansMapper implements Mapper<DataPlans, DomainPlans> {
    private final DataPlanAppearanceToDomainPlanAppearanceMapper dataPlanAppearanceToDomainPlanAppearanceMapper;

    public DataPlansToDomainPlansMapper(DataPlanAppearanceToDomainPlanAppearanceMapper dataPlanAppearanceToDomainPlanAppearanceMapper) {
        Intrinsics.checkNotNullParameter(dataPlanAppearanceToDomainPlanAppearanceMapper, "dataPlanAppearanceToDomainPlanAppearanceMapper");
        this.dataPlanAppearanceToDomainPlanAppearanceMapper = dataPlanAppearanceToDomainPlanAppearanceMapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public DomainPlans map(DataPlans input) {
        Intrinsics.checkNotNullParameter(input, "input");
        Boolean outdated = input.getOutdated();
        String identifier = input.getIdentifier();
        PlansDuration duration = input.getDuration();
        Integer price = input.getPrice();
        DataPlanAppearance appearance = input.getAppearance();
        return new DomainPlans(outdated, identifier, duration, price, appearance != null ? this.dataPlanAppearanceToDomainPlanAppearanceMapper.map(appearance) : null);
    }
}
