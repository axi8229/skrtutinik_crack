package ru.yoomoney.sdk.auth.api.di.account;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ru.yoomoney.sdk.auth.router.Router;

/* loaded from: classes4.dex */
public final class AccountEntryModule_ProvideRouterFactory implements Factory<Router> {
    private final AccountEntryModule module;

    public AccountEntryModule_ProvideRouterFactory(AccountEntryModule accountEntryModule) {
        this.module = accountEntryModule;
    }

    public static AccountEntryModule_ProvideRouterFactory create(AccountEntryModule accountEntryModule) {
        return new AccountEntryModule_ProvideRouterFactory(accountEntryModule);
    }

    public static Router provideRouter(AccountEntryModule accountEntryModule) {
        return (Router) Preconditions.checkNotNullFromProvides(accountEntryModule.provideRouter());
    }

    @Override // javax.inject.Provider
    public Router get() {
        return provideRouter(this.module);
    }
}
