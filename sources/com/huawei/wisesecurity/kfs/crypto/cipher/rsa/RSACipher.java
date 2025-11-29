package com.huawei.wisesecurity.kfs.crypto.cipher.rsa;

import com.huawei.wisesecurity.kfs.crypto.AsymmetricBuilder;
import com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg;
import com.huawei.wisesecurity.kfs.crypto.cipher.CipherText;
import com.huawei.wisesecurity.kfs.crypto.cipher.DecryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.DefaultDecryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.DefaultEncryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.EncryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.KfsCipher;
import com.huawei.wisesecurity.kfs.crypto.key.KeyStoreProvider;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* loaded from: classes3.dex */
public class RSACipher implements KfsCipher {
    private final CipherAlg cipherAlg;
    private final AlgorithmParameterSpec parameterSpec;
    private final PrivateKey privateKey;
    private final KeyStoreProvider provider;
    private final PublicKey publicKey;

    public static class Builder extends AsymmetricBuilder<RSACipher> {
        private CipherAlg cipherAlg;
        private final AlgorithmParameterSpec parameterSpec;

        public Builder(KeyStoreProvider keyStoreProvider) {
            super(keyStoreProvider);
            this.cipherAlg = CipherAlg.getPreferredAlg("RSA");
            this.parameterSpec = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.huawei.wisesecurity.kfs.crypto.AsymmetricBuilder
        public RSACipher build() throws CryptoException {
            return new RSACipher(this.keyStoreProvider, this.cipherAlg, this.privateKey, this.publicKey, this.parameterSpec);
        }

        public Builder withAlg(CipherAlg cipherAlg) {
            this.cipherAlg = cipherAlg;
            return this;
        }
    }

    private RSACipher(KeyStoreProvider keyStoreProvider, CipherAlg cipherAlg, PrivateKey privateKey, PublicKey publicKey, AlgorithmParameterSpec algorithmParameterSpec) {
        this.provider = keyStoreProvider;
        this.cipherAlg = cipherAlg;
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        this.parameterSpec = algorithmParameterSpec;
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.cipher.KfsCipher
    public DecryptHandler getDecryptHandler() throws CryptoException {
        CipherText cipherText = new CipherText();
        cipherText.setAlgId(this.cipherAlg);
        PrivateKey privateKey = this.privateKey;
        if (privateKey != null) {
            return new DefaultDecryptHandler(this.provider, privateKey, cipherText, this.parameterSpec);
        }
        throw new CryptoException("privateKey is invalid.");
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.cipher.KfsCipher
    public EncryptHandler getEncryptHandler() throws CryptoException {
        CipherText cipherText = new CipherText();
        cipherText.setAlgId(this.cipherAlg);
        PublicKey publicKey = this.publicKey;
        if (publicKey != null) {
            return new DefaultEncryptHandler(this.provider, publicKey, cipherText, this.parameterSpec);
        }
        throw new CryptoException("publicKey is invalid.");
    }
}
