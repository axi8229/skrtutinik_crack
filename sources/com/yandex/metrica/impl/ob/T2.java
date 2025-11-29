package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.yandex.metrica.AppMetricaDeviceIDListener;
import com.yandex.metrica.DeferredDeeplinkListener;
import com.yandex.metrica.DeferredDeeplinkParametersListener;
import com.yandex.metrica.IIdentifierCallback;
import com.yandex.metrica.YandexMetricaConfig;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class T2 implements T0 {
    private static final EnumMap<IIdentifierCallback.Reason, AppMetricaDeviceIDListener.Reason> n;
    private final Context a;
    private final C0820b9 b;
    private final C0979hi c;
    private final C0827bg d;
    private final A3 e;
    private final R1 f;
    private final T1 g;
    private final C1060l0 h;
    private final C1289ua i;
    private final C1278u j;
    private final C1137o2 k;
    private volatile C1036k1 l;
    private IIdentifierCallback m;

    class a implements IIdentifierCallback {
        final /* synthetic */ AppMetricaDeviceIDListener a;

        a(AppMetricaDeviceIDListener appMetricaDeviceIDListener) {
            this.a = appMetricaDeviceIDListener;
        }

        @Override // com.yandex.metrica.IIdentifierCallback
        public void onReceive(Map<String, String> map) {
            T2.a(T2.this, (IIdentifierCallback) null);
            this.a.onLoaded(map.get("appmetrica_device_id_hash"));
        }

        @Override // com.yandex.metrica.IIdentifierCallback
        public void onRequestError(IIdentifierCallback.Reason reason) {
            T2.a(T2.this, (IIdentifierCallback) null);
            this.a.onError((AppMetricaDeviceIDListener.Reason) T2.n.get(reason));
        }
    }

    static {
        EnumMap<IIdentifierCallback.Reason, AppMetricaDeviceIDListener.Reason> enumMap = new EnumMap<>(IIdentifierCallback.Reason.class);
        n = enumMap;
        enumMap.put((EnumMap<IIdentifierCallback.Reason, AppMetricaDeviceIDListener.Reason>) IIdentifierCallback.Reason.UNKNOWN, (IIdentifierCallback.Reason) AppMetricaDeviceIDListener.Reason.UNKNOWN);
        enumMap.put((EnumMap<IIdentifierCallback.Reason, AppMetricaDeviceIDListener.Reason>) IIdentifierCallback.Reason.INVALID_RESPONSE, (IIdentifierCallback.Reason) AppMetricaDeviceIDListener.Reason.INVALID_RESPONSE);
        enumMap.put((EnumMap<IIdentifierCallback.Reason, AppMetricaDeviceIDListener.Reason>) IIdentifierCallback.Reason.NETWORK, (IIdentifierCallback.Reason) AppMetricaDeviceIDListener.Reason.NETWORK);
    }

    T2(Context context, S0 s0) {
        this(context.getApplicationContext(), s0, new C0820b9(C1020ja.a(context.getApplicationContext()).c()));
    }

    static /* synthetic */ IIdentifierCallback a(T2 t2, IIdentifierCallback iIdentifierCallback) {
        t2.m = null;
        return null;
    }

    @Override // com.yandex.metrica.impl.ob.O0
    public N0 b() {
        return this.f;
    }

    @Override // com.yandex.metrica.impl.ob.T0
    public void c(com.yandex.metrica.e eVar) {
        this.f.c(eVar);
    }

    @Override // com.yandex.metrica.impl.ob.T0
    public C1036k1 d() {
        return this.l;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1111n1
    public void setStatisticsSending(boolean z) {
        this.l.b().setStatisticsSending(z);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1111n1
    public void setUserProfileID(String str) {
        this.l.b().setUserProfileID(str);
    }

    @Override // com.yandex.metrica.impl.ob.T0
    public void a(YandexMetricaConfig yandexMetricaConfig, com.yandex.metrica.i iVar) {
        this.i.a(this.a, this.c).a(yandexMetricaConfig, this.c.c());
        C0858cm c0858cmB = Ul.b(iVar.apiKey);
        Sl slA = Ul.a(iVar.apiKey);
        this.h.getClass();
        if (this.l != null) {
            if (c0858cmB.isEnabled()) {
                c0858cmB.w("Appmetrica already has been activated!");
                return;
            }
            return;
        }
        this.d.a();
        this.c.a(c0858cmB);
        this.c.a(iVar.d);
        this.c.a(iVar.b);
        this.c.a(iVar.c);
        if (A2.a((Object) iVar.c)) {
            this.c.b("api");
        }
        this.e.b(iVar);
        this.g.a(iVar.locationTracking, iVar.statisticsSending, (Boolean) null);
        C1011j1 c1011j1A = this.f.a(iVar, false, this.b);
        this.l = new C1036k1(c1011j1A, new C1010j0(c1011j1A));
        this.j.a(this.l.a());
        this.k.a(c1011j1A);
        this.c.g();
        Log.i("AppMetrica", "Activate AppMetrica with APIKey " + A2.a(iVar.apiKey));
        if (Boolean.TRUE.equals(iVar.logs)) {
            c0858cmB.setEnabled();
            slA.setEnabled();
            C0858cm.a().setEnabled();
            Sl.a().setEnabled();
            return;
        }
        c0858cmB.setDisabled();
        slA.setDisabled();
        C0858cm.a().setDisabled();
        Sl.a().setDisabled();
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1111n1
    public void b(boolean z) {
        this.l.b().b(z);
    }

    @Override // com.yandex.metrica.impl.ob.T0
    public String c() {
        return this.c.b();
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1111n1
    public void c(String str, String str2) {
        this.l.b().c(str, str2);
    }

    private T2(Context context, S0 s0, C0820b9 c0820b9) {
        this(context, s0, c0820b9, new O(context), new U2(), P.g(), new C1289ua());
    }

    T2(Context context, S0 s0, C0820b9 c0820b9, O o, U2 u2, P p, C1289ua c1289ua) {
        this.a = context;
        this.b = c0820b9;
        Handler handlerC = s0.c();
        A3 a3A = u2.a(context, u2.a(handlerC, this));
        this.e = a3A;
        C1060l0 c1060l0F = p.f();
        this.h = c1060l0F;
        T1 t1A = u2.a(a3A, context, s0.b());
        this.g = t1A;
        c1060l0F.a(t1A);
        o.a(context);
        C0979hi c0979hiA = u2.a(context, t1A, c0820b9, handlerC);
        this.c = c0979hiA;
        this.j = s0.a();
        this.i = c1289ua;
        t1A.a(c0979hiA);
        this.d = u2.a(t1A, c0820b9, handlerC);
        this.f = u2.a(context, a3A, t1A, handlerC, c0979hiA);
        this.k = p.l();
    }

    @Override // com.yandex.metrica.impl.ob.ResultReceiverC0911f0.a
    public void a(int i, Bundle bundle) {
        this.c.a(bundle, (Yh) null);
    }

    @Override // com.yandex.metrica.impl.ob.T0
    public void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.d.a(deferredDeeplinkParametersListener);
    }

    @Override // com.yandex.metrica.impl.ob.T0
    public void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        this.d.a(deferredDeeplinkListener);
    }

    @Override // com.yandex.metrica.impl.ob.T0
    public void a(AppMetricaDeviceIDListener appMetricaDeviceIDListener) {
        a aVar = new a(appMetricaDeviceIDListener);
        this.m = aVar;
        this.c.a(aVar, Collections.singletonList("appmetrica_device_id_hash"), this.e.a());
    }

    @Override // com.yandex.metrica.impl.ob.T0
    public M0 a(com.yandex.metrica.e eVar) {
        return this.f.b(eVar);
    }

    @Override // com.yandex.metrica.impl.ob.T0
    public String a() {
        return this.c.e();
    }

    @Override // com.yandex.metrica.impl.ob.T0
    public void a(IIdentifierCallback iIdentifierCallback, List<String> list) {
        this.c.a(iIdentifierCallback, list, this.e.a());
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1111n1
    public void a(Location location) {
        this.l.b().a(location);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1111n1
    public void a(boolean z) {
        this.l.b().a(z);
    }
}
