package com.sputnik.common.di.use_cases.invites;

import com.sputnik.domain.repositories.invites.IInvitesRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class InvitesUseCaseModule_ProvideSendFamilyInviteUseCaseFactory implements Factory<SendFamilyInviteUseCase> {
    private final InvitesUseCaseModule module;
    private final Provider<IInvitesRepository> repositoryProvider;

    public InvitesUseCaseModule_ProvideSendFamilyInviteUseCaseFactory(InvitesUseCaseModule invitesUseCaseModule, Provider<IInvitesRepository> provider) {
        this.module = invitesUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public SendFamilyInviteUseCase get() {
        return provideSendFamilyInviteUseCase(this.module, this.repositoryProvider.get());
    }

    public static InvitesUseCaseModule_ProvideSendFamilyInviteUseCaseFactory create(InvitesUseCaseModule invitesUseCaseModule, Provider<IInvitesRepository> provider) {
        return new InvitesUseCaseModule_ProvideSendFamilyInviteUseCaseFactory(invitesUseCaseModule, provider);
    }

    public static SendFamilyInviteUseCase provideSendFamilyInviteUseCase(InvitesUseCaseModule invitesUseCaseModule, IInvitesRepository iInvitesRepository) {
        return (SendFamilyInviteUseCase) Preconditions.checkNotNullFromProvides(invitesUseCaseModule.provideSendFamilyInviteUseCase(iInvitesRepository));
    }
}
