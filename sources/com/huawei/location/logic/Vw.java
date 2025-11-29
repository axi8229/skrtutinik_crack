package com.huawei.location.logic;

import com.huawei.hms.location.entity.activity.ActivityTransitionRequest;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.LocationUtil;

/* loaded from: classes3.dex */
public class Vw implements FB {
    private static volatile FB Vw;
    private static final byte[] yn = new byte[0];
    private yn FB = yn.yn();

    private Vw() {
        LocationUtil.registerScreenStatusBroadcast();
    }

    public static FB yn() {
        if (Vw == null) {
            synchronized (yn) {
                try {
                    if (Vw == null) {
                        Vw = new Vw();
                    }
                } finally {
                }
            }
        }
        return Vw;
    }

    public void yn(long j, ARCallback aRCallback, ClientInfo clientInfo) {
        LogLocation.i("HwActivityRecognitionManager", "requestActivityUpdates begin.");
        this.FB.yn(j, aRCallback, clientInfo);
    }

    public void yn(ARCallback aRCallback, ClientInfo clientInfo) {
        LogLocation.i("HwActivityRecognitionManager", "removeActivityUpdates begin.");
        this.FB.yn(aRCallback, clientInfo);
    }

    public void yn(String str, ActivityTransitionRequest activityTransitionRequest, ATCallback aTCallback, ClientInfo clientInfo) {
        this.FB.yn(activityTransitionRequest, aTCallback, clientInfo);
    }

    public void yn(String str, ATCallback aTCallback, ClientInfo clientInfo) {
        this.FB.yn(aTCallback, clientInfo);
    }
}
