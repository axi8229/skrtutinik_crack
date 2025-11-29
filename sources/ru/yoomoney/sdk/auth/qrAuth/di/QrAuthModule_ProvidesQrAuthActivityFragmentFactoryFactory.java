package ru.yoomoney.sdk.auth.qrAuth.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.api.di.ActivityFragmentFactory;

/* loaded from: classes4.dex */
public final class QrAuthModule_ProvidesQrAuthActivityFragmentFactoryFactory implements Factory<ActivityFragmentFactory> {
    private final Provider<Map<Class<?>, Provider<Fragment>>> fragmentsProvider;
    private final QrAuthModule module;

    public QrAuthModule_ProvidesQrAuthActivityFragmentFactoryFactory(QrAuthModule qrAuthModule, Provider<Map<Class<?>, Provider<Fragment>>> provider) {
        this.module = qrAuthModule;
        this.fragmentsProvider = provider;
    }

    public static QrAuthModule_ProvidesQrAuthActivityFragmentFactoryFactory create(QrAuthModule qrAuthModule, Provider<Map<Class<?>, Provider<Fragment>>> provider) {
        return new QrAuthModule_ProvidesQrAuthActivityFragmentFactoryFactory(qrAuthModule, provider);
    }

    public static ActivityFragmentFactory providesQrAuthActivityFragmentFactory(QrAuthModule qrAuthModule, Map<Class<?>, Provider<Fragment>> map) {
        return (ActivityFragmentFactory) Preconditions.checkNotNullFromProvides(qrAuthModule.providesQrAuthActivityFragmentFactory(map));
    }

    @Override // javax.inject.Provider
    public ActivityFragmentFactory get() {
        return providesQrAuthActivityFragmentFactory(this.module, this.fragmentsProvider.get());
    }
}
