package com.huawei.hms.jos;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.jos.manager.InnerActivityManager;
import com.huawei.hms.jos.product.ProductClient;
import com.huawei.hms.jos.product.ProductClientImpl;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.utils.Checker;

/* loaded from: classes3.dex */
public final class JosApps {
    public static AppUpdateClient getAppUpdateClient(Activity activity) {
        Checker.assertNonNull(activity);
        InnerActivityManager.get().setCurrentActivity(activity);
        return new AppUpdateClientImpl();
    }

    public static AppUpdateClient getAppUpdateClient(Context context) {
        Checker.assertNonNull(context);
        return new AppUpdateClientImpl();
    }

    public static JosAppsClient getJosAppsClient(Activity activity) {
        Checker.assertNonNull(activity);
        InnerActivityManager.get().setCurrentActivity(activity);
        return new a(activity);
    }

    @Deprecated
    public static JosAppsClient getJosAppsClient(Activity activity, AuthHuaweiId authHuaweiId) {
        Checker.assertNonNull(activity);
        InnerActivityManager.get().setCurrentActivity(activity);
        return new a(activity);
    }

    public static ProductClient getProductClient(Activity activity) {
        Checker.assertNonNull(activity);
        InnerActivityManager.get().setCurrentActivity(activity);
        return new ProductClientImpl(activity);
    }

    @Deprecated
    public static ProductClient getProductClient(Context context) {
        Checker.assertNonNull(context);
        return new ProductClientImpl(context);
    }
}
