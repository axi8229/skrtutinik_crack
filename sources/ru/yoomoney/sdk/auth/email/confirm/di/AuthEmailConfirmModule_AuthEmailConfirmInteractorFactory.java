package ru.yoomoney.sdk.auth.email.confirm.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.email.confirm.impl.AuthEmailConfirmInteractor;

/* loaded from: classes4.dex */
public final class AuthEmailConfirmModule_AuthEmailConfirmInteractorFactory implements Factory<AuthEmailConfirmInteractor> {
    private final Provider<EnrollmentRepository> enrollmentRepositoryProvider;
    private final Provider<LoginRepository> loginRepositoryProvider;
    private final Provider<MigrationRepository> migrationRepositoryProvider;
    private final AuthEmailConfirmModule module;
    private final Provider<PasswordRecoveryRepository> passwordRecoveryRepositoryProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AuthEmailConfirmModule_AuthEmailConfirmInteractorFactory(AuthEmailConfirmModule authEmailConfirmModule, Provider<EnrollmentRepository> provider, Provider<LoginRepository> provider2, Provider<MigrationRepository> provider3, Provider<PasswordRecoveryRepository> provider4, Provider<ServerTimeRepository> provider5) {
        this.module = authEmailConfirmModule;
        this.enrollmentRepositoryProvider = provider;
        this.loginRepositoryProvider = provider2;
        this.migrationRepositoryProvider = provider3;
        this.passwordRecoveryRepositoryProvider = provider4;
        this.serverTimeRepositoryProvider = provider5;
    }

    public static AuthEmailConfirmInteractor authEmailConfirmInteractor(AuthEmailConfirmModule authEmailConfirmModule, EnrollmentRepository enrollmentRepository, LoginRepository loginRepository, MigrationRepository migrationRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        return (AuthEmailConfirmInteractor) Preconditions.checkNotNullFromProvides(authEmailConfirmModule.authEmailConfirmInteractor(enrollmentRepository, loginRepository, migrationRepository, passwordRecoveryRepository, serverTimeRepository));
    }

    public static AuthEmailConfirmModule_AuthEmailConfirmInteractorFactory create(AuthEmailConfirmModule authEmailConfirmModule, Provider<EnrollmentRepository> provider, Provider<LoginRepository> provider2, Provider<MigrationRepository> provider3, Provider<PasswordRecoveryRepository> provider4, Provider<ServerTimeRepository> provider5) {
        return new AuthEmailConfirmModule_AuthEmailConfirmInteractorFactory(authEmailConfirmModule, provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public AuthEmailConfirmInteractor get() {
        return authEmailConfirmInteractor(this.module, this.enrollmentRepositoryProvider.get(), this.loginRepositoryProvider.get(), this.migrationRepositoryProvider.get(), this.passwordRecoveryRepositoryProvider.get(), this.serverTimeRepositoryProvider.get());
    }
}
