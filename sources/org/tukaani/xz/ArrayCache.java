package org.tukaani.xz;

/* loaded from: classes4.dex */
public class ArrayCache {
    private static volatile ArrayCache defaultCache;
    private static final ArrayCache dummyCache;

    static {
        ArrayCache arrayCache = new ArrayCache();
        dummyCache = arrayCache;
        defaultCache = arrayCache;
    }

    public static ArrayCache getDefaultCache() {
        return defaultCache;
    }

    public byte[] getByteArray(int i, boolean z) {
        return new byte[i];
    }

    public void putArray(byte[] bArr) {
    }
}
