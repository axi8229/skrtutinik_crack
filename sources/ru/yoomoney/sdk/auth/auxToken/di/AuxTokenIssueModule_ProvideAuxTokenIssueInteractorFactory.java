package ru.yoomoney.sdk.auth.auxToken.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;
import ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationRepository;
import ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractor;

/* loaded from: classes4.dex */
public final class AuxTokenIssueModule_ProvideAuxTokenIssueInteractorFactory implements Factory<AuxTokenIssueInteractor> {
    private final Provider<AccountRepository> accountRepositoryProvider;
    private final Provider<AuxAuthorizationRepository> auxAuthorizationRepositoryProvider;
    private final AuxTokenIssueModule module;

    public AuxTokenIssueModule_ProvideAuxTokenIssueInteractorFactory(AuxTokenIssueModule auxTokenIssueModule, Provider<AuxAuthorizationRepository> provider, Provider<AccountRepository> provider2) {
        this.module = auxTokenIssueModule;
        this.auxAuthorizationRepositoryProvider = provider;
        this.accountRepositoryProvider = provider2;
    }

    public static AuxTokenIssueModule_ProvideAuxTokenIssueInteractorFactory create(AuxTokenIssueModule auxTokenIssueModule, Provider<AuxAuthorizationRepository> provider, Provider<AccountRepository> provider2) {
        return new AuxTokenIssueModule_ProvideAuxTokenIssueInteractorFactory(auxTokenIssueModule, provider, provider2);
    }

    public static AuxTokenIssueInteractor provideAuxTokenIssueInteractor(AuxTokenIssueModule auxTokenIssueModule, AuxAuthorizationRepository auxAuthorizationRepository, AccountRepository accountRepository) {
        return (AuxTokenIssueInteractor) Preconditions.checkNotNullFromProvides(auxTokenIssueModule.provideAuxTokenIssueInteractor(auxAuthorizationRepository, accountRepository));
    }

    @Override // javax.inject.Provider
    public AuxTokenIssueInteractor get() {
        return provideAuxTokenIssueInteractor(this.module, this.auxAuthorizationRepositoryProvider.get(), this.accountRepositoryProvider.get());
    }
}
