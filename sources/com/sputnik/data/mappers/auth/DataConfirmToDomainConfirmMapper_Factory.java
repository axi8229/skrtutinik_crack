package com.sputnik.data.mappers.auth;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataConfirmToDomainConfirmMapper_Factory implements Factory<DataConfirmToDomainConfirmMapper> {

    private static final class InstanceHolder {
        private static final DataConfirmToDomainConfirmMapper_Factory INSTANCE = new DataConfirmToDomainConfirmMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataConfirmToDomainConfirmMapper get() {
        return newInstance();
    }

    public static DataConfirmToDomainConfirmMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataConfirmToDomainConfirmMapper newInstance() {
        return new DataConfirmToDomainConfirmMapper();
    }
}
