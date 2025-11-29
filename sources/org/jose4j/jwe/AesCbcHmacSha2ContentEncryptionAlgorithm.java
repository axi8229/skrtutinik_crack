package org.jose4j.jwe;

import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.keys.KeyPersuasion;
import ru.yoomoney.sdk.auth.utils.CipherChaCha20Poly1305Kt;

/* loaded from: classes4.dex */
public class AesCbcHmacSha2ContentEncryptionAlgorithm extends AlgorithmInfo implements ContentEncryptionAlgorithm {
    private final ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor;
    private final String hmacJavaAlgorithm;
    private final int tagTruncationLength;

    public AesCbcHmacSha2ContentEncryptionAlgorithm(String str, int i, String str2, int i2) {
        setAlgorithmIdentifier(str);
        this.contentEncryptionKeyDescriptor = new ContentEncryptionKeyDescriptor(i, "AES");
        this.hmacJavaAlgorithm = str2;
        this.tagTruncationLength = i2;
        setJavaAlgorithm("AES/CBC/PKCS5Padding");
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        setKeyType("AES");
    }

    public ContentEncryptionKeyDescriptor getContentEncryptionKeyDescriptor() {
        return this.contentEncryptionKeyDescriptor;
    }

    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() {
        return CipherStrengthSupport.isAvailable(getJavaAlgorithm(), getContentEncryptionKeyDescriptor().getContentEncryptionKeyByteLength() / 2);
    }

    public static class Aes128CbcHmacSha256 extends AesCbcHmacSha2ContentEncryptionAlgorithm implements ContentEncryptionAlgorithm {
        public Aes128CbcHmacSha256() {
            super("A128CBC-HS256", 32, CipherChaCha20Poly1305Kt.HASHING_ALGORITHM_HMAC_SHA_256, 16);
        }
    }

    public static class Aes192CbcHmacSha384 extends AesCbcHmacSha2ContentEncryptionAlgorithm implements ContentEncryptionAlgorithm {
        public Aes192CbcHmacSha384() {
            super("A192CBC-HS384", 48, "HmacSHA384", 24);
        }
    }

    public static class Aes256CbcHmacSha512 extends AesCbcHmacSha2ContentEncryptionAlgorithm implements ContentEncryptionAlgorithm {
        public Aes256CbcHmacSha512() {
            super("A256CBC-HS512", 64, "HmacSHA512", 32);
        }
    }
}
