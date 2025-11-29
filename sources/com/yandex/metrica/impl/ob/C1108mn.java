package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* renamed from: com.yandex.metrica.impl.ob.mn, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1108mn {
    public ApplicationInfo a(Context context, String str, int i) {
        try {
            return context.getPackageManager().getApplicationInfo(str, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public PackageInfo b(Context context, String str, int i) {
        try {
            return context.getPackageManager().getPackageInfo(str, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean a(Context context, String str) {
        try {
            return context.getPackageManager().hasSystemFeature(str);
        } catch (Throwable unused) {
            return false;
        }
    }
}
