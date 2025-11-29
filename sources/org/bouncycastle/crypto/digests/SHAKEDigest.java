package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.Xof;

/* loaded from: classes4.dex */
public class SHAKEDigest extends KeccakDigest implements Xof {
    public SHAKEDigest(int i) {
        super(checkBitLength(i));
    }

    private static int checkBitLength(int i) {
        if (i == 128 || i == 256) {
            return i;
        }
        throw new IllegalArgumentException("'bitLength' " + i + " not supported for SHAKE");
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        return doFinal(bArr, i, getDigestSize());
    }

    @Override // org.bouncycastle.crypto.Xof
    public int doFinal(byte[] bArr, int i, int i2) {
        int iDoOutput = doOutput(bArr, i, i2);
        reset();
        return iDoOutput;
    }

    public int doOutput(byte[] bArr, int i, int i2) {
        if (!this.squeezing) {
            absorbBits(15, 4);
        }
        squeeze(bArr, i, i2 * 8);
        return i2;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHAKE" + this.fixedOutputLength;
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.fixedOutputLength / 4;
    }
}
