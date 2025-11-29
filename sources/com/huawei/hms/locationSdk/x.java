package com.huawei.hms.locationSdk;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.gson.JsonSyntaxException;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationRequestHelper;
import com.huawei.hms.support.api.location.common.PermissionUtil;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.config.ConfigManager;
import com.huawei.location.lite.common.report.ReportBuilder;
import com.huawei.location.lite.common.report.Tracker;
import com.huawei.location.lite.common.util.DeviceInfoUtil;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.LocationUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class x implements Handler.Callback {
    private b0 a;
    private c0 b;
    private HandlerThread c;
    private final AtomicBoolean d;
    private long e;
    private int f;
    private y g;
    private Handler h;
    private AtomicInteger i;
    private String j;
    private String k;

    private static class b {
        private static final x a = new x();
    }

    private x() {
        this.d = new AtomicBoolean(false);
        this.i = new AtomicInteger(0);
        d();
    }

    private synchronized Looper a() {
        try {
            if (this.c == null) {
                HandlerThread handlerThread = new HandlerThread("Loc_AnalyzerHandler");
                this.c = handlerThread;
                handlerThread.start();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.c.getLooper();
    }

    private List<String> a(String str, int i) {
        String strSubstring;
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i2 = 0;
        int i3 = i;
        while (true) {
            if (i3 >= length) {
                try {
                    strSubstring = str.substring(i2, length);
                } catch (Exception unused) {
                    return arrayList;
                }
            } else {
                strSubstring = str.substring(i2, i3);
            }
            arrayList.add(strSubstring);
            i2 = i3;
            i3 += i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(HWLocation hWLocation) {
        h();
        this.b.b(hWLocation);
    }

    private void a(JSONObject jSONObject) {
        String str;
        String strReplace = jSONObject.toString().replace("\\", "");
        if (strReplace.length() > 4000) {
            List<String> listA = a(strReplace, 4000);
            HMSLocationLog.i("LocationCallbackStatusAnalyzer", "", "reportBody log start");
            Iterator<String> it = listA.iterator();
            while (it.hasNext()) {
                HMSLocationLog.i("LocationCallbackStatusAnalyzer", "", it.next());
            }
            str = "reportBody log end";
        } else {
            str = "reportBody:" + strReplace;
        }
        HMSLocationLog.i("LocationCallbackStatusAnalyzer", "", str);
    }

    public static x b() {
        return b.a;
    }

    private void c() {
        if (this.a == null) {
            this.a = new b0(this.g);
        }
        if (this.b == null) {
            this.b = new c0();
        }
    }

    private void d() {
        if (f()) {
            try {
                this.g = (y) GsonUtil.getInstance().fromJson(ConfigManager.getInstance().getConfig("gnssException"), y.class);
            } catch (JsonSyntaxException unused) {
                HMSLocationLog.e("LocationCallbackStatusAnalyzer", "", "config to json failed");
            }
            if (this.g == null) {
                y yVar = new y();
                this.g = yVar;
                yVar.h();
            }
            HMSLocationLog.i("LocationCallbackStatusAnalyzer", "", this.g.toString());
        }
    }

    private boolean e() {
        if (PermissionUtil.isPermissionAvailable(ContextUtil.getContext(), "android.permission.ACCESS_FINE_LOCATION") && this.g.c() != 0) {
            return this.g.b() == null || this.g.b().contains(ContextUtil.getContext().getApplicationContext().getPackageName());
        }
        return false;
    }

    private boolean f() {
        int deviceFeature = DeviceInfoUtil.getDeviceFeature(ContextUtil.getContext());
        return deviceFeature == 8 || deviceFeature == 0 || deviceFeature == 1;
    }

    private void g() throws IllegalArgumentException {
        HMSLocationLog.i("LocationCallbackStatusAnalyzer", "", "post network request");
        FusedLocationProviderClient fusedLocationProviderClient = new FusedLocationProviderClient(ContextUtil.getContext());
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setPriority(102);
        locationRequest.setNumUpdates(1);
        locationRequest.setExpirationDuration(DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM);
        locationRequest.putExtras(LocationRequestHelper.CP_TRANS_ID, this.k);
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, new LocationCallback(), a());
    }

    private void h() {
        Handler handler = this.h;
        if (handler != null) {
            handler.removeMessages(1);
            Handler handler2 = this.h;
            handler2.sendMessageDelayed(handler2.obtainMessage(1), this.g.d() * 1000);
        }
    }

    private synchronized void i() {
        if (this.d.get()) {
            if (this.g.c() != 0 && this.g.c() != 2) {
                if (this.f == this.g.e()) {
                    HMSLocationLog.i("LocationCallbackStatusAnalyzer", "", "report reach max count");
                    return;
                }
                if (System.currentTimeMillis() - (this.g.a() * 1000) < this.e) {
                    HMSLocationLog.i("LocationCallbackStatusAnalyzer", "", "report not reach time");
                    return;
                }
                this.f++;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("GnssFrameStatus", this.a.a());
                    jSONObject.put("LocationInfo", this.b.a());
                    if (!TextUtils.isEmpty(this.k)) {
                        jSONObject.put(LocationRequestHelper.CP_TRANS_ID, this.k);
                    }
                } catch (JSONException unused) {
                    HMSLocationLog.e("LocationCallbackStatusAnalyzer", "", "buildBody exception");
                }
                this.e = System.currentTimeMillis();
                ReportBuilder reportBuilder = new ReportBuilder();
                reportBuilder.setApiName("Location_GnssException_SDK");
                reportBuilder.setWLANScan();
                reportBuilder.setLocationEnable(LocationUtil.isLocationEnabled(ContextUtil.getContext()));
                reportBuilder.setTransactionID(this.j);
                reportBuilder.setExt(jSONObject.toString());
                Tracker.getInstance().onEvent(1, reportBuilder.getEventId(), reportBuilder.build());
                a(jSONObject);
                g();
            }
        }
    }

    public synchronized void a(String str, String str2) {
        if (f() && e()) {
            this.j = str;
            this.k = str2;
            this.i.incrementAndGet();
            if (this.d.get()) {
                HMSLocationLog.w("LocationCallbackStatusAnalyzer", "", "analyzer is started");
                return;
            }
            if (this.h == null) {
                this.h = new Handler(a(), this);
            }
            c();
            boolean z = this.g.c() == 1 || this.g.c() == 2;
            HMSLocationLog.i("LocationCallbackStatusAnalyzer", "", "start gnss:" + this.a.a(this.g.f(), a(), z) + ",statLocation:" + this.b.a(this.g.f(), a(), z));
            this.d.set(true);
            Handler handler = this.h;
            if (handler != null) {
                handler.removeMessages(1);
                Handler handler2 = this.h;
                handler2.sendMessageDelayed(handler2.obtainMessage(1), DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM);
            }
            return;
        }
        HMSLocationLog.w("LocationCallbackStatusAnalyzer", "", "not support analyzer:" + Build.VERSION.SDK_INT);
    }

    public synchronized void b(final HWLocation hWLocation) {
        Handler handler;
        if (this.d.get() && (handler = this.h) != null) {
            handler.post(new Runnable() { // from class: com.huawei.hms.locationSdk.x$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(hWLocation);
                }
            });
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        i();
        h();
        return false;
    }

    public synchronized void j() {
        if (!this.d.get()) {
            HMSLocationLog.w("LocationCallbackStatusAnalyzer", "", "is stopped,do nothing");
            return;
        }
        if (this.i.decrementAndGet() > 0) {
            HMSLocationLog.w("LocationCallbackStatusAnalyzer", "", "also have gnss request,not stop");
            return;
        }
        this.d.set(false);
        HMSLocationLog.w("LocationCallbackStatusAnalyzer", "", "stop analyzer");
        b0 b0Var = this.a;
        if (b0Var != null) {
            b0Var.c();
            this.a = null;
        }
        c0 c0Var = this.b;
        if (c0Var != null) {
            c0Var.b();
            this.b = null;
        }
        this.f = 0;
        Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}
