package com.sputnik.common.di.use_cases.single_use_cases;

import com.sputnik.domain.repositories.localization.ILocalizationRepository;
import com.sputnik.domain.usecases.localization.GetLocalizationUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class LocalizationUseCaseModule_ProvideGetLocalizationUseCaseFactory implements Factory<GetLocalizationUseCase> {
    private final LocalizationUseCaseModule module;
    private final Provider<ILocalizationRepository> repositoryProvider;

    public LocalizationUseCaseModule_ProvideGetLocalizationUseCaseFactory(LocalizationUseCaseModule localizationUseCaseModule, Provider<ILocalizationRepository> provider) {
        this.module = localizationUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetLocalizationUseCase get() {
        return provideGetLocalizationUseCase(this.module, this.repositoryProvider.get());
    }

    public static LocalizationUseCaseModule_ProvideGetLocalizationUseCaseFactory create(LocalizationUseCaseModule localizationUseCaseModule, Provider<ILocalizationRepository> provider) {
        return new LocalizationUseCaseModule_ProvideGetLocalizationUseCaseFactory(localizationUseCaseModule, provider);
    }

    public static GetLocalizationUseCase provideGetLocalizationUseCase(LocalizationUseCaseModule localizationUseCaseModule, ILocalizationRepository iLocalizationRepository) {
        return (GetLocalizationUseCase) Preconditions.checkNotNullFromProvides(localizationUseCaseModule.provideGetLocalizationUseCase(iLocalizationRepository));
    }
}
