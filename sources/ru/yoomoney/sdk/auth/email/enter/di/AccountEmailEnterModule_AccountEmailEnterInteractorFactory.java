package ru.yoomoney.sdk.auth.email.enter.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.email.enter.impl.AccountEmailEnterInteractor;

/* loaded from: classes4.dex */
public final class AccountEmailEnterModule_AccountEmailEnterInteractorFactory implements Factory<AccountEmailEnterInteractor> {
    private final Provider<EmailChangeRepository> emailChangeRepositoryProvider;
    private final AccountEmailEnterModule module;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AccountEmailEnterModule_AccountEmailEnterInteractorFactory(AccountEmailEnterModule accountEmailEnterModule, Provider<EmailChangeRepository> provider, Provider<ServerTimeRepository> provider2) {
        this.module = accountEmailEnterModule;
        this.emailChangeRepositoryProvider = provider;
        this.serverTimeRepositoryProvider = provider2;
    }

    public static AccountEmailEnterInteractor accountEmailEnterInteractor(AccountEmailEnterModule accountEmailEnterModule, EmailChangeRepository emailChangeRepository, ServerTimeRepository serverTimeRepository) {
        return (AccountEmailEnterInteractor) Preconditions.checkNotNullFromProvides(accountEmailEnterModule.accountEmailEnterInteractor(emailChangeRepository, serverTimeRepository));
    }

    public static AccountEmailEnterModule_AccountEmailEnterInteractorFactory create(AccountEmailEnterModule accountEmailEnterModule, Provider<EmailChangeRepository> provider, Provider<ServerTimeRepository> provider2) {
        return new AccountEmailEnterModule_AccountEmailEnterInteractorFactory(accountEmailEnterModule, provider, provider2);
    }

    @Override // javax.inject.Provider
    public AccountEmailEnterInteractor get() {
        return accountEmailEnterInteractor(this.module, this.emailChangeRepositoryProvider.get(), this.serverTimeRepositoryProvider.get());
    }
}
