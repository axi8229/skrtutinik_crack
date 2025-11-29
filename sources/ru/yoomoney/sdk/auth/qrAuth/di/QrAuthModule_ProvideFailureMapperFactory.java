package ru.yoomoney.sdk.auth.qrAuth.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class QrAuthModule_ProvideFailureMapperFactory implements Factory<ResourceMapper> {
    private final Provider<Context> contextProvider;
    private final QrAuthModule module;

    public QrAuthModule_ProvideFailureMapperFactory(QrAuthModule qrAuthModule, Provider<Context> provider) {
        this.module = qrAuthModule;
        this.contextProvider = provider;
    }

    public static QrAuthModule_ProvideFailureMapperFactory create(QrAuthModule qrAuthModule, Provider<Context> provider) {
        return new QrAuthModule_ProvideFailureMapperFactory(qrAuthModule, provider);
    }

    public static ResourceMapper provideFailureMapper(QrAuthModule qrAuthModule, Context context) {
        return (ResourceMapper) Preconditions.checkNotNullFromProvides(qrAuthModule.provideFailureMapper(context));
    }

    @Override // javax.inject.Provider
    public ResourceMapper get() {
        return provideFailureMapper(this.module, this.contextProvider.get());
    }
}
