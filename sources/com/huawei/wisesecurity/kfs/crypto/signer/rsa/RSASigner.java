package com.huawei.wisesecurity.kfs.crypto.signer.rsa;

import com.huawei.wisesecurity.kfs.crypto.key.KeyStoreProvider;
import com.huawei.wisesecurity.kfs.crypto.signer.AsymmetricSignerBuilder;
import com.huawei.wisesecurity.kfs.crypto.signer.DefaultSignHandler;
import com.huawei.wisesecurity.kfs.crypto.signer.DefaultVerifyHandler;
import com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner;
import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;
import com.huawei.wisesecurity.kfs.crypto.signer.SignHandler;
import com.huawei.wisesecurity.kfs.crypto.signer.SignText;
import com.huawei.wisesecurity.kfs.crypto.signer.VerifyHandler;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: classes3.dex */
public class RSASigner implements KfsSigner {
    private final AlgorithmParameterSpec parameterSpec;
    private final PrivateKey privateKey;
    private final KeyStoreProvider provider;
    private final PublicKey publicKey;
    private final SignAlg signAlg;

    public static class Builder extends AsymmetricSignerBuilder<RSASigner> {
        public Builder(KeyStoreProvider keyStoreProvider) {
            super(keyStoreProvider);
            withAlg(SignAlg.getPreferredAlg("RSA"));
        }

        @Override // com.huawei.wisesecurity.kfs.crypto.AsymmetricBuilder
        public RSASigner build() throws CryptoException {
            return new RSASigner(this.keyStoreProvider, this.signAlg, this.privateKey, this.publicKey, this.parameterSpec);
        }
    }

    private RSASigner(KeyStoreProvider keyStoreProvider, SignAlg signAlg, PrivateKey privateKey, PublicKey publicKey, AlgorithmParameterSpec algorithmParameterSpec) {
        this.provider = keyStoreProvider;
        this.signAlg = signAlg;
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        this.parameterSpec = algorithmParameterSpec;
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner
    public SignHandler getSignHandler() throws CryptoException {
        SignText signText = new SignText();
        signText.setAlgId(this.signAlg);
        PrivateKey privateKey = this.privateKey;
        if (privateKey != null) {
            return new DefaultSignHandler(this.provider, privateKey, signText, this.parameterSpec);
        }
        throw new CryptoException("privateKey is invalid.");
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner
    public VerifyHandler getVerifyHandler() throws CryptoException {
        SignText signText = new SignText();
        signText.setAlgId(this.signAlg);
        PublicKey publicKey = this.publicKey;
        if (publicKey != null) {
            return new DefaultVerifyHandler(this.provider, publicKey, signText, this.parameterSpec);
        }
        throw new CryptoException("publicKey is invalid.");
    }
}
