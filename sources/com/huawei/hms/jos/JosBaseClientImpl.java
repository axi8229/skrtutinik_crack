package com.huawei.hms.jos;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.jos.util.Utils;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class JosBaseClientImpl extends HuaweiApi<JosOptions> {
    private static AtomicBoolean b = new AtomicBoolean(false);
    private Context a;

    public JosBaseClientImpl(Activity activity, Api<JosOptions> api, JosOptions josOptions, JosClientBuilder josClientBuilder) {
        super(activity, api, josOptions, (AbstractClientBuilder) josClientBuilder);
        this.a = activity;
        setKitSdkVersion(Utils.getSDKVersionCode(activity));
    }

    public JosBaseClientImpl(Context context, Api<JosOptions> api, JosOptions josOptions, JosClientBuilder josClientBuilder) {
        super(context, api, josOptions, josClientBuilder);
        this.a = context;
        setKitSdkVersion(Utils.getSDKVersionCode(context));
    }

    protected JSONObject attachBaseRequest(JSONObject jSONObject) throws JSONException {
        try {
            jSONObject.put("cpId", Util.getCpId(this.a));
            jSONObject.put("sdkVersionName", "5.2.0.300");
        } catch (JSONException unused) {
            HMSLog.e("GamesBaseClientImpl", "base requestBody create failed. ");
        }
        return jSONObject;
    }

    protected ApiException checkAccess() {
        if (isInit()) {
            return null;
        }
        HMSLog.e("GamesBaseClientImpl", "call init method first");
        return new ApiException(new Status(7018, "call init method first"));
    }

    protected ApiException checkInit() {
        if (isInit()) {
            return null;
        }
        HMSLog.e("GamesBaseClientImpl", "call init method first");
        return new ApiException(new Status(7018, "call init method first"));
    }

    public ApiException getParamsInvalidException() {
        return new ApiException(new Status(7005, ""));
    }

    protected boolean isInit() {
        return b.get();
    }

    protected void setInit() {
        b.set(true);
    }
}
