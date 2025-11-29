package com.sputnik.common.di.use_cases.single_use_cases;

import com.sputnik.domain.repositories.country_code.ICountryCodeRepository;
import com.sputnik.domain.usecases.country_code.GetCountryCodeUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class CountryCodeUseCaseModule_ProvideGetCountryCodeUseCaseFactory implements Factory<GetCountryCodeUseCase> {
    private final CountryCodeUseCaseModule module;
    private final Provider<ICountryCodeRepository> repositoryProvider;

    public CountryCodeUseCaseModule_ProvideGetCountryCodeUseCaseFactory(CountryCodeUseCaseModule countryCodeUseCaseModule, Provider<ICountryCodeRepository> provider) {
        this.module = countryCodeUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetCountryCodeUseCase get() {
        return provideGetCountryCodeUseCase(this.module, this.repositoryProvider.get());
    }

    public static CountryCodeUseCaseModule_ProvideGetCountryCodeUseCaseFactory create(CountryCodeUseCaseModule countryCodeUseCaseModule, Provider<ICountryCodeRepository> provider) {
        return new CountryCodeUseCaseModule_ProvideGetCountryCodeUseCaseFactory(countryCodeUseCaseModule, provider);
    }

    public static GetCountryCodeUseCase provideGetCountryCodeUseCase(CountryCodeUseCaseModule countryCodeUseCaseModule, ICountryCodeRepository iCountryCodeRepository) {
        return (GetCountryCodeUseCase) Preconditions.checkNotNullFromProvides(countryCodeUseCaseModule.provideGetCountryCodeUseCase(iCountryCodeRepository));
    }
}
