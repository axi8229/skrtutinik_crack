package com.sputnik.data.di.modules;

import com.sputnik.data.entities.localization.DataLocalization;
import com.sputnik.data.mappers.localization.DataLocalizationToDomainLocalizationMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.localization.DomainLocalization;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataLocalizationToDomainLocalizationFactory implements Factory<ListMapper<DataLocalization, DomainLocalization>> {
    private final Provider<DataLocalizationToDomainLocalizationMapper> mapperProvider;
    private final ListMappersModule module;

    public ListMappersModule_ProvideDataLocalizationToDomainLocalizationFactory(ListMappersModule listMappersModule, Provider<DataLocalizationToDomainLocalizationMapper> provider) {
        this.module = listMappersModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public ListMapper<DataLocalization, DomainLocalization> get() {
        return provideDataLocalizationToDomainLocalization(this.module, this.mapperProvider.get());
    }

    public static ListMappersModule_ProvideDataLocalizationToDomainLocalizationFactory create(ListMappersModule listMappersModule, Provider<DataLocalizationToDomainLocalizationMapper> provider) {
        return new ListMappersModule_ProvideDataLocalizationToDomainLocalizationFactory(listMappersModule, provider);
    }

    public static ListMapper<DataLocalization, DomainLocalization> provideDataLocalizationToDomainLocalization(ListMappersModule listMappersModule, DataLocalizationToDomainLocalizationMapper dataLocalizationToDomainLocalizationMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataLocalizationToDomainLocalization(dataLocalizationToDomainLocalizationMapper));
    }
}
