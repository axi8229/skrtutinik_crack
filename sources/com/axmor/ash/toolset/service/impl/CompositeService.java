package com.axmor.ash.toolset.service.impl;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* loaded from: classes.dex */
public abstract class CompositeService extends Service {
    protected ServiceCore core = null;

    private String createNotificationChannel(NotificationManager notificationManager) {
        NotificationChannel notificationChannelM = CompositeService$$ExternalSyntheticApiModelOutline3.m("sputnik.axmor.com.sputnik.core.service.appservice", "Service for SIP calls", 4);
        notificationChannelM.setImportance(0);
        notificationChannelM.setLockscreenVisibility(0);
        notificationManager.createNotificationChannel(notificationChannelM);
        return "sputnik.axmor.com.sputnik.core.service.appservice";
    }

    protected abstract void buildComposite(CompositeBuilder compositeBuilder);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.core.activate();
        this.core.setHaveBindings(true);
        return new ServiceBinder(this.core);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ServiceCore serviceCore = new ServiceCore(this);
        this.core = serviceCore;
        buildComposite(serviceCore);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.core.shutdown();
        this.core = null;
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        this.core.setHaveBindings(true);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.core.activate();
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                startForeground(101, new NotificationCompat.Builder(this, createNotificationChannel((NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION))).setOngoing(true).setPriority(-2).setCategory("service").build());
                stopForeground(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 1;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        this.core.setHaveBindings(false);
        return true;
    }
}
