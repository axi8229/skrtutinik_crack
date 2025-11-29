package com.sputnik.data.di.modules;

import com.sputnik.data.entities.archive.DataArchiveResponse;
import com.sputnik.data.mappers.archive.DataArchiveToDomainArchiveMapper;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.archive.DomainArchiveUrls;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataArchiveToDomainArchiveFactory implements Factory<Mapper<DataArchiveResponse, DomainArchiveUrls>> {
    public static Mapper<DataArchiveResponse, DomainArchiveUrls> provideDataArchiveToDomainArchive(ListMappersModule listMappersModule, DataArchiveToDomainArchiveMapper dataArchiveToDomainArchiveMapper) {
        return (Mapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataArchiveToDomainArchive(dataArchiveToDomainArchiveMapper));
    }
}
