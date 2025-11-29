package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;

/* loaded from: classes2.dex */
final class WakeLockManager {
    private boolean enabled;
    private final PowerManager powerManager;
    private boolean stayAwake;
    private PowerManager.WakeLock wakeLock;

    public WakeLockManager(Context context) {
        this.powerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    public void setStayAwake(boolean stayAwake) {
        this.stayAwake = stayAwake;
        updateWakeLock();
    }

    @SuppressLint({"WakelockTimeout"})
    private void updateWakeLock() {
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock == null) {
            return;
        }
        if (this.enabled && this.stayAwake) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }
}
