package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.util.Base64;
import android.util.Pair;
import com.google.protobuf.nano.ym.MessageNano;
import com.yandex.metrica.IMetricaService;
import com.yandex.metrica.impl.ob.U1;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class T1 implements P0 {
    private final Context a;
    private C1136o1 b;
    private C1011j1 c;
    private final T d;
    private InterfaceC1028ji e;
    private final P6 f;
    private final C1309v6 g;
    private final U1 h = new U1(this);

    class a implements U1.e {
        final /* synthetic */ Map a;
        final /* synthetic */ Q1 b;

        a(Map map, Q1 q1) {
            this.a = map;
            this.b = q1;
        }

        @Override // com.yandex.metrica.impl.ob.U1.e
        public C0836c0 a(C0836c0 c0836c0) {
            T1 t1 = T1.this;
            C0836c0 c0836c0F = c0836c0.f(Tl.g(this.a));
            Q1 q1 = this.b;
            t1.getClass();
            if (C1399z0.f(c0836c0F.e)) {
                c0836c0F.c(q1.c.a());
            }
            return c0836c0F;
        }
    }

    class b implements U1.e {
        final /* synthetic */ C1318vf a;

        b(T1 t1, C1318vf c1318vf) {
            this.a = c1318vf;
        }

        @Override // com.yandex.metrica.impl.ob.U1.e
        public C0836c0 a(C0836c0 c0836c0) {
            return c0836c0.f(new String(Base64.encode(MessageNano.toByteArray(this.a), 0)));
        }
    }

    class c implements U1.e {
        final /* synthetic */ String a;

        c(T1 t1, String str) {
            this.a = str;
        }

        @Override // com.yandex.metrica.impl.ob.U1.e
        public C0836c0 a(C0836c0 c0836c0) {
            return c0836c0.f(this.a);
        }
    }

    class d implements U1.e {
        final /* synthetic */ W1 a;

        d(T1 t1, W1 w1) {
            this.a = w1;
        }

        @Override // com.yandex.metrica.impl.ob.U1.e
        public C0836c0 a(C0836c0 c0836c0) {
            Pair<byte[], Integer> pairA = this.a.a();
            C0836c0 c0836c0F = c0836c0.f(new String(Base64.encode((byte[]) pairA.first, 0)));
            c0836c0F.h = ((Integer) pairA.second).intValue();
            return c0836c0F;
        }
    }

    class e implements U1.e {
        final /* synthetic */ Sg a;

        e(T1 t1, Sg sg) {
            this.a = sg;
        }

        @Override // com.yandex.metrica.impl.ob.U1.e
        public C0836c0 a(C0836c0 c0836c0) {
            kotlin.Pair<byte[], Integer> pairA = this.a.a();
            C0836c0 c0836c0F = c0836c0.f(new String(Base64.encode(pairA.getFirst(), 0)));
            c0836c0F.h = pairA.getSecond().intValue();
            return c0836c0F;
        }
    }

    class f implements U1.e {
        final /* synthetic */ Na a;

        f(T1 t1, Na na) {
            this.a = na;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.yandex.metrica.impl.ob.U1.e
        public C0836c0 a(C0836c0 c0836c0) {
            C0836c0 c0836c0F = c0836c0.f(L0.a(MessageNano.toByteArray((MessageNano) this.a.a)));
            c0836c0F.h = this.a.b.a();
            return c0836c0F;
        }
    }

    T1(A3 a3, Context context, C1136o1 c1136o1, P6 p6, C1309v6 c1309v6) {
        this.b = c1136o1;
        this.a = context;
        this.d = new T(a3);
        this.f = p6;
        this.g = c1309v6;
    }

    void a(C1011j1 c1011j1) {
        this.c = c1011j1;
    }

    public void b(Q1 q1) {
        C1000ie c1000ie = q1.d;
        String strE = q1.e();
        C0858cm c0858cmA = a(q1);
        List<Integer> list = C1399z0.i;
        JSONObject jSONObject = new JSONObject();
        if (c1000ie != null) {
            c1000ie.a(jSONObject);
        }
        a(new J(jSONObject.toString(), "", EnumC0787a1.EVENT_TYPE_ACTIVATION.b(), 0, c0858cmA).d(strE), q1);
    }

    public void c(Q1 q1) {
        C0836c0 c0836c0 = new C0836c0();
        c0836c0.e = EnumC0787a1.EVENT_TYPE_APP_ENVIRONMENT_CLEARED.b();
        a(new U1.f(c0836c0, q1));
    }

    void d() {
        this.b.g();
    }

    void e() {
        this.b.f();
    }

    public void f() {
        this.b.a();
    }

    public void g() {
        this.b.c();
    }

    void a(InterfaceC1028ji interfaceC1028ji) {
        this.e = interfaceC1028ji;
        this.d.a(interfaceC1028ji);
    }

    void a(Boolean bool, Boolean bool2, Boolean bool3) {
        if (A2.a(bool)) {
            this.d.b().b(bool.booleanValue());
        }
        if (A2.a(bool2)) {
            this.d.b().c(bool2.booleanValue());
        }
        if (A2.a(bool3)) {
            this.d.b().a(bool3.booleanValue());
        }
        C0836c0 c0836c0 = new C0836c0();
        c0836c0.e = EnumC0787a1.EVENT_TYPE_UPDATE_PRE_ACTIVATION_CONFIG.b();
        a(c0836c0, this.d);
    }

    public C1136o1 c() {
        return this.b;
    }

    void a(String str, Q1 q1) {
        try {
            a(C1399z0.c(L0.a(MessageNano.toByteArray(this.f.fromModel(new C0868d7(str == null ? new byte[0] : str.getBytes("UTF-8"), new C0843c7(EnumC0943g7.USER, null))))), a(q1)), q1);
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public Future<Void> a(C0836c0 c0836c0, Q1 q1, Map<String, Object> map) {
        EnumC0787a1 enumC0787a1 = EnumC0787a1.EVENT_TYPE_UNDEFINED;
        this.b.f();
        U1.f fVar = new U1.f(c0836c0, q1);
        if (!A2.b(map)) {
            fVar.a(new a(map, q1));
        }
        return a(fVar);
    }

    public Future<Void> a(A3 a3) {
        return this.h.queuePauseUserSession(a3);
    }

    public void a(List<String> list, ResultReceiver resultReceiver, Map<String, String> map) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.yandex.metrica.impl.IdentifiersData", new V0(list, map, resultReceiver));
        EnumC0787a1 enumC0787a1 = EnumC0787a1.EVENT_TYPE_STARTUP;
        int i = Ul.e;
        C0858cm c0858cmA = C0858cm.a();
        List<Integer> list2 = C1399z0.i;
        a(new J("", "", enumC0787a1.b(), 0, c0858cmA).c(bundle), this.d);
    }

    public void a(ResultReceiverC0902eg resultReceiverC0902eg) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.yandex.metrica.impl.referrer.common.ReferrerResultReceiver", resultReceiverC0902eg);
        int i = Ul.e;
        C0858cm c0858cmA = C0858cm.a();
        List<Integer> list = C1399z0.i;
        a(new J("", "", EnumC0787a1.EVENT_TYPE_REQUEST_REFERRER.b(), 0, c0858cmA).c(bundle), this.d);
    }

    public Future<Void> b(A3 a3) {
        return this.h.queueResumeUserSession(a3);
    }

    public void b(String str) {
        this.d.a().b(str);
    }

    void b(H6 h6, Q1 q1) {
        this.b.f();
        a(this.g.a(h6, q1));
    }

    void b(String str, Q1 q1) {
        a(new U1.f(J.a(str, a(q1)), q1).a(new c(this, str)));
    }

    public com.yandex.metrica.rtm.wrapper.k b() {
        return this.h;
    }

    void a(C0836c0 c0836c0, Q1 q1) {
        if (C1399z0.f(c0836c0.e)) {
            c0836c0.c(q1.c.a());
        }
        a(c0836c0, q1, (Map<String, Object>) null);
    }

    public void a(List<String> list) {
        this.d.a().a(list);
    }

    public void a(Map<String, String> map) {
        this.d.a().a(map);
    }

    public void a(String str) {
        this.d.a().a(str);
    }

    void a(H6 h6, Q1 q1) {
        this.b.f();
        U1.f fVarA = this.g.a(h6, q1);
        fVarA.a().a(this.e);
        this.h.sendCrash(fVarA);
    }

    public void a(String str, String str2, Q1 q1) {
        C0836c0 c0836c0 = new C0836c0();
        c0836c0.e = EnumC0787a1.EVENT_TYPE_APP_ENVIRONMENT_UPDATED.b();
        a(new U1.f(c0836c0.a(str, str2), q1));
    }

    void a(C1318vf c1318vf, Q1 q1) {
        C0836c0 c0836c0 = new C0836c0();
        c0836c0.e = EnumC0787a1.EVENT_TYPE_SEND_USER_PROFILE.b();
        a(new U1.f(c0836c0, q1).a(new b(this, c1318vf)));
    }

    void a(W1 w1, Q1 q1) {
        J j = new J(a(q1));
        j.e = EnumC0787a1.EVENT_TYPE_SEND_REVENUE_EVENT.b();
        a(new U1.f(j, q1).a(new d(this, w1)));
    }

    void a(Sg sg, Q1 q1) {
        J j = new J(a(q1));
        j.e = EnumC0787a1.EVENT_TYPE_SEND_AD_REVENUE_EVENT.b();
        a(new U1.f(j, q1).a(new e(this, sg)));
    }

    void a(Za za, Q1 q1) {
        for (Na<C1100mf, Vm> na : za.toProto()) {
            J j = new J(a(q1));
            j.e = EnumC0787a1.EVENT_TYPE_SEND_ECOMMERCE_EVENT.b();
            a(new U1.f(j, q1).a(new f(this, na)));
        }
    }

    public void a(IMetricaService iMetricaService, C0836c0 c0836c0, Q1 q1) throws RemoteException {
        iMetricaService.reportData(c0836c0.b(q1.c()));
        C1011j1 c1011j1 = this.c;
        if (c1011j1 == null || c1011j1.b.f()) {
            this.b.g();
        }
    }

    private Future<Void> a(U1.f fVar) {
        fVar.a().a(this.e);
        return this.h.queueReport(fVar);
    }

    public Context a() {
        return this.a;
    }

    private C0858cm a(Q1 q1) {
        return Ul.b(q1.b().a());
    }
}
