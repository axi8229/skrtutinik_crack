package com.huawei.hms.jos.apps;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.jos.JosBaseClientImpl;
import com.huawei.hms.jos.JosClientBuilder;
import com.huawei.hms.jos.JosOptions;

/* loaded from: classes3.dex */
public abstract class AppsBaseClientImpl extends JosBaseClientImpl {
    private static final AppsClientBuilder c = new AppsClientBuilder();
    private static final Api<JosOptions> d = new Api<>("HuaweiApp.API");

    public AppsBaseClientImpl(Activity activity) {
        super(activity, d, new JosOptions(), (JosClientBuilder) c);
    }

    public AppsBaseClientImpl(Context context) {
        super(context, d, new AppOptions(), c);
    }
}
