package sberid.sdk.auth.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataUtils.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/content/Context;", "context", "", "checkSbolIsNotInstalled", "(Landroid/content/Context;)Z", "SberIdSDK_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class DataUtilsKt {
    public static final boolean checkSbolIsNotInstalled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", new Uri.Builder().scheme("sberbankidlogin").authority("sberbankid").build()), 0).isEmpty();
    }
}
