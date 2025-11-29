package com.huawei.hms.locationSdk;

/* loaded from: classes3.dex */
public class g0 extends i0 {
    private static volatile g0 b;
    private static final byte[] c = new byte[0];

    public static g0 b() {
        if (b == null) {
            synchronized (c) {
                try {
                    if (b == null) {
                        b = new g0();
                    }
                } finally {
                }
            }
        }
        return b;
    }
}
