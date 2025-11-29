package com.huawei.location.cache;

import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.callback.d2;

/* loaded from: classes3.dex */
public class Vw {
    private d2 Vw;
    private RequestLocationUpdatesRequest yn;

    public Vw() {
        this(new RequestLocationUpdatesRequest());
    }

    public Vw(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        this.yn = requestLocationUpdatesRequest;
    }

    public String E5() {
        return this.yn.getTid();
    }

    public int FB() {
        LocationRequest locationRequest = this.yn.getLocationRequest();
        if (locationRequest == null) {
            return -1;
        }
        return locationRequest.getPriority();
    }

    public String LW() {
        LocationRequest locationRequest = this.yn.getLocationRequest();
        if (locationRequest == null) {
            return "";
        }
        int priority = locationRequest.getPriority();
        if (priority != 100) {
            if (priority != 102) {
                if (priority == 200) {
                    return "gps";
                }
                if (priority != 300) {
                    if (priority != 400) {
                        if (priority != 104) {
                            return priority != 105 ? "" : "passive";
                        }
                    }
                }
            }
            return "network";
        }
        return "fused";
    }

    public LocationRequest Vw() {
        return this.yn.getLocationRequest();
    }

    public String d2() {
        return this.yn.getUuid();
    }

    public RequestLocationUpdatesRequest dC() {
        return this.yn;
    }

    public d2 yn() {
        return this.Vw;
    }

    public void yn(d2 d2Var) {
        this.Vw = d2Var;
    }
}
