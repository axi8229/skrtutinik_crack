package com.sputnik.common.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebViewUtils.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/sputnik/common/utils/WebViewUtils;", "", "()V", "openWebPage", "", "activity", "Landroid/app/Activity;", "url", "", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WebViewUtils {
    public static final WebViewUtils INSTANCE = new WebViewUtils();

    private WebViewUtils() {
    }

    public final void openWebPage(Activity activity, String url) {
        Uri uri = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        if (activity != null) {
            ContextCompat.startActivity(activity, new Intent("android.intent.action.VIEW", uri), null);
        }
    }
}
