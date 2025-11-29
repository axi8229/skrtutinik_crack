package com.group_ib.sdk;

import android.os.Message;
import com.google.android.gms.location.DeviceOrientationRequest;

/* renamed from: com.group_ib.sdk.f0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class HandlerC0596f0 extends W0 {
    public final long b;

    public HandlerC0596f0(MobileSdkService mobileSdkService) {
        super(mobileSdkService);
        this.b = DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM;
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void a(int i) {
        if (i == 16) {
            removeMessages(256);
            sendEmptyMessageDelayed(256, this.b);
        } else {
            if (i != 32) {
                return;
            }
            removeMessages(256);
        }
    }

    @Override // android.os.Handler
    public final synchronized void handleMessage(Message message) {
        if (message.what == 256) {
            this.a.e();
            sendEmptyMessageDelayed(256, this.b);
        }
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void run() {
        sendEmptyMessage(256);
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void a() {
        removeMessages(256);
    }
}
