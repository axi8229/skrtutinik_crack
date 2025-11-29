package com.huawei.hms.locationSdk;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class y {

    @SerializedName("TopCnOSvCount")
    private int a;

    @SerializedName("StatusCacheTime")
    private int b;

    @SerializedName("GnssExceptionInterval")
    private int c;

    @SerializedName("MaxGnssExceptionCount")
    private int d;

    @SerializedName("GnssExceptionTimeOut")
    private int e;

    @SerializedName("GnssExceptionReportType")
    private int f;

    @SerializedName("GnssExceptionReportPkg")
    private List<String> g;

    public int a() {
        return this.c;
    }

    public List<String> b() {
        return this.g;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.e;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.a;
    }

    public void h() {
        this.a = 10;
        this.b = 30;
        this.c = 60;
        this.d = 5;
        this.e = 5;
        this.f = 1;
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        arrayList.add("com.huawei.maps.app");
        this.g.add("com.huawei.maps.car.app");
        this.g.add("com.huawei.Locationsample6");
    }

    public String toString() {
        return "GnssExceptionConfigBean{topCnOSvCount=" + this.a + ", statusCacheTime=" + this.b + ", gnssExceptionInterval=" + this.c + ", maxGnssExceptionCount=" + this.d + ", gnssExceptionTimeOut=" + this.e + ", gnssExceptionReportType=" + this.f + ", gnssExceptionReportPkg=" + this.g + '}';
    }
}
