package ru.yoomoney.sdk.auth.phone.confirm.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractor;

/* loaded from: classes4.dex */
public final class AuthPhoneConfirmModule_AuthPhoneConfirmInteractorFactory implements Factory<AuthPhoneConfirmInteractor> {
    private final Provider<EnrollmentRepository> enrollmentRepositoryProvider;
    private final Provider<LoginRepository> loginRepositoryProvider;
    private final Provider<MigrationRepository> migrationRepositoryProvider;
    private final AuthPhoneConfirmModule module;
    private final Provider<PasswordRecoveryRepository> passwordRecoveryRepositoryProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AuthPhoneConfirmModule_AuthPhoneConfirmInteractorFactory(AuthPhoneConfirmModule authPhoneConfirmModule, Provider<EnrollmentRepository> provider, Provider<LoginRepository> provider2, Provider<MigrationRepository> provider3, Provider<PasswordRecoveryRepository> provider4, Provider<ServerTimeRepository> provider5) {
        this.module = authPhoneConfirmModule;
        this.enrollmentRepositoryProvider = provider;
        this.loginRepositoryProvider = provider2;
        this.migrationRepositoryProvider = provider3;
        this.passwordRecoveryRepositoryProvider = provider4;
        this.serverTimeRepositoryProvider = provider5;
    }

    public static AuthPhoneConfirmInteractor authPhoneConfirmInteractor(AuthPhoneConfirmModule authPhoneConfirmModule, EnrollmentRepository enrollmentRepository, LoginRepository loginRepository, MigrationRepository migrationRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository) {
        return (AuthPhoneConfirmInteractor) Preconditions.checkNotNullFromProvides(authPhoneConfirmModule.authPhoneConfirmInteractor(enrollmentRepository, loginRepository, migrationRepository, passwordRecoveryRepository, serverTimeRepository));
    }

    public static AuthPhoneConfirmModule_AuthPhoneConfirmInteractorFactory create(AuthPhoneConfirmModule authPhoneConfirmModule, Provider<EnrollmentRepository> provider, Provider<LoginRepository> provider2, Provider<MigrationRepository> provider3, Provider<PasswordRecoveryRepository> provider4, Provider<ServerTimeRepository> provider5) {
        return new AuthPhoneConfirmModule_AuthPhoneConfirmInteractorFactory(authPhoneConfirmModule, provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public AuthPhoneConfirmInteractor get() {
        return authPhoneConfirmInteractor(this.module, this.enrollmentRepositoryProvider.get(), this.loginRepositoryProvider.get(), this.migrationRepositoryProvider.get(), this.passwordRecoveryRepositoryProvider.get(), this.serverTimeRepositoryProvider.get());
    }
}
