package sputnik.axmor.com.sputnik.utils.permissions;

import android.content.Context;
import android.provider.Settings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionsUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isDisplayOverOtherAppsGranted", "", "Landroid/content/Context;", "app_huaweiRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PermissionsUtilsKt {
    public static final boolean isDisplayOverOtherAppsGranted(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return Settings.canDrawOverlays(context);
    }
}
