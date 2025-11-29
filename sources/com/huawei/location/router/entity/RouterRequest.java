package com.huawei.location.router.entity;

import android.os.Parcelable;
import com.huawei.location.router.interfaces.IRouterCallback;

/* loaded from: classes3.dex */
public class RouterRequest {
    private boolean agcFail;
    private final String apiName;
    private Parcelable parcelable;
    private final String requestJson;
    private final IRouterCallback routerCallback;
    private final String transactionId;

    public RouterRequest(String str, String str2, String str3, IRouterCallback iRouterCallback) {
        this(str, str2, str3, iRouterCallback, null);
    }

    public RouterRequest(String str, String str2, String str3, IRouterCallback iRouterCallback, Parcelable parcelable) {
        this.apiName = str;
        this.requestJson = str2;
        this.parcelable = parcelable;
        this.transactionId = str3;
        this.routerCallback = iRouterCallback;
    }

    public String getApiName() {
        return this.apiName;
    }

    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public String getRequestJson() {
        return this.requestJson;
    }

    public IRouterCallback getRouterCallback() {
        return this.routerCallback;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public boolean isAgcFail() {
        return this.agcFail;
    }

    public void setAgcFail(boolean z) {
        this.agcFail = z;
    }

    public void setParcelable(Parcelable parcelable) {
        this.parcelable = parcelable;
    }
}
