package org.jose4j.keys;

import javax.crypto.spec.SecretKeySpec;
import org.jose4j.lang.ByteUtil;

/* loaded from: classes4.dex */
public class AesKey extends SecretKeySpec {
    public AesKey(byte[] bArr) {
        super(bArr, "AES");
    }

    public String toString() {
        return ByteUtil.bitLength(getEncoded().length) + " bit AES key";
    }
}
