package com.huawei.location.lite.common.http.exception;

/* loaded from: classes3.dex */
public abstract class BaseException extends Throwable {
    protected ErrorCode errorCode;

    public BaseException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}
