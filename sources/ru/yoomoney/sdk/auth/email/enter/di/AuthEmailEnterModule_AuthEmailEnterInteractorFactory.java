package ru.yoomoney.sdk.auth.email.enter.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractor;

/* loaded from: classes4.dex */
public final class AuthEmailEnterModule_AuthEmailEnterInteractorFactory implements Factory<AuthEmailEnterInteractor> {
    private final Provider<EnrollmentRepository> enrollmentRepositoryProvider;
    private final Provider<MigrationRepository> migrationRepositoryProvider;
    private final AuthEmailEnterModule module;
    private final Provider<RegistrationV2Repository> registrationV2RepositoryProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AuthEmailEnterModule_AuthEmailEnterInteractorFactory(AuthEmailEnterModule authEmailEnterModule, Provider<EnrollmentRepository> provider, Provider<RegistrationV2Repository> provider2, Provider<MigrationRepository> provider3, Provider<ServerTimeRepository> provider4) {
        this.module = authEmailEnterModule;
        this.enrollmentRepositoryProvider = provider;
        this.registrationV2RepositoryProvider = provider2;
        this.migrationRepositoryProvider = provider3;
        this.serverTimeRepositoryProvider = provider4;
    }

    public static AuthEmailEnterInteractor authEmailEnterInteractor(AuthEmailEnterModule authEmailEnterModule, EnrollmentRepository enrollmentRepository, RegistrationV2Repository registrationV2Repository, MigrationRepository migrationRepository, ServerTimeRepository serverTimeRepository) {
        return (AuthEmailEnterInteractor) Preconditions.checkNotNullFromProvides(authEmailEnterModule.authEmailEnterInteractor(enrollmentRepository, registrationV2Repository, migrationRepository, serverTimeRepository));
    }

    public static AuthEmailEnterModule_AuthEmailEnterInteractorFactory create(AuthEmailEnterModule authEmailEnterModule, Provider<EnrollmentRepository> provider, Provider<RegistrationV2Repository> provider2, Provider<MigrationRepository> provider3, Provider<ServerTimeRepository> provider4) {
        return new AuthEmailEnterModule_AuthEmailEnterInteractorFactory(authEmailEnterModule, provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public AuthEmailEnterInteractor get() {
        return authEmailEnterInteractor(this.module, this.enrollmentRepositoryProvider.get(), this.registrationV2RepositoryProvider.get(), this.migrationRepositoryProvider.get(), this.serverTimeRepositoryProvider.get());
    }
}
