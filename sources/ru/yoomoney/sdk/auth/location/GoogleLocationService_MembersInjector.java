package ru.yoomoney.sdk.auth.location;

import com.google.android.gms.location.FusedLocationProviderClient;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GoogleLocationService_MembersInjector implements MembersInjector<GoogleLocationService> {
    private final Provider<FusedLocationProviderClient> fusedLocationClientProvider;
    private final Provider<LocationHeaderManager> locationHeaderManagerProvider;

    public GoogleLocationService_MembersInjector(Provider<FusedLocationProviderClient> provider, Provider<LocationHeaderManager> provider2) {
        this.fusedLocationClientProvider = provider;
        this.locationHeaderManagerProvider = provider2;
    }

    public static MembersInjector<GoogleLocationService> create(Provider<FusedLocationProviderClient> provider, Provider<LocationHeaderManager> provider2) {
        return new GoogleLocationService_MembersInjector(provider, provider2);
    }

    public static void injectFusedLocationClient(GoogleLocationService googleLocationService, FusedLocationProviderClient fusedLocationProviderClient) {
        googleLocationService.fusedLocationClient = fusedLocationProviderClient;
    }

    public static void injectLocationHeaderManager(GoogleLocationService googleLocationService, LocationHeaderManager locationHeaderManager) {
        googleLocationService.locationHeaderManager = locationHeaderManager;
    }

    public void injectMembers(GoogleLocationService googleLocationService) {
        injectFusedLocationClient(googleLocationService, this.fusedLocationClientProvider.get());
        injectLocationHeaderManager(googleLocationService, this.locationHeaderManagerProvider.get());
    }
}
