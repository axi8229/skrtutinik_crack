package com.huawei.location.lite.common.exception;

/* loaded from: classes3.dex */
public abstract class BaseException extends RuntimeException {
    private int exceptionCode;

    public BaseException(int i, String str) {
        super(str);
        setExceptionCode(i);
    }

    private void setExceptionCode(int i) {
        this.exceptionCode = i;
    }

    public int getExceptionCode() {
        return this.exceptionCode;
    }
}
