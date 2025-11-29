package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.yandex.metrica.networktasks.api.IParamsAppender;
import com.yandex.metrica.networktasks.api.NetworkTaskForSendingDataParamsAppender;
import com.yandex.metrica.networktasks.api.RequestBodyEncrypter;

/* loaded from: classes3.dex */
public class Qg implements IParamsAppender {
    private final Ng a;
    private final NetworkTaskForSendingDataParamsAppender b;
    private Ig c;
    private long d;

    public Qg(RequestBodyEncrypter requestBodyEncrypter) {
        this(new Ng(), new NetworkTaskForSendingDataParamsAppender(requestBodyEncrypter));
    }

    public void a(Ig ig) {
        this.c = ig;
    }

    @Override // com.yandex.metrica.networktasks.api.IParamsAppender
    public void appendParams(Uri.Builder builder, Object obj) {
        Lg lg = (Lg) obj;
        builder.path("report");
        this.b.appendEncryptedData(builder);
        Ig ig = this.c;
        if (ig != null) {
            this.b.appendCommitHash(builder, ig.p, ig.f);
            builder.appendQueryParameter("deviceid", C0810b.a(this.c.a, lg.g()));
            builder.appendQueryParameter("uuid", C0810b.a(this.c.b, lg.w()));
            a(builder, "analytics_sdk_version", this.c.c);
            a(builder, "analytics_sdk_version_name", this.c.d);
            builder.appendQueryParameter("app_version_name", C0810b.a(this.c.g, lg.f()));
            builder.appendQueryParameter("app_build_number", C0810b.a(this.c.i, lg.b()));
            builder.appendQueryParameter("os_version", C0810b.a(this.c.j, lg.o()));
            a(builder, "os_api_level", this.c.k);
            a(builder, "analytics_sdk_build_number", this.c.e);
            a(builder, "analytics_sdk_build_type", this.c.f);
            a(builder, "app_debuggable", this.c.h);
            builder.appendQueryParameter("locale", C0810b.a(this.c.l, lg.k()));
            builder.appendQueryParameter("is_rooted", C0810b.a(this.c.m, lg.h()));
            builder.appendQueryParameter("app_framework", C0810b.a(this.c.n, lg.c()));
            a(builder, "attribution_id", this.c.o);
        }
        builder.appendQueryParameter("api_key_128", lg.B());
        builder.appendQueryParameter(HiAnalyticsConstant.BI_KEY_APP_ID, lg.p());
        builder.appendQueryParameter("app_platform", "android");
        builder.appendQueryParameter("model", lg.m());
        builder.appendQueryParameter("manufacturer", lg.l());
        builder.appendQueryParameter("screen_width", String.valueOf(lg.u()));
        builder.appendQueryParameter("screen_height", String.valueOf(lg.t()));
        builder.appendQueryParameter("screen_dpi", String.valueOf(lg.s()));
        builder.appendQueryParameter("scalefactor", String.valueOf(lg.r()));
        builder.appendQueryParameter("device_type", lg.i());
        a(builder, "clids_set", lg.E());
        builder.appendQueryParameter("app_set_id", lg.d());
        builder.appendQueryParameter("app_set_id_scope", lg.e());
        this.a.appendParams(builder, lg.a());
        builder.appendQueryParameter("request_id", String.valueOf(this.d));
    }

    Qg(Ng ng, NetworkTaskForSendingDataParamsAppender networkTaskForSendingDataParamsAppender) {
        this.a = ng;
        this.b = networkTaskForSendingDataParamsAppender;
    }

    public void a(long j) {
        this.d = j;
    }

    private void a(Uri.Builder builder, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }
}
