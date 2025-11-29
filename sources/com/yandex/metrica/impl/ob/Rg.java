package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.yandex.metrica.impl.ob.C1306v3;
import com.yandex.metrica.networktasks.api.IParamsAppender;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class Rg implements IParamsAppender {
    private final Kg a;
    private final InterfaceC1048kd b;

    public Rg(Kg kg, InterfaceC1048kd interfaceC1048kd) {
        this.a = kg;
        this.b = interfaceC1048kd;
    }

    private void a(Uri.Builder builder, C1290ub c1290ub, String str) {
        if (c1290ub.a()) {
            builder.appendQueryParameter(this.a.a(str), c1290ub.a.b);
        } else {
            builder.appendQueryParameter(this.a.a(str), "");
        }
    }

    @Override // com.yandex.metrica.networktasks.api.IParamsAppender
    public void appendParams(Uri.Builder builder, Object obj) {
        int i;
        C0877dg c0877dgA;
        Mg mg = (Mg) obj;
        builder.path("analytics/startup");
        builder.appendQueryParameter(this.a.a("deviceid"), mg.g());
        C1233s2 c1233s2U = F0.g().u();
        C1410zb c1410zbA = mg.a();
        if (c1233s2U.c()) {
            builder.appendQueryParameter(this.a.a("adv_id"), "");
            builder.appendQueryParameter(this.a.a("oaid"), "");
            builder.appendQueryParameter(this.a.a("yandex_adv_id"), "");
        } else {
            a(builder, c1410zbA.a(), "adv_id");
            a(builder, c1410zbA.b(), "oaid");
            a(builder, c1410zbA.c(), "yandex_adv_id");
        }
        builder.appendQueryParameter(this.a.a("app_set_id"), mg.d());
        builder.appendQueryParameter(this.a.a("app_set_id_scope"), mg.e());
        builder.appendQueryParameter(this.a.a("app_platform"), "android");
        builder.appendQueryParameter(this.a.a("protocol_version"), "2");
        builder.appendQueryParameter(this.a.a("analytics_sdk_version_name"), "5.3.0");
        builder.appendQueryParameter(this.a.a("model"), mg.m());
        builder.appendQueryParameter(this.a.a("manufacturer"), mg.l());
        builder.appendQueryParameter(this.a.a("os_version"), mg.o());
        builder.appendQueryParameter(this.a.a("screen_width"), String.valueOf(mg.u()));
        builder.appendQueryParameter(this.a.a("screen_height"), String.valueOf(mg.t()));
        builder.appendQueryParameter(this.a.a("screen_dpi"), String.valueOf(mg.s()));
        builder.appendQueryParameter(this.a.a("scalefactor"), String.valueOf(mg.r()));
        builder.appendQueryParameter(this.a.a("locale"), mg.k());
        builder.appendQueryParameter(this.a.a("device_type"), mg.i());
        builder.appendQueryParameter(this.a.a("queries"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("query_hosts"), String.valueOf(2));
        String strA = this.a.a("features");
        List<String> listB = this.b.b();
        String[] strArr = {this.a.a("easy_collecting"), this.a.a("egress"), this.a.a("package_info"), this.a.a("socket"), this.a.a("permissions_collecting"), this.a.a("features_collecting"), this.a.a("location_collecting"), this.a.a("lbs_collecting"), this.a.a("google_aid"), this.a.a("huawei_oaid"), this.a.a("throttling"), this.a.a("wifi_around"), this.a.a("wifi_connected"), this.a.a("cells_around"), this.a.a("sim_info"), this.a.a("sdk_list"), this.a.a("identity_light_collecting"), this.a.a("gpl_collecting"), this.a.a("ui_parsing"), this.a.a("ui_collecting_for_bridge"), this.a.a("ui_event_sending"), this.a.a("ui_raw_event_sending"), this.a.a("cell_additional_info"), this.a.a("cell_additional_info_connected_only"), this.a.a("ssl_pinning")};
        ArrayList arrayList = new ArrayList(listB);
        arrayList.addAll(Arrays.asList(strArr));
        builder.appendQueryParameter(strA, TextUtils.join(",", (String[]) arrayList.toArray(new String[0])));
        builder.appendQueryParameter(this.a.a("socket"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a(HiAnalyticsConstant.BI_KEY_APP_ID), mg.p());
        builder.appendQueryParameter(this.a.a("location_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("app_debuggable"), mg.z());
        builder.appendQueryParameter(this.a.a("sdk_list"), String.valueOf(1));
        if (mg.L()) {
            String strD = mg.D();
            if (!TextUtils.isEmpty(strD)) {
                builder.appendQueryParameter(this.a.a("country_init"), strD);
            }
            i = 1;
        } else {
            i = 1;
            builder.appendQueryParameter(this.a.a("detect_locale"), String.valueOf(1));
        }
        C1306v3.a aVarB = mg.B();
        if (!A2.b(aVarB.b())) {
            builder.appendQueryParameter(this.a.a("distribution_customization"), String.valueOf(i));
            builder.appendQueryParameter(this.a.a("clids_set"), Tl.c(aVarB.b()));
            int iOrdinal = aVarB.a().ordinal();
            builder.appendQueryParameter(this.a.a("clids_set_source"), iOrdinal != i ? iOrdinal != 2 ? iOrdinal != 3 ? "" : "retail" : "satellite" : "api");
            String strE = mg.E();
            String strF = mg.F();
            if (TextUtils.isEmpty(strE) && (c0877dgA = mg.H().a()) != null) {
                strE = c0877dgA.a;
                strF = c0877dgA.d.a;
            }
            if (!TextUtils.isEmpty(strE)) {
                builder.appendQueryParameter(this.a.a("install_referrer"), strE);
                if (strF == null) {
                    strF = "null";
                }
                builder.appendQueryParameter(this.a.a("install_referrer_source"), strF);
            }
        }
        String strW = mg.w();
        if (!TextUtils.isEmpty(strW)) {
            builder.appendQueryParameter(this.a.a("uuid"), strW);
        }
        builder.appendQueryParameter(this.a.a(CrashHianalyticsData.TIME), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("requests"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("stat_sending"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("permissions"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("identity_light_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("ui_parsing"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("ui_collecting_for_bridge"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("ui_event_sending"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("ui_raw_event_sending"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("retry_policy"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("throttling"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("cache_control"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("mediascope_api_keys"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("diagnostics"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("permissions_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("app_system_flag"), mg.A());
        builder.appendQueryParameter(this.a.a("auto_inapp_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("attribution"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("easy_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("egress"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("startup_update"), String.valueOf(1));
        Map<String, Integer> mapA = this.b.a();
        for (String str : mapA.keySet()) {
            builder.appendQueryParameter(str, String.valueOf(mapA.get(str)));
        }
    }
}
