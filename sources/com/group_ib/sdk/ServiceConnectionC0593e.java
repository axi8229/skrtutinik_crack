package com.group_ib.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.IBinder;
import java.net.URL;
import java.util.Iterator;
import java.util.UUID;

/* renamed from: com.group_ib.sdk.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class ServiceConnectionC0593e implements ServiceConnection {
    public final /* synthetic */ C0595f a;

    public ServiceConnectionC0593e(C0595f c0595f) {
        this.a = c0595f;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder instanceof BinderC0603j) {
            C0595f c0595f = this.a;
            MobileSdkService mobileSdkService = ((BinderC0603j) iBinder).a;
            c0595f.getClass();
            c1.a(3, 3, "MobileSdk", "Starting MobileSdk service...");
            c0595f.c = mobileSdkService;
            mobileSdkService.getClass();
            try {
                T.h = UUID.randomUUID().toString();
                mobileSdkService.l = new E0(mobileSdkService);
                if (T.d() == null) {
                    T.c(mobileSdkService);
                }
                if (mobileSdkService.h == null) {
                    HandlerThread handlerThread = new HandlerThread("GIBSDK Network Thread");
                    mobileSdkService.e = handlerThread;
                    handlerThread.start();
                    mobileSdkService.h = new G(mobileSdkService.e.getLooper(), mobileSdkService);
                    try {
                        G g = mobileSdkService.h;
                        URL url = T.b;
                        g.a(url != null ? url.toString() : null);
                    } catch (Exception e) {
                        c1.b(MobileSdkService.O, "failed to initialize NetworkAgent", e);
                    }
                }
                synchronized (mobileSdkService.i) {
                    try {
                        if (T.b(EnumC0589c.ActivityCollectionCapability)) {
                            mobileSdkService.i.put("ActivityCollectionCapability", new HandlerC0598g0(mobileSdkService));
                        }
                        Iterator it = mobileSdkService.i.values().iterator();
                        while (it.hasNext()) {
                            ((d1) it.next()).run();
                        }
                    } finally {
                    }
                }
                if (mobileSdkService.b == null) {
                    RunnableC0597g runnableC0597g = new RunnableC0597g();
                    runnableC0597g.a = mobileSdkService;
                    mobileSdkService.b = new Thread(runnableC0597g);
                    if (AbstractC0604j0.a((Context) mobileSdkService)) {
                        mobileSdkService.b.setName("GIBSDK Service Thread");
                    }
                    mobileSdkService.b.start();
                }
                R0 r0 = U0.b;
                r0.a(2, (S0) mobileSdkService);
                r0.a(1, (S0) mobileSdkService);
            } catch (Exception e2) {
                c1.b(MobileSdkService.O, e2.toString(), e2);
            }
            c0595f.d.a(mobileSdkService);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        C0595f c0595f = this.a;
        c0595f.a.unbindService(c0595f.g);
        c0595f.a.stopService(new Intent(c0595f.a, (Class<?>) MobileSdkService.class));
        c0595f.c = null;
        c0595f.d.a((MobileSdkService) null);
    }
}
