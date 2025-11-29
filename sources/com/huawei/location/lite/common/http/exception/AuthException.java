package com.huawei.location.lite.common.http.exception;

import java.io.IOException;

/* loaded from: classes3.dex */
public class AuthException extends IOException {
    private ErrorCode errorCode;

    public AuthException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}
