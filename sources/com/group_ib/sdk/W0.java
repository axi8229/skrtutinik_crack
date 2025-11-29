package com.group_ib.sdk;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes3.dex */
public abstract class W0 extends Handler implements d1 {
    public final MobileSdkService a;

    public W0(Looper looper, MobileSdkService mobileSdkService) {
        super(looper);
        this.a = mobileSdkService;
    }

    public void a(int i) {
    }

    public void run() {
        sendEmptyMessage(1);
    }

    public W0(MobileSdkService mobileSdkService) {
        this.a = mobileSdkService;
    }

    public void a() {
        sendEmptyMessage(2);
    }
}
