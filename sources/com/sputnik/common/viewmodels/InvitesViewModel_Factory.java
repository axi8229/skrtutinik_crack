package com.sputnik.common.viewmodels;

import com.sputnik.common.di.use_cases.invites.AcceptInviteUseCase;
import com.sputnik.common.di.use_cases.invites.DeclineInviteUseCase;
import com.sputnik.common.di.use_cases.invites.DeleteFamilyInviteUseCase;
import com.sputnik.common.di.use_cases.invites.GetFamilyInvitesUseCase;
import com.sputnik.common.di.use_cases.invites.GetInvitesUseCase;
import com.sputnik.common.di.use_cases.invites.ResendFamilyInviteUseCase;
import com.sputnik.common.di.use_cases.invites.SendFamilyInviteUseCase;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.mappers.invites.DomainFamilyInvitesToFamilyInvitesMapper;
import com.sputnik.common.mappers.invites.DomainInviteToInviteMapper;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.usecases.country_code.GetCountryCodeUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class InvitesViewModel_Factory implements Factory<InvitesViewModel> {
    private final Provider<AcceptInviteUseCase> acceptInviteUseCaseProvider;
    private final Provider<IConfig> configProvider;
    private final Provider<DeclineInviteUseCase> declineInviteUseCaseProvider;
    private final Provider<DeleteFamilyInviteUseCase> deleteFamilyInviteUseCaseProvider;
    private final Provider<DomainFamilyInvitesToFamilyInvitesMapper> domainFamilyInvitesToFamilyInvitesMapperProvider;
    private final Provider<DomainInviteToInviteMapper> domainInviteToInviteMapperProvider;
    private final Provider<GetCountryCodeUseCase> getCountryCodeUseCaseProvider;
    private final Provider<GetFamilyInvitesUseCase> getFamilyInvitesUseCaseProvider;
    private final Provider<GetInvitesUseCase> getInvitesUseCaseProvider;
    private final Provider<LocalizationStorage> localizationStorageProvider;
    private final Provider<PrefManager> prefManagerProvider;
    private final Provider<ResendFamilyInviteUseCase> resendFamilyInviteUseCaseProvider;
    private final Provider<SendFamilyInviteUseCase> sendFamilyInviteUseCaseProvider;

    public InvitesViewModel_Factory(Provider<GetInvitesUseCase> provider, Provider<GetFamilyInvitesUseCase> provider2, Provider<SendFamilyInviteUseCase> provider3, Provider<ResendFamilyInviteUseCase> provider4, Provider<DeleteFamilyInviteUseCase> provider5, Provider<AcceptInviteUseCase> provider6, Provider<DeclineInviteUseCase> provider7, Provider<IConfig> provider8, Provider<PrefManager> provider9, Provider<DomainInviteToInviteMapper> provider10, Provider<DomainFamilyInvitesToFamilyInvitesMapper> provider11, Provider<GetCountryCodeUseCase> provider12, Provider<LocalizationStorage> provider13) {
        this.getInvitesUseCaseProvider = provider;
        this.getFamilyInvitesUseCaseProvider = provider2;
        this.sendFamilyInviteUseCaseProvider = provider3;
        this.resendFamilyInviteUseCaseProvider = provider4;
        this.deleteFamilyInviteUseCaseProvider = provider5;
        this.acceptInviteUseCaseProvider = provider6;
        this.declineInviteUseCaseProvider = provider7;
        this.configProvider = provider8;
        this.prefManagerProvider = provider9;
        this.domainInviteToInviteMapperProvider = provider10;
        this.domainFamilyInvitesToFamilyInvitesMapperProvider = provider11;
        this.getCountryCodeUseCaseProvider = provider12;
        this.localizationStorageProvider = provider13;
    }

    @Override // javax.inject.Provider
    public InvitesViewModel get() {
        return newInstance(this.getInvitesUseCaseProvider.get(), this.getFamilyInvitesUseCaseProvider.get(), this.sendFamilyInviteUseCaseProvider.get(), this.resendFamilyInviteUseCaseProvider.get(), this.deleteFamilyInviteUseCaseProvider.get(), this.acceptInviteUseCaseProvider.get(), this.declineInviteUseCaseProvider.get(), this.configProvider.get(), this.prefManagerProvider.get(), this.domainInviteToInviteMapperProvider.get(), this.domainFamilyInvitesToFamilyInvitesMapperProvider.get(), this.getCountryCodeUseCaseProvider.get(), this.localizationStorageProvider.get());
    }

    public static InvitesViewModel_Factory create(Provider<GetInvitesUseCase> provider, Provider<GetFamilyInvitesUseCase> provider2, Provider<SendFamilyInviteUseCase> provider3, Provider<ResendFamilyInviteUseCase> provider4, Provider<DeleteFamilyInviteUseCase> provider5, Provider<AcceptInviteUseCase> provider6, Provider<DeclineInviteUseCase> provider7, Provider<IConfig> provider8, Provider<PrefManager> provider9, Provider<DomainInviteToInviteMapper> provider10, Provider<DomainFamilyInvitesToFamilyInvitesMapper> provider11, Provider<GetCountryCodeUseCase> provider12, Provider<LocalizationStorage> provider13) {
        return new InvitesViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static InvitesViewModel newInstance(GetInvitesUseCase getInvitesUseCase, GetFamilyInvitesUseCase getFamilyInvitesUseCase, SendFamilyInviteUseCase sendFamilyInviteUseCase, ResendFamilyInviteUseCase resendFamilyInviteUseCase, DeleteFamilyInviteUseCase deleteFamilyInviteUseCase, AcceptInviteUseCase acceptInviteUseCase, DeclineInviteUseCase declineInviteUseCase, IConfig iConfig, PrefManager prefManager, DomainInviteToInviteMapper domainInviteToInviteMapper, DomainFamilyInvitesToFamilyInvitesMapper domainFamilyInvitesToFamilyInvitesMapper, GetCountryCodeUseCase getCountryCodeUseCase, LocalizationStorage localizationStorage) {
        return new InvitesViewModel(getInvitesUseCase, getFamilyInvitesUseCase, sendFamilyInviteUseCase, resendFamilyInviteUseCase, deleteFamilyInviteUseCase, acceptInviteUseCase, declineInviteUseCase, iConfig, prefManager, domainInviteToInviteMapper, domainFamilyInvitesToFamilyInvitesMapper, getCountryCodeUseCase, localizationStorage);
    }
}
