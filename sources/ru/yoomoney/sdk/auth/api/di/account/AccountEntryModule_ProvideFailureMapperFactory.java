package ru.yoomoney.sdk.auth.api.di.account;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class AccountEntryModule_ProvideFailureMapperFactory implements Factory<ResourceMapper> {
    private final Provider<Context> contextProvider;
    private final AccountEntryModule module;

    public AccountEntryModule_ProvideFailureMapperFactory(AccountEntryModule accountEntryModule, Provider<Context> provider) {
        this.module = accountEntryModule;
        this.contextProvider = provider;
    }

    public static AccountEntryModule_ProvideFailureMapperFactory create(AccountEntryModule accountEntryModule, Provider<Context> provider) {
        return new AccountEntryModule_ProvideFailureMapperFactory(accountEntryModule, provider);
    }

    public static ResourceMapper provideFailureMapper(AccountEntryModule accountEntryModule, Context context) {
        return (ResourceMapper) Preconditions.checkNotNullFromProvides(accountEntryModule.provideFailureMapper(context));
    }

    @Override // javax.inject.Provider
    public ResourceMapper get() {
        return provideFailureMapper(this.module, this.contextProvider.get());
    }
}
