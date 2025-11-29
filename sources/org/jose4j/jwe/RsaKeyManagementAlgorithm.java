package org.jose4j.jwe;

import java.security.spec.MGF1ParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ExceptionHelp;
import org.jose4j.lang.JoseException;

/* loaded from: classes4.dex */
public class RsaKeyManagementAlgorithm extends WrappingKeyManagementAlgorithm implements KeyManagementAlgorithm {
    public RsaKeyManagementAlgorithm(String str, String str2) {
        super(str, str2);
        setKeyType("RSA");
        setKeyPersuasion(KeyPersuasion.ASYMMETRIC);
    }

    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() {
        try {
            return CipherUtil.getCipher(getJavaAlgorithm(), null) != null;
        } catch (JoseException unused) {
            return false;
        }
    }

    public static class RsaOaep extends RsaKeyManagementAlgorithm implements KeyManagementAlgorithm {
        public RsaOaep() {
            super("RSA/ECB/OAEPWithSHA-1AndMGF1Padding", "RSA-OAEP");
        }
    }

    public static class RsaOaep256 extends RsaKeyManagementAlgorithm implements KeyManagementAlgorithm {
        public RsaOaep256() {
            super("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", "RSA-OAEP-256");
            setAlgorithmParameterSpec(new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        }

        @Override // org.jose4j.jwe.RsaKeyManagementAlgorithm, org.jose4j.jwa.Algorithm
        public boolean isAvailable() {
            try {
                return manageForEncrypt(JsonWebKey.Factory.newJwk("{\"kty\":\"RSA\",\"n\":\"sXchDaQebHnPiGvyDOAT4saGEUetSyo9MKLOoWFsueri23bOdgWp4Dy1WlUzewbgBHod5pcM9H95GQRV3JDXboIRROSBigeC5yjU1hGzHHyXss8UDprecbAYxknTcQkhslANGRUZmdTOQ5qTRsLAt6BTYuyvVRdhS8exSZEy_c4gs_7svlJJQ4H9_NxsiIoLwAEk7-Q3UXERGYw_75IDrGA84-lA_-Ct4eTlXHBIY2EaV7t7LjJaynVJCpkv4LKjTTAumiGUIuQhrNhZLuF_RJLqHpM2kgWFLU7-VTdL1VbC2tejvcI2BlMkEpk1BzBZI0KQB0GaDWFLN-aEAw3vRw\",\"e\":\"AQAB\"}").getKey(), new ContentEncryptionKeyDescriptor(16, "AES"), null, null, new ProviderContext()) != null;
            } catch (JoseException e) {
                ((WrappingKeyManagementAlgorithm) this).log.debug(getAlgorithmIdentifier() + " is not available due to " + ExceptionHelp.toStringWithCauses(e));
                return false;
            }
        }
    }

    public static class Rsa1_5 extends RsaKeyManagementAlgorithm implements KeyManagementAlgorithm {
        public Rsa1_5() {
            super("RSA/ECB/PKCS1Padding", "RSA1_5");
        }
    }
}
