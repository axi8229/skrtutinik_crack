package ru.yoomoney.sdk.auth.api.di.auth;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.di.ActivityFragmentFactory;

/* loaded from: classes4.dex */
public final class AuthEntryModule_ProvidesAuthEntryActivityFragmentFactoryFactory implements Factory<ActivityFragmentFactory> {
    private final Provider<Map<Class<?>, Provider<Fragment>>> fragmentsProvider;
    private final AuthEntryModule module;

    public AuthEntryModule_ProvidesAuthEntryActivityFragmentFactoryFactory(AuthEntryModule authEntryModule, Provider<Map<Class<?>, Provider<Fragment>>> provider) {
        this.module = authEntryModule;
        this.fragmentsProvider = provider;
    }

    public static AuthEntryModule_ProvidesAuthEntryActivityFragmentFactoryFactory create(AuthEntryModule authEntryModule, Provider<Map<Class<?>, Provider<Fragment>>> provider) {
        return new AuthEntryModule_ProvidesAuthEntryActivityFragmentFactoryFactory(authEntryModule, provider);
    }

    public static ActivityFragmentFactory providesAuthEntryActivityFragmentFactory(AuthEntryModule authEntryModule, Map<Class<?>, Provider<Fragment>> map) {
        return (ActivityFragmentFactory) Preconditions.checkNotNullFromProvides(authEntryModule.providesAuthEntryActivityFragmentFactory(map));
    }

    @Override // javax.inject.Provider
    public ActivityFragmentFactory get() {
        return providesAuthEntryActivityFragmentFactory(this.module, this.fragmentsProvider.get());
    }
}
