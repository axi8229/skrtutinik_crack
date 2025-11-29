package com.huawei.location.lite.common.http;

import android.text.TextUtils;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.lite.common.http.adapter.HttpClientAdapter;
import com.huawei.location.lite.common.http.adapter.IHttpClient;
import com.huawei.location.lite.common.http.adapter.ISubmitAdapter;
import com.huawei.location.lite.common.http.adapter.InterceptorAdapter;
import com.huawei.location.lite.common.http.adapter.RealInterceptorChain;
import com.huawei.location.lite.common.http.adapter.ResponseAdapter;
import com.huawei.location.lite.common.http.exception.AuthException;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.interceptor.CallHttpSDKInterceptor;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.response.BaseResponse;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.GsonUtil;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
public class SubmitEx implements ISubmitAdapter {
    private final IHttpClient httpClient;
    private HttpReportHelper httpReportHelper;
    private final BaseRequest request;

    private class TempResponse extends BaseResponse {
        private TempResponse() {
        }

        @Override // com.huawei.location.lite.common.http.response.BaseResponse
        public String getApiCode() {
            return this.code;
        }

        @Override // com.huawei.location.lite.common.http.response.BaseResponse
        public boolean isSuccess() {
            return TextUtils.isEmpty(this.code) || "0".equals(this.code);
        }
    }

    public SubmitEx(BaseRequest baseRequest, IHttpClient iHttpClient) {
        this.httpClient = iHttpClient;
        this.request = baseRequest;
        this.httpReportHelper = new HttpReportHelper(iHttpClient instanceof HttpClientAdapter ? ((HttpClientAdapter) iHttpClient).getReportBuilder() : null);
    }

    private String innerExecute() throws OnErrorException, OnFailureException {
        return new String(getResponseWithInterceptorChain().getBody().bytes(), StandardCharsets.UTF_8);
    }

    @Override // com.huawei.location.lite.common.http.adapter.ISubmitAdapter
    public <T extends BaseResponse> T execute(Class<T> cls) throws OnErrorException, OnFailureException {
        return (T) getEntity(innerExecute(), cls);
    }

    @Override // com.huawei.location.lite.common.http.adapter.ISubmitAdapter
    public byte[] executeOriginal() throws OnErrorException, OnFailureException {
        byte[] bArrBytes = getResponseWithInterceptorChain().getBody().bytes();
        if (bArrBytes != null && bArrBytes.length > 0) {
            this.httpReportHelper.reportHttpResult(this.request, String.valueOf(200), ErrorCode.valueOfKey(200));
        }
        return bArrBytes;
    }

    public <T extends BaseResponse> T getEntity(String str, Class<T> cls) throws OnErrorException, OnFailureException {
        try {
            T t = (T) GsonUtil.getInstance().fromJson(str, (Class) cls);
            if (t == null) {
                LogLocation.e("SubmitEx", "param exception");
                this.httpReportHelper.reportHttpResult(this.request, String.valueOf(10304), ErrorCode.valueOfKey(10304));
                throw new OnFailureException(ErrorCode.valueOf(10304));
            }
            if (t.isSuccess()) {
                this.httpReportHelper.reportHttpResult(this.request, String.valueOf(200), ErrorCode.valueOfKey(200));
                return t;
            }
            this.httpReportHelper.reportHttpResult(this.request, t.getApiCode(), t.getMsg());
            throw new OnErrorException(t.getApiCode(), t.getMsg());
        } catch (Exception unused) {
            LogLocation.e("SubmitEx", "getEntity exception body is :" + str);
            this.httpReportHelper.reportHttpResult(this.request, String.valueOf(10304), ErrorCode.valueOfKey(10304));
            throw new OnFailureException(ErrorCode.valueOf(10304));
        }
    }

    public ResponseAdapter getResponseWithInterceptorChain() throws OnErrorException, OnFailureException {
        ErrorCode errorCode;
        LogLocation.i("SubmitEx", "fetch info from server by network start...");
        ErrorCode errorCode2 = null;
        try {
            try {
                InterceptorAdapter urlPathExInterceptor = HttpInterceptorEx.getUrlPathExInterceptor(this.request.getPath());
                if (urlPathExInterceptor != null) {
                    this.httpClient.getInterceptors().add(urlPathExInterceptor);
                }
                this.httpClient.getInterceptors().add(new CallHttpSDKInterceptor());
                IHttpClient iHttpClient = this.httpClient;
                ResponseAdapter responseAdapterProceed = new RealInterceptorChain(iHttpClient, this.request, iHttpClient.getInterceptors(), 0, this.httpClient.newRequestTask()).proceed(this.request);
                if (responseAdapterProceed == null || responseAdapterProceed.getBody() == null) {
                    throw new OnFailureException(ErrorCode.valueOf(10307));
                }
                long sDKCostTime = responseAdapterProceed.getSDKCostTime();
                if (!responseAdapterProceed.isSuccessful()) {
                    throw new OnFailureException(ErrorCode.valueOf(responseAdapterProceed.getCode()));
                }
                LogLocation.i("SubmitEx", "fetch info from server by network end...");
                this.httpReportHelper.setHttpSDKCostTime(sDKCostTime);
                return responseAdapterProceed;
            } catch (OnErrorException e) {
                e = e;
                e.getErrorCode();
                throw e;
            } catch (OnFailureException e2) {
                e = e2;
                e.getErrorCode();
                throw e;
            } catch (IOException e3) {
                if (e3 instanceof AuthException) {
                    errorCode = ((AuthException) e3).getErrorCode();
                } else {
                    errorCode = new ErrorCode(ActivityErrorCode.ENABLE_CONVERSION_EVENT_FAILED, ErrorCode.valueOfKey(ActivityErrorCode.ENABLE_CONVERSION_EVENT_FAILED) + ":" + e3.getClass().getSimpleName());
                }
                throw new OnFailureException(errorCode);
            }
        } catch (Throwable th) {
            LogLocation.i("SubmitEx", "fetch info from server by network end...");
            this.httpReportHelper.setHttpSDKCostTime(-1L);
            if (0 != 0) {
                this.httpReportHelper.reportHttpResult(this.request, String.valueOf(errorCode2.code), String.valueOf(errorCode2.msg));
            }
            throw th;
        }
    }
}
