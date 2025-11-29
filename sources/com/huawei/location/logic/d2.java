package com.huawei.location.logic;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.location.LocationRequest;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.secure.android.common.intent.SafeBundle;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class d2 {
    private Handler FB;
    private int Vw;
    private ConcurrentHashMap<com.huawei.location.callback.d2, E5> yn;

    /* JADX INFO: Access modifiers changed from: private */
    static class Vw {
        private static final d2 yn = new d2(null);
    }

    class yn implements Handler.Callback {
        yn() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            return d2.yn(d2.this, message);
        }
    }

    private d2() {
        this.Vw = 0;
        this.yn = new ConcurrentHashMap<>();
        HandlerThread handlerThread = new HandlerThread("MaxWaitTimeManager");
        handlerThread.start();
        this.FB = new Handler(handlerThread.getLooper(), new yn());
    }

    /* synthetic */ d2(yn ynVar) {
        this();
    }

    public static d2 yn() {
        return Vw.yn;
    }

    private void yn(com.huawei.location.callback.d2 d2Var, E5 e5) {
        String str;
        LogLocation.i("MaxWaitTimeManager", "callback maxWaitTime start :" + e5.LW());
        if (d2Var == null) {
            LogLocation.e("MaxWaitTimeManager", "callback maxWaitTime failed , callback is null");
            return;
        }
        if (e5.yn() == null || e5.yn().size() <= 0) {
            str = "not need callback, locations size is null";
        } else {
            LogLocation.i("MaxWaitTimeManager", "callback locationResult size is " + e5.yn().size());
            Iterator<Location> it = e5.yn().iterator();
            while (it.hasNext()) {
                d2Var.Vw(new HwLocationResult(0, com.huawei.location.constant.yn.yn(0), it.next()));
            }
            if (e5.yn() != null) {
                e5.yn().clear();
            }
            this.yn.put(d2Var, e5);
            str = "callback maxWaitTime end";
        }
        LogLocation.i("MaxWaitTimeManager", str);
    }

    static boolean yn(d2 d2Var, Message message) {
        com.huawei.location.callback.d2 d2Var2;
        E5 e5;
        com.huawei.location.callback.d2 d2Var3;
        E5 e52;
        d2Var.getClass();
        LogLocation.i("MaxWaitTimeManager", "handleMessage msg what:" + message.what);
        ConcurrentHashMap<com.huawei.location.callback.d2, E5> concurrentHashMap = d2Var.yn;
        if (concurrentHashMap != null) {
            int i = message.what;
            if (i == 2147483636) {
                Object obj = message.obj;
                if (obj instanceof com.huawei.location.callback.d2) {
                    com.huawei.location.callback.d2 d2Var4 = (com.huawei.location.callback.d2) obj;
                    E5 e53 = concurrentHashMap.get(d2Var4);
                    if (e53 == null) {
                        LogLocation.e("MaxWaitTimeManager", "updateLocations failed , no find bean");
                    } else {
                        Bundle data = message.getData();
                        if (data != null) {
                            Serializable serializable = new SafeBundle(data).getSerializable("TAG_BEAN");
                            if (serializable instanceof E5) {
                                e53.yn(((E5) serializable).yn());
                                d2Var.yn.put(d2Var4, e53);
                                LogLocation.i("MaxWaitTimeManager", "updateLocations success");
                            }
                        }
                    }
                    return true;
                }
            } else if (i != 2147483637) {
                Object obj2 = message.obj;
                if ((obj2 instanceof com.huawei.location.callback.d2) && (e52 = concurrentHashMap.get((d2Var3 = (com.huawei.location.callback.d2) obj2))) != null) {
                    d2Var.yn(d2Var3, e52);
                    Message messageObtainMessage = d2Var.FB.obtainMessage();
                    messageObtainMessage.what = e52.FB();
                    messageObtainMessage.obj = d2Var3;
                    d2Var.FB.sendMessageDelayed(messageObtainMessage, e52.Vw());
                }
            } else {
                Object obj3 = message.obj;
                if ((obj3 instanceof com.huawei.location.callback.d2) && (e5 = concurrentHashMap.get((d2Var2 = (com.huawei.location.callback.d2) obj3))) != null) {
                    d2Var.FB.removeMessages(e5.FB());
                    d2Var.yn(d2Var2, e5);
                    d2Var.yn.remove(d2Var2);
                    LogLocation.i("MaxWaitTimeManager", "removeMaxWaitTimeQueue success");
                }
            }
        }
        return false;
    }

    public void yn(com.huawei.location.cache.Vw vw, String str) {
        LogLocation.i("MaxWaitTimeManager", "removeMaxWaitTimeQueue transactionID:" + str);
        if (vw.yn() == null) {
            return;
        }
        com.huawei.location.callback.d2 d2VarYn = vw.yn();
        if (this.yn.containsKey(d2VarYn)) {
            Message messageObtainMessage = this.FB.obtainMessage(2147483637);
            messageObtainMessage.obj = d2VarYn;
            this.FB.sendMessage(messageObtainMessage);
            LogLocation.i("MaxWaitTimeManager", "removeMaxWaitTimeQueue send msg");
        }
    }

    public void yn(com.huawei.location.callback.d2 d2Var, String str, long j, LocationRequest locationRequest) {
        String str2;
        String str3;
        LogLocation.i("MaxWaitTimeManager", "addMaxWaitTimeQueue start transactionID:" + str);
        if (d2Var == null) {
            str3 = "addMaxWaitTimeQueue failed , callback is null";
        } else {
            if (this.Vw != 1073741822) {
                if (this.yn == null) {
                    this.yn = new ConcurrentHashMap<>();
                }
                if (this.yn.containsKey(d2Var)) {
                    LogLocation.i("MaxWaitTimeManager", "addMaxWaitTimeQueue update bean and restart queue");
                    E5 e5 = this.yn.get(d2Var);
                    if (e5 == null) {
                        return;
                    }
                    e5.yn(j);
                    e5.yn(str);
                    this.yn.putIfAbsent(d2Var, e5);
                    Message messageObtainMessage = this.FB.obtainMessage();
                    messageObtainMessage.what = e5.FB();
                    messageObtainMessage.obj = d2Var;
                    this.FB.removeMessages(e5.FB());
                    this.FB.sendMessageDelayed(messageObtainMessage, j);
                    str2 = "addMaxWaitTimeQueue update bean and restart queue send msg";
                } else {
                    LogLocation.i("MaxWaitTimeManager", "addMaxWaitTimeQueue new bean and start queue");
                    this.yn.put(d2Var, new E5(str, this.Vw, j, null, locationRequest));
                    Message messageObtainMessage2 = this.FB.obtainMessage();
                    messageObtainMessage2.what = this.Vw;
                    messageObtainMessage2.obj = d2Var;
                    this.FB.sendMessageDelayed(messageObtainMessage2, j);
                    this.Vw++;
                    str2 = "addMaxWaitTimeQueue new bean and restart queue send msg";
                }
                LogLocation.i("MaxWaitTimeManager", str2);
                return;
            }
            str3 = "addMaxWaitTimeQueue failed , msgWhat is out of number";
        }
        LogLocation.e("MaxWaitTimeManager", str3);
    }

    public boolean yn(String str, com.huawei.location.callback.d2 d2Var, List<Location> list) {
        LogLocation.i("MaxWaitTimeManager", "updateLocations start transactionID:" + str);
        if (this.yn.size() == 0) {
            LogLocation.i("MaxWaitTimeManager", "map is null , no need update");
            return false;
        }
        if (list.isEmpty()) {
            LogLocation.i("MaxWaitTimeManager", "updateLocations failed , locations is null");
            return false;
        }
        if (!this.yn.containsKey(d2Var)) {
            LogLocation.e("MaxWaitTimeManager", "updateLocations failed , not contains id");
            return false;
        }
        Message messageObtainMessage = this.FB.obtainMessage(2147483636);
        messageObtainMessage.obj = d2Var;
        E5 e5 = new E5(str, -1, -1L, list, null);
        SafeBundle safeBundle = new SafeBundle();
        safeBundle.putSerializable("TAG_BEAN", e5);
        messageObtainMessage.setData(safeBundle.getBundle());
        this.FB.sendMessage(messageObtainMessage);
        LogLocation.i("MaxWaitTimeManager", "updateLocations send msg");
        return true;
    }
}
