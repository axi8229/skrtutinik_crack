package com.huawei.wisesecurity.ucs.credential.entity;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotNull;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;
import com.huawei.wisesecurity.ucs_credential.f;

/* loaded from: classes3.dex */
public class EcKeyPair {
    public byte[] privateKey;
    public byte[] publicKey;

    public static final class Builder {

        @KfsNotNull
        private byte[] privateKey;

        @KfsNotNull
        private byte[] publicKey;

        private Builder() {
        }

        public EcKeyPair build() throws UcsException {
            try {
                KfsValidator.validate(this);
                return new EcKeyPair(this);
            } catch (KfsValidationException e) {
                StringBuilder sbA = f.a("EcKeyPair build check param error : ");
                sbA.append(e.getMessage());
                throw new UcsParamException(sbA.toString());
            }
        }

        public Builder privateKey(byte[] bArr) {
            this.privateKey = bArr;
            return this;
        }

        public Builder publicKey(byte[] bArr) {
            this.publicKey = bArr;
            return this;
        }
    }

    private EcKeyPair(Builder builder) {
        this.publicKey = builder.publicKey;
        this.privateKey = builder.privateKey;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public byte[] getPrivateKey() {
        return this.privateKey;
    }

    public byte[] getPublicKey() {
        return this.publicKey;
    }
}
