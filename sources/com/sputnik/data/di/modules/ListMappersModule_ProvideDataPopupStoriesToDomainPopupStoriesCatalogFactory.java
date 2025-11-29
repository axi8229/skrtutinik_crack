package com.sputnik.data.di.modules;

import com.sputnik.data.entities.popups.DataPopupStoryStructure;
import com.sputnik.data.mappers.popups.DataPopupStoryToDomainPopupStoryMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.popups.DomainPopupStoryStructure;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataPopupStoriesToDomainPopupStoriesCatalogFactory implements Factory<NullableInputListMapper<DataPopupStoryStructure, DomainPopupStoryStructure>> {
    private final Provider<DataPopupStoryToDomainPopupStoryMapper> mapperProvider;
    private final ListMappersModule module;

    public ListMappersModule_ProvideDataPopupStoriesToDomainPopupStoriesCatalogFactory(ListMappersModule listMappersModule, Provider<DataPopupStoryToDomainPopupStoryMapper> provider) {
        this.module = listMappersModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public NullableInputListMapper<DataPopupStoryStructure, DomainPopupStoryStructure> get() {
        return provideDataPopupStoriesToDomainPopupStoriesCatalog(this.module, this.mapperProvider.get());
    }

    public static ListMappersModule_ProvideDataPopupStoriesToDomainPopupStoriesCatalogFactory create(ListMappersModule listMappersModule, Provider<DataPopupStoryToDomainPopupStoryMapper> provider) {
        return new ListMappersModule_ProvideDataPopupStoriesToDomainPopupStoriesCatalogFactory(listMappersModule, provider);
    }

    public static NullableInputListMapper<DataPopupStoryStructure, DomainPopupStoryStructure> provideDataPopupStoriesToDomainPopupStoriesCatalog(ListMappersModule listMappersModule, DataPopupStoryToDomainPopupStoryMapper dataPopupStoryToDomainPopupStoryMapper) {
        return (NullableInputListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataPopupStoriesToDomainPopupStoriesCatalog(dataPopupStoryToDomainPopupStoryMapper));
    }
}
