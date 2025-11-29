package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.google.protobuf.nano.ym.MessageNano;
import com.yandex.metrica.impl.ob.C1147oc;
import com.yandex.metrica.impl.ob.C1199qf;
import com.yandex.metrica.impl.ob.E;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class J1 {
    private static Map<EnumC0917f6, Integer> a;
    private static SparseArray<EnumC0917f6> b;
    private static final Map<EnumC0787a1, Integer> c;
    private static final Map<EnumC0787a1, C1221re> d;
    public static final /* synthetic */ int e = 0;

    class a implements Ge {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.Ge
        public byte[] a(C1198qe c1198qe, Lg lg) {
            if (!TextUtils.isEmpty(c1198qe.b)) {
                try {
                    C0877dg c0877dgA = C0877dg.a(Base64.decode(c1198qe.b, 0));
                    C1246sf c1246sf = new C1246sf();
                    String str = c0877dgA.a;
                    c1246sf.a = str == null ? new byte[0] : str.getBytes();
                    c1246sf.c = c0877dgA.b;
                    c1246sf.b = c0877dgA.c;
                    int iOrdinal = c0877dgA.d.ordinal();
                    int i = 1;
                    if (iOrdinal != 1) {
                        i = 2;
                        if (iOrdinal != 2) {
                            i = 0;
                        }
                    }
                    c1246sf.d = i;
                    return MessageNano.toByteArray(c1246sf);
                } catch (Throwable unused) {
                }
            }
            return new byte[0];
        }
    }

    class b implements InterfaceC1245se {
        b() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1245se
        public Integer a(C1198qe c1198qe) {
            return c1198qe.k;
        }
    }

    static {
        HashMap map = new HashMap();
        EnumC0917f6 enumC0917f6 = EnumC0917f6.FOREGROUND;
        map.put(enumC0917f6, 0);
        EnumC0917f6 enumC0917f62 = EnumC0917f6.BACKGROUND;
        map.put(enumC0917f62, 1);
        a = Collections.unmodifiableMap(map);
        SparseArray<EnumC0917f6> sparseArray = new SparseArray<>();
        sparseArray.put(0, enumC0917f6);
        sparseArray.put(1, enumC0917f62);
        b = sparseArray;
        HashMap map2 = new HashMap();
        EnumC0787a1 enumC0787a1 = EnumC0787a1.EVENT_TYPE_INIT;
        map2.put(enumC0787a1, 1);
        EnumC0787a1 enumC0787a12 = EnumC0787a1.EVENT_TYPE_REGULAR;
        map2.put(enumC0787a12, 4);
        EnumC0787a1 enumC0787a13 = EnumC0787a1.EVENT_TYPE_SEND_REFERRER;
        map2.put(enumC0787a13, 5);
        EnumC0787a1 enumC0787a14 = EnumC0787a1.EVENT_TYPE_ALIVE;
        map2.put(enumC0787a14, 7);
        EnumC0787a1 enumC0787a15 = EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED;
        map2.put(enumC0787a15, 3);
        EnumC0787a1 enumC0787a16 = EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        map2.put(enumC0787a16, 26);
        EnumC0787a1 enumC0787a17 = EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT;
        map2.put(enumC0787a17, 26);
        EnumC0787a1 enumC0787a18 = EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        map2.put(enumC0787a18, 26);
        EnumC0787a1 enumC0787a19 = EnumC0787a1.EVENT_TYPE_ANR;
        map2.put(enumC0787a19, 25);
        EnumC0787a1 enumC0787a110 = EnumC0787a1.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH;
        map2.put(enumC0787a110, 3);
        EnumC0787a1 enumC0787a111 = EnumC0787a1.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        map2.put(enumC0787a111, 26);
        EnumC0787a1 enumC0787a112 = EnumC0787a1.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH;
        map2.put(enumC0787a112, 3);
        EnumC0787a1 enumC0787a113 = EnumC0787a1.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        map2.put(enumC0787a113, 26);
        EnumC0787a1 enumC0787a114 = EnumC0787a1.EVENT_TYPE_CURRENT_SESSION_CRASHPAD_CRASH_PROTOBUF;
        map2.put(enumC0787a114, 26);
        EnumC0787a1 enumC0787a115 = EnumC0787a1.EVENT_TYPE_API_NATIVE_CRASH_PROTOBUF;
        map2.put(enumC0787a115, 26);
        EnumC0787a1 enumC0787a116 = EnumC0787a1.EVENT_TYPE_EXCEPTION_USER;
        map2.put(enumC0787a116, 6);
        EnumC0787a1 enumC0787a117 = EnumC0787a1.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        map2.put(enumC0787a117, 27);
        EnumC0787a1 enumC0787a118 = EnumC0787a1.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        map2.put(enumC0787a118, 27);
        EnumC0787a1 enumC0787a119 = EnumC0787a1.EVENT_TYPE_IDENTITY;
        map2.put(enumC0787a119, 8);
        map2.put(EnumC0787a1.EVENT_TYPE_IDENTITY_LIGHT, 28);
        EnumC0787a1 enumC0787a120 = EnumC0787a1.EVENT_TYPE_STATBOX;
        map2.put(enumC0787a120, 11);
        EnumC0787a1 enumC0787a121 = EnumC0787a1.EVENT_TYPE_SET_USER_INFO;
        map2.put(enumC0787a121, 12);
        EnumC0787a1 enumC0787a122 = EnumC0787a1.EVENT_TYPE_REPORT_USER_INFO;
        map2.put(enumC0787a122, 12);
        EnumC0787a1 enumC0787a123 = EnumC0787a1.EVENT_TYPE_FIRST_ACTIVATION;
        map2.put(enumC0787a123, 13);
        EnumC0787a1 enumC0787a124 = EnumC0787a1.EVENT_TYPE_START;
        map2.put(enumC0787a124, 2);
        EnumC0787a1 enumC0787a125 = EnumC0787a1.EVENT_TYPE_APP_OPEN;
        map2.put(enumC0787a125, 16);
        EnumC0787a1 enumC0787a126 = EnumC0787a1.EVENT_TYPE_APP_UPDATE;
        map2.put(enumC0787a126, 17);
        EnumC0787a1 enumC0787a127 = EnumC0787a1.EVENT_TYPE_PERMISSIONS;
        map2.put(enumC0787a127, 18);
        EnumC0787a1 enumC0787a128 = EnumC0787a1.EVENT_TYPE_APP_FEATURES;
        map2.put(enumC0787a128, 19);
        EnumC0787a1 enumC0787a129 = EnumC0787a1.EVENT_TYPE_SEND_USER_PROFILE;
        map2.put(enumC0787a129, 20);
        EnumC0787a1 enumC0787a130 = EnumC0787a1.EVENT_TYPE_SEND_REVENUE_EVENT;
        map2.put(enumC0787a130, 21);
        EnumC0787a1 enumC0787a131 = EnumC0787a1.EVENT_TYPE_SEND_AD_REVENUE_EVENT;
        map2.put(enumC0787a131, 40);
        EnumC0787a1 enumC0787a132 = EnumC0787a1.EVENT_TYPE_SEND_ECOMMERCE_EVENT;
        map2.put(enumC0787a132, 35);
        map2.put(EnumC0787a1.EVENT_TYPE_CLEANUP, 29);
        EnumC0787a1 enumC0787a133 = EnumC0787a1.EVENT_TYPE_VIEW_TREE;
        map2.put(enumC0787a133, 30);
        EnumC0787a1 enumC0787a134 = EnumC0787a1.EVENT_TYPE_RAW_VIEW_TREE;
        map2.put(enumC0787a134, 34);
        EnumC0787a1 enumC0787a135 = EnumC0787a1.EVENT_TYPE_STATBOX_EXP;
        map2.put(enumC0787a135, 36);
        EnumC0787a1 enumC0787a136 = EnumC0787a1.EVENT_TYPE_WEBVIEW_SYNC;
        map2.put(enumC0787a136, 38);
        c = Collections.unmodifiableMap(map2);
        HashMap map3 = new HashMap();
        C1099me c1099me = new C1099me();
        C1174pe c1174pe = new C1174pe();
        C1124ne c1124ne = new C1124ne();
        C1024je c1024je = new C1024je();
        Fe fe = new Fe();
        Be be = new Be();
        C1221re c1221reA = C1221re.a().a((Ge) be).a((InterfaceC1149oe) be).a();
        C1221re c1221reA2 = C1221re.a().a(c1174pe).a();
        C1221re c1221reA3 = C1221re.a().a(c1024je).a();
        C1221re c1221reA4 = C1221re.a().a(fe).a();
        C1221re c1221reA5 = C1221re.a().a(c1099me).a();
        C1221re c1221reA6 = C1221re.a().a(new He()).a();
        map3.put(enumC0787a12, c1221reA2);
        map3.put(enumC0787a13, C1221re.a().a(new a()).a());
        map3.put(enumC0787a14, C1221re.a().a(c1099me).a(c1124ne).a(new C1049ke()).a(new C1074le()).a());
        map3.put(enumC0787a110, c1221reA);
        map3.put(enumC0787a112, c1221reA);
        map3.put(enumC0787a111, c1221reA);
        map3.put(enumC0787a113, c1221reA);
        map3.put(enumC0787a114, c1221reA);
        map3.put(enumC0787a115, c1221reA);
        map3.put(enumC0787a116, c1221reA2);
        map3.put(enumC0787a117, c1221reA3);
        map3.put(enumC0787a118, c1221reA3);
        map3.put(enumC0787a119, C1221re.a().a(c1174pe).a(new C1341we()).a());
        map3.put(enumC0787a120, c1221reA2);
        map3.put(enumC0787a121, c1221reA2);
        map3.put(enumC0787a122, c1221reA2);
        map3.put(enumC0787a15, c1221reA2);
        map3.put(enumC0787a16, c1221reA3);
        map3.put(enumC0787a17, c1221reA3);
        map3.put(enumC0787a18, c1221reA3);
        map3.put(enumC0787a19, c1221reA3);
        map3.put(enumC0787a124, C1221re.a().a(new C1099me()).a(c1024je).a());
        map3.put(EnumC0787a1.EVENT_TYPE_CUSTOM_EVENT, C1221re.a().a(new b()).a());
        map3.put(enumC0787a125, c1221reA2);
        map3.put(enumC0787a127, c1221reA5);
        map3.put(enumC0787a128, c1221reA5);
        map3.put(enumC0787a129, c1221reA3);
        map3.put(enumC0787a130, c1221reA3);
        map3.put(enumC0787a131, c1221reA3);
        map3.put(enumC0787a132, c1221reA4);
        map3.put(enumC0787a133, c1221reA2);
        map3.put(enumC0787a134, c1221reA2);
        map3.put(enumC0787a1, c1221reA6);
        map3.put(enumC0787a126, c1221reA6);
        map3.put(enumC0787a123, c1221reA2);
        map3.put(enumC0787a135, c1221reA2);
        map3.put(enumC0787a136, c1221reA2);
        d = Collections.unmodifiableMap(map3);
    }

    public static C1199qf.f a(ContentValues contentValues) {
        Long asLong = contentValues.getAsLong("start_time");
        Long asLong2 = contentValues.getAsLong("server_time_offset");
        Boolean asBoolean = contentValues.getAsBoolean("obtained_before_first_sync");
        C1199qf.f fVar = new C1199qf.f();
        if (asLong != null) {
            fVar.a = asLong.longValue();
            fVar.b = ((GregorianCalendar) Calendar.getInstance()).getTimeZone().getOffset(asLong.longValue() * 1000) / 1000;
        }
        if (asLong2 != null) {
            fVar.c = asLong2.longValue();
        }
        if (asBoolean != null) {
            fVar.d = asBoolean.booleanValue();
        }
        return fVar;
    }

    public static C1150of[] b(JSONArray jSONArray) {
        try {
            C1150of[] c1150ofArr = new C1150of[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        c1150ofArr[i] = b(jSONObjectOptJSONObject);
                    }
                } catch (Throwable unused) {
                    return c1150ofArr;
                }
            }
            return c1150ofArr;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static C1150of b(JSONObject jSONObject) {
        C1150of c1150of = new C1150of();
        int iOptInt = jSONObject.optInt("signal_strength", c1150of.b);
        if (iOptInt != -1) {
            c1150of.b = iOptInt;
        }
        c1150of.a = jSONObject.optInt("cell_id", c1150of.a);
        c1150of.c = jSONObject.optInt("lac", c1150of.c);
        c1150of.d = jSONObject.optInt("country_code", c1150of.d);
        c1150of.e = jSONObject.optInt("operator_id", c1150of.e);
        c1150of.f = jSONObject.optString("operator_name", c1150of.f);
        c1150of.g = jSONObject.optBoolean("is_connected", c1150of.g);
        c1150of.h = jSONObject.optInt("cell_type", 0);
        c1150of.i = jSONObject.optInt("pci", c1150of.i);
        c1150of.j = jSONObject.optLong("last_visible_time_offset", c1150of.j);
        c1150of.k = jSONObject.optInt("lte_rsrq", c1150of.k);
        c1150of.l = jSONObject.optInt("lte_rssnr", c1150of.l);
        c1150of.n = jSONObject.optInt("arfcn", c1150of.n);
        c1150of.m = jSONObject.optInt("lte_rssi", c1150of.m);
        c1150of.o = jSONObject.optInt("lte_bandwidth", c1150of.o);
        c1150of.p = jSONObject.optInt("lte_cqi", c1150of.p);
        return c1150of;
    }

    static EnumC0917f6 a(int i) {
        EnumC0917f6 enumC0917f6 = b.get(i);
        return enumC0917f6 == null ? EnumC0917f6.FOREGROUND : enumC0917f6;
    }

    public static C1222rf[] a(JSONArray jSONArray) {
        try {
            C1222rf[] c1222rfArr = new C1222rf[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    c1222rfArr[i] = a(jSONArray.getJSONObject(i));
                } catch (Throwable unused) {
                    return c1222rfArr;
                }
            }
            return c1222rfArr;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static C1222rf a(JSONObject jSONObject) {
        try {
            C1222rf c1222rf = new C1222rf();
            c1222rf.a = jSONObject.getString("mac");
            c1222rf.b = jSONObject.getInt("signal_strength");
            c1222rf.c = jSONObject.getString("ssid");
            c1222rf.d = jSONObject.optBoolean("is_connected");
            c1222rf.e = jSONObject.optLong("last_visible_offset_seconds", 0L);
            return c1222rf;
        } catch (Throwable unused) {
            C1222rf c1222rf2 = new C1222rf();
            c1222rf2.a = jSONObject.optString("mac");
            return c1222rf2;
        }
    }

    public static Integer b(EnumC0787a1 enumC0787a1) {
        if (enumC0787a1 == null) {
            return null;
        }
        return c.get(enumC0787a1);
    }

    static int a(EnumC0917f6 enumC0917f6) {
        Integer num = a.get(enumC0917f6);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static C1221re a(EnumC0787a1 enumC0787a1) {
        C1221re c1221re = enumC0787a1 != null ? d.get(enumC0787a1) : null;
        return c1221re == null ? C1221re.b() : c1221re;
    }

    public static int a(E.b.a aVar) {
        int iOrdinal = aVar.ordinal();
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                i = 3;
                if (iOrdinal != 3) {
                    i = 4;
                    if (iOrdinal != 4) {
                        return 0;
                    }
                }
            }
        }
        return i;
    }

    public static int a(C1147oc.a aVar) {
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 1) {
            return 0;
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? 3 : 2;
        }
        return 1;
    }
}
