package org.jose4j.jwe;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ExceptionHelp;

/* loaded from: classes4.dex */
public class AesKeyWrapManagementAlgorithm extends WrappingKeyManagementAlgorithm {
    int keyByteLength;

    public AesKeyWrapManagementAlgorithm(String str, int i) {
        super("AESWrap", str);
        setKeyType("oct");
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        this.keyByteLength = i;
    }

    int getKeyByteLength() {
        return this.keyByteLength;
    }

    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() throws NoSuchPaddingException, NoSuchAlgorithmException {
        int keyByteLength = getKeyByteLength();
        String javaAlgorithm = getJavaAlgorithm();
        try {
            Cipher.getInstance(javaAlgorithm);
            return CipherStrengthSupport.isAvailable(javaAlgorithm, keyByteLength);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            ((WrappingKeyManagementAlgorithm) this).log.debug("{} for {} is not available ({}).", javaAlgorithm, getAlgorithmIdentifier(), ExceptionHelp.toStringWithCauses(e));
            return false;
        }
    }

    AesKeyWrapManagementAlgorithm setUseGeneralProviderContext() {
        this.useSuppliedKeyProviderContext = false;
        return this;
    }

    public static class Aes128 extends AesKeyWrapManagementAlgorithm {
        public Aes128() {
            super("A128KW", 16);
        }
    }

    public static class Aes192 extends AesKeyWrapManagementAlgorithm {
        public Aes192() {
            super("A192KW", 24);
        }
    }

    public static class Aes256 extends AesKeyWrapManagementAlgorithm {
        public Aes256() {
            super("A256KW", 32);
        }
    }
}
