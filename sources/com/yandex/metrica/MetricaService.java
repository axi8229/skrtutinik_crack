package com.yandex.metrica;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.yandex.metrica.IMetricaService;
import com.yandex.metrica.impl.ob.C1037k2;
import com.yandex.metrica.impl.ob.C1185q1;
import com.yandex.metrica.impl.ob.C1208r1;
import com.yandex.metrica.impl.ob.F0;
import com.yandex.metrica.impl.ob.InterfaceC1161p1;
import com.yandex.metrica.impl.ob.Vl;

/* loaded from: classes3.dex */
public class MetricaService extends Service {
    private static InterfaceC1161p1 c;
    private final d a = new a();
    private final IMetricaService.a b = new b(this);

    class a implements d {
        a() {
        }

        @Override // com.yandex.metrica.MetricaService.d
        public void a(int i) {
            MetricaService.this.stopSelfResult(i);
        }
    }

    class b extends IMetricaService.a {
        b(MetricaService metricaService) {
        }

        @Override // com.yandex.metrica.IMetricaService
        public void a(int i, Bundle bundle) throws RemoteException {
            MetricaService.c.a(i, bundle);
        }

        @Override // com.yandex.metrica.IMetricaService
        public void b(Bundle bundle) throws RemoteException {
            MetricaService.c.b(bundle);
        }

        @Override // com.yandex.metrica.IMetricaService
        public void reportData(Bundle bundle) throws RemoteException {
            MetricaService.c.reportData(bundle);
        }

        @Override // com.yandex.metrica.IMetricaService
        public void a(Bundle bundle) throws RemoteException {
            MetricaService.c.a(bundle);
        }
    }

    static class c extends Binder {
        c() {
        }
    }

    public interface d {
        void a(int i);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder cVar = "com.yandex.metrica.ACTION_BIND_TO_LOCAL_SERVER".equals(intent.getAction()) ? new c() : this.b;
        c.a(intent);
        return cVar;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c.onConfigurationChanged(configuration);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        F0.a(getApplicationContext());
        Vl.a(getApplicationContext());
        InterfaceC1161p1 interfaceC1161p1 = c;
        if (interfaceC1161p1 == null) {
            c = new C1185q1(new C1208r1(getApplicationContext(), this.a));
        } else {
            interfaceC1161p1.a(this.a);
        }
        c.a();
        F0.g().a(new C1037k2(c));
    }

    @Override // android.app.Service
    public void onDestroy() {
        c.b();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        c.c(intent);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        c.a(intent, i);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        c.a(intent, i, i2);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        c.b(intent);
        return ("com.yandex.metrica.ACTION_BIND_TO_LOCAL_SERVER".equals(intent.getAction()) || intent.getData() == null) ? false : true;
    }
}
