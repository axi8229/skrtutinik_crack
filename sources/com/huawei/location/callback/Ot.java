package com.huawei.location.callback;

import android.location.Location;
import android.os.Bundle;
import android.os.Message;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.utils.Vw;
import com.huawei.secure.android.common.intent.SafeBundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class Ot extends d2 {
    protected AtomicBoolean oc = new AtomicBoolean(true);
    protected Location ut;
    protected Location zp;

    public Ot(RequestLocationUpdatesRequest requestLocationUpdatesRequest, oc ocVar) {
        this.LW = new Vw.yn().yn("Location_locationCallback").FB(requestLocationUpdatesRequest.getTid());
        this.yn = ocVar;
        this.dC = requestLocationUpdatesRequest;
        this.FB.sendEmptyMessageDelayed(1002, 3000L);
    }

    @Override // com.huawei.location.callback.d2
    public void LW(HwLocationResult hwLocationResult) {
        String str;
        String str2;
        LogLocation.i("NLPCallback", "receive posEngine loc, isFirst is " + this.oc);
        if (this.oc.get()) {
            this.ut = hwLocationResult.getLocation();
            if (this.FB.hasMessages(1002) && this.zp == null) {
                return;
            }
            this.FB.removeMessages(1002);
            this.FB.sendEmptyMessage(1002);
            return;
        }
        Location location = hwLocationResult.getLocation();
        Location location2 = this.zp;
        if (location == null && location2 == null) {
            LogLocation.i("NLPCallback", "compareElapsedRealtimeNanos both is null");
            location = null;
        } else {
            if (location == null) {
                str = "posEngineLoc is null";
            } else {
                if (location2 == null) {
                    str2 = "nativeLoc is null";
                } else if (location.getElapsedRealtimeNanos() > location2.getElapsedRealtimeNanos() + 20000000000L) {
                    str2 = "nativeNetworkLoc elapsedRealtimeNanos is invalid";
                } else if (location2.getElapsedRealtimeNanos() > location.getElapsedRealtimeNanos() + 20000000000L) {
                    str = "posEngineLoc elapsedRealtimeNanos is invalid";
                } else {
                    location = Vw(location, location2);
                }
                LogLocation.i("NLPCallback", str2);
            }
            LogLocation.i("NLPCallback", str);
            location = location2;
        }
        if (location == null) {
            LogLocation.i("NLPCallback", "onLocationChanged bestLoc is null ");
        } else {
            hwLocationResult.setLocation(location);
            dC(hwLocationResult);
        }
    }

    protected Location Vw(Location location, Location location2) {
        String str;
        if (location == null && location2 == null) {
            LogLocation.i("NLPCallback", "posEngineLoc & nativeNetworkLoc is null");
            return null;
        }
        if (location == null) {
            str = "posEngineLoc is null";
        } else {
            if (location2 == null) {
                LogLocation.i("NLPCallback", "nativeNetworkLoc is null");
                return location;
            }
            if (!location.hasAccuracy()) {
                str = "posEngineLoc not hasAccuracy";
            } else {
                if (!location2.hasAccuracy()) {
                    LogLocation.i("NLPCallback", "nativeLoc not hasAccuracy");
                    return location;
                }
                if (location.getAccuracy() < location2.getAccuracy()) {
                    LogLocation.i("NLPCallback", "posEngineLoc acc is better");
                    return location;
                }
                str = "nativeLoc acc is better";
            }
        }
        LogLocation.i("NLPCallback", str);
        return location2;
    }

    protected void dC(HwLocationResult hwLocationResult) {
        hwLocationResult.setCode(0);
        Message messageObtainMessage = this.FB.obtainMessage(1001);
        Bundle bundle = new Bundle();
        bundle.putParcelable("hwLocationResult", hwLocationResult);
        messageObtainMessage.setData(bundle);
        this.FB.sendMessage(messageObtainMessage);
    }

    @Override // com.huawei.location.callback.d2, android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (location == null) {
            LogLocation.e("NLPCallback", "receive native network loc is null");
            return;
        }
        SafeBundle safeBundle = new SafeBundle(location.getExtras());
        safeBundle.putInt("vendorType", 32);
        location.setExtras(safeBundle.getBundle());
        location.setProvider("network");
        this.zp = location;
        LogLocation.i("NLPCallback", "receive native network loc, isFirst is " + this.oc);
        if (this.oc.get()) {
            if (this.FB.hasMessages(1002) && this.ut == null) {
                return;
            }
            this.FB.removeMessages(1002);
            this.FB.sendEmptyMessage(1002);
        }
    }

    @Override // com.huawei.location.callback.d2
    protected void yn(Bundle bundle) {
        HwLocationResult hwLocationResult = (HwLocationResult) new SafeBundle(bundle).getParcelable("hwLocationResult");
        if (!FB(hwLocationResult) && yn(hwLocationResult.getLocation())) {
            this.oc.set(false);
            yn(hwLocationResult);
        }
    }

    @Override // com.huawei.location.callback.d2
    protected void yn(Message message) {
        LogLocation.i("NLPCallback", "handleFirstDelayMsg");
        Location locationVw = Vw(this.ut, this.zp);
        if (locationVw == null) {
            LogLocation.e("NLPCallback", "handleFirstDelayMsg, accLocation is null");
            return;
        }
        HwLocationResult hwLocationResult = new HwLocationResult();
        hwLocationResult.setCode(0);
        hwLocationResult.setLocation(locationVw);
        Bundle bundle = new Bundle();
        bundle.putParcelable("hwLocationResult", hwLocationResult);
        yn(bundle);
    }

    @Override // com.huawei.location.callback.d2
    public void yn(boolean z, boolean z2) {
        if (z) {
            return;
        }
        yn(false);
    }
}
