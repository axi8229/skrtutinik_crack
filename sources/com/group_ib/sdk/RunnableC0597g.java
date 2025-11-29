package com.group_ib.sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* renamed from: com.group_ib.sdk.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0597g implements Runnable {
    public MobileSdkService a = null;

    @Override // java.lang.Runnable
    public final void run() {
        MobileSdkService mobileSdkService = this.a;
        String str = MobileSdkService.O;
        mobileSdkService.getClass();
        c1.a(4, 4, MobileSdkService.O, "service thread started");
        Looper.prepare();
        mobileSdkService.c = Looper.myLooper();
        mobileSdkService.d = new ExecutorC0607l(new Handler(mobileSdkService.c));
        R0 r0 = U0.c;
        r0.a(mobileSdkService.c);
        r0.a(5, (S0) mobileSdkService);
        mobileSdkService.q = new HandlerC0605k(mobileSdkService);
        synchronized (mobileSdkService.p) {
            mobileSdkService.s = AbstractC0604j0.a(mobileSdkService);
        }
        synchronized (mobileSdkService.i) {
            try {
                mobileSdkService.i.put(HandlerC0596f0.class.toString(), new HandlerC0596f0(mobileSdkService));
                mobileSdkService.i.put(T0.class.toString(), new T0(mobileSdkService));
                mobileSdkService.i.put(HandlerC0586a0.class.toString(), new HandlerC0586a0(mobileSdkService));
                mobileSdkService.i.put(C0617q0.class.toString(), new C0617q0(mobileSdkService));
                mobileSdkService.i.put(h1.class.toString(), new h1(mobileSdkService));
                mobileSdkService.i.put(Y0.class.toString(), new Y0(mobileSdkService));
                mobileSdkService.i.put(S.class.toString(), new S(mobileSdkService));
                mobileSdkService.i.put(C0610m0.class.toString(), new C0610m0(mobileSdkService));
                mobileSdkService.i.put(L0.class.toString(), new L0(mobileSdkService));
                mobileSdkService.i.put(H0.class.toString(), new H0(mobileSdkService));
                if (T.b(EnumC0589c.PackageCollectionCapability)) {
                    mobileSdkService.i.put("PackageCollectionCapability", new HandlerC0626v0(mobileSdkService));
                }
                if (T.b(EnumC0589c.LocationCapability)) {
                    mobileSdkService.i.put("LocationCapability", new e1(mobileSdkService));
                }
                if (T.b(EnumC0589c.CellsCollectionCapability)) {
                    mobileSdkService.i.put("CellsCollectionCapability", new C0628w0(mobileSdkService));
                }
                if (T.b(EnumC0589c.CloudIdentificationCapability)) {
                    mobileSdkService.i.put("CloudIdentificationCapability", new C0632y0(mobileSdkService));
                }
                if (T.b(EnumC0589c.MotionCollectionCapability)) {
                    LinkedHashMap linkedHashMap = mobileSdkService.i;
                    K k = new K(mobileSdkService);
                    mobileSdkService.r = k;
                    linkedHashMap.put("MotionCollectionCapability", k);
                }
                Iterator it = mobileSdkService.i.values().iterator();
                while (it.hasNext()) {
                    ((d1) it.next()).run();
                }
                if (T.b(EnumC0589c.GlobalIdentificationCapability)) {
                    mobileSdkService.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Looper.loop();
        c1.a(4, 4, MobileSdkService.O, "service thread exited");
    }
}
