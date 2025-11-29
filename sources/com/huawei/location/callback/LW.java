package com.huawei.location.callback;

import android.app.PendingIntent;
import com.huawei.location.router.interfaces.IRouterCallback;

/* loaded from: classes3.dex */
public class LW {
    private IRouterCallback Vw;
    private PendingIntent yn;

    public IRouterCallback Vw() {
        return this.Vw;
    }

    public PendingIntent yn() {
        return this.yn;
    }

    public void yn(PendingIntent pendingIntent) {
        this.yn = pendingIntent;
    }

    public void yn(IRouterCallback iRouterCallback) {
        this.Vw = iRouterCallback;
    }
}
