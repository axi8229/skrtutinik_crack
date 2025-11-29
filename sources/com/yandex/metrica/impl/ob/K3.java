package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.ob.C1230s;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class K3 {
    private final L3 a;
    private final Id b;
    private List<j> c;

    public static class b {
        private final L3 a;

        public b(L3 l3) {
            this.a = l3;
        }

        K3 a(Id id) {
            return new K3(this.a, id);
        }
    }

    static class c extends j {
        private final Md b;
        private final C0845c9 c;

        c(L3 l3) {
            super(l3);
            this.b = new Md(l3.g(), l3.e().toString());
            this.c = l3.f();
        }

        @Override // com.yandex.metrica.impl.ob.K3.j
        protected void b() {
            C0892e6 c0892e6 = new C0892e6(this.c, "background");
            if (!c0892e6.h()) {
                long jC = this.b.c(-1L);
                if (jC != -1) {
                    c0892e6.d(jC);
                }
                long jA = this.b.a(Long.MIN_VALUE);
                if (jA != Long.MIN_VALUE) {
                    c0892e6.a(jA);
                }
                long jB = this.b.b(0L);
                if (jB != 0) {
                    c0892e6.c(jB);
                }
                long jD = this.b.d(0L);
                if (jD != 0) {
                    c0892e6.e(jD);
                }
                c0892e6.b();
            }
            C0892e6 c0892e62 = new C0892e6(this.c, "foreground");
            if (!c0892e62.h()) {
                long jG = this.b.g(-1L);
                if (-1 != jG) {
                    c0892e62.d(jG);
                }
                boolean zBooleanValue = this.b.a(true).booleanValue();
                if (zBooleanValue) {
                    c0892e62.a(zBooleanValue);
                }
                long jE = this.b.e(Long.MIN_VALUE);
                if (jE != Long.MIN_VALUE) {
                    c0892e62.a(jE);
                }
                long jF = this.b.f(0L);
                if (jF != 0) {
                    c0892e62.c(jF);
                }
                long jH = this.b.h(0L);
                if (jH != 0) {
                    c0892e62.e(jH);
                }
                c0892e62.b();
            }
            C1230s.a aVarF = this.b.f();
            if (aVarF != null) {
                this.c.a(aVarF);
            }
            String strB = this.b.b((String) null);
            if (!TextUtils.isEmpty(strB) && TextUtils.isEmpty(this.c.n())) {
                this.c.j(strB);
            }
            long jI = this.b.i(Long.MIN_VALUE);
            if (jI != Long.MIN_VALUE && this.c.b(Long.MIN_VALUE) == Long.MIN_VALUE) {
                this.c.c(jI);
            }
            this.b.h();
            this.c.d();
        }

        @Override // com.yandex.metrica.impl.ob.K3.j
        protected boolean c() {
            return this.b.g();
        }
    }

    static class d extends k {
        d(L3 l3, Id id) {
            super(l3, id);
        }

        @Override // com.yandex.metrica.impl.ob.K3.j
        protected void b() {
            d().a();
        }

        @Override // com.yandex.metrica.impl.ob.K3.j
        protected boolean c() {
            return a() instanceof U3;
        }
    }

    static class e extends j {
        private final Jd b;
        private final C0795a9 c;

        e(L3 l3, Jd jd) {
            super(l3);
            this.b = jd;
            this.c = l3.o();
        }

        @Override // com.yandex.metrica.impl.ob.K3.j
        protected void b() {
            if ("DONE".equals(this.b.c(null))) {
                this.c.j();
            }
            if ("DONE".equals(this.b.d(null))) {
                this.c.k();
            }
            this.b.h();
            this.b.g();
            this.b.i();
        }

        @Override // com.yandex.metrica.impl.ob.K3.j
        protected boolean c() {
            return "DONE".equals(this.b.c(null)) || "DONE".equals(this.b.d(null));
        }
    }

    static class f extends k {
        f(L3 l3, Id id) {
            super(l3, id);
        }

        @Override // com.yandex.metrica.impl.ob.K3.j
        protected void b() {
            Id idD = d();
            if (a() instanceof U3) {
                idD.b();
            } else {
                idD.c();
            }
        }

        @Override // com.yandex.metrica.impl.ob.K3.j
        protected boolean c() {
            return a().o().g(null) == null;
        }
    }

    static class g extends j {
        private final C0895e9 b;

        g(L3 l3, C0895e9 c0895e9) {
            super(l3);
            this.b = c0895e9;
        }

        @Override // com.yandex.metrica.impl.ob.K3.j
        protected void b() {
            if (this.b.a(new Rd("REFERRER_HANDLED", null).a(), false)) {
                a().f().q();
            }
        }

        @Override // com.yandex.metrica.impl.ob.K3.j
        protected boolean c() {
            return true;
        }
    }

    static class h extends j {

        @Deprecated
        static final Rd c = new Rd("SESSION_SLEEP_START", null);

        @Deprecated
        static final Rd d = new Rd("SESSION_ID", null);

        @Deprecated
        static final Rd e = new Rd("SESSION_COUNTER_ID", null);

        @Deprecated
        static final Rd f = new Rd("SESSION_INIT_TIME", null);

        @Deprecated
        static final Rd g = new Rd("SESSION_IS_ALIVE_REPORT_NEEDED", null);

        @Deprecated
        static final Rd h = new Rd("BG_SESSION_ID", null);

        @Deprecated
        static final Rd i = new Rd("BG_SESSION_SLEEP_START", null);

        @Deprecated
        static final Rd j = new Rd("BG_SESSION_COUNTER_ID", null);

        @Deprecated
        static final Rd k = new Rd("BG_SESSION_INIT_TIME", null);

        @Deprecated
        static final Rd l = new Rd("BG_SESSION_IS_ALIVE_REPORT_NEEDED", null);
        private final C0845c9 b;

        h(L3 l3) {
            super(l3);
            this.b = l3.f();
        }

        @Override // com.yandex.metrica.impl.ob.K3.j
        protected void b() {
            C0845c9 c0845c9 = this.b;
            Rd rd = i;
            long jA = c0845c9.a(rd.a(), -2147483648L);
            if (jA != -2147483648L) {
                C0892e6 c0892e6 = new C0892e6(this.b, "background");
                if (!c0892e6.h()) {
                    if (jA != 0) {
                        c0892e6.e(jA);
                    }
                    long jA2 = this.b.a(h.a(), -1L);
                    if (jA2 != -1) {
                        c0892e6.d(jA2);
                    }
                    boolean zA = this.b.a(l.a(), true);
                    if (zA) {
                        c0892e6.a(zA);
                    }
                    long jA3 = this.b.a(k.a(), Long.MIN_VALUE);
                    if (jA3 != Long.MIN_VALUE) {
                        c0892e6.a(jA3);
                    }
                    long jA4 = this.b.a(j.a(), 0L);
                    if (jA4 != 0) {
                        c0892e6.c(jA4);
                    }
                    c0892e6.b();
                }
            }
            C0845c9 c0845c92 = this.b;
            Rd rd2 = c;
            long jA5 = c0845c92.a(rd2.a(), -2147483648L);
            if (jA5 != -2147483648L) {
                C0892e6 c0892e62 = new C0892e6(this.b, "foreground");
                if (!c0892e62.h()) {
                    if (jA5 != 0) {
                        c0892e62.e(jA5);
                    }
                    long jA6 = this.b.a(d.a(), -1L);
                    if (-1 != jA6) {
                        c0892e62.d(jA6);
                    }
                    boolean zA2 = this.b.a(g.a(), true);
                    if (zA2) {
                        c0892e62.a(zA2);
                    }
                    long jA7 = this.b.a(f.a(), Long.MIN_VALUE);
                    if (jA7 != Long.MIN_VALUE) {
                        c0892e62.a(jA7);
                    }
                    long jA8 = this.b.a(e.a(), 0L);
                    if (jA8 != 0) {
                        c0892e62.c(jA8);
                    }
                    c0892e62.b();
                }
            }
            this.b.f(rd2.a());
            this.b.f(d.a());
            this.b.f(e.a());
            this.b.f(f.a());
            this.b.f(g.a());
            this.b.f(h.a());
            this.b.f(rd.a());
            this.b.f(j.a());
            this.b.f(k.a());
            this.b.f(l.a());
        }

        @Override // com.yandex.metrica.impl.ob.K3.j
        protected boolean c() {
            return true;
        }
    }

    static class i extends j {
        private final C0795a9 b;
        private final C0845c9 c;
        private final C0819b8 d;
        private final String e;
        private final String f;
        private final String g;
        private final String h;
        private final String i;

        i(L3 l3) {
            super(l3);
            this.e = new Rd("LAST_REQUEST_ID").a();
            this.f = new Rd("NEXT_EVENT_GLOBAL_NUMBER").a();
            this.g = new Rd("CURRENT_SESSION_ID").a();
            this.h = new Rd("ATTRIBUTION_ID").a();
            this.i = new Rd("OPEN_ID").a();
            this.b = l3.o();
            this.c = l3.f();
            this.d = l3.x();
        }

        @Override // com.yandex.metrica.impl.ob.K3.j
        protected void b() {
            JSONObject jSONObject = new JSONObject();
            for (String str : this.c.e()) {
                if (str.startsWith("EVENT_NUMBER_OF_TYPE_")) {
                    try {
                        jSONObject.put(String.valueOf(Integer.parseInt(str.substring(21))), this.c.a(str, 0));
                        this.c.f(str);
                    } catch (Throwable unused) {
                    }
                }
            }
            this.d.a(this.b.f(), this.b.g(), this.c.c(this.e) ? Integer.valueOf(this.c.a(this.e, -1)) : null, this.c.c(this.f) ? Integer.valueOf(this.c.a(this.f, 0)) : null, this.c.c(this.g) ? Long.valueOf(this.c.a(this.g, -1L)) : null, this.c.t(), jSONObject, this.c.c(this.i) ? Integer.valueOf(this.c.a(this.i, 1)) : null, this.c.c(this.h) ? Integer.valueOf(this.c.a(this.h, 1)) : null, this.c.j());
            this.b.h().i().d();
            this.c.s().r().f(this.e).f(this.f).f(this.g).f(this.h).f(this.i).d();
        }

        @Override // com.yandex.metrica.impl.ob.K3.j
        protected boolean c() {
            return true;
        }
    }

    static abstract class j {
        private final L3 a;

        j(L3 l3) {
            this.a = l3;
        }

        L3 a() {
            return this.a;
        }

        protected abstract void b();

        protected abstract boolean c();
    }

    private static abstract class k extends j {
        private Id b;

        k(L3 l3, Id id) {
            super(l3);
            this.b = id;
        }

        public Id d() {
            return this.b;
        }
    }

    static class l extends j {
        private final C0795a9 b;

        l(L3 l3) {
            super(l3);
            this.b = l3.o();
        }

        @Override // com.yandex.metrica.impl.ob.K3.j
        protected void b() {
            this.b.f(new Rd("first_event_description_key", null).a()).d();
        }

        @Override // com.yandex.metrica.impl.ob.K3.j
        protected boolean c() {
            return true;
        }
    }

    private void b() {
        LinkedList linkedList = new LinkedList();
        this.c = linkedList;
        linkedList.add(new d(this.a, this.b));
        this.c.add(new f(this.a, this.b));
        List<j> list = this.c;
        L3 l3 = this.a;
        list.add(new e(l3, l3.n()));
        this.c.add(new c(this.a));
        this.c.add(new h(this.a));
        List<j> list2 = this.c;
        L3 l32 = this.a;
        list2.add(new g(l32, l32.t()));
        this.c.add(new l(this.a));
        this.c.add(new i(this.a));
    }

    void a() {
        if (Id.b.values().contains(this.a.e().a())) {
            return;
        }
        for (j jVar : this.c) {
            if (jVar.c()) {
                jVar.b();
            }
        }
    }

    private K3(L3 l3, Id id) {
        this.a = l3;
        this.b = id;
        b();
    }
}
