package org.jose4j.lang;

import java.io.UnsupportedEncodingException;

/* loaded from: classes4.dex */
public class StringUtil {
    public static String newStringUtf8(byte[] bArr) {
        return newString(bArr, "UTF-8");
    }

    public static String newString(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException unused) {
            throw newISE(str);
        }
    }

    public static byte[] getBytesUtf8(String str) {
        return getBytesUnchecked(str, "UTF-8");
    }

    public static byte[] getBytesAscii(String str) {
        return getBytesUnchecked(str, "US-ASCII");
    }

    public static byte[] getBytesUnchecked(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            throw newISE(str2);
        }
    }

    private static IllegalStateException newISE(String str) {
        return new IllegalStateException("Unknown or unsupported character set name: " + str);
    }
}
