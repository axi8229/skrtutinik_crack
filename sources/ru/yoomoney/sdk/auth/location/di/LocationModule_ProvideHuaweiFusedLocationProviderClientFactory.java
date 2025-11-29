package ru.yoomoney.sdk.auth.location.di;

import android.content.Context;
import com.huawei.hms.location.FusedLocationProviderClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class LocationModule_ProvideHuaweiFusedLocationProviderClientFactory implements Factory<FusedLocationProviderClient> {
    private final Provider<Context> contextProvider;

    public LocationModule_ProvideHuaweiFusedLocationProviderClientFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static LocationModule_ProvideHuaweiFusedLocationProviderClientFactory create(Provider<Context> provider) {
        return new LocationModule_ProvideHuaweiFusedLocationProviderClientFactory(provider);
    }

    public static FusedLocationProviderClient provideHuaweiFusedLocationProviderClient(Context context) {
        return (FusedLocationProviderClient) Preconditions.checkNotNullFromProvides(LocationModule.INSTANCE.provideHuaweiFusedLocationProviderClient(context));
    }

    @Override // javax.inject.Provider
    public FusedLocationProviderClient get() {
        return provideHuaweiFusedLocationProviderClient(this.contextProvider.get());
    }
}
