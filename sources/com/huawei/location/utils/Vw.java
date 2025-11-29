package com.huawei.location.utils;

import android.location.Location;
import android.os.Bundle;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.hms.support.api.location.common.LocationRequestHelper;
import com.huawei.location.lite.common.agc.AGCManager;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.report.ReportBuilder;
import com.huawei.location.lite.common.report.Tracker;
import com.huawei.location.lite.common.util.APKUtil;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.secure.android.common.intent.SafeBundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class Vw {
    private ReportBuilder yn;

    public static class yn {
        private ReportBuilder yn;

        public yn() {
            ReportBuilder reportBuilder = new ReportBuilder();
            this.yn = reportBuilder;
            reportBuilder.setAppID(AGCManager.getInstance().getAppId());
        }

        public yn FB(String str) {
            this.yn.setTransactionID(str);
            return this;
        }

        public yn Vw() {
            this.yn.setWLANScan();
            return this;
        }

        public yn Vw(String str) {
            this.yn.setExt(str);
            return this;
        }

        public yn yn(LocationRequest locationRequest, boolean z) {
            HashMap map = new HashMap();
            if (locationRequest != null) {
                map.put(RemoteMessageConst.Notification.PRIORITY, Integer.valueOf(locationRequest.getPriority()));
                map.put("interval", Long.valueOf(locationRequest.getInterval()));
                map.put("fastestInterval", Long.valueOf(locationRequest.getFastestInterval()));
                map.put("expirationTime", Long.valueOf(locationRequest.getExpirationTime()));
                map.put("numUpdates", Integer.valueOf(locationRequest.getNumUpdates()));
                map.put("smallestDisplacement", Float.valueOf(locationRequest.getSmallestDisplacement()));
                map.put("needAddress", Boolean.valueOf(locationRequest.getNeedAddress()));
                map.put("maxWaitTime", Long.valueOf(locationRequest.getMaxWaitTime()));
                if (z) {
                    map.put("isDuplicate", 1);
                }
                Map<String, String> extras = locationRequest.getExtras();
                if (extras != null && extras.containsKey(LocationRequestHelper.CP_TRANS_ID)) {
                    map.put(LocationRequestHelper.CP_TRANS_ID, extras.get(LocationRequestHelper.CP_TRANS_ID));
                }
            }
            try {
                this.yn.setExt(GsonUtil.getInstance().toJson(map));
            } catch (Exception unused) {
                LogLocation.e("LocationClientReport", "GsonUtil.getInstance().toJson(map) exception");
            }
            return this;
        }

        public yn yn(LocationBaseRequest locationBaseRequest) {
            if (locationBaseRequest != null) {
                this.yn.setTransactionID(locationBaseRequest.getTid());
                this.yn.setLocationEnable(LocationUtil.isLocationEnabled(ContextUtil.getContext()));
                this.yn.setPackage(locationBaseRequest.getPackageName());
                this.yn.setCpAppVersion(String.valueOf(APKUtil.getThirdAppVersionCode(locationBaseRequest.getPackageName())));
            }
            return this;
        }

        public yn yn(com.huawei.location.resp.Vw vw) {
            ArrayList arrayList = (ArrayList) vw.Vw();
            if (arrayList.size() == 0) {
                this.yn.setExt("");
                return this;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Location location = (Location) it.next();
                HashMap map = new HashMap();
                map.put("provider", location.getProvider());
                map.put("accuracy", Float.valueOf(location.getAccuracy()));
                map.put("locationTime", Long.valueOf(location.getTime()));
                map.put("locationType", Integer.valueOf((location.getExtras() != null && (new SafeBundle(location.getExtras()).getInt("SourceType") & 8) == 8) ? 1 : 0));
                Bundle extras = location.getExtras();
                SafeBundle safeBundle = new SafeBundle(extras);
                if (extras != null) {
                    if (safeBundle.containsKey("session_id")) {
                        map.put("session_id", safeBundle.getString("session_id"));
                    }
                    if (safeBundle.containsKey("vendorType")) {
                        map.put("vendorType", Integer.valueOf(safeBundle.getInt("vendorType")));
                    }
                    if (safeBundle.containsKey("locateType")) {
                        map.put("locateType", safeBundle.getString("locateType"));
                    }
                    if (safeBundle.containsKey("isCache")) {
                        map.put("isCache", Boolean.valueOf(safeBundle.getBoolean("isCache")));
                    }
                }
                arrayList2.add(map);
            }
            try {
                this.yn.setExt(GsonUtil.getInstance().toJson(arrayList2));
            } catch (Exception unused) {
                LogLocation.e("LocationClientReport", "GsonUtil.getInstance().toJson(list) exception");
            }
            return this;
        }

        public yn yn(String str) {
            this.yn.setApiName(str);
            return this;
        }

        public Vw yn() {
            return new Vw(this.yn);
        }
    }

    public Vw(ReportBuilder reportBuilder) {
        this.yn = reportBuilder;
    }

    public void Vw(String str) {
        this.yn.setResult(str);
        this.yn.setCostTime();
        Tracker.getInstance().onMaintEvent(this.yn);
        Tracker.getInstance().onOperationEvent(this.yn);
        this.yn.setCallTime();
    }

    public void yn(String str) {
        this.yn.setErrorCode(str);
        this.yn.setCostTime();
        Tracker.getInstance().onMaintEvent(this.yn);
        Tracker.getInstance().onOperationEvent(this.yn);
    }
}
