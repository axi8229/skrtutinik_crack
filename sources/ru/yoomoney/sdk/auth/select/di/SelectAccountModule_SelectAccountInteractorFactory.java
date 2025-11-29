package ru.yoomoney.sdk.auth.select.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractor;

/* loaded from: classes4.dex */
public final class SelectAccountModule_SelectAccountInteractorFactory implements Factory<SelectAccountInteractor> {
    private final Provider<EnrollmentRepository> enrollmentRepositoryProvider;
    private final Provider<LoginRepository> loginRepositoryProvider;
    private final SelectAccountModule module;
    private final Provider<PasswordRecoveryRepository> passwordRecoveryRepositoryProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public SelectAccountModule_SelectAccountInteractorFactory(SelectAccountModule selectAccountModule, Provider<ServerTimeRepository> provider, Provider<LoginRepository> provider2, Provider<PasswordRecoveryRepository> provider3, Provider<EnrollmentRepository> provider4) {
        this.module = selectAccountModule;
        this.serverTimeRepositoryProvider = provider;
        this.loginRepositoryProvider = provider2;
        this.passwordRecoveryRepositoryProvider = provider3;
        this.enrollmentRepositoryProvider = provider4;
    }

    public static SelectAccountModule_SelectAccountInteractorFactory create(SelectAccountModule selectAccountModule, Provider<ServerTimeRepository> provider, Provider<LoginRepository> provider2, Provider<PasswordRecoveryRepository> provider3, Provider<EnrollmentRepository> provider4) {
        return new SelectAccountModule_SelectAccountInteractorFactory(selectAccountModule, provider, provider2, provider3, provider4);
    }

    public static SelectAccountInteractor selectAccountInteractor(SelectAccountModule selectAccountModule, ServerTimeRepository serverTimeRepository, LoginRepository loginRepository, PasswordRecoveryRepository passwordRecoveryRepository, EnrollmentRepository enrollmentRepository) {
        return (SelectAccountInteractor) Preconditions.checkNotNullFromProvides(selectAccountModule.selectAccountInteractor(serverTimeRepository, loginRepository, passwordRecoveryRepository, enrollmentRepository));
    }

    @Override // javax.inject.Provider
    public SelectAccountInteractor get() {
        return selectAccountInteractor(this.module, this.serverTimeRepositoryProvider.get(), this.loginRepositoryProvider.get(), this.passwordRecoveryRepositoryProvider.get(), this.enrollmentRepositoryProvider.get());
    }
}
