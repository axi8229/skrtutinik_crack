package com.huawei.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesResponse;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.req.BackgroundReq;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.huawei.location.service.BackGroundService;

/* loaded from: classes3.dex */
public class EnableGroundTaskCall extends BaseApiRequest {
    private static final String TAG = "EnableGroundTaskCall";

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
        LogLocation.i(TAG, "onRequest EnableGroundTaskCall");
        BackgroundReq backgroundReq = new BackgroundReq();
        com.huawei.location.utils.yn.yn(str, backgroundReq);
        Context context = ContextUtil.getContext();
        Notification notification = (Notification) getParcelable();
        Intent intent = new Intent(context, (Class<?>) BackGroundService.class);
        intent.putExtra("notificationId", backgroundReq.getNotificationId());
        intent.putExtra(RemoteMessageConst.NOTIFICATION, notification);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
        onComplete(new RouterResponse(GsonUtil.getInstance().toJson(new RequestLocationUpdatesResponse()), new StatusInfo(0, 0, "SUCCESS")));
    }
}
