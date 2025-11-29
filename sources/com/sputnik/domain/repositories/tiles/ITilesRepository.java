package com.sputnik.domain.repositories.tiles;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.tiles.DomainTile;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ITilesRepository.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/sputnik/domain/repositories/tiles/ITilesRepository;", "", "getTiles", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/tiles/DomainTile;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ITilesRepository {
    Flow<Resource<List<DomainTile>>> getTiles();
}
