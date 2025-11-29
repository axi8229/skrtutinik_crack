package npi.spay;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.e1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1555e1 {
    public static String a(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        String string = appContext.getSharedPreferences("clickstream_lite_prefs_device_id", 0).getString("deviceId", "");
        return string == null ? "" : string;
    }

    public final void a(Context appContext, String deviceId) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        appContext.getSharedPreferences("clickstream_lite_prefs_device_id", 0).edit().putString("deviceId", deviceId).apply();
    }
}
