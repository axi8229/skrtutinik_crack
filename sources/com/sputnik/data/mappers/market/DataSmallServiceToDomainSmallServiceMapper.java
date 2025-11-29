package com.sputnik.data.mappers.market;

import com.sputnik.data.entities.market.DataBaseAppearance;
import com.sputnik.data.entities.market.DataSmallService;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.market.appearance.DomainBaseAppearance;
import com.sputnik.domain.entities.market.services.DomainSmallServices;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataSmallServiceToDomainSmallServiceMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/market/DataSmallServiceToDomainSmallServiceMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/market/DataSmallService;", "Lcom/sputnik/domain/entities/market/services/DomainSmallServices;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataSmallServiceToDomainSmallServiceMapper implements Mapper<DataSmallService, DomainSmallServices> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainSmallServices map(DataSmallService input) {
        Intrinsics.checkNotNullParameter(input, "input");
        String serviceConfigIdentifier = input.getServiceConfigIdentifier();
        DataBaseAppearance appearance = input.getAppearance();
        String title = appearance != null ? appearance.getTitle() : null;
        DataBaseAppearance appearance2 = input.getAppearance();
        String description = appearance2 != null ? appearance2.getDescription() : null;
        DataBaseAppearance appearance3 = input.getAppearance();
        return new DomainSmallServices(serviceConfigIdentifier, new DomainBaseAppearance(title, description, appearance3 != null ? appearance3.getOrigin() : null));
    }
}
