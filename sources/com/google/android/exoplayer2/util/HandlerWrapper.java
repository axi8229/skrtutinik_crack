package com.google.android.exoplayer2.util;

import android.os.Looper;
import android.os.Message;

/* loaded from: classes2.dex */
public interface HandlerWrapper {
    Looper getLooper();

    Message obtainMessage(int what);

    Message obtainMessage(int what, int arg1, int arg2);

    Message obtainMessage(int what, int arg1, int arg2, Object obj);

    Message obtainMessage(int what, Object obj);

    void removeMessages(int what);

    boolean sendEmptyMessage(int what);

    boolean sendEmptyMessageAtTime(int what, long uptimeMs);
}
