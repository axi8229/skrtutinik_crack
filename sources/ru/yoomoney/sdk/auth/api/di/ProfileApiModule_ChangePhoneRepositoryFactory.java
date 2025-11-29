package ru.yoomoney.sdk.auth.api.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeApi;
import ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepository;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;

/* loaded from: classes4.dex */
public final class ProfileApiModule_ChangePhoneRepositoryFactory implements Factory<PhoneChangeRepository> {
    private final Provider<String> accountTokenProvider;
    private final Provider<PhoneChangeApi> apiProvider;
    private final Provider<LocationHeaderManager> locationHeaderManagerProvider;
    private final ProfileApiModule module;

    public ProfileApiModule_ChangePhoneRepositoryFactory(ProfileApiModule profileApiModule, Provider<PhoneChangeApi> provider, Provider<String> provider2, Provider<LocationHeaderManager> provider3) {
        this.module = profileApiModule;
        this.apiProvider = provider;
        this.accountTokenProvider = provider2;
        this.locationHeaderManagerProvider = provider3;
    }

    public static PhoneChangeRepository changePhoneRepository(ProfileApiModule profileApiModule, PhoneChangeApi phoneChangeApi, String str, LocationHeaderManager locationHeaderManager) {
        return (PhoneChangeRepository) Preconditions.checkNotNullFromProvides(profileApiModule.changePhoneRepository(phoneChangeApi, str, locationHeaderManager));
    }

    public static ProfileApiModule_ChangePhoneRepositoryFactory create(ProfileApiModule profileApiModule, Provider<PhoneChangeApi> provider, Provider<String> provider2, Provider<LocationHeaderManager> provider3) {
        return new ProfileApiModule_ChangePhoneRepositoryFactory(profileApiModule, provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public PhoneChangeRepository get() {
        return changePhoneRepository(this.module, this.apiProvider.get(), this.accountTokenProvider.get(), this.locationHeaderManagerProvider.get());
    }
}
