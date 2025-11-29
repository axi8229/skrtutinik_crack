package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Pair;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.protobuf.nano.ym.MessageNano;
import com.yandex.metrica.coreutils.collection.CollectionUtils;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.impl.ob.C1398z;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.c0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0836c0 implements Parcelable {
    public static final Parcelable.Creator<C0836c0> CREATOR = new a();
    String a;
    String b;
    private String c;
    private String d;
    int e;
    int f;
    private Pair<String, String> g;
    int h;
    private String i;
    private long j;
    private long k;
    private D0 l;
    private EnumC1375y0 m;
    private Bundle n;
    private Boolean o;
    private Integer p;
    private Map<String, byte[]> q;

    /* renamed from: com.yandex.metrica.impl.ob.c0$a */
    class a implements Parcelable.Creator<C0836c0> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public C0836c0 createFromParcel(Parcel parcel) {
            Bundle bundle = parcel.readBundle(ResultReceiverC0911f0.class.getClassLoader());
            EnumC1375y0 enumC1375y0A = bundle.containsKey("CounterReport.Source") ? EnumC1375y0.a(bundle.getInt("CounterReport.Source")) : null;
            C0836c0 c0836c0 = new C0836c0();
            c0836c0.e = bundle.getInt("CounterReport.Type", EnumC0787a1.EVENT_TYPE_UNDEFINED.b());
            c0836c0.f = bundle.getInt("CounterReport.CustomType");
            String string = bundle.getString("CounterReport.Value");
            if (string == null) {
                string = "";
            }
            c0836c0.b = string;
            C0836c0 c0836c0A = C0836c0.a(c0836c0.e(bundle.getString("CounterReport.UserInfo")).c(bundle.getString("CounterReport.Environment")).b(bundle.getString("CounterReport.Event")), (bundle.containsKey("CounterReport.AppEnvironmentDiffKey") && bundle.containsKey("CounterReport.AppEnvironmentDiffValue")) ? new Pair(bundle.getString("CounterReport.AppEnvironmentDiffKey"), bundle.getString("CounterReport.AppEnvironmentDiffValue")) : null);
            c0836c0A.h = bundle.getInt("CounterReport.TRUNCATED");
            return c0836c0A.d(bundle.getString("CounterReport.ProfileID")).a(bundle.getLong("CounterReport.CreationElapsedRealtime")).b(bundle.getLong("CounterReport.CreationTimestamp")).a(D0.a(Integer.valueOf(bundle.getInt("CounterReport.UniquenessStatus")))).a(enumC1375y0A).c(bundle.getBundle("CounterReport.Payload")).a(bundle.containsKey("CounterReport.AttributionIdChanged") ? Boolean.valueOf(bundle.getBoolean("CounterReport.AttributionIdChanged")) : null).a(bundle.containsKey("CounterReport.OpenId") ? Integer.valueOf(bundle.getInt("CounterReport.OpenId")) : null).a(CollectionUtils.bundleToMap(bundle.getBundle("CounterReport.Extras")));
        }

        @Override // android.os.Parcelable.Creator
        public C0836c0[] newArray(int i) {
            return new C0836c0[i];
        }
    }

    public C0836c0() {
        this("", 0);
    }

    public C0836c0 a(byte[] bArr) {
        this.b = new String(Base64.encode(bArr, 0));
        return this;
    }

    public C0836c0 b(String str) {
        this.a = str;
        return this;
    }

    public C0836c0 c(String str) {
        this.d = str;
        return this;
    }

    public int d() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public C0836c0 e(String str) {
        this.c = str;
        return this;
    }

    public C0836c0 f(String str) {
        this.b = str;
        return this;
    }

    public String g() {
        return this.a;
    }

    public String h() {
        return this.d;
    }

    public Map<String, byte[]> i() {
        return this.q;
    }

    public D0 j() {
        return this.l;
    }

    public Integer k() {
        return this.p;
    }

    public Bundle l() {
        return this.n;
    }

    public String m() {
        return this.i;
    }

    public EnumC1375y0 n() {
        return this.m;
    }

    public int o() {
        return this.e;
    }

    public String p() {
        return this.c;
    }

    public String q() {
        return this.b;
    }

    public byte[] r() {
        return Base64.decode(this.b, 0);
    }

    public String toString() {
        return String.format(Locale.US, "[event: %s, type: %s, value: %s]", this.a, EnumC0787a1.a(this.e).a(), A2.a(this.b, 500));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("CounterReport.Event", this.a);
        bundle.putString("CounterReport.Value", this.b);
        bundle.putInt("CounterReport.Type", this.e);
        bundle.putInt("CounterReport.CustomType", this.f);
        bundle.putInt("CounterReport.TRUNCATED", this.h);
        bundle.putString("CounterReport.ProfileID", this.i);
        bundle.putInt("CounterReport.UniquenessStatus", this.l.a);
        Bundle bundle2 = this.n;
        if (bundle2 != null) {
            bundle.putParcelable("CounterReport.Payload", bundle2);
        }
        String str = this.d;
        if (str != null) {
            bundle.putString("CounterReport.Environment", str);
        }
        String str2 = this.c;
        if (str2 != null) {
            bundle.putString("CounterReport.UserInfo", str2);
        }
        Pair<String, String> pair = this.g;
        if (pair != null) {
            bundle.putString("CounterReport.AppEnvironmentDiffKey", (String) pair.first);
            bundle.putString("CounterReport.AppEnvironmentDiffValue", (String) pair.second);
        }
        bundle.putLong("CounterReport.CreationElapsedRealtime", this.j);
        bundle.putLong("CounterReport.CreationTimestamp", this.k);
        EnumC1375y0 enumC1375y0 = this.m;
        if (enumC1375y0 != null) {
            bundle.putInt("CounterReport.Source", enumC1375y0.a);
        }
        Boolean bool = this.o;
        if (bool != null) {
            bundle.putBoolean("CounterReport.AttributionIdChanged", bool.booleanValue());
        }
        Integer num = this.p;
        if (num != null) {
            bundle.putInt("CounterReport.OpenId", num.intValue());
        }
        bundle.putBundle("CounterReport.Extras", CollectionUtils.mapToBundle(this.q));
        parcel.writeBundle(bundle);
    }

    public C0836c0(String str, int i) {
        this("", str, i);
    }

    public C0836c0 a(int i) {
        this.e = i;
        return this;
    }

    public Pair<String, String> b() {
        return this.g;
    }

    protected C0836c0 c(Bundle bundle) {
        this.n = bundle;
        return this;
    }

    public C0836c0 d(String str) {
        this.i = str;
        return this;
    }

    public long e() {
        return this.j;
    }

    public long f() {
        return this.k;
    }

    public C0836c0(String str, String str2, int i) {
        this(str, str2, i, new SystemTimeProvider());
    }

    private static C0836c0 d(C0836c0 c0836c0) {
        C0836c0 c0836c02 = new C0836c0();
        c0836c02.k = c0836c0.k;
        c0836c02.j = c0836c0.j;
        c0836c02.c = c0836c0.c;
        c0836c02.g = c0836c0.g;
        c0836c02.d = c0836c0.d;
        c0836c02.n = c0836c0.n;
        c0836c02.q = c0836c0.q;
        c0836c02.i = c0836c0.i;
        return c0836c02;
    }

    public static C0836c0 e(C0836c0 c0836c0) {
        return a(c0836c0, EnumC0787a1.EVENT_TYPE_APP_UPDATE);
    }

    C0836c0 a(String str, String str2) {
        if (this.g == null) {
            this.g = new Pair<>(str, str2);
        }
        return this;
    }

    protected C0836c0 b(long j) {
        this.k = j;
        return this;
    }

    public Boolean c() {
        return this.o;
    }

    public C0836c0(String str, String str2, int i, SystemTimeProvider systemTimeProvider) {
        this.l = D0.UNKNOWN;
        this.q = new HashMap();
        this.a = str2;
        this.e = i;
        this.b = str;
        this.j = systemTimeProvider.elapsedRealtime();
        this.k = systemTimeProvider.currentTimeMillis();
    }

    public static C0836c0 c(C0836c0 c0836c0) {
        return a(c0836c0, EnumC0787a1.EVENT_TYPE_INIT);
    }

    Bundle b(Bundle bundle) {
        bundle.putParcelable("CounterReport.Object", this);
        return bundle;
    }

    static C0836c0 a(C0836c0 c0836c0, Pair pair) {
        c0836c0.g = pair;
        return c0836c0;
    }

    public static C0836c0 b(C0836c0 c0836c0) {
        return a(c0836c0, EnumC0787a1.EVENT_TYPE_FIRST_ACTIVATION);
    }

    protected C0836c0 a(long j) {
        this.j = j;
        return this;
    }

    public C0836c0 a(D0 d0) {
        this.l = d0;
        return this;
    }

    public C0836c0 a(EnumC1375y0 enumC1375y0) {
        this.m = enumC1375y0;
        return this;
    }

    public C0836c0 a(Boolean bool) {
        this.o = bool;
        return this;
    }

    public C0836c0 a(Integer num) {
        this.p = num;
        return this;
    }

    public C0836c0 a(Map<String, byte[]> map) {
        this.q = map;
        return this;
    }

    public static C0836c0 a(Bundle bundle) {
        if (bundle != null) {
            try {
                C0836c0 c0836c0 = (C0836c0) bundle.getParcelable("CounterReport.Object");
                if (c0836c0 != null) {
                    return c0836c0;
                }
            } catch (Throwable unused) {
                return new C0836c0();
            }
        }
        return new C0836c0();
    }

    private static C0836c0 a(C0836c0 c0836c0, EnumC0787a1 enumC0787a1) {
        C0836c0 c0836c0D = d(c0836c0);
        c0836c0D.e = enumC0787a1.b();
        return c0836c0D;
    }

    public static C0836c0 a(C0836c0 c0836c0) {
        return a(c0836c0, EnumC0787a1.EVENT_TYPE_ALIVE);
    }

    public static C0836c0 a(C0836c0 c0836c0, A0 a0) {
        C0836c0 c0836c0A = a(c0836c0, EnumC0787a1.EVENT_TYPE_START);
        String strA = a0.a();
        C1125nf c1125nf = new C1125nf();
        if (strA != null) {
            c1125nf.a = strA.getBytes();
        }
        c0836c0A.a(MessageNano.toByteArray(c1125nf));
        c0836c0A.k = c0836c0.k;
        c0836c0A.j = c0836c0.j;
        return c0836c0A;
    }

    public static C0836c0 a(C0836c0 c0836c0, L3 l3) {
        Context contextG = l3.g();
        Y0 y0C = new Y0(contextG, new C1184q0(contextG)).c();
        try {
            y0C.b();
        } catch (Throwable unused) {
        }
        C0836c0 c0836c0D = d(c0836c0);
        c0836c0D.e = EnumC0787a1.EVENT_TYPE_IDENTITY.b();
        c0836c0D.b = y0C.a();
        return c0836c0D;
    }

    public static C0836c0 a(C0836c0 c0836c0, Collection<Bd> collection, C1398z c1398z, C1302v c1302v, List<String> list) {
        String string;
        String str;
        C0836c0 c0836c0D = d(c0836c0);
        try {
            JSONArray jSONArray = new JSONArray();
            for (Bd bd : collection) {
                jSONArray.put(new JSONObject().put(AppMeasurementSdk.ConditionalUserProperty.NAME, bd.a).put("granted", bd.b));
            }
            JSONObject jSONObject = new JSONObject();
            if (c1398z != null) {
                jSONObject.put("background_restricted", c1398z.b);
                C1398z.a aVar = c1398z.a;
                c1302v.getClass();
                if (aVar != null) {
                    int iOrdinal = aVar.ordinal();
                    if (iOrdinal == 0) {
                        str = "ACTIVE";
                    } else if (iOrdinal == 1) {
                        str = "WORKING_SET";
                    } else if (iOrdinal == 2) {
                        str = "FREQUENT";
                    } else if (iOrdinal == 3) {
                        str = "RARE";
                    } else if (iOrdinal == 4) {
                        str = "RESTRICTED";
                    }
                    jSONObject.put("app_standby_bucket", str);
                }
                str = null;
                jSONObject.put("app_standby_bucket", str);
            }
            string = new JSONObject().put("permissions", jSONArray).put("background_restrictions", jSONObject).put("available_providers", new JSONArray((Collection) list)).toString();
        } catch (Throwable unused) {
            string = "";
        }
        c0836c0D.e = EnumC0787a1.EVENT_TYPE_PERMISSIONS.b();
        c0836c0D.b = string;
        return c0836c0D;
    }

    public static C0836c0 a(C0836c0 c0836c0, String str) {
        C0836c0 c0836c0D = d(c0836c0);
        c0836c0D.e = EnumC0787a1.EVENT_TYPE_APP_FEATURES.b();
        c0836c0D.b = str;
        return c0836c0D;
    }

    public static C0836c0 a() {
        C0836c0 c0836c0 = new C0836c0();
        c0836c0.e = EnumC0787a1.EVENT_TYPE_SEND_REVENUE_EVENT.b();
        return c0836c0;
    }

    public static C0836c0 a(String str) {
        C0836c0 c0836c0 = new C0836c0();
        c0836c0.e = EnumC0787a1.EVENT_TYPE_WEBVIEW_SYNC.b();
        c0836c0.b = str;
        c0836c0.m = EnumC1375y0.JS;
        return c0836c0;
    }
}
