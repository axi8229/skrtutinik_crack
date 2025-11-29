package com.huawei.location.vdr.data.ephemeris;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Locale;

/* loaded from: classes3.dex */
public class Vw {
    private int FB;
    private long LW;
    private int Vw;
    private int yn;

    public Vw(long j) {
        yn(j);
    }

    private void yn(long j) {
        long j2 = ((j / 1000) - 315964800) + 18;
        this.LW = j2;
        this.FB = (int) (j2 % 604800);
        int i = (int) (j2 / 604800);
        this.yn = i / 1024;
        this.Vw = i % 1024;
    }

    public int FB() {
        return this.Vw;
    }

    public int LW() {
        return this.yn;
    }

    public long Vw() {
        return this.LW;
    }

    public int dC() {
        return this.FB;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "weekRound: %d weekNumber = %d weekSecond: %d", Integer.valueOf(this.yn), Integer.valueOf(this.Vw), Integer.valueOf(this.FB));
    }

    public int yn() {
        return (this.FB / RemoteMessageConst.DEFAULT_TTL) * RemoteMessageConst.DEFAULT_TTL;
    }
}
