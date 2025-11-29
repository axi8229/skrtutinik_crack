package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Pack;

/* loaded from: classes4.dex */
class LM_OTS {
    static byte[] lms_ots_generatePublicKey(LMOtsParameters lMOtsParameters, byte[] bArr, int i, byte[] bArr2) {
        Digest digest = DigestUtil.getDigest(lMOtsParameters.getDigestOID());
        byte[] bArrBuild = Composer.compose().bytes(bArr).u32str(i).u16str(-32640).padUntil(0, 22).build();
        digest.update(bArrBuild, 0, bArrBuild.length);
        Digest digest2 = DigestUtil.getDigest(lMOtsParameters.getDigestOID());
        byte[] bArrBuild2 = Composer.compose().bytes(bArr).u32str(i).padUntil(0, digest2.getDigestSize() + 23).build();
        SeedDerive seedDerive = new SeedDerive(bArr, bArr2, DigestUtil.getDigest(lMOtsParameters.getDigestOID()));
        seedDerive.setQ(i);
        seedDerive.setJ(0);
        int p = lMOtsParameters.getP();
        int n = lMOtsParameters.getN();
        int w = (1 << lMOtsParameters.getW()) - 1;
        int i2 = 0;
        while (i2 < p) {
            seedDerive.deriveSeed(bArrBuild2, i2 < p + (-1), 23);
            Pack.shortToBigEndian((short) i2, bArrBuild2, 20);
            for (int i3 = 0; i3 < w; i3++) {
                bArrBuild2[22] = (byte) i3;
                digest2.update(bArrBuild2, 0, bArrBuild2.length);
                digest2.doFinal(bArrBuild2, 23);
            }
            digest.update(bArrBuild2, 23, n);
            i2++;
        }
        byte[] bArr3 = new byte[digest.getDigestSize()];
        digest.doFinal(bArr3, 0);
        return bArr3;
    }
}
