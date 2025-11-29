package com.sputnik.common.viewmodels;

import com.sputnik.common.entities.country_code.CountryCode;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.county_code.DomainCountryCode;
import com.sputnik.domain.usecases.auth.ApplyRegistrationUseCase;
import com.sputnik.domain.usecases.auth.ConfirmRegistrationUseCase;
import com.sputnik.domain.usecases.auth.GetRequestUseCase;
import com.sputnik.domain.usecases.auth.RegisterUserByPhoneUseCase;
import com.sputnik.domain.usecases.country_code.GetCountryCodeUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
    private final Provider<ApplyRegistrationUseCase> applyRegistrationUseCaseProvider;
    private final Provider<IConfig> configProvider;
    private final Provider<ConfirmRegistrationUseCase> confirmRegistrationUseCaseProvider;
    private final Provider<ListMapper<DomainCountryCode, CountryCode>> domainCountryCodeToCountryCodeMapperProvider;
    private final Provider<GetCountryCodeUseCase> getCountryCodeUseCaseProvider;
    private final Provider<GetRequestUseCase> getRequestUseCaseProvider;
    private final Provider<PrefManager> prefManagerProvider;
    private final Provider<RegisterUserByPhoneUseCase> registerUserUserCaseProvider;

    public LoginViewModel_Factory(Provider<RegisterUserByPhoneUseCase> provider, Provider<ApplyRegistrationUseCase> provider2, Provider<ConfirmRegistrationUseCase> provider3, Provider<GetRequestUseCase> provider4, Provider<PrefManager> provider5, Provider<GetCountryCodeUseCase> provider6, Provider<ListMapper<DomainCountryCode, CountryCode>> provider7, Provider<IConfig> provider8) {
        this.registerUserUserCaseProvider = provider;
        this.applyRegistrationUseCaseProvider = provider2;
        this.confirmRegistrationUseCaseProvider = provider3;
        this.getRequestUseCaseProvider = provider4;
        this.prefManagerProvider = provider5;
        this.getCountryCodeUseCaseProvider = provider6;
        this.domainCountryCodeToCountryCodeMapperProvider = provider7;
        this.configProvider = provider8;
    }

    @Override // javax.inject.Provider
    public LoginViewModel get() {
        return newInstance(this.registerUserUserCaseProvider.get(), this.applyRegistrationUseCaseProvider.get(), this.confirmRegistrationUseCaseProvider.get(), this.getRequestUseCaseProvider.get(), this.prefManagerProvider.get(), this.getCountryCodeUseCaseProvider.get(), this.domainCountryCodeToCountryCodeMapperProvider.get(), this.configProvider.get());
    }

    public static LoginViewModel_Factory create(Provider<RegisterUserByPhoneUseCase> provider, Provider<ApplyRegistrationUseCase> provider2, Provider<ConfirmRegistrationUseCase> provider3, Provider<GetRequestUseCase> provider4, Provider<PrefManager> provider5, Provider<GetCountryCodeUseCase> provider6, Provider<ListMapper<DomainCountryCode, CountryCode>> provider7, Provider<IConfig> provider8) {
        return new LoginViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static LoginViewModel newInstance(RegisterUserByPhoneUseCase registerUserByPhoneUseCase, ApplyRegistrationUseCase applyRegistrationUseCase, ConfirmRegistrationUseCase confirmRegistrationUseCase, GetRequestUseCase getRequestUseCase, PrefManager prefManager, GetCountryCodeUseCase getCountryCodeUseCase, ListMapper<DomainCountryCode, CountryCode> listMapper, IConfig iConfig) {
        return new LoginViewModel(registerUserByPhoneUseCase, applyRegistrationUseCase, confirmRegistrationUseCase, getRequestUseCase, prefManager, getCountryCodeUseCase, listMapper, iConfig);
    }
}
