package com.huawei.location.lite.common.chain;

import com.huawei.location.lite.common.chain.Result;
import com.huawei.location.lite.common.chain.Task;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.UUID;

/* loaded from: classes3.dex */
public class TaskRequest {
    private Data data;
    private Result result;
    private TaskFinishCallBack taskFinishCallBack;
    private int maxTimeOut = 120000;
    private boolean isAsync = false;
    private boolean isTimeOut = false;
    private String transId = UUID.randomUUID().toString();

    public Data getInputData() {
        return this.data;
    }

    public int getMaxTimeOut() {
        return this.maxTimeOut;
    }

    public Data getOutputData() {
        Result result;
        Result result2 = this.result;
        if (result2 instanceof Result.Success) {
            result = (Result.Success) result2;
        } else {
            if (!(result2 instanceof Result.Failure)) {
                return this.data;
            }
            result = (Result.Failure) result2;
        }
        return result.getOutputData();
    }

    public Result getResult() {
        return this.result;
    }

    public TaskFinishCallBack getTaskFinishCallBack() {
        return this.taskFinishCallBack;
    }

    public String getTransId() {
        return this.transId;
    }

    public boolean isAsync() {
        return this.isAsync;
    }

    public void setInputData(Data data) {
        this.data = data;
    }

    public void setIsTimeOut(boolean z) {
        this.isTimeOut = z;
    }

    public void setMaxTimeOut(int i) {
        this.maxTimeOut = i;
    }

    public void setResult(Result result, Task.Chain chain) {
        boolean z;
        this.result = result;
        if (this.isTimeOut || this.taskFinishCallBack == null) {
            LogLocation.w("TaskRequest", "request is time out,tid:" + this.transId);
            return;
        }
        switch (chain.proceed()) {
            case 100:
                this.taskFinishCallBack.onSuccess(result.getOutputData());
                return;
            case 101:
                this.taskFinishCallBack.onFail(result.getOutputData());
                return;
            case 102:
                z = true;
                break;
            case 103:
                z = false;
                break;
            default:
                this.taskFinishCallBack.onFail(Result.failure().getOutputData());
                return;
        }
        chain.runTask(z);
    }

    public void setTaskFinishCallBack(TaskFinishCallBack taskFinishCallBack) {
        this.taskFinishCallBack = taskFinishCallBack;
    }
}
