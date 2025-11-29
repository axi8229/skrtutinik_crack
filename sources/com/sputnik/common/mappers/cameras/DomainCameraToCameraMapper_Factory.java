package com.sputnik.common.mappers.cameras;

import com.sputnik.common.mappers.archive.DomainFlussonicToFlussonicMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DomainCameraToCameraMapper_Factory implements Factory<DomainCameraToCameraMapper> {
    private final Provider<DomainFlussonicToFlussonicMapper> mapperProvider;

    public DomainCameraToCameraMapper_Factory(Provider<DomainFlussonicToFlussonicMapper> provider) {
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public DomainCameraToCameraMapper get() {
        return newInstance(this.mapperProvider.get());
    }

    public static DomainCameraToCameraMapper_Factory create(Provider<DomainFlussonicToFlussonicMapper> provider) {
        return new DomainCameraToCameraMapper_Factory(provider);
    }

    public static DomainCameraToCameraMapper newInstance(DomainFlussonicToFlussonicMapper domainFlussonicToFlussonicMapper) {
        return new DomainCameraToCameraMapper(domainFlussonicToFlussonicMapper);
    }
}
