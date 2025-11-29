package com.sputnik.common.di.use_cases.invites;

import com.sputnik.domain.repositories.invites.IInvitesRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class InvitesUseCaseModule_ProvideGetInvitesUseCaseFactory implements Factory<GetInvitesUseCase> {
    private final InvitesUseCaseModule module;
    private final Provider<IInvitesRepository> repositoryProvider;

    public InvitesUseCaseModule_ProvideGetInvitesUseCaseFactory(InvitesUseCaseModule invitesUseCaseModule, Provider<IInvitesRepository> provider) {
        this.module = invitesUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetInvitesUseCase get() {
        return provideGetInvitesUseCase(this.module, this.repositoryProvider.get());
    }

    public static InvitesUseCaseModule_ProvideGetInvitesUseCaseFactory create(InvitesUseCaseModule invitesUseCaseModule, Provider<IInvitesRepository> provider) {
        return new InvitesUseCaseModule_ProvideGetInvitesUseCaseFactory(invitesUseCaseModule, provider);
    }

    public static GetInvitesUseCase provideGetInvitesUseCase(InvitesUseCaseModule invitesUseCaseModule, IInvitesRepository iInvitesRepository) {
        return (GetInvitesUseCase) Preconditions.checkNotNullFromProvides(invitesUseCaseModule.provideGetInvitesUseCase(iInvitesRepository));
    }
}
