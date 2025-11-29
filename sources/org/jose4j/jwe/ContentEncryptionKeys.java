package org.jose4j.jwe;

import org.jose4j.lang.ByteUtil;

/* loaded from: classes4.dex */
public class ContentEncryptionKeys {
    private final byte[] contentEncryptionKey;
    private final byte[] encryptedKey;

    public ContentEncryptionKeys(byte[] bArr, byte[] bArr2) {
        this.contentEncryptionKey = bArr;
        this.encryptedKey = bArr2 == null ? ByteUtil.EMPTY_BYTES : bArr2;
    }
}
