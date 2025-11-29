package com.sputnik.data.mappers.archive;

import com.sputnik.data.entities.archive.DataArchiveItem;
import com.sputnik.data.entities.archive.DataArchiveResponse;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.archive.DomainArchiveUrls;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataArchiveToDomainArchiveMapper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/sputnik/data/mappers/archive/DataArchiveToDomainArchiveMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/archive/DataArchiveResponse;", "Lcom/sputnik/domain/entities/archive/DomainArchiveUrls;", "itemMapper", "Lcom/sputnik/data/mappers/archive/DataArchiveItemToDomainArchiveItemMapper;", "(Lcom/sputnik/data/mappers/archive/DataArchiveItemToDomainArchiveItemMapper;)V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataArchiveToDomainArchiveMapper implements Mapper<DataArchiveResponse, DomainArchiveUrls> {
    private final DataArchiveItemToDomainArchiveItemMapper itemMapper;

    public DataArchiveToDomainArchiveMapper(DataArchiveItemToDomainArchiveItemMapper itemMapper) {
        Intrinsics.checkNotNullParameter(itemMapper, "itemMapper");
        this.itemMapper = itemMapper;
    }

    @Override // com.sputnik.domain.common.Mapper
    public DomainArchiveUrls map(DataArchiveResponse input) {
        Intrinsics.checkNotNullParameter(input, "input");
        String way = input.getWay();
        List<DataArchiveItem> data = input.getData();
        DataArchiveItemToDomainArchiveItemMapper dataArchiveItemToDomainArchiveItemMapper = this.itemMapper;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(data, 10));
        Iterator<T> it = data.iterator();
        while (it.hasNext()) {
            arrayList.add(dataArchiveItemToDomainArchiveItemMapper.map((DataArchiveItem) it.next()));
        }
        return new DomainArchiveUrls(way, arrayList, input.getMessage());
    }
}
