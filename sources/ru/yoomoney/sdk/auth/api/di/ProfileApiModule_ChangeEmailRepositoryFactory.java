package ru.yoomoney.sdk.auth.api.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeApi;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository;

/* loaded from: classes4.dex */
public final class ProfileApiModule_ChangeEmailRepositoryFactory implements Factory<EmailChangeRepository> {
    private final Provider<String> accountTokenProvider;
    private final Provider<EmailChangeApi> apiProvider;
    private final ProfileApiModule module;

    public ProfileApiModule_ChangeEmailRepositoryFactory(ProfileApiModule profileApiModule, Provider<EmailChangeApi> provider, Provider<String> provider2) {
        this.module = profileApiModule;
        this.apiProvider = provider;
        this.accountTokenProvider = provider2;
    }

    public static EmailChangeRepository changeEmailRepository(ProfileApiModule profileApiModule, EmailChangeApi emailChangeApi, String str) {
        return (EmailChangeRepository) Preconditions.checkNotNullFromProvides(profileApiModule.changeEmailRepository(emailChangeApi, str));
    }

    public static ProfileApiModule_ChangeEmailRepositoryFactory create(ProfileApiModule profileApiModule, Provider<EmailChangeApi> provider, Provider<String> provider2) {
        return new ProfileApiModule_ChangeEmailRepositoryFactory(profileApiModule, provider, provider2);
    }

    @Override // javax.inject.Provider
    public EmailChangeRepository get() {
        return changeEmailRepository(this.module, this.apiProvider.get(), this.accountTokenProvider.get());
    }
}
