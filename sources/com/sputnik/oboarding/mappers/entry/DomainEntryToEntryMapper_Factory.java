package com.sputnik.oboarding.mappers.entry;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DomainEntryToEntryMapper_Factory implements Factory<DomainEntryToEntryMapper> {

    private static final class InstanceHolder {
        private static final DomainEntryToEntryMapper_Factory INSTANCE = new DomainEntryToEntryMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DomainEntryToEntryMapper get() {
        return newInstance();
    }

    public static DomainEntryToEntryMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DomainEntryToEntryMapper newInstance() {
        return new DomainEntryToEntryMapper();
    }
}
