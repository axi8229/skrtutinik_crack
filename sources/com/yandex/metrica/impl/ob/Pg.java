package com.yandex.metrica.impl.ob;

import android.net.Uri;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.yandex.metrica.networktasks.api.IParamsAppender;
import com.yandex.metrica.networktasks.api.NetworkTaskForSendingDataParamsAppender;
import com.yandex.metrica.networktasks.api.RequestBodyEncrypter;

/* loaded from: classes3.dex */
public class Pg implements IParamsAppender {
    private final Ng a;
    private final NetworkTaskForSendingDataParamsAppender b;
    private long c;

    public Pg(RequestBodyEncrypter requestBodyEncrypter) {
        this(new Ng(), new NetworkTaskForSendingDataParamsAppender(requestBodyEncrypter));
    }

    public void a(long j) {
        this.c = j;
    }

    @Override // com.yandex.metrica.networktasks.api.IParamsAppender
    public void appendParams(Uri.Builder builder, Object obj) {
        C0949gd c0949gd = (C0949gd) obj;
        this.b.appendEncryptedData(builder);
        NetworkTaskForSendingDataParamsAppender networkTaskForSendingDataParamsAppender = this.b;
        c0949gd.getClass();
        networkTaskForSendingDataParamsAppender.appendCommitHash(builder, "a72bf6f57701ed3c2b8ed570054febbff4e58c12", c0949gd.j());
        builder.appendPath("location");
        builder.appendQueryParameter("deviceid", c0949gd.g());
        builder.appendQueryParameter("device_type", c0949gd.i());
        builder.appendQueryParameter("uuid", c0949gd.w());
        builder.appendQueryParameter("analytics_sdk_version_name", "5.3.0");
        builder.appendQueryParameter("analytics_sdk_build_number", "45003240");
        builder.appendQueryParameter("analytics_sdk_build_type", c0949gd.j());
        builder.appendQueryParameter("app_version_name", c0949gd.f());
        builder.appendQueryParameter("app_build_number", c0949gd.b());
        builder.appendQueryParameter("os_version", c0949gd.o());
        builder.appendQueryParameter("os_api_level", String.valueOf(c0949gd.n()));
        builder.appendQueryParameter("is_rooted", c0949gd.h());
        builder.appendQueryParameter("app_framework", c0949gd.c());
        builder.appendQueryParameter(HiAnalyticsConstant.BI_KEY_APP_ID, c0949gd.p());
        builder.appendQueryParameter("app_platform", "android");
        builder.appendQueryParameter("request_id", String.valueOf(this.c));
        builder.appendQueryParameter("app_set_id", c0949gd.d());
        builder.appendQueryParameter("app_set_id_scope", c0949gd.e());
        this.a.appendParams(builder, c0949gd.a());
    }

    Pg(Ng ng, NetworkTaskForSendingDataParamsAppender networkTaskForSendingDataParamsAppender) {
        this.a = ng;
        this.b = networkTaskForSendingDataParamsAppender;
    }
}
