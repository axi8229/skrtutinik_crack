package com.huawei.hms.apptouch;

/* loaded from: classes3.dex */
public class AppInfo {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    public AppInfo() {
    }

    public AppInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }

    public String getAppId() {
        return this.c;
    }

    public String getAppPackageName() {
        return this.d;
    }

    public String getAppTouchPackageName() {
        return this.b;
    }

    public String getBusiness() {
        return this.a;
    }

    public String getCarrierId() {
        return this.e;
    }

    public String getHomeCountry() {
        return this.f;
    }

    public void setAppId(String str) {
        this.c = str;
    }

    public void setAppPackageName(String str) {
        this.d = str;
    }

    public void setAppTouchPackageName(String str) {
        this.b = str;
    }

    public void setBusiness(String str) {
        this.a = str;
    }

    public void setCarrierId(String str) {
        this.e = str;
    }

    public void setHomeCountry(String str) {
        this.f = str;
    }

    public String toString() {
        return "business:" + this.a + ", appTouchPackageName:" + this.b + ", appId:" + this.c + ", appPackageName:" + this.d + ", carrierId:" + this.e + ", homeCountry:" + this.f;
    }
}
