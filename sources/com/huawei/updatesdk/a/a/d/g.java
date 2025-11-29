package com.huawei.updatesdk.a.a.d;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.IllegalFormatException;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class g {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("~", "%7E");
        } catch (UnsupportedEncodingException e) {
            com.huawei.updatesdk.a.a.c.a.a.a.a("StringUtils", "encode2utf8 error", e);
            return null;
        }
    }

    public static String a(byte[] bArr) throws NoSuchAlgorithmException {
        String str;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            StringBuilder sb = new StringBuilder(256);
            for (byte b : messageDigest.digest()) {
                sb.append(String.format(Locale.ENGLISH, "%02X", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            str = "sha256EncryptStr error:NoSuchAlgorithmException";
            com.huawei.updatesdk.a.a.c.a.a.a.b("StringUtils", str);
            return null;
        } catch (IllegalFormatException unused2) {
            str = "sha256EncryptStr error:IllegalFormatException";
            com.huawei.updatesdk.a.a.c.a.a.a.b("StringUtils", str);
            return null;
        } catch (Exception unused3) {
            str = "sha256EncryptStr error:Exception";
            com.huawei.updatesdk.a.a.c.a.a.a.b("StringUtils", str);
            return null;
        }
    }

    public static String b(String str) {
        String strE = e(str);
        if (strE == null) {
            return null;
        }
        return strE.toLowerCase(Locale.getDefault());
    }

    public static byte[] c(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int iDigit = Character.digit(charArray[i2 + 1], 16) | (Character.digit(charArray[i2], 16) << 4);
            if (iDigit > 127) {
                iDigit -= 256;
            }
            bArr[i] = Byte.valueOf(String.valueOf(iDigit)).byteValue();
        }
        return bArr;
    }

    public static boolean d(String str) {
        return str != null && str.trim().startsWith("{") && str.trim().endsWith("}");
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return a(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            com.huawei.updatesdk.a.a.c.a.a.a.b("StringUtils", "can not getBytes");
            return null;
        }
    }
}
