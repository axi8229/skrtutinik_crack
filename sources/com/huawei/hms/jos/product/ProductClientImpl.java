package com.huawei.hms.jos.product;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.jos.apps.AppApiConstants;
import com.huawei.hms.jos.apps.AppsBaseClientImpl;
import com.huawei.hms.jos.util.Utils;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ProductClientImpl extends AppsBaseClientImpl implements ProductClient {
    private boolean e;

    public ProductClientImpl(Activity activity) {
        super(activity);
        this.e = true;
    }

    public ProductClientImpl(Context context) {
        super(context);
        this.e = false;
    }

    @Override // com.huawei.hms.jos.product.ProductClient
    public Task<List<ProductOrderInfo>> getMissProductOrder(Context context) throws JSONException {
        String strReportEntry = HiAnalyticsClient.reportEntry(getContext(), AppApiConstants.GET_MISS_PRODUCT_ORDER, Utils.getSDKVersionCode(getContext()));
        ApiException apiExceptionCheckInit = checkInit();
        if (apiExceptionCheckInit != null) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(apiExceptionCheckInit);
            return taskCompletionSource.getTask();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isActivityCaller", this.e);
        } catch (JSONException unused) {
            HMSLog.e("ProductClientImpl", "add product client extra info to json failed");
        }
        return doWrite(new GetMissProductOrderTaskApiCall(AppApiConstants.GET_MISS_PRODUCT_ORDER, attachBaseRequest(jSONObject).toString(), strReportEntry));
    }
}
