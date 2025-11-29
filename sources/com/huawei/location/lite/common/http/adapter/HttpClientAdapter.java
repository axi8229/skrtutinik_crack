package com.huawei.location.lite.common.http.adapter;

import android.content.Context;
import com.huawei.location.lite.common.report.ReportBuilder;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes3.dex */
public abstract class HttpClientAdapter implements IHttpClient {
    protected static final int MAX_CONNECT_SIZE = Runtime.getRuntime().availableProcessors();
    protected int connectTimeout;
    protected Context context;
    protected HostnameVerifier hostnameVerifier;
    protected List<InterceptorAdapter> interceptors;
    protected boolean isNeedCheckAGC;
    protected boolean isNeedCheckTssAuth;
    protected boolean isNeedCheckUcsAuth;
    protected boolean isNeedInterceptor;
    protected List<InterceptorAdapter> networkInterceptors;
    protected int pingInterval;
    protected Proxy proxy;
    protected int readTimeout;
    protected ReportBuilder reportBuilder;
    protected SSLSocketFactory sslSocketFactory;
    protected int writeTimeout;
    protected X509TrustManager x509TrustManager;

    public HttpClientAdapter(HttpClientBuilder httpClientBuilder, Context context) {
        this.context = context;
        this.connectTimeout = httpClientBuilder.connectTimeout;
        this.readTimeout = httpClientBuilder.readTimeout;
        this.pingInterval = httpClientBuilder.pingInterval;
        this.writeTimeout = httpClientBuilder.writeTimeout;
        this.sslSocketFactory = httpClientBuilder.sslSocketFactory;
        this.x509TrustManager = httpClientBuilder.x509TrustManager;
        this.hostnameVerifier = httpClientBuilder.hostnameVerifier;
        this.proxy = httpClientBuilder.proxy;
        this.isNeedInterceptor = httpClientBuilder.isNeedInterceptor;
        this.isNeedCheckAGC = httpClientBuilder.isNeedCheckAGC;
        this.isNeedCheckUcsAuth = httpClientBuilder.isNeedCheckUcsAuth;
        this.isNeedCheckTssAuth = httpClientBuilder.isNeedCheckTssAuth;
        this.reportBuilder = httpClientBuilder.reportBuilder;
        List<InterceptorAdapter> list = httpClientBuilder.interceptors;
        this.interceptors = list;
        if (list == null) {
            this.interceptors = new ArrayList(8);
        }
        this.networkInterceptors = httpClientBuilder.networkInterceptors;
    }

    protected abstract void addCustomInterceptors();

    public ReportBuilder getReportBuilder() {
        return this.reportBuilder;
    }

    @Override // com.huawei.location.lite.common.http.adapter.IHttpClient
    public void init() {
        if (this.isNeedInterceptor) {
            addCustomInterceptors();
        }
        initHttpClient();
    }

    protected abstract void initHttpClient();
}
