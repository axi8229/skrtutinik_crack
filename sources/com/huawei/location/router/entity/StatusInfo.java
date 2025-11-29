package com.huawei.location.router.entity;

/* loaded from: classes3.dex */
public class StatusInfo {
    private final int errorCode;
    private final String errorMessage;
    private final int statusCode;

    public StatusInfo(int i, int i2, String str) {
        this.statusCode = i;
        this.errorCode = i2;
        this.errorMessage = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
