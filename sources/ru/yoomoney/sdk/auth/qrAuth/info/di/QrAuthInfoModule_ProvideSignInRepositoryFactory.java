package ru.yoomoney.sdk.auth.qrAuth.info.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.signIn.SignInApi;
import ru.yoomoney.sdk.auth.api.signIn.SignInRepository;

/* loaded from: classes4.dex */
public final class QrAuthInfoModule_ProvideSignInRepositoryFactory implements Factory<SignInRepository> {
    private final Provider<String> accountTokenProvider;
    private final QrAuthInfoModule module;
    private final Provider<SignInApi> signInApiProvider;

    public QrAuthInfoModule_ProvideSignInRepositoryFactory(QrAuthInfoModule qrAuthInfoModule, Provider<SignInApi> provider, Provider<String> provider2) {
        this.module = qrAuthInfoModule;
        this.signInApiProvider = provider;
        this.accountTokenProvider = provider2;
    }

    public static QrAuthInfoModule_ProvideSignInRepositoryFactory create(QrAuthInfoModule qrAuthInfoModule, Provider<SignInApi> provider, Provider<String> provider2) {
        return new QrAuthInfoModule_ProvideSignInRepositoryFactory(qrAuthInfoModule, provider, provider2);
    }

    public static SignInRepository provideSignInRepository(QrAuthInfoModule qrAuthInfoModule, SignInApi signInApi, String str) {
        return (SignInRepository) Preconditions.checkNotNullFromProvides(qrAuthInfoModule.provideSignInRepository(signInApi, str));
    }

    @Override // javax.inject.Provider
    public SignInRepository get() {
        return provideSignInRepository(this.module, this.signInApiProvider.get(), this.accountTokenProvider.get());
    }
}
