package com.sputnik.data.mappers.keys;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataPhysicalKeyToDomainPhysicalKeyMapper_Factory implements Factory<DataPhysicalKeyToDomainPhysicalKeyMapper> {

    private static final class InstanceHolder {
        private static final DataPhysicalKeyToDomainPhysicalKeyMapper_Factory INSTANCE = new DataPhysicalKeyToDomainPhysicalKeyMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataPhysicalKeyToDomainPhysicalKeyMapper get() {
        return newInstance();
    }

    public static DataPhysicalKeyToDomainPhysicalKeyMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataPhysicalKeyToDomainPhysicalKeyMapper newInstance() {
        return new DataPhysicalKeyToDomainPhysicalKeyMapper();
    }
}
