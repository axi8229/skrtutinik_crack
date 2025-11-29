package com.huawei.wisesecurity.ucs.credential.crypto.cipher;

import com.huawei.wisesecurity.kfs.crypto.cipher.KfsCipher;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.util.ByteUtil;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotNull;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs_credential.f;

/* loaded from: classes3.dex */
public class CredentialCipher implements KfsCipher {
    public CredentialCipherText cipherText;
    private Credential credential;
    private CredentialClient credentialClient;

    public static class Builder {

        @KfsNotNull
        private CredentialCipherAlg cipherAlg = CredentialCipherAlg.AES_GCM;

        @KfsNotNull
        private Credential credential;

        @KfsNotNull
        private CredentialClient credentialClient;

        @KfsNotNull
        private byte[] iv;

        public CredentialCipher build() throws UcsException {
            try {
                KfsValidator.validate(this);
                return new CredentialCipher(this.cipherAlg, this.credential, this.iv, this.credentialClient);
            } catch (KfsValidationException e) {
                StringBuilder sbA = f.a("CredentialCipher check param error : ");
                sbA.append(e.getMessage());
                throw new UcsParamException(sbA.toString());
            }
        }

        public Builder withAlg(CredentialCipherAlg credentialCipherAlg) {
            this.cipherAlg = credentialCipherAlg;
            return this;
        }

        public Builder withCredential(Credential credential) {
            this.credential = credential;
            return this;
        }

        public Builder withCredentialClient(CredentialClient credentialClient) {
            this.credentialClient = credentialClient;
            return this;
        }

        public Builder withIv(byte[] bArr) {
            this.iv = ByteUtil.clone(bArr);
            return this;
        }
    }

    public CredentialCipher(CredentialCipherAlg credentialCipherAlg, Credential credential, byte[] bArr, CredentialClient credentialClient) {
        this.credential = credential;
        CredentialCipherText credentialCipherText = new CredentialCipherText();
        credentialCipherText.setAlgId(credentialCipherAlg);
        credentialCipherText.setIv(bArr);
        this.cipherText = credentialCipherText;
        this.credentialClient = credentialClient;
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.cipher.KfsCipher
    public CredentialDecryptHandler getDecryptHandler() {
        return new CredentialDecryptHandler(this.credential, this.cipherText, this.credentialClient);
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.cipher.KfsCipher
    public CredentialEncryptHandler getEncryptHandler() {
        return new CredentialEncryptHandler(this.credential, this.cipherText, this.credentialClient);
    }
}
