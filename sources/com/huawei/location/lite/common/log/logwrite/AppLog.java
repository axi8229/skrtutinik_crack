package com.huawei.location.lite.common.log.logwrite;

/* loaded from: classes3.dex */
public class AppLog {
    private String fileType;
    private String level;
    private String msg;
    private String tag;
    private Throwable tr;

    public AppLog(String str, String str2) {
        this.msg = str;
        this.fileType = str2;
    }

    public AppLog(String str, String str2, String str3, String str4, Throwable th) {
        this.level = str;
        this.tag = str2;
        this.msg = str3;
        this.fileType = str4;
        this.tr = th;
    }

    public AppLog(String str, String str2, String str3, Throwable th) {
        this.level = str;
        this.tag = str2;
        this.msg = str3;
        this.tr = th;
        this.fileType = "log";
    }

    public String getFileType() {
        return this.fileType;
    }

    public String getLevel() {
        return this.level;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getTag() {
        return this.tag;
    }

    public Throwable getTr() {
        return this.tr;
    }
}
