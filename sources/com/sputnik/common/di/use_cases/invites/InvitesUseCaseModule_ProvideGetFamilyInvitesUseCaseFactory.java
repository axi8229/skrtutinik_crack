package com.sputnik.common.di.use_cases.invites;

import com.sputnik.domain.repositories.invites.IInvitesRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class InvitesUseCaseModule_ProvideGetFamilyInvitesUseCaseFactory implements Factory<GetFamilyInvitesUseCase> {
    private final InvitesUseCaseModule module;
    private final Provider<IInvitesRepository> repositoryProvider;

    public InvitesUseCaseModule_ProvideGetFamilyInvitesUseCaseFactory(InvitesUseCaseModule invitesUseCaseModule, Provider<IInvitesRepository> provider) {
        this.module = invitesUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetFamilyInvitesUseCase get() {
        return provideGetFamilyInvitesUseCase(this.module, this.repositoryProvider.get());
    }

    public static InvitesUseCaseModule_ProvideGetFamilyInvitesUseCaseFactory create(InvitesUseCaseModule invitesUseCaseModule, Provider<IInvitesRepository> provider) {
        return new InvitesUseCaseModule_ProvideGetFamilyInvitesUseCaseFactory(invitesUseCaseModule, provider);
    }

    public static GetFamilyInvitesUseCase provideGetFamilyInvitesUseCase(InvitesUseCaseModule invitesUseCaseModule, IInvitesRepository iInvitesRepository) {
        return (GetFamilyInvitesUseCase) Preconditions.checkNotNullFromProvides(invitesUseCaseModule.provideGetFamilyInvitesUseCase(iInvitesRepository));
    }
}
