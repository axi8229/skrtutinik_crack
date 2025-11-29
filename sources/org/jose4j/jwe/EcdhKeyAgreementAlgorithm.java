package org.jose4j.jwe;

import org.jose4j.jwa.AlgorithmAvailability;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.keys.EcKeyUtil;
import org.jose4j.keys.KeyPersuasion;

/* loaded from: classes4.dex */
public class EcdhKeyAgreementAlgorithm extends AlgorithmInfo implements KeyManagementAlgorithm {
    String algorithmIdHeaderName;

    public EcdhKeyAgreementAlgorithm() {
        this.algorithmIdHeaderName = "enc";
        setAlgorithmIdentifier("ECDH-ES");
        setJavaAlgorithm("ECDH");
        setKeyType("EC");
        setKeyPersuasion(KeyPersuasion.ASYMMETRIC);
    }

    public EcdhKeyAgreementAlgorithm(String str) {
        this();
        this.algorithmIdHeaderName = str;
    }

    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() {
        return new EcKeyUtil().isAvailable() && AlgorithmAvailability.isAvailable("KeyAgreement", getJavaAlgorithm());
    }
}
