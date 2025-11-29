package ru.yoomoney.sdk.auth.api.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountApi;
import ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepository;

/* loaded from: classes4.dex */
public final class ProfileApiModule_SocialAccountRepositoryImplFactory implements Factory<SocialAccountRepository> {
    private final Provider<String> accountTokenProvider;
    private final Provider<SocialAccountApi> apiProvider;
    private final ProfileApiModule module;

    public ProfileApiModule_SocialAccountRepositoryImplFactory(ProfileApiModule profileApiModule, Provider<SocialAccountApi> provider, Provider<String> provider2) {
        this.module = profileApiModule;
        this.apiProvider = provider;
        this.accountTokenProvider = provider2;
    }

    public static ProfileApiModule_SocialAccountRepositoryImplFactory create(ProfileApiModule profileApiModule, Provider<SocialAccountApi> provider, Provider<String> provider2) {
        return new ProfileApiModule_SocialAccountRepositoryImplFactory(profileApiModule, provider, provider2);
    }

    public static SocialAccountRepository socialAccountRepositoryImpl(ProfileApiModule profileApiModule, SocialAccountApi socialAccountApi, String str) {
        return (SocialAccountRepository) Preconditions.checkNotNullFromProvides(profileApiModule.socialAccountRepositoryImpl(socialAccountApi, str));
    }

    @Override // javax.inject.Provider
    public SocialAccountRepository get() {
        return socialAccountRepositoryImpl(this.module, this.apiProvider.get(), this.accountTokenProvider.get());
    }
}
