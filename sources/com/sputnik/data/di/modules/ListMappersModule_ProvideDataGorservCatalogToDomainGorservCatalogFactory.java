package com.sputnik.data.di.modules;

import com.sputnik.data.entities.gorserv.DataGorservCatalog;
import com.sputnik.data.mappers.gorserv.DataGorservCatalogToDomainGorservCatalogMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.gorserv.DomainGorservCatalog;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataGorservCatalogToDomainGorservCatalogFactory implements Factory<ListMapper<DataGorservCatalog, DomainGorservCatalog>> {
    public static ListMapper<DataGorservCatalog, DomainGorservCatalog> provideDataGorservCatalogToDomainGorservCatalog(ListMappersModule listMappersModule, DataGorservCatalogToDomainGorservCatalogMapper dataGorservCatalogToDomainGorservCatalogMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataGorservCatalogToDomainGorservCatalog(dataGorservCatalogToDomainGorservCatalogMapper));
    }
}
