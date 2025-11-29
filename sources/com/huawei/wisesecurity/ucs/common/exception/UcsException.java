package com.huawei.wisesecurity.ucs.common.exception;

/* loaded from: classes3.dex */
public class UcsException extends Exception {
    private transient UcsErrorCode errorCode;

    public UcsException(long j, String str) {
        super(str);
        this.errorCode = new UcsErrorCode(j);
    }

    public long getErrorCode() {
        return this.errorCode.getCode();
    }
}
