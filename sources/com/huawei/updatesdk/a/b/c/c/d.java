package com.huawei.updatesdk.a.b.c.c;

/* loaded from: classes3.dex */
public class d extends b {
    public static final int ERROR = 1;
    public static final int NETWORK_ERROR = 3;
    public static final int OK = 0;
    public static final int PROGUARD_ERROR = 6;
    public static final int REQ_PARAM_ERROR = 5;
    public static final int RTN_CODE_OK = 0;
    public static final int TIMEOUT = 2;
    private String reason;
    private int responseCode = 1;
    private int rtnCode_ = 0;
    private a errCause = a.NORMAL;
    private int httpRespondeCode = 0;

    public enum a {
        NORMAL,
        NO_NETWORK,
        JSON_ERROR,
        PARAM_ERROR,
        IO_EXCEPTION,
        CONNECT_EXCEPTION,
        UNKNOWN_EXCEPTION,
        NO_PROGUARD
    }

    public a a() {
        return this.errCause;
    }

    public void a(int i) {
        this.httpRespondeCode = i;
    }

    public void a(a aVar) {
        this.errCause = aVar;
    }

    public void a(String str) {
        this.reason = str;
    }

    public int b() {
        return this.httpRespondeCode;
    }

    public void b(int i) {
        this.responseCode = i;
    }

    public String c() {
        return this.reason;
    }

    public int d() {
        return this.responseCode;
    }

    public int e() {
        return this.rtnCode_;
    }

    public boolean f() {
        return d() == 0 && e() == 0;
    }

    public String toString() {
        return " { \n\tresponseCode: " + d() + "\n\trtnCode_: " + e() + "\n\terrCause: " + a() + "\n}";
    }
}
