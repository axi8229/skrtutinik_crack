package com.huawei.location.lite.common.util.filedownload;

import android.text.TextUtils;
import com.huawei.hms.location.BuildConfig;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.chain.Data;
import com.huawei.location.lite.common.chain.Result;
import com.huawei.location.lite.common.chain.Task;
import com.huawei.location.lite.common.grs.LocationNlpGrsHelper;
import com.huawei.location.lite.common.http.HttpClientEx;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.request.HeadBuilder;
import com.huawei.location.lite.common.http.request.RequestJsonBody;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.UUID;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class DownloadUrlReqTask extends DownloadBaseTask {
    /* JADX WARN: Multi-variable type inference failed */
    private void requestDownloadUrl(String str, String str2) throws JSONException {
        StringBuilder sb;
        String apiMsg;
        OnFailureException onFailureException;
        try {
            DownLoadFileBean downLoadFileBean = (DownLoadFileBean) new HttpClientEx(ContextUtil.getHMSContext()).newSubmit(new BaseRequest.Builder("/location/v1/getFileDownloadUrl").setHeads(new HeadBuilder(UUID.randomUUID().toString())).setBody(new RequestJsonBody.Builder().add("serviceType", str).add("subType", str2).build()).setBaseUrl(LocationNlpGrsHelper.getGrsHostAddress(BuildConfig.LIBRARY_PACKAGE_NAME)).setMethod("POST").build()).execute(DownLoadFileBean.class);
            LogLocation.i("ReqDownloadUrlTask", "url request success url and fileVersion:" + downLoadFileBean.getFileAccessInfo().getVersion());
            setNextSuccess(downLoadFileBean);
        } catch (OnErrorException e) {
            sb = new StringBuilder();
            sb.append("apiErrorCode====");
            sb.append(e.getApiCode());
            sb.append("apiErrorMsg=====");
            apiMsg = e.getApiMsg();
            onFailureException = e;
            sb.append(apiMsg);
            LogLocation.e("ReqDownloadUrlTask", sb.toString());
            setNextFail(onFailureException.getErrorCode().code, onFailureException.getErrorCode().msg);
        } catch (OnFailureException e2) {
            sb = new StringBuilder();
            sb.append("errorCode====");
            sb.append(e2.getErrorCode().code);
            sb.append("errorMsg=====");
            apiMsg = e2.getErrorCode().msg;
            onFailureException = e2;
            sb.append(apiMsg);
            LogLocation.e("ReqDownloadUrlTask", sb.toString());
            setNextFail(onFailureException.getErrorCode().code, onFailureException.getErrorCode().msg);
        }
    }

    private void setNextSuccess(DownLoadFileBean downLoadFileBean) {
        this.taskRequest.setResult(Result.success(new Data.Builder().putAll(this.taskRequest.getOutputData()).putParcelable("download_entity", downLoadFileBean).build()), this.downloadChain);
    }

    @Override // com.huawei.location.lite.common.util.filedownload.DownloadBaseTask, com.huawei.location.lite.common.chain.Task
    public void runTask(Task.Chain chain) throws JSONException {
        super.runTask(chain);
        DownloadFileParam downloadFileParam = this.downloadFileParam;
        if (downloadFileParam == null) {
            setNextFail(10000, "param error");
            return;
        }
        String serviceType = downloadFileParam.getServiceType();
        String subType = this.downloadFileParam.getSubType();
        if (TextUtils.isEmpty(serviceType) || TextUtils.isEmpty(subType)) {
            setNextFail(10000, "param error");
        } else {
            requestDownloadUrl(serviceType, subType);
        }
    }
}
