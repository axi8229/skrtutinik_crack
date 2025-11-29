package com.huawei.location.lite.common.log.logwrite;

import java.io.BufferedWriter;

/* loaded from: classes3.dex */
public class FileParam {
    private String fileDirPath;
    private String fileName;
    private boolean isFirstWrite = true;
    private boolean isNeedCheck;
    private BufferedWriter writer;

    public String getFileDirPath() {
        return this.fileDirPath;
    }

    public String getFileName() {
        return this.fileName;
    }

    public BufferedWriter getWriter() {
        return this.writer;
    }

    public boolean isFirstWrite() {
        return this.isFirstWrite;
    }

    public boolean isNeedCheck() {
        return this.isNeedCheck;
    }

    public void setFileDirPath(String str) {
        this.fileDirPath = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setNeedCheck(boolean z) {
        this.isNeedCheck = z;
    }

    public void setWriter(BufferedWriter bufferedWriter) {
        this.writer = bufferedWriter;
    }
}
