package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.IIdentifierCallback;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.impl.interact.CellularNetworkInfo;
import com.yandex.metrica.p;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Rf {
    private final Sf a;
    private final ICommonExecutor b;
    private final Kn<Context> c;
    private final Kn<String> d;
    private final C0983hm e;

    class a extends AbstractRunnableC0908em {
        final /* synthetic */ Context a;
        final /* synthetic */ IIdentifierCallback b;
        final /* synthetic */ List c;

        a(Context context, IIdentifierCallback iIdentifierCallback, List list) {
            this.a = context;
            this.b = iIdentifierCallback;
            this.c = list;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() throws Exception {
            Sf sf = Rf.this.a;
            Context context = this.a;
            sf.getClass();
            R2.a(context).a(this.b, this.c);
        }
    }

    class b extends AbstractCallableC0883dm<String> {
        b() {
        }

        @Override // com.yandex.metrica.impl.ob.AbstractCallableC0883dm
        public String a() throws Exception {
            Rf.this.a.getClass();
            R2 r2K = R2.k();
            if (r2K == null) {
                return null;
            }
            return r2K.e().a();
        }
    }

    class c extends AbstractCallableC0883dm<Boolean> {
        c() {
        }

        @Override // com.yandex.metrica.impl.ob.AbstractCallableC0883dm
        public Boolean a() throws Exception {
            Rf.this.a.getClass();
            R2 r2K = R2.k();
            if (r2K == null) {
                return null;
            }
            return r2K.e().b();
        }
    }

    class d extends AbstractRunnableC0908em {
        final /* synthetic */ boolean a;

        d(boolean z) {
            this.a = z;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() throws Exception {
            Sf sf = Rf.this.a;
            boolean z = this.a;
            sf.getClass();
            R2.b(z);
        }
    }

    class e extends AbstractRunnableC0908em {
        final /* synthetic */ p.Ucc a;
        final /* synthetic */ boolean b;

        class a implements InterfaceC1081ll {
            a() {
            }

            @Override // com.yandex.metrica.impl.ob.InterfaceC1081ll
            public void onError(String str) {
                e.this.a.onError(str);
            }

            @Override // com.yandex.metrica.impl.ob.InterfaceC1081ll
            public void onResult(JSONObject jSONObject) {
                e.this.a.onResult(jSONObject);
            }
        }

        e(p.Ucc ucc, boolean z) {
            this.a = ucc;
            this.b = z;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() throws Exception {
            Rf.b(Rf.this).a(new a(), this.b);
        }
    }

    class f extends AbstractRunnableC0908em {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;

        f(Context context, Map map) {
            this.a = context;
            this.b = map;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() throws Exception {
            Sf sf = Rf.this.a;
            Context context = this.a;
            sf.getClass();
            R2.a(context).a(this.b);
        }
    }

    public Rf(ICommonExecutor iCommonExecutor, Sf sf) {
        this(iCommonExecutor, sf, new Kf(sf), new Hn(new Gn("Context")), new Hn(new Gn("Event name")), new C0983hm());
    }

    public Future<Boolean> b() {
        return this.b.submit(new c());
    }

    public String c(Context context) {
        this.c.a(context);
        return context.getPackageName();
    }

    public String d(Context context) {
        this.c.a(context);
        this.a.getClass();
        return R2.a(context).a();
    }

    public Rf(ICommonExecutor iCommonExecutor, Sf sf, Kf kf, Kn<Context> kn, Kn<String> kn2, C0983hm c0983hm) {
        this.a = sf;
        this.b = iCommonExecutor;
        this.c = kn;
        this.d = kn2;
        this.e = c0983hm;
    }

    public void a(Context context, IIdentifierCallback iIdentifierCallback, List<String> list) {
        this.c.a(context);
        this.b.execute(new a(context, iIdentifierCallback, list));
    }

    public String b(Context context) {
        this.c.a(context);
        this.a.getClass();
        return R2.a(context).c();
    }

    public Future<String> a() {
        return this.b.submit(new b());
    }

    public String a(Context context) {
        this.c.a(context);
        return this.e.a(context) ? new CellularNetworkInfo(context).getCelluralInfo() : "";
    }

    public void a(Context context, boolean z) {
        this.c.a(context);
        this.b.execute(new d(z));
    }

    public void a(p.Ucc ucc, boolean z) {
        this.a.getClass();
        if (!R2.i()) {
            ucc.onError("Main API key is not activated");
        } else {
            this.b.execute(new e(ucc, z));
        }
    }

    static K0 b(Rf rf) {
        rf.a.getClass();
        return R2.k().d().b();
    }

    public void a(Context context, Map<String, Object> map) {
        this.c.a(context);
        this.b.execute(new f(context, map));
    }
}
