package ru.yoomoney.sdk.two_fa.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.two_fa.entryPoint.impl.EntryPointInteractor;
import ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepository;

/* loaded from: classes5.dex */
public final class TwoFaModule_ProvideEntryPointInteractorFactory implements Factory<EntryPointInteractor> {
    private final Provider<AuthenticatorRepository> authenticatorRepositoryProvider;
    private final TwoFaModule module;

    public TwoFaModule_ProvideEntryPointInteractorFactory(TwoFaModule twoFaModule, Provider<AuthenticatorRepository> provider) {
        this.module = twoFaModule;
        this.authenticatorRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public EntryPointInteractor get() {
        return provideEntryPointInteractor(this.module, this.authenticatorRepositoryProvider.get());
    }

    public static TwoFaModule_ProvideEntryPointInteractorFactory create(TwoFaModule twoFaModule, Provider<AuthenticatorRepository> provider) {
        return new TwoFaModule_ProvideEntryPointInteractorFactory(twoFaModule, provider);
    }

    public static EntryPointInteractor provideEntryPointInteractor(TwoFaModule twoFaModule, AuthenticatorRepository authenticatorRepository) {
        return (EntryPointInteractor) Preconditions.checkNotNullFromProvides(twoFaModule.provideEntryPointInteractor(authenticatorRepository));
    }
}
