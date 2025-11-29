package ru.yoomoney.sdk.auth.password.create.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.password.create.impl.AuthPasswordCreateInteractor;

/* loaded from: classes4.dex */
public final class AuthPasswordCreateModule_AuthPasswordCreateInteractorFactory implements Factory<AuthPasswordCreateInteractor> {
    private final Provider<EnrollmentRepository> enrollmentRepositoryProvider;
    private final Provider<MigrationRepository> migrationRepositoryProvider;
    private final AuthPasswordCreateModule module;
    private final Provider<PasswordRecoveryRepository> passwordRecoveryRepositoryProvider;
    private final Provider<RegistrationV2Repository> registrationV2RepositoryProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AuthPasswordCreateModule_AuthPasswordCreateInteractorFactory(AuthPasswordCreateModule authPasswordCreateModule, Provider<EnrollmentRepository> provider, Provider<RegistrationV2Repository> provider2, Provider<MigrationRepository> provider3, Provider<PasswordRecoveryRepository> provider4, Provider<ServerTimeRepository> provider5) {
        this.module = authPasswordCreateModule;
        this.enrollmentRepositoryProvider = provider;
        this.registrationV2RepositoryProvider = provider2;
        this.migrationRepositoryProvider = provider3;
        this.passwordRecoveryRepositoryProvider = provider4;
        this.serverTimeRepositoryProvider = provider5;
    }

    public static AuthPasswordCreateInteractor authPasswordCreateInteractor(AuthPasswordCreateModule authPasswordCreateModule, EnrollmentRepository enrollmentRepository, RegistrationV2Repository registrationV2Repository, MigrationRepository migrationRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        return (AuthPasswordCreateInteractor) Preconditions.checkNotNullFromProvides(authPasswordCreateModule.authPasswordCreateInteractor(enrollmentRepository, registrationV2Repository, migrationRepository, passwordRecoveryRepository, serverTimeRepository));
    }

    public static AuthPasswordCreateModule_AuthPasswordCreateInteractorFactory create(AuthPasswordCreateModule authPasswordCreateModule, Provider<EnrollmentRepository> provider, Provider<RegistrationV2Repository> provider2, Provider<MigrationRepository> provider3, Provider<PasswordRecoveryRepository> provider4, Provider<ServerTimeRepository> provider5) {
        return new AuthPasswordCreateModule_AuthPasswordCreateInteractorFactory(authPasswordCreateModule, provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public AuthPasswordCreateInteractor get() {
        return authPasswordCreateInteractor(this.module, this.enrollmentRepositoryProvider.get(), this.registrationV2RepositoryProvider.get(), this.migrationRepositoryProvider.get(), this.passwordRecoveryRepositoryProvider.get(), this.serverTimeRepositoryProvider.get());
    }
}
