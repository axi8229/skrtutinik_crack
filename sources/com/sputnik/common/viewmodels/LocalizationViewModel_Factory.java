package com.sputnik.common.viewmodels;

import com.sputnik.common.entities.localization.Localization;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.localization.DomainLocalization;
import com.sputnik.domain.usecases.localization.GetLocalizationUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class LocalizationViewModel_Factory implements Factory<LocalizationViewModel> {
    private final Provider<IConfig> configProvider;
    private final Provider<ListMapper<DomainLocalization, Localization>> domainLocalizationToLocalizationMapperProvider;
    private final Provider<GetLocalizationUseCase> getLocalizationUseCaseProvider;
    private final Provider<LocalizationStorage> localizationStorageProvider;
    private final Provider<PrefManager> prefManagerProvider;

    public LocalizationViewModel_Factory(Provider<GetLocalizationUseCase> provider, Provider<PrefManager> provider2, Provider<IConfig> provider3, Provider<ListMapper<DomainLocalization, Localization>> provider4, Provider<LocalizationStorage> provider5) {
        this.getLocalizationUseCaseProvider = provider;
        this.prefManagerProvider = provider2;
        this.configProvider = provider3;
        this.domainLocalizationToLocalizationMapperProvider = provider4;
        this.localizationStorageProvider = provider5;
    }

    @Override // javax.inject.Provider
    public LocalizationViewModel get() {
        return newInstance(this.getLocalizationUseCaseProvider.get(), this.prefManagerProvider.get(), this.configProvider.get(), this.domainLocalizationToLocalizationMapperProvider.get(), this.localizationStorageProvider.get());
    }

    public static LocalizationViewModel_Factory create(Provider<GetLocalizationUseCase> provider, Provider<PrefManager> provider2, Provider<IConfig> provider3, Provider<ListMapper<DomainLocalization, Localization>> provider4, Provider<LocalizationStorage> provider5) {
        return new LocalizationViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static LocalizationViewModel newInstance(GetLocalizationUseCase getLocalizationUseCase, PrefManager prefManager, IConfig iConfig, ListMapper<DomainLocalization, Localization> listMapper, LocalizationStorage localizationStorage) {
        return new LocalizationViewModel(getLocalizationUseCase, prefManager, iConfig, listMapper, localizationStorage);
    }
}
