package com.huawei.hms.apptouch;

import java.util.List;

/* loaded from: classes3.dex */
public class AppInfoSetResponse {
    private List<AppInfoResult> a;

    public static class AppInfoResult {
        private int a;
        private String b;
        private AppInfo c;

        public AppInfoResult() {
        }

        public AppInfoResult(int i, String str, AppInfo appInfo) {
            this.a = i;
            this.b = str;
            this.c = appInfo;
        }

        public AppInfo getAppInfo() {
            return this.c;
        }

        public int getErrorCode() {
            return this.a;
        }

        public String getErrorMessage() {
            return this.b;
        }

        public void setAppInfo(AppInfo appInfo) {
            this.c = appInfo;
        }

        public void setErrorCode(int i) {
            this.a = i;
        }

        public void setErrorMessage(String str) {
            this.b = str;
        }

        public String toString() {
            return "errorCode:" + this.a + ", errorMessage:" + this.b + ", appInfo:" + this.c;
        }
    }

    public List<AppInfoResult> getErrorAppInfos() {
        return this.a;
    }

    public void setErrorAppInfos(List<AppInfoResult> list) {
        this.a = list;
    }
}
