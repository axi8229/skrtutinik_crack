package com.huawei.location.lite.common.chain;

import com.huawei.location.lite.common.chain.Result;
import com.huawei.location.lite.common.chain.Task;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.List;

/* loaded from: classes3.dex */
public class TaskChain implements Task.Chain {
    private int index = -1;
    private TaskRequest request;
    private List<Task> taskList;

    public TaskChain(List<Task> list, TaskRequest taskRequest) {
        this.taskList = list;
        this.request = taskRequest;
    }

    @Override // com.huawei.location.lite.common.chain.Task.Chain
    public TaskRequest getRequest() {
        return this.request;
    }

    @Override // com.huawei.location.lite.common.chain.Task.Chain
    public int proceed() {
        if (this.request.getResult() instanceof Result.Failure) {
            return 101;
        }
        return this.index == this.taskList.size() + (-1) ? 100 : 103;
    }

    @Override // com.huawei.location.lite.common.chain.Task.Chain
    public Result runTask(boolean z) {
        if (!z) {
            this.index++;
        }
        this.taskList.get(this.index).runTask(this);
        LogLocation.i("TaskChain", "tasks tid:" + getRequest().getTransId());
        return getRequest().getResult();
    }
}
