package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.prng.drbg.CTRSP800DRBG;
import org.bouncycastle.crypto.prng.drbg.SP80090DRBG;

/* loaded from: classes4.dex */
public class SP800SecureRandomBuilder {
    private final EntropySourceProvider entropySourceProvider;
    private byte[] personalizationString;
    private final SecureRandom random;
    private int securityStrength = 256;
    private int entropyBitsRequired = 256;

    private static class CTRDRBGProvider implements DRBGProvider {
        private final BlockCipher blockCipher;
        private final int keySizeInBits;
        private final byte[] nonce;
        private final byte[] personalizationString;
        private final int securityStrength;

        public CTRDRBGProvider(BlockCipher blockCipher, int i, byte[] bArr, byte[] bArr2, int i2) {
            this.blockCipher = blockCipher;
            this.keySizeInBits = i;
            this.nonce = bArr;
            this.personalizationString = bArr2;
            this.securityStrength = i2;
        }

        @Override // org.bouncycastle.crypto.prng.DRBGProvider
        public SP80090DRBG get(EntropySource entropySource) {
            return new CTRSP800DRBG(this.blockCipher, this.keySizeInBits, this.securityStrength, entropySource, this.personalizationString, this.nonce);
        }

        @Override // org.bouncycastle.crypto.prng.DRBGProvider
        public String getAlgorithm() {
            return "CTR-DRBG-" + this.blockCipher.getAlgorithmName() + this.keySizeInBits;
        }
    }

    public SP800SecureRandomBuilder(SecureRandom secureRandom, boolean z) {
        this.random = secureRandom;
        this.entropySourceProvider = new BasicEntropySourceProvider(secureRandom, z);
    }

    public SP800SecureRandom buildCTR(BlockCipher blockCipher, int i, byte[] bArr, boolean z) {
        return new SP800SecureRandom(this.random, this.entropySourceProvider.get(this.entropyBitsRequired), new CTRDRBGProvider(blockCipher, i, bArr, this.personalizationString, this.securityStrength), z);
    }

    public SP800SecureRandomBuilder setEntropyBitsRequired(int i) {
        this.entropyBitsRequired = i;
        return this;
    }
}
