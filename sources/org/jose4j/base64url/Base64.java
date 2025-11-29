package org.jose4j.base64url;

/* loaded from: classes4.dex */
public class Base64 {
    public static String encode(byte[] bArr) {
        return getCodec().encodeToString(bArr);
    }

    public static byte[] decode(String str) {
        return getCodec().decode(str);
    }

    private static org.jose4j.base64url.internal.apache.commons.codec.binary.Base64 getCodec() {
        return new org.jose4j.base64url.internal.apache.commons.codec.binary.Base64();
    }
}
