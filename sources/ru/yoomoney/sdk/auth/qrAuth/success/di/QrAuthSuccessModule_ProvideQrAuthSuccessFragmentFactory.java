package ru.yoomoney.sdk.auth.qrAuth.success.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes4.dex */
public final class QrAuthSuccessModule_ProvideQrAuthSuccessFragmentFactory implements Factory<Fragment> {
    private final QrAuthSuccessModule module;

    public QrAuthSuccessModule_ProvideQrAuthSuccessFragmentFactory(QrAuthSuccessModule qrAuthSuccessModule) {
        this.module = qrAuthSuccessModule;
    }

    public static QrAuthSuccessModule_ProvideQrAuthSuccessFragmentFactory create(QrAuthSuccessModule qrAuthSuccessModule) {
        return new QrAuthSuccessModule_ProvideQrAuthSuccessFragmentFactory(qrAuthSuccessModule);
    }

    public static Fragment provideQrAuthSuccessFragment(QrAuthSuccessModule qrAuthSuccessModule) {
        return (Fragment) Preconditions.checkNotNullFromProvides(qrAuthSuccessModule.provideQrAuthSuccessFragment());
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideQrAuthSuccessFragment(this.module);
    }
}
