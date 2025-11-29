package bz;

import android.util.Base64;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import okio.Utf8;

/* loaded from: classes.dex */
public abstract class D1 {
    public static final String a = Q1.a(new byte[]{-1, -12, -74, -13, 87, -123, 99, -45, 119, -2, 57, -121, -85, 68, 114, 125, 21, 81, 62, 6, -81, 87, 26, -25, -25, 109, -106, -127, -15, 104, -106, -61});

    public static void a(InputStream inputStream, ByteArrayOutputStream byteArrayOutputStream) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        String str = new String(Base64.decode(a.getBytes(), 0));
        String str2 = new String(Base64.decode("djZwODFSMEppV3k0RjViOFRUNXFnd2pJYUhSQjRGWFk=".getBytes(), 0));
        String str3 = new String(Base64.decode("ZDF4JDAjIUUyVVE5dlZlOQ==".getBytes(), 0));
        IvParameterSpec ivParameterSpec = new IvParameterSpec(Base64.decode("YlYxYTd5NjYxRW1LSmtUSA==".getBytes(), 0));
        SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance(Q1.a(new byte[]{-8, -36, 49, -93, 115, -48, -31, -60, -91, 89, -50, -74, 71, -124, -41, -93, ByteSourceJsonBootstrapper.UTF8_BOM_2, 112, -101, -13, 48, -56, -60, ByteSourceJsonBootstrapper.UTF8_BOM_1, -81, 104, 61, -55, ByteSourceJsonBootstrapper.UTF8_BOM_2, -82, -89, -102})).generateSecret(new PBEKeySpec(str.concat(str2).toCharArray(), str3.getBytes(), 16, 256)).getEncoded(), Q1.a(new byte[]{-89, -84, 14, -83, 22, 82, -42, 110, -47, -19, 126, 112, -58, 24, 72, -92}));
        Cipher cipher = Cipher.getInstance(Q1.a(new byte[]{-57, 65, 70, 74, -128, 68, -56, 15, -116, 37, -36, ByteSourceJsonBootstrapper.UTF8_BOM_1, -55, -117, 124, ByteSourceJsonBootstrapper.UTF8_BOM_2, 109, -41, 75, -29, 114, -78, -24, 125, -107, 114, Utf8.REPLACEMENT_BYTE, -105, 127, 69, -40, -8}));
        cipher.init(2, secretKeySpec, ivParameterSpec);
        byte[] bArr = new byte[64];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                break;
            }
            byte[] bArrUpdate = cipher.update(bArr, 0, i);
            if (bArrUpdate != null) {
                byteArrayOutputStream.write(bArrUpdate);
            }
        }
        byte[] bArrDoFinal = cipher.doFinal();
        if (bArrDoFinal != null) {
            byteArrayOutputStream.write(bArrDoFinal);
        }
    }
}
