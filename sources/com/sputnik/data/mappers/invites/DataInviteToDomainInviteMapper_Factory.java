package com.sputnik.data.mappers.invites;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataInviteToDomainInviteMapper_Factory implements Factory<DataInviteToDomainInviteMapper> {

    private static final class InstanceHolder {
        private static final DataInviteToDomainInviteMapper_Factory INSTANCE = new DataInviteToDomainInviteMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataInviteToDomainInviteMapper get() {
        return newInstance();
    }

    public static DataInviteToDomainInviteMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataInviteToDomainInviteMapper newInstance() {
        return new DataInviteToDomainInviteMapper();
    }
}
