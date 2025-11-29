package com.huawei.wisesecurity.kfs.crypto.signer.ec;

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

/* loaded from: classes3.dex */
public class ECSigner implements KfsSigner {
    private final PrivateKey privateKey;
    private final KeyStoreProvider provider;
    private final PublicKey publicKey;
    private final SignAlg signAlg;

    public static class Builder extends AsymmetricSignerBuilder<ECSigner> {
        public Builder(KeyStoreProvider keyStoreProvider) {
            super(keyStoreProvider);
            withAlg(SignAlg.getPreferredAlg("EC"));
        }

        @Override // com.huawei.wisesecurity.kfs.crypto.AsymmetricBuilder
        public ECSigner build() throws CryptoException {
            return new ECSigner(this.keyStoreProvider, this.signAlg, this.privateKey, this.publicKey);
        }
    }

    private ECSigner(KeyStoreProvider keyStoreProvider, SignAlg signAlg, PrivateKey privateKey, PublicKey publicKey) {
        this.provider = keyStoreProvider;
        this.signAlg = signAlg;
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner
    public SignHandler getSignHandler() throws CryptoException {
        SignText signText = new SignText();
        signText.setAlgId(this.signAlg);
        PrivateKey privateKey = this.privateKey;
        if (privateKey != null) {
            return new DefaultSignHandler(this.provider, privateKey, signText, null);
        }
        throw new CryptoException("privateKey is invalid.");
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner
    public VerifyHandler getVerifyHandler() throws CryptoException {
        SignText signText = new SignText();
        signText.setAlgId(this.signAlg);
        PublicKey publicKey = this.publicKey;
        if (publicKey != null) {
            return new DefaultVerifyHandler(this.provider, publicKey, signText, null);
        }
        throw new CryptoException("publicKey is invalid.");
    }
}
