package com.sputnik.data.mappers.invites;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataFamilyInvitesToDomainFamilyInvitesMapper_Factory implements Factory<DataFamilyInvitesToDomainFamilyInvitesMapper> {

    private static final class InstanceHolder {
        private static final DataFamilyInvitesToDomainFamilyInvitesMapper_Factory INSTANCE = new DataFamilyInvitesToDomainFamilyInvitesMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataFamilyInvitesToDomainFamilyInvitesMapper get() {
        return newInstance();
    }

    public static DataFamilyInvitesToDomainFamilyInvitesMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataFamilyInvitesToDomainFamilyInvitesMapper newInstance() {
        return new DataFamilyInvitesToDomainFamilyInvitesMapper();
    }
}
