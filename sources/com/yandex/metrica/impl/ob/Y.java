package com.yandex.metrica.impl.ob;

import android.content.ComponentName;
import android.content.Context;
import com.yandex.metrica.PreloadInfoContentProvider;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmStatic;

/* loaded from: classes3.dex */
public final class Y {
    private static volatile CountDownLatch a;
    private static volatile PreloadInfoContentProvider b;

    @JvmStatic
    public static final void a(PreloadInfoContentProvider preloadInfoContentProvider) {
        a = new CountDownLatch(1);
        b = preloadInfoContentProvider;
    }

    @JvmStatic
    public static final void a() {
        CountDownLatch countDownLatch = a;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    @JvmStatic
    public static final void a(Context context) throws InterruptedException {
        CountDownLatch countDownLatch = a;
        if (countDownLatch != null) {
            countDownLatch.await(1L, TimeUnit.SECONDS);
            try {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, (Class<?>) PreloadInfoContentProvider.class), 2, 1);
                PreloadInfoContentProvider preloadInfoContentProvider = b;
                if (preloadInfoContentProvider != null) {
                    preloadInfoContentProvider.disable();
                }
            } catch (Throwable unused) {
            }
            a = null;
        }
    }
}
