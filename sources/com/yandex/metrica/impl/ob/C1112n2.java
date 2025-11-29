package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import com.yandex.metrica.MetricaService;

/* renamed from: com.yandex.metrica.impl.ob.n2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1112n2 {
    private static final C1108mn a = new C1108mn();

    public static Intent a(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Intent intentAddFlags = new Intent(context, (Class<?>) MetricaService.class).setAction("com.yandex.metrica.IMetricaService").setData(new Uri.Builder().scheme("metrica").authority(context.getPackageName()).build()).addFlags(32);
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (Throwable unused) {
            applicationInfo = null;
        }
        try {
            bundle = applicationInfo.metaData;
            if (bundle == null) {
                bundle = new Bundle();
            }
        } catch (Throwable unused2) {
            bundle = new Bundle();
        }
        Intent intentPutExtras = intentAddFlags.putExtras(bundle);
        intentPutExtras.setData(intentPutExtras.getData().buildUpon().path("client").appendQueryParameter("pid", String.valueOf(Process.myPid())).appendQueryParameter("psid", A3.c).build());
        C0838c2 c0838c2A = C0913f2.a(context).a();
        intentPutExtras.putExtra("screen_size", c0838c2A != null ? Tl.a(c0838c2A) : null);
        return intentPutExtras.setPackage(context.getApplicationContext().getPackageName());
    }
}
