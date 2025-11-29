package com.huawei.hms.support.api.location.common;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationServices;
import com.huawei.hms.locationSdk.j0;
import com.huawei.hms.locationSdk.k0;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.location.lite.common.android.context.ContextUtil;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public class LocationClientStateManager {
    private static final int CP_PERMISSION_DENIED = 10803;
    private static final int DELAY_MSG_CHECK_TIME = 12000;
    private static final int DELAY_TIME = 300;
    private static final int INTERNAL_ERROR = 10000;
    private static final String IS_RE_REQUEST = "isReRequest";
    private static final String LOCATIONAVAILABILITY_EXTRA_KEY = "com.huawei.hms.location.EXTRA_LOCATION_AVAILABILITY";
    private static final long MAX_INTERVAL_TIME = 300000;
    private static final int MAX_RECONNECT_COUNT = 3;
    private static final int MSG_RESTART = 1001;
    private static final int MSG_RESTART_DELAY_CHECK = 1002;
    private static final int PERMISSION_DENIED = 10102;
    private static final long REPEAT_REQUEST_INTERVAL_TIME = 500;
    public static final int RE_START_STATE_DOING = 1;
    public static final int RE_START_STATE_FAILED = 2;
    public static final int RE_START_STATE_INITIAL = 0;
    private static final String TAG = "LocationClientStateManager";
    private Handler handler;
    private volatile AtomicLong lastDisConnectTime;
    private volatile AtomicInteger reConnectCount;
    private volatile AtomicInteger resendState;

    class a implements OnFailureListener {
        final /* synthetic */ LocationCallback a;
        final /* synthetic */ PendingIntent b;

        a(LocationCallback locationCallback, PendingIntent pendingIntent) {
            this.a = locationCallback;
            this.b = pendingIntent;
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public void onFailure(Exception exc) throws PendingIntent.CanceledException {
            HMSLog.e(LocationClientStateManager.TAG, "task request onFailure");
            LocationClientStateManager.this.handler.removeMessages(1002);
            LocationClientStateManager.this.handlerOnFailureMsg(exc, this.a, this.b);
            LocationClientStateManager.getInstance().setResendState(2);
        }
    }

    class b implements OnSuccessListener<Void> {
        b() {
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r2) {
            HMSLog.i(LocationClientStateManager.TAG, "task request onSuccess");
            LocationClientStateManager.this.handler.removeMessages(1002);
            LocationClientStateManager.getInstance().setResendState(0);
        }
    }

    class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i != 1001) {
                if (i != 1002) {
                    return false;
                }
                LocationClientStateManager.this.checkReSendState();
                return false;
            }
            LocationClientStateManager.this.handler.removeMessages(1002);
            LocationClientStateManager.this.handler.sendEmptyMessageDelayed(1002, 12000L);
            LocationClientStateManager.this.reSendRequest();
            return false;
        }
    }

    private static class d {
        private static final LocationClientStateManager a = new LocationClientStateManager(null);
    }

    private LocationClientStateManager() {
        this.lastDisConnectTime = new AtomicLong(0L);
        this.reConnectCount = new AtomicInteger(0);
        this.resendState = new AtomicInteger(0);
    }

    /* synthetic */ LocationClientStateManager(a aVar) {
        this();
    }

    private void addListener(Task<Void> task, LocationCallback locationCallback, PendingIntent pendingIntent) {
        task.addOnSuccessListener(new b()).addOnFailureListener(new a(locationCallback, pendingIntent));
    }

    private boolean canResendRequest() {
        return this.resendState.get() == 2 || this.resendState.get() == 0;
    }

    private boolean checkCanResendRequest() {
        return checkReconnectStrategy() && canResendRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkReSendState() {
        if (getInstance().getResendState() == 1) {
            getInstance().setResendState(2);
            HMSLog.e(TAG, "reSend request time out ,reset state to RE_START_STATE_FAILED");
        }
    }

    private boolean checkReconnectStrategy() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.lastDisConnectTime.get() < REPEAT_REQUEST_INTERVAL_TIME) {
            HMSLog.e(TAG, "can not reconnect , not satisfied interval");
            return false;
        }
        if (this.reConnectCount.get() == 0) {
            this.lastDisConnectTime.set(jElapsedRealtime);
            this.reConnectCount.incrementAndGet();
            HMSLog.i(TAG, "first reconnect");
            return true;
        }
        if (jElapsedRealtime - this.lastDisConnectTime.get() > MAX_INTERVAL_TIME) {
            this.reConnectCount.set(1);
            this.lastDisConnectTime.set(jElapsedRealtime);
            HMSLog.i(TAG, "over MAX_INTERVAL_TIME , restart first reconnect");
            return true;
        }
        if (this.reConnectCount.get() >= 3) {
            this.lastDisConnectTime.set(jElapsedRealtime);
            HMSLog.i(TAG, "can not reconnect , cause count > MAX_RECONNECT_COUNT");
            return false;
        }
        HMSLog.i(TAG, "can reconnect");
        this.lastDisConnectTime.set(jElapsedRealtime);
        this.reConnectCount.incrementAndGet();
        return true;
    }

    public static LocationClientStateManager getInstance() {
        return d.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerOnFailureMsg(Exception exc, LocationCallback locationCallback, PendingIntent pendingIntent) throws PendingIntent.CanceledException {
        String str;
        try {
            if (exc instanceof ApiException) {
                ApiException apiException = (ApiException) exc;
                int statusCode = apiException.getStatusCode();
                if (statusCode != 10000 && statusCode != 10102 && statusCode != 10803) {
                    if (statusCode != 907135004) {
                        return;
                    }
                    HMSLog.e(TAG, "task request onFailure from HMS and checkRestart");
                    checkCanResend();
                    return;
                }
                if (locationCallback != null) {
                    LocationAvailability locationAvailability = new LocationAvailability();
                    locationAvailability.setLocationStatus(1001);
                    locationCallback.onLocationAvailability(locationAvailability);
                    HMSLog.e(TAG, "task request onFailure from Location and callback to cp ,errorCode " + apiException.getStatusCode());
                }
                if (pendingIntent == null) {
                    return;
                }
                Intent intent = new Intent();
                LocationAvailability locationAvailability2 = new LocationAvailability();
                locationAvailability2.setLocationStatus(1001);
                intent.putExtra(LOCATIONAVAILABILITY_EXTRA_KEY, locationAvailability2);
                pendingIntent.send(ContextUtil.getContext(), 0, intent);
                str = "task request onFailure from Location and pendingIntent to cp ,errorCode " + apiException.getStatusCode();
            } else {
                str = "handlerOnFailureMsg failed by instanceof failed";
            }
            HMSLog.e(TAG, str);
        } catch (Exception unused) {
            HMSLog.e(TAG, "handlerOnFailureMsg failed by exception");
        }
    }

    private void initHandler() {
        if (this.handler == null) {
            HandlerThread handlerThread = new HandlerThread(TAG);
            handlerThread.start();
            this.handler = new Handler(handlerThread.getLooper(), new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendRequest() {
        try {
            List<k0> listA = j0.b().a();
            if (CollectionsUtil.isEmpty(listA)) {
                HMSLog.i(TAG, "onConnected, requests cache list is empty remove delay check msg");
                this.handler.removeMessages(1002);
                getInstance().setResendState(0);
                return;
            }
            HMSLog.i(TAG, "request cache list size:" + listA.size());
            FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(ContextUtil.getContext());
            for (k0 k0Var : listA) {
                HMSLocationLog.i(TAG, k0Var.a(), "onConnected, request in cache list prepare to send");
                realRequest(fusedLocationProviderClient, k0Var);
            }
        } catch (Exception unused) {
            getInstance().setResendState(2);
            HMSLog.e(TAG, "onConnected exception");
        }
    }

    private void realRequest(FusedLocationProviderClient fusedLocationProviderClient, k0 k0Var) {
        Task<Void> taskRequestLocationUpdates;
        LocationCallback locationCallbackC = k0Var.c();
        LocationRequest locationRequestD = k0Var.d();
        PendingIntent pendingIntentB = k0Var.b();
        if (locationRequestD == null) {
            getInstance().setResendState(0);
            HMSLocationLog.w(TAG, k0Var.a(), "onConnected, requests cache list param is error");
            return;
        }
        locationRequestD.putExtras(IS_RE_REQUEST, "1");
        if (locationCallbackC == null) {
            if (pendingIntentB != null) {
                addListener(fusedLocationProviderClient.requestLocationUpdates(locationRequestD, pendingIntentB), null, pendingIntentB);
                return;
            } else {
                getInstance().setResendState(0);
                HMSLocationLog.w(TAG, k0Var.a(), "onConnected, requests cache list param is error");
                return;
            }
        }
        if (TextUtils.equals(k0Var.f(), "ExCallback")) {
            HMSLocationLog.i(TAG, k0Var.a(), "send ex location request");
            taskRequestLocationUpdates = fusedLocationProviderClient.requestLocationUpdatesEx(locationRequestD, locationCallbackC, k0Var.e());
        } else {
            HMSLocationLog.i(TAG, k0Var.a(), "send location request");
            taskRequestLocationUpdates = fusedLocationProviderClient.requestLocationUpdates(locationRequestD, locationCallbackC, k0Var.e());
        }
        addListener(taskRequestLocationUpdates, locationCallbackC, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResendState(int i) {
        this.resendState.set(i);
    }

    public synchronized void checkCanResend() {
        try {
            boolean zCheckCanResendRequest = getInstance().checkCanResendRequest();
            if (zCheckCanResendRequest) {
                reStartHmsLocation();
            }
            HMSLog.i(TAG, "checkCanResend:" + zCheckCanResendRequest + ",reStartHmsLocation restartState：" + getInstance().getResendState());
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int getResendState() {
        return this.resendState.get();
    }

    public synchronized void reStartHmsLocation() {
        HMSLog.i(TAG, "reStartHmsLocation restartState：" + getInstance().getResendState());
        getInstance().setResendState(1);
        initHandler();
        this.handler.sendEmptyMessageDelayed(1001, 300L);
    }

    public synchronized void resetCache() {
        if (this.reConnectCount.get() == 0 && this.lastDisConnectTime.get() == 0) {
            HMSLog.i(TAG, "not need resetCache");
            return;
        }
        HMSLog.i(TAG, "resetCache");
        this.lastDisConnectTime.set(0L);
        this.reConnectCount.set(0);
    }
}
