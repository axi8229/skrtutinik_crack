package com.huawei.location.base.activity;

import android.os.SystemClock;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;
import com.huawei.hms.location.entity.activity.DetectedActivity;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class ActivityRecognitionMappingManager {
    private static final String TAG = "ActivityRecognitionMappingManager";
    private List<ActivityRecognitionMappingInfo> activityRecognitionMappingInfoList = new CopyOnWriteArrayList();

    private void callBackWithReport(ActivityRecognitionMappingInfo activityRecognitionMappingInfo, ActivityRecognitionResult activityRecognitionResult) {
        try {
            activityRecognitionMappingInfo.getCallback().onActivityRecognition(activityRecognitionResult);
        } catch (Exception unused) {
            LogLocation.e(TAG, "Failed to get activity recognition callback", true);
        }
    }

    private boolean isUpdate(ActivityRecognitionMappingInfo activityRecognitionMappingInfo) {
        for (int i = 0; i < this.activityRecognitionMappingInfoList.size(); i++) {
            if (this.activityRecognitionMappingInfoList.get(i).equals(activityRecognitionMappingInfo)) {
                ActivityRecognitionMappingInfo activityRecognitionMappingInfo2 = this.activityRecognitionMappingInfoList.get(i);
                LogLocation.i(TAG, "need update arMappingInfo:time:" + activityRecognitionMappingInfo2.getDetectionIntervalMillis() + "->" + activityRecognitionMappingInfo.getDetectionIntervalMillis());
                activityRecognitionMappingInfo2.setDetectionIntervalMillis(activityRecognitionMappingInfo.getDetectionIntervalMillis());
                activityRecognitionMappingInfo2.setClientInfo(activityRecognitionMappingInfo.getClientInfo());
                return true;
            }
        }
        return false;
    }

    public void addActivityUpdatesMappingInfo(long j, ARCallback aRCallback, ClientInfo clientInfo) {
        LogLocation.i(TAG, "addActivityUpdatesMappingInfo enter, detectionIntervalMillis:" + j + ", callback:" + aRCallback);
        ActivityRecognitionMappingInfo activityRecognitionMappingInfo = new ActivityRecognitionMappingInfo();
        activityRecognitionMappingInfo.setCallback(aRCallback);
        activityRecognitionMappingInfo.setClientInfo(clientInfo);
        activityRecognitionMappingInfo.setDetectionIntervalMillis(j);
        if (this.activityRecognitionMappingInfoList.isEmpty() || !isUpdate(activityRecognitionMappingInfo)) {
            this.activityRecognitionMappingInfoList.add(activityRecognitionMappingInfo);
        }
        LogLocation.i(TAG, "addActivityUpdatesMappingInfo success, infos size:" + this.activityRecognitionMappingInfoList.size());
    }

    public List<ActivityRecognitionMappingInfo> getInfos() {
        return this.activityRecognitionMappingInfoList;
    }

    public long getMinTime() {
        Iterator<ActivityRecognitionMappingInfo> it = this.activityRecognitionMappingInfoList.iterator();
        long j = -1;
        while (it.hasNext()) {
            long detectionIntervalMillis = it.next().getDetectionIntervalMillis();
            if (j == -1 || detectionIntervalMillis < j) {
                j = detectionIntervalMillis;
            }
        }
        LogLocation.i(TAG, "getMinTime ,minTime is " + j);
        return j;
    }

    public boolean isEmptyRequest() {
        List<ActivityRecognitionMappingInfo> list = this.activityRecognitionMappingInfoList;
        return list == null || list.isEmpty();
    }

    public void removeActivityUpdatesMappingInfo(ARCallback aRCallback) {
        LogLocation.i(TAG, "removeActivityUpdatesMappingInfo enter, callback:" + aRCallback, true);
        if (aRCallback == null) {
            LogLocation.e(TAG, "callback is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ActivityRecognitionMappingInfo activityRecognitionMappingInfo : this.activityRecognitionMappingInfoList) {
            if (activityRecognitionMappingInfo.getCallback().equals(aRCallback)) {
                arrayList.add(activityRecognitionMappingInfo);
            }
        }
        this.activityRecognitionMappingInfoList.removeAll(arrayList);
        LogLocation.i(TAG, "removeActivityUpdatesMappingInfo success,  infos size:" + this.activityRecognitionMappingInfoList.size(), true);
    }

    public List<ActivityRecognitionMappingInfo> removeActivityUpdatesMappingInfoByPackageName(String str) {
        LogLocation.i(TAG, "removeActivityUpdatesMappingInfoByPackageName:enter:" + str);
        ArrayList arrayList = new ArrayList();
        for (ActivityRecognitionMappingInfo activityRecognitionMappingInfo : this.activityRecognitionMappingInfoList) {
            if (activityRecognitionMappingInfo.getClientInfo().getPackageName().equals(str)) {
                arrayList.add(activityRecognitionMappingInfo);
            }
        }
        this.activityRecognitionMappingInfoList.removeAll(arrayList);
        LogLocation.i(TAG, "removeActivityUpdatesMappingInfoByPackageName:exit:" + str);
        return arrayList;
    }

    public void send(List<DetectedActivity> list) {
        LogLocation.i(TAG, "send begin");
        if (list.size() > 0) {
            ActivityRecognitionResult activityRecognitionResult = new ActivityRecognitionResult(list, System.currentTimeMillis(), SystemClock.elapsedRealtime());
            for (ActivityRecognitionMappingInfo activityRecognitionMappingInfo : this.activityRecognitionMappingInfoList) {
                LogLocation.i(TAG, "sending");
                callBackWithReport(activityRecognitionMappingInfo, activityRecognitionResult);
            }
        }
    }
}
