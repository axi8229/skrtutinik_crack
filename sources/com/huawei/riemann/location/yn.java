package com.huawei.riemann.location;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.huawei.riemann.common.api.location.CityTileCallback;
import com.huawei.riemann.location.bean.obs.Pvt;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class yn {
    public dC E5;
    public boolean FB;
    public SdmLocationAlgoWrapper G3;
    public ServiceConnection LW;
    public boolean Ot;
    public final Object Vw;
    public CityTileCallback Yx;
    public FB d2;
    public Messenger dC;
    public volatile boolean dW;
    public CityTileCallback h1;
    public Intent oc;
    public ArrayList<com.huawei.riemann.common.api.location.yn> ut;
    public Context yn;
    public LW zp;

    public class E5 implements Runnable {
        public byte[] Vw;
        public long yn;

        public E5(long j, byte[] bArr) {
            this.yn = j;
            this.Vw = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d("SdmLocationManager", "TileUpdateRunnable run");
            SdmLocationAlgoWrapper sdmLocationAlgoWrapper = yn.this.G3;
            if (sdmLocationAlgoWrapper == null || !sdmLocationAlgoWrapper.FB) {
                Log.e("SdmLocationManager", "wp is null");
            } else {
                sdmLocationAlgoWrapper.sdmUpdateTileById(this.yn, this.Vw);
            }
        }
    }

    public static class FB extends HandlerThread {
        public yn yn;

        public FB(String str, yn ynVar) {
            super(str);
            this.yn = ynVar;
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            if (this.yn == null) {
                Log.i("SdmLocationManager", "slmgr null");
            }
        }
    }

    public class LW extends Handler {
        public LW(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ClassCastException e;
            String str;
            String str2;
            try {
                super.handleMessage(message);
                int i = message.what;
                if (i == 11) {
                    Log.d("SdmLocationManager", "handleMessage REGISTER LISTENER");
                    Object obj = message.obj;
                    if (obj instanceof com.huawei.riemann.common.api.location.yn) {
                        yn.this.ut.add((com.huawei.riemann.common.api.location.yn) obj);
                        return;
                    }
                    return;
                }
                if (i == 12) {
                    Log.d("SdmLocationManager", "handleMessage UNREGISTER LISTENER");
                    Object obj2 = message.obj;
                    if (obj2 instanceof com.huawei.riemann.common.api.location.yn) {
                        yn.this.ut.remove((com.huawei.riemann.common.api.location.yn) obj2);
                        return;
                    }
                    return;
                }
                if (i == 17) {
                    str = "handleMessage DELIVER RAW OBS";
                } else {
                    if (i == 18) {
                        Log.d("SdmLocationManager", "handleMessage REQUEST REMOTE TILE");
                        Bundle data = message.getData();
                        if (data == null) {
                            Log.e("SdmLocationManager", "bundle is null");
                            return;
                        }
                        long j = data.getLong("tileId");
                        CityTileCallback cityTileCallback = yn.this.h1;
                        if (cityTileCallback != null) {
                            byte[] bArr = cityTileCallback.get(j);
                            yn ynVar = yn.this;
                            ynVar.getClass();
                            Log.d("SdmLocationManager", "update local tile");
                            dC dCVar = ynVar.E5;
                            if (dCVar != null) {
                                dCVar.postAtFrontOfQueue(ynVar.new E5(j, bArr));
                                return;
                            }
                            str2 = "result hd is null";
                        } else {
                            str2 = "rcb null";
                        }
                        Log.e("SdmLocationManager", str2);
                        return;
                    }
                    str = "handleMessage unknown " + message.what;
                }
                try {
                    Log.d("SdmLocationManager", str);
                } catch (ClassCastException e2) {
                    e = e2;
                    Log.e("SdmLocationManager", e.getMessage() != null ? e.getMessage() : "ClassCastException2");
                    if (str == null) {
                        str = "handleMessage";
                    }
                    Log.e("SdmLocationManager", "SdmOpsHandler-" + str);
                }
            } catch (ClassCastException e3) {
                e = e3;
                str = null;
            }
        }
    }

    public static class Vw implements CityTileCallback {
        public Handler Vw;
        public CityTileCallback yn;

        public Vw(Handler handler, CityTileCallback cityTileCallback) {
            this.Vw = handler;
            this.yn = cityTileCallback;
        }

        @Override // com.huawei.riemann.common.api.location.CityTileCallback
        public byte[] get(long j) {
            if (this.Vw == null) {
                if (this.yn != null) {
                    Log.d("SdmLocationManager", "direct");
                    return this.yn.get(j);
                }
                Log.e("SdmLocationManager", "hd and remote cb null");
                return new byte[0];
            }
            Log.d("SdmLocationManager", "through hd");
            Bundle bundle = new Bundle();
            bundle.putLong("tileId", j);
            Message messageObtain = Message.obtain();
            messageObtain.what = 18;
            messageObtain.setData(bundle);
            this.Vw.sendMessageAtFrontOfQueue(messageObtain);
            return new byte[0];
        }
    }

    public class dC extends Handler {
        public dC() {
        }

        public dC(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                Log.d("SdmLocationManager", "SdmHandler msg - " + message.what);
                int i = message.what;
                if (i == 10001) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 10002;
                    messageObtain.setData(message.getData());
                    yn.this.E5.sendMessageAtFrontOfQueue(messageObtain);
                    return;
                }
                if (i != 10002) {
                    return;
                }
                Bundle data = message.getData();
                if (data == null) {
                    Log.e("SdmLocationManager", "bundle is null");
                    return;
                }
                Pvt pvt = (Pvt) data.getParcelable("imp-pvt");
                Iterator<com.huawei.riemann.common.api.location.yn> it = yn.this.ut.iterator();
                while (it.hasNext()) {
                    it.next().yn(pvt);
                }
            } catch (ClassCastException e) {
                Log.e("SdmLocationManager", e.getMessage() != null ? e.getMessage() : "ClassCastException1");
                Log.e("SdmLocationManager", "SdmResultHandler-" + (0 == 0 ? "handleMessage" : null));
            }
        }
    }

    /* renamed from: com.huawei.riemann.location.yn$yn, reason: collision with other inner class name */
    public class ServiceConnectionC0101yn implements ServiceConnection {
        public ServiceConnectionC0101yn() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("SdmLocationManager", "onServiceConnected");
            yn.this.dC = new Messenger(iBinder);
            yn.this.FB = true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("SdmLocationManager", "onServiceDisconnected");
            yn ynVar = yn.this;
            ynVar.dC = null;
            ynVar.FB = false;
        }
    }

    public yn(Context context, Intent intent, Looper looper, String str) {
        this.Vw = new Object();
        this.FB = false;
        this.dC = null;
        this.ut = new ArrayList<>();
        this.oc = null;
        this.Ot = false;
        this.G3 = null;
        this.Yx = null;
        this.h1 = null;
        this.dW = false;
        this.LW = new ServiceConnectionC0101yn();
        this.yn = context;
        this.oc = intent;
        this.G3 = SdmLocationAlgoWrapper.yn(context, str);
        yn(looper);
        com.huawei.location.LW.yn();
    }

    public yn(Context context, Intent intent, String str) {
        this(context, intent, null, str);
    }

    public yn(Context context, Looper looper, String str) {
        this(context, null, looper, str);
    }

    public yn(Context context, String str) {
        this(context, null, null, str);
    }

    public final void yn(Looper looper) {
        if (!this.Ot) {
            if (looper == null) {
                this.E5 = Looper.myLooper() == null ? new dC(this.yn.getMainLooper()) : new dC();
            } else {
                this.E5 = new dC(looper);
            }
            FB fb = new FB("SdmLocationManagerThread", this);
            this.d2 = fb;
            fb.start();
            this.zp = new LW(this.d2.getLooper());
        }
        this.Ot = true;
    }
}
