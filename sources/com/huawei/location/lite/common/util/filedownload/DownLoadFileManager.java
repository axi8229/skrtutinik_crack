package com.huawei.location.lite.common.util.filedownload;

import android.os.Parcelable;
import com.huawei.location.lite.common.chain.Data;
import com.huawei.location.lite.common.chain.TaskClient;
import com.huawei.location.lite.common.chain.TaskFinishCallBack;
import com.huawei.location.lite.common.chain.TaskRequest;
import com.huawei.location.lite.common.chain.TaskTimeOutException;
import com.huawei.location.lite.common.log.LogLocation;
import java.io.File;

/* loaded from: classes3.dex */
public class DownLoadFileManager implements TaskFinishCallBack {
    private DownloadFileParam downloadFileParam;
    private IDownloadResult iDownloadResult;
    private IDownloadSupport iDownloadSupport;

    public DownLoadFileManager(DownloadFileParam downloadFileParam) {
        this.downloadFileParam = downloadFileParam;
    }

    public DownLoadFileManager(DownloadFileParam downloadFileParam, IDownloadSupport iDownloadSupport) {
        this(downloadFileParam);
        this.iDownloadSupport = iDownloadSupport;
    }

    @Override // com.huawei.location.lite.common.chain.TaskFinishCallBack
    public void onFail(Data data) {
        IDownloadResult iDownloadResult = this.iDownloadResult;
        if (iDownloadResult != null) {
            iDownloadResult.onFail(data.getInt("download_result_code_key", 0), data.getString("download_result_desc_key"));
        }
    }

    @Override // com.huawei.location.lite.common.chain.TaskFinishCallBack
    public void onSuccess(Data data) {
        String str;
        LogLocation.i("DownLoadFileManager", "download file Success.");
        if (this.iDownloadResult == null) {
            str = "iDownloadResult is empty.please setting";
        } else {
            Parcelable parcelable = data.getParcelable("download_entity");
            if (parcelable instanceof DownLoadFileBean) {
                DownLoadFileBean downLoadFileBean = (DownLoadFileBean) parcelable;
                if (data.getKeyValueMap().get("download_file") instanceof File) {
                    this.iDownloadResult.onSuccess(downLoadFileBean, (File) data.getKeyValueMap().get("download_file"));
                    return;
                }
                return;
            }
            str = "return data exception";
        }
        LogLocation.e("DownLoadFileManager", str);
    }

    public void startDownloadTask(IDownloadResult iDownloadResult) {
        this.iDownloadResult = iDownloadResult;
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setMaxTimeOut(300000);
        taskRequest.setInputData(new Data.Builder().putParcelable("download_file_param", this.downloadFileParam).build());
        taskRequest.setTaskFinishCallBack(this);
        TaskClient.Builder builder = new TaskClient.Builder();
        builder.addTask(new DownloadUrlReqTask());
        DownloadFileTask downloadFileTask = new DownloadFileTask();
        downloadFileTask.setiDownloadSupport(this.iDownloadSupport);
        builder.addTask(downloadFileTask);
        try {
            builder.withTaskRequest(taskRequest).build().runTasks();
        } catch (TaskTimeOutException unused) {
            LogLocation.e("DownLoadFileManager", "download file timeout");
        }
    }
}
