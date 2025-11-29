package com.sputnik.data.repositories.keys;

import com.sputnik.data.api.PhysicalKeysApi;
import com.sputnik.data.mappers.keys.DataPhysicalKeyToDomainPhysicalKeyMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PhysicalKeysRepository_Factory implements Factory<PhysicalKeysRepository> {
    private final Provider<PhysicalKeysApi> apiProvider;
    private final Provider<DataPhysicalKeyToDomainPhysicalKeyMapper> mapperProvider;

    public PhysicalKeysRepository_Factory(Provider<PhysicalKeysApi> provider, Provider<DataPhysicalKeyToDomainPhysicalKeyMapper> provider2) {
        this.apiProvider = provider;
        this.mapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public PhysicalKeysRepository get() {
        return newInstance(this.apiProvider.get(), this.mapperProvider.get());
    }

    public static PhysicalKeysRepository_Factory create(Provider<PhysicalKeysApi> provider, Provider<DataPhysicalKeyToDomainPhysicalKeyMapper> provider2) {
        return new PhysicalKeysRepository_Factory(provider, provider2);
    }

    public static PhysicalKeysRepository newInstance(PhysicalKeysApi physicalKeysApi, DataPhysicalKeyToDomainPhysicalKeyMapper dataPhysicalKeyToDomainPhysicalKeyMapper) {
        return new PhysicalKeysRepository(physicalKeysApi, dataPhysicalKeyToDomainPhysicalKeyMapper);
    }
}
