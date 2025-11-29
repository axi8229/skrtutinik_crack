package com.huawei.location.lite.common.log.logwrite;

/* loaded from: classes3.dex */
public class LogWriteParam {
    private int fileExpiredTime;
    private int fileNum;
    private int fileSize;
    private String logPath;

    public int getFileExpiredTime() {
        return this.fileExpiredTime;
    }

    public int getFileNum() {
        return this.fileNum;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public String getLogPath() {
        return this.logPath;
    }

    public void setFileExpiredTime(int i) {
        this.fileExpiredTime = i;
    }

    public void setFileNum(int i) {
        this.fileNum = i;
    }

    public void setFileSize(int i) {
        this.fileSize = i;
    }

    public void setLogPath(String str) {
        this.logPath = str;
    }
}
