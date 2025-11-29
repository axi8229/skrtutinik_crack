package com.huawei.location.provider;

import com.huawei.location.gnss.api.Vw;
import com.huawei.location.lite.common.log.LogLocation;

/* loaded from: classes3.dex */
public class yn {
    private Vw yn = new Vw();

    public void Vw(com.huawei.location.cache.Vw vw) {
        if (vw.dC() == null) {
            LogLocation.i("NLPProvider", "locationRequest is invalid");
            return;
        }
        LogLocation.i("NLPProvider", "requestLocation, LocationRequest is " + vw.Vw().toString());
        this.yn.yn(vw.dC(), vw.yn());
        com.huawei.location.nlp.api.yn.yn().Vw(vw.dC());
    }

    public void yn(com.huawei.location.cache.Vw vw) {
        if (vw.yn() != null) {
            this.yn.yn(vw.yn());
        }
        if (vw.dC() != null) {
            com.huawei.location.nlp.api.yn.yn().yn(vw.dC());
        }
    }
}
