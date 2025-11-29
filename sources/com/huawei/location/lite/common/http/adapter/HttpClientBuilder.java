package com.huawei.location.lite.common.http.adapter;

import com.huawei.location.lite.common.report.ReportBuilder;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes3.dex */
public class HttpClientBuilder {
    HostnameVerifier hostnameVerifier;
    int pingInterval;
    Proxy proxy;
    ReportBuilder reportBuilder;
    SSLSocketFactory sslSocketFactory;
    X509TrustManager x509TrustManager;
    int connectTimeout = 10000;
    int readTimeout = 10000;
    int writeTimeout = 10000;
    boolean isNeedCheckTssAuth = true;
    boolean isNeedCheckUcsAuth = true;
    boolean isNeedInterceptor = true;
    boolean isNeedCheckAGC = true;
    List<InterceptorAdapter> interceptors = new ArrayList(4);
    List<InterceptorAdapter> networkInterceptors = new ArrayList(4);

    public HttpClientBuilder setNeedCheckAGC(boolean z) {
        this.isNeedCheckAGC = z;
        return this;
    }

    public HttpClientBuilder setNeedCheckUcsAuth(boolean z) {
        this.isNeedCheckUcsAuth = z;
        return this;
    }

    public HttpClientBuilder setNeedInterceptor(boolean z) {
        this.isNeedInterceptor = z;
        return this;
    }
}
