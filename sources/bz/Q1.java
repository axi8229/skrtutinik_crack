package bz;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public abstract class Q1 {
    public static final int[] a = {102, 112, 110, 45, 49, 57, 57, 102, 56, 54, 50, 100, 49, 53, 53, 100, 57, 54, 101, 57, 55, 54, 99, 56, 48, 99, 55, 49, 99, 100, 99, 51, 57, 53, 53, 99, 100, 52, 54, 53, 100, 99, 97, 57};

    public static String a(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            int[] iArr = a;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 32; i++) {
                sb.append((char) iArr[i]);
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(sb.toString().getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
            return new String(cipher.doFinal(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
