package sputnik.axmor.com.sputnik.core.updates;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformDependentFeatures.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"openMarket", "", "context", "Landroid/content/Context;", "openReviewDialog", "activity", "Landroid/app/Activity;", "app_huaweiRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PlatformDependentFeaturesKt {
    public static final void openMarket(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("appmarket://details?id=sputnik.axmor.com"));
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static final void openReviewDialog(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        openMarket(activity);
    }
}
