package ru.yoomoney.sdk.auth.password.enter.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository;
import ru.yoomoney.sdk.auth.api.passwordRecovery.PasswordRecoveryRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.password.enter.impl.AccountPasswordEnterInteractor;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* loaded from: classes4.dex */
public final class AccountPasswordEnterModule_AccountPasswordEnterInteractorFactory implements Factory<AccountPasswordEnterInteractor> {
    private final Provider<EmailChangeRepository> emailChangeRepositoryProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final AccountPasswordEnterModule module;
    private final Provider<PasswordChangeRepository> passwordChangeRepositoryProvider;
    private final Provider<PasswordRecoveryRepository> passwordRecoveryRepositoryProvider;
    private final Provider<YooProfiler> profilerProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AccountPasswordEnterModule_AccountPasswordEnterInteractorFactory(AccountPasswordEnterModule accountPasswordEnterModule, Provider<PasswordRecoveryRepository> provider, Provider<ServerTimeRepository> provider2, Provider<EmailChangeRepository> provider3, Provider<PasswordChangeRepository> provider4, Provider<YooProfiler> provider5, Provider<Lazy<Config>> provider6) {
        this.module = accountPasswordEnterModule;
        this.passwordRecoveryRepositoryProvider = provider;
        this.serverTimeRepositoryProvider = provider2;
        this.emailChangeRepositoryProvider = provider3;
        this.passwordChangeRepositoryProvider = provider4;
        this.profilerProvider = provider5;
        this.lazyConfigProvider = provider6;
    }

    public static AccountPasswordEnterInteractor accountPasswordEnterInteractor(AccountPasswordEnterModule accountPasswordEnterModule, PasswordRecoveryRepository passwordRecoveryRepository, ServerTimeRepository serverTimeRepository, EmailChangeRepository emailChangeRepository, PasswordChangeRepository passwordChangeRepository, YooProfiler yooProfiler, Lazy<Config> lazy) {
        return (AccountPasswordEnterInteractor) Preconditions.checkNotNullFromProvides(accountPasswordEnterModule.accountPasswordEnterInteractor(passwordRecoveryRepository, serverTimeRepository, emailChangeRepository, passwordChangeRepository, yooProfiler, lazy));
    }

    public static AccountPasswordEnterModule_AccountPasswordEnterInteractorFactory create(AccountPasswordEnterModule accountPasswordEnterModule, Provider<PasswordRecoveryRepository> provider, Provider<ServerTimeRepository> provider2, Provider<EmailChangeRepository> provider3, Provider<PasswordChangeRepository> provider4, Provider<YooProfiler> provider5, Provider<Lazy<Config>> provider6) {
        return new AccountPasswordEnterModule_AccountPasswordEnterInteractorFactory(accountPasswordEnterModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public AccountPasswordEnterInteractor get() {
        return accountPasswordEnterInteractor(this.module, this.passwordRecoveryRepositoryProvider.get(), this.serverTimeRepositoryProvider.get(), this.emailChangeRepositoryProvider.get(), this.passwordChangeRepositoryProvider.get(), this.profilerProvider.get(), this.lazyConfigProvider.get());
    }
}
