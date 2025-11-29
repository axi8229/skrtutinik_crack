package ru.yoomoney.sdk.two_fa.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepository;
import ru.yoomoney.sdk.two_fa.smsConfirm.impl.SmsConfirmInteractor;

/* loaded from: classes5.dex */
public final class TwoFaModule_ProvideSmsConfirmInteractorFactory implements Factory<SmsConfirmInteractor> {
    private final Provider<AuthenticatorRepository> authenticatorRepositoryProvider;
    private final TwoFaModule module;

    public TwoFaModule_ProvideSmsConfirmInteractorFactory(TwoFaModule twoFaModule, Provider<AuthenticatorRepository> provider) {
        this.module = twoFaModule;
        this.authenticatorRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public SmsConfirmInteractor get() {
        return provideSmsConfirmInteractor(this.module, this.authenticatorRepositoryProvider.get());
    }

    public static TwoFaModule_ProvideSmsConfirmInteractorFactory create(TwoFaModule twoFaModule, Provider<AuthenticatorRepository> provider) {
        return new TwoFaModule_ProvideSmsConfirmInteractorFactory(twoFaModule, provider);
    }

    public static SmsConfirmInteractor provideSmsConfirmInteractor(TwoFaModule twoFaModule, AuthenticatorRepository authenticatorRepository) {
        return (SmsConfirmInteractor) Preconditions.checkNotNullFromProvides(twoFaModule.provideSmsConfirmInteractor(authenticatorRepository));
    }
}
