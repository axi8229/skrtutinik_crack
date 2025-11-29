package ru.yoomoney.sdk.auth.api.di.auth;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ru.yoomoney.sdk.auth.router.ProcessMapper;

/* loaded from: classes4.dex */
public final class AuthEntryModule_ProvideProcessMapperFactory implements Factory<ProcessMapper> {
    private final AuthEntryModule module;

    public AuthEntryModule_ProvideProcessMapperFactory(AuthEntryModule authEntryModule) {
        this.module = authEntryModule;
    }

    public static AuthEntryModule_ProvideProcessMapperFactory create(AuthEntryModule authEntryModule) {
        return new AuthEntryModule_ProvideProcessMapperFactory(authEntryModule);
    }

    public static ProcessMapper provideProcessMapper(AuthEntryModule authEntryModule) {
        return (ProcessMapper) Preconditions.checkNotNullFromProvides(authEntryModule.provideProcessMapper());
    }

    @Override // javax.inject.Provider
    public ProcessMapper get() {
        return provideProcessMapper(this.module);
    }
}
