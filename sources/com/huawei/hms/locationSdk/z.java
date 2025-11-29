package com.huawei.hms.locationSdk;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class z {
    private final int a;
    private final long b;
    private final List<a0> c;

    public z(int i, long j, List<a0> list) {
        this.a = i;
        this.b = j;
        this.c = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("svCnt");
        sb.append(":");
        sb.append(this.a);
        sb.append(",");
        sb.append("receiverTime");
        sb.append(":");
        sb.append(this.b);
        sb.append(",");
        sb.append("gnssStatus");
        sb.append(":[");
        List<a0> list = this.c;
        if (list != null && list.size() != 0) {
            Iterator<a0> it = this.c.iterator();
            while (it.hasNext()) {
                sb.append(it.next().toString());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        return sb.toString();
    }
}
