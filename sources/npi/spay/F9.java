package npi.spay;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class F9 {
    public final Context a;

    public F9(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    public final String a(String packageName) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        try {
            PackageManager packageManager = this.a.getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "context.packageManager");
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "packageManager.getApplic…ageManager.GET_META_DATA)");
            CharSequence applicationLabel = packageManager.getApplicationLabel(applicationInfo);
            Intrinsics.checkNotNull(applicationLabel, "null cannot be cast to non-null type kotlin.String");
            return (String) applicationLabel;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
