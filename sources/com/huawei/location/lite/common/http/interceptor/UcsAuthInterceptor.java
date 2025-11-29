package com.huawei.location.lite.common.http.interceptor;

import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.http.adapter.InterceptorAdapter;
import com.huawei.location.lite.common.http.adapter.ResponseAdapter;
import com.huawei.location.lite.common.http.exception.AuthException;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.sign.SignRequest;
import com.huawei.location.lite.common.http.sign.ucs.UCSSignHelper;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.wisesecurity.ucs.common.exception.UcsCryptoException;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import java.io.IOException;

/* loaded from: classes3.dex */
public class UcsAuthInterceptor extends BaseAuthInterceptor {
    private int requestTimes = 0;

    private boolean reTrySign(long j) {
        if (j != 1020) {
            return false;
        }
        int i = this.requestTimes + 1;
        this.requestTimes = i;
        if (i > 3) {
            return false;
        }
        UCSSignHelper.getInstance().reApplyCredential();
        return true;
    }

    @Override // com.huawei.location.lite.common.http.adapter.InterceptorAdapter
    public ResponseAdapter intercept(InterceptorAdapter.Chain chain) throws OnErrorException, OnFailureException, IOException {
        return chain.proceed(auth(chain.request()));
    }

    @Override // com.huawei.location.lite.common.http.interceptor.BaseAuthInterceptor
    public BaseRequest sign(BaseRequest baseRequest, SignRequest signRequest) throws IOException {
        try {
            String strSign = UCSSignHelper.getInstance().sign(ContextUtil.getContext(), signRequest);
            LogLocation.d("UcsAuthInterceptor", "X_REQUEST_ID:" + baseRequest.getHeads().get("X-Request-ID"));
            LogLocation.d("UcsAuthInterceptor", "auth:" + strSign);
            return baseRequest.newBuilder().addHeader("authorization", strSign).build();
        } catch (UcsCryptoException e) {
            LogLocation.e("UcsAuthInterceptor", "UcsCryptoException:" + e.getMessage());
            if (reTrySign(e.getErrorCode())) {
                return sign(baseRequest, signRequest);
            }
            LogLocation.e("UcsAuthInterceptor", "AuthException:10550");
            throw new AuthException(ErrorCode.valueOf(10550));
        } catch (UcsException e2) {
            LogLocation.e("UcsAuthInterceptor", "UcsException:errorCode:" + e2.getErrorCode() + ",message:" + e2.getMessage());
            if (reTrySign(e2.getErrorCode())) {
                return sign(baseRequest, signRequest);
            }
            LogLocation.e("UcsAuthInterceptor", "AuthException:10550");
            throw new AuthException(ErrorCode.valueOf(10550));
        }
    }
}
