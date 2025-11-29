package com.sputnik.data.mappers.entry;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataEntryToDomainEntryMapper_Factory implements Factory<DataEntryToDomainEntryMapper> {

    private static final class InstanceHolder {
        private static final DataEntryToDomainEntryMapper_Factory INSTANCE = new DataEntryToDomainEntryMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataEntryToDomainEntryMapper get() {
        return newInstance();
    }

    public static DataEntryToDomainEntryMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataEntryToDomainEntryMapper newInstance() {
        return new DataEntryToDomainEntryMapper();
    }
}
