package com.group_ib.sdk;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class K extends W0 {
    public final HashMap b;

    public K(MobileSdkService mobileSdkService) {
        List<Sensor> sensorList;
        super(mobileSdkService.f(), mobileSdkService);
        this.b = new HashMap();
        SensorManager sensorManager = (SensorManager) this.a.getSystemService("sensor");
        if (sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null || sensorList.isEmpty()) {
            return;
        }
        for (Sensor sensor : sensorList) {
            int type = sensor.getType();
            if (type == 4 || type == 9 || type == 10) {
                this.b.put(Integer.valueOf(sensor.getType()), new l1(sensorManager, sensor, new J()));
                c1.b("SensorsProvider", "Sensor '" + sensor.getName() + "' added");
            }
        }
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void a(int i) {
        if (i == 16) {
            run();
        } else if (i == 32) {
            a();
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1024) {
            Object obj = message.obj;
            if (obj instanceof I) {
                I i2 = (I) obj;
                Iterator it = this.b.entrySet().iterator();
                while (it.hasNext()) {
                    l1 l1Var = (l1) ((Map.Entry) it.next()).getValue();
                    B bA = ((C0606k0) i2).a(l1Var);
                    if (bA != null) {
                        l1Var.d.add(bA);
                    } else {
                        l1Var.getClass();
                    }
                }
                return;
            }
        }
        if (i == 2048) {
            Object obj2 = message.obj;
            if (obj2 instanceof I) {
                C0606k0 c0606k0 = (C0606k0) ((I) obj2);
                HashSet hashSet = c0606k0.h;
                if (hashSet != null) {
                    Iterator it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        ((B) it2.next()).a = 4;
                    }
                }
                ((HandlerC0598g0) c0606k0.d).a((L) c0606k0);
            }
        }
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void run() {
        Iterator it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            ((l1) ((Map.Entry) it.next()).getValue()).a(this);
        }
    }

    public final boolean a(I i) {
        if (i == null) {
            return false;
        }
        if (getLooper().getThread() != Thread.currentThread()) {
            sendMessage(obtainMessage(1024, i));
            return true;
        }
        Iterator it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            l1 l1Var = (l1) ((Map.Entry) it.next()).getValue();
            B bA = ((C0606k0) i).a(l1Var);
            if (bA != null) {
                l1Var.d.add(bA);
            } else {
                l1Var.getClass();
            }
        }
        return true;
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void a() {
        Iterator it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            ((l1) ((Map.Entry) it.next()).getValue()).a();
        }
    }
}
