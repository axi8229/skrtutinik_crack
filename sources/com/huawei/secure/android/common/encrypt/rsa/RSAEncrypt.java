package com.huawei.secure.android.common.encrypt.rsa;

import com.huawei.secure.android.common.encrypt.utils.b;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes3.dex */
public abstract class RSAEncrypt {
    public static boolean isPublicKeyLengthRight(RSAPublicKey rSAPublicKey) {
        return rSAPublicKey != null && rSAPublicKey.getModulus().bitLength() >= 2048;
    }

    public static byte[] encrypt(byte[] bArr, PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] bArr2 = new byte[0];
        if (bArr != null && publicKey != null && isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
                cipher.init(1, publicKey);
                return cipher.doFinal(bArr);
            } catch (GeneralSecurityException e) {
                b.b("RSAEncrypt", "RSA encrypt exception : " + e.getMessage());
                return bArr2;
            }
        }
        b.b("RSAEncrypt", "content or PublicKey is null , or length is too short");
        return bArr2;
    }
}
