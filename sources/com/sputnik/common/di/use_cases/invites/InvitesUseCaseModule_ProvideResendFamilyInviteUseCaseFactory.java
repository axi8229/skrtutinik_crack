package com.sputnik.common.di.use_cases.invites;

import com.sputnik.domain.repositories.invites.IInvitesRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class InvitesUseCaseModule_ProvideResendFamilyInviteUseCaseFactory implements Factory<ResendFamilyInviteUseCase> {
    private final InvitesUseCaseModule module;
    private final Provider<IInvitesRepository> repositoryProvider;

    public InvitesUseCaseModule_ProvideResendFamilyInviteUseCaseFactory(InvitesUseCaseModule invitesUseCaseModule, Provider<IInvitesRepository> provider) {
        this.module = invitesUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public ResendFamilyInviteUseCase get() {
        return provideResendFamilyInviteUseCase(this.module, this.repositoryProvider.get());
    }

    public static InvitesUseCaseModule_ProvideResendFamilyInviteUseCaseFactory create(InvitesUseCaseModule invitesUseCaseModule, Provider<IInvitesRepository> provider) {
        return new InvitesUseCaseModule_ProvideResendFamilyInviteUseCaseFactory(invitesUseCaseModule, provider);
    }

    public static ResendFamilyInviteUseCase provideResendFamilyInviteUseCase(InvitesUseCaseModule invitesUseCaseModule, IInvitesRepository iInvitesRepository) {
        return (ResendFamilyInviteUseCase) Preconditions.checkNotNullFromProvides(invitesUseCaseModule.provideResendFamilyInviteUseCase(iInvitesRepository));
    }
}
