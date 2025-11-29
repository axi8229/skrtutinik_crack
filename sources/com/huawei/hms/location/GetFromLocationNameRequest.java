package com.huawei.hms.location;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes3.dex */
public class GetFromLocationNameRequest implements IMessageEntity {

    @Packed
    private String locationName;

    @Packed
    private double lowerLeftLatitude;

    @Packed
    private double lowerLeftLongitude;

    @Packed
    private int maxResults;

    @Packed
    private double upperRightLatitude;

    @Packed
    private double upperRightLongitude;

    public GetFromLocationNameRequest(String str, int i) {
        this.locationName = str;
        this.maxResults = i;
    }

    public GetFromLocationNameRequest(String str, int i, double d, double d2, double d3, double d4) {
        this.locationName = str;
        this.maxResults = i;
        this.lowerLeftLatitude = d;
        this.lowerLeftLongitude = d2;
        this.upperRightLatitude = d3;
        this.upperRightLongitude = d4;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public double getLowerLeftLatitude() {
        return this.lowerLeftLatitude;
    }

    public double getLowerLeftLongitude() {
        return this.lowerLeftLongitude;
    }

    public int getMaxResults() {
        return this.maxResults;
    }

    public double getUpperRightLatitude() {
        return this.upperRightLatitude;
    }

    public double getUpperRightLongitude() {
        return this.upperRightLongitude;
    }

    public void setLocationName(String str) {
        this.locationName = str;
    }

    public void setLowerLeftLatitude(double d) {
        this.lowerLeftLatitude = d;
    }

    public void setLowerLeftLongitude(double d) {
        this.lowerLeftLongitude = d;
    }

    public void setMaxResults(int i) {
        this.maxResults = i;
    }

    public void setUpperRightLatitude(double d) {
        this.upperRightLatitude = d;
    }

    public void setUpperRightLongitude(double d) {
        this.upperRightLongitude = d;
    }
}
