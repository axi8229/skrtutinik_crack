package com.huawei.wisesecurity.kfs.ha.message;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
public abstract class BaseReportMsgBuilder implements ReportMsgBuilder {
    private long nanoCallTime;
    private long segmentationStartTime;
    private int segCount = 6;
    public LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();

    @Override // com.huawei.wisesecurity.kfs.ha.message.ReportMsgBuilder
    public LinkedHashMap<String, String> build() {
        return this.linkedHashMap;
    }

    public BaseReportMsgBuilder setApiName(String str) {
        this.linkedHashMap.put("apiName", str);
        return this;
    }

    public BaseReportMsgBuilder setAppId(String str) {
        this.linkedHashMap.put("appId", str);
        return this;
    }

    public BaseReportMsgBuilder setCallTime() {
        long jNanoTime = System.nanoTime();
        this.nanoCallTime = jNanoTime;
        this.segmentationStartTime = jNanoTime;
        this.linkedHashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
        return this;
    }

    public BaseReportMsgBuilder setCostTime() {
        this.linkedHashMap.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf((System.nanoTime() - this.nanoCallTime) / 1000000));
        return this;
    }

    public BaseReportMsgBuilder setErrorMsg(String str) {
        this.linkedHashMap.put("errorMsg", str);
        return this;
    }

    public BaseReportMsgBuilder setPackageName(String str) {
        this.linkedHashMap.put("packageName", str);
        return this;
    }

    public BaseReportMsgBuilder setStatusCode(int i) {
        this.linkedHashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(i));
        return this;
    }

    public BaseReportMsgBuilder setTransId(String str) {
        this.linkedHashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, str);
        return this;
    }

    public BaseReportMsgBuilder setVersion(String str) {
        this.linkedHashMap.put("version", str);
        return this;
    }
}
