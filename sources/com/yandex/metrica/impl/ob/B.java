package com.yandex.metrica.impl.ob;

import android.app.NotificationManager;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.protobuf.nano.ym.MessageNano;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.yandex.metrica.AdRevenue;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.ecommerce.ECommerceEvent;
import com.yandex.metrica.impl.ob.C1318vf;
import com.yandex.metrica.plugins.IPluginReporter;
import com.yandex.metrica.plugins.PluginErrorDetails;
import com.yandex.metrica.profile.UserProfile;
import com.yandex.metrica.profile.UserProfileUpdate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class B implements I0 {
    private static final Collection<Integer> n = new HashSet(Arrays.asList(14, 15));
    private static final Kn<C1318vf> o = new a();
    protected final Context a;
    protected final Q1 b;
    protected final C0858cm c;
    protected final Sl d;
    protected final X6 e;
    protected final S6 f;
    protected final M6 g;
    private final K6 h;
    protected final T1 i;
    private C0812b1 j;
    private final InterfaceC0833bm k;
    private final A0 l;
    private final C1237s6 m;

    class a implements Kn<C1318vf> {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.Kn
        public In a(C1318vf c1318vf) {
            C1318vf.a[] aVarArr = c1318vf.a;
            return (aVarArr == null || aVarArr.length == 0) ? In.a(this, "attributes list is empty") : In.a(this);
        }
    }

    static final class b {
        private static final Kn<Revenue> a = new On();

        public static Kn<Revenue> a() {
            return a;
        }
    }

    B(Context context, T1 t1, Q1 q1, A0 a0, InterfaceC0833bm interfaceC0833bm, com.yandex.metrica.rtm.wrapper.d dVar, Yg yg, X6 x6, S6 s6, M6 m6, K6 k6, C1237s6 c1237s6) {
        this.a = context.getApplicationContext();
        this.i = t1;
        this.b = q1;
        this.l = a0;
        this.e = x6;
        this.f = s6;
        this.g = m6;
        this.h = k6;
        this.m = c1237s6;
        C0858cm c0858cmB = Ul.b(q1.b().a());
        this.c = c0858cmB;
        q1.a(new C0834bn(c0858cmB, "Crash Environment"));
        Sl slA = Ul.a(q1.b().a());
        this.d = slA;
        if (C0810b.a(q1.b().p())) {
            c0858cmB.setEnabled();
            slA.setEnabled();
        }
        this.k = interfaceC0833bm;
    }

    void a(C0812b1 c0812b1) {
        this.j = c0812b1;
    }

    @Override // com.yandex.metrica.impl.ob.I0, com.yandex.metrica.impl.ob.M0, com.yandex.metrica.d
    public void b(String str, String str2) {
        C0858cm c0858cm = this.c;
        List<Integer> list = C1399z0.i;
        this.i.a(new J(str2, str, EnumC0787a1.EVENT_TYPE_STATBOX.b(), 0, c0858cm), this.b);
        if (this.c.isEnabled()) {
            StringBuilder sb = new StringBuilder("Statbox event received ");
            sb.append(" with name: ");
            sb.append(f(str));
            sb.append(" with value: ");
            String strF = f(str2);
            if (strF.length() > 100) {
                sb.append(strF.substring(0, 100));
                sb.append("...");
            } else {
                sb.append(strF);
            }
            this.c.i(sb.toString());
        }
    }

    public void c(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.b.c.a(str, str2);
        } else if (this.c.isEnabled()) {
            this.c.fw("Invalid Error Environment (key,value) pair: (%s,%s).", str, str2);
        }
    }

    @Override // com.yandex.metrica.impl.ob.I0, com.yandex.metrica.impl.ob.M0, com.yandex.metrica.d
    public void d(String str, String str2) {
        List<Integer> list = C1399z0.i;
        this.i.a(new C0836c0(str2, str, EnumC0787a1.EVENT_TYPE_DIAGNOSTIC.b()), this.b);
    }

    void e(String str) {
        this.i.e();
        this.j.b();
        T1 t1 = this.i;
        C0858cm c0858cm = this.c;
        List<Integer> list = C1399z0.i;
        t1.a(new J("", str, EnumC0787a1.EVENT_TYPE_START.b(), c0858cm), this.b);
        this.b.h();
    }

    public void f() {
        this.i.b(this.b);
    }

    @Override // com.yandex.metrica.IReporter
    public IPluginReporter getPluginExtension() {
        return this;
    }

    @Override // com.yandex.metrica.IReporter
    public void pauseSession() {
        if (this.c.isEnabled()) {
            this.c.i("Pause session");
        }
        d(null);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportAdRevenue(AdRevenue adRevenue) {
        this.i.a(new Sg(adRevenue, this.c), this.b);
        if (this.c.isEnabled()) {
            C0858cm c0858cm = this.c;
            StringBuilder sb = new StringBuilder();
            sb.append("AdRevenue Received: AdRevenue{adRevenue=");
            sb.append(adRevenue.adRevenue);
            sb.append(", currency='");
            sb.append(f(adRevenue.currency.getCurrencyCode()));
            sb.append('\'');
            sb.append(", adType=");
            Object obj = adRevenue.adType;
            if (obj == null) {
                obj = "<null>";
            }
            sb.append(obj);
            sb.append(", adNetwork='");
            sb.append(f(adRevenue.adNetwork));
            sb.append('\'');
            sb.append(", adUnitId='");
            sb.append(f(adRevenue.adUnitId));
            sb.append('\'');
            sb.append(", adUnitName='");
            sb.append(f(adRevenue.adUnitName));
            sb.append('\'');
            sb.append(", adPlacementId='");
            sb.append(f(adRevenue.adPlacementId));
            sb.append('\'');
            sb.append(", adPlacementName='");
            sb.append(f(adRevenue.adPlacementName));
            sb.append('\'');
            sb.append(", precision='");
            sb.append(f(adRevenue.precision));
            sb.append('\'');
            sb.append(", payload=");
            sb.append(Tl.g(adRevenue.payload));
            sb.append('}');
            c0858cm.i(sb.toString());
        }
    }

    @Override // com.yandex.metrica.IReporter
    public void reportECommerce(ECommerceEvent eCommerceEvent) {
        if (this.c.isEnabled()) {
            this.c.i("E-commerce event received: " + eCommerceEvent.getPublicDescription());
        }
        this.i.a(eCommerceEvent, this.b);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(String str, Throwable th) {
        B6 b6 = new B6(str, a(th));
        T1 t1 = this.i;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(b6));
        C0858cm c0858cm = this.c;
        List<Integer> list = C1399z0.i;
        t1.a(new J(byteArray, str, EnumC0787a1.EVENT_TYPE_EXCEPTION_USER_PROTOBUF.b(), c0858cm), this.b);
        if (this.c.isEnabled()) {
            this.c.fi("Error received: %s", f(str));
        }
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String str) {
        if (this.c.isEnabled() && this.c.isEnabled()) {
            this.c.i("Event received: " + f(str));
        }
        C0858cm c0858cm = this.c;
        List<Integer> list = C1399z0.i;
        this.i.a(new J("", str, EnumC0787a1.EVENT_TYPE_REGULAR.b(), 0, c0858cm), this.b);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportRevenue(Revenue revenue) {
        In inA = b.a().a(revenue);
        if (!inA.b()) {
            if (this.c.isEnabled()) {
                this.c.w("Passed revenue is not valid. Reason: " + inA.a());
                return;
            }
            return;
        }
        this.i.a(new W1(revenue, this.c), this.b);
        if (this.c.isEnabled()) {
            StringBuilder sb = new StringBuilder("Revenue received ");
            sb.append("for productID: ");
            sb.append(f(revenue.productID));
            sb.append(" of quantity: ");
            Integer num = revenue.quantity;
            if (num != null) {
                sb.append(num);
            } else {
                sb.append("<null>");
            }
            sb.append(" with price");
            if (revenue.priceMicros != null) {
                sb.append(" (in micros): ");
                sb.append(revenue.priceMicros);
            } else {
                sb.append(": ");
                sb.append(revenue.price);
            }
            sb.append(" ");
            sb.append(revenue.currency);
            this.c.i(sb.toString());
        }
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUnhandledException(Throwable th) {
        H6 h6A = I6.a(th, new C1333w6(null, null, ((Xl) this.k).b()), null, this.l.a(), this.l.b());
        this.i.b(h6A, this.b);
        b(h6A);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUserProfile(UserProfile userProfile) {
        C0801af c0801af = new C0801af();
        Iterator<UserProfileUpdate<? extends InterfaceC0826bf>> it = userProfile.getUserProfileUpdates().iterator();
        while (it.hasNext()) {
            Se se = (Se) it.next().getUserProfileUpdatePatcher();
            se.a(this.c);
            se.a(c0801af);
        }
        C1318vf c1318vfC = c0801af.c();
        In inA = o.a(c1318vfC);
        if (inA.b()) {
            this.i.a(c1318vfC, this.b);
            if (this.c.isEnabled()) {
                this.c.i(new StringBuilder("User profile received").toString());
                return;
            }
            return;
        }
        if (this.c.isEnabled()) {
            this.c.w("UserInfo wasn't sent because " + inA.a());
        }
    }

    @Override // com.yandex.metrica.IReporter
    public void resumeSession() {
        e(null);
        if (this.c.isEnabled()) {
            this.c.i("Resume session");
        }
    }

    @Override // com.yandex.metrica.IReporter
    public void sendEventsBuffer() {
        T1 t1 = this.i;
        EnumC0787a1 enumC0787a1 = EnumC0787a1.EVENT_TYPE_PURGE_BUFFER;
        C0858cm c0858cm = this.c;
        List<Integer> list = C1399z0.i;
        t1.a(new J("", "", enumC0787a1.b(), 0, c0858cm), this.b);
    }

    @Override // com.yandex.metrica.IReporter
    public void setStatisticsSending(boolean z) {
        this.b.b().c(z);
    }

    @Override // com.yandex.metrica.IReporter
    public void setUserProfileID(String str) {
        this.i.b(str, this.b);
        if (this.c.isEnabled()) {
            this.c.i("Set user profile ID: " + f(str));
        }
    }

    public void a(Map<String, String> map) {
        if (A2.b(map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            c(entry.getKey(), entry.getValue());
        }
    }

    protected String f(String str) {
        return str == null ? "<null>" : str.isEmpty() ? "<empty>" : str;
    }

    @Override // com.yandex.metrica.impl.ob.I0
    public void a(String str, byte[] bArr) {
        T1 t1 = this.i;
        C0858cm c0858cm = this.c;
        List<Integer> list = C1399z0.i;
        J j = new J("", (String) null, EnumC0787a1.EVENT_TYPE_SET_SESSION_EXTRA.b(), c0858cm);
        if (bArr == null) {
            bArr = new byte[0];
        }
        j.a(Collections.singletonMap(str, bArr));
        t1.a(j, this.b);
    }

    @Override // com.yandex.metrica.impl.ob.I0
    public void c(String str) {
        this.i.a(str, this.b);
        if (this.c.isEnabled()) {
            this.c.i("Error received: native");
        }
    }

    @Override // com.yandex.metrica.plugins.IPluginReporter
    public void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        String strB;
        H6 h6A = this.m.a(pluginErrorDetails);
        T1 t1 = this.i;
        F6 f6 = h6A.a;
        String str = "";
        if (f6 != null && (strB = f6.b()) != null) {
            str = strB;
        }
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(h6A));
        C0858cm c0858cm = this.c;
        List<Integer> list = C1399z0.i;
        t1.a(new J(byteArray, str, EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF.b(), c0858cm), this.b);
        if (this.c.isEnabled()) {
            this.c.fi("Crash from plugin received: %s", f(pluginErrorDetails.getMessage()));
        }
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String str, String str2) {
        if (this.c.isEnabled()) {
            e(str, str2);
        }
        C0858cm c0858cm = this.c;
        List<Integer> list = C1399z0.i;
        this.i.a(new J(str2, str, EnumC0787a1.EVENT_TYPE_REGULAR.b(), 0, c0858cm), this.b);
    }

    void d(String str) {
        if (this.b.f()) {
            return;
        }
        this.i.d();
        this.j.a();
        this.b.g();
        T1 t1 = this.i;
        C0858cm c0858cm = this.c;
        List<Integer> list = C1399z0.i;
        t1.a(new J("", str, EnumC0787a1.EVENT_TYPE_UPDATE_FOREGROUND_TIME.b(), 0, c0858cm), this.b);
    }

    protected void b(H6 h6) {
        if (this.c.isEnabled()) {
            this.c.i("Unhandled exception received: " + h6.toString());
        }
    }

    @Override // com.yandex.metrica.impl.ob.M0
    public void b() throws JSONException {
        Integer numValueOf;
        T1 t1 = this.i;
        Context context = this.a;
        C0836c0 c0836c0 = new C0836c0();
        c0836c0.a = "";
        F0 f0G = F0.g();
        Intrinsics.checkNotNullExpressionValue(f0G, "GlobalServiceLocator.getInstance()");
        E eC = f0G.c();
        Intrinsics.checkNotNullExpressionValue(eC, "GlobalServiceLocator.get…nce().batteryInfoProvider");
        Integer numA = eC.a();
        long jElapsedRealtime = SystemClock.elapsedRealtime() / 1000;
        if (A2.a(23)) {
            try {
                Object systemService = context.getSystemService(RemoteMessageConst.NOTIFICATION);
                if (systemService != null) {
                    numValueOf = Integer.valueOf(((NotificationManager) systemService).getCurrentInterruptionFilter());
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
                }
            } catch (Throwable unused) {
            }
        } else {
            numValueOf = null;
        }
        JSONObject jSONObjectPut = new JSONObject().put("dfid", new JSONObject().putOpt("battery", numA).put("boot_time_seconds", jElapsedRealtime).putOpt("notification_filter", numValueOf));
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject()\n           …tionFilter)\n            )");
        c0836c0.e = EnumC0787a1.EVENT_TYPE_IDENTITY_LIGHT.b();
        c0836c0.b = jSONObjectPut.toString();
        t1.a(c0836c0, this.b);
    }

    @Override // com.yandex.metrica.impl.ob.I0
    public void b(String str) {
        this.i.a(C0836c0.a(str), this.b);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(String str, String str2) {
        reportError(str, str2, (Throwable) null);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(String str, String str2, Throwable th) {
        this.i.a(C1399z0.a(str2, MessageNano.toByteArray(this.g.fromModel(new C1405z6(new B6(str2, a(th)), str))), this.c), this.b);
        if (this.c.isEnabled()) {
            this.c.fi("Error received: id: %s, message: %s", f(str), f(str2));
        }
    }

    private void e(String str, String str2) {
        if (this.c.isEnabled()) {
            this.c.i("Event received: " + f(str) + ". With value: " + f(str2));
        }
    }

    @Override // com.yandex.metrica.plugins.IPluginReporter
    public void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        C1237s6 c1237s6 = this.m;
        c1237s6.getClass();
        this.i.a(C1399z0.a(str, MessageNano.toByteArray(this.f.fromModel(new B6(str, pluginErrorDetails != null ? c1237s6.a(pluginErrorDetails) : null))), this.c), this.b);
        if (this.c.isEnabled()) {
            this.c.fi("Error from plugin received: %s", f(str));
        }
    }

    boolean e() {
        boolean zF = this.b.f();
        boolean z = !zF;
        if (!zF) {
            C0858cm c0858cm = this.c;
            List<Integer> list = C1399z0.i;
            this.i.a(new J("", "", EnumC0787a1.EVENT_TYPE_UPDATE_FOREGROUND_TIME.b(), 0, c0858cm), this.b);
        }
        return z;
    }

    @Override // com.yandex.metrica.plugins.IPluginReporter
    public void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        C1237s6 c1237s6 = this.m;
        c1237s6.getClass();
        this.i.a(C1399z0.a(str2, MessageNano.toByteArray(this.g.fromModel(new C1405z6(new B6(str2, pluginErrorDetails != null ? c1237s6.a(pluginErrorDetails) : null), str))), this.c), this.b);
        if (this.c.isEnabled()) {
            this.c.fi("Error with identifier: %s from plugin received: %s", str, f(str2));
        }
    }

    @Override // com.yandex.metrica.impl.ob.I0
    public void a(int i, String str, String str2, Map<String, String> map, Map<String, byte[]> map2) {
        if (n.contains(Integer.valueOf(i)) || i < 1 || i > 99) {
            HashMap map3 = map == null ? null : new HashMap(map);
            C0858cm c0858cm = this.c;
            List<Integer> list = C1399z0.i;
            C0836c0 c0836c0C = new J(str2, str, EnumC0787a1.EVENT_TYPE_CUSTOM_EVENT.b(), i, c0858cm).c(Tl.g(map3));
            if (map2 != null) {
                c0836c0C.a(map2);
            }
            this.i.a(c0836c0C, this.b);
        }
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String str, Map<String, Object> map) {
        HashMap map2 = A2.b(map) ? null : new HashMap(map);
        T1 t1 = this.i;
        C0858cm c0858cm = this.c;
        List<Integer> list = C1399z0.i;
        t1.a(new J("", str, EnumC0787a1.EVENT_TYPE_REGULAR.b(), 0, c0858cm), this.b, map2);
        if (this.c.isEnabled()) {
            e(str, map2 != null ? map2.toString() : null);
        }
    }

    private H6 a(Throwable th) {
        Throwable th2;
        StackTraceElement[] stackTrace;
        if (th == null) {
            stackTrace = null;
            th2 = null;
        } else if (th instanceof C1041k6) {
            stackTrace = th.getStackTrace();
            th2 = null;
        } else {
            th2 = th;
            stackTrace = null;
        }
        return I6.a(th2, new C1333w6(null, null, ((Xl) this.k).b()), stackTrace != null ? Arrays.asList(stackTrace) : null, this.l.a(), this.l.b());
    }

    @Override // com.yandex.metrica.impl.ob.R0
    public void a(H6 h6) {
        this.i.a(h6, this.b);
        b(h6);
    }

    @Override // com.yandex.metrica.impl.ob.R0
    public void a(C1333w6 c1333w6) {
        C1357x6 c1357x6 = new C1357x6(c1333w6, this.l.a(), this.l.b());
        T1 t1 = this.i;
        byte[] byteArray = MessageNano.toByteArray(this.h.fromModel(c1357x6));
        C0858cm c0858cm = this.c;
        List<Integer> list = C1399z0.i;
        t1.a(new J(byteArray, "", EnumC0787a1.EVENT_TYPE_ANR.b(), c0858cm), this.b);
    }

    @Override // com.yandex.metrica.impl.ob.M0
    public void a(String str, JSONObject jSONObject) {
        T1 t1 = this.i;
        C0836c0 c0836c0 = new C0836c0();
        c0836c0.a = str;
        c0836c0.e = EnumC0787a1.EVENT_TYPE_APPMETRICA_DIAGNOSTICS.b();
        c0836c0.b = jSONObject.toString();
        t1.a(c0836c0, this.b);
    }

    @Override // com.yandex.metrica.impl.ob.I0
    public void a(String str, String str2) {
        e(str, str2);
        C0858cm c0858cm = this.c;
        List<Integer> list = C1399z0.i;
        this.i.a(new J(str2, str, EnumC0787a1.EVENT_TYPE_REGULAR.b(), 0, c0858cm).a(EnumC1375y0.JS), this.b);
    }
}
