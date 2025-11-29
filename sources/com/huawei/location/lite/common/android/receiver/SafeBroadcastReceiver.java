package com.huawei.location.lite.common.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public abstract class SafeBroadcastReceiver extends BroadcastReceiver {
    private volatile Looper mReceiveLooper;
    private volatile ReceiverHandler mReceiverHandler;

    private final class ReceiverHandler extends Handler {
        public ReceiverHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 101) {
                if (SafeBroadcastReceiver.this.mReceiveLooper != null) {
                    SafeBroadcastReceiver.this.mReceiveLooper.quitSafely();
                    SafeBroadcastReceiver.this.mReceiveLooper = null;
                    return;
                }
                return;
            }
            if (i != 102) {
                return;
            }
            SafeBroadcastReceiver.this.onSafeReceive((Intent) message.obj);
            removeMessages(101);
            sendEmptyMessageDelayed(101, SafeBroadcastReceiver.this.threadExitDelayTime() > 0 ? SafeBroadcastReceiver.this.threadExitDelayTime() : 0L);
        }
    }

    protected boolean isOpenNewThread() {
        return true;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (!isOpenNewThread()) {
            onSafeReceive(intent);
            return;
        }
        if (this.mReceiveLooper == null || this.mReceiverHandler == null) {
            HandlerThread handlerThread = new HandlerThread(!TextUtils.isEmpty(receiveThreadName()) ? receiveThreadName() : "Loc-Safe-Receiver");
            handlerThread.start();
            this.mReceiveLooper = handlerThread.getLooper();
            this.mReceiverHandler = new ReceiverHandler(this.mReceiveLooper);
        }
        Message messageObtainMessage = this.mReceiverHandler.obtainMessage();
        messageObtainMessage.what = 102;
        messageObtainMessage.obj = intent;
        this.mReceiverHandler.sendMessage(messageObtainMessage);
    }

    protected abstract void onSafeReceive(Intent intent);

    protected abstract String receiveThreadName();

    protected int threadExitDelayTime() {
        return 0;
    }
}
