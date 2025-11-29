package com.huawei.location.crowdsourcing.upload.entity;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
public class yn {
    public static final yn yn = new yn(33554432, 10);

    @SerializedName("patchSize")
    private final long FB;

    @SerializedName("patchNum")
    private final int LW;

    @SerializedName("patchVer")
    private final String Vw = "0";

    public yn(long j, int i) {
        this.FB = j;
        this.LW = i;
    }

    public String FB() {
        return this.Vw;
    }

    public long Vw() {
        return this.FB;
    }

    public int yn() {
        return this.LW;
    }
}
