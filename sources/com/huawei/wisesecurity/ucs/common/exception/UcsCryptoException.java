package com.huawei.wisesecurity.ucs.common.exception;

import com.huawei.wisesecurity.kfs.exception.CryptoException;

/* loaded from: classes3.dex */
public class UcsCryptoException extends CryptoException {
    private transient UcsErrorCode errorCode;

    public UcsCryptoException(long j, String str) {
        super(str);
        this.errorCode = new UcsErrorCode(j);
    }

    public int getErrorCode() {
        return (int) this.errorCode.getCode();
    }
}
