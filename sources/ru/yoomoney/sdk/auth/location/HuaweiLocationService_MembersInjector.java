package ru.yoomoney.sdk.auth.location;

import com.huawei.hms.location.FusedLocationProviderClient;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class HuaweiLocationService_MembersInjector implements MembersInjector<HuaweiLocationService> {
    private final Provider<FusedLocationProviderClient> fusedLocationClientProvider;
    private final Provider<LocationHeaderManager> locationHeaderManagerProvider;

    public HuaweiLocationService_MembersInjector(Provider<FusedLocationProviderClient> provider, Provider<LocationHeaderManager> provider2) {
        this.fusedLocationClientProvider = provider;
        this.locationHeaderManagerProvider = provider2;
    }

    public static MembersInjector<HuaweiLocationService> create(Provider<FusedLocationProviderClient> provider, Provider<LocationHeaderManager> provider2) {
        return new HuaweiLocationService_MembersInjector(provider, provider2);
    }

    public static void injectFusedLocationClient(HuaweiLocationService huaweiLocationService, FusedLocationProviderClient fusedLocationProviderClient) {
        huaweiLocationService.fusedLocationClient = fusedLocationProviderClient;
    }

    public static void injectLocationHeaderManager(HuaweiLocationService huaweiLocationService, LocationHeaderManager locationHeaderManager) {
        huaweiLocationService.locationHeaderManager = locationHeaderManager;
    }

    public void injectMembers(HuaweiLocationService huaweiLocationService) {
        injectFusedLocationClient(huaweiLocationService, this.fusedLocationClientProvider.get());
        injectLocationHeaderManager(huaweiLocationService, this.locationHeaderManagerProvider.get());
    }
}
