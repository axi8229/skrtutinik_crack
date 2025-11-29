package com.huawei.wisesecurity.ucs.credential.crypto.signer;

import com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotNull;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs_credential.f;

/* loaded from: classes3.dex */
public class CredentialSigner implements KfsSigner {
    private Credential credential;
    private CredentialClient credentialClient;
    private CredentialSignText signText;

    public static class Builder {

        @KfsNotNull
        private Credential credential;

        @KfsNotNull
        private CredentialClient credentialClient;

        @KfsNotNull
        private CredentialSignAlg signAlg = CredentialSignAlg.HMAC_SHA256;

        public CredentialSigner build() throws UcsException {
            try {
                KfsValidator.validate(this);
                return new CredentialSigner(this.signAlg, this.credential, this.credentialClient);
            } catch (KfsValidationException e) {
                StringBuilder sbA = f.a("CredentialCipher check param error : ");
                sbA.append(e.getMessage());
                throw new UcsParamException(sbA.toString());
            }
        }

        public Builder withAlg(CredentialSignAlg credentialSignAlg) {
            this.signAlg = credentialSignAlg;
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
    }

    private CredentialSigner(CredentialSignAlg credentialSignAlg, Credential credential, CredentialClient credentialClient) {
        this.credential = credential;
        CredentialSignText credentialSignText = new CredentialSignText();
        this.signText = credentialSignText;
        credentialSignText.setAlgId(credentialSignAlg);
        this.credentialClient = credentialClient;
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner
    public CredentialSignHandler getSignHandler() {
        return new CredentialSignHandler(this.credential, this.signText, this.credentialClient);
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner
    public CredentialVerifyHandler getVerifyHandler() {
        return new CredentialVerifyHandler(this.credential, this.signText, this.credentialClient);
    }
}
