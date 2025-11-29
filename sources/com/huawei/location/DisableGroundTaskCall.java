package com.huawei.location;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesResponse;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.huawei.location.service.BackGroundService;

/* loaded from: classes3.dex */
public class DisableGroundTaskCall extends BaseApiRequest {
    private static final String TAG = "DisableGroundTaskCall";

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
        LogLocation.i(TAG, "onRequest DisableGroundTaskCall");
        Context context = ContextUtil.getContext();
        context.stopService(new Intent(context, (Class<?>) BackGroundService.class));
        onComplete(new RouterResponse(GsonUtil.getInstance().toJson(new RequestLocationUpdatesResponse()), new StatusInfo(0, 0, "SUCCESS")));
    }
}
