package ru.yoomoney.sdk.auth.api.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.ClientAppParams;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentApi;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;

/* loaded from: classes4.dex */
public final class AccountApiModule_EnrollmentRepositoryFactory implements Factory<EnrollmentRepository> {
    private final Provider<EnrollmentApi> apiProvider;
    private final Provider<ClientAppParams> clientAppParamsProvider;
    private final Provider<Boolean> isDebugModeProvider;
    private final AccountApiModule module;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AccountApiModule_EnrollmentRepositoryFactory(AccountApiModule accountApiModule, Provider<EnrollmentApi> provider, Provider<ClientAppParams> provider2, Provider<ServerTimeRepository> provider3, Provider<Boolean> provider4) {
        this.module = accountApiModule;
        this.apiProvider = provider;
        this.clientAppParamsProvider = provider2;
        this.serverTimeRepositoryProvider = provider3;
        this.isDebugModeProvider = provider4;
    }

    public static AccountApiModule_EnrollmentRepositoryFactory create(AccountApiModule accountApiModule, Provider<EnrollmentApi> provider, Provider<ClientAppParams> provider2, Provider<ServerTimeRepository> provider3, Provider<Boolean> provider4) {
        return new AccountApiModule_EnrollmentRepositoryFactory(accountApiModule, provider, provider2, provider3, provider4);
    }

    public static EnrollmentRepository enrollmentRepository(AccountApiModule accountApiModule, EnrollmentApi enrollmentApi, ClientAppParams clientAppParams, ServerTimeRepository serverTimeRepository, boolean z) {
        return (EnrollmentRepository) Preconditions.checkNotNullFromProvides(accountApiModule.enrollmentRepository(enrollmentApi, clientAppParams, serverTimeRepository, z));
    }

    @Override // javax.inject.Provider
    public EnrollmentRepository get() {
        return enrollmentRepository(this.module, this.apiProvider.get(), this.clientAppParamsProvider.get(), this.serverTimeRepositoryProvider.get(), this.isDebugModeProvider.get().booleanValue());
    }
}
