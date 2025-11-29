package com.sputnik.data.mappers.alerts;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataAlertToDomainAlertMapper_Factory implements Factory<DataAlertToDomainAlertMapper> {

    private static final class InstanceHolder {
        private static final DataAlertToDomainAlertMapper_Factory INSTANCE = new DataAlertToDomainAlertMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataAlertToDomainAlertMapper get() {
        return newInstance();
    }

    public static DataAlertToDomainAlertMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataAlertToDomainAlertMapper newInstance() {
        return new DataAlertToDomainAlertMapper();
    }
}
