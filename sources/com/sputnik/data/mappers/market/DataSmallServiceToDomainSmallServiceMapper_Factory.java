package com.sputnik.data.mappers.market;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataSmallServiceToDomainSmallServiceMapper_Factory implements Factory<DataSmallServiceToDomainSmallServiceMapper> {

    private static final class InstanceHolder {
        private static final DataSmallServiceToDomainSmallServiceMapper_Factory INSTANCE = new DataSmallServiceToDomainSmallServiceMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataSmallServiceToDomainSmallServiceMapper get() {
        return newInstance();
    }

    public static DataSmallServiceToDomainSmallServiceMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataSmallServiceToDomainSmallServiceMapper newInstance() {
        return new DataSmallServiceToDomainSmallServiceMapper();
    }
}
