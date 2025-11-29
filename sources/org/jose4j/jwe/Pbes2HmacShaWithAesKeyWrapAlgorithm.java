package org.jose4j.jwe;

import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.jwe.AesKeyWrapManagementAlgorithm;
import org.jose4j.jwe.kdf.PasswordBasedKeyDerivationFunction2;
import org.jose4j.keys.KeyPersuasion;
import ru.yoomoney.sdk.auth.utils.CipherChaCha20Poly1305Kt;

/* loaded from: classes4.dex */
public class Pbes2HmacShaWithAesKeyWrapAlgorithm extends AlgorithmInfo implements KeyManagementAlgorithm {
    private static final byte[] ZERO_BYTE = {0};
    private long defaultIterationCount = 8192;
    private int defaultSaltByteLength = 12;
    private AesKeyWrapManagementAlgorithm keyWrap;
    private ContentEncryptionKeyDescriptor keyWrapKeyDescriptor;
    private PasswordBasedKeyDerivationFunction2 pbkdf2;

    public Pbes2HmacShaWithAesKeyWrapAlgorithm(String str, String str2, AesKeyWrapManagementAlgorithm aesKeyWrapManagementAlgorithm) {
        setAlgorithmIdentifier(str);
        setJavaAlgorithm("n/a");
        this.pbkdf2 = new PasswordBasedKeyDerivationFunction2(str2);
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        setKeyType("PBKDF2");
        this.keyWrap = aesKeyWrapManagementAlgorithm;
        this.keyWrapKeyDescriptor = new ContentEncryptionKeyDescriptor(aesKeyWrapManagementAlgorithm.getKeyByteLength(), "AES");
    }

    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() {
        return this.keyWrap.isAvailable();
    }

    public static class HmacSha256Aes128 extends Pbes2HmacShaWithAesKeyWrapAlgorithm {
        public HmacSha256Aes128() {
            super("PBES2-HS256+A128KW", CipherChaCha20Poly1305Kt.HASHING_ALGORITHM_HMAC_SHA_256, new AesKeyWrapManagementAlgorithm.Aes128().setUseGeneralProviderContext());
        }
    }

    public static class HmacSha384Aes192 extends Pbes2HmacShaWithAesKeyWrapAlgorithm {
        public HmacSha384Aes192() {
            super("PBES2-HS384+A192KW", "HmacSHA384", new AesKeyWrapManagementAlgorithm.Aes192().setUseGeneralProviderContext());
        }
    }

    public static class HmacSha512Aes256 extends Pbes2HmacShaWithAesKeyWrapAlgorithm {
        public HmacSha512Aes256() {
            super("PBES2-HS512+A256KW", "HmacSHA512", new AesKeyWrapManagementAlgorithm.Aes256().setUseGeneralProviderContext());
        }
    }
}
