package org.bouncycastle.crypto.prng.drbg;

import java.util.Hashtable;
import org.bouncycastle.util.Integers;

/* loaded from: classes4.dex */
class Utils {
    static final Hashtable maxSecurityStrengths;

    static {
        Hashtable hashtable = new Hashtable();
        maxSecurityStrengths = hashtable;
        hashtable.put("SHA-1", Integers.valueOf(128));
        hashtable.put("SHA-224", Integers.valueOf(192));
        hashtable.put("SHA-256", Integers.valueOf(256));
        hashtable.put("SHA-384", Integers.valueOf(256));
        hashtable.put("SHA-512", Integers.valueOf(256));
        hashtable.put("SHA-512/224", Integers.valueOf(192));
        hashtable.put("SHA-512/256", Integers.valueOf(256));
    }

    static boolean isTooLarge(byte[] bArr, int i) {
        return bArr != null && bArr.length > i;
    }
}
