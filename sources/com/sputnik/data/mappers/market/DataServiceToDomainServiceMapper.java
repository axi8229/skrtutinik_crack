package com.sputnik.data.mappers.market;

import com.sputnik.data.entities.market.service.DataOriginSub;
import com.sputnik.data.entities.market.service.DataService;
import com.sputnik.data.entities.market.service.DataServiceAppearance;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.market.services.DomainOriginSub;
import com.sputnik.domain.entities.market.services.DomainService;
import com.sputnik.domain.entities.market.services.DomainServiceAppearance;
import com.sputnik.domain.entities.market.services.ServiceState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataServiceToDomainServiceMapper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/sputnik/data/mappers/market/DataServiceToDomainServiceMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/market/service/DataService;", "Lcom/sputnik/domain/entities/market/services/DomainService;", "dataServiceAppearanceToDomainServiceAppearanceMapper", "Lcom/sputnik/data/mappers/market/DataServiceAppearanceToDomainServiceAppearanceMapper;", "dataOriginSubToDomainOriginSubMapper", "Lcom/sputnik/data/mappers/market/DataOriginSubToDomainOriginSubMapper;", "(Lcom/sputnik/data/mappers/market/DataServiceAppearanceToDomainServiceAppearanceMapper;Lcom/sputnik/data/mappers/market/DataOriginSubToDomainOriginSubMapper;)V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataServiceToDomainServiceMapper implements Mapper<DataService, DomainService> {
    private final DataOriginSubToDomainOriginSubMapper dataOriginSubToDomainOriginSubMapper;
    private final DataServiceAppearanceToDomainServiceAppearanceMapper dataServiceAppearanceToDomainServiceAppearanceMapper;

    public DataServiceToDomainServiceMapper(DataServiceAppearanceToDomainServiceAppearanceMapper dataServiceAppearanceToDomainServiceAppearanceMapper, DataOriginSubToDomainOriginSubMapper dataOriginSubToDomainOriginSubMapper) {
        Intrinsics.checkNotNullParameter(dataServiceAppearanceToDomainServiceAppearanceMapper, "dataServiceAppearanceToDomainServiceAppearanceMapper");
        Intrinsics.checkNotNullParameter(dataOriginSubToDomainOriginSubMapper, "dataOriginSubToDomainOriginSubMapper");
        this.dataServiceAppearanceToDomainServiceAppearanceMapper = dataServiceAppearanceToDomainServiceAppearanceMapper;
        this.dataOriginSubToDomainOriginSubMapper = dataOriginSubToDomainOriginSubMapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public DomainService map(DataService input) {
        Intrinsics.checkNotNullParameter(input, "input");
        ServiceState state = input.getState();
        String serviceConfigIdentifier = input.getServiceConfigIdentifier();
        DataServiceAppearance appearance = input.getAppearance();
        DomainServiceAppearance map = appearance != null ? this.dataServiceAppearanceToDomainServiceAppearanceMapper.map(appearance) : null;
        DataOriginSub origin = input.getOrigin();
        DomainOriginSub map2 = origin != null ? this.dataOriginSubToDomainOriginSubMapper.map(origin) : null;
        String activatedAt = input.getActivatedAt();
        Boolean requiresSubscription = input.getRequiresSubscription();
        return new DomainService(state, serviceConfigIdentifier, map, map2, activatedAt, Boolean.valueOf(requiresSubscription != null ? requiresSubscription.booleanValue() : false));
    }
}
