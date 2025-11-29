package sputnik.axmor.com.sputnik.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PowerUtils.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"isIgnoringBatteryOptimizations", "", "context", "Landroid/content/Context;", "app_huaweiRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PowerUtilsKt {
    public static final boolean isIgnoringBatteryOptimizations(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        PowerManager powerManager = (PowerManager) ContextCompat.getSystemService(applicationContext, PowerManager.class);
        if (powerManager != null) {
            return powerManager.isIgnoringBatteryOptimizations(applicationContext.getPackageName());
        }
        return false;
    }
}
