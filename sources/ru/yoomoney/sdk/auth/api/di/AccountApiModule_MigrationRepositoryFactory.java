package ru.yoomoney.sdk.auth.api.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.ClientAppParams;
import ru.yoomoney.sdk.auth.api.migration.MigrationApi;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;

/* loaded from: classes4.dex */
public final class AccountApiModule_MigrationRepositoryFactory implements Factory<MigrationRepository> {
    private final Provider<MigrationApi> apiProvider;
    private final Provider<ClientAppParams> clientAppParamsProvider;
    private final Provider<Boolean> isDebugModeProvider;
    private final Provider<LocationHeaderManager> locationHeaderManagerProvider;
    private final AccountApiModule module;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AccountApiModule_MigrationRepositoryFactory(AccountApiModule accountApiModule, Provider<MigrationApi> provider, Provider<ClientAppParams> provider2, Provider<ServerTimeRepository> provider3, Provider<Boolean> provider4, Provider<LocationHeaderManager> provider5) {
        this.module = accountApiModule;
        this.apiProvider = provider;
        this.clientAppParamsProvider = provider2;
        this.serverTimeRepositoryProvider = provider3;
        this.isDebugModeProvider = provider4;
        this.locationHeaderManagerProvider = provider5;
    }

    public static AccountApiModule_MigrationRepositoryFactory create(AccountApiModule accountApiModule, Provider<MigrationApi> provider, Provider<ClientAppParams> provider2, Provider<ServerTimeRepository> provider3, Provider<Boolean> provider4, Provider<LocationHeaderManager> provider5) {
        return new AccountApiModule_MigrationRepositoryFactory(accountApiModule, provider, provider2, provider3, provider4, provider5);
    }

    public static MigrationRepository migrationRepository(AccountApiModule accountApiModule, MigrationApi migrationApi, ClientAppParams clientAppParams, ServerTimeRepository serverTimeRepository, boolean z, LocationHeaderManager locationHeaderManager) {
        return (MigrationRepository) Preconditions.checkNotNullFromProvides(accountApiModule.migrationRepository(migrationApi, clientAppParams, serverTimeRepository, z, locationHeaderManager));
    }

    @Override // javax.inject.Provider
    public MigrationRepository get() {
        return migrationRepository(this.module, this.apiProvider.get(), this.clientAppParamsProvider.get(), this.serverTimeRepositoryProvider.get(), this.isDebugModeProvider.get().booleanValue(), this.locationHeaderManagerProvider.get());
    }
}
