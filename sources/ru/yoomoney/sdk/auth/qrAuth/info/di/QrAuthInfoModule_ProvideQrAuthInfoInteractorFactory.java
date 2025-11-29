package ru.yoomoney.sdk.auth.qrAuth.info.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.signIn.SignInRepository;
import ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractor;

/* loaded from: classes4.dex */
public final class QrAuthInfoModule_ProvideQrAuthInfoInteractorFactory implements Factory<QrAuthInfoInteractor> {
    private final QrAuthInfoModule module;
    private final Provider<SignInRepository> signInRepositoryProvider;

    public QrAuthInfoModule_ProvideQrAuthInfoInteractorFactory(QrAuthInfoModule qrAuthInfoModule, Provider<SignInRepository> provider) {
        this.module = qrAuthInfoModule;
        this.signInRepositoryProvider = provider;
    }

    public static QrAuthInfoModule_ProvideQrAuthInfoInteractorFactory create(QrAuthInfoModule qrAuthInfoModule, Provider<SignInRepository> provider) {
        return new QrAuthInfoModule_ProvideQrAuthInfoInteractorFactory(qrAuthInfoModule, provider);
    }

    public static QrAuthInfoInteractor provideQrAuthInfoInteractor(QrAuthInfoModule qrAuthInfoModule, SignInRepository signInRepository) {
        return (QrAuthInfoInteractor) Preconditions.checkNotNullFromProvides(qrAuthInfoModule.provideQrAuthInfoInteractor(signInRepository));
    }

    @Override // javax.inject.Provider
    public QrAuthInfoInteractor get() {
        return provideQrAuthInfoInteractor(this.module, this.signInRepositoryProvider.get());
    }
}
