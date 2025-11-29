package com.sputnik.common.mappers.profile;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.data.local.PrefManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DomainProfileToProfileMapper_Factory implements Factory<DomainProfileToProfileMapper> {
    private final Provider<LocalizationStorage> localizationStorageProvider;
    private final Provider<DomainProfileCardInfoToProfileCardInfoMapper> mapperProvider;
    private final Provider<PrefManager> prefManagerProvider;

    public DomainProfileToProfileMapper_Factory(Provider<DomainProfileCardInfoToProfileCardInfoMapper> provider, Provider<LocalizationStorage> provider2, Provider<PrefManager> provider3) {
        this.mapperProvider = provider;
        this.localizationStorageProvider = provider2;
        this.prefManagerProvider = provider3;
    }

    @Override // javax.inject.Provider
    public DomainProfileToProfileMapper get() {
        return newInstance(this.mapperProvider.get(), this.localizationStorageProvider.get(), this.prefManagerProvider.get());
    }

    public static DomainProfileToProfileMapper_Factory create(Provider<DomainProfileCardInfoToProfileCardInfoMapper> provider, Provider<LocalizationStorage> provider2, Provider<PrefManager> provider3) {
        return new DomainProfileToProfileMapper_Factory(provider, provider2, provider3);
    }

    public static DomainProfileToProfileMapper newInstance(DomainProfileCardInfoToProfileCardInfoMapper domainProfileCardInfoToProfileCardInfoMapper, LocalizationStorage localizationStorage, PrefManager prefManager) {
        return new DomainProfileToProfileMapper(domainProfileCardInfoToProfileCardInfoMapper, localizationStorage, prefManager);
    }
}
