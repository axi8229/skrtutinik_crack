package ru.yoomoney.sdk.auth.api.login.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.login.impl.LoginEnterInteractor;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;

/* loaded from: classes4.dex */
public final class LoginEnterModule_LoginEnterInteractorFactory implements Factory<LoginEnterInteractor> {
    private final Provider<LoginRepository> loginRepositoryProvider;
    private final LoginEnterModule module;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public LoginEnterModule_LoginEnterInteractorFactory(LoginEnterModule loginEnterModule, Provider<LoginRepository> provider, Provider<ServerTimeRepository> provider2) {
        this.module = loginEnterModule;
        this.loginRepositoryProvider = provider;
        this.serverTimeRepositoryProvider = provider2;
    }

    public static LoginEnterModule_LoginEnterInteractorFactory create(LoginEnterModule loginEnterModule, Provider<LoginRepository> provider, Provider<ServerTimeRepository> provider2) {
        return new LoginEnterModule_LoginEnterInteractorFactory(loginEnterModule, provider, provider2);
    }

    public static LoginEnterInteractor loginEnterInteractor(LoginEnterModule loginEnterModule, LoginRepository loginRepository, ServerTimeRepository serverTimeRepository) {
        return (LoginEnterInteractor) Preconditions.checkNotNullFromProvides(loginEnterModule.loginEnterInteractor(loginRepository, serverTimeRepository));
    }

    @Override // javax.inject.Provider
    public LoginEnterInteractor get() {
        return loginEnterInteractor(this.module, this.loginRepositoryProvider.get(), this.serverTimeRepositoryProvider.get());
    }
}
