package ru.yoomoney.sdk.two_fa.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.two_fa.api.Class2faApi;
import ru.yoomoney.sdk.two_fa.repository.AuthenticatorRepository;

/* loaded from: classes5.dex */
public final class TwoFaModule_ProvideAuthenticatorRepositoryFactory implements Factory<AuthenticatorRepository> {
    private final TwoFaModule module;
    private final Provider<Class2faApi> twoFaApiProvider;

    public TwoFaModule_ProvideAuthenticatorRepositoryFactory(TwoFaModule twoFaModule, Provider<Class2faApi> provider) {
        this.module = twoFaModule;
        this.twoFaApiProvider = provider;
    }

    @Override // javax.inject.Provider
    public AuthenticatorRepository get() {
        return provideAuthenticatorRepository(this.module, this.twoFaApiProvider.get());
    }

    public static TwoFaModule_ProvideAuthenticatorRepositoryFactory create(TwoFaModule twoFaModule, Provider<Class2faApi> provider) {
        return new TwoFaModule_ProvideAuthenticatorRepositoryFactory(twoFaModule, provider);
    }

    public static AuthenticatorRepository provideAuthenticatorRepository(TwoFaModule twoFaModule, Class2faApi class2faApi) {
        return (AuthenticatorRepository) Preconditions.checkNotNullFromProvides(twoFaModule.provideAuthenticatorRepository(class2faApi));
    }
}
