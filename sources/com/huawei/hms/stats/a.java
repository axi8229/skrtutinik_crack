package com.huawei.hms.stats;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: AnalyticsCacheManager.java */
/* loaded from: classes3.dex */
public class a {
    private static final a f = new a();
    private final Object a = new Object();
    private boolean b = false;
    private final List<Runnable> c = new ArrayList();
    private final Handler d = new Handler(Looper.getMainLooper());
    private final Runnable e = new RunnableC0080a();

    /* compiled from: AnalyticsCacheManager.java */
    /* renamed from: com.huawei.hms.stats.a$a, reason: collision with other inner class name */
    class RunnableC0080a implements Runnable {
        RunnableC0080a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.i("AnalyticsCacheManager", "Timeout execCacheBi.");
            if (HiAnalyticsUtils.getInstance().getInitFlag()) {
                a.this.b();
            } else {
                a.this.a();
            }
        }
    }

    private a() {
    }

    public static a c() {
        return f;
    }

    public void a(Runnable runnable) {
        synchronized (this.a) {
            try {
                if (runnable == null) {
                    return;
                }
                if (this.b) {
                    return;
                }
                if (this.c.size() >= 60) {
                    return;
                }
                this.c.add(runnable);
                this.d.removeCallbacks(this.e);
                this.d.postDelayed(this.e, DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        synchronized (this.a) {
            HMSLog.i("AnalyticsCacheManager", "execCacheBi: cache size: " + this.c.size());
            this.b = true;
            try {
                Iterator<Runnable> it = this.c.iterator();
                while (it.hasNext()) {
                    it.next().run();
                    it.remove();
                }
            } catch (Throwable th) {
                HMSLog.e("AnalyticsCacheManager", "<execCacheBi> failed. " + th.getMessage());
                a();
            }
            this.b = false;
        }
    }

    public void a() {
        synchronized (this.a) {
            HMSLog.i("AnalyticsCacheManager", "clear AnalyticsCache.");
            this.c.clear();
        }
    }
}
