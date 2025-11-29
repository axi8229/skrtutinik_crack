package com.huawei.wisesecurity.kfs.crypto.cipher;

import com.huawei.hms.android.SystemUtils;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public enum CipherAlg {
    UNKNOWN((byte) -1, SystemUtils.UNKNOWN, 0),
    AES_CBC((byte) 0, "AES/CBC/PKCS5Padding", 16),
    KEY_STORE_AES_CBC((byte) 0, "AES/CBC/PKCS7Padding", 16),
    AES_GCM((byte) 1, "AES/GCM/NoPadding", 12),
    RSA_OAEP((byte) 16, "RSA/ECB/OAEPWithSHA-256AndMGF1Padding", 0),
    ECIES((byte) 32, "ECIESwithAES/NONE/PKCS7Padding", 0),
    ECIES_CBC((byte) 33, "ECIESwithAES-CBC/NONE/PKCS7Padding", 0);

    private static final Map<Byte, CipherAlg> MAPPING = new HashMap();
    private static final Map<String, CipherAlg> PREFERRED_ALGS = new HashMap();
    private final byte id;
    private final int ivLen;
    private final String transformation;

    static {
        Iterator it = EnumSet.allOf(CipherAlg.class).iterator();
        while (it.hasNext()) {
            CipherAlg cipherAlg = (CipherAlg) it.next();
            MAPPING.put(Byte.valueOf(cipherAlg.id), cipherAlg);
        }
        Map<String, CipherAlg> map = PREFERRED_ALGS;
        map.put("EC", ECIES);
        map.put("RSA", RSA_OAEP);
        map.put("AES", AES_GCM);
    }

    CipherAlg(byte b, String str, int i) {
        this.id = b;
        this.transformation = str;
        this.ivLen = i;
    }

    public static CipherAlg getPreferredAlg(String str) {
        return PREFERRED_ALGS.get(str);
    }

    public int getIvLen() {
        return this.ivLen;
    }

    public String getTransformation() {
        return this.transformation;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.transformation;
    }
}
