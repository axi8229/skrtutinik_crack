package ru.yoomoney.sdk.auth.api.di.account;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ru.yoomoney.sdk.auth.router.ProcessMapper;

/* loaded from: classes4.dex */
public final class AccountEntryModule_ProvideProcessMapperFactory implements Factory<ProcessMapper> {
    private final AccountEntryModule module;

    public AccountEntryModule_ProvideProcessMapperFactory(AccountEntryModule accountEntryModule) {
        this.module = accountEntryModule;
    }

    public static AccountEntryModule_ProvideProcessMapperFactory create(AccountEntryModule accountEntryModule) {
        return new AccountEntryModule_ProvideProcessMapperFactory(accountEntryModule);
    }

    public static ProcessMapper provideProcessMapper(AccountEntryModule accountEntryModule) {
        return (ProcessMapper) Preconditions.checkNotNullFromProvides(accountEntryModule.provideProcessMapper());
    }

    @Override // javax.inject.Provider
    public ProcessMapper get() {
        return provideProcessMapper(this.module);
    }
}
