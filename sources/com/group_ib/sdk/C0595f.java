package com.group_ib.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import java.net.URL;
import ru.yoomoney.sdk.yooprofiler.YooProfilerImpl;

/* renamed from: com.group_ib.sdk.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0595f {
    public static final long h = System.currentTimeMillis();
    public static C0595f i = null;
    public static boolean j = false;
    public static boolean k = false;
    public final Context a;
    public boolean b = false;
    public MobileSdkService c = null;
    public final HandlerC0618r0 d = new HandlerC0618r0();
    public C0588b0 e = null;
    public Activity f = null;
    public final ServiceConnectionC0593e g = new ServiceConnectionC0593e(this);

    public C0595f(Context context) {
        this.a = context.getApplicationContext();
    }

    public final C0595f a(EnumC0589c enumC0589c) {
        MobileSdkService mobileSdkService;
        T.a(enumC0589c);
        c1.a(4, 4, "MobileSdk", "Capability '" + enumC0589c.name() + "' enabled");
        synchronized (this) {
            try {
                if (this.b && (mobileSdkService = this.c) != null) {
                    mobileSdkService.a(enumC0589c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }

    public final void b() {
        if (!k) {
            c1.a(4, 4, "MobileSdk", "Process is not running the foreground UI, logs sending disabled");
            U0.b.a(4, (S0) new C0591d(this));
        } else {
            synchronized (this) {
                this.a.bindService(new Intent(this.a, (Class<?>) MobileSdkService.class), this.g, 1);
                c1.c.sendEmptyMessage(9);
            }
        }
    }

    public final C0595f c() {
        c1.a(3, 3, "MobileSdk", "setTargetURL (" + YooProfilerImpl.TARGET_URL + ")");
        synchronized (T.class) {
            T.b = new URL(YooProfilerImpl.TARGET_URL);
        }
        return this;
    }

    public final void d() {
        synchronized (this) {
            try {
                if (this.e != null) {
                    ((Application) this.a.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.e);
                    this.e = null;
                }
                if (this.b) {
                    this.a.unbindService(this.g);
                    this.a.stopService(new Intent(this.a, (Class<?>) MobileSdkService.class));
                    this.c = null;
                    this.d.a((MobileSdkService) null);
                    this.b = false;
                }
                c1.a(4, 4, "MobileSdk", "Stopped");
                c1.a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final C0595f a() throws C0633z {
        if (j && !this.b) {
            if (T.a == null) {
                throw new C0633z("Customer id is not specified");
            }
            if (T.b == null) {
                throw new C0633z("Target URL is not specified");
            }
            Application application = (Application) this.a.getApplicationContext();
            if (this.e == null) {
                C0588b0 c0588b0 = new C0588b0();
                this.e = c0588b0;
                Activity activity = this.f;
                if (activity != null) {
                    k = true;
                    c0588b0.a(activity);
                    this.f = null;
                }
                T.v = this.e;
                application.registerActivityLifecycleCallbacks(this.e);
            }
            b();
            this.b = true;
        }
        return this;
    }

    public final C0595f a(String str) throws C0633z {
        if (str == null) {
            throw new C0633z("sessionId is unspecified");
        }
        c1.a(3, 3, "MobileSdk", "setSessionId(" + str + ")");
        HandlerC0618r0 handlerC0618r0 = this.d;
        synchronized (handlerC0618r0) {
            handlerC0618r0.a("csid", str, false);
        }
        return this;
    }
}
