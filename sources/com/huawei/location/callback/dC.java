package com.huawei.location.callback;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.secure.android.common.intent.SafeBundle;

/* loaded from: classes3.dex */
public class dC extends Ot {
    private Location G3;
    private Location Ot;

    public dC(RequestLocationUpdatesRequest requestLocationUpdatesRequest, oc ocVar) {
        super(requestLocationUpdatesRequest, ocVar);
    }

    @Override // com.huawei.location.callback.Ot, com.huawei.location.callback.d2, android.location.LocationListener
    public void onLocationChanged(Location location) {
        LogLocation.i("FusedForGCallback", "fusedForG gnss location successful");
        if (!com.huawei.location.activity.model.Vw.yn(this.dC)) {
            try {
                com.huawei.location.logic.LW.yn().yn(this.dC.getUuid());
                LogLocation.i("FusedForGCallback", "request expiration and remove");
                return;
            } catch (LocationServiceException unused) {
                LogLocation.e("FusedForGCallback", "throw locationServiceException");
                return;
            }
        }
        if (!TextUtils.equals("gps", location.getProvider())) {
            super.onLocationChanged(location);
            return;
        }
        LogLocation.i("FusedForGCallback", "receive native gnss loc");
        HwLocationResult hwLocationResult = new HwLocationResult();
        hwLocationResult.setLocation(location);
        dC(hwLocationResult);
    }

    @Override // com.huawei.location.callback.Ot, com.huawei.location.callback.d2
    protected void yn(Bundle bundle) {
        HwLocationResult hwLocationResult = (HwLocationResult) new SafeBundle(bundle).getParcelable("hwLocationResult");
        if (FB(hwLocationResult)) {
            return;
        }
        Location location = hwLocationResult.getLocation();
        LogLocation.i("FusedForGCallback", "handlerFuesdLocation, location provider is " + location.getProvider());
        if ("gps".equals(location.getProvider())) {
            this.G3 = new Location(location);
        } else {
            this.Ot = new Location(location);
        }
        Location locationYn = yn(this.G3, this.Ot);
        if (yn(locationYn)) {
            hwLocationResult.setLocation(locationYn);
            this.oc.set(false);
            yn(hwLocationResult);
        }
    }
}
