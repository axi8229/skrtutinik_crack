package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class y {
    private static y b;
    private volatile Map<String, p0> a = new HashMap();

    private y() {
    }

    private p0 a(String str) {
        if (!this.a.containsKey(str)) {
            this.a.put(str, new p0());
        }
        return this.a.get(str);
    }

    public static y a() {
        if (b == null) {
            b();
        }
        return b;
    }

    private static synchronized void b() {
        if (b == null) {
            b = new y();
        }
    }

    public p0 a(String str, long j) {
        p0 p0VarA = a(str);
        p0VarA.a(j);
        return p0VarA;
    }
}
