package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.C1202qi;
import com.yandex.metrica.impl.ob.If;
import com.yandex.metrica.networktasks.api.RetryPolicyConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class X9 implements ProtobufConverter {
    private L9 a = new L9();
    private W9 b = new W9();
    private Q9 c = new Q9();
    private S9 d = new S9();
    private E9 e = new E9();
    private O9 f = new O9();
    private Z9 g = new Z9();
    private U9 h = new U9();
    private J9 i = new J9();
    private C0871da j = new C0871da();
    private C0846ca k = new C0846ca();
    private C1264t9 l = new C1264t9();
    private C0796aa m = new C0796aa();
    private C1336w9 n = new C1336w9();
    private A9 o = new A9();
    private C1240s9 p = new C1240s9();
    private B9 q = new B9();
    private C9 r = new C9();
    private C1384y9 s = new C1384y9();
    private Y9 t = new Y9();
    private N9 u = new N9();

    @Override // com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        C1202qi c1202qi = (C1202qi) obj;
        If r0 = new If();
        r0.C = c1202qi.G;
        r0.D = c1202qi.H;
        r0.l = new If.k[c1202qi.s.size()];
        Iterator<C1147oc> it = c1202qi.s.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            r0.l[i2] = this.a.fromModel(it.next());
            i2++;
        }
        String str = c1202qi.a;
        if (str != null) {
            r0.a = str;
        }
        String str2 = c1202qi.b;
        if (str2 != null) {
            r0.y = str2;
        }
        String str3 = c1202qi.c;
        if (str3 != null) {
            r0.z = str3;
        }
        List<String> list = c1202qi.j;
        if (list != null) {
            r0.g = (String[]) list.toArray(new String[list.size()]);
        }
        List<String> list2 = c1202qi.k;
        if (list2 != null) {
            r0.h = (String[]) list2.toArray(new String[list2.size()]);
        }
        List<String> list3 = c1202qi.d;
        if (list3 != null) {
            r0.c = (String[]) list3.toArray(new String[list3.size()]);
        }
        List<String> list4 = c1202qi.i;
        if (list4 != null) {
            r0.f = (String[]) list4.toArray(new String[list4.size()]);
        }
        List<String> list5 = c1202qi.l;
        if (list5 != null) {
            r0.t = (String[]) list5.toArray(new String[list5.size()]);
        }
        List<String> list6 = c1202qi.m;
        if (list6 != null) {
            r0.i = (String[]) list6.toArray(new String[list6.size()]);
        }
        Map<String, List<String>> map = c1202qi.n;
        if (map != null) {
            r0.j = this.s.fromModel(map);
        }
        C0879di c0879di = c1202qi.t;
        if (c0879di != null) {
            r0.m = this.b.fromModel(c0879di);
        }
        C0804ai c0804ai = c1202qi.A;
        if (c0804ai != null) {
            this.c.getClass();
            If.n nVar = new If.n();
            nVar.a = c0804ai.a;
            nVar.b = c0804ai.b;
            r0.F = nVar;
        }
        String str4 = c1202qi.o;
        if (str4 != null) {
            r0.o = str4;
        }
        String str5 = c1202qi.e;
        if (str5 != null) {
            r0.d = str5;
        }
        String str6 = c1202qi.f;
        if (str6 != null) {
            r0.e = str6;
        }
        String str7 = c1202qi.g;
        if (str7 != null) {
            r0.A = str7;
        }
        String str8 = c1202qi.h;
        if (str8 != null) {
            r0.B = str8;
        }
        r0.k = this.e.fromModel(c1202qi.r);
        String str9 = c1202qi.p;
        if (str9 != null) {
            r0.p = str9;
        }
        String str10 = c1202qi.q;
        if (str10 != null) {
            r0.q = str10;
        }
        r0.r = c1202qi.w;
        r0.b = c1202qi.u;
        r0.v = c1202qi.v;
        RetryPolicyConfig retryPolicyConfig = c1202qi.E;
        r0.H = retryPolicyConfig.maxIntervalSeconds;
        r0.I = retryPolicyConfig.exponentialMultiplier;
        List<C0829bi> list7 = c1202qi.x;
        if (list7 != null) {
            If.o[] oVarArr = new If.o[list7.size()];
            Iterator<C0829bi> it2 = list7.iterator();
            while (it2.hasNext()) {
                oVarArr[i] = this.d.fromModel(it2.next());
                i++;
            }
            r0.n = oVarArr;
        }
        String str11 = c1202qi.y;
        if (str11 != null) {
            r0.s = str11;
        }
        List<String> list8 = c1202qi.Q;
        r0.Q = (String[]) list8.toArray(new String[list8.size()]);
        List<Bd> list9 = c1202qi.B;
        if (list9 != null) {
            r0.w = this.f.fromModel(list9);
        }
        C0854ci c0854ci = c1202qi.C;
        if (c0854ci != null) {
            r0.x = this.h.fromModel(c0854ci);
        }
        C1273ti c1273ti = c1202qi.z;
        if (c1273ti != null) {
            this.g.getClass();
            If.s sVar = new If.s();
            sVar.a = c1273ti.a;
            r0.u = sVar;
        }
        r0.E = c1202qi.I;
        Zh zh = c1202qi.D;
        if (zh != null) {
            this.i.getClass();
            If.j jVar = new If.j();
            jVar.a = zh.a;
            r0.G = jVar;
        }
        C1348wl c1348wl = c1202qi.J;
        if (c1348wl != null) {
            r0.J = this.j.fromModel(c1348wl);
        }
        C0982hl c0982hl = c1202qi.K;
        if (c0982hl != null) {
            r0.L = this.k.fromModel(c0982hl);
        }
        C0982hl c0982hl2 = c1202qi.L;
        if (c0982hl2 != null) {
            r0.M = this.k.fromModel(c0982hl2);
        }
        C0982hl c0982hl3 = c1202qi.M;
        if (c0982hl3 != null) {
            r0.K = this.k.fromModel(c0982hl3);
        }
        C0985i c0985i = c1202qi.N;
        if (c0985i != null) {
            this.l.getClass();
            If.b bVar = new If.b();
            bVar.a = c0985i.a;
            bVar.b = c0985i.b;
            r0.R = bVar;
        }
        C1297ui c1297ui = c1202qi.F;
        if (c1297ui != null) {
            r0.N = this.m.fromModel(c1297ui);
        }
        Ph ph = c1202qi.O;
        if (ph != null) {
            r0.O = this.n.fromModel(ph);
        }
        r0.P = this.o.fromModel(c1202qi.P);
        Oh oh = c1202qi.R;
        if (oh != null) {
            r0.S = this.p.fromModel(oh);
        }
        C1327w0 c1327w0 = c1202qi.S;
        if (c1327w0 != null) {
            this.q.getClass();
            If.g gVar = new If.g();
            gVar.a = c1327w0.a();
            r0.U = gVar;
        }
        Uh uh = c1202qi.T;
        if (uh != null) {
            r0.T = this.r.fromModel(uh);
        }
        Y9 y9 = this.t;
        C1249si c1249si = c1202qi.U;
        y9.getClass();
        If.r rVar = new If.r();
        rVar.a = c1249si.a();
        r0.V = rVar;
        r0.W = this.u.fromModel(c1202qi.V);
        return r0;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        If r9 = (If) obj;
        C1202qi.b bVarA = new C1202qi.b(this.e.toModel(r9.k)).k(r9.a).c(r9.y).d(r9.z).e(r9.o).f(r9.d).i(Arrays.asList(r9.c)).e(Arrays.asList(r9.f)).b(Arrays.asList(r9.h)).c(Arrays.asList(r9.g)).i(r9.e).j(r9.A).a(r9.B).a(Arrays.asList(r9.t)).g(Arrays.asList(r9.i)).h(r9.p).g(r9.q).c(r9.r).c(r9.b).a(r9.v);
        If.o[] oVarArr = r9.n;
        ArrayList arrayList = new ArrayList(oVarArr.length);
        int i = 0;
        for (If.o oVar : oVarArr) {
            arrayList.add(this.d.toModel(oVar));
        }
        C1202qi.b bVarA2 = bVarA.j(arrayList).b(r9.C).a(r9.D).b(r9.s).b(r9.E).a(new RetryPolicyConfig(r9.H, r9.I)).f(Arrays.asList(r9.Q)).a(this.s.toModel(r9.j));
        if (r9.l != null) {
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                If.k[] kVarArr = r9.l;
                if (i >= kVarArr.length) {
                    break;
                }
                arrayList2.add(this.a.toModel(kVarArr[i]));
                i++;
            }
            bVarA2.d(arrayList2);
        }
        If.q qVar = r9.m;
        if (qVar != null) {
            bVarA2.a(this.b.toModel(qVar));
        }
        If.n nVar = r9.F;
        if (nVar != null) {
            this.c.getClass();
            bVarA2.a(new C0804ai(nVar.a, nVar.b));
        }
        If.m[] mVarArr = r9.w;
        if (mVarArr != null) {
            bVarA2.h(this.f.toModel(mVarArr));
        }
        If.p pVar = r9.x;
        if (pVar != null) {
            bVarA2.a(this.h.toModel(pVar));
        }
        If.s sVar = r9.u;
        if (sVar != null) {
            bVarA2.a(this.g.toModel(sVar));
        }
        If.j jVar = r9.G;
        if (jVar != null) {
            bVarA2.a(this.i.toModel(jVar));
        }
        If.w wVar = r9.J;
        if (wVar != null) {
            bVarA2.a(this.j.toModel(wVar));
        }
        If.v vVar = r9.L;
        if (vVar != null) {
            bVarA2.b(this.k.toModel(vVar));
        }
        If.v vVar2 = r9.M;
        if (vVar2 != null) {
            bVarA2.c(this.k.toModel(vVar2));
        }
        If.v vVar3 = r9.K;
        if (vVar3 != null) {
            bVarA2.a(this.k.toModel(vVar3));
        }
        If.b bVar = r9.R;
        if (bVar != null) {
            bVarA2.a(this.l.toModel(bVar));
        }
        If.t tVar = r9.N;
        if (tVar != null) {
            bVarA2.a(this.m.toModel(tVar));
        }
        If.c cVar = r9.O;
        if (cVar != null) {
            bVarA2.a(this.n.toModel(cVar));
        }
        If.f fVar = r9.P;
        if (fVar != null) {
            bVarA2.a(this.o.a(fVar));
        }
        If.a aVar = r9.S;
        if (aVar != null) {
            bVarA2.a(this.p.toModel(aVar));
        }
        If.h hVar = r9.T;
        if (hVar != null) {
            bVarA2.a(this.r.toModel(hVar));
        }
        If.g gVar = r9.U;
        if (gVar != null) {
            bVarA2.a(this.q.toModel(gVar));
        }
        If.r rVar = r9.V;
        if (rVar != null) {
            bVarA2.a(this.t.toModel(rVar));
        }
        bVarA2.b(this.u.toModel(r9.W));
        return bVarA2.a();
    }
}
