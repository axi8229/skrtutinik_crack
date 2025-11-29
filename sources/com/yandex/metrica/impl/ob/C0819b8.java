package com.yandex.metrica.impl.ob;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.b8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0819b8 {
    public static final a b = new a(null);
    private final C0844c8 a;

    /* renamed from: com.yandex.metrica.impl.ob.b8$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.b8$b */
    static final class b implements InterfaceC0869d8 {
        public static final b a = new b();

        b() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC0869d8
        public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
            JSONObject jSONObject3;
            JSONObject jSONObject4 = new JSONObject();
            Boolean bool = Boolean.FALSE;
            jSONObject4.put("first_event_done", Tl.a(jSONObject2, "first_event_done", Tl.a(jSONObject, "first_event_done", bool)));
            jSONObject4.put("init_event_done", Tl.a(jSONObject2, "init_event_done", Tl.a(jSONObject, "init_event_done", bool)));
            jSONObject4.put("report_request_id", Tl.a(jSONObject2, "report_request_id", Tl.a(jSONObject, "report_request_id", (Integer) (-1))));
            jSONObject4.put("global_number", Tl.a(jSONObject2, "global_number", Tl.a(jSONObject, "global_number", (Integer) 0)));
            jSONObject4.put("session_id", Tl.a(jSONObject2, "session_id", Tl.a(jSONObject, "session_id", (Long) (-1L))));
            jSONObject4.put("referrer_handled", Tl.a(jSONObject2, "referrer_handled", Tl.a(jSONObject, "referrer_handled", bool)));
            JSONObject jSONObject5 = null;
            if (jSONObject.has("numbers_of_type")) {
                try {
                    jSONObject3 = jSONObject.getJSONObject("numbers_of_type");
                } catch (Throwable unused) {
                }
            } else {
                jSONObject3 = null;
            }
            if (jSONObject2.has("numbers_of_type")) {
                try {
                    jSONObject5 = jSONObject2.getJSONObject("numbers_of_type");
                } catch (Throwable unused2) {
                }
            }
            if (jSONObject5 != null) {
                jSONObject3 = jSONObject5;
            }
            jSONObject4.put("numbers_of_type", jSONObject3);
            jSONObject4.put("open_id", Tl.a(jSONObject2, "open_id", Tl.a(jSONObject, "open_id", (Integer) 1)));
            jSONObject4.put("attribution_id", Tl.a(jSONObject2, "attribution_id", Tl.a(jSONObject, "attribution_id", (Integer) 1)));
            jSONObject4.put("last_migration_api_level", Tl.a(jSONObject2, "last_migration_api_level", Tl.a(jSONObject, "last_migration_api_level", (Integer) 0)));
            return jSONObject4;
        }
    }

    public C0819b8(InterfaceC0919f8 interfaceC0919f8, InterfaceC0919f8 interfaceC0919f82, String str) {
        this.a = new C0844c8(interfaceC0919f8, interfaceC0919f82, "[VitalComponentDataProvider-" + str + ']', b.a);
    }

    public final synchronized void a(boolean z) {
        C0844c8 c0844c8 = this.a;
        JSONObject jSONObjectPut = c0844c8.a().put("first_event_done", z);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…(FIRST_EVENT_DONE, value)");
        c0844c8.a(jSONObjectPut);
    }

    public final synchronized void b(boolean z) {
        C0844c8 c0844c8 = this.a;
        JSONObject jSONObjectPut = c0844c8.a().put("init_event_done", z);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…t(INIT_EVENT_DONE, value)");
        c0844c8.a(jSONObjectPut);
    }

    public final synchronized void c(int i) {
        C0844c8 c0844c8 = this.a;
        JSONObject jSONObjectPut = c0844c8.a().put("report_request_id", i);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…REPORT_REQUEST_ID, value)");
        c0844c8.a(jSONObjectPut);
    }

    public final synchronized JSONObject d() {
        return this.a.a().optJSONObject("numbers_of_type");
    }

    public final synchronized int e() {
        return this.a.a().optInt("open_id", 1);
    }

    public final synchronized boolean f() {
        return this.a.a().optBoolean("referrer_handled", false);
    }

    public final synchronized int g() {
        return this.a.a().optInt("report_request_id", -1);
    }

    public final synchronized long h() {
        return this.a.a().optLong("session_id", -1L);
    }

    public final synchronized void i() {
        synchronized (this) {
        }
        int iOptInt = this.a.a().optInt("attribution_id", 1) + 1;
        synchronized (this) {
            C0844c8 c0844c8 = this.a;
            JSONObject jSONObjectPut = c0844c8.a().put("attribution_id", iOptInt);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…EY_ATTRIBUTION_ID, value)");
            c0844c8.a(jSONObjectPut);
        }
    }

    public final synchronized void j() {
        synchronized (this) {
        }
        int iOptInt = this.a.a().optInt("open_id", 1) + 1;
        synchronized (this) {
            C0844c8 c0844c8 = this.a;
            JSONObject jSONObjectPut = c0844c8.a().put("open_id", iOptInt);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…).put(KEY_OPEN_ID, value)");
            c0844c8.a(jSONObjectPut);
        }
    }

    public final synchronized boolean k() {
        return this.a.a().optBoolean("first_event_done", false);
    }

    public final synchronized boolean l() {
        return this.a.a().optBoolean("init_event_done", false);
    }

    public final synchronized void a(int i) {
        C0844c8 c0844c8 = this.a;
        JSONObject jSONObjectPut = c0844c8.a().put("global_number", i);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…KEY_GLOBAL_NUMBER, value)");
        c0844c8.a(jSONObjectPut);
    }

    public final synchronized int b() {
        return this.a.a().optInt("global_number", 0);
    }

    public final synchronized void c(boolean z) {
        C0844c8 c0844c8 = this.a;
        JSONObject jSONObjectPut = c0844c8.a().put("referrer_handled", z);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…_REFERRER_HANDLED, value)");
        c0844c8.a(jSONObjectPut);
    }

    public final synchronized void a(long j) {
        C0844c8 c0844c8 = this.a;
        JSONObject jSONObjectPut = c0844c8.a().put("session_id", j);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…ut(KEY_SESSION_ID, value)");
        c0844c8.a(jSONObjectPut);
    }

    public final synchronized void b(int i) {
        C0844c8 c0844c8 = this.a;
        JSONObject jSONObjectPut = c0844c8.a().put("last_migration_api_level", i);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…GRATION_API_LEVEL, value)");
        c0844c8.a(jSONObjectPut);
    }

    public final synchronized int c() {
        return this.a.a().optInt("last_migration_api_level", 0);
    }

    public final synchronized void a(JSONObject jSONObject) {
        C0844c8 c0844c8 = this.a;
        JSONObject jSONObjectPut = c0844c8.a().put("numbers_of_type", jSONObject);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "vitalDataProvider.getOrL…Y_NUMBERS_OF_TYPE, value)");
        c0844c8.a(jSONObjectPut);
    }

    public final synchronized int a() {
        return this.a.a().optInt("attribution_id", 1);
    }

    public final synchronized void a(boolean z, boolean z2, Integer num, Integer num2, Long l, Boolean bool, JSONObject jSONObject, Integer num3, Integer num4, Integer num5) {
        JSONObject json = new JSONObject().put("first_event_done", z).put("init_event_done", z2).put("report_request_id", num).put("global_number", num2).put("session_id", l).put("referrer_handled", bool).put("open_id", num3).put("attribution_id", num4).put("numbers_of_type", jSONObject).put("last_migration_api_level", num5);
        C0844c8 c0844c8 = this.a;
        Intrinsics.checkNotNullExpressionValue(json, "json");
        c0844c8.a(json);
    }
}
