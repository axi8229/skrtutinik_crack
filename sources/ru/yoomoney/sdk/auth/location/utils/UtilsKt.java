package ru.yoomoney.sdk.auth.location.utils;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.location.GoogleLocationService;
import ru.yoomoney.sdk.auth.location.HuaweiLocationService;
import ru.yoomoney.sdk.auth.utils.AndroidUtilsKt;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"COMMA_SYMBOL", "", "UPDATE_INTERVAL", "", "checkPermissions", "", "context", "Landroid/content/Context;", "isGPSEnabled", "makeHeaderFromLocation", "location", "Landroid/location/Location;", "startLocationService", "Landroid/content/Intent;", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UtilsKt {
    private static final String COMMA_SYMBOL = ",";
    public static final long UPDATE_INTERVAL = 30000;

    public static final boolean checkPermissions(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static final boolean isGPSEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        return ((LocationManager) systemService).isProviderEnabled("gps");
    }

    public static final String makeHeaderFromLocation(Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        return location.getLatitude() + COMMA_SYMBOL + location.getLongitude();
    }

    public static final Intent startLocationService(Context context) {
        Intent intent;
        Intrinsics.checkNotNullParameter(context, "context");
        if (AndroidUtilsKt.isGooglePlayServicesAvailable(context)) {
            intent = new Intent(context, (Class<?>) GoogleLocationService.class);
        } else {
            if (!AndroidUtilsKt.isHuaweiMobileServicesAvailable(context)) {
                return null;
            }
            intent = new Intent(context, (Class<?>) HuaweiLocationService.class);
        }
        context.startService(intent);
        return intent;
    }
}
