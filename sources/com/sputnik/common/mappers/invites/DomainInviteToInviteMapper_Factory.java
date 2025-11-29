package com.sputnik.common.mappers.invites;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DomainInviteToInviteMapper_Factory implements Factory<DomainInviteToInviteMapper> {

    private static final class InstanceHolder {
        private static final DomainInviteToInviteMapper_Factory INSTANCE = new DomainInviteToInviteMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DomainInviteToInviteMapper get() {
        return newInstance();
    }

    public static DomainInviteToInviteMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DomainInviteToInviteMapper newInstance() {
        return new DomainInviteToInviteMapper();
    }
}
