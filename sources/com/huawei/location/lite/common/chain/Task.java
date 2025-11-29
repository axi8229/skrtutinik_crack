package com.huawei.location.lite.common.chain;

/* loaded from: classes3.dex */
public interface Task {

    public interface Chain {
        TaskRequest getRequest();

        int proceed();

        Result runTask(boolean z);
    }

    void runTask(Chain chain);
}
