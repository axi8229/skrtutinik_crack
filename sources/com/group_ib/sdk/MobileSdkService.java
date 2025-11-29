package com.group_ib.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MobileSdkService extends Service implements S0 {
    public static final String O = X.b(6);
    public final BinderC0603j a = new BinderC0603j(this);
    public Thread b = null;
    public Looper c = null;
    public ExecutorC0607l d = null;
    public HandlerThread e = null;
    public boolean f = false;
    public boolean g = false;
    public volatile G h = null;
    public final LinkedHashMap i = new LinkedHashMap();
    public HandlerC0598g0 j = null;
    public boolean k = true;
    public E0 l = null;
    public final Handler m = new Handler(Looper.getMainLooper());
    public final Object p = new Object();
    public HandlerC0605k q = null;
    public K r = null;
    public JSONObject s = null;
    public C0602i0 t = null;
    public JSONArray u = null;
    public JSONArray v = null;
    public JSONArray w = null;
    public b1 x = null;
    public b1 y = null;
    public JSONArray z = null;
    public JSONArray A = null;
    public C0630x0 B = null;
    public JSONObject C = null;
    public JSONObject D = null;
    public JSONArray E = null;
    public JSONArray F = null;
    public JSONArray G = null;
    public String H = null;
    public N I = null;
    public JSONArray J = null;
    public JSONObject K = null;
    public volatile String L = null;
    public JSONArray M = null;
    public b1 N = null;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.a;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        c1.a(4, 4, O, "onDestroy");
        try {
            U0.b.a(Looper.getMainLooper());
            U0.c.a(null);
            U0.a.shutdown();
            synchronized (this.i) {
                try {
                    Iterator it = this.i.values().iterator();
                    while (it.hasNext()) {
                        ((d1) it.next()).a();
                    }
                    this.i.clear();
                } finally {
                }
            }
            T.v = null;
            T.b();
            Looper looper = this.c;
            if (looper != null) {
                looper.quit();
                this.c = null;
            }
            this.e = null;
            if (this.h != null) {
                this.h.sendEmptyMessage(3);
                this.h = null;
            }
            this.b = null;
            super.onDestroy();
        } catch (Exception e) {
            c1.b(O, e.toString(), e);
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return 2;
    }

    @Override // com.group_ib.sdk.S0
    public final void a(int i, Object obj) {
        String str;
        String str2;
        if (i != 1) {
            if (i != 2) {
                if (i != 5) {
                    return;
                }
                if (obj instanceof Boolean) {
                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                    c1.a(4, 4, O, "Application has just became ".concat(zBooleanValue ? "foreground" : "background"));
                    synchronized (this.p) {
                        try {
                            if (this.A == null) {
                                this.A = new JSONArray();
                            }
                            this.A.put(new JSONObject().put(AppMeasurementSdk.ConditionalUserProperty.NAME, zBooleanValue ? T.e() : "null").put("elapsed", System.currentTimeMillis() - C0595f.h));
                        } catch (Exception e) {
                            c1.a(O, "failed to add foreground history", e);
                        } finally {
                        }
                        HandlerC0605k handlerC0605k = this.q;
                        if (handlerC0605k != null) {
                            handlerC0605k.a(false);
                        }
                    }
                    synchronized (this.i) {
                        int i2 = zBooleanValue ? 16 : 32;
                        try {
                            Iterator it = this.i.values().iterator();
                            while (it.hasNext()) {
                                ((d1) it.next()).a(i2);
                            }
                            this.k = true;
                        } finally {
                        }
                    }
                    G g = this.h;
                    if (zBooleanValue) {
                        if (g != null) {
                            g.sendEmptyMessage(6);
                        }
                        c1.d();
                        return;
                    } else {
                        if (g != null) {
                            g.sendEmptyMessage(7);
                        }
                        c1.c();
                        return;
                    }
                }
                str = O;
                str2 = "GC_FOREGROUND_STATUS_CHANGED called for non-boolean instance";
            } else if (obj instanceof WebView) {
                a((WebView) obj);
                return;
            } else {
                str = O;
                str2 = "GC_DISPATCH_ON_PAGE_STARTED called for non-WebView instance";
            }
        } else if (obj instanceof String) {
            String str3 = T.a;
            a((WebView) null);
            return;
        } else {
            str = O;
            str2 = "GC_DISPATCH_ON_SDK_SESSION_OPENED called for non-String value";
        }
        c1.a(str, str2);
    }

    public final String b() {
        E0 e0 = this.l;
        String string = null;
        if (e0 != null) {
            synchronized (e0) {
                try {
                    HashMap mapA = e0.a();
                    if (mapA != null) {
                        StringBuilder sb = new StringBuilder();
                        for (Map.Entry entry : mapA.entrySet()) {
                            sb.append((String) entry.getKey());
                            sb.append('=');
                            sb.append((String) entry.getValue());
                            sb.append(';');
                        }
                        string = sb.toString();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return string;
    }

    public final void c() {
        c1.a(2, 2, O, "Connection to Internet disappeared");
        synchronized (this.i) {
            try {
                Iterator it = this.i.values().iterator();
                while (it.hasNext()) {
                    ((d1) it.next()).a(8);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        this.g = true;
        synchronized (this.i) {
            try {
                Iterator it = this.i.values().iterator();
                while (it.hasNext()) {
                    ((d1) it.next()).a(64);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        synchronized (this.i) {
            try {
                Iterator it = this.i.values().iterator();
                while (it.hasNext()) {
                    ((d1) it.next()).a(256);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Looper f() {
        return this.c;
    }

    public final void b(JSONArray jSONArray) {
        synchronized (this.p) {
            this.z = jSONArray;
            this.q.a(false);
        }
    }

    public final void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        synchronized (this.p) {
            try {
                if (this.E == null) {
                    this.E = new JSONArray();
                }
                this.E.put(jSONObject);
                if (this.E.length() >= 5) {
                    this.q.a(false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(WebView webView) {
        String string;
        StringBuilder sb;
        if (webView == null) {
            return;
        }
        synchronized (this) {
            try {
                if (!this.f) {
                    c1.a(4, 4, O, "Mobile SDK still not opened, skip App WebView initialization");
                    return;
                }
                E0 e0 = this.l;
                String str = null;
                HashMap mapA = e0 != null ? e0.a() : null;
                if (mapA != null) {
                    try {
                        CookieManager cookieManager = CookieManager.getInstance();
                        cookieManager.setAcceptCookie(true);
                        cookieManager.setAcceptThirdPartyCookies(webView, true);
                        String url = webView.getUrl();
                        if (url == null) {
                            return;
                        }
                        URL url2 = new URL(url);
                        String host = url2.getHost();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(url2.getProtocol());
                        sb2.append("://");
                        sb2.append(host);
                        sb2.append(url2.getPort() != -1 ? ":" + url2.getPort() : "");
                        sb2.append("/");
                        String string2 = sb2.toString();
                        for (Map.Entry entry : mapA.entrySet()) {
                            cookieManager.setCookie(string2, ((String) entry.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + ((String) entry.getValue()) + "; Domain=" + host);
                        }
                        cookieManager.flush();
                    } catch (MalformedURLException e) {
                        c1.b(O, "Application WebView holds malformed url", e);
                        return;
                    } catch (Exception e2) {
                        c1.a(O, "failed to access webkit cookie manager", e2);
                    }
                }
                try {
                    string = Settings.Secure.getString(getContentResolver(), "android_id");
                } catch (Exception unused) {
                    string = null;
                }
                if (AbstractC0604j0.a((Context) this)) {
                    sb = new StringBuilder();
                    sb.append("FHP Web Snippet params:\n\tcid: ");
                    sb.append(T.a);
                    sb.append("\n\tbackUrl: ");
                    sb.append(T.k());
                    sb.append("\n");
                } else {
                    sb = null;
                }
                String str2 = T.a;
                if (mapA != null && !mapA.isEmpty()) {
                    String str3 = (String) mapA.get("cfids" + T.a);
                    String str4 = (String) mapA.get("gssc" + T.a);
                    String str5 = (String) mapA.get("__gsac_" + T.a);
                    String str6 = "if (typeof(window.gib.setCFIDS) === 'function') window.gib.setCFIDS('" + (str3 != null ? str3 : "") + "');\nif (typeof(window.gib.setGSSC) === 'function') window.gib.setGSSC('" + (str4 != null ? str4 : "") + "');\n if (typeof(window.gib.setGSAC) === 'function') window.gib.setGSAC('" + (str5 != null ? str5 : "") + "');\n";
                    if (sb != null) {
                        if (str3 != null) {
                            sb.append("\tcfids: ");
                            sb.append(str3);
                            sb.append("\n");
                        }
                        if (str4 != null) {
                            sb.append("\tgssc: ");
                            sb.append(str4);
                            sb.append("\n");
                        }
                        if (str5 != null) {
                            sb.append("\tgsac: ");
                            sb.append(str5);
                            sb.append("\n");
                        }
                    }
                    str = str6;
                }
                StringBuilder sb3 = new StringBuilder("javascript:window.onGIBLoad=function(){\nwindow.gib.setAttribute('android_id', '");
                sb3.append(string);
                sb3.append("', {persistent: true});\n");
                if (str == null) {
                    str = "";
                }
                sb3.append(str);
                sb3.append("window.gib.init({cid:'");
                sb3.append(T.a);
                sb3.append("', \nbackUrl:'");
                sb3.append(T.k());
                sb3.append("',\nsilentAlive: true});\nwindow.gib.mobileSdkSend = function() { typeof(window.AndroidSdk.send) === 'function' && window.AndroidSdk.send(); }\n};\nif(window.gib != undefined) window.onGIBLoad();\n");
                webView.loadUrl(sb3.toString());
                String str7 = O;
                c1.a(4, 4, str7, "App WebView notified to run embedded FHP Web Snippet");
                if (sb != null) {
                    c1.a(str7, sb.toString());
                }
            } finally {
            }
        }
    }

    public final void a(N n) {
        if (n != null) {
            c1.a(4, 4, O, n.b + " activity event(s) added");
            synchronized (this.p) {
                try {
                    this.I = n;
                    HandlerC0605k handlerC0605k = this.q;
                    if (handlerC0605k != null) {
                        handlerC0605k.a(false);
                    }
                } finally {
                }
            }
        }
    }

    public final void a(C0602i0 c0602i0) {
        synchronized (this.p) {
            this.t = c0602i0;
        }
    }

    public final void a(C0630x0 c0630x0) {
        synchronized (this.p) {
            try {
                C0630x0 c0630x02 = this.B;
                if (c0630x02 != null) {
                    c0630x02.a(c0630x0);
                } else {
                    this.B = c0630x0;
                }
                this.q.a(false);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004e A[Catch: all -> 0x0048, TryCatch #0 {all -> 0x0048, blocks: (B:6:0x0006, B:8:0x000a, B:9:0x0012, B:11:0x0018, B:17:0x0034, B:20:0x0039, B:29:0x005f, B:25:0x004a, B:27:0x004e, B:28:0x0055), top: B:33:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.group_ib.sdk.b1 r9, boolean r10) {
        /*
            r8 = this;
            if (r9 != 0) goto L3
            return
        L3:
            java.lang.Object r0 = r8.p
            monitor-enter(r0)
            com.group_ib.sdk.b1 r1 = r8.x     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L4a
            java.util.Set r2 = r9.entrySet()     // Catch: java.lang.Throwable -> L48
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L48
        L12:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L48
            if (r3 == 0) goto L5f
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L48
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> L48
            java.lang.Object r4 = r3.getValue()     // Catch: java.lang.Throwable -> L48
            java.lang.Object r3 = r3.getKey()     // Catch: java.lang.Throwable -> L48
            java.lang.Object r3 = r1.get(r3)     // Catch: java.lang.Throwable -> L48
            r5 = 0
            r6 = 1
            if (r3 != 0) goto L30
            r7 = r6
            goto L31
        L30:
            r7 = r5
        L31:
            if (r4 != 0) goto L34
            r5 = r6
        L34:
            r5 = r5 ^ r7
            if (r5 != 0) goto L4a
            if (r3 == 0) goto L12
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L48
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L48
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L48
            if (r3 != 0) goto L12
            goto L4a
        L48:
            r9 = move-exception
            goto L61
        L4a:
            com.group_ib.sdk.b1 r1 = r8.y     // Catch: java.lang.Throwable -> L48
            if (r1 != 0) goto L55
            com.group_ib.sdk.b1 r1 = new com.group_ib.sdk.b1     // Catch: java.lang.Throwable -> L48
            r1.<init>()     // Catch: java.lang.Throwable -> L48
            r8.y = r1     // Catch: java.lang.Throwable -> L48
        L55:
            com.group_ib.sdk.b1 r1 = r8.y     // Catch: java.lang.Throwable -> L48
            r1.putAll(r9)     // Catch: java.lang.Throwable -> L48
            com.group_ib.sdk.k r9 = r8.q     // Catch: java.lang.Throwable -> L48
            r9.a(r10)     // Catch: java.lang.Throwable -> L48
        L5f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L48
            return
        L61:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L48
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.MobileSdkService.a(com.group_ib.sdk.b1, boolean):void");
    }

    public final synchronized void a(String str, String str2) {
        E0 e0;
        try {
            E0 e02 = this.l;
            if (e02 != null) {
                e02.a("cfids" + T.a, str);
            }
            if (str2 != null && (e0 = this.l) != null) {
                e0.a("gssc" + T.a, str2);
            }
            if (!this.f) {
                c1.a(4, 4, O, "Session opened: ".concat(str));
                InterfaceC0609m interfaceC0609m = T.e;
                if (interfaceC0609m != null) {
                    String str3 = T.a;
                    this.m.post(new RunnableC0599h(interfaceC0609m, str));
                }
                U0.b.a(1, str);
                synchronized (this.i) {
                    try {
                        Iterator it = this.i.values().iterator();
                        while (it.hasNext()) {
                            ((d1) it.next()).a(128);
                        }
                    } finally {
                    }
                }
                this.f = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void a(JSONArray jSONArray) {
        synchronized (this.p) {
            if (this.G != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        this.G.put(jSONArray.getJSONObject(i));
                    } catch (Exception e) {
                        c1.a(O, "failed to add access point", e);
                    }
                }
            } else {
                this.G = jSONArray;
            }
            if (this.G.length() > 50) {
                this.q.a(false);
            }
        }
    }

    public final void a(JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3) {
        synchronized (this.p) {
            if (jSONArray != null) {
                try {
                    this.u = jSONArray;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (jSONArray2 != null) {
                this.v = jSONArray2;
            }
            if (jSONArray3 != null) {
                this.w = jSONArray3;
            }
            HandlerC0605k handlerC0605k = this.q;
            if (handlerC0605k != null) {
                handlerC0605k.a(false);
            }
        }
    }

    public final void a(JSONObject jSONObject) {
        synchronized (this.p) {
            this.C = jSONObject;
        }
    }

    public final void a(EnumC0589c enumC0589c) {
        synchronized (this.i) {
            try {
                d1 c0632y0 = (d1) this.i.get(enumC0589c.name());
                if (c0632y0 == null) {
                    switch (AbstractC0601i.a[enumC0589c.ordinal()]) {
                        case 1:
                            a();
                            break;
                        case 2:
                            c0632y0 = new C0632y0(this);
                            break;
                        case 3:
                            c0632y0 = new e1(this);
                            break;
                        case 4:
                            c0632y0 = new C0628w0(this);
                            break;
                        case 5:
                            c0632y0 = new HandlerC0626v0(this);
                            break;
                        case 6:
                            if (Thread.currentThread() == getMainLooper().getThread()) {
                                if (this.j == null) {
                                    this.j = new HandlerC0598g0(this);
                                }
                                c0632y0 = this.j;
                                break;
                            } else {
                                c1.a(1, 1, O, "Capability 'ActivityCollectionCapability' is tried to enable from non-UI thread, ignore");
                                return;
                            }
                        case 7:
                            if (this.r == null) {
                                this.r = new K(this);
                            }
                            c0632y0 = this.r;
                            break;
                    }
                    if (c0632y0 != null) {
                        this.i.put(enumC0589c.name(), c0632y0);
                        c0632y0.run();
                        if (this.k) {
                            c0632y0.a(16);
                        }
                    }
                }
            } finally {
            }
        }
    }

    public final void a() {
        synchronized (this.p) {
            try {
                if (this.H != null) {
                    return;
                }
                if (T.h() != null) {
                    synchronized (this.i) {
                        try {
                            if (((d1) this.i.get("GlobalIdentificationCapability")) == null) {
                                Q0 q0 = new Q0(this);
                                this.i.put("GlobalIdentificationCapability", q0);
                                q0.sendEmptyMessage(1);
                            }
                        } finally {
                        }
                    }
                }
            } finally {
            }
        }
    }

    public final void a(String str) {
        synchronized (this.p) {
            this.H = str;
        }
        synchronized (this.i) {
            try {
                d1 d1Var = (d1) this.i.remove("GlobalIdentificationCapability");
                if (d1Var != null) {
                    d1Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
