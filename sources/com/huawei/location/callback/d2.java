package com.huawei.location.callback;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.resp.LocationAvailabilityInfo;
import com.huawei.location.resp.ResponseInfo;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.huawei.location.utils.Vw;
import com.yandex.varioqub.config.model.ConfigValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class d2 implements LocationListener {
    protected Handler FB;
    protected Vw.yn LW;
    public Location Vw;
    protected RequestLocationUpdatesRequest dC;
    public oc yn;
    private long E5 = SystemClock.elapsedRealtimeNanos();
    private boolean d2 = false;

    class yn implements Handler.Callback {
        yn() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1001) {
                d2.this.yn(message.getData());
                return false;
            }
            if (i == 1002) {
                d2.this.yn(message);
                return false;
            }
            LogLocation.w("HwBaseCallback", "handleMessage error");
            return false;
        }
    }

    public d2() {
        HandlerThread handlerThread = new HandlerThread("HwBaseCallback");
        handlerThread.start();
        this.FB = new Handler(handlerThread.getLooper(), new yn());
    }

    protected boolean FB(HwLocationResult hwLocationResult) {
        String str;
        if (hwLocationResult == null || hwLocationResult.getCode() != 0) {
            str = "checkLocationResult fail, hwLocationResult is invalid";
        } else if (hwLocationResult.getLocation() == null) {
            str = "checkLocationResult fail, location is null";
        } else {
            RequestLocationUpdatesRequest requestLocationUpdatesRequest = this.dC;
            if (requestLocationUpdatesRequest != null && !TextUtils.isEmpty(requestLocationUpdatesRequest.getUuid())) {
                return false;
            }
            str = "checkLocationResult fail, request is invalid";
        }
        LogLocation.e("HwBaseCallback", str);
        return true;
    }

    public void LW(HwLocationResult hwLocationResult) {
        Message messageObtainMessage = this.FB.obtainMessage(1001);
        Bundle bundle = new Bundle();
        bundle.putParcelable("hwLocationResult", hwLocationResult);
        messageObtainMessage.setData(bundle);
        this.FB.sendMessage(messageObtainMessage);
    }

    public void Vw(HwLocationResult hwLocationResult) {
        ResponseInfo responseInfo = new ResponseInfo();
        StatusInfo statusInfo = new StatusInfo(0, 0, hwLocationResult.getMessage());
        com.huawei.location.resp.Vw vw = new com.huawei.location.resp.Vw();
        vw.yn(this.Vw);
        responseInfo.setLocationResult(vw);
        List<com.huawei.location.resp.yn> arrayList = new ArrayList<>();
        if (responseInfo.getLocationResult() != null) {
            arrayList = responseInfo.getLocationResult().yn();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<com.huawei.location.resp.yn> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(com.huawei.location.activity.model.Vw.yn(it.next().yn()));
            }
            jSONObject2.put("locations", jSONArray);
            jSONObject.put("locationResult", jSONObject2);
        } catch (JSONException unused) {
            LogLocation.e("LocationInnerUtil", "buildEntityFromResponse get jsonException .");
        }
        String string = jSONObject.toString();
        LogLocation.i("HwBaseCallback", "callJson to cp, tid is " + this.dC.getTid() + ", uuid is " + this.dC.getUuid() + ", provider is " + this.Vw.getProvider());
        this.yn.yn(new RouterResponse(string, statusInfo));
        com.huawei.location.cache.yn.Vw().FB(this.dC.getUuid());
        Vw.yn ynVar = this.LW;
        if (ynVar != null) {
            ynVar.yn(vw);
            this.LW.yn().Vw(String.valueOf(0));
        }
    }

    public void Vw(boolean z) {
        this.d2 = z;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        LogLocation.i("HwBaseCallback", "gnss location successful");
        HwLocationResult hwLocationResult = new HwLocationResult();
        hwLocationResult.setLocation(location);
        LW(hwLocationResult);
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    protected Location yn(Location location, Location location2) {
        String str;
        String str2;
        if (location != null) {
            if (location2 == null) {
                str2 = "nlpTempLocation is null";
            } else if (location.getElapsedRealtimeNanos() >= SystemClock.elapsedRealtimeNanos() - 20000000000L) {
                str2 = "gnssLocation is better";
            } else {
                str = "network location is better";
            }
            LogLocation.i("HwBaseCallback", str2);
            return location;
        }
        str = "gnssTempLocation is null";
        LogLocation.i("HwBaseCallback", str);
        return location2;
    }

    public void yn() {
        Handler handler = this.FB;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        this.FB.getLooper().quitSafely();
        LogLocation.i("HwBaseCallback", "handler quitSafely");
    }

    protected abstract void yn(Bundle bundle);

    protected void yn(Message message) {
    }

    public void yn(HwLocationResult hwLocationResult) {
        if (com.huawei.location.activity.model.Vw.yn()) {
            LogLocation.e("HwBaseCallback", "no precise location permission");
            return;
        }
        Location location = this.Vw;
        if (this.d2 && location != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(location);
            if (com.huawei.location.logic.d2.yn().yn(this.dC.getTid(), this, arrayList)) {
                LogLocation.i("HwBaseCallback", "this locationResult add maxWaitTimeQueue , not need callback");
                if (this.Vw != null) {
                    this.E5 = SystemClock.elapsedRealtimeNanos();
                }
                this.Vw = location;
                com.huawei.location.cache.yn.Vw().yn(location);
                return;
            }
        }
        Location location2 = hwLocationResult.getLocation();
        if (this.Vw != null) {
            this.E5 = SystemClock.elapsedRealtimeNanos();
        }
        this.Vw = location2;
        com.huawei.location.cache.yn.Vw().yn(location2);
        Vw(hwLocationResult);
    }

    public void yn(boolean z) {
        ResponseInfo responseInfo = new ResponseInfo();
        LocationAvailabilityInfo locationAvailabilityInfo = new LocationAvailabilityInfo();
        locationAvailabilityInfo.setLocationStatus(z ? 0 : 1001);
        responseInfo.setLocationAvailability(locationAvailabilityInfo);
        this.yn.yn(new RouterResponse(GsonUtil.getInstance().toJson(responseInfo), new StatusInfo(0, 0, "success")));
    }

    public void yn(boolean z, boolean z2) {
    }

    protected boolean yn(Location location) {
        LocationRequest locationRequest = this.dC.getLocationRequest();
        if (locationRequest == null) {
            LogLocation.i("HwBaseCallback", "report location fail, locationRequest is null");
            return false;
        }
        if (this.Vw == null) {
            return true;
        }
        long jElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - this.E5) / 1000000;
        double dMin = Math.min(locationRequest.getInterval(), locationRequest.getFastestInterval());
        double d = 0.9d * dMin;
        if (dMin >= 2000.0d) {
            d = dMin - 1000.0d;
        }
        if (jElapsedRealtimeNanos < d) {
            LogLocation.e("HwBaseCallback", "report location fail, timeDifference is " + jElapsedRealtimeNanos + ", provider is " + location.getProvider());
            return false;
        }
        if (locationRequest.getNumUpdates() < 1) {
            LogLocation.e("HwBaseCallback", "report location fail, numUpdate < 1");
            return false;
        }
        double smallestDisplacement = locationRequest.getSmallestDisplacement();
        if (smallestDisplacement > ConfigValue.DOUBLE_DEFAULT_VALUE && location.distanceTo(this.Vw) <= smallestDisplacement) {
            LogLocation.i("HwBaseCallback", "report location fail, minDistance is not met");
            return false;
        }
        if (locationRequest.getExpirationTime() >= SystemClock.elapsedRealtime()) {
            return true;
        }
        LogLocation.i("HwBaseCallback", "report location fail, expirationTime is not met");
        return false;
    }
}
