package com.sputnik.common.mappers.archive;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DomainFlussonicToFlussonicMapper_Factory implements Factory<DomainFlussonicToFlussonicMapper> {

    private static final class InstanceHolder {
        private static final DomainFlussonicToFlussonicMapper_Factory INSTANCE = new DomainFlussonicToFlussonicMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DomainFlussonicToFlussonicMapper get() {
        return newInstance();
    }

    public static DomainFlussonicToFlussonicMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DomainFlussonicToFlussonicMapper newInstance() {
        return new DomainFlussonicToFlussonicMapper();
    }
}
