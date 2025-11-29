package com.huawei.hms.locationSdk;

import android.annotation.SuppressLint;
import android.location.GnssStatus;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.location.lite.common.android.context.ContextUtil;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@SuppressLint({"MissingPermission", "NewApi"})
/* loaded from: classes3.dex */
public class b0 {
    private LinkedBlockingQueue<z> a;
    private final AtomicBoolean b = new AtomicBoolean(false);
    private int c;
    private Handler d;
    private GnssStatus.Callback e;
    private int f;
    private boolean g;

    class a extends GnssStatus.Callback {
        a() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            b0.this.a(gnssStatus);
        }
    }

    public b0(y yVar) {
        this.f = yVar.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(a0 a0Var, a0 a0Var2) {
        return Double.compare(a0Var2.a(), a0Var.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(GnssStatus gnssStatus) {
        try {
            int satelliteCount = gnssStatus.getSatelliteCount();
            long jCurrentTimeMillis = System.currentTimeMillis();
            PriorityQueue priorityQueue = new PriorityQueue(new Comparator() { // from class: com.huawei.hms.locationSdk.b0$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return b0.a((a0) obj, (a0) obj2);
                }
            });
            for (int i = 0; i < satelliteCount; i++) {
                priorityQueue.add(new a0().a(gnssStatus.getSvid(i)).b(gnssStatus.getCn0DbHz(i)).a(gnssStatus.usedInFix(i)).c(gnssStatus.getElevationDegrees(i)).a(gnssStatus.getAzimuthDegrees(i)));
            }
            z zVar = new z(satelliteCount, jCurrentTimeMillis, (List) priorityQueue.stream().sorted(new Comparator() { // from class: com.huawei.hms.locationSdk.b0$$ExternalSyntheticLambda1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return b0.b((a0) obj, (a0) obj2);
                }
            }).limit(this.f).collect(Collectors.toList()));
            if (this.a.size() == this.c) {
                this.a.poll();
            }
            this.a.offer(zVar);
            if (this.g) {
                HMSLocationLog.i("GnssStatusCollector", "", "gnssStatusChanged:" + zVar);
            } else {
                HMSLocationLog.i("GnssStatusCollector", "", "gnssStatusChanged");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private boolean a(Looper looper) {
        LocationManager locationManagerB = b();
        if (locationManagerB == null) {
            return false;
        }
        if (this.d == null) {
            this.d = new Handler(looper);
        }
        if (this.e == null) {
            this.e = new a();
        }
        return locationManagerB.registerGnssStatusCallback(this.e, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(a0 a0Var, a0 a0Var2) {
        return Float.compare(a0Var2.a(), a0Var.a());
    }

    private LocationManager b() {
        Object systemService = ContextUtil.getContext().getSystemService("location");
        if (systemService instanceof LocationManager) {
            return (LocationManager) systemService;
        }
        return null;
    }

    public String a() {
        if (!this.b.get() || this.a.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<z> it = this.a.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        this.a.clear();
        return sb.toString();
    }

    public boolean a(int i, Looper looper, boolean z) {
        if (this.b.get()) {
            return true;
        }
        this.g = z;
        this.b.set(true);
        if (this.a == null) {
            this.a = new LinkedBlockingQueue<>(i);
        }
        this.c = i;
        HMSLocationLog.i("GnssStatusCollector", "", "start gnss");
        return a(looper);
    }

    public void c() {
        HMSLocationLog.d("GnssStatusCollector", "", "stop");
        this.b.set(false);
        this.a.clear();
        LocationManager locationManagerB = b();
        if (locationManagerB == null) {
            return;
        }
        locationManagerB.unregisterGnssStatusCallback(this.e);
    }
}
