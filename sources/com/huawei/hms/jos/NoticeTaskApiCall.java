package com.huawei.hms.jos;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcelable;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.jos.apps.AppHmsClient;
import com.huawei.hms.jos.manager.InnerActivityManager;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes3.dex */
public class NoticeTaskApiCall extends JosBaseApiCall<AppHmsClient, Intent> {
    public NoticeTaskApiCall(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    private void a(Parcelable parcelable) throws IntentSender.SendIntentException {
        String str;
        Activity currentActivity = InnerActivityManager.get().getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing() || currentActivity.isDestroyed()) {
            HMSLog.i("NoticeTaskApiCall", "launchNoticeActivity failed, activity is invalid");
            return;
        }
        if (parcelable instanceof Intent) {
            try {
                currentActivity.startActivity((Intent) parcelable);
                return;
            } catch (Exception unused) {
                str = "Jos Notice startActivity meet exception";
            }
        } else if (parcelable instanceof PendingIntent) {
            try {
                currentActivity.startIntentSender(((PendingIntent) parcelable).getIntentSender(), null, 0, 0, 0);
                return;
            } catch (IntentSender.SendIntentException unused2) {
                str = "Jos Notice startIntentSender meet exception";
            }
        } else {
            str = "Jos Notice unKnow case ";
        }
        HMSLog.e("NoticeTaskApiCall", str);
    }

    @Override // com.huawei.hms.jos.JosBaseApiCall
    protected void doExecuteSuccess(ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Intent> taskCompletionSource) throws IntentSender.SendIntentException {
        a(responseErrorCode.getParcelable());
    }
}
