package ru.yoomoney.sdk.auth.acceptTerms.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.acceptTerms.impl.AcceptTermsInteractor;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;

/* loaded from: classes4.dex */
public final class AcceptTermsModule_AcceptTermsInteractorFactory implements Factory<AcceptTermsInteractor> {
    private final Provider<EnrollmentRepository> enrollmentRepositoryProvider;
    private final AcceptTermsModule module;

    public AcceptTermsModule_AcceptTermsInteractorFactory(AcceptTermsModule acceptTermsModule, Provider<EnrollmentRepository> provider) {
        this.module = acceptTermsModule;
        this.enrollmentRepositoryProvider = provider;
    }

    public static AcceptTermsInteractor acceptTermsInteractor(AcceptTermsModule acceptTermsModule, EnrollmentRepository enrollmentRepository) {
        return (AcceptTermsInteractor) Preconditions.checkNotNullFromProvides(acceptTermsModule.acceptTermsInteractor(enrollmentRepository));
    }

    public static AcceptTermsModule_AcceptTermsInteractorFactory create(AcceptTermsModule acceptTermsModule, Provider<EnrollmentRepository> provider) {
        return new AcceptTermsModule_AcceptTermsInteractorFactory(acceptTermsModule, provider);
    }

    @Override // javax.inject.Provider
    public AcceptTermsInteractor get() {
        return acceptTermsInteractor(this.module, this.enrollmentRepositoryProvider.get());
    }
}
