package com.huawei.location;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

/* loaded from: classes3.dex */
public class FB {
    public static final Object Vw = new Object();
    public static volatile FB yn;
    public yn FB;
    public Handler LW;
    public boolean dC = false;

    public static class yn extends HandlerThread {
        public FB yn;

        public yn(String str, FB fb) {
            super(str);
            this.yn = fb;
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            if (this.yn == null) {
                Log.i("LogPersistenceManager", "log persistence manager null");
            }
        }
    }

    public FB(com.huawei.location.yn ynVar) {
        Vw.yn();
        yn();
    }

    public static FB yn(Context context, com.huawei.location.yn ynVar) {
        if (yn == null) {
            synchronized (Vw) {
                try {
                    if (yn == null) {
                        yn = new FB(ynVar);
                    }
                } finally {
                }
            }
        }
        return yn;
    }

    public final void yn() {
        if (this.dC) {
            return;
        }
        this.dC = true;
        yn ynVar = new yn("LogPersistenceManagerThread", this);
        this.FB = ynVar;
        ynVar.start();
        this.LW = new Handler(this.FB.getLooper());
    }
}
