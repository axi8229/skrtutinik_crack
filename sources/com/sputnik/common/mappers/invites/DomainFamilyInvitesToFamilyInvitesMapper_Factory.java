package com.sputnik.common.mappers.invites;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DomainFamilyInvitesToFamilyInvitesMapper_Factory implements Factory<DomainFamilyInvitesToFamilyInvitesMapper> {

    private static final class InstanceHolder {
        private static final DomainFamilyInvitesToFamilyInvitesMapper_Factory INSTANCE = new DomainFamilyInvitesToFamilyInvitesMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DomainFamilyInvitesToFamilyInvitesMapper get() {
        return newInstance();
    }

    public static DomainFamilyInvitesToFamilyInvitesMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DomainFamilyInvitesToFamilyInvitesMapper newInstance() {
        return new DomainFamilyInvitesToFamilyInvitesMapper();
    }
}
