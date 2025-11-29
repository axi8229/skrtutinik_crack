package com.huawei.hms.location;

/* loaded from: classes3.dex */
public class LogConfig {
    private int fileExpiredTime;
    private int fileNum;
    private int fileSize;
    private String logPath;

    public LogConfig() {
    }

    public LogConfig(String str) {
        this.logPath = str;
    }

    public LogConfig(String str, int i, int i2, int i3) {
        this.logPath = str;
        this.fileSize = i;
        this.fileNum = i2;
        this.fileExpiredTime = i3;
    }

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
