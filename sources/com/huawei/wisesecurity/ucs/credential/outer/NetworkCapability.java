package com.huawei.wisesecurity.ucs.credential.outer;

import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import java.io.IOException;

/* loaded from: classes3.dex */
public interface NetworkCapability {
    NetworkResponse get(NetworkRequest networkRequest) throws IOException;

    void initConfig(int i, int i2) throws UcsException;

    NetworkResponse post(NetworkRequest networkRequest) throws IOException;
}
