package com.axmor.ash.toolset.service.impl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import androidx.core.content.ContextCompat;
import lombok.NonNull;

/* loaded from: classes.dex */
final class ServiceLifeline {
    private final Context serviceLockContext;
    private final Intent serviceLockIntent;
    private final Handler shutdownHandler = new Handler();
    private boolean haveBindings = false;
    private int serviceLockCounter = 0;
    private final Runnable shutdownRunnable = new Runnable() { // from class: com.axmor.ash.toolset.service.impl.ServiceLifeline.1
        @Override // java.lang.Runnable
        public void run() {
            Log.i("ServiceLifeline", "shutdownRunnable::run:: shutting down");
            ServiceLifeline serviceLifeline = ServiceLifeline.this;
            serviceLifeline.serviceLockContext.stopService(serviceLifeline.serviceLockIntent);
        }
    };

    public ServiceLifeline(@NonNull Service service) {
        if (service == null) {
            throw new NullPointerException("hostService is marked non-null but is null");
        }
        this.serviceLockContext = service;
        this.serviceLockIntent = new Intent(service, service.getClass());
    }

    private void ensureServiceRunning() {
        this.shutdownHandler.removeCallbacks(this.shutdownRunnable);
        if (Build.VERSION.SDK_INT >= 26) {
            ContextCompat.startForegroundService(this.serviceLockContext, this.serviceLockIntent);
        } else {
            this.serviceLockContext.startService(this.serviceLockIntent);
        }
        Log.i("ServiceLifeline", "ensureServiceRunning:: ensured service running");
    }

    private boolean isLockFree() {
        return this.serviceLockCounter == 0;
    }

    private void tryScheduleShutdown() {
        if (this.haveBindings || !isLockFree()) {
            return;
        }
        this.shutdownHandler.removeCallbacks(this.shutdownRunnable);
        this.shutdownHandler.postDelayed(this.shutdownRunnable, 300000L);
        Log.i("ServiceLifeline", "tryScheduleShutdown:: scheduled shutdown in " + String.valueOf(300L) + " seconds");
    }

    public void setHaveBindings(boolean z) {
        this.haveBindings = z;
        if (z) {
            ensureServiceRunning();
        } else {
            tryScheduleShutdown();
        }
    }
}
