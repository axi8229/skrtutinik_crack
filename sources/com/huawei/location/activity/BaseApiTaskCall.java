package com.huawei.location.activity;

import com.huawei.location.router.BaseRouterTaskCallImpl;
import com.huawei.location.util.yn;

/* loaded from: classes3.dex */
public abstract class BaseApiTaskCall extends BaseRouterTaskCallImpl {
    protected yn.C0098yn reportBuilder = new yn.C0098yn();
    protected int errorCode = 0;
    protected String errorReason = "";
}
