package com.sputnik.common.di.use_cases.invites;

import com.sputnik.domain.repositories.invites.IInvitesRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class InvitesUseCaseModule_ProvideDeleteFamilyInviteUseCaseFactory implements Factory<DeleteFamilyInviteUseCase> {
    private final InvitesUseCaseModule module;
    private final Provider<IInvitesRepository> repositoryProvider;

    public InvitesUseCaseModule_ProvideDeleteFamilyInviteUseCaseFactory(InvitesUseCaseModule invitesUseCaseModule, Provider<IInvitesRepository> provider) {
        this.module = invitesUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public DeleteFamilyInviteUseCase get() {
        return provideDeleteFamilyInviteUseCase(this.module, this.repositoryProvider.get());
    }

    public static InvitesUseCaseModule_ProvideDeleteFamilyInviteUseCaseFactory create(InvitesUseCaseModule invitesUseCaseModule, Provider<IInvitesRepository> provider) {
        return new InvitesUseCaseModule_ProvideDeleteFamilyInviteUseCaseFactory(invitesUseCaseModule, provider);
    }

    public static DeleteFamilyInviteUseCase provideDeleteFamilyInviteUseCase(InvitesUseCaseModule invitesUseCaseModule, IInvitesRepository iInvitesRepository) {
        return (DeleteFamilyInviteUseCase) Preconditions.checkNotNullFromProvides(invitesUseCaseModule.provideDeleteFamilyInviteUseCase(iInvitesRepository));
    }
}
