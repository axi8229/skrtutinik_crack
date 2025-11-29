package com.huawei.hms.apptouch;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.utils.Checker;

/* loaded from: classes3.dex */
public class AppTouch {
    private AppTouch() {
    }

    public static AppTouchClient getAppClientImpl(Activity activity) {
        Checker.assertNonNull(activity);
        AppTouchClientImpl appTouchClientImpl = new AppTouchClientImpl(activity, new c());
        appTouchClientImpl.setApiLevel(1);
        appTouchClientImpl.setKitSdkVersion(1);
        return appTouchClientImpl;
    }

    public static AppTouchClient getAppClientImpl(Context context) {
        Checker.assertNonNull(context);
        AppTouchClientImpl appTouchClientImpl = new AppTouchClientImpl(context, new c());
        appTouchClientImpl.setApiLevel(1);
        appTouchClientImpl.setKitSdkVersion(1);
        return appTouchClientImpl;
    }
}
