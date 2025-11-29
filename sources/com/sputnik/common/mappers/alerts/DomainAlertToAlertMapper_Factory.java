package com.sputnik.common.mappers.alerts;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DomainAlertToAlertMapper_Factory implements Factory<DomainAlertToAlertMapper> {

    private static final class InstanceHolder {
        private static final DomainAlertToAlertMapper_Factory INSTANCE = new DomainAlertToAlertMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DomainAlertToAlertMapper get() {
        return newInstance();
    }

    public static DomainAlertToAlertMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DomainAlertToAlertMapper newInstance() {
        return new DomainAlertToAlertMapper();
    }
}
