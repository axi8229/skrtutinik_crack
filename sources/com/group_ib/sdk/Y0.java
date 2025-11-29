package com.group_ib.sdk;

import android.os.Message;

/* loaded from: classes3.dex */
public final class Y0 extends W0 {
    public boolean b;

    public Y0(MobileSdkService mobileSdkService) {
        super(mobileSdkService);
        this.b = false;
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void a(int i) {
        if (!this.b || T.i <= 0) {
            return;
        }
        if (i == 16) {
            sendEmptyMessage(1024);
        } else {
            if (i != 32) {
                return;
            }
            removeMessages(1024);
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        long j = T.i;
        if (!this.b || j <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - T.j;
        if (jCurrentTimeMillis >= j) {
            MobileSdkService mobileSdkService = this.a;
            G g = mobileSdkService.h;
            if (g != null && g.b()) {
                mobileSdkService.q.a();
            }
        } else {
            j -= jCurrentTimeMillis;
        }
        sendEmptyMessageDelayed(1024, j);
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void run() {
        if (this.b) {
            return;
        }
        String str = T.a;
        T.j = System.currentTimeMillis();
        long j = T.i;
        if (j > 0) {
            sendEmptyMessageDelayed(1024, j);
            c1.a(4, 4, "KeepAliveProvider", "keep-alive sending initiated with period " + j + " ms");
        }
        this.b = true;
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void a() {
        if (this.b) {
            removeMessages(1024);
            this.b = false;
            c1.a(4, 4, "KeepAliveProvider", "keep-alive sending stopped");
        }
    }
}
