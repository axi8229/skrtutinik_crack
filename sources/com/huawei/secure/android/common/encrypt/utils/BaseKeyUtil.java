package com.huawei.secure.android.common.encrypt.utils;

import android.annotation.SuppressLint;
import com.huawei.secure.android.common.encrypt.hash.PBKDF2;
import java.io.UnsupportedEncodingException;

/* loaded from: classes3.dex */
public class BaseKeyUtil {
    private static final String a = "BaseKeyUtil";

    private static int a(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    private static boolean a(int i) {
        return i >= 16;
    }

    private static boolean a(int i, byte[] bArr) {
        return a(i) & a(bArr);
    }

    @SuppressLint({"NewApi"})
    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 16, z);
    }

    @SuppressLint({"NewApi"})
    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, int i, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 10000, i, z);
    }

    private static boolean a(byte[] bArr) {
        return bArr.length >= 16;
    }

    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, int i, int i2, boolean z) throws UnsupportedEncodingException {
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        byte[] bArrHexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str2);
        byte[] bArrHexStr2ByteArray3 = HexUtil.hexStr2ByteArray(str3);
        int iA = a(bArrHexStr2ByteArray.length, bArrHexStr2ByteArray2.length, bArrHexStr2ByteArray3.length);
        if (a(iA, bArr)) {
            char[] cArr = new char[iA];
            for (int i3 = 0; i3 < iA; i3++) {
                cArr[i3] = (char) ((bArrHexStr2ByteArray[i3] ^ bArrHexStr2ByteArray2[i3]) ^ bArrHexStr2ByteArray3[i3]);
            }
            if (!z) {
                b.c(a, "exportRootKey: sha1");
                return PBKDF2.pbkdf2(cArr, bArr, i, i2 * 8);
            }
            b.c(a, "exportRootKey: sha256");
            return PBKDF2.pbkdf2SHA256(cArr, bArr, i, i2 * 8);
        }
        throw new IllegalArgumentException("key length must be more than 128bit.");
    }

    public static byte[] exportRootKey(String str, String str2, String str3, String str4, int i, boolean z) {
        return exportRootKey(str, str2, str3, HexUtil.hexStr2ByteArray(str4), i, z);
    }
}
