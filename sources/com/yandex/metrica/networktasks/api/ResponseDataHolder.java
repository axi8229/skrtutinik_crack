package com.yandex.metrica.networktasks.api;

import java.util.Map;

/* loaded from: classes3.dex */
public class ResponseDataHolder {
    private int a;
    private byte[] b;
    private Map c;
    private final ResponseValidityChecker d;

    public ResponseDataHolder(ResponseValidityChecker responseValidityChecker) {
        this.d = responseValidityChecker;
    }

    public int getResponseCode() {
        return this.a;
    }

    public byte[] getResponseData() {
        return this.b;
    }

    public Map getResponseHeaders() {
        return this.c;
    }

    public boolean isValidResponse() {
        return this.d.isResponseValid(this.a);
    }

    public void setResponseCode(int i) {
        this.a = i;
    }

    public void setResponseData(byte[] bArr) {
        this.b = bArr;
    }

    public void setResponseHeaders(Map map) {
        this.c = map;
    }
}
