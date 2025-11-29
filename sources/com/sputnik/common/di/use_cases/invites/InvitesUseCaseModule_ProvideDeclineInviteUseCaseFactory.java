package com.sputnik.common.di.use_cases.invites;

import com.sputnik.domain.repositories.invites.IInvitesRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class InvitesUseCaseModule_ProvideDeclineInviteUseCaseFactory implements Factory<DeclineInviteUseCase> {
    private final InvitesUseCaseModule module;
    private final Provider<IInvitesRepository> repositoryProvider;

    public InvitesUseCaseModule_ProvideDeclineInviteUseCaseFactory(InvitesUseCaseModule invitesUseCaseModule, Provider<IInvitesRepository> provider) {
        this.module = invitesUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public DeclineInviteUseCase get() {
        return provideDeclineInviteUseCase(this.module, this.repositoryProvider.get());
    }

    public static InvitesUseCaseModule_ProvideDeclineInviteUseCaseFactory create(InvitesUseCaseModule invitesUseCaseModule, Provider<IInvitesRepository> provider) {
        return new InvitesUseCaseModule_ProvideDeclineInviteUseCaseFactory(invitesUseCaseModule, provider);
    }

    public static DeclineInviteUseCase provideDeclineInviteUseCase(InvitesUseCaseModule invitesUseCaseModule, IInvitesRepository iInvitesRepository) {
        return (DeclineInviteUseCase) Preconditions.checkNotNullFromProvides(invitesUseCaseModule.provideDeclineInviteUseCase(iInvitesRepository));
    }
}
