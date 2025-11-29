package com.yandex.metrica.impl.ob;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: com.yandex.metrica.impl.ob.b0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0811b0 {
    private final BroadcastReceiver a;
    private boolean b = false;

    /* renamed from: com.yandex.metrica.impl.ob.b0$a */
    public static class a {
        public C0811b0 a(BroadcastReceiver broadcastReceiver) {
            return new C0811b0(broadcastReceiver);
        }
    }

    public C0811b0(BroadcastReceiver broadcastReceiver) {
        this.a = broadcastReceiver;
    }

    public synchronized Intent a(Context context, IntentFilter intentFilter) {
        Intent intentRegisterReceiver;
        try {
            intentRegisterReceiver = context.registerReceiver(this.a, intentFilter);
            try {
                this.b = true;
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            intentRegisterReceiver = null;
        }
        return intentRegisterReceiver;
    }

    public synchronized void a(Context context) {
        if (this.b) {
            try {
                context.unregisterReceiver(this.a);
                this.b = false;
            } catch (Throwable unused) {
            }
        }
    }
}
