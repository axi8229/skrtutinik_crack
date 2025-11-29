package com.huawei.location.lite.common.report;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.location.lite.common.agc.AGCManager;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.grs.LocationNlpGrsHelper;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class Tracker {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static volatile Tracker instance;
    private LocationReportHandler reportHandler;
    private AtomicBoolean isInitialized = new AtomicBoolean(false);
    private final Map<String, LinkedHashMap> maintenanceCacheEventId = new HashMap(16, 0.85f);
    private final Map<String, LinkedHashMap> operatjionCacheEventId = new HashMap(16, 0.85f);
    private volatile boolean reportTask = false;

    private class LocationReportHandler extends Handler {
        LocationReportHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                Tracker.this.initHiAnalytics();
            } else {
                LogLocation.d("LocationTracker", "handleMessage case 1, begin to report");
                Tracker.this.onReport();
                Tracker.this.reportTask = false;
            }
        }
    }

    private Tracker() {
        HandlerThread handlerThread = new HandlerThread("Location-Full-LocationTracker");
        handlerThread.start();
        this.reportHandler = new LocationReportHandler(handlerThread.getLooper());
        LogLocation.i("LocationTracker", "LocationTracker init");
    }

    private boolean checkUninitializedAnalytics(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (this.isInitialized.get()) {
            return false;
        }
        LogLocation.d("LocationTracker", "checkUninitializedAnalytics not initialized");
        if (i == 0) {
            synchronized (this.operatjionCacheEventId) {
                try {
                    if (this.operatjionCacheEventId.size() > 100) {
                        this.operatjionCacheEventId.clear();
                        LogLocation.d("LocationTracker", "out of size clear cache");
                    }
                    this.operatjionCacheEventId.put(encodeKey(str, i), linkedHashMap);
                } finally {
                }
            }
        } else if (1 == i) {
            synchronized (this.maintenanceCacheEventId) {
                try {
                    if (this.maintenanceCacheEventId.size() > 100) {
                        this.maintenanceCacheEventId.clear();
                        LogLocation.d("LocationTracker", "out of size clear cache");
                    }
                    this.maintenanceCacheEventId.put(encodeKey(str, i), linkedHashMap);
                } finally {
                }
            }
        } else {
            LogLocation.d("LocationTracker", "onEvent type =" + i);
        }
        init();
        return true;
    }

    private String decodeKeyForEventId(String str) {
        return TextUtils.isEmpty(str) ? str : str.split("\\|")[0];
    }

    private String decodeKeyForType(String str) {
        return TextUtils.isEmpty(str) ? str : str.split("\\|")[1];
    }

    private void doReport() {
        LocationReportHandler locationReportHandler;
        if (this.reportTask || (locationReportHandler = this.reportHandler) == null) {
            return;
        }
        locationReportHandler.sendEmptyMessageDelayed(1, 3600000L);
        this.reportTask = true;
    }

    private String encodeKey(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + i + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + UUID.randomUUID().toString();
    }

    public static Tracker getInstance() {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                try {
                    if (instance == null) {
                        instance = new Tracker();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initHiAnalytics() {
        if (this.isInitialized.get()) {
            return;
        }
        String grsHostAddress = LocationNlpGrsHelper.getGrsHostAddress(GrsApp.getInstance().getIssueCountryCode(ContextUtil.getContext()), "HIANALYTICROUTE");
        LogLocation.d("LocationTracker", "hiAnalyticsUrl:" + grsHostAddress);
        if (TextUtils.isEmpty(grsHostAddress)) {
            LogLocation.i("LocationTracker", "initHiAnalytics  hiAnalyticsUrl is empty.");
            this.isInitialized.set(false);
            return;
        }
        LogLocation.i("LocationTracker", "initHiAnalytics begin.");
        HmsHiAnalyticsUtils.init(ContextUtil.getContext(), false, false, false, grsHostAddress, AGCManager.getInstance().getAppId());
        if (HmsHiAnalyticsUtils.getInitFlag()) {
            this.isInitialized.set(true);
        }
        processUnreportedData();
    }

    private void processUnreportedData() {
        processUnreportedDataUtil(this.operatjionCacheEventId);
        processUnreportedDataUtil(this.maintenanceCacheEventId);
    }

    private void processUnreportedDataUtil(Map<String, LinkedHashMap> map) {
        synchronized (map) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, LinkedHashMap> entry : map.entrySet()) {
                        if (TextUtils.isEmpty(entry.getKey())) {
                            LogLocation.e("LocationTracker", "mapEntry.getKey() == null");
                        } else {
                            onEvent(Integer.parseInt(decodeKeyForType(entry.getKey())), decodeKeyForEventId(entry.getKey()), entry.getValue());
                        }
                    }
                    map.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void init() {
        if (this.isInitialized.get()) {
            return;
        }
        this.reportHandler.sendEmptyMessage(2);
    }

    public synchronized void onEvent(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (checkUninitializedAnalytics(i, str, linkedHashMap)) {
            return;
        }
        if (!HmsHiAnalyticsUtils.getInitFlag()) {
            LogLocation.d("LocationTracker", "onEvent HA init is false");
        } else {
            LogLocation.d("LocationTracker", "analyticsInstance.onEvent");
            HmsHiAnalyticsUtils.onEvent(i, str, linkedHashMap);
        }
    }

    public void onMaintEvent(ReportBuilder reportBuilder) {
        LogLocation.i("LocationTracker", "onMaintEvent:" + reportBuilder.build().toString());
        onEvent(1, reportBuilder.getEventId(), reportBuilder.build());
        doReport();
    }

    public void onOperationEvent(ReportBuilder reportBuilder) {
        onEvent(0, reportBuilder.getEventId(), reportBuilder.build());
    }

    public void onReport() {
        if (HmsHiAnalyticsUtils.getInitFlag()) {
            LogLocation.d("LocationTracker", "analyticsInstance.onReport");
            HmsHiAnalyticsUtils.onReport();
        }
    }
}
