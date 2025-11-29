package ru.yoomoney.sdk.two_fa.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl.EmailConfirmInteractor;
import ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepository;

/* loaded from: classes5.dex */
public final class TwoFaModule_ProvideEmailConfirmInteractorFactory implements Factory<EmailConfirmInteractor> {
    private final Provider<AuthenticatorRepository> authenticatorRepositoryProvider;
    private final TwoFaModule module;

    public TwoFaModule_ProvideEmailConfirmInteractorFactory(TwoFaModule twoFaModule, Provider<AuthenticatorRepository> provider) {
        this.module = twoFaModule;
        this.authenticatorRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public EmailConfirmInteractor get() {
        return provideEmailConfirmInteractor(this.module, this.authenticatorRepositoryProvider.get());
    }

    public static TwoFaModule_ProvideEmailConfirmInteractorFactory create(TwoFaModule twoFaModule, Provider<AuthenticatorRepository> provider) {
        return new TwoFaModule_ProvideEmailConfirmInteractorFactory(twoFaModule, provider);
    }

    public static EmailConfirmInteractor provideEmailConfirmInteractor(TwoFaModule twoFaModule, AuthenticatorRepository authenticatorRepository) {
        return (EmailConfirmInteractor) Preconditions.checkNotNullFromProvides(twoFaModule.provideEmailConfirmInteractor(authenticatorRepository));
    }
}
