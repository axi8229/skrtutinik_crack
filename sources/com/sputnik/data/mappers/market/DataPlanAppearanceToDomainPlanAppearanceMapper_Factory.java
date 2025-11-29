package com.sputnik.data.mappers.market;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataPlanAppearanceToDomainPlanAppearanceMapper_Factory implements Factory<DataPlanAppearanceToDomainPlanAppearanceMapper> {

    private static final class InstanceHolder {
        private static final DataPlanAppearanceToDomainPlanAppearanceMapper_Factory INSTANCE = new DataPlanAppearanceToDomainPlanAppearanceMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataPlanAppearanceToDomainPlanAppearanceMapper get() {
        return newInstance();
    }

    public static DataPlanAppearanceToDomainPlanAppearanceMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataPlanAppearanceToDomainPlanAppearanceMapper newInstance() {
        return new DataPlanAppearanceToDomainPlanAppearanceMapper();
    }
}
