package com.sputnik.data.mappers.archive;

import com.sputnik.data.entities.archive.DataArchiveItem;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.archive.DomainArchiveItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataArchiveToDomainArchiveMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/archive/DataArchiveItemToDomainArchiveItemMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/archive/DataArchiveItem;", "Lcom/sputnik/domain/entities/archive/DomainArchiveItem;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataArchiveItemToDomainArchiveItemMapper implements Mapper<DataArchiveItem, DomainArchiveItem> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainArchiveItem map(DataArchiveItem input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return new DomainArchiveItem(input.getCameraUUID(), input.getDeviceUUID(), input.getPlayerUrl(), input.getDomain(), input.getSdkUrl(), input.getArchiveToken());
    }
}
