package com.yandex.metrica.identifiers.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: classes3.dex */
public class d implements ServiceConnection {
    private final Intent a;
    private IBinder b;
    private final Object c = new Object();

    public d(Intent intent, String str) {
        this.a = intent;
        String.format("[AdServiceConnection-%s]", str);
    }

    public Intent a() {
        return this.a;
    }

    public IBinder a(long j) {
        if (this.b == null) {
            synchronized (this.c) {
                if (this.b == null) {
                    try {
                        this.c.wait(j);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
        return this.b;
    }

    public boolean a(Context context) {
        return context.bindService(this.a, this, 1);
    }

    public void b(Context context) {
        synchronized (this.c) {
            this.b = null;
            this.c.notifyAll();
        }
        context.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        synchronized (this.c) {
            this.b = null;
            this.c.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        synchronized (this.c) {
            this.c.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.c) {
            this.b = iBinder;
            this.c.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.c) {
            this.b = null;
            this.c.notifyAll();
        }
    }
}
