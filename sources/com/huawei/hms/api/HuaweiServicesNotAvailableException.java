package com.huawei.hms.api;

/* loaded from: classes3.dex */
public final class HuaweiServicesNotAvailableException extends Exception {
    public final int errorCode;

    public HuaweiServicesNotAvailableException(int i) {
        this.errorCode = i;
    }
}
