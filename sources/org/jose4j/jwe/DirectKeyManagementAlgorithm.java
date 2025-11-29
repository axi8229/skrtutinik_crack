package org.jose4j.jwe;

import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.keys.KeyPersuasion;

/* loaded from: classes4.dex */
public class DirectKeyManagementAlgorithm extends AlgorithmInfo implements KeyManagementAlgorithm {
    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() {
        return true;
    }

    public DirectKeyManagementAlgorithm() {
        setAlgorithmIdentifier("dir");
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        setKeyType("oct");
    }
}
