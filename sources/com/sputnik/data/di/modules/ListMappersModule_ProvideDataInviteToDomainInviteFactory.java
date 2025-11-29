package com.sputnik.data.di.modules;

import com.sputnik.data.entities.invites.DataInvite;
import com.sputnik.data.mappers.invites.DataInviteToDomainInviteMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.invites.DomainInvite;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataInviteToDomainInviteFactory implements Factory<ListMapper<DataInvite, DomainInvite>> {
    private final Provider<DataInviteToDomainInviteMapper> mapperProvider;
    private final ListMappersModule module;

    public ListMappersModule_ProvideDataInviteToDomainInviteFactory(ListMappersModule listMappersModule, Provider<DataInviteToDomainInviteMapper> provider) {
        this.module = listMappersModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public ListMapper<DataInvite, DomainInvite> get() {
        return provideDataInviteToDomainInvite(this.module, this.mapperProvider.get());
    }

    public static ListMappersModule_ProvideDataInviteToDomainInviteFactory create(ListMappersModule listMappersModule, Provider<DataInviteToDomainInviteMapper> provider) {
        return new ListMappersModule_ProvideDataInviteToDomainInviteFactory(listMappersModule, provider);
    }

    public static ListMapper<DataInvite, DomainInvite> provideDataInviteToDomainInvite(ListMappersModule listMappersModule, DataInviteToDomainInviteMapper dataInviteToDomainInviteMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataInviteToDomainInvite(dataInviteToDomainInviteMapper));
    }
}
