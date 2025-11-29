package com.huawei.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public final class AesCbc {
    private static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.b("CBC", "encrypt 5 content is null");
            return new byte[0];
        }
        if (bArr == null) {
            b.b("CBC", "encrypt 5 key is null");
            return new byte[0];
        }
        if (bArr.length < 16) {
            b.b("CBC", "encrypt 5 key error: 5 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr2 == null) {
            b.b("CBC", "encrypt 5 iv is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            b.b("CBC", "encrypt 5 iv error: 5 iv length less than 16 bytes.");
            return new byte[0];
        }
        try {
            return encrypt(str.getBytes("UTF-8"), bArr, bArr2);
        } catch (UnsupportedEncodingException e) {
            b.b("CBC", " cbc encrypt data error" + e.getMessage());
            return new byte[0];
        }
    }

    public static String decrypt(String str, String str2) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            b.b("CBC", "decrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            b.b("CBC", "decrypt 1 key is null");
            return "";
        }
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        if (bArrHexStr2ByteArray.length >= 16) {
            return decrypt(str, bArrHexStr2ByteArray);
        }
        b.b("CBC", "decrypt 1 key error: 1 key length less than 16 bytes.");
        return "";
    }

    public static String encrypt(String str, String str2) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            b.b("CBC", "encrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            b.b("CBC", "encrypt 1 key is null");
            return "";
        }
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        if (bArrHexStr2ByteArray.length >= 16) {
            return encrypt(str, bArrHexStr2ByteArray);
        }
        b.b("CBC", "encrypt 1 key error: 1 key length less than 16 bytes.");
        return "";
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(6, 12) + str.substring(16, 26) + str.substring(32, 48);
        } catch (Exception e) {
            b.b("CBC", "getIv exception : " + e.getMessage());
            return "";
        }
    }

    public static String decrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            b.b("CBC", "decrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            b.b("CBC", "decrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            b.b("CBC", "decrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        String strB = b(str);
        String strA = a(str);
        if (TextUtils.isEmpty(strB)) {
            b.b("CBC", "decrypt 2 iv is null");
            return "";
        }
        if (TextUtils.isEmpty(strA)) {
            b.b("CBC", "decrypt 2 encrypt content is null");
            return "";
        }
        return decrypt(strA, bArr, HexUtil.hexStr2ByteArray(strB));
    }

    public static String encrypt(String str, byte[] bArr) throws NoSuchAlgorithmException {
        if (TextUtils.isEmpty(str)) {
            b.b("CBC", "encrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            b.b("CBC", "encrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            b.b("CBC", "encrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        byte[] bArrGenerateSecureRandom = EncryptUtil.generateSecureRandom(16);
        byte[] bArrA = a(str, bArr, bArrGenerateSecureRandom);
        return (bArrA == null || bArrA.length == 0) ? "" : a(HexUtil.byteArray2HexStr(bArrGenerateSecureRandom), HexUtil.byteArray2HexStr(bArrA));
    }

    private static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return str2.substring(0, 6) + str.substring(0, 6) + str2.substring(6, 10) + str.substring(6, 16) + str2.substring(10, 16) + str.substring(16) + str2.substring(16);
            } catch (Exception e) {
                b.b("CBC", "mix exception: " + e.getMessage());
            }
        }
        return "";
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(0, 6) + str.substring(12, 16) + str.substring(26, 32) + str.substring(48);
        } catch (Exception e) {
            b.b("CBC", "get encryptword exception : " + e.getMessage());
            return "";
        }
    }

    public static String decrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.b("CBC", "decrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            b.b("CBC", "decrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            b.b("CBC", "decrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            b.b("CBC", "decrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 16) {
            b.b("CBC", "decrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        }
        try {
            return new String(decrypt(HexUtil.hexStr2ByteArray(str), bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            b.b("CBC", " cbc decrypt data error" + e.getMessage());
            return "";
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (bArr == null) {
            b.b("CBC", "encrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            b.b("CBC", "encrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            b.b("CBC", "encrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            b.b("CBC", "encrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            b.b("CBC", "encrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 16) {
            b.b("CBC", "encrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e) {
            b.b("CBC", "NullPointerException: " + e.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e2) {
            b.b("CBC", "InvalidAlgorithmParameterException: " + e2.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e3) {
            b.b("CBC", "InvalidKeyException: " + e3.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e4) {
            b.b("CBC", "NoSuchAlgorithmException: " + e4.getMessage());
            return new byte[0];
        } catch (BadPaddingException e5) {
            b.b("CBC", "BadPaddingException: " + e5.getMessage());
            return new byte[0];
        } catch (IllegalBlockSizeException e6) {
            b.b("CBC", "IllegalBlockSizeException: " + e6.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e7) {
            b.b("CBC", "NoSuchPaddingException: " + e7.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (bArr == null) {
            b.b("CBC", "decrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            b.b("CBC", "decrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            b.b("CBC", "decrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            b.b("CBC", "decrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            b.b("CBC", "decrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 16) {
            b.b("CBC", "decrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e) {
            b.b("CBC", "NullPointerException: " + e.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e2) {
            b.b("CBC", "InvalidAlgorithmParameterException: " + e2.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e3) {
            b.b("CBC", "InvalidKeyException: " + e3.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e4) {
            b.b("CBC", "NoSuchAlgorithmException: " + e4.getMessage());
            return new byte[0];
        } catch (BadPaddingException e5) {
            b.b("CBC", "BadPaddingException: " + e5.getMessage());
            b.b("CBC", "key is not right");
            return new byte[0];
        } catch (IllegalBlockSizeException e6) {
            b.b("CBC", "IllegalBlockSizeException: " + e6.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e7) {
            b.b("CBC", "NoSuchPaddingException: " + e7.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException {
        byte[] bArrGenerateSecureRandom = EncryptUtil.generateSecureRandom(16);
        return a(bArrGenerateSecureRandom, encrypt(bArr, bArr2, bArrGenerateSecureRandom));
    }
}
