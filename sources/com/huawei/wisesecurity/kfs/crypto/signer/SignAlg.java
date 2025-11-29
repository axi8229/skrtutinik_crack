package com.huawei.wisesecurity.kfs.crypto.signer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import ru.yoomoney.sdk.auth.utils.CipherChaCha20Poly1305Kt;

/* loaded from: classes3.dex */
public enum SignAlg {
    UNKNOWN("UNKNOWN", "UNKNOWN"),
    ECDSA("EC", "SHA256WithECDSA"),
    RSA_SHA256("RSA_SHA256", "SHA256WithRSA"),
    RSA_SHA256_PSS("RSA_SHA256_PSS", "SHA256withRSA/PSS"),
    HMAC_SHA256(CipherChaCha20Poly1305Kt.HASHING_ALGORITHM_HMAC_SHA_256, CipherChaCha20Poly1305Kt.HASHING_ALGORITHM_HMAC_SHA_256);

    private static final Map<String, String> MAPPING = new HashMap();
    private static final Map<String, SignAlg> PREFERRED_ALGS = new HashMap();
    private final String alg;
    private final String keyType;

    static {
        Iterator it = EnumSet.allOf(SignAlg.class).iterator();
        while (it.hasNext()) {
            SignAlg signAlg = (SignAlg) it.next();
            MAPPING.put(signAlg.keyType, signAlg.alg);
        }
        Map<String, SignAlg> map = PREFERRED_ALGS;
        map.put("EC", ECDSA);
        map.put("RSA", RSA_SHA256);
        map.put("HMAC", HMAC_SHA256);
    }

    SignAlg(String str, String str2) {
        this.keyType = str;
        this.alg = str2;
    }

    public static SignAlg getPreferredAlg(String str) {
        return PREFERRED_ALGS.get(str);
    }

    public String getTransformation() {
        return this.alg;
    }
}
