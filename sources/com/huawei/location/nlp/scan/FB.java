package com.huawei.location.nlp.scan;

import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import java.util.Comparator;

/* loaded from: classes3.dex */
class FB implements Comparator<WifiInfo> {
    FB(LW lw) {
    }

    @Override // java.util.Comparator
    public int compare(WifiInfo wifiInfo, WifiInfo wifiInfo2) {
        WifiInfo wifiInfo3 = wifiInfo;
        WifiInfo wifiInfo4 = wifiInfo2;
        if (wifiInfo3 != null || wifiInfo4 != null) {
            if (wifiInfo3 != null) {
                if (wifiInfo4 == null || wifiInfo3.getTime() > wifiInfo4.getTime() || (wifiInfo3.getTime() == wifiInfo4.getTime() && wifiInfo3.getRssi() > wifiInfo4.getRssi())) {
                    return -1;
                }
                if (wifiInfo3.getTime() != wifiInfo4.getTime() || wifiInfo3.getRssi() != wifiInfo4.getRssi()) {
                }
            }
            return 1;
        }
        return 0;
    }
}
