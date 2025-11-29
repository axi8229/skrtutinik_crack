package com.huawei.wisesecurity.kfs.exception;

import com.huawei.wisesecurity.ucs_credential.f;

/* loaded from: classes3.dex */
public class KfsException extends Exception {
    private final int errorCode;

    public KfsException(String str) {
        super(str);
        this.errorCode = 100001;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sbA = f.a("[errorCode:");
        sbA.append(this.errorCode);
        sbA.append(" message:");
        sbA.append(getMessage());
        sbA.append("]");
        return sbA.toString();
    }
}
