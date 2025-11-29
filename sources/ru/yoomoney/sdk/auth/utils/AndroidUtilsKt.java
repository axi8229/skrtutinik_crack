package ru.yoomoney.sdk.auth.utils;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.huawei.hms.api.HuaweiApiAvailability;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0005"}, d2 = {"isGooglePlayServicesAvailable", "", "context", "Landroid/content/Context;", "isHuaweiMobileServicesAvailable", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AndroidUtilsKt {
    public static final boolean isGooglePlayServicesAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int iIsGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
        return iIsGooglePlayServicesAvailable == 0 || iIsGooglePlayServicesAvailable == 18;
    }

    public static final boolean isHuaweiMobileServicesAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int iIsHuaweiMobileServicesAvailable = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context);
        return iIsHuaweiMobileServicesAvailable == 0 || iIsHuaweiMobileServicesAvailable == 18;
    }
}
