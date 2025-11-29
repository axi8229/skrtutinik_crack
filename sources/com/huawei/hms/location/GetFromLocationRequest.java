package com.huawei.hms.location;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes3.dex */
public class GetFromLocationRequest implements IMessageEntity {

    @Packed
    private double latitude;

    @Packed
    private double longitude;

    @Packed
    private int maxResults;

    public GetFromLocationRequest(double d, double d2, int i) {
        this.latitude = d;
        this.longitude = d2;
        this.maxResults = i;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public int getMaxResults() {
        return this.maxResults;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setMaxResults(int i) {
        this.maxResults = i;
    }
}
