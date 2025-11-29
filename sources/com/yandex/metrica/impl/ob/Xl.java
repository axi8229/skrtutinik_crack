package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;

/* loaded from: classes3.dex */
public class Xl implements InterfaceC0833bm {
    private volatile String a;

    public String b() {
        if (this.a != null) {
            return this.a;
        }
        synchronized (this) {
            try {
                if (this.a == null) {
                    this.a = a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PrivateApi"})
    public String a() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            return (String) cls.getMethod("getProcessName", null).invoke(cls.getMethod("currentActivityThread", null).invoke(null, null), null);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
