package com.group_ib.sdk;

import android.os.HandlerThread;
import android.os.Message;

/* loaded from: classes3.dex */
public final class Q0 extends W0 {
    public static final /* synthetic */ int $r8$clinit = 0;
    public HandlerThread b;
    public O0 c;

    public Q0(MobileSdkService mobileSdkService) {
        super(mobileSdkService.f(), mobileSdkService);
        this.b = null;
        this.c = null;
    }

    @Override // com.group_ib.sdk.W0, com.group_ib.sdk.d1
    public final void a(int i) {
        O0 o0 = this.c;
        if (o0 != null) {
            if (i == 4 || i == 16 || i == 32) {
                o0.sendEmptyMessage(i);
            }
        }
    }

    @Override // android.os.Handler
    public final synchronized void handleMessage(Message message) {
        HandlerThread handlerThread;
        try {
            if (message.what == 1 && T.h() != null) {
                HandlerThread handlerThread2 = new HandlerThread("GIBSDK Global Id thread");
                this.b = handlerThread2;
                handlerThread2.start();
                O0 o0 = new O0(this.b.getLooper(), this.a);
                this.c = o0;
                o0.sendEmptyMessage(1024);
            } else if (message.what == 2 && (handlerThread = this.b) != null) {
                handlerThread.quit();
                this.b = null;
                this.c = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
