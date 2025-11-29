package com.huawei.hms.apptouch;

import android.content.Context;
import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import java.util.List;

/* loaded from: classes3.dex */
public interface AppTouchClient {
    Task<AppInfo> getAppInfo();

    Task<AppInfo> getAppInfoByName(String str);

    List<String> getHMSPackageName(Context context);

    Intent getResolveErrorIntent(Context context);

    boolean hasPrivacy();

    int isHMSCoreAvailable(Context context);

    Task<AppInfoSetResponse> setAppInfos(List<AppInfo> list);
}
