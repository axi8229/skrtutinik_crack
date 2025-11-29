package com.huawei.location.lite.common.http.interceptor;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.location.lite.common.agc.AGCManager;
import com.huawei.location.lite.common.http.request.BaseRequest;

/* loaded from: classes3.dex */
public class CommonInterceptor extends BaseCommonInterceptor {
    @Override // com.huawei.location.lite.common.http.interceptor.BaseCommonInterceptor
    public void addCustomHeads(BaseRequest.Builder builder) {
        addHead(builder, HiAnalyticsConstant.HaKey.BI_KEY_APPID, AGCManager.getInstance().getAppId());
        builder.removeHeader("User-Agent");
        addHead(builder, "User-Agent", BaseCommonInterceptor.getUserAgent());
    }

    @Override // com.huawei.location.lite.common.http.interceptor.BaseCommonInterceptor
    public void addCustomQuery(BaseRequest.Builder builder) {
        builder.addQuery("clientLiteSDKVersion", String.valueOf(212000300));
    }
}
