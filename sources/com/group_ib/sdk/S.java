package com.group_ib.sdk;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class S implements d1 {
    public final MobileSdkService a;
    public ConnectivityManager b = null;
    public P c = null;

    public S(MobileSdkService mobileSdkService) {
        this.a = mobileSdkService;
    }

    @Override // com.group_ib.sdk.d1
    public final void a(int i) {
    }

    @Override // com.group_ib.sdk.d1
    public final void run() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
        this.b = connectivityManager;
        if (connectivityManager != null) {
            P p = new P(this);
            this.c = p;
            this.b.registerDefaultNetworkCallback(p);
        }
    }

    public static void a(S s) {
        NetworkInfo activeNetworkInfo = s.b.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (!activeNetworkInfo.isConnected()) {
                s.a.c();
                return;
            }
            MobileSdkService mobileSdkService = s.a;
            mobileSdkService.getClass();
            c1.a(3, 3, MobileSdkService.O, "Connection to Internet restored or changed");
            synchronized (mobileSdkService.i) {
                try {
                    Iterator it = mobileSdkService.i.values().iterator();
                    while (it.hasNext()) {
                        ((d1) it.next()).a(4);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            G g = mobileSdkService.h;
            if (g != null) {
                g.sendEmptyMessage(1);
            }
            c1.b();
        }
    }

    @Override // com.group_ib.sdk.d1
    public final void a() {
        P p;
        ConnectivityManager connectivityManager = this.b;
        if (connectivityManager == null || (p = this.c) == null) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(p);
        this.c = null;
    }
}
