package com.huawei.hms.jos;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.HuaweiApiInterface;

/* loaded from: classes3.dex */
public interface JosAppsClient extends HuaweiApiInterface {
    Task<String> getAppId();

    void init();
}
