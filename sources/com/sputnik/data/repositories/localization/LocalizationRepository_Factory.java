package com.sputnik.data.repositories.localization;

import com.sputnik.data.api.LocalizationApi;
import com.sputnik.data.entities.localization.DataLocalization;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.localization.DomainLocalization;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class LocalizationRepository_Factory implements Factory<LocalizationRepository> {
    private final Provider<ListMapper<DataLocalization, DomainLocalization>> dataLocalizationToDomainLocalizationMapperProvider;
    private final Provider<LocalizationApi> localizationApiProvider;

    public LocalizationRepository_Factory(Provider<LocalizationApi> provider, Provider<ListMapper<DataLocalization, DomainLocalization>> provider2) {
        this.localizationApiProvider = provider;
        this.dataLocalizationToDomainLocalizationMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public LocalizationRepository get() {
        return newInstance(this.localizationApiProvider.get(), this.dataLocalizationToDomainLocalizationMapperProvider.get());
    }

    public static LocalizationRepository_Factory create(Provider<LocalizationApi> provider, Provider<ListMapper<DataLocalization, DomainLocalization>> provider2) {
        return new LocalizationRepository_Factory(provider, provider2);
    }

    public static LocalizationRepository newInstance(LocalizationApi localizationApi, ListMapper<DataLocalization, DomainLocalization> listMapper) {
        return new LocalizationRepository(localizationApi, listMapper);
    }
}
