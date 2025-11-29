package com.yandex.metrica.impl.ob;

import android.content.Context;

/* renamed from: com.yandex.metrica.impl.ob.vm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1325vm {
    private final Context a;

    public C1325vm(Context context) {
        this.a = context;
    }

    public byte[] a() {
        try {
            return Tl.b(new StringBuilder(this.a.getPackageName()).reverse().toString());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }

    public byte[] b() {
        try {
            return Tl.b(this.a.getPackageName());
        } catch (Throwable unused) {
            return new byte[16];
        }
    }
}
