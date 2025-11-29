package org.jose4j.keys;

import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public class HmacKey extends SecretKeySpec {
    public HmacKey(byte[] bArr) {
        super(bArr, "HMAC");
    }
}
