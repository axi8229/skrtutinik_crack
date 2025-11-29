package ru.yoomoney.sdk.two_fa.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.two_fa.phoneCall.impl.PhoneCallInteractor;
import ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepository;

/* loaded from: classes5.dex */
public final class TwoFaModule_ProvidePhoneCallInteractorFactory implements Factory<PhoneCallInteractor> {
    private final Provider<AuthenticatorRepository> authenticatorRepositoryProvider;
    private final TwoFaModule module;

    public TwoFaModule_ProvidePhoneCallInteractorFactory(TwoFaModule twoFaModule, Provider<AuthenticatorRepository> provider) {
        this.module = twoFaModule;
        this.authenticatorRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public PhoneCallInteractor get() {
        return providePhoneCallInteractor(this.module, this.authenticatorRepositoryProvider.get());
    }

    public static TwoFaModule_ProvidePhoneCallInteractorFactory create(TwoFaModule twoFaModule, Provider<AuthenticatorRepository> provider) {
        return new TwoFaModule_ProvidePhoneCallInteractorFactory(twoFaModule, provider);
    }

    public static PhoneCallInteractor providePhoneCallInteractor(TwoFaModule twoFaModule, AuthenticatorRepository authenticatorRepository) {
        return (PhoneCallInteractor) Preconditions.checkNotNullFromProvides(twoFaModule.providePhoneCallInteractor(authenticatorRepository));
    }
}
