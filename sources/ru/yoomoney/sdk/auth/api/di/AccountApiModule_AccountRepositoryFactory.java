package ru.yoomoney.sdk.auth.api.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.account.AccountApi;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;

/* loaded from: classes4.dex */
public final class AccountApiModule_AccountRepositoryFactory implements Factory<AccountRepository> {
    private final Provider<AccountApi> apiProvider;
    private final AccountApiModule module;

    public AccountApiModule_AccountRepositoryFactory(AccountApiModule accountApiModule, Provider<AccountApi> provider) {
        this.module = accountApiModule;
        this.apiProvider = provider;
    }

    public static AccountRepository accountRepository(AccountApiModule accountApiModule, AccountApi accountApi) {
        return (AccountRepository) Preconditions.checkNotNullFromProvides(accountApiModule.accountRepository(accountApi));
    }

    public static AccountApiModule_AccountRepositoryFactory create(AccountApiModule accountApiModule, Provider<AccountApi> provider) {
        return new AccountApiModule_AccountRepositoryFactory(accountApiModule, provider);
    }

    @Override // javax.inject.Provider
    public AccountRepository get() {
        return accountRepository(this.module, this.apiProvider.get());
    }
}
