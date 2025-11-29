package org.jose4j.jwe;

import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.jwe.AesKeyWrapManagementAlgorithm;
import org.jose4j.keys.KeyPersuasion;

/* loaded from: classes4.dex */
public class EcdhKeyAgreementWithAesKeyWrapAlgorithm extends AlgorithmInfo implements KeyManagementAlgorithm {
    private EcdhKeyAgreementAlgorithm ecdh;
    private AesKeyWrapManagementAlgorithm keyWrap;
    private ContentEncryptionKeyDescriptor keyWrapKeyDescriptor;

    public EcdhKeyAgreementWithAesKeyWrapAlgorithm(String str, AesKeyWrapManagementAlgorithm aesKeyWrapManagementAlgorithm) {
        setAlgorithmIdentifier(str);
        setJavaAlgorithm("N/A");
        setKeyType("EC");
        setKeyPersuasion(KeyPersuasion.ASYMMETRIC);
        this.keyWrap = aesKeyWrapManagementAlgorithm;
        this.ecdh = new EcdhKeyAgreementAlgorithm("alg");
        this.keyWrapKeyDescriptor = new ContentEncryptionKeyDescriptor(aesKeyWrapManagementAlgorithm.getKeyByteLength(), "AES");
    }

    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() {
        return this.ecdh.isAvailable() && this.keyWrap.isAvailable();
    }

    public static class EcdhKeyAgreementWithAes128KeyWrapAlgorithm extends EcdhKeyAgreementWithAesKeyWrapAlgorithm implements KeyManagementAlgorithm {
        public EcdhKeyAgreementWithAes128KeyWrapAlgorithm() {
            super("ECDH-ES+A128KW", new AesKeyWrapManagementAlgorithm.Aes128().setUseGeneralProviderContext());
        }
    }

    public static class EcdhKeyAgreementWithAes192KeyWrapAlgorithm extends EcdhKeyAgreementWithAesKeyWrapAlgorithm implements KeyManagementAlgorithm {
        public EcdhKeyAgreementWithAes192KeyWrapAlgorithm() {
            super("ECDH-ES+A192KW", new AesKeyWrapManagementAlgorithm.Aes192().setUseGeneralProviderContext());
        }
    }

    public static class EcdhKeyAgreementWithAes256KeyWrapAlgorithm extends EcdhKeyAgreementWithAesKeyWrapAlgorithm implements KeyManagementAlgorithm {
        public EcdhKeyAgreementWithAes256KeyWrapAlgorithm() {
            super("ECDH-ES+A256KW", new AesKeyWrapManagementAlgorithm.Aes256().setUseGeneralProviderContext());
        }
    }
}
