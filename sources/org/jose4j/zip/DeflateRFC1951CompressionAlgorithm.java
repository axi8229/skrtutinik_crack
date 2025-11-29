package org.jose4j.zip;

/* loaded from: classes4.dex */
public class DeflateRFC1951CompressionAlgorithm implements CompressionAlgorithm {
    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() {
        return true;
    }

    @Override // org.jose4j.jwa.Algorithm
    public String getAlgorithmIdentifier() {
        return "DEF";
    }
}
