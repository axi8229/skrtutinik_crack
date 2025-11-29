package npi.spay;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.q5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1858q5 implements SensorEventListener {
    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }
}
