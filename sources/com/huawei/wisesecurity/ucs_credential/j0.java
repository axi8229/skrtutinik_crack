package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.hms.network.NetworkKit;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.restclient.RestClient;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkRequest;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
public class j0 implements NetworkCapability {
    public k0 a;
    public Context b;

    public j0(Context context) {
        this.b = context;
    }

    public final String a(Response<String> response) {
        if (response.isSuccessful()) {
            return (String) response.getBody();
        }
        try {
            return new String(response.getErrorBody().bytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            StringBuilder sbA = f.a("getErrorBody fail : ");
            sbA.append(e.getMessage());
            LogUcs.e("RemoteRestClient", sbA.toString(), new Object[0]);
            return "";
        }
    }

    @Override // com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability
    public NetworkResponse get(NetworkRequest networkRequest) throws IOException {
        NetworkResponse networkResponse = new NetworkResponse();
        Response<String> responseExecute = this.a.a(networkRequest.getUrl(), networkRequest.getHeaders()).execute();
        networkResponse.setCode(responseExecute.getCode());
        networkResponse.setHeaders(responseExecute.getHeaders());
        networkResponse.setBody(a(responseExecute));
        return networkResponse;
    }

    @Override // com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability
    public void initConfig(int i, int i2) throws UcsException {
        try {
            NetworkKit.init(this.b, new i0(this));
            this.a = (k0) new RestClient.Builder().httpClient(new HttpClient.Builder().connectTimeout(i).callTimeout(i).retryTimeOnConnectionFailure(i2).build()).build().create(k0.class);
        } catch (Exception e) {
            String strA = e.a(e, f.a("RemoteRestClient init failed, "));
            throw h.a("RemoteRestClient", strA, new Object[0], 2001L, strA);
        }
    }

    @Override // com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability
    public NetworkResponse post(NetworkRequest networkRequest) throws IOException {
        NetworkResponse networkResponse = new NetworkResponse();
        Response<String> responseExecute = this.a.a(networkRequest.getUrl(), networkRequest.getHeaders(), networkRequest.getBody()).execute();
        networkResponse.setCode(responseExecute.getCode());
        networkResponse.setHeaders(responseExecute.getHeaders());
        networkResponse.setBody(a(responseExecute));
        return networkResponse;
    }
}
