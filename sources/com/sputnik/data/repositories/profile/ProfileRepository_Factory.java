package com.sputnik.data.repositories.profile;

import com.sputnik.data.api.ProfileApi;
import com.sputnik.data.mappers.profile.DataProfileToDomainProfileMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfileRepository_Factory implements Factory<ProfileRepository> {
    private final Provider<DataProfileToDomainProfileMapper> dataProfileToDomainProfileMapperProvider;
    private final Provider<ProfileApi> profileApiProvider;

    public ProfileRepository_Factory(Provider<ProfileApi> provider, Provider<DataProfileToDomainProfileMapper> provider2) {
        this.profileApiProvider = provider;
        this.dataProfileToDomainProfileMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public ProfileRepository get() {
        return newInstance(this.profileApiProvider.get(), this.dataProfileToDomainProfileMapperProvider.get());
    }

    public static ProfileRepository_Factory create(Provider<ProfileApi> provider, Provider<DataProfileToDomainProfileMapper> provider2) {
        return new ProfileRepository_Factory(provider, provider2);
    }

    public static ProfileRepository newInstance(ProfileApi profileApi, DataProfileToDomainProfileMapper dataProfileToDomainProfileMapper) {
        return new ProfileRepository(profileApi, dataProfileToDomainProfileMapper);
    }
}
