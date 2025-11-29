package ru.yoomoney.sdk.auth.qrAuth.failure.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes4.dex */
public final class QrAuthFailureModule_ProvideQrAuthFailureFragmentFactory implements Factory<Fragment> {
    private final QrAuthFailureModule module;

    public QrAuthFailureModule_ProvideQrAuthFailureFragmentFactory(QrAuthFailureModule qrAuthFailureModule) {
        this.module = qrAuthFailureModule;
    }

    public static QrAuthFailureModule_ProvideQrAuthFailureFragmentFactory create(QrAuthFailureModule qrAuthFailureModule) {
        return new QrAuthFailureModule_ProvideQrAuthFailureFragmentFactory(qrAuthFailureModule);
    }

    public static Fragment provideQrAuthFailureFragment(QrAuthFailureModule qrAuthFailureModule) {
        return (Fragment) Preconditions.checkNotNullFromProvides(qrAuthFailureModule.provideQrAuthFailureFragment());
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideQrAuthFailureFragment(this.module);
    }
}
