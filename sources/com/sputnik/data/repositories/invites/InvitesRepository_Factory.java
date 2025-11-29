package com.sputnik.data.repositories.invites;

import com.sputnik.data.api.InvitesApi;
import com.sputnik.data.entities.invites.DataInvite;
import com.sputnik.data.mappers.invites.DataFamilyInvitesToDomainFamilyInvitesMapper;
import com.sputnik.data.mappers.invites.DataInviteToDomainInviteMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.invites.DomainInvite;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class InvitesRepository_Factory implements Factory<InvitesRepository> {
    private final Provider<InvitesApi> apiProvider;
    private final Provider<DataFamilyInvitesToDomainFamilyInvitesMapper> familyInvitesMapperProvider;
    private final Provider<ListMapper<DataInvite, DomainInvite>> listMapperProvider;
    private final Provider<DataInviteToDomainInviteMapper> mapperProvider;

    public InvitesRepository_Factory(Provider<InvitesApi> provider, Provider<ListMapper<DataInvite, DomainInvite>> provider2, Provider<DataInviteToDomainInviteMapper> provider3, Provider<DataFamilyInvitesToDomainFamilyInvitesMapper> provider4) {
        this.apiProvider = provider;
        this.listMapperProvider = provider2;
        this.mapperProvider = provider3;
        this.familyInvitesMapperProvider = provider4;
    }

    @Override // javax.inject.Provider
    public InvitesRepository get() {
        return newInstance(this.apiProvider.get(), this.listMapperProvider.get(), this.mapperProvider.get(), this.familyInvitesMapperProvider.get());
    }

    public static InvitesRepository_Factory create(Provider<InvitesApi> provider, Provider<ListMapper<DataInvite, DomainInvite>> provider2, Provider<DataInviteToDomainInviteMapper> provider3, Provider<DataFamilyInvitesToDomainFamilyInvitesMapper> provider4) {
        return new InvitesRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static InvitesRepository newInstance(InvitesApi invitesApi, ListMapper<DataInvite, DomainInvite> listMapper, DataInviteToDomainInviteMapper dataInviteToDomainInviteMapper, DataFamilyInvitesToDomainFamilyInvitesMapper dataFamilyInvitesToDomainFamilyInvitesMapper) {
        return new InvitesRepository(invitesApi, listMapper, dataInviteToDomainInviteMapper, dataFamilyInvitesToDomainFamilyInvitesMapper);
    }
}
