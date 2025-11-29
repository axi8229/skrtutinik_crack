package com.yandex.varioqub.config.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.varioqub.config.impl.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1423b {
    public static int a() {
        return Build.VERSION.SDK_INT;
    }

    public static String b() {
        Context context = AbstractC1425d.a;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appContext");
            context = null;
        }
        return context.getResources().getConfiguration().getLocales().get(0).getLanguage();
    }

    public static PackageInfo c() {
        Context context = AbstractC1425d.a;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appContext");
            context = null;
        }
        return Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L)) : context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
    }

    public static String d() {
        PackageInfo packageInfoC = c();
        return Build.VERSION.SDK_INT >= 28 ? String.valueOf(packageInfoC.getLongVersionCode()) : String.valueOf(packageInfoC.versionCode);
    }
}
