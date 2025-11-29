package ru.yoomoney.sdk.auth.email.select.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.email.select.impl.EmailSelectInteractor;

/* loaded from: classes4.dex */
public final class EmailSelectModule_ProvideEmailSelectInteractorFactory implements Factory<EmailSelectInteractor> {
    private final Provider<MigrationRepository> migrationRepositoryProvider;
    private final EmailSelectModule module;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public EmailSelectModule_ProvideEmailSelectInteractorFactory(EmailSelectModule emailSelectModule, Provider<MigrationRepository> provider, Provider<ServerTimeRepository> provider2) {
        this.module = emailSelectModule;
        this.migrationRepositoryProvider = provider;
        this.serverTimeRepositoryProvider = provider2;
    }

    public static EmailSelectModule_ProvideEmailSelectInteractorFactory create(EmailSelectModule emailSelectModule, Provider<MigrationRepository> provider, Provider<ServerTimeRepository> provider2) {
        return new EmailSelectModule_ProvideEmailSelectInteractorFactory(emailSelectModule, provider, provider2);
    }

    public static EmailSelectInteractor provideEmailSelectInteractor(EmailSelectModule emailSelectModule, MigrationRepository migrationRepository, ServerTimeRepository serverTimeRepository) {
        return (EmailSelectInteractor) Preconditions.checkNotNullFromProvides(emailSelectModule.provideEmailSelectInteractor(migrationRepository, serverTimeRepository));
    }

    @Override // javax.inject.Provider
    public EmailSelectInteractor get() {
        return provideEmailSelectInteractor(this.module, this.migrationRepositoryProvider.get(), this.serverTimeRepositoryProvider.get());
    }
}
