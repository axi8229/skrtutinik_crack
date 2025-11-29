package com.yandex.metrica;

import android.content.Context;
import com.yandex.metrica.impl.ob.L2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class p {
    private static final List<String> a = Arrays.asList("yandex_mobile_metrica_uuid", "yandex_mobile_metrica_device_id", "appmetrica_device_id_hash", "yandex_mobile_metrica_get_ad_url", "yandex_mobile_metrica_report_ad_url");

    public interface Ucc {
        void onError(String str);

        void onResult(JSONObject jSONObject);
    }

    public static void a(Context context, IIdentifierCallback iIdentifierCallback, List<String> list) {
        L2.a(context, iIdentifierCallback, new ArrayList(list));
    }

    @Deprecated
    public static YandexMetricaConfig cpcwh(YandexMetricaConfig yandexMetricaConfig, String str) {
        return L2.a(yandexMetricaConfig, str);
    }

    public static String gcni(Context context) {
        return L2.a(context);
    }

    public static String gdid(Context context) {
        return L2.b(context);
    }

    public static String gmsvn(int i) {
        return L2.a(i);
    }

    public static void guc(Ucc ucc, boolean z) {
        L2.a(ucc, z);
    }

    public static String guid(Context context) {
        return L2.d(context);
    }

    @Deprecated(since = "Use ModulesFacade.isActivatedForApp")
    public static boolean iifa() {
        return ModulesFacade.isActivatedForApp();
    }

    public static String mpn(Context context) {
        return L2.c(context);
    }

    public static String pgai() {
        try {
            return L2.a().get();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean plat() {
        try {
            return L2.b().get();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Deprecated(since = "Use ModulesFacade.reportEvent")
    public static void rce(int i, String str, String str2, Map<String, String> map) {
        ModulesFacade.reportEvent(i, str, str2, map);
    }

    public static void rlse(Context context, Map<String, Object> map) {
        L2.a(context, map);
    }

    @Deprecated(since = "Use ModulesFacade.sendEventsBuffer")
    public static void seb() {
        ModulesFacade.sendEventsBuffer();
    }

    @Deprecated(since = "Will be removed in next major release")
    public static void slte(Context context, boolean z) {
        L2.a(context, z);
    }

    public static String u(String str) {
        return L2.a(str);
    }

    public static void a(Context context, IIdentifierCallback iIdentifierCallback, String... strArr) {
        a(context, iIdentifierCallback, (List<String>) Arrays.asList(strArr));
    }

    public static void a(Context context, IIdentifierCallback iIdentifierCallback) {
        a(context, iIdentifierCallback, a);
    }
}
