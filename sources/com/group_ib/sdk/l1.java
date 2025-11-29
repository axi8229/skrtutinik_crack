package com.group_ib.sdk;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import bz.J1;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public final class l1 implements SensorEventListener {
    public final SensorManager a;
    public final Sensor b;
    public final k1 c;
    public final LinkedList d = new LinkedList();

    public l1(SensorManager sensorManager, Sensor sensor, J j) {
        this.a = sensorManager;
        this.b = sensor;
        this.c = j;
    }

    public final void a() {
        this.a.unregisterListener(this);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            k1 k1Var = (k1) this.d.get(size);
            int i = j1.a[J1.a(k1Var.a())];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.d.remove(k1Var);
                    }
                }
            } else {
                this.c.a(sensorEvent.timestamp, k1Var);
            }
            k1Var.a(sensorEvent);
        }
        this.c.a(sensorEvent);
    }

    public final void a(Handler handler) {
        this.a.registerListener(this, this.b, 5000, handler);
    }
}
