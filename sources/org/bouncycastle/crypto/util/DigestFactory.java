package org.bouncycastle.crypto.util;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.SHAKEDigest;

/* loaded from: classes4.dex */
public final class DigestFactory {
    private static final Map cloneMap;

    static {
        HashMap map = new HashMap();
        cloneMap = map;
        map.put(createMD5().getAlgorithmName(), new Object() { // from class: org.bouncycastle.crypto.util.DigestFactory.1
        });
        map.put(createSHA1().getAlgorithmName(), new Object() { // from class: org.bouncycastle.crypto.util.DigestFactory.2
        });
        map.put(createSHA224().getAlgorithmName(), new Object() { // from class: org.bouncycastle.crypto.util.DigestFactory.3
        });
        map.put(createSHA256().getAlgorithmName(), new Object() { // from class: org.bouncycastle.crypto.util.DigestFactory.4
        });
        map.put(createSHA384().getAlgorithmName(), new Object() { // from class: org.bouncycastle.crypto.util.DigestFactory.5
        });
        map.put(createSHA512().getAlgorithmName(), new Object() { // from class: org.bouncycastle.crypto.util.DigestFactory.6
        });
        map.put(createSHA3_224().getAlgorithmName(), new Object() { // from class: org.bouncycastle.crypto.util.DigestFactory.7
        });
        map.put(createSHA3_256().getAlgorithmName(), new Object() { // from class: org.bouncycastle.crypto.util.DigestFactory.8
        });
        map.put(createSHA3_384().getAlgorithmName(), new Object() { // from class: org.bouncycastle.crypto.util.DigestFactory.9
        });
        map.put(createSHA3_512().getAlgorithmName(), new Object() { // from class: org.bouncycastle.crypto.util.DigestFactory.10
        });
        map.put(createSHAKE128().getAlgorithmName(), new Object() { // from class: org.bouncycastle.crypto.util.DigestFactory.11
        });
        map.put(createSHAKE256().getAlgorithmName(), new Object() { // from class: org.bouncycastle.crypto.util.DigestFactory.12
        });
    }

    public static Digest createMD5() {
        return new MD5Digest();
    }

    public static Digest createSHA1() {
        return new SHA1Digest();
    }

    public static Digest createSHA224() {
        return new SHA224Digest();
    }

    public static Digest createSHA256() {
        return new SHA256Digest();
    }

    public static Digest createSHA384() {
        return new SHA384Digest();
    }

    public static Digest createSHA3_224() {
        return new SHA3Digest(224);
    }

    public static Digest createSHA3_256() {
        return new SHA3Digest(256);
    }

    public static Digest createSHA3_384() {
        return new SHA3Digest(384);
    }

    public static Digest createSHA3_512() {
        return new SHA3Digest(512);
    }

    public static Digest createSHA512() {
        return new SHA512Digest();
    }

    public static Digest createSHAKE128() {
        return new SHAKEDigest(128);
    }

    public static Digest createSHAKE256() {
        return new SHAKEDigest(256);
    }
}
