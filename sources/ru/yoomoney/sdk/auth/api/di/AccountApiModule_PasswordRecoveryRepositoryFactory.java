package ru.yoomoney.sdk.auth.api.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.ClientAppParams;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryApi;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;

/* loaded from: classes4.dex */
public final class AccountApiModule_PasswordRecoveryRepositoryFactory implements Factory<PasswordRecoveryRepository> {
    private final Provider<PasswordRecoveryApi> apiProvider;
    private final Provider<ClientAppParams> clientAppParamsProvider;
    private final Provider<Boolean> isDebugModeProvider;
    private final Provider<LocationHeaderManager> locationHeaderManagerProvider;
    private final AccountApiModule module;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AccountApiModule_PasswordRecoveryRepositoryFactory(AccountApiModule accountApiModule, Provider<PasswordRecoveryApi> provider, Provider<ClientAppParams> provider2, Provider<ServerTimeRepository> provider3, Provider<Boolean> provider4, Provider<LocationHeaderManager> provider5) {
        this.module = accountApiModule;
        this.apiProvider = provider;
        this.clientAppParamsProvider = provider2;
        this.serverTimeRepositoryProvider = provider3;
        this.isDebugModeProvider = provider4;
        this.locationHeaderManagerProvider = provider5;
    }

    public static AccountApiModule_PasswordRecoveryRepositoryFactory create(AccountApiModule accountApiModule, Provider<PasswordRecoveryApi> provider, Provider<ClientAppParams> provider2, Provider<ServerTimeRepository> provider3, Provider<Boolean> provider4, Provider<LocationHeaderManager> provider5) {
        return new AccountApiModule_PasswordRecoveryRepositoryFactory(accountApiModule, provider, provider2, provider3, provider4, provider5);
    }

    public static PasswordRecoveryRepository passwordRecoveryRepository(AccountApiModule accountApiModule, PasswordRecoveryApi passwordRecoveryApi, ClientAppParams clientAppParams, ServerTimeRepository serverTimeRepository, boolean z, LocationHeaderManager locationHeaderManager) {
        return (PasswordRecoveryRepository) Preconditions.checkNotNullFromProvides(accountApiModule.passwordRecoveryRepository(passwordRecoveryApi, clientAppParams, serverTimeRepository, z, locationHeaderManager));
    }

    @Override // javax.inject.Provider
    public PasswordRecoveryRepository get() {
        return passwordRecoveryRepository(this.module, this.apiProvider.get(), this.clientAppParamsProvider.get(), this.serverTimeRepositoryProvider.get(), this.isDebugModeProvider.get().booleanValue(), this.locationHeaderManagerProvider.get());
    }
}
