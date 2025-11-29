package com.huawei.location.base.activity;

import android.content.Context;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;
import com.huawei.hms.location.entity.activity.ActivityTransitionRequest;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.base.activity.permission.ARLocationPermissionManager;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class AbstractARServiceManager {
    private static final String TAG = "AbstractARServiceManager";
    protected long lastTimeByTimer = -1;
    protected Context mContext = ContextUtil.getContext();
    protected ActivityRecognitionMappingManager recognitionMappingManager;
    protected ScheduledExecutorService scheduledExecutorService;
    protected ScheduledFuture scheduledFuture;
    protected ActivityTransitionMappingManager transitionMappingManager;

    protected AbstractARServiceManager(ActivityTransitionMappingManager activityTransitionMappingManager, ActivityRecognitionMappingManager activityRecognitionMappingManager) {
        this.transitionMappingManager = activityTransitionMappingManager;
        this.recognitionMappingManager = activityRecognitionMappingManager;
    }

    protected boolean checkActivityRecognitionPermission(ClientInfo clientInfo) {
        if (clientInfo == null) {
            return false;
        }
        return ARLocationPermissionManager.checkCPActivityRecognitionPermission(TAG, clientInfo.getClientPid(), clientInfo.getClientUid());
    }

    public abstract boolean connectService();

    public abstract boolean disConnectService();

    public abstract ActivityRecognitionResult getDetectedActivity(int i, int i2);

    public ActivityRecognitionMappingManager getRecognitionRequestMapping() {
        return this.recognitionMappingManager;
    }

    protected Runnable getTask() {
        return null;
    }

    public ActivityTransitionMappingManager getTransitionMappingManager() {
        return this.transitionMappingManager;
    }

    public abstract boolean isConnected();

    public abstract void removeActivityTransitionUpdates(ATCallback aTCallback, ClientInfo clientInfo);

    public abstract void removeActivityUpdates(ARCallback aRCallback, ClientInfo clientInfo);

    public abstract void requestActivityTransitionUpdates(ActivityTransitionRequest activityTransitionRequest, ATCallback aTCallback, ClientInfo clientInfo);

    public abstract void requestActivityUpdates(long j, ARCallback aRCallback, ClientInfo clientInfo);

    protected void restartScheduled(long j) {
        stopScheduled();
        startScheduled(j);
    }

    public synchronized void scheduleTimer() {
        long minTime;
        try {
            minTime = this.recognitionMappingManager.getMinTime();
        } catch (Exception unused) {
            LogLocation.e(TAG, "scheduleTimer exception", true);
        }
        if (-1 == minTime) {
            LogLocation.i(TAG, "scheduleTimer return time is " + minTime);
            this.lastTimeByTimer = -1L;
            stopScheduled();
            return;
        }
        long j = this.lastTimeByTimer;
        if (j == -1) {
            LogLocation.i(TAG, "scheduleTimer begin time is " + minTime);
            this.lastTimeByTimer = minTime;
            startScheduled(minTime);
        } else if (minTime != j) {
            LogLocation.i(TAG, "scheduleTimer begin again time is " + minTime);
            this.lastTimeByTimer = minTime;
            restartScheduled(minTime);
        }
    }

    protected void startScheduled(long j) {
        LogLocation.i(TAG, "startScheduled enter");
        if (this.scheduledExecutorService == null) {
            this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
        }
        this.scheduledFuture = this.scheduledExecutorService.scheduleWithFixedDelay(getTask(), 0L, j, TimeUnit.MILLISECONDS);
        LogLocation.i(TAG, "startScheduled exit");
    }

    protected void stopScheduled() {
        LogLocation.i(TAG, "stopScheduled enter");
        try {
            ScheduledFuture scheduledFuture = this.scheduledFuture;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                LogLocation.i(TAG, "stopScheduled exit:" + this.scheduledFuture.cancel(true));
                return;
            }
            LogLocation.i(TAG, "scheduled not init or cancelled");
        } catch (Exception unused) {
            LogLocation.e(TAG, "stopScheduled exit exception", true);
        }
    }
}
