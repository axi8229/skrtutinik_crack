package ru.yoomoney.sdk.auth.location.di;

import android.content.Context;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;
import ru.yoomoney.sdk.auth.location.LocationHeaderManagerImpl;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/location/di/LocationModule;", "", "()V", "provideGoogleFusedLocationProviderClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "context", "Landroid/content/Context;", "provideHuaweiFusedLocationProviderClient", "Lcom/huawei/hms/location/FusedLocationProviderClient;", "provideLocationHeaderManager", "Lru/yoomoney/sdk/auth/location/LocationHeaderManager;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LocationModule {
    public static final LocationModule INSTANCE = new LocationModule();

    private LocationModule() {
    }

    public final FusedLocationProviderClient provideGoogleFusedLocationProviderClient(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClient, "getFusedLocationProviderClient(...)");
        return fusedLocationProviderClient;
    }

    public final com.huawei.hms.location.FusedLocationProviderClient provideHuaweiFusedLocationProviderClient(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.huawei.hms.location.FusedLocationProviderClient fusedLocationProviderClient = com.huawei.hms.location.LocationServices.getFusedLocationProviderClient(context);
        Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClient, "getFusedLocationProviderClient(...)");
        return fusedLocationProviderClient;
    }

    public final LocationHeaderManager provideLocationHeaderManager() {
        return new LocationHeaderManagerImpl();
    }
}
