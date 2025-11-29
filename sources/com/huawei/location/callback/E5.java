package com.huawei.location.callback;

import android.location.Location;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.utils.Vw;

/* loaded from: classes3.dex */
public class E5 extends d2 {
    public E5(RequestLocationUpdatesRequest requestLocationUpdatesRequest, oc ocVar) {
        this.LW = new Vw.yn().yn("Location_locationCallbackEx").FB(requestLocationUpdatesRequest.getTid());
        this.yn = ocVar;
        this.dC = requestLocationUpdatesRequest;
    }

    @Override // com.huawei.location.callback.d2, android.location.LocationListener
    public void onLocationChanged(Location location) {
        LogLocation.i("HDLocationCallback", "gnss location successful");
        if (com.huawei.location.activity.model.Vw.yn(this.dC)) {
            HwLocationResult hwLocationResult = new HwLocationResult();
            hwLocationResult.setLocation(location);
            LW(hwLocationResult);
        } else {
            try {
                com.huawei.location.logic.LW.yn().yn(this.dC.getUuid());
                LogLocation.i("HDLocationCallback", "request expiration and remove");
            } catch (LocationServiceException unused) {
                LogLocation.e("HDLocationCallback", "HDLocationCallback throw locationServiceException");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @Override // com.huawei.location.callback.d2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void yn(android.os.Bundle r6) {
        /*
            r5 = this;
            java.lang.String r0 = "handlerLocation"
            java.lang.String r1 = "HDLocationCallback"
            com.huawei.location.lite.common.log.LogLocation.i(r1, r0)
            com.huawei.secure.android.common.intent.SafeBundle r0 = new com.huawei.secure.android.common.intent.SafeBundle
            r0.<init>(r6)
            java.lang.String r6 = "hwLocationResult"
            android.os.Parcelable r6 = r0.getParcelable(r6)
            com.huawei.hms.location.HwLocationResult r6 = (com.huawei.hms.location.HwLocationResult) r6
            boolean r0 = r5.FB(r6)
            if (r0 == 0) goto L1b
            return
        L1b:
            android.location.Location r0 = r6.getLocation()
            if (r0 != 0) goto L27
            java.lang.String r0 = "modifySourceType location is Empty, modifySourceType fail."
        L23:
            com.huawei.location.lite.common.log.LogLocation.e(r1, r0)
            goto L4d
        L27:
            android.os.Bundle r2 = r0.getExtras()
            if (r2 != 0) goto L30
            java.lang.String r0 = "modifySourceType extras is Empty, modifySourceType fail."
            goto L23
        L30:
            com.huawei.secure.android.common.intent.SafeBundle r1 = new com.huawei.secure.android.common.intent.SafeBundle
            r1.<init>(r2)
            java.lang.String r3 = "SourceType"
            boolean r4 = r1.containsKey(r3)
            if (r4 == 0) goto L46
            int r2 = r2.getInt(r3)
            r2 = r2 & 247(0xf7, float:3.46E-43)
            r1.putInt(r3, r2)
        L46:
            android.os.Bundle r1 = r1.getBundle()
            r0.setExtras(r1)
        L4d:
            android.location.Location r0 = r6.getLocation()
            boolean r0 = r5.yn(r0)
            if (r0 == 0) goto L5a
            r5.yn(r6)
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.callback.E5.yn(android.os.Bundle):void");
    }

    @Override // com.huawei.location.callback.d2
    public void yn(boolean z, boolean z2) {
        if (z) {
            return;
        }
        yn(false);
    }
}
