package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1199qf;
import com.yandex.metrica.impl.ob.C1230s;
import com.yandex.metrica.networktasks.api.DefaultNetworkResponseHandler;
import com.yandex.metrica.networktasks.api.FullUrlFormer;
import com.yandex.metrica.networktasks.api.RequestBodyEncrypter;
import com.yandex.metrica.networktasks.api.RequestDataHolder;
import com.yandex.metrica.networktasks.api.ResponseDataHolder;
import com.yandex.metrica.networktasks.api.RetryPolicyConfig;
import com.yandex.metrica.networktasks.api.SendingDataTaskHelper;
import com.yandex.metrica.networktasks.api.UnderlyingNetworkTask;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class P1 implements UnderlyingNetworkTask {
    private final L3 a;
    private final Map<String, String> b;
    private Ig c;
    private C1199qf d;
    private final L7 e;
    private List<Long> f;
    private int g;
    private int h;
    private b i;
    private final InterfaceC0934fn<byte[]> j;
    private final C0858cm k;
    private final C0819b8 l;
    private final M0 m;
    private final Qg n;
    private final FullUrlFormer o;
    private final C0862d1 p;
    private final RequestDataHolder q;
    private final ResponseDataHolder r;
    private final SendingDataTaskHelper s;
    private int t;

    static final class a {
        final C1199qf.d a;
        final C1230s.a b;
        final boolean c;

        a(C1199qf.d dVar, C1230s.a aVar, boolean z) {
            this.a = dVar;
            this.b = aVar;
            this.c = z;
        }
    }

    static final class b {
        final List<C1199qf.d> a;
        final List<Long> b;
        final JSONObject c;

        b(List<C1199qf.d> list, List<Long> list2, JSONObject jSONObject) {
            this.a = list;
            this.b = list2;
            this.c = jSONObject;
        }
    }

    public P1(L3 l3, Qg qg, C0862d1 c0862d1, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this(l3, qg, c0862d1, fullUrlFormer, requestDataHolder, responseDataHolder, l3.i(), l3.q(), l3.x(), requestBodyEncrypter);
    }

    static /* synthetic */ int a(P1 p1, int i) {
        int i2 = p1.g + i;
        p1.g = i2;
        return i2;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public String description() {
        return "ReportTask_" + this.a.e().a();
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public FullUrlFormer getFullUrlFormer() {
        return this.o;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public RequestDataHolder getRequestDataHolder() {
        return this.q;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public ResponseDataHolder getResponseDataHolder() {
        return this.r;
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public RetryPolicyConfig getRetryPolicyConfig() {
        return this.a.m().q();
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public SSLSocketFactory getSslSocketFactory() {
        F0.g().t().getClass();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01e7 A[LOOP:2: B:85:0x01e1->B:87:0x01e7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0200 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0202  */
    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onCreateTask() {
        /*
            Method dump skipped, instructions count: 678
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.P1.onCreateTask():boolean");
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onPerformRequest() {
        this.s.onPerformRequest();
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onPostRequestComplete(boolean z) {
        if (z) {
            a(false);
        } else if (A2.b(this.r.getResponseCode())) {
            a(true);
        }
        if (z && this.k.isEnabled()) {
            for (int i = 0; i < this.i.a.size(); i++) {
                this.k.a(this.i.a.get(i), "Event sent");
            }
        }
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public boolean onRequestComplete() {
        return this.s.isResponseValid();
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onRequestError(Throwable th) {
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onShouldNotExecute() {
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onSuccessfulTaskFinished() {
        this.a.l().c();
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onTaskAdded() {
        this.a.l().a();
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onTaskFinished() {
        this.a.i().a();
        this.a.l().b();
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onTaskRemoved() {
        this.a.l().b();
    }

    @Override // com.yandex.metrica.networktasks.api.UnderlyingNetworkTask
    public void onUnsuccessfulTaskFinished() {
    }

    private C1199qf.a[] a(JSONObject jSONObject) {
        int length = jSONObject.length();
        if (length <= 0) {
            return null;
        }
        C1199qf.a[] aVarArr = new C1199qf.a[length];
        Iterator<String> itKeys = jSONObject.keys();
        int i = 0;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                C1199qf.a aVar = new C1199qf.a();
                aVar.a = next;
                aVar.b = jSONObject.getString(next);
                aVarArr[i] = aVar;
            } catch (Throwable unused) {
            }
            i++;
        }
        return aVarArr;
    }

    private P1(L3 l3, Qg qg, C0862d1 c0862d1, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, L7 l7, C0858cm c0858cm, C0819b8 c0819b8, RequestBodyEncrypter requestBodyEncrypter) {
        this(l3, c0858cm, l7, qg, c0819b8, c0862d1, new Tm(1024000, "event value in ReportTask", c0858cm), C1152oh.a(), fullUrlFormer, requestDataHolder, responseDataHolder, requestBodyEncrypter);
    }

    private void a(boolean z) {
        this.l.c(this.t);
        C1199qf.d[] dVarArr = this.d.a;
        for (int i = 0; i < dVarArr.length; i++) {
            try {
                C1199qf.d dVar = dVarArr[i];
                this.e.a(this.f.get(i).longValue(), J1.a(dVar.b.c).a(), dVar.c.length, z);
            } catch (Throwable unused) {
            }
        }
        this.e.a(this.a.v().a());
    }

    P1(L3 l3, C0858cm c0858cm, L7 l7, Qg qg, C0819b8 c0819b8, C0862d1 c0862d1, Tm tm, M0 m0, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this.b = new LinkedHashMap();
        this.g = 0;
        this.h = -1;
        this.s = new SendingDataTaskHelper(requestBodyEncrypter, new Ql(), requestDataHolder, responseDataHolder, new DefaultNetworkResponseHandler());
        this.n = qg;
        this.a = l3;
        this.e = l7;
        this.k = c0858cm;
        this.j = tm;
        this.l = c0819b8;
        this.p = c0862d1;
        this.m = m0;
        this.q = requestDataHolder;
        this.r = responseDataHolder;
        this.o = fullUrlFormer;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0052 A[Catch: all -> 0x00a0, TRY_LEAVE, TryCatch #0 {all -> 0x00a0, blocks: (B:5:0x0020, B:6:0x0026, B:8:0x002d, B:20:0x0052, B:23:0x005e, B:26:0x006d, B:28:0x0076, B:37:0x0098, B:44:0x00ad, B:46:0x00bb, B:53:0x00c7, B:52:0x00c6, B:49:0x00c1, B:54:0x00cd, B:57:0x00df, B:60:0x00e6, B:41:0x00a5, B:63:0x00ee, B:18:0x004c, B:64:0x00f3, B:66:0x00f9, B:67:0x010e, B:69:0x0112), top: B:81:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00ee A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.yandex.metrica.impl.ob.P1.a a(long r17, com.yandex.metrica.impl.ob.C1199qf.d.b r19, com.yandex.metrica.impl.ob.Lg r20, java.util.List<java.lang.Throwable> r21, int r22) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.P1.a(long, com.yandex.metrica.impl.ob.qf$d$b, com.yandex.metrica.impl.ob.Lg, java.util.List, int):com.yandex.metrica.impl.ob.P1$a");
    }
}
