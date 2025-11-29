package com.huawei.location.lite.common.util.filedownload;

import android.os.Parcelable;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.chain.Data;
import com.huawei.location.lite.common.chain.Result;
import com.huawei.location.lite.common.chain.Task;
import com.huawei.location.lite.common.http.HttpClientEx;
import com.huawei.location.lite.common.http.adapter.HttpClientBuilder;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.request.HeadBuilder;
import com.huawei.location.lite.common.http.request.RequestJsonBody;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.router.dispatch.IDispatchExceptionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

/* loaded from: classes3.dex */
public class DownloadFileTask extends DownloadBaseTask {
    private IDownloadSupport iDownloadSupport;

    private void downLoadSuccessDeal(byte[] bArr) {
        DownloadFileParam downloadFileParam;
        if (bArr == null || bArr.length <= 0 || (downloadFileParam = this.downloadFileParam) == null) {
            LogLocation.e("DownloadFileTask", "responseBody is null");
        } else {
            this.taskRequest.setResult(Result.success(new Data.Builder().putAll(this.taskRequest.getOutputData()).put("download_file", saveToSd(downloadFileParam.getSaveFilePath(), this.downloadFileParam.getFileName(), bArr)).build()), this.downloadChain);
        }
    }

    private StringBuilder getRequestPath(URI uri) {
        StringBuilder sb = new StringBuilder(0);
        sb.append(uri.getPath());
        if (!TextUtils.isEmpty(uri.getQuery())) {
            sb.append("?");
            sb.append(uri.getQuery());
        }
        return sb;
    }

    private boolean isDownLoadFileVality(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !URLUtil.isHttpsUrl(str)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void requestDownLoadFileStream(DownLoadFileBean downLoadFileBean) {
        StringBuilder sb;
        String apiMsg;
        OnFailureException onFailureException;
        String version = downLoadFileBean.getFileAccessInfo().getVersion();
        String url = downLoadFileBean.getFileAccessInfo().getUrl();
        String fileSha256 = downLoadFileBean.getFileAccessInfo().getFileSha256();
        if (TextUtils.isEmpty(version) || TextUtils.isEmpty(url) || TextUtils.isEmpty(fileSha256)) {
            setNextFail(10004, "download url format error with empty data");
            return;
        }
        if (!isDownLoadFileVality(url, fileSha256)) {
            setNextFail(10004, "download url not https or sha256 error");
            return;
        }
        try {
            URI uri = new URI(url);
            if (!uriCheck(uri)) {
                setNextFail(10004, "download url format error");
                return;
            }
            StringBuilder sb2 = new StringBuilder(0);
            sb2.append(uri.getScheme());
            sb2.append("://");
            sb2.append(uri.getHost());
            StringBuilder requestPath = getRequestPath(uri);
            BaseRequest.Builder method = new BaseRequest.Builder(requestPath.toString()).setHeads(new HeadBuilder(UUID.randomUUID().toString())).setBody(new RequestJsonBody.Builder().build()).setBaseUrl(sb2.toString()).setMethod("GET");
            try {
                downLoadSuccessDeal(new HttpClientEx(ContextUtil.getHMSContext(), new HttpClientBuilder().setNeedInterceptor(false)).newSubmit(method.build()).executeOriginal());
            } catch (OnErrorException e) {
                sb = new StringBuilder();
                sb.append("apiErrorCode====");
                sb.append(e.getApiCode());
                sb.append("apiErrorMsg=====");
                apiMsg = e.getApiMsg();
                onFailureException = e;
                sb.append(apiMsg);
                LogLocation.e("DownloadFileTask", sb.toString());
                setNextFail(onFailureException.getErrorCode().code, onFailureException.getErrorCode().msg);
            } catch (OnFailureException e2) {
                sb = new StringBuilder();
                sb.append("errorCode====");
                sb.append(e2.getErrorCode().code);
                sb.append("errorMsg=====");
                apiMsg = e2.getErrorCode().msg;
                onFailureException = e2;
                sb.append(apiMsg);
                LogLocation.e("DownloadFileTask", sb.toString());
                setNextFail(onFailureException.getErrorCode().code, onFailureException.getErrorCode().msg);
            }
        } catch (URISyntaxException unused) {
            setNextFail(10004, "download url MalformedURLException");
            LogLocation.e("DownloadFileTask", "MalformedURLException");
        }
    }

    private File saveToSd(String str, String str2, byte[] bArr) throws IOException {
        File file = new File(str, str2);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                fileOutputStream.flush();
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
            LogLocation.e("DownloadFileTask", "saveToSd createSdFile stream read write exception");
        }
        return file;
    }

    private boolean uriCheck(URI uri) {
        String str;
        if (uri == null) {
            str = "uri is null";
        } else if (TextUtils.isEmpty(uri.getScheme())) {
            str = "uri scheme is undefined";
        } else if (TextUtils.isEmpty(uri.getHost())) {
            str = "uri host is undefined";
        } else {
            if (!TextUtils.isEmpty(uri.getPath())) {
                return true;
            }
            str = "uri path is undefined";
        }
        LogLocation.e("DownloadFileTask", str);
        return false;
    }

    @Override // com.huawei.location.lite.common.util.filedownload.DownloadBaseTask, com.huawei.location.lite.common.chain.Task
    public void runTask(Task.Chain chain) {
        int i;
        String str;
        super.runTask(chain);
        Parcelable parcelable = this.taskRequest.getOutputData().getParcelable("download_entity");
        if (parcelable instanceof DownLoadFileBean) {
            DownLoadFileBean downLoadFileBean = (DownLoadFileBean) parcelable;
            IDownloadSupport iDownloadSupport = this.iDownloadSupport;
            if (iDownloadSupport == null || iDownloadSupport.isSupportDownloadFile(downLoadFileBean)) {
                requestDownLoadFileStream(downLoadFileBean);
                return;
            } else {
                i = 10005;
                str = "business not need download file";
            }
        } else {
            i = IDispatchExceptionListener.OTHER_ERROR;
            str = "The data format error";
        }
        setNextFail(i, str);
    }

    public void setiDownloadSupport(IDownloadSupport iDownloadSupport) {
        this.iDownloadSupport = iDownloadSupport;
    }
}
