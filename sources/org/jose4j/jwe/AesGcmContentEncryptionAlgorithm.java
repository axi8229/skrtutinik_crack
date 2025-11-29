package org.jose4j.jwe;

import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ByteUtil;

/* loaded from: classes4.dex */
public class AesGcmContentEncryptionAlgorithm extends AlgorithmInfo implements ContentEncryptionAlgorithm {
    private ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor;
    private SimpleAeadCipher simpleAeadCipher;

    public AesGcmContentEncryptionAlgorithm(String str, int i) {
        setAlgorithmIdentifier(str);
        setJavaAlgorithm("AES/GCM/NoPadding");
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        setKeyType("AES");
        this.contentEncryptionKeyDescriptor = new ContentEncryptionKeyDescriptor(ByteUtil.byteLength(i), "AES");
        this.simpleAeadCipher = new SimpleAeadCipher(getJavaAlgorithm(), 16);
    }

    public ContentEncryptionKeyDescriptor getContentEncryptionKeyDescriptor() {
        return this.contentEncryptionKeyDescriptor;
    }

    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() {
        return this.simpleAeadCipher.isAvailable(this.log, getContentEncryptionKeyDescriptor().getContentEncryptionKeyByteLength(), 12, getAlgorithmIdentifier());
    }

    public static class Aes256Gcm extends AesGcmContentEncryptionAlgorithm {
        public Aes256Gcm() {
            super("A256GCM", 256);
        }
    }

    public static class Aes192Gcm extends AesGcmContentEncryptionAlgorithm {
        public Aes192Gcm() {
            super("A192GCM", 192);
        }
    }

    public static class Aes128Gcm extends AesGcmContentEncryptionAlgorithm {
        public Aes128Gcm() {
            super("A128GCM", 128);
        }
    }
}
