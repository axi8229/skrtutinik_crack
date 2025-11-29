package com.sputnik.common.di.use_cases.invites;

import com.sputnik.domain.repositories.invites.IInvitesRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class InvitesUseCaseModule_ProvideAcceptInviteUseCaseFactory implements Factory<AcceptInviteUseCase> {
    private final InvitesUseCaseModule module;
    private final Provider<IInvitesRepository> repositoryProvider;

    public InvitesUseCaseModule_ProvideAcceptInviteUseCaseFactory(InvitesUseCaseModule invitesUseCaseModule, Provider<IInvitesRepository> provider) {
        this.module = invitesUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public AcceptInviteUseCase get() {
        return provideAcceptInviteUseCase(this.module, this.repositoryProvider.get());
    }

    public static InvitesUseCaseModule_ProvideAcceptInviteUseCaseFactory create(InvitesUseCaseModule invitesUseCaseModule, Provider<IInvitesRepository> provider) {
        return new InvitesUseCaseModule_ProvideAcceptInviteUseCaseFactory(invitesUseCaseModule, provider);
    }

    public static AcceptInviteUseCase provideAcceptInviteUseCase(InvitesUseCaseModule invitesUseCaseModule, IInvitesRepository iInvitesRepository) {
        return (AcceptInviteUseCase) Preconditions.checkNotNullFromProvides(invitesUseCaseModule.provideAcceptInviteUseCase(iInvitesRepository));
    }
}
