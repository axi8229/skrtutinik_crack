package org.jose4j.jwe;

import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ByteUtil;

/* loaded from: classes4.dex */
public class AesGcmKeyEncryptionAlgorithm extends AlgorithmInfo implements KeyManagementAlgorithm {
    private int keyByteLength;
    private SimpleAeadCipher simpleAeadCipher;

    public AesGcmKeyEncryptionAlgorithm(String str, int i) {
        setAlgorithmIdentifier(str);
        setJavaAlgorithm("AES/GCM/NoPadding");
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        setKeyType("oct");
        this.simpleAeadCipher = new SimpleAeadCipher(getJavaAlgorithm(), 16);
        this.keyByteLength = i;
    }

    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() {
        return this.simpleAeadCipher.isAvailable(this.log, this.keyByteLength, 12, getAlgorithmIdentifier());
    }

    public static class Aes128Gcm extends AesGcmKeyEncryptionAlgorithm {
        public Aes128Gcm() {
            super("A128GCMKW", ByteUtil.byteLength(128));
        }
    }

    public static class Aes192Gcm extends AesGcmKeyEncryptionAlgorithm {
        public Aes192Gcm() {
            super("A192GCMKW", ByteUtil.byteLength(192));
        }
    }

    public static class Aes256Gcm extends AesGcmKeyEncryptionAlgorithm {
        public Aes256Gcm() {
            super("A256GCMKW", ByteUtil.byteLength(256));
        }
    }
}
