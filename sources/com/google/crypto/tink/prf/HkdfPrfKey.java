package com.google.crypto.tink.prf;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;

@Alpha
/* loaded from: classes2.dex */
public final class HkdfPrfKey extends PrfKey {
    private final SecretBytes keyBytes;
    private final HkdfPrfParameters parameters;

    @Override // com.google.crypto.tink.Key
    public Integer getIdRequirementOrNull() {
        return null;
    }

    public static final class Builder {
        private SecretBytes keyBytes;
        private HkdfPrfParameters parameters;

        private Builder() {
            this.parameters = null;
            this.keyBytes = null;
        }

        public Builder setParameters(HkdfPrfParameters parameters) {
            this.parameters = parameters;
            return this;
        }

        public Builder setKeyBytes(SecretBytes keyBytes) {
            this.keyBytes = keyBytes;
            return this;
        }

        public HkdfPrfKey build() throws GeneralSecurityException {
            HkdfPrfParameters hkdfPrfParameters = this.parameters;
            if (hkdfPrfParameters == null || this.keyBytes == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (hkdfPrfParameters.getKeySizeBytes() != this.keyBytes.size()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            return new HkdfPrfKey(this.parameters, this.keyBytes);
        }
    }

    private HkdfPrfKey(HkdfPrfParameters parameters, SecretBytes keyBytes) {
        this.parameters = parameters;
        this.keyBytes = keyBytes;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    @Override // com.google.crypto.tink.prf.PrfKey, com.google.crypto.tink.Key
    public HkdfPrfParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if (!(o instanceof HkdfPrfKey)) {
            return false;
        }
        HkdfPrfKey hkdfPrfKey = (HkdfPrfKey) o;
        return hkdfPrfKey.parameters.equals(this.parameters) && hkdfPrfKey.keyBytes.equalsSecretBytes(this.keyBytes);
    }
}
