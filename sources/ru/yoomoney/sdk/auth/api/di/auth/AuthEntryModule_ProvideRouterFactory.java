package ru.yoomoney.sdk.auth.api.di.auth;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.router.Router;

/* loaded from: classes4.dex */
public final class AuthEntryModule_ProvideRouterFactory implements Factory<Router> {
    private final Provider<Lazy<Config>> configProvider;
    private final AuthEntryModule module;

    public AuthEntryModule_ProvideRouterFactory(AuthEntryModule authEntryModule, Provider<Lazy<Config>> provider) {
        this.module = authEntryModule;
        this.configProvider = provider;
    }

    public static AuthEntryModule_ProvideRouterFactory create(AuthEntryModule authEntryModule, Provider<Lazy<Config>> provider) {
        return new AuthEntryModule_ProvideRouterFactory(authEntryModule, provider);
    }

    public static Router provideRouter(AuthEntryModule authEntryModule, Lazy<Config> lazy) {
        return (Router) Preconditions.checkNotNullFromProvides(authEntryModule.provideRouter(lazy));
    }

    @Override // javax.inject.Provider
    public Router get() {
        return provideRouter(this.module, this.configProvider.get());
    }
}
