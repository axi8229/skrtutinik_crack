package ru.yoomoney.sdk.auth.auxToken.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class AuxTokenIssueModule_ProvideFailureMapperFactory implements Factory<ResourceMapper> {
    private final Provider<Context> contextProvider;
    private final AuxTokenIssueModule module;

    public AuxTokenIssueModule_ProvideFailureMapperFactory(AuxTokenIssueModule auxTokenIssueModule, Provider<Context> provider) {
        this.module = auxTokenIssueModule;
        this.contextProvider = provider;
    }

    public static AuxTokenIssueModule_ProvideFailureMapperFactory create(AuxTokenIssueModule auxTokenIssueModule, Provider<Context> provider) {
        return new AuxTokenIssueModule_ProvideFailureMapperFactory(auxTokenIssueModule, provider);
    }

    public static ResourceMapper provideFailureMapper(AuxTokenIssueModule auxTokenIssueModule, Context context) {
        return (ResourceMapper) Preconditions.checkNotNullFromProvides(auxTokenIssueModule.provideFailureMapper(context));
    }

    @Override // javax.inject.Provider
    public ResourceMapper get() {
        return provideFailureMapper(this.module, this.contextProvider.get());
    }
}
