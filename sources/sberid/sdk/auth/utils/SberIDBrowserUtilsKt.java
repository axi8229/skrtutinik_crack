package sberid.sdk.auth.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import ru.sberbank.mobile.clickstream.utils.CollectionUtils;
import sberid.sdk.auth.R$color;

/* compiled from: SberIDBrowserUtils.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u001a\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroid/content/Context;", "context", "Landroid/net/Uri;", "merchantUri", "", "launchCustomTabs", "(Landroid/content/Context;Landroid/net/Uri;)Z", "launchBrowser", "", "getCustomTabsPackage", "(Landroid/content/Context;)Ljava/lang/String;", "", "intentFlags", "", "Landroid/content/pm/ResolveInfo;", "getPackagesSupportingCustomTabs", "(Landroid/content/Context;I)Ljava/util/List;", "getPackagesSupportingBrowser", "SberIdSDK_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class SberIDBrowserUtilsKt {
    public static final boolean launchCustomTabs(Context context, Uri merchantUri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(merchantUri, "merchantUri");
        String customTabsPackage = getCustomTabsPackage(context);
        if (customTabsPackage != null) {
            try {
                CustomTabColorSchemeParams customTabColorSchemeParamsBuild = new CustomTabColorSchemeParams.Builder().setToolbarColor(ContextCompat.getColor(context, R$color.color_sber_id_button_primary)).build();
                Intrinsics.checkNotNullExpressionValue(customTabColorSchemeParamsBuild, "CustomTabColorSchemePara…ry))\n            .build()");
                CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().setDefaultColorSchemeParams(customTabColorSchemeParamsBuild).setShowTitle(true).build();
                Intrinsics.checkNotNullExpressionValue(customTabsIntentBuild, "CustomTabsIntent.Builder…rue)\n            .build()");
                customTabsIntentBuild.intent.setPackage(customTabsPackage);
                Log.d("CustomTabsUtils", "CustomTabs was launched with URL: " + merchantUri);
                customTabsIntentBuild.launchUrl(context, merchantUri);
                return true;
            } catch (Throwable th) {
                Log.e("CustomTabsUtils", String.valueOf(th.getMessage()), th);
            }
        }
        return false;
    }

    public static final boolean launchBrowser(Context context, Uri merchantUri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(merchantUri, "merchantUri");
        if (CollectionUtils.isEmpty(getPackagesSupportingBrowser(context, 131072))) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(merchantUri);
        Unit unit = Unit.INSTANCE;
        context.startActivity(intent);
        return true;
    }

    private static final String getCustomTabsPackage(Context context) {
        ActivityInfo activityInfo;
        ResolveInfo resolveInfo = (ResolveInfo) CollectionsKt.firstOrNull((List) getPackagesSupportingCustomTabs(context, pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1));
        if (resolveInfo != null) {
            return resolveInfo.activityInfo.packageName;
        }
        List<ResolveInfo> packagesSupportingCustomTabs = getPackagesSupportingCustomTabs(context, 131072);
        if (CollectionsKt.contains(packagesSupportingCustomTabs, "com.android.chrome")) {
            return "com.android.chrome";
        }
        ResolveInfo resolveInfo2 = (ResolveInfo) CollectionsKt.firstOrNull((List) packagesSupportingCustomTabs);
        if (resolveInfo2 == null || (activityInfo = resolveInfo2.activityInfo) == null) {
            return null;
        }
        return activityInfo.packageName;
    }

    private static final List<ResolveInfo> getPackagesSupportingCustomTabs(Context context, int i) {
        List<ResolveInfo> packagesSupportingBrowser = getPackagesSupportingBrowser(context, i);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : packagesSupportingBrowser) {
            Intent intent = new Intent();
            intent.setAction("android.support.customtabs.action.CustomTabsService");
            intent.setPackage(resolveInfo.activityInfo.packageName);
            if (context.getPackageManager().resolveService(intent, 131072) != null && !Intrinsics.areEqual(resolveInfo.activityInfo.packageName, "com.yandex.browser")) {
                arrayList.add(resolveInfo);
            }
        }
        return arrayList;
    }

    private static final List<ResolveInfo> getPackagesSupportingBrowser(Context context, int i) {
        PackageManager packageManager = context.getPackageManager();
        Intent data = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.fromParts("https", "", null));
        Intrinsics.checkNotNullExpressionValue(data, "Intent()\n        .setAct…StringUtils.EMPTY, null))");
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(data, i);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "packageManager.queryInte…ivityIntent, intentFlags)");
        return listQueryIntentActivities;
    }
}
