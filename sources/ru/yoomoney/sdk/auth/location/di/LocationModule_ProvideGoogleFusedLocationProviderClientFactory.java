package ru.yoomoney.sdk.auth.location.di;

import android.content.Context;
import com.google.android.gms.location.FusedLocationProviderClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class LocationModule_ProvideGoogleFusedLocationProviderClientFactory implements Factory<FusedLocationProviderClient> {
    private final Provider<Context> contextProvider;

    public LocationModule_ProvideGoogleFusedLocationProviderClientFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static LocationModule_ProvideGoogleFusedLocationProviderClientFactory create(Provider<Context> provider) {
        return new LocationModule_ProvideGoogleFusedLocationProviderClientFactory(provider);
    }

    public static FusedLocationProviderClient provideGoogleFusedLocationProviderClient(Context context) {
        return (FusedLocationProviderClient) Preconditions.checkNotNullFromProvides(LocationModule.INSTANCE.provideGoogleFusedLocationProviderClient(context));
    }

    @Override // javax.inject.Provider
    public FusedLocationProviderClient get() {
        return provideGoogleFusedLocationProviderClient(this.contextProvider.get());
    }
}
