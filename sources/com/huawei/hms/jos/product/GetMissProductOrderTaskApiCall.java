package com.huawei.hms.jos.product;

import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.jos.JosBaseApiCall;
import com.huawei.hms.jos.JosConstant;
import com.huawei.hms.jos.apps.AppHmsClient;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class GetMissProductOrderTaskApiCall extends JosBaseApiCall<AppHmsClient, List<ProductOrderInfo>> {
    GetMissProductOrderTaskApiCall(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    private List<ProductOrderInfo> a(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            if (jSONArray.length() <= 0) {
                return null;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(new ProductOrderInfo(jSONArray.getString(i)));
            }
            return arrayList;
        } catch (JSONException unused) {
            HMSLog.e("GetMissProductOrderTask", "parsePlayer from json meet excveption");
            return null;
        }
    }

    @Override // com.huawei.hms.jos.JosBaseApiCall
    protected void doExecuteSuccess(ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<List<ProductOrderInfo>> taskCompletionSource) {
        taskCompletionSource.setResult(!TextUtils.isEmpty(str) ? a(str) : null);
    }

    @Override // com.huawei.hms.jos.JosBaseApiCall, com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return JosConstant.APP_HMS_VERSION_3_0_3;
    }
}
