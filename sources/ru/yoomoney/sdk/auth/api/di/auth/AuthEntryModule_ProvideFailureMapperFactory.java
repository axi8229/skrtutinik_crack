package ru.yoomoney.sdk.auth.api.di.auth;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class AuthEntryModule_ProvideFailureMapperFactory implements Factory<ResourceMapper> {
    private final Provider<Context> contextProvider;
    private final AuthEntryModule module;

    public AuthEntryModule_ProvideFailureMapperFactory(AuthEntryModule authEntryModule, Provider<Context> provider) {
        this.module = authEntryModule;
        this.contextProvider = provider;
    }

    public static AuthEntryModule_ProvideFailureMapperFactory create(AuthEntryModule authEntryModule, Provider<Context> provider) {
        return new AuthEntryModule_ProvideFailureMapperFactory(authEntryModule, provider);
    }

    public static ResourceMapper provideFailureMapper(AuthEntryModule authEntryModule, Context context) {
        return (ResourceMapper) Preconditions.checkNotNullFromProvides(authEntryModule.provideFailureMapper(context));
    }

    @Override // javax.inject.Provider
    public ResourceMapper get() {
        return provideFailureMapper(this.module, this.contextProvider.get());
    }
}
