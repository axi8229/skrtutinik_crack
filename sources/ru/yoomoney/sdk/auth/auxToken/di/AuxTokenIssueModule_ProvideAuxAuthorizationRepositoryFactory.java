package ru.yoomoney.sdk.auth.auxToken.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationApi;
import ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationRepository;

/* loaded from: classes4.dex */
public final class AuxTokenIssueModule_ProvideAuxAuthorizationRepositoryFactory implements Factory<AuxAuthorizationRepository> {
    private final Provider<AuxAuthorizationApi> apiProvider;
    private final AuxTokenIssueModule module;

    public AuxTokenIssueModule_ProvideAuxAuthorizationRepositoryFactory(AuxTokenIssueModule auxTokenIssueModule, Provider<AuxAuthorizationApi> provider) {
        this.module = auxTokenIssueModule;
        this.apiProvider = provider;
    }

    public static AuxTokenIssueModule_ProvideAuxAuthorizationRepositoryFactory create(AuxTokenIssueModule auxTokenIssueModule, Provider<AuxAuthorizationApi> provider) {
        return new AuxTokenIssueModule_ProvideAuxAuthorizationRepositoryFactory(auxTokenIssueModule, provider);
    }

    public static AuxAuthorizationRepository provideAuxAuthorizationRepository(AuxTokenIssueModule auxTokenIssueModule, AuxAuthorizationApi auxAuthorizationApi) {
        return (AuxAuthorizationRepository) Preconditions.checkNotNullFromProvides(auxTokenIssueModule.provideAuxAuthorizationRepository(auxAuthorizationApi));
    }

    @Override // javax.inject.Provider
    public AuxAuthorizationRepository get() {
        return provideAuxAuthorizationRepository(this.module, this.apiProvider.get());
    }
}
