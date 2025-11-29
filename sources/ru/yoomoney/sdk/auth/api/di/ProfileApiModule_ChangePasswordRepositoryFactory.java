package ru.yoomoney.sdk.auth.api.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeApi;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;

/* loaded from: classes4.dex */
public final class ProfileApiModule_ChangePasswordRepositoryFactory implements Factory<PasswordChangeRepository> {
    private final Provider<String> accountTokenProvider;
    private final Provider<PasswordChangeApi> apiProvider;
    private final Provider<LocationHeaderManager> locationHeaderManagerProvider;
    private final ProfileApiModule module;

    public ProfileApiModule_ChangePasswordRepositoryFactory(ProfileApiModule profileApiModule, Provider<PasswordChangeApi> provider, Provider<String> provider2, Provider<LocationHeaderManager> provider3) {
        this.module = profileApiModule;
        this.apiProvider = provider;
        this.accountTokenProvider = provider2;
        this.locationHeaderManagerProvider = provider3;
    }

    public static PasswordChangeRepository changePasswordRepository(ProfileApiModule profileApiModule, PasswordChangeApi passwordChangeApi, String str, LocationHeaderManager locationHeaderManager) {
        return (PasswordChangeRepository) Preconditions.checkNotNullFromProvides(profileApiModule.changePasswordRepository(passwordChangeApi, str, locationHeaderManager));
    }

    public static ProfileApiModule_ChangePasswordRepositoryFactory create(ProfileApiModule profileApiModule, Provider<PasswordChangeApi> provider, Provider<String> provider2, Provider<LocationHeaderManager> provider3) {
        return new ProfileApiModule_ChangePasswordRepositoryFactory(profileApiModule, provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public PasswordChangeRepository get() {
        return changePasswordRepository(this.module, this.apiProvider.get(), this.accountTokenProvider.get(), this.locationHeaderManagerProvider.get());
    }
}
