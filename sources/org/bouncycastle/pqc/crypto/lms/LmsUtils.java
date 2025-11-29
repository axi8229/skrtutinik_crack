package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;

/* loaded from: classes4.dex */
class LmsUtils {
    static void byteArray(byte[] bArr, Digest digest) {
        digest.update(bArr, 0, bArr.length);
    }

    static void u16str(short s, Digest digest) {
        digest.update((byte) (s >>> 8));
        digest.update((byte) s);
    }

    static void u32str(int i, Digest digest) {
        digest.update((byte) (i >>> 24));
        digest.update((byte) (i >>> 16));
        digest.update((byte) (i >>> 8));
        digest.update((byte) i);
    }
}
