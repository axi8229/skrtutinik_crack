package ru.yoomoney.sdk.auth.qrAuth.info.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.qrAuth.info.impl.QrAuthInfoInteractor;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class QrAuthInfoModule_ProvideQrAuthInfoFragmentFactory implements Factory<Fragment> {
    private final Provider<QrAuthInfoInteractor> interactorProvider;
    private final QrAuthInfoModule module;
    private final Provider<ResourceMapper> resourceMapperProvider;

    public QrAuthInfoModule_ProvideQrAuthInfoFragmentFactory(QrAuthInfoModule qrAuthInfoModule, Provider<QrAuthInfoInteractor> provider, Provider<ResourceMapper> provider2) {
        this.module = qrAuthInfoModule;
        this.interactorProvider = provider;
        this.resourceMapperProvider = provider2;
    }

    public static QrAuthInfoModule_ProvideQrAuthInfoFragmentFactory create(QrAuthInfoModule qrAuthInfoModule, Provider<QrAuthInfoInteractor> provider, Provider<ResourceMapper> provider2) {
        return new QrAuthInfoModule_ProvideQrAuthInfoFragmentFactory(qrAuthInfoModule, provider, provider2);
    }

    public static Fragment provideQrAuthInfoFragment(QrAuthInfoModule qrAuthInfoModule, QrAuthInfoInteractor qrAuthInfoInteractor, ResourceMapper resourceMapper) {
        return (Fragment) Preconditions.checkNotNullFromProvides(qrAuthInfoModule.provideQrAuthInfoFragment(qrAuthInfoInteractor, resourceMapper));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideQrAuthInfoFragment(this.module, this.interactorProvider.get(), this.resourceMapperProvider.get());
    }
}
