package com.sputnik.data.mappers.market;

import com.sputnik.data.entities.market.DataIncludedServices;
import com.sputnik.data.entities.market.DataSmallService;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.market.appearance.DomainIncludedServices;
import com.sputnik.domain.entities.market.services.DomainSmallServices;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataIncludedServiceToDomainIncludedServiceMapper.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\b\u0007\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/sputnik/data/mappers/market/DataIncludedServiceToDomainIncludedServiceMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/market/DataIncludedServices;", "Lcom/sputnik/domain/entities/market/appearance/DomainIncludedServices;", "mapper", "Lcom/sputnik/domain/common/NullableInputListMapper;", "Lcom/sputnik/data/entities/market/DataSmallService;", "Lcom/sputnik/domain/entities/market/services/DomainSmallServices;", "(Lcom/sputnik/domain/common/NullableInputListMapper;)V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataIncludedServiceToDomainIncludedServiceMapper implements Mapper<DataIncludedServices, DomainIncludedServices> {
    private final NullableInputListMapper<DataSmallService, DomainSmallServices> mapper;

    public DataIncludedServiceToDomainIncludedServiceMapper(NullableInputListMapper<DataSmallService, DomainSmallServices> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.mapper = mapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public DomainIncludedServices map(DataIncludedServices input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return new DomainIncludedServices(input.getTitle(), (List) this.mapper.map(input.getServices()));
    }
}
