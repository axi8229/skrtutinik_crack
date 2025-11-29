package com.huawei.location.lite.common.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class GnssAndNetReceiver {
    private SafeBroadcastReceiver gnssReceiver;
    private boolean isFirstReceive = true;
    private AtomicInteger networkCnt;
    private SafeBroadcastReceiver networkReceiver;

    public GnssAndNetReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.location.MODE_CHANGED");
        this.gnssReceiver = new SafeBroadcastReceiver() { // from class: com.huawei.location.lite.common.android.receiver.GnssAndNetReceiver.1
            @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
            public void onSafeReceive(Intent intent) {
                if (TextUtils.equals(new SafeIntent(intent).getAction(), "android.location.MODE_CHANGED")) {
                    GnssAndNetReceiver.this.notifyListeners();
                }
            }

            @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
            public String receiveThreadName() {
                return "Loc-Receive-GNSS";
            }
        };
        ContextUtil.getContext().registerReceiver(this.gnssReceiver, intentFilter);
        LogLocation.i("GnssAndNetReceiver", "register gnss receiver ");
    }

    private void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            ContextUtil.getContext().unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e) {
            LogLocation.e("GnssAndNetReceiver", e.getMessage());
        }
    }

    public abstract void notifyListeners();

    public void registerNetworkObserve() {
        if (this.networkCnt == null) {
            this.networkCnt = new AtomicInteger(0);
        }
        this.networkCnt.incrementAndGet();
        LogLocation.d("GnssAndNetReceiver", "network observe cnt incrementAndGet:" + this.networkCnt.get());
        if (this.networkReceiver != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.networkReceiver = new SafeBroadcastReceiver() { // from class: com.huawei.location.lite.common.android.receiver.GnssAndNetReceiver.2
            @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
            public void onSafeReceive(Intent intent) {
                if (TextUtils.equals(new SafeIntent(intent).getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
                    if (GnssAndNetReceiver.this.isFirstReceive) {
                        GnssAndNetReceiver.this.isFirstReceive = false;
                    } else {
                        GnssAndNetReceiver.this.notifyListeners();
                    }
                }
            }

            @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
            public String receiveThreadName() {
                return "Loc-Receive-Network";
            }
        };
        ContextUtil.getContext().registerReceiver(this.networkReceiver, intentFilter);
        LogLocation.i("GnssAndNetReceiver", "register network receiver");
    }

    public void unRegisterAllObserve() {
        SafeBroadcastReceiver safeBroadcastReceiver = this.networkReceiver;
        if (safeBroadcastReceiver != null) {
            unregisterReceiver(safeBroadcastReceiver);
            this.networkReceiver = null;
            LogLocation.i("GnssAndNetReceiver", "unregister network receiver");
        }
        SafeBroadcastReceiver safeBroadcastReceiver2 = this.gnssReceiver;
        if (safeBroadcastReceiver2 != null) {
            unregisterReceiver(safeBroadcastReceiver2);
            this.gnssReceiver = null;
            LogLocation.i("GnssAndNetReceiver", "unregister gnss receiver");
        }
    }

    public void unRegisterNetworkObserve() {
        AtomicInteger atomicInteger = this.networkCnt;
        if (atomicInteger == null || this.networkReceiver == null) {
            return;
        }
        atomicInteger.decrementAndGet();
        LogLocation.d("GnssAndNetReceiver", "network observe cnt decrementAndGet:" + this.networkCnt.get());
        if (this.networkCnt.get() <= 0) {
            unregisterReceiver(this.networkReceiver);
            this.isFirstReceive = true;
            this.networkReceiver = null;
            this.networkCnt = null;
            LogLocation.i("GnssAndNetReceiver", "unregister network receiver");
        }
    }
}
