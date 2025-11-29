package com.huawei.location.logic;

import android.location.Location;
import com.huawei.location.callback.ut;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.android.receiver.GnssAndNetReceiver;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.location.lite.common.util.NetworkUtil;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class dC extends GnssAndNetReceiver {
    @Override // com.huawei.location.lite.common.android.receiver.GnssAndNetReceiver
    public void notifyListeners() {
        boolean zIsLocationEnabled = LocationUtil.isLocationEnabled(ContextUtil.getContext());
        boolean zIsNetworkAvailable = NetworkUtil.isNetworkAvailable(ContextUtil.getContext());
        if (!zIsLocationEnabled) {
            com.huawei.location.cache.yn.Vw().yn((Location) null);
        }
        if (zIsLocationEnabled && zIsNetworkAvailable) {
            LogLocation.i("LocationAvailabilityObserver", "available,resume scan and get location");
            com.huawei.location.nlp.api.yn.yn().FB();
        } else {
            LogLocation.i("LocationAvailabilityObserver", "unAvailable,stop scan and get location");
            com.huawei.location.nlp.api.yn.yn().LW();
        }
        Iterator<Map.Entry<String, com.huawei.location.cache.Vw>> it = com.huawei.location.cache.yn.Vw().yn().entrySet().iterator();
        while (it.hasNext()) {
            com.huawei.location.callback.d2 d2VarYn = it.next().getValue().yn();
            if (d2VarYn != null) {
                if ((d2VarYn instanceof com.huawei.location.callback.E5) || (d2VarYn instanceof ut) || (d2VarYn instanceof com.huawei.location.callback.dC)) {
                    d2VarYn.yn(zIsLocationEnabled);
                } else {
                    d2VarYn.yn(zIsLocationEnabled && zIsNetworkAvailable);
                }
            }
        }
    }
}
