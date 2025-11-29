package ru.yoomoney.sdk.auth.phone.enter.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.phone.enter.impl.AuthPhoneEnterInteractor;

/* loaded from: classes4.dex */
public final class AuthPhoneEnterModule_AuthPasswordEnterInteractorFactory implements Factory<AuthPhoneEnterInteractor> {
    private final Provider<EnrollmentRepository> enrollmentRepositoryProvider;
    private final Provider<MigrationRepository> migrationRepositoryProvider;
    private final AuthPhoneEnterModule module;
    private final Provider<PasswordRecoveryRepository> passwordRecoveryRepositoryProvider;
    private final Provider<RegistrationV2Repository> registrationV2RepositoryProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AuthPhoneEnterModule_AuthPasswordEnterInteractorFactory(AuthPhoneEnterModule authPhoneEnterModule, Provider<EnrollmentRepository> provider, Provider<RegistrationV2Repository> provider2, Provider<MigrationRepository> provider3, Provider<PasswordRecoveryRepository> provider4, Provider<ServerTimeRepository> provider5) {
        this.module = authPhoneEnterModule;
        this.enrollmentRepositoryProvider = provider;
        this.registrationV2RepositoryProvider = provider2;
        this.migrationRepositoryProvider = provider3;
        this.passwordRecoveryRepositoryProvider = provider4;
        this.serverTimeRepositoryProvider = provider5;
    }

    public static AuthPhoneEnterInteractor authPasswordEnterInteractor(AuthPhoneEnterModule authPhoneEnterModule, EnrollmentRepository enrollmentRepository, RegistrationV2Repository registrationV2Repository, MigrationRepository migrationRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        return (AuthPhoneEnterInteractor) Preconditions.checkNotNullFromProvides(authPhoneEnterModule.authPasswordEnterInteractor(enrollmentRepository, registrationV2Repository, migrationRepository, passwordRecoveryRepository, serverTimeRepository));
    }

    public static AuthPhoneEnterModule_AuthPasswordEnterInteractorFactory create(AuthPhoneEnterModule authPhoneEnterModule, Provider<EnrollmentRepository> provider, Provider<RegistrationV2Repository> provider2, Provider<MigrationRepository> provider3, Provider<PasswordRecoveryRepository> provider4, Provider<ServerTimeRepository> provider5) {
        return new AuthPhoneEnterModule_AuthPasswordEnterInteractorFactory(authPhoneEnterModule, provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public AuthPhoneEnterInteractor get() {
        return authPasswordEnterInteractor(this.module, this.enrollmentRepositoryProvider.get(), this.registrationV2RepositoryProvider.get(), this.migrationRepositoryProvider.get(), this.passwordRecoveryRepositoryProvider.get(), this.serverTimeRepositoryProvider.get());
    }
}
