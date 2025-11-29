package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.yandex.metrica.core.api.ProtobufStateStorage;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.coreutils.services.ActivationBarrier;
import com.yandex.metrica.impl.ob.C0829bi;
import com.yandex.metrica.impl.ob.H1;
import com.yandex.metrica.network.NetworkClient;
import com.yandex.metrica.network.Request;
import com.yandex.metrica.network.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class Jf {
    private static final Map<C0829bi.a, H1.d> i = Collections.unmodifiableMap(new a());
    private final Context a;
    private final ProtobufStateStorage b;
    private final ICommonExecutor c;
    private final C1052kh d;
    private final C1233s2 e;
    private final Rl f;
    private e g;
    private boolean h = false;

    class a extends HashMap<C0829bi.a, H1.d> {
        a() {
            put(C0829bi.a.CELL, H1.d.CELL);
            put(C0829bi.a.WIFI, H1.d.WIFI);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Jf.a(Jf.this);
        }
    }

    class c implements Runnable {
        final /* synthetic */ List a;
        final /* synthetic */ C1178pi b;

        c(List list, C1178pi c1178pi) {
            this.a = list;
            this.b = c1178pi;
        }

        @Override // java.lang.Runnable
        public void run() {
            Jf.a(Jf.this, this.a, this.b.C());
        }
    }

    class d implements Runnable {
        final /* synthetic */ e.a a;

        d(e.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Jf.this.e.e()) {
                return;
            }
            Jf.this.d.b(this.a);
            e.b bVar = new e.b(this.a);
            Rl rl = Jf.this.f;
            Context context = Jf.this.a;
            ((Ml) rl).getClass();
            H1.d dVarA = H1.a(context);
            bVar.a(dVarA);
            if (dVarA == H1.d.OFFLINE) {
                bVar.a(e.b.a.OFFLINE);
            } else if (this.a.f.contains(dVarA)) {
                Request.Builder builderWithMethod = new Request.Builder(this.a.b).withMethod(this.a.c);
                for (Map.Entry<String, ? extends Collection<String>> entry : this.a.d.a()) {
                    builderWithMethod.addHeader(entry.getKey(), TextUtils.join(",", entry.getValue()));
                }
                NetworkClient.Builder builder = new NetworkClient.Builder();
                F0.g().t().getClass();
                NetworkClient.Builder builderWithInstanceFollowRedirects = builder.withSslSocketFactory(null).withInstanceFollowRedirects(true);
                int i = C1098md.a;
                Response responseExecute = builderWithInstanceFollowRedirects.withConnectTimeout(i).withReadTimeout(i).withMaxResponseSize(102400).build().newCall(builderWithMethod.build()).execute();
                int code = responseExecute.getCode();
                if (responseExecute.isCompleted()) {
                    bVar.a(e.b.a.COMPLETE);
                } else {
                    bVar.a(e.b.a.ERROR);
                    bVar.a(responseExecute.getException());
                }
                bVar.a(Integer.valueOf(code));
                bVar.e = responseExecute.getResponseData();
                bVar.f = responseExecute.getErrorData();
                bVar.a((Map<String, List<String>>) responseExecute.getHeaders());
            } else {
                bVar.a(e.b.a.INCOMPATIBLE_NETWORK_TYPE);
            }
            Jf.a(Jf.this, bVar);
        }
    }

    public static class e {
        private final List<a> a;
        private final LinkedHashMap<String, Object> b = new LinkedHashMap<>();

        public static class a {
            public final String a;
            public final String b;
            public final String c;
            public final C1229rm<String, String> d;
            public final long e;
            public final List<H1.d> f;

            public a(String str, String str2, String str3, C1229rm<String, String> c1229rm, long j, List<H1.d> list) {
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.e = j;
                this.f = list;
                this.d = c1229rm;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || a.class != obj.getClass()) {
                    return false;
                }
                return this.a.equals(((a) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }
        }

        public static class b {
            private final a a;
            private a b;
            private H1.d c;
            private Integer d;
            byte[] e;
            byte[] f;
            private Map<String, List<String>> g;
            private Throwable h;

            public enum a {
                OFFLINE,
                INCOMPATIBLE_NETWORK_TYPE,
                COMPLETE,
                ERROR
            }

            public b(a aVar) {
                this.a = aVar;
            }

            public byte[] b() {
                return this.f;
            }

            public Throwable c() {
                return this.h;
            }

            public a d() {
                return this.a;
            }

            public byte[] e() {
                return this.e;
            }

            public Integer f() {
                return this.d;
            }

            public Map<String, List<String>> g() {
                return this.g;
            }

            public a h() {
                return this.b;
            }

            public void a(a aVar) {
                this.b = aVar;
            }

            public H1.d a() {
                return this.c;
            }

            public void a(H1.d dVar) {
                this.c = dVar;
            }

            public void a(Integer num) {
                this.d = num;
            }

            public void a(Map<String, List<String>> map) {
                this.g = map;
            }

            public void a(Throwable th) {
                this.h = th;
            }
        }

        public e(List<a> list, List<String> list2) {
            this.a = list;
            if (A2.b(list2)) {
                return;
            }
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                this.b.put(it.next(), new Object());
            }
        }

        public boolean a(a aVar) {
            if (this.b.get(aVar.a) != null || this.a.contains(aVar)) {
                return false;
            }
            this.a.add(aVar);
            return true;
        }

        public List<a> b() {
            return this.a;
        }

        public void b(a aVar) {
            this.b.put(aVar.a, new Object());
            this.a.remove(aVar);
        }

        public Set<String> a() {
            HashSet hashSet = new HashSet();
            Iterator<String> it = this.b.keySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                hashSet.add(it.next());
                i++;
                if (i > 1000) {
                    break;
                }
            }
            return hashSet;
        }
    }

    public Jf(Context context, ProtobufStateStorage protobufStateStorage, C1233s2 c1233s2, C1052kh c1052kh, ICommonExecutor iCommonExecutor, Rl rl) {
        this.a = context;
        this.b = protobufStateStorage;
        this.e = c1233s2;
        this.d = c1052kh;
        this.g = (e) protobufStateStorage.read();
        this.c = iCommonExecutor;
        this.f = rl;
    }

    static void a(Jf jf, List list, long j) {
        Long l;
        jf.getClass();
        if (A2.b(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0829bi c0829bi = (C0829bi) it.next();
            if (c0829bi.a != null && c0829bi.b != null && c0829bi.c != null && (l = c0829bi.e) != null && l.longValue() >= 0 && !A2.b(c0829bi.f)) {
                String str = c0829bi.a;
                String str2 = c0829bi.b;
                String str3 = c0829bi.c;
                List<Pair<String, String>> list2 = c0829bi.d;
                C1229rm c1229rm = new C1229rm(false);
                for (Pair<String, String> pair : list2) {
                    c1229rm.a(pair.first, pair.second);
                }
                long millis = TimeUnit.SECONDS.toMillis(c0829bi.e.longValue() + j);
                List<C0829bi.a> list3 = c0829bi.f;
                ArrayList arrayList = new ArrayList(list3.size());
                Iterator<C0829bi.a> it2 = list3.iterator();
                while (it2.hasNext()) {
                    arrayList.add(i.get(it2.next()));
                }
                jf.a(new e.a(str, str2, str3, c1229rm, millis, arrayList));
            }
        }
    }

    private void b(e.a aVar) {
        this.c.executeDelayed(new d(aVar), Math.max(ActivationBarrier.ACTIVATION_DELAY, Math.max(aVar.e - System.currentTimeMillis(), 0L)));
    }

    public synchronized void a() {
        this.c.execute(new b());
    }

    static void a(Jf jf) {
        if (jf.h) {
            return;
        }
        e eVar = (e) jf.b.read();
        jf.g = eVar;
        Iterator<e.a> it = eVar.b().iterator();
        while (it.hasNext()) {
            jf.b(it.next());
        }
        jf.h = true;
    }

    public synchronized void a(C1178pi c1178pi) {
        this.c.execute(new c(c1178pi.I(), c1178pi));
    }

    private boolean a(e.a aVar) {
        boolean zA = this.g.a(aVar);
        if (zA) {
            b(aVar);
            this.d.a(aVar);
        }
        this.b.save(this.g);
        return zA;
    }

    static void a(Jf jf, e.b bVar) {
        synchronized (jf) {
            jf.g.b(bVar.a);
            jf.b.save(jf.g);
            jf.d.a(bVar);
        }
    }
}
