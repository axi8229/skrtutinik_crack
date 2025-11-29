package com.huawei.hms.support.api.entity.location.stationrecognition;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
public class HistoryStationBean {

    @SerializedName("seqNumber")
    private int seqNumber;

    @SerializedName("stationName")
    private String stationName;

    public int getSeqNumber() {
        return this.seqNumber;
    }

    public String getStationName() {
        return this.stationName;
    }

    public void setSeqNumber(int i) {
        this.seqNumber = i;
    }

    public void setStationName(String str) {
        this.stationName = str;
    }
}
