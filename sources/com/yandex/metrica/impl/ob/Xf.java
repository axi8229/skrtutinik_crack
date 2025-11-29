package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yandex.metrica.AppMetricaDeviceIDListener;
import com.yandex.metrica.DeferredDeeplinkListener;
import com.yandex.metrica.DeferredDeeplinkParametersListener;
import com.yandex.metrica.ReporterConfig;
import com.yandex.metrica.YandexMetricaConfig;

/* loaded from: classes3.dex */
public class Xf extends C0802ag {
    private static final Kn<YandexMetricaConfig> j = new Hn(new Gn("Config"));
    private static final Kn<String> k = new Hn(new Fn("Native crash"));
    private static final Kn<Activity> l = new Hn(new Gn("Activity"));
    private static final Kn<Intent> m = new Hn(new Gn("Intent"));
    private static final Kn<Application> n = new Hn(new Gn("Application"));
    private static final Kn<Context> o = new Hn(new Gn("Context"));
    private static final Kn<Object> p = new Hn(new Gn("Deeplink listener"));
    private static final Kn<AppMetricaDeviceIDListener> q = new Hn(new Gn("DeviceID listener"));
    private static final Kn<ReporterConfig> r = new Hn(new Gn("Reporter Config"));
    private static final Kn<String> s = new Hn(new Fn("Deeplink"));
    private static final Kn<String> t = new Hn(new Fn("Referral url"));
    private static final Kn<String> u = new Hn(new Ln());
    private static final Kn<String> v = new Hn(new Gn("Key"));
    private static final Kn<WebView> w = new Hn(new Gn("WebView"));
    private static final Kn<String> x = new Fn(AppMeasurementSdk.ConditionalUserProperty.VALUE);
    private static final Kn<String> y = new Fn(AppMeasurementSdk.ConditionalUserProperty.NAME);

    public void a(Application application) {
        ((Hn) n).a(application);
    }

    public void b(Context context) {
        ((Hn) o).a(context);
    }

    public void c(String str) {
        ((Hn) k).a(str);
    }

    public void d(String str) {
        ((Hn) v).a(str);
    }

    public void e(String str) {
        ((Hn) s).a(str);
    }

    public boolean f(String str) {
        return ((Fn) y).a(str).b();
    }

    public boolean g(String str) {
        return ((Fn) x).a(str).b();
    }

    public void a(Intent intent) {
        ((Hn) m).a(intent);
    }

    public void c(Activity activity) {
        ((Hn) l).a(activity);
    }

    public void a(String str) {
        ((Hn) t).a(str);
    }

    public void a(Context context) {
        ((Hn) o).a(context);
    }

    public void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        ((Hn) p).a(deferredDeeplinkParametersListener);
    }

    public void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        ((Hn) p).a(deferredDeeplinkListener);
    }

    public void a(AppMetricaDeviceIDListener appMetricaDeviceIDListener) {
        ((Hn) q).a(appMetricaDeviceIDListener);
    }

    public void a(Context context, String str) {
        ((Hn) o).a(context);
        ((Hn) u).a(str);
    }

    public void a(Context context, ReporterConfig reporterConfig) {
        ((Hn) o).a(context);
        ((Hn) r).a(reporterConfig);
    }

    public void a(Context context, YandexMetricaConfig yandexMetricaConfig) {
        ((Hn) o).a(context);
        ((Hn) j).a(yandexMetricaConfig);
    }

    public void a(WebView webView) {
        ((Hn) w).a(webView);
    }
}
