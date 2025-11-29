package com.huawei.location.lite.common.http;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.plug.PluginManager;
import com.huawei.location.lite.common.plug.PluginReqMessage;
import com.huawei.location.lite.common.report.ReportBuilder;
import com.huawei.location.lite.common.report.Tracker;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.SDKComponentType;
import com.huawei.location.lite.common.util.StringUtil;

/* loaded from: classes3.dex */
public class HttpReportHelper {
    private ReportBuilder reportBuilder;

    public HttpReportHelper(ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
        initReport();
    }

    private void addExt(BaseRequest baseRequest, String str) {
        if (!TextUtils.equals(baseRequest.getPath(), "/networklocation/v1/onlineLocation") || TextUtils.equals(str, String.valueOf(200))) {
            return;
        }
        String str2 = baseRequest.getHeads().get("X-CP-Info");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.reportBuilder.setExtParam("X-CP-Info", str2);
    }

    private void initReport() {
        if (this.reportBuilder == null) {
            this.reportBuilder = new ReportBuilder();
        }
        this.reportBuilder.setCallTime();
    }

    private String url2Dr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "UNKNOWN";
        }
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("-drcn", "DR1");
        arrayMap.put("locationtest.", "DR1");
        arrayMap.put("-dra", "DR2");
        arrayMap.put("locationtestSingapore.", "DR2");
        arrayMap.put("-dre", "DR3");
        arrayMap.put("locationtestEurope.", "DR3");
        arrayMap.put("-drru", "DR4");
        arrayMap.put("locationtestRussia.", "DR4");
        for (String str2 : arrayMap.keySet()) {
            if (str.contains(str2)) {
                return (String) arrayMap.get(str2);
            }
        }
        return "UNKNOWN";
    }

    public void reportHttpResult(BaseRequest baseRequest, String str, String str2) {
        ReportBuilder reportBuilder;
        if (baseRequest == null) {
            LogLocation.e("HttpReportHelper", "request param exception");
            return;
        }
        if (TextUtils.equals("0", baseRequest.getHeads().get("NeedReport"))) {
            LogLocation.w("HttpReportHelper", "this request not need report");
            return;
        }
        if (this.reportBuilder == null) {
            this.reportBuilder = new ReportBuilder();
        }
        this.reportBuilder.setApiName("Location_serverApi");
        this.reportBuilder.setTransactionID(baseRequest.getHeads().get("X-Request-ID"));
        String path = baseRequest.getPath();
        if (path.length() > 60) {
            reportBuilder = this.reportBuilder;
            path = path.substring(0, 60);
        } else {
            reportBuilder = this.reportBuilder;
        }
        reportBuilder.setRequestUrl(path);
        if (!StringUtil.isEmpty(str)) {
            this.reportBuilder.setErrorCode(str);
        }
        if (!StringUtil.isEmpty(str2)) {
            this.reportBuilder.setErrorMessage(str2);
        }
        if (!TextUtils.equals(str, String.valueOf(200)) && TextUtils.isEmpty(this.reportBuilder.getMcc())) {
            this.reportBuilder.setMCC(url2Dr(baseRequest.getBaseUrl()));
        }
        addExt(baseRequest, str);
        this.reportBuilder.setCostTime();
        try {
            if (SDKComponentType.getComponentType() == 100) {
                Tracker.getInstance().onMaintEvent(this.reportBuilder);
                Tracker.getInstance().onOperationEvent(this.reportBuilder);
            } else {
                PluginReqMessage pluginReqMessage = new PluginReqMessage();
                pluginReqMessage.setData(GsonUtil.getInstance().toJson(this.reportBuilder));
                Bundle bundle = new Bundle();
                bundle.putString("report_type", "server_report");
                pluginReqMessage.setExtraData(bundle);
                PluginManager.getInstance().startFunction(102, "report", pluginReqMessage, null);
            }
        } catch (Exception unused) {
            LogLocation.e("HttpReportHelper", "reportHttpResult exception");
        }
    }

    public void setHttpSDKCostTime(long j) {
        this.reportBuilder.setExtParam("httpSdkCostTime", j + "");
    }
}
