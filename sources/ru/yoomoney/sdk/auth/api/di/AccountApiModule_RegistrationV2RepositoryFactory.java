package ru.yoomoney.sdk.auth.api.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.api.registrationV2.api.RegistrationV2Api;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;

/* loaded from: classes4.dex */
public final class AccountApiModule_RegistrationV2RepositoryFactory implements Factory<RegistrationV2Repository> {
    private final Provider<RegistrationV2Api> apiProvider;
    private final Provider<Lazy<Config>> configProvider;
    private final Provider<LocationHeaderManager> locationHeaderManagerProvider;
    private final AccountApiModule module;

    public AccountApiModule_RegistrationV2RepositoryFactory(AccountApiModule accountApiModule, Provider<RegistrationV2Api> provider, Provider<Lazy<Config>> provider2, Provider<LocationHeaderManager> provider3) {
        this.module = accountApiModule;
        this.apiProvider = provider;
        this.configProvider = provider2;
        this.locationHeaderManagerProvider = provider3;
    }

    public static AccountApiModule_RegistrationV2RepositoryFactory create(AccountApiModule accountApiModule, Provider<RegistrationV2Api> provider, Provider<Lazy<Config>> provider2, Provider<LocationHeaderManager> provider3) {
        return new AccountApiModule_RegistrationV2RepositoryFactory(accountApiModule, provider, provider2, provider3);
    }

    public static RegistrationV2Repository registrationV2Repository(AccountApiModule accountApiModule, RegistrationV2Api registrationV2Api, Lazy<Config> lazy, LocationHeaderManager locationHeaderManager) {
        return (RegistrationV2Repository) Preconditions.checkNotNullFromProvides(accountApiModule.registrationV2Repository(registrationV2Api, lazy, locationHeaderManager));
    }

    @Override // javax.inject.Provider
    public RegistrationV2Repository get() {
        return registrationV2Repository(this.module, this.apiProvider.get(), this.configProvider.get(), this.locationHeaderManagerProvider.get());
    }
}
