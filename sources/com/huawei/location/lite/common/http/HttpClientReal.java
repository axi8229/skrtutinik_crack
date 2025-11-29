package com.huawei.location.lite.common.http;

import android.annotation.SuppressLint;
import android.content.Context;
import com.huawei.location.lite.common.http.adapter.HttpClientAdapter;
import com.huawei.location.lite.common.http.adapter.HttpClientBuilder;
import com.huawei.location.lite.common.http.adapter.IHttpSDKRequestTask;
import com.huawei.location.lite.common.http.adapter.InterceptorAdapter;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.interceptor.AGCInterceptor;
import com.huawei.location.lite.common.http.interceptor.CommonInterceptor;
import com.huawei.location.lite.common.http.interceptor.UcsAuthInterceptor;
import com.huawei.location.lite.common.log.LogLocation;
import java.net.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import ru.yoomoney.sdk.auth.location.utils.UtilsKt;

@SuppressLint({"CheckResult"})
/* loaded from: classes3.dex */
public class HttpClientReal extends HttpClientAdapter {
    private static final ConnectionPool CONNECTION_POOL = new ConnectionPool(HttpClientAdapter.MAX_CONNECT_SIZE, UtilsKt.UPDATE_INTERVAL, TimeUnit.MILLISECONDS);
    private OkHttpClient httpClient;

    public HttpClientReal(HttpClientBuilder httpClientBuilder, Context context) {
        super(httpClientBuilder, context);
    }

    @Override // com.huawei.location.lite.common.http.adapter.HttpClientAdapter
    protected void addCustomInterceptors() {
        this.interceptors.add(new CommonInterceptor());
        if (this.isNeedCheckUcsAuth) {
            this.interceptors.add(new UcsAuthInterceptor());
        }
        if (this.isNeedCheckAGC) {
            this.interceptors.add(new AGCInterceptor());
        }
    }

    @Override // com.huawei.location.lite.common.http.adapter.IHttpClient
    public List<InterceptorAdapter> getInterceptors() {
        return this.interceptors;
    }

    @Override // com.huawei.location.lite.common.http.adapter.HttpClientAdapter
    protected void initHttpClient() {
        X509TrustManager x509TrustManager;
        LogLocation.d("HttpClientReal", "OkHttpClient init...");
        OkHttpClient.Builder builderProtocols = new OkHttpClient.Builder().connectionPool(CONNECTION_POOL).retryOnConnectionFailure(false).protocols(Collections.unmodifiableList(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1)));
        int i = this.pingInterval;
        if (i > 0) {
            builderProtocols.pingInterval(i, TimeUnit.MILLISECONDS);
        }
        int i2 = this.readTimeout;
        if (i2 > 0) {
            builderProtocols.readTimeout(i2, TimeUnit.MILLISECONDS);
        }
        int i3 = this.writeTimeout;
        if (i3 > 0) {
            builderProtocols.writeTimeout(i3, TimeUnit.MILLISECONDS);
        }
        int i4 = this.connectTimeout;
        if (i4 > 0) {
            builderProtocols.connectTimeout(i4, TimeUnit.MILLISECONDS);
        }
        Proxy proxy = this.proxy;
        if (proxy != null) {
            builderProtocols.proxy(proxy);
        }
        HostnameVerifier hostnameVerifier = this.hostnameVerifier;
        if (hostnameVerifier != null) {
            builderProtocols.hostnameVerifier(hostnameVerifier);
        }
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
        if (sSLSocketFactory != null && (x509TrustManager = this.x509TrustManager) != null) {
            builderProtocols.sslSocketFactory(sSLSocketFactory, x509TrustManager);
        }
        this.httpClient = builderProtocols.build();
    }

    @Override // com.huawei.location.lite.common.http.adapter.IHttpClient
    public IHttpSDKRequestTask newRequestTask() throws OnErrorException {
        return new OkRequestTask(this.httpClient);
    }
}
