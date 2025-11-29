package com.huawei.wisesecurity.kfs.crypto.key;

import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotBlank;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotNull;

/* loaded from: classes3.dex */
public class KeyGenerateParam {

    @KfsNotNull
    @KfsNotBlank
    private String alias;
    private boolean attestationChallengeEnable;
    private int keyLen;

    @KfsNotNull
    private KfsKeyPurpose purpose;

    public static class Builder {
        private String alias;
        private boolean attestationChallengeEnable = true;
        private int keyLen;
        private KfsKeyPurpose purpose;

        public Builder alias(String str) {
            this.alias = str;
            return this;
        }

        public KeyGenerateParam build() {
            return new KeyGenerateParam(this.alias, this.keyLen, this.purpose, this.attestationChallengeEnable);
        }

        public Builder keyLen(int i) {
            this.keyLen = i;
            return this;
        }

        public Builder purpose(KfsKeyPurpose kfsKeyPurpose) {
            this.purpose = kfsKeyPurpose;
            return this;
        }
    }

    public KeyGenerateParam(String str, int i, KfsKeyPurpose kfsKeyPurpose) {
        this(str, i, kfsKeyPurpose, true);
    }

    public KeyGenerateParam(String str, int i, KfsKeyPurpose kfsKeyPurpose, boolean z) {
        this.alias = str;
        this.keyLen = i;
        this.purpose = kfsKeyPurpose;
        this.attestationChallengeEnable = z;
    }

    public String getAlias() {
        return this.alias;
    }

    public int getKeyLen() {
        return this.keyLen;
    }

    public KfsKeyPurpose getPurpose() {
        return this.purpose;
    }

    public boolean isAttestationChallengeEnable() {
        return this.attestationChallengeEnable;
    }
}
