package com.sputnik.data.mappers.market;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataSubsPlansToDomainSubsPlansMapper_Factory implements Factory<DataSubsPlansToDomainSubsPlansMapper> {

    private static final class InstanceHolder {
        private static final DataSubsPlansToDomainSubsPlansMapper_Factory INSTANCE = new DataSubsPlansToDomainSubsPlansMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataSubsPlansToDomainSubsPlansMapper get() {
        return newInstance();
    }

    public static DataSubsPlansToDomainSubsPlansMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataSubsPlansToDomainSubsPlansMapper newInstance() {
        return new DataSubsPlansToDomainSubsPlansMapper();
    }
}
