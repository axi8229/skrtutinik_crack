package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.IIdentifierCallback;
import com.yandex.metrica.YandexMetricaConfig;
import com.yandex.metrica.coreutils.network.UserAgent;
import com.yandex.metrica.p;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
public final class L2 {
    static Rf a = new Rf(P.g().c(), new Sf());

    public static void a(Context context, IIdentifierCallback iIdentifierCallback, List<String> list) {
        a.a(context, iIdentifierCallback, list);
    }

    public static String b(Context context) {
        return a.b(context);
    }

    public static String c(Context context) {
        return a.c(context);
    }

    public static String d(Context context) {
        return a.d(context);
    }

    public static Future<String> a() {
        return a.a();
    }

    public static Future<Boolean> b() {
        return a.b();
    }

    public static String a(Context context) {
        return a.a(context);
    }

    public static String a(String str) {
        a.getClass();
        return UserAgent.getFor(str, "5.3.0", "45003240");
    }

    public static String a(int i) {
        a.getClass();
        return Z0.a(i);
    }

    public static YandexMetricaConfig a(YandexMetricaConfig yandexMetricaConfig, String str) {
        a.getClass();
        return com.yandex.metrica.i.a(yandexMetricaConfig).a(Collections.singletonList(str)).a();
    }

    public static YandexMetricaConfig a(YandexMetricaConfig yandexMetricaConfig, List<String> list) {
        a.getClass();
        return com.yandex.metrica.i.a(yandexMetricaConfig).a(list).a();
    }

    public static void a(Context context, boolean z) {
        a.a(context, z);
    }

    public static void a(p.Ucc ucc, boolean z) {
        a.a(ucc, z);
    }

    public static void a(Context context, Map<String, Object> map) {
        a.a(context, map);
    }
}
