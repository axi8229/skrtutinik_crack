package com.sputnik.oboarding.mappers.connect_intercom;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DomainActivationCodeToActivationCodeMapper_Factory implements Factory<DomainActivationCodeToActivationCodeMapper> {

    private static final class InstanceHolder {
        private static final DomainActivationCodeToActivationCodeMapper_Factory INSTANCE = new DomainActivationCodeToActivationCodeMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DomainActivationCodeToActivationCodeMapper get() {
        return newInstance();
    }

    public static DomainActivationCodeToActivationCodeMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DomainActivationCodeToActivationCodeMapper newInstance() {
        return new DomainActivationCodeToActivationCodeMapper();
    }
}
