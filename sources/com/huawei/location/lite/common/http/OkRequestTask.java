package com.huawei.location.lite.common.http;

import com.huawei.location.lite.common.http.adapter.IHttpSDKRequestTask;
import com.huawei.location.lite.common.http.adapter.ResponseAdapter;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.parse.ParseHttpUtils;
import com.huawei.location.lite.common.http.request.BaseRequest;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes3.dex */
public class OkRequestTask implements IHttpSDKRequestTask {
    private BaseRequest baseRequest;
    private final OkHttpClient httpClient;

    public OkRequestTask(OkHttpClient okHttpClient) {
        this.httpClient = okHttpClient;
    }

    @Override // com.huawei.location.lite.common.http.adapter.IHttpSDKRequestTask
    public ResponseAdapter execute(BaseRequest baseRequest) throws OnErrorException, OnFailureException, IOException {
        this.baseRequest = baseRequest;
        Response responseExecute = this.httpClient.newCall(ParseHttpUtils.parseRequest(baseRequest, new Request.Builder())).execute();
        if (responseExecute.body() != null) {
            return ParseHttpUtils.parseResponseAdapter(responseExecute);
        }
        throw new OnFailureException(ErrorCode.valueOf(10307));
    }
}
