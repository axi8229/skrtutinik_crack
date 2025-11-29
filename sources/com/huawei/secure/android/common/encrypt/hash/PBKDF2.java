package com.huawei.secure.android.common.encrypt.hash;

import android.os.Build;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/* loaded from: classes3.dex */
public abstract class PBKDF2 {
    private static final String a = "PBKDF2";

    private static byte[] a(char[] cArr, byte[] bArr, int i, int i2, boolean z) {
        try {
            return (z ? SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256") : SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")).generateSecret(new PBEKeySpec(cArr, bArr, i, i2)).getEncoded();
        } catch (NoSuchAlgorithmException e) {
            e = e;
            b.b(a, "pbkdf exception : " + e.getMessage());
            return new byte[0];
        } catch (InvalidKeySpecException e2) {
            e = e2;
            b.b(a, "pbkdf exception : " + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] pbkdf2(char[] cArr, byte[] bArr, int i, int i2) {
        return a(cArr, bArr, i, i2, false);
    }

    public static byte[] pbkdf2SHA256(char[] cArr, byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[0];
        if (Build.VERSION.SDK_INT >= 26) {
            return a(cArr, bArr, i, i2, true);
        }
        b.b(a, "system version not high than 26");
        return bArr2;
    }
}
