package com.huawei.location.lite.common.chain;

import com.huawei.location.lite.common.log.LogLocation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class TaskClient implements TaskFinishCallBack {
    private CountDownLatch countDownLatch;
    private boolean isSuccess;
    private Data outData;
    private TaskFinishCallBack taskFinishCallBack;
    private TaskRequest taskRequest;
    private List<Task> tasks;

    public static final class Builder {
        private TaskRequest taskRequest;
        private List<Task> tasks = new ArrayList();

        public Builder addTask(Task task) {
            if (task == null) {
                throw new IllegalArgumentException("task == null");
            }
            if (this.tasks == null) {
                this.tasks = new ArrayList();
            }
            this.tasks.add(task);
            return this;
        }

        public TaskClient build() {
            return new TaskClient(this);
        }

        public Builder withTaskRequest(TaskRequest taskRequest) {
            this.taskRequest = taskRequest;
            return this;
        }
    }

    private TaskClient(Builder builder) {
        this.tasks = Collections.unmodifiableList(builder.tasks);
        TaskRequest taskRequest = builder.taskRequest;
        this.taskRequest = taskRequest;
        this.taskFinishCallBack = taskRequest.getTaskFinishCallBack();
        this.taskRequest.setTaskFinishCallBack(this);
        this.countDownLatch = new CountDownLatch(1);
    }

    private void enqueue() throws TaskTimeOutException {
        try {
            LogLocation.i("TaskChain", "tasks is start,tid:" + this.taskRequest.getTransId());
            new TaskChain(this.tasks, this.taskRequest).runTask(false);
            if (this.countDownLatch.await(this.taskRequest.getMaxTimeOut(), TimeUnit.MILLISECONDS)) {
                LogLocation.i("TaskChain", "tasks is success,tid:" + this.taskRequest.getTransId());
                return;
            }
            LogLocation.w("TaskChain", "tasks is timeOut,tid:" + this.taskRequest.getTransId());
            this.taskRequest.setIsTimeOut(true);
            throw new TaskTimeOutException("task timeout");
        } catch (InterruptedException unused) {
            throw new TaskTimeOutException("task interrupted");
        }
    }

    private void execute() throws TaskTimeOutException {
        enqueue();
        if (this.isSuccess) {
            this.taskFinishCallBack.onSuccess(this.outData);
        } else {
            this.taskFinishCallBack.onFail(this.outData);
        }
    }

    @Override // com.huawei.location.lite.common.chain.TaskFinishCallBack
    public void onFail(Data data) {
        this.outData = data;
        this.isSuccess = false;
        if (this.taskRequest.isAsync()) {
            this.taskFinishCallBack.onFail(data);
        }
        this.countDownLatch.countDown();
    }

    @Override // com.huawei.location.lite.common.chain.TaskFinishCallBack
    public void onSuccess(Data data) {
        this.outData = data;
        this.isSuccess = true;
        if (this.taskRequest.isAsync()) {
            this.taskFinishCallBack.onSuccess(data);
        }
        this.countDownLatch.countDown();
    }

    public void runTasks() throws TaskTimeOutException {
        if (this.tasks.isEmpty()) {
            return;
        }
        if (this.taskRequest.isAsync()) {
            enqueue();
        } else {
            execute();
        }
    }
}
