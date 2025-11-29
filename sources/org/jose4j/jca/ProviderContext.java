package org.jose4j.jca;

import java.security.SecureRandom;

/* loaded from: classes4.dex */
public class ProviderContext {
    private SecureRandom secureRandom;
    private Context suppliedKeyProviderContext = new Context();
    private Context generalProviderContext = new Context();

    public static class SignatureAlgorithmOverride {
    }

    public Context getSuppliedKeyProviderContext() {
        return this.suppliedKeyProviderContext;
    }

    public Context getGeneralProviderContext() {
        return this.generalProviderContext;
    }

    public SecureRandom getSecureRandom() {
        return this.secureRandom;
    }

    public class Context {
        private String cipherProvider;
        private String generalProvider;
        private String macProvider;
        private String signatureProvider;

        public SignatureAlgorithmOverride getSignatureAlgorithmOverride() {
            return null;
        }

        public Context() {
        }

        public String getCipherProvider() {
            return select(this.cipherProvider);
        }

        public String getSignatureProvider() {
            return select(this.signatureProvider);
        }

        public String getMacProvider() {
            return select(this.macProvider);
        }

        private String select(String str) {
            return str == null ? this.generalProvider : str;
        }
    }
}
