package com.sputnik.common.mappers.keys;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DomainPhysicalKeyToPhysicalKeyMapper_Factory implements Factory<DomainPhysicalKeyToPhysicalKeyMapper> {

    private static final class InstanceHolder {
        private static final DomainPhysicalKeyToPhysicalKeyMapper_Factory INSTANCE = new DomainPhysicalKeyToPhysicalKeyMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DomainPhysicalKeyToPhysicalKeyMapper get() {
        return newInstance();
    }

    public static DomainPhysicalKeyToPhysicalKeyMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DomainPhysicalKeyToPhysicalKeyMapper newInstance() {
        return new DomainPhysicalKeyToPhysicalKeyMapper();
    }
}
