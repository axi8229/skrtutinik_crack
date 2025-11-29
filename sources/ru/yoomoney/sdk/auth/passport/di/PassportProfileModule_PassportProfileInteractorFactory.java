package ru.yoomoney.sdk.auth.passport.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.api.ClientAppParams;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository;
import ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepository;
import ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractor;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* loaded from: classes4.dex */
public final class PassportProfileModule_PassportProfileInteractorFactory implements Factory<PassportProfileInteractor> {
    private final Provider<AccountRepository> accountRepositoryProvider;
    private final Provider<ClientAppParams> clientAppParamsProvider;
    private final Provider<Context> contextProvider;
    private final Provider<EmailChangeRepository> emailChangeRepositoryProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final PassportProfileModule module;
    private final Provider<PasswordChangeRepository> passwordChangeRepositoryProvider;
    private final Provider<PhoneChangeRepository> phoneChangeRepositoryProvider;
    private final Provider<YooProfiler> profilerProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;
    private final Provider<SocialAccountRepository> socialAccountRepositoryProvider;

    public PassportProfileModule_PassportProfileInteractorFactory(PassportProfileModule passportProfileModule, Provider<AccountRepository> provider, Provider<EmailChangeRepository> provider2, Provider<PhoneChangeRepository> provider3, Provider<PasswordChangeRepository> provider4, Provider<SocialAccountRepository> provider5, Provider<ServerTimeRepository> provider6, Provider<Lazy<Config>> provider7, Provider<YooProfiler> provider8, Provider<ClientAppParams> provider9, Provider<Context> provider10) {
        this.module = passportProfileModule;
        this.accountRepositoryProvider = provider;
        this.emailChangeRepositoryProvider = provider2;
        this.phoneChangeRepositoryProvider = provider3;
        this.passwordChangeRepositoryProvider = provider4;
        this.socialAccountRepositoryProvider = provider5;
        this.serverTimeRepositoryProvider = provider6;
        this.lazyConfigProvider = provider7;
        this.profilerProvider = provider8;
        this.clientAppParamsProvider = provider9;
        this.contextProvider = provider10;
    }

    public static PassportProfileModule_PassportProfileInteractorFactory create(PassportProfileModule passportProfileModule, Provider<AccountRepository> provider, Provider<EmailChangeRepository> provider2, Provider<PhoneChangeRepository> provider3, Provider<PasswordChangeRepository> provider4, Provider<SocialAccountRepository> provider5, Provider<ServerTimeRepository> provider6, Provider<Lazy<Config>> provider7, Provider<YooProfiler> provider8, Provider<ClientAppParams> provider9, Provider<Context> provider10) {
        return new PassportProfileModule_PassportProfileInteractorFactory(passportProfileModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static PassportProfileInteractor passportProfileInteractor(PassportProfileModule passportProfileModule, AccountRepository accountRepository, EmailChangeRepository emailChangeRepository, PhoneChangeRepository phoneChangeRepository, PasswordChangeRepository passwordChangeRepository, SocialAccountRepository socialAccountRepository, ServerTimeRepository serverTimeRepository, Lazy<Config> lazy, YooProfiler yooProfiler, ClientAppParams clientAppParams, Context context) {
        return (PassportProfileInteractor) Preconditions.checkNotNullFromProvides(passportProfileModule.passportProfileInteractor(accountRepository, emailChangeRepository, phoneChangeRepository, passwordChangeRepository, socialAccountRepository, serverTimeRepository, lazy, yooProfiler, clientAppParams, context));
    }

    @Override // javax.inject.Provider
    public PassportProfileInteractor get() {
        return passportProfileInteractor(this.module, this.accountRepositoryProvider.get(), this.emailChangeRepositoryProvider.get(), this.phoneChangeRepositoryProvider.get(), this.passwordChangeRepositoryProvider.get(), this.socialAccountRepositoryProvider.get(), this.serverTimeRepositoryProvider.get(), this.lazyConfigProvider.get(), this.profilerProvider.get(), this.clientAppParamsProvider.get(), this.contextProvider.get());
    }
}
