package com.huawei.location.nlp.network.request;

import com.huawei.location.nlp.network.response.Location;

/* loaded from: classes3.dex */
public class GPSLocationOnline extends Location {
    private int sourceType;

    public int getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(int i) {
        this.sourceType = i;
    }

    @Override // com.huawei.location.nlp.network.response.Location
    public String toString() {
        return "GPSLocationOnline{" + super.toString() + "sourceType=" + this.sourceType + '}';
    }
}
