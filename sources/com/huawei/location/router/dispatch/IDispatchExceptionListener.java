package com.huawei.location.router.dispatch;

/* loaded from: classes3.dex */
public interface IDispatchExceptionListener {
    public static final int API_NOT_EXIST = 10001;
    public static final int API_TASK_EMPTY = 10002;
    public static final int OTHER_ERROR = 10003;

    void onDispatchError(int i, String str);
}
