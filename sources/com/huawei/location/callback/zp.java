package com.huawei.location.callback;

import android.os.Bundle;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.utils.Vw;
import com.huawei.secure.android.common.intent.SafeBundle;

/* loaded from: classes3.dex */
public class zp extends d2 {
    public zp(RequestLocationUpdatesRequest requestLocationUpdatesRequest, oc ocVar) {
        this.LW = new Vw.yn().yn("Location_locationCallback").FB(requestLocationUpdatesRequest.getTid());
        this.yn = ocVar;
        this.dC = requestLocationUpdatesRequest;
    }

    @Override // com.huawei.location.callback.d2
    protected void yn(Bundle bundle) {
        LogLocation.i("HwCommonCallback", "handlerLocation");
        HwLocationResult hwLocationResult = (HwLocationResult) new SafeBundle(bundle).getParcelable("hwLocationResult");
        if (!FB(hwLocationResult) && yn(hwLocationResult.getLocation())) {
            yn(hwLocationResult);
        }
    }

    @Override // com.huawei.location.callback.d2
    public void yn(boolean z, boolean z2) {
        if (z && z2) {
            return;
        }
        yn(false);
    }
}
