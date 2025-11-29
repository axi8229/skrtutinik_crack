package sberid.sdk.auth.utils;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sberid.sdk.auth.di.ComponentHolder;

/* compiled from: UriUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004¨\u0006\u0005"}, d2 = {"getHost", "", "isHostWhiteList", "", "Landroid/net/Uri;", "SberIdSDK_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class UriUtilsKt {
    public static final boolean isHostWhiteList(Uri isHostWhiteList) {
        Intrinsics.checkNotNullParameter(isHostWhiteList, "$this$isHostWhiteList");
        if (isHostWhiteList.getHost() == null) {
            return false;
        }
        ComponentHolder.INSTANCE.getComponentHolder();
        return false;
    }

    public static final String getHost(String getHost) {
        Intrinsics.checkNotNullParameter(getHost, "$this$getHost");
        Uri uri = Uri.parse(getHost);
        Intrinsics.checkNotNullExpressionValue(uri, "Uri.parse(this)");
        return uri.getHost();
    }
}
