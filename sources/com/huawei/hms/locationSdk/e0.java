package com.huawei.hms.locationSdk;

/* loaded from: classes3.dex */
public class e0 extends i0 {
    private static volatile e0 b;
    private static final byte[] c = new byte[0];

    public static e0 b() {
        if (b == null) {
            synchronized (c) {
                try {
                    if (b == null) {
                        b = new e0();
                    }
                } finally {
                }
            }
        }
        return b;
    }
}
