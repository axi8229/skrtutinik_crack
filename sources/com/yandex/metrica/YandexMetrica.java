package com.yandex.metrica;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.webkit.WebView;
import com.yandex.metrica.ecommerce.ECommerceEvent;
import com.yandex.metrica.impl.ob.Vf;
import com.yandex.metrica.impl.ob.W2;
import com.yandex.metrica.plugins.YandexMetricaPlugins;
import com.yandex.metrica.profile.UserProfile;
import java.util.Map;

/* loaded from: classes3.dex */
public final class YandexMetrica {
    private YandexMetrica() {
    }

    public static void activate(Context context, YandexMetricaConfig yandexMetricaConfig) {
        Vf.a().a(context, yandexMetricaConfig);
    }

    public static void activateReporter(Context context, ReporterConfig reporterConfig) {
        Vf.a().a(context, reporterConfig);
    }

    public static void enableActivityAutoTracking(Application application) {
        Vf.a().a(application);
    }

    public static int getLibraryApiLevel() {
        return 106;
    }

    public static String getLibraryVersion() {
        return "5.3.0";
    }

    public static YandexMetricaPlugins getPluginExtension() {
        return W2.a();
    }

    public static IReporter getReporter(Context context, String str) {
        return Vf.a().a(context, str);
    }

    public static void initWebViewReporting(WebView webView) {
        Vf.a().a(webView);
    }

    public static void pauseSession(Activity activity) {
        Vf.a().a(activity);
    }

    public static void putErrorEnvironmentValue(String str, String str2) {
        Vf.a().a(str, str2);
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        Vf.a().a(adRevenue);
    }

    public static void reportAppOpen(Activity activity) {
        Vf.a().b(activity);
    }

    public static void reportECommerce(ECommerceEvent eCommerceEvent) {
        Vf.a().a(eCommerceEvent);
    }

    public static void reportError(String str, Throwable th) {
        Vf.a().a(str, th);
    }

    public static void reportEvent(String str) {
        Vf.a().b(str);
    }

    @Deprecated
    public static void reportNativeCrash(String str) {
        Vf.a().d(str);
    }

    public static void reportReferralUrl(String str) {
        Vf.a().e(str);
    }

    public static void reportRevenue(Revenue revenue) {
        Vf.a().a(revenue);
    }

    public static void reportUnhandledException(Throwable th) {
        Vf.a().a(th);
    }

    public static void reportUserProfile(UserProfile userProfile) {
        Vf.a().a(userProfile);
    }

    public static void requestAppMetricaDeviceID(AppMetricaDeviceIDListener appMetricaDeviceIDListener) {
        Vf.a().a(appMetricaDeviceIDListener);
    }

    public static void requestDeferredDeeplink(DeferredDeeplinkListener deferredDeeplinkListener) {
        Vf.a().a(deferredDeeplinkListener);
    }

    public static void requestDeferredDeeplinkParameters(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        Vf.a().a(deferredDeeplinkParametersListener);
    }

    public static void resumeSession(Activity activity) {
        Vf.a().c(activity);
    }

    public static void sendEventsBuffer() {
        Vf.a().i();
    }

    public static void setLocation(Location location) {
        Vf.a().a(location);
    }

    public static void setLocationTracking(boolean z) {
        Vf.a().a(z);
    }

    public static void setStatisticsSending(Context context, boolean z) {
        Vf.a().b(context, z);
    }

    public static void setUserProfileID(String str) {
        Vf.a().f(str);
    }

    public static void reportAppOpen(String str) {
        Vf.a().a(str);
    }

    public static void reportError(String str, String str2) {
        Vf.a().a(str, str2, null);
    }

    public static void reportEvent(String str, String str2) {
        Vf.a().b(str, str2);
    }

    public static void setLocationTracking(Context context, boolean z) {
        Vf.a().a(context, z);
    }

    public static void reportAppOpen(Intent intent) {
        Vf.a().a(intent);
    }

    public static void reportError(String str, String str2, Throwable th) {
        Vf.a().a(str, str2, th);
    }

    public static void reportEvent(String str, Map<String, Object> map) {
        Vf.a().a(str, map);
    }
}
