package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.yandex.metrica.networktasks.api.IParamsAppender;

/* loaded from: classes3.dex */
public class Og implements IParamsAppender {
    @Override // com.yandex.metrica.networktasks.api.IParamsAppender
    public void appendParams(Uri.Builder builder, Object obj) {
        D4 d4 = (D4) obj;
        builder.appendPath("diagnostic");
        builder.appendQueryParameter("deviceid", d4.g());
        builder.appendQueryParameter("uuid", d4.w());
        builder.appendQueryParameter("app_platform", "android");
        builder.appendQueryParameter("analytics_sdk_version_name", "5.3.0");
        builder.appendQueryParameter("analytics_sdk_build_number", "45003240");
        builder.appendQueryParameter("analytics_sdk_build_type", d4.j());
        if (d4.j().contains("source") && !TextUtils.isEmpty("a72bf6f57701ed3c2b8ed570054febbff4e58c12")) {
            builder.appendQueryParameter("commit_hash", "a72bf6f57701ed3c2b8ed570054febbff4e58c12");
        }
        builder.appendQueryParameter("app_version_name", d4.f());
        builder.appendQueryParameter("app_build_number", d4.b());
        builder.appendQueryParameter("model", d4.m());
        builder.appendQueryParameter("manufacturer", d4.l());
        builder.appendQueryParameter("os_version", d4.o());
        builder.appendQueryParameter("os_api_level", String.valueOf(d4.n()));
        builder.appendQueryParameter("screen_width", String.valueOf(d4.u()));
        builder.appendQueryParameter("screen_height", String.valueOf(d4.t()));
        builder.appendQueryParameter("screen_dpi", String.valueOf(d4.s()));
        builder.appendQueryParameter("scalefactor", String.valueOf(d4.r()));
        builder.appendQueryParameter("locale", d4.k());
        builder.appendQueryParameter("device_type", d4.i());
        builder.appendQueryParameter(HiAnalyticsConstant.BI_KEY_APP_ID, d4.p());
        builder.appendQueryParameter("api_key_128", d4.B());
        builder.appendQueryParameter("app_debuggable", d4.z());
        builder.appendQueryParameter("is_rooted", d4.h());
        builder.appendQueryParameter("app_framework", d4.c());
    }
}
