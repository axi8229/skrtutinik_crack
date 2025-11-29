package ru.yoomoney.sdk.auth.password.enter.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.password.enter.impl.AuthPasswordEnterInteractor;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* loaded from: classes4.dex */
public final class AuthPasswordEnterModule_AuthPasswordEnterInteractorFactory implements Factory<AuthPasswordEnterInteractor> {
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final Provider<LoginRepository> loginRepositoryProvider;
    private final AuthPasswordEnterModule module;
    private final Provider<PasswordRecoveryRepository> passwordRecoveryRepositoryProvider;
    private final Provider<YooProfiler> profilerProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AuthPasswordEnterModule_AuthPasswordEnterInteractorFactory(AuthPasswordEnterModule authPasswordEnterModule, Provider<LoginRepository> provider, Provider<PasswordRecoveryRepository> provider2, Provider<ServerTimeRepository> provider3, Provider<YooProfiler> provider4, Provider<Lazy<Config>> provider5) {
        this.module = authPasswordEnterModule;
        this.loginRepositoryProvider = provider;
        this.passwordRecoveryRepositoryProvider = provider2;
        this.serverTimeRepositoryProvider = provider3;
        this.profilerProvider = provider4;
        this.lazyConfigProvider = provider5;
    }

    public static AuthPasswordEnterInteractor authPasswordEnterInteractor(AuthPasswordEnterModule authPasswordEnterModule, LoginRepository loginRepository, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository, YooProfiler yooProfiler, Lazy<Config> lazy) {
        return (AuthPasswordEnterInteractor) Preconditions.checkNotNullFromProvides(authPasswordEnterModule.authPasswordEnterInteractor(loginRepository, passwordRecoveryRepository, serverTimeRepository, yooProfiler, lazy));
    }

    public static AuthPasswordEnterModule_AuthPasswordEnterInteractorFactory create(AuthPasswordEnterModule authPasswordEnterModule, Provider<LoginRepository> provider, Provider<PasswordRecoveryRepository> provider2, Provider<ServerTimeRepository> provider3, Provider<YooProfiler> provider4, Provider<Lazy<Config>> provider5) {
        return new AuthPasswordEnterModule_AuthPasswordEnterInteractorFactory(authPasswordEnterModule, provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public AuthPasswordEnterInteractor get() {
        return authPasswordEnterInteractor(this.module, this.loginRepositoryProvider.get(), this.passwordRecoveryRepositoryProvider.get(), this.serverTimeRepositoryProvider.get(), this.profilerProvider.get(), this.lazyConfigProvider.get());
    }
}
