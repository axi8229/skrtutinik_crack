package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.yandex.metrica.core.api.ProtobufStateStorage;
import com.yandex.metrica.coreutils.io.FileUtils;
import com.yandex.metrica.impl.ob.C1178pi;
import com.yandex.metrica.impl.ob.C1202qi;
import com.yandex.metrica.impl.ob.C1230s;
import com.yandex.metrica.impl.ob.C1306v3;
import com.yandex.metrica.impl.ob.D1;
import com.yandex.metrica.impl.ob.InterfaceC0921fa;
import com.yandex.metrica.impl.ob.Ud;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.m2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1087m2 extends D1 {
    private final C0895e9 a;
    private final Context b;
    private final C0794a8 c;

    /* renamed from: com.yandex.metrica.impl.ob.m2$a */
    class a extends SparseArray<D1.a> {
        a() {
            put(29, new j(C1087m2.this.b));
            put(39, new k());
            put(47, new l(C1087m2.this.a));
            put(60, new m(C1087m2.this.a));
            put(62, new n());
            put(66, new o());
            put(67, new g(InterfaceC0921fa.b.a(C1202qi.class).b(C1087m2.this.b), new C0920f9(C1020ja.a(C1087m2.this.b).q(), C1087m2.this.b.getPackageName())));
            put(68, new u());
            put(72, new f(InterfaceC0921fa.b.b(Bd.class).b(C1087m2.this.b), InterfaceC0921fa.b.a(C1202qi.class).b(C1087m2.this.b)));
            put(82, new h(InterfaceC0921fa.b.b(Bd.class).b(C1087m2.this.b), InterfaceC0921fa.b.a(C1268td.class).b(C1087m2.this.b)));
            put(87, new i(InterfaceC0921fa.b.a(C1202qi.class).b(C1087m2.this.b)));
            put(92, new c(InterfaceC0921fa.b.a(C1202qi.class).b(C1087m2.this.b)));
            put(93, new e(C1087m2.this.b, InterfaceC0921fa.b.a(C0900ee.class).b(C1087m2.this.b), InterfaceC0921fa.b.a(Ud.class).b(C1087m2.this.b)));
            put(94, new p(C1087m2.this.b, InterfaceC0921fa.b.a(C1202qi.class).b(C1087m2.this.b)));
            put(98, new t(C1087m2.this.a));
            put(100, new b(new C0920f9(C1020ja.a(C1087m2.this.b).q(), C1087m2.this.b.getPackageName())));
            put(101, new q(C1087m2.this.a, InterfaceC0921fa.b.a(C1202qi.class).b(C1087m2.this.b)));
            put(102, new r(InterfaceC0921fa.b.a(Ud.class).b(C1087m2.this.b)));
            put(103, new d(InterfaceC0921fa.b.a(Z1.class).b(C1087m2.this.b), InterfaceC0921fa.b.a(C1306v3.class).b(C1087m2.this.b), C1087m2.this.a));
            put(104, new s(C1020ja.a(C1087m2.this.b).o()));
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$b */
    static class b implements D1.a {
        private final C0920f9 a;

        public b(C0920f9 c0920f9) {
            this.a = c0920f9;
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            this.a.f();
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$c */
    static class c implements D1.a {
        private final ProtobufStateStorage a;

        c(ProtobufStateStorage protobufStateStorage) {
            this.a = protobufStateStorage;
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            C1202qi c1202qi = (C1202qi) this.a.read();
            this.a.save(c1202qi.a(c1202qi.r).g(c1202qi.p).a());
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$d */
    static class d implements D1.a {
        private final ProtobufStateStorage a;
        private final ProtobufStateStorage b;
        private final C0895e9 c;

        public d(ProtobufStateStorage protobufStateStorage, ProtobufStateStorage protobufStateStorage2, C0895e9 c0895e9) {
            this.a = protobufStateStorage;
            this.b = protobufStateStorage2;
            this.c = c0895e9;
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            Z1 z1 = (Z1) this.a.read();
            this.a.delete();
            if (z1.b) {
                if (!A2.b(z1.a)) {
                    C1306v3.a aVar = new C1306v3.a(z1.a, EnumC1279u0.SATELLITE);
                    this.b.save(new C1306v3(aVar, Collections.singletonList(aVar)));
                }
                this.c.h();
            }
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$e */
    static class e implements D1.a {
        private final C0800ae a;
        private final ProtobufStateStorage b;
        private final ProtobufStateStorage c;

        e(Context context, ProtobufStateStorage protobufStateStorage, ProtobufStateStorage protobufStateStorage2) {
            this(protobufStateStorage, protobufStateStorage2, new C0800ae(context));
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            C0900ee c0900eeInvoke;
            C0900ee c0900ee = (C0900ee) this.b.read();
            ArrayList arrayList = new ArrayList();
            EnumC1279u0 enumC1279u0 = c0900ee.e;
            if (enumC1279u0 != EnumC1279u0.UNDEFINED) {
                arrayList.add(new Ud.a(c0900ee.a, c0900ee.b, enumC1279u0));
            }
            if (c0900ee.e == EnumC1279u0.RETAIL && (c0900eeInvoke = this.a.invoke()) != null) {
                arrayList.add(new Ud.a(c0900eeInvoke.a, c0900eeInvoke.b, c0900eeInvoke.e));
            }
            this.c.save(new Ud(c0900ee, arrayList));
            this.b.delete();
        }

        e(ProtobufStateStorage protobufStateStorage, ProtobufStateStorage protobufStateStorage2, C0800ae c0800ae) {
            this.b = protobufStateStorage;
            this.c = protobufStateStorage2;
            this.a = c0800ae;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$f */
    static class f implements D1.a {
        private final ProtobufStateStorage a;
        private final ProtobufStateStorage b;
        private final B0 c;

        public f(ProtobufStateStorage protobufStateStorage, ProtobufStateStorage protobufStateStorage2) {
            this(protobufStateStorage, protobufStateStorage2, new B0());
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            JSONObject jSONObject;
            String strOptString;
            V7 v7H = C1020ja.a(context).h();
            List<Bd> listB = v7H.b();
            if (listB != null) {
                this.a.save(listB);
                v7H.a();
            }
            C1202qi c1202qi = (C1202qi) this.b.read();
            C1202qi.b bVarA = c1202qi.a(c1202qi.r);
            String strOptString2 = null;
            try {
                jSONObject = new JSONObject(L0.a(this.c.b(context.getFilesDir(), "credentials.dat")));
            } catch (Throwable unused) {
                jSONObject = null;
            }
            if (jSONObject == null && FileUtils.needToUseNoBackup()) {
                try {
                    jSONObject = new JSONObject(L0.a(this.c.b(context.getNoBackupFilesDir(), "credentials.dat")));
                } catch (Throwable unused2) {
                }
            }
            if (jSONObject != null) {
                strOptString2 = jSONObject.optString("device_id", null);
                strOptString = jSONObject.optString("device_id_hash", null);
            } else {
                strOptString = null;
            }
            if (!TextUtils.isEmpty(strOptString2)) {
                bVarA.c(strOptString2);
            }
            if (!TextUtils.isEmpty(strOptString)) {
                bVarA.d(strOptString);
            }
            bVarA.b(true);
            this.b.save(bVarA.a());
            context.getSharedPreferences("com.yandex.metrica.configuration", 0).edit().clear().apply();
        }

        f(ProtobufStateStorage protobufStateStorage, ProtobufStateStorage protobufStateStorage2, B0 b0) {
            this.a = protobufStateStorage;
            this.b = protobufStateStorage2;
            this.c = b0;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$g */
    static class g implements D1.a {
        private ProtobufStateStorage a;
        private C0920f9 b;

        public g(ProtobufStateStorage protobufStateStorage, C0920f9 c0920f9) {
            this.a = protobufStateStorage;
            this.b = c0920f9;
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            this.a.save(this.b.g());
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$h */
    static class h implements D1.a {
        private final ProtobufStateStorage a;
        private final ProtobufStateStorage b;

        h(ProtobufStateStorage protobufStateStorage, ProtobufStateStorage protobufStateStorage2) {
            this.a = protobufStateStorage;
            this.b = protobufStateStorage2;
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            this.b.save(new C1268td(new ArrayList((Collection) this.a.read()), null, new ArrayList()));
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$i */
    static class i implements D1.a {
        private final ProtobufStateStorage a;

        i(ProtobufStateStorage protobufStateStorage) {
            this.a = protobufStateStorage;
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            ProtobufStateStorage protobufStateStorage = this.a;
            C1202qi c1202qi = (C1202qi) protobufStateStorage.read();
            protobufStateStorage.save(c1202qi.a(c1202qi.r).b(true).a());
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$j */
    static class j implements D1.a {
        private Pd a;
        private C0920f9 b;

        j(Context context) {
            this.a = new Pd(context);
            this.b = new C0920f9(C1020ja.a(context).p(), context.getPackageName());
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            String strB = this.a.b((String) null);
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            this.b.i(strB).d();
            Pd.b(context);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$k */
    static class k implements D1.a {
        k() {
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            Md md = new Md(context, context.getPackageName());
            SharedPreferences sharedPreferencesA = C0810b.a(context, "_boundentrypreferences");
            Rd rd = Md.H;
            String string = sharedPreferencesA.getString(rd.b(), null);
            Rd rd2 = Md.I;
            long j = sharedPreferencesA.getLong(rd2.b(), -1L);
            if (string == null || j == -1) {
                return;
            }
            md.a(new C1230s.a(string, j)).b();
            sharedPreferencesA.edit().remove(rd.b()).remove(rd2.b()).apply();
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$l */
    static class l implements D1.a {
        private final C0895e9 a;

        l(C0895e9 c0895e9) {
            this.a = c0895e9;
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            C0895e9 c0895e9 = this.a;
            Qd qd = new Qd(context, null);
            if (qd.f()) {
                c0895e9.d(true);
                qd.g();
            }
            C0895e9 c0895e92 = this.a;
            Od od = new Od(context, context.getPackageName());
            long jA = od.a(0);
            if (jA != 0) {
                c0895e92.l(jA);
            }
            od.f();
            new Md(context, new W3(context.getPackageName(), null).b()).i().b();
            this.a.d();
            Hd hd = new Hd(context);
            hd.a();
            hd.b();
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$m */
    static class m implements D1.a {
        private final C0895e9 a;

        m(C0895e9 c0895e9) {
            this.a = c0895e9;
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            boolean z = new C0920f9(C1020ja.a(context).q(), context.getPackageName()).g().u > 0;
            boolean z2 = this.a.b(-1) > 0;
            if (z || z2) {
                this.a.c(false).d();
            }
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$n */
    static class n implements D1.a {
        n() {
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            C0920f9 c0920f9 = new C0920f9(C1020ja.a(context).q(), context.getPackageName());
            String strH = c0920f9.h(null);
            if (strH != null) {
                c0920f9.b(Collections.singletonList(strH));
            }
            String strG = c0920f9.g(null);
            if (strG != null) {
                c0920f9.a(Collections.singletonList(strG));
            }
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$o */
    static class o implements D1.a {
        private final B0 a;

        /* renamed from: com.yandex.metrica.impl.ob.m2$o$a */
        static class a implements FilenameFilter {
            final Iterable<FilenameFilter> a;

            a(Iterable<FilenameFilter> iterable) {
                this.a = iterable;
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                Iterator<FilenameFilter> it = this.a.iterator();
                while (it.hasNext()) {
                    if (it.next().accept(file, str)) {
                        return true;
                    }
                }
                return false;
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.m2$o$b */
        static class b implements FilenameFilter {
            private final FilenameFilter a;

            b(FilenameFilter filenameFilter) {
                this.a = filenameFilter;
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                if (!str.startsWith("db_metrica_")) {
                    return false;
                }
                try {
                    FilenameFilter filenameFilter = this.a;
                    if (str.endsWith("-journal")) {
                        str = str.replace("-journal", "");
                    }
                    return filenameFilter.accept(file, str);
                } catch (Throwable unused) {
                    return false;
                }
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.m2$o$c */
        static class c implements FilenameFilter {
            c() {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.endsWith("null");
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.m2$o$d */
        static class d implements FilenameFilter {
            private final String a;

            d(String str) {
                this.a = str;
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return !str.contains(this.a);
            }
        }

        o() {
            this(new B0());
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            for (File file : b(context) == null ? new File[0] : b(context).listFiles(new a(Arrays.asList(new b(new d(context.getPackageName())), new b(new c()))))) {
                try {
                    if (!file.delete()) {
                        ((C1127nh) C1152oh.a()).reportEvent("Can not delete file", new JSONObject().put("fileName", file.getName()).toString());
                    }
                } catch (Throwable th) {
                    ((C1127nh) C1152oh.a()).reportError("Can not delete file", th);
                }
            }
            new C0920f9(C1020ja.a(context).q(), context.getPackageName()).f(new Rd("LAST_STARTUP_CLIDS_SAVE_TIME", null).a()).d();
        }

        File b(Context context) {
            if (A2.a(21)) {
                return context.getNoBackupFilesDir();
            }
            File filesDir = context.getFilesDir();
            if (filesDir != null) {
                return this.a.b(filesDir.getParentFile(), "databases");
            }
            return null;
        }

        o(B0 b0) {
            this.a = b0;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$r */
    static class r implements D1.a {
        private final ProtobufStateStorage a;

        public r(ProtobufStateStorage protobufStateStorage) {
            this.a = protobufStateStorage;
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            Ud ud = (Ud) this.a.read();
            ArrayList arrayList = new ArrayList();
            Ud.a aVar = null;
            for (Ud.a aVar2 : ud.b) {
                if (aVar2.c != EnumC1279u0.APP) {
                    arrayList.add(aVar2);
                } else if (aVar == null) {
                    arrayList.add(aVar2);
                    aVar = aVar2;
                }
            }
            this.a.save(new Ud(ud.a, arrayList));
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$s */
    static class s implements D1.a {
        private final R7 a;

        public s(R7 r7) {
            this.a = r7;
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            this.a.b("notification_cache_state");
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$t */
    static class t implements D1.a {
        private final C0895e9 a;

        public t(C0895e9 c0895e9) {
            this.a = c0895e9;
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            this.a.f(new Rd("REFERRER", null).a()).f(new Rd("REFERRER_HOLDER_STATE", null).a()).d();
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$u */
    static class u implements D1.a {
        u() {
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            ProtobufStateStorage protobufStateStorageB = InterfaceC0921fa.b.a(C1202qi.class).b(context);
            C1202qi c1202qi = (C1202qi) protobufStateStorageB.read();
            protobufStateStorageB.save(c1202qi.a(c1202qi.r).a(c1202qi.u > 0).b(true).a());
        }
    }

    C1087m2(Context context, C0895e9 c0895e9, C0794a8 c0794a8) {
        this.b = context;
        this.a = c0895e9;
        this.c = c0794a8;
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$q */
    static class q implements D1.a {
        private final C0895e9 a;
        private final ProtobufStateStorage b;
        private final C0794a8 c;
        private final String d;
        private final String e;
        private final String f;
        private final String g;
        private final String h;

        public q(C0895e9 c0895e9, ProtobufStateStorage protobufStateStorage) {
            this(c0895e9, protobufStateStorage, F0.g().w().b());
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            C1202qi c1202qi = (C1202qi) this.b.read();
            Nd nd = new Nd(context);
            int iF = nd.f();
            if (iF == -1) {
                iF = this.a.a(-1);
            }
            this.c.a(c1202qi.b, c1202qi.c, this.a.a(this.d, (String) null), this.a.c(this.e) ? Boolean.valueOf(this.a.a(this.e, false)) : null, this.a.c(this.f) ? Long.valueOf(this.a.a(this.f, -1L)) : null, this.a.c(this.g) ? Long.valueOf(this.a.a(this.g, -1L)) : null, this.a.c(this.h) ? Long.valueOf(this.a.a(this.h, -1L)) : null, iF == -1 ? null : Integer.valueOf(iF));
            this.a.j().f(this.d).f(this.e).f(this.f).f(this.g).f(this.h).d();
            nd.h().b();
        }

        q(C0895e9 c0895e9, ProtobufStateStorage protobufStateStorage, C0794a8 c0794a8) {
            this.d = new Rd("REFERRER_FROM_PLAY_SERVICES").a();
            this.e = new Rd("REFERRER_CHECKED").a();
            this.f = new Rd("L_ID").a();
            this.g = new Rd("LBS_ID").a();
            this.h = new Rd("L_REQ_NUM").a();
            this.a = c0895e9;
            this.b = protobufStateStorage;
            this.c = c0794a8;
        }
    }

    @Override // com.yandex.metrica.impl.ob.D1
    SparseArray<D1.a> a() {
        return new a();
    }

    /* renamed from: com.yandex.metrica.impl.ob.m2$p */
    static class p implements D1.a {
        private final ProtobufStateStorage a;
        private final C0880dj b;

        public p(Context context, ProtobufStateStorage protobufStateStorage) {
            this(protobufStateStorage, C0905ej.a(context).b(context, new C1004ij(new C1178pi.b(context))));
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            String str = this.b.a().a;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            C1202qi c1202qi = (C1202qi) this.a.read();
            if (str.equals(c1202qi.a)) {
                return;
            }
            this.a.save(c1202qi.a(c1202qi.r).k(str).a());
        }

        public p(ProtobufStateStorage protobufStateStorage, C0880dj c0880dj) {
            this.a = protobufStateStorage;
            this.b = c0880dj;
        }
    }

    @Override // com.yandex.metrica.impl.ob.D1
    protected int a(Nd nd) {
        int iF = nd.f();
        if (iF == -1) {
            iF = this.a.a(-1);
        }
        return iF == -1 ? this.c.c() : iF;
    }

    @Override // com.yandex.metrica.impl.ob.D1
    protected void a(Nd nd, int i2) {
        this.c.a(i2);
    }
}
