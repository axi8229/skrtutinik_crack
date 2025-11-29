package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.yandex.metrica.impl.ob.C1147oc;
import com.yandex.metrica.impl.ob.E;

/* renamed from: com.yandex.metrica.impl.ob.qe, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1198qe {
    public final byte[] A;
    public final String a;
    public String b;
    public final Integer c;
    public final Integer d;
    public final Integer e;
    public final Long f;
    public final String g;
    public final String h;
    public final String i;
    public final EnumC0787a1 j;
    public final Integer k;
    public final String l;
    public final String m;
    public final Integer n;
    public final Integer o;
    public final String p;
    public final String q;
    public final Em r;
    public final D0 s;
    public final E.b.a t;
    public final C1147oc.a u;
    public final Integer v;
    public final Integer w;
    public final EnumC1375y0 x;
    public final Boolean y;
    public final Integer z;

    public C1198qe(ContentValues contentValues) {
        Integer asInteger = contentValues.getAsInteger("type");
        this.j = asInteger == null ? null : EnumC0787a1.a(asInteger.intValue());
        this.k = contentValues.getAsInteger("custom_type");
        this.a = contentValues.getAsString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        this.b = contentValues.getAsString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
        this.f = contentValues.getAsLong(CrashHianalyticsData.TIME);
        this.c = contentValues.getAsInteger("number");
        this.d = contentValues.getAsInteger("global_number");
        this.e = contentValues.getAsInteger("number_of_type");
        this.h = contentValues.getAsString("cell_info");
        this.g = contentValues.getAsString("location_info");
        this.i = contentValues.getAsString("wifi_network_info");
        this.l = contentValues.getAsString("error_environment");
        this.m = contentValues.getAsString("user_info");
        this.n = contentValues.getAsInteger("truncated");
        this.o = contentValues.getAsInteger("connection_type");
        this.p = contentValues.getAsString("cellular_connection_type");
        this.q = contentValues.getAsString("profile_id");
        this.r = Em.a(contentValues.getAsInteger("encrypting_mode"));
        this.s = D0.a(contentValues.getAsInteger("first_occurrence_status"));
        this.t = E.b.a.a(contentValues.getAsInteger("battery_charge_type"));
        this.u = C1147oc.a.a(contentValues.getAsString("collection_mode"));
        this.v = contentValues.getAsInteger("has_omitted_data");
        this.w = contentValues.getAsInteger("call_state");
        Integer asInteger2 = contentValues.getAsInteger("source");
        this.x = asInteger2 != null ? EnumC1375y0.a(asInteger2.intValue()) : null;
        this.y = contentValues.getAsBoolean("attribution_id_changed");
        this.z = contentValues.getAsInteger("open_id");
        this.A = contentValues.getAsByteArray("extras");
    }
}
