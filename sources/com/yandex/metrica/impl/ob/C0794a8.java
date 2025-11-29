package com.yandex.metrica.impl.ob;

import android.util.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.a8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0794a8 {
    private final C0844c8 a;

    /* renamed from: com.yandex.metrica.impl.ob.a8$a */
    static final class a implements InterfaceC0869d8 {
        public static final a a = new a();

        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC0869d8
        public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("device_id", Tl.a(jSONObject, jSONObject2, "device_id"));
            jSONObject3.put("device_id_hash", Tl.a(jSONObject, jSONObject2, "device_id_hash"));
            jSONObject3.put("referrer", Tl.a(jSONObject, jSONObject2, "referrer"));
            jSONObject3.put("referrer_checked", Tl.a(jSONObject2, "referrer_checked", Tl.a(jSONObject, "referrer_checked", Boolean.FALSE)));
            jSONObject3.put("location_id", Tl.a(jSONObject2, "location_id", Tl.a(jSONObject, "location_id", (Long) (-1L))));
            jSONObject3.put("lbs_id", Tl.a(jSONObject2, "lbs_id", Tl.a(jSONObject, "lbs_id", (Long) (-1L))));
            jSONObject3.put("location_request_id", Tl.a(jSONObject2, "location_request_id", Tl.a(jSONObject, "location_request_id", (Long) (-1L))));
            jSONObject3.put("last_migration_api_level", Tl.a(jSONObject2, "last_migration_api_level", Tl.a(jSONObject, "last_migration_api_level", (Integer) (-1))));
            return jSONObject3;
        }
    }

    public C0794a8(InterfaceC0919f8 interfaceC0919f8, InterfaceC0919f8 interfaceC0919f82) {
        this.a = new C0844c8(interfaceC0919f8, interfaceC0919f82, "[VitalCommonDataProvider]", a.a);
    }

    public final synchronized String a() {
        return Tl.b(this.a.a(), "device_id");
    }

    public final synchronized String b() {
        return Tl.b(this.a.a(), "device_id_hash");
    }

    public final synchronized void c(long j) {
        C0844c8 c0844c8 = this.a;
        JSONObject jSONObjectPut = c0844c8.a().put("location_request_id", j);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…CATION_REQUEST_ID, value)");
        c0844c8.a(jSONObjectPut);
    }

    public final synchronized long d() {
        return this.a.a().optLong("lbs_id", -1L);
    }

    public final synchronized long e() {
        return this.a.a().optLong("location_id", -1L);
    }

    public final synchronized long f() {
        return this.a.a().optLong("location_request_id", -1L);
    }

    public final synchronized C0877dg g() {
        C0877dg c0877dgA;
        String strB = Tl.b(this.a.a(), "referrer");
        if (strB != null) {
            try {
                byte[] bytes = strB.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                c0877dgA = C0877dg.a(Base64.decode(bytes, 0));
            } catch (Throwable unused) {
            }
        } else {
            c0877dgA = null;
        }
        return c0877dgA;
    }

    public final synchronized boolean h() {
        return this.a.a().optBoolean("referrer_checked", false);
    }

    public final synchronized void a(String str) {
        C0844c8 c0844c8 = this.a;
        JSONObject jSONObjectPut = c0844c8.a().put("device_id", str);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…put(KEY_DEVICE_ID, value)");
        c0844c8.a(jSONObjectPut);
    }

    public final synchronized void b(String str) {
        C0844c8 c0844c8 = this.a;
        JSONObject jSONObjectPut = c0844c8.a().put("device_id_hash", str);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…EY_DEVICE_ID_HASH, value)");
        c0844c8.a(jSONObjectPut);
    }

    public final synchronized int c() {
        return this.a.a().optInt("last_migration_api_level", -1);
    }

    public final synchronized void a(C0877dg c0877dg) {
        String str;
        try {
            C0844c8 c0844c8 = this.a;
            JSONObject jSONObjectA = c0844c8.a();
            if (c0877dg != null) {
                byte[] bArrEncode = Base64.encode(c0877dg.a(), 0);
                Intrinsics.checkNotNullExpressionValue(bArrEncode, "Base64.encode(toProto(), 0)");
                str = new String(bArrEncode, Charsets.UTF_8);
            } else {
                str = null;
            }
            JSONObject jSONObjectPut = jSONObjectA.put("referrer", str);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…value?.toEncodedString())");
            c0844c8.a(jSONObjectPut);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(long j) {
        C0844c8 c0844c8 = this.a;
        JSONObject jSONObjectPut = c0844c8.a().put("location_id", j);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…t(KEY_LOCATION_ID, value)");
        c0844c8.a(jSONObjectPut);
    }

    public final synchronized void a(boolean z) {
        C0844c8 c0844c8 = this.a;
        JSONObject jSONObjectPut = c0844c8.a().put("referrer_checked", z);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…_REFERRER_CHECKED, value)");
        c0844c8.a(jSONObjectPut);
    }

    public final synchronized void a(long j) {
        C0844c8 c0844c8 = this.a;
        JSONObject jSONObjectPut = c0844c8.a().put("lbs_id", j);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…().put(KEY_LBS_ID, value)");
        c0844c8.a(jSONObjectPut);
    }

    public final synchronized void a(int i) {
        C0844c8 c0844c8 = this.a;
        JSONObject jSONObjectPut = c0844c8.a().put("last_migration_api_level", i);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…GRATION_API_LEVEL, value)");
        c0844c8.a(jSONObjectPut);
    }

    public final synchronized void a(String str, String str2, String str3, Boolean bool, Long l, Long l2, Long l3, Integer num) {
        JSONObject json = new JSONObject().put("device_id", str).put("device_id_hash", str2).put("referrer", str3).put("referrer_checked", bool).put("location_id", l).put("lbs_id", l2).put("location_request_id", l3).put("last_migration_api_level", num);
        C0844c8 c0844c8 = this.a;
        Intrinsics.checkNotNullExpressionValue(json, "json");
        c0844c8.a(json);
    }
}
