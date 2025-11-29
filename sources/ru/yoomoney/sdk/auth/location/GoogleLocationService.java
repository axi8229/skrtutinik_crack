package ru.yoomoney.sdk.auth.location;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.huawei.hms.support.api.entity.core.CommonCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.location.di.LocationComponent;
import ru.yoomoney.sdk.auth.location.utils.UtilsKt;

@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\n\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0003R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lru/yoomoney/sdk/auth/location/GoogleLocationService;", "Landroid/app/Service;", "()V", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getFusedLocationClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "setFusedLocationClient", "(Lcom/google/android/gms/location/FusedLocationProviderClient;)V", "locationCallback", "ru/yoomoney/sdk/auth/location/GoogleLocationService$locationCallback$1", "Lru/yoomoney/sdk/auth/location/GoogleLocationService$locationCallback$1;", "locationHeaderManager", "Lru/yoomoney/sdk/auth/location/LocationHeaderManager;", "getLocationHeaderManager", "()Lru/yoomoney/sdk/auth/location/LocationHeaderManager;", "setLocationHeaderManager", "(Lru/yoomoney/sdk/auth/location/LocationHeaderManager;)V", "onBind", "Landroid/os/IBinder;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "onCreate", "", "onDestroy", "startLocationUpdates", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GoogleLocationService extends Service {
    private static final String TAG;
    public FusedLocationProviderClient fusedLocationClient;
    private final GoogleLocationService$locationCallback$1 locationCallback = new LocationCallback() { // from class: ru.yoomoney.sdk.auth.location.GoogleLocationService$locationCallback$1
        @Override // com.google.android.gms.location.LocationCallback
        public void onLocationResult(LocationResult locationResult) {
            Intrinsics.checkNotNullParameter(locationResult, "locationResult");
            super.onLocationResult(locationResult);
            for (Location location : locationResult.getLocations()) {
                Log.d(GoogleLocationService.TAG, "GoogleLocationService get new location" + location.getLatitude() + "/" + location.getLongitude());
                LocationHeaderManager locationHeaderManager = this.this$0.getLocationHeaderManager();
                Intrinsics.checkNotNull(location);
                locationHeaderManager.updateLocationHeader(UtilsKt.makeHeaderFromLocation(location));
            }
        }
    };
    public LocationHeaderManager locationHeaderManager;

    static {
        String name = GoogleLocationService.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        TAG = name;
    }

    @SuppressLint({"MissingPermission"})
    private final void startLocationUpdates() {
        if (!UtilsKt.checkPermissions(this) || !UtilsKt.isGPSEnabled(this)) {
            Log.d(TAG, "checkPermissions or isGPSEnabled = false");
            return;
        }
        LocationRequest locationRequestBuild = new LocationRequest.Builder(UtilsKt.UPDATE_INTERVAL).setPriority(100).build();
        Intrinsics.checkNotNullExpressionValue(locationRequestBuild, "build(...)");
        getFusedLocationClient().requestLocationUpdates(locationRequestBuild, this.locationCallback, (Looper) null);
    }

    public final FusedLocationProviderClient getFusedLocationClient() {
        FusedLocationProviderClient fusedLocationProviderClient = this.fusedLocationClient;
        if (fusedLocationProviderClient != null) {
            return fusedLocationProviderClient;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fusedLocationClient");
        return null;
    }

    public final LocationHeaderManager getLocationHeaderManager() {
        LocationHeaderManager locationHeaderManager = this.locationHeaderManager;
        if (locationHeaderManager != null) {
            return locationHeaderManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationHeaderManager");
        return null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "GoogleLocationService onCreate");
        LocationComponent.INSTANCE.initAndGet(this).inject(this);
        startLocationUpdates();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "GoogleLocationService onDestroy");
        getFusedLocationClient().removeLocationUpdates(this.locationCallback);
    }

    public final void setFusedLocationClient(FusedLocationProviderClient fusedLocationProviderClient) {
        Intrinsics.checkNotNullParameter(fusedLocationProviderClient, "<set-?>");
        this.fusedLocationClient = fusedLocationProviderClient;
    }

    public final void setLocationHeaderManager(LocationHeaderManager locationHeaderManager) {
        Intrinsics.checkNotNullParameter(locationHeaderManager, "<set-?>");
        this.locationHeaderManager = locationHeaderManager;
    }
}
