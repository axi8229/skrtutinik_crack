package com.huawei.location.lite.common.util.filedownload;

import android.os.Parcelable;
import com.huawei.location.lite.common.chain.Data;
import com.huawei.location.lite.common.chain.Result;
import com.huawei.location.lite.common.chain.Task;
import com.huawei.location.lite.common.chain.TaskRequest;
import com.huawei.location.lite.common.log.LogLocation;

/* loaded from: classes3.dex */
public class DownloadBaseTask implements Task {
    protected Task.Chain downloadChain;
    protected DownloadFileParam downloadFileParam;
    protected TaskRequest taskRequest;

    @Override // com.huawei.location.lite.common.chain.Task
    public void runTask(Task.Chain chain) {
        this.downloadChain = chain;
        TaskRequest request = chain.getRequest();
        this.taskRequest = request;
        Parcelable parcelable = request.getInputData().getParcelable("download_file_param");
        if (parcelable instanceof DownloadFileParam) {
            this.downloadFileParam = (DownloadFileParam) parcelable;
        } else {
            setNextFail(10000, "param error");
        }
    }

    protected void setNextFail(int i, String str) {
        LogLocation.e("DownloadBaseTask", "download  failed:" + i + "desc:" + str);
        this.taskRequest.setResult(Result.failure(new Data.Builder().putInt("download_result_code_key", i).putString("download_result_desc_key", str).build()), this.downloadChain);
    }
}
