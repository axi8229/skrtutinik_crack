package ru.yoomoney.sdk.auth.api.di.account;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.di.ActivityFragmentFactory;

/* loaded from: classes4.dex */
public final class AccountEntryModule_ProvidesAuthEntryActivityFragmentFactoryFactory implements Factory<ActivityFragmentFactory> {
    private final Provider<Map<Class<?>, Provider<Fragment>>> fragmentsProvider;
    private final AccountEntryModule module;

    public AccountEntryModule_ProvidesAuthEntryActivityFragmentFactoryFactory(AccountEntryModule accountEntryModule, Provider<Map<Class<?>, Provider<Fragment>>> provider) {
        this.module = accountEntryModule;
        this.fragmentsProvider = provider;
    }

    public static AccountEntryModule_ProvidesAuthEntryActivityFragmentFactoryFactory create(AccountEntryModule accountEntryModule, Provider<Map<Class<?>, Provider<Fragment>>> provider) {
        return new AccountEntryModule_ProvidesAuthEntryActivityFragmentFactoryFactory(accountEntryModule, provider);
    }

    public static ActivityFragmentFactory providesAuthEntryActivityFragmentFactory(AccountEntryModule accountEntryModule, Map<Class<?>, Provider<Fragment>> map) {
        return (ActivityFragmentFactory) Preconditions.checkNotNullFromProvides(accountEntryModule.providesAuthEntryActivityFragmentFactory(map));
    }

    @Override // javax.inject.Provider
    public ActivityFragmentFactory get() {
        return providesAuthEntryActivityFragmentFactory(this.module, this.fragmentsProvider.get());
    }
}
