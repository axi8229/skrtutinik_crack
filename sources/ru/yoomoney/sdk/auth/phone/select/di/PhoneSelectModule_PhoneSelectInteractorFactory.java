package ru.yoomoney.sdk.auth.phone.select.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.phone.select.impl.PhoneSelectInteractor;

/* loaded from: classes4.dex */
public final class PhoneSelectModule_PhoneSelectInteractorFactory implements Factory<PhoneSelectInteractor> {
    private final Provider<MigrationRepository> migrationRepositoryProvider;
    private final PhoneSelectModule module;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public PhoneSelectModule_PhoneSelectInteractorFactory(PhoneSelectModule phoneSelectModule, Provider<MigrationRepository> provider, Provider<ServerTimeRepository> provider2) {
        this.module = phoneSelectModule;
        this.migrationRepositoryProvider = provider;
        this.serverTimeRepositoryProvider = provider2;
    }

    public static PhoneSelectModule_PhoneSelectInteractorFactory create(PhoneSelectModule phoneSelectModule, Provider<MigrationRepository> provider, Provider<ServerTimeRepository> provider2) {
        return new PhoneSelectModule_PhoneSelectInteractorFactory(phoneSelectModule, provider, provider2);
    }

    public static PhoneSelectInteractor phoneSelectInteractor(PhoneSelectModule phoneSelectModule, MigrationRepository migrationRepository, ServerTimeRepository serverTimeRepository) {
        return (PhoneSelectInteractor) Preconditions.checkNotNullFromProvides(phoneSelectModule.phoneSelectInteractor(migrationRepository, serverTimeRepository));
    }

    @Override // javax.inject.Provider
    public PhoneSelectInteractor get() {
        return phoneSelectInteractor(this.module, this.migrationRepositoryProvider.get(), this.serverTimeRepositoryProvider.get());
    }
}
