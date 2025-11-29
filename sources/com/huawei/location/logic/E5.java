package com.huawei.location.logic;

import android.location.Location;
import com.huawei.hms.location.LocationRequest;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class E5 implements Serializable {
    private long FB;
    private List<Location> LW;
    private int Vw;
    private String yn;

    public E5() {
    }

    public E5(String str, int i, long j, List<Location> list, LocationRequest locationRequest) {
        this.yn = str;
        this.Vw = i;
        this.FB = j;
        this.LW = list;
    }

    public int FB() {
        return this.Vw;
    }

    public String LW() {
        return this.yn;
    }

    public long Vw() {
        return this.FB;
    }

    public List<Location> yn() {
        return this.LW;
    }

    public void yn(long j) {
        this.FB = j;
    }

    public void yn(String str) {
        this.yn = str;
    }

    public void yn(List<Location> list) {
        List<Location> list2 = this.LW;
        if (list2 == null) {
            this.LW = list;
        } else {
            list2.addAll(list);
        }
    }
}
