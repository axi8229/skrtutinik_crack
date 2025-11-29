package com.huawei.wisesecurity.kfs.crypto.signer.hmac;

import com.huawei.wisesecurity.kfs.crypto.key.KeyStoreProvider;
import com.huawei.wisesecurity.kfs.crypto.signer.DefaultSignHandler;
import com.huawei.wisesecurity.kfs.crypto.signer.DefaultVerifyHandler;
import com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner;
import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;
import com.huawei.wisesecurity.kfs.crypto.signer.SignHandler;
import com.huawei.wisesecurity.kfs.crypto.signer.SignText;
import com.huawei.wisesecurity.kfs.crypto.signer.VerifyHandler;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class HmacSigner implements KfsSigner {
    private final Key key;
    private final KeyStoreProvider provider;
    private final SignAlg signAlg;

    public static class Builder {
        private Key key;
        private SignAlg signAlg = SignAlg.getPreferredAlg("HMAC");
        private final KeyStoreProvider keyStoreProvider = KeyStoreProvider.ANDROID_KEYSTORE;

        public HmacSigner build() throws CryptoException {
            Key key = this.key;
            if (key != null) {
                return new HmacSigner(this.keyStoreProvider, this.signAlg, key);
            }
            throw new CryptoException("key cannot be null");
        }

        public Builder withAlg(SignAlg signAlg) {
            this.signAlg = signAlg;
            return this;
        }

        public Builder withKey(byte[] bArr) {
            this.key = new SecretKeySpec(bArr, this.signAlg.getTransformation());
            return this;
        }
    }

    private HmacSigner(KeyStoreProvider keyStoreProvider, SignAlg signAlg, Key key) {
        this.provider = keyStoreProvider;
        this.signAlg = signAlg;
        this.key = key;
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner
    public SignHandler getSignHandler() throws CryptoException {
        SignText signText = new SignText();
        signText.setAlgId(this.signAlg);
        return new DefaultSignHandler(this.provider, this.key, signText, null);
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner
    public VerifyHandler getVerifyHandler() throws CryptoException {
        SignText signText = new SignText();
        signText.setAlgId(this.signAlg);
        return new DefaultVerifyHandler(this.provider, this.key, signText, null);
    }
}
