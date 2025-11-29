package com.yandex.metrica.impl.ob;

import android.location.Location;
import com.yandex.metrica.i;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.yandex.metrica.impl.ob.l0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1060l0 implements InterfaceC1111n1 {
    private Location a;
    private Boolean b;
    private Boolean c;
    private Boolean d;
    private Map<String, String> e = new LinkedHashMap();
    private Map<String, String> f = new LinkedHashMap();
    private String g;
    private boolean h;
    private T1 i;

    private static boolean a(Object obj) {
        return obj == null;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1111n1
    public void a(boolean z) {
        this.c = Boolean.valueOf(z);
        b();
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1111n1
    public void b(boolean z) {
        this.b = Boolean.valueOf(z);
        b();
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1111n1
    public void c(String str, String str2) {
        this.f.put(str, str2);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1111n1
    public void setStatisticsSending(boolean z) {
        this.d = Boolean.valueOf(z);
        b();
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1111n1
    public void setUserProfileID(String str) {
        this.g = str;
    }

    private void b(Map<String, String> map, i.b bVar) {
        if (A2.b(map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bVar.b(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1111n1
    public void a(Location location) {
        this.a = location;
    }

    public com.yandex.metrica.i a(com.yandex.metrica.i iVar) {
        if (this.h) {
            return iVar;
        }
        i.b bVarA = com.yandex.metrica.i.a(iVar.apiKey);
        bVarA.a(iVar.b, iVar.i);
        bVarA.b(iVar.a);
        bVarA.a(iVar.preloadInfo);
        bVarA.a(iVar.location);
        if (A2.a((Object) iVar.d)) {
            bVarA.a(iVar.d);
        }
        if (A2.a((Object) iVar.appVersion)) {
            bVarA.a(iVar.appVersion);
        }
        if (A2.a(iVar.f)) {
            bVarA.b(iVar.f.intValue());
        }
        if (A2.a(iVar.e)) {
            bVarA.a(iVar.e.intValue());
        }
        if (A2.a(iVar.g)) {
            bVarA.c(iVar.g.intValue());
        }
        if (A2.a(iVar.logs) && iVar.logs.booleanValue()) {
            bVarA.b();
        }
        if (A2.a(iVar.sessionTimeout)) {
            bVarA.e(iVar.sessionTimeout.intValue());
        }
        if (A2.a(iVar.crashReporting)) {
            bVarA.d(iVar.crashReporting.booleanValue());
        }
        if (A2.a(iVar.nativeCrashReporting)) {
            bVarA.f(iVar.nativeCrashReporting.booleanValue());
        }
        if (A2.a(iVar.locationTracking)) {
            bVarA.e(iVar.locationTracking.booleanValue());
        }
        if (A2.a((Object) iVar.c)) {
            bVarA.f = iVar.c;
        }
        if (A2.a(iVar.firstActivationAsUpdate)) {
            bVarA.a(iVar.firstActivationAsUpdate.booleanValue());
        }
        if (A2.a(iVar.statisticsSending)) {
            bVarA.j(iVar.statisticsSending.booleanValue());
        }
        if (A2.a(iVar.k)) {
            bVarA.b(iVar.k.booleanValue());
        }
        if (A2.a(iVar.maxReportsInDatabaseCount)) {
            bVarA.d(iVar.maxReportsInDatabaseCount.intValue());
        }
        if (A2.a((Object) null)) {
            bVarA.a((com.yandex.metrica.c) null);
        }
        if (A2.a((Object) iVar.userProfileID)) {
            bVarA.c(iVar.userProfileID);
        }
        if (A2.a(iVar.revenueAutoTrackingEnabled)) {
            bVarA.h(iVar.revenueAutoTrackingEnabled.booleanValue());
        }
        if (A2.a(iVar.appOpenTrackingEnabled)) {
            bVarA.c(iVar.appOpenTrackingEnabled.booleanValue());
        }
        a(this.e, bVarA);
        a(iVar.h, bVarA);
        b(this.f, bVarA);
        b(iVar.errorEnvironment, bVarA);
        Boolean bool = this.b;
        if (a(iVar.locationTracking) && A2.a(bool)) {
            bVarA.e(bool.booleanValue());
        }
        Location location = this.a;
        if (a((Object) iVar.location) && A2.a(location)) {
            bVarA.a(location);
        }
        Boolean bool2 = this.d;
        if (a(iVar.statisticsSending) && A2.a(bool2)) {
            bVarA.j(bool2.booleanValue());
        }
        if (!A2.a((Object) iVar.userProfileID) && A2.a((Object) this.g)) {
            bVarA.c(this.g);
        }
        this.h = true;
        this.a = null;
        this.b = null;
        this.d = null;
        this.e.clear();
        this.f.clear();
        this.g = null;
        return bVarA.a();
    }

    private void b() {
        T1 t1 = this.i;
        if (t1 != null) {
            t1.a(this.b, this.d, this.c);
        }
    }

    private void a(Map<String, String> map, i.b bVar) {
        if (A2.b(map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bVar.a(entry.getKey(), entry.getValue());
        }
    }

    public void a(T1 t1) {
        this.i = t1;
    }
}
