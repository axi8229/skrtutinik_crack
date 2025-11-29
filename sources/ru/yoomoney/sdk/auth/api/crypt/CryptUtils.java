package ru.yoomoney.sdk.auth.api.crypt;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jose4j.base64url.Base64Url;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\tJ\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\tJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\tH\u0002J\u001b\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017H\u0007¢\u0006\u0002\u0010\u0018J\f\u0010\u0019\u001a\u00020\u001a*\u00020\u0004H\u0002J\f\u0010\u001b\u001a\u00020\u0004*\u00020\u001aH\u0002J\f\u0010\u001c\u001a\u00020\u0004*\u00020\u001aH\u0002J\f\u0010\u001d\u001a\u00020\u001a*\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lru/yoomoney/sdk/auth/api/crypt/CryptUtils;", "", "()V", "APP_SECRET_KEY_ALG", "", "APP_SECRET_KEY_SIZE", "", "IV_LENGTH", "decodeAppSecretKey", "Ljavax/crypto/SecretKey;", "encodedSecretKey", "decryptApiSecretKey", "secretKey", AppMeasurementSdk.ConditionalUserProperty.VALUE, "encodeAppSecretKey", "encryptApiSecretKey", "generateAppSecretKey", "initCipher", "Ljavax/crypto/Cipher;", "mode", "main", "", "args", "", "([Ljava/lang/String;)V", "decodeBase64Url", "", "encodeBase64Url", "unzip", "zip", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CryptUtils {
    private static final String APP_SECRET_KEY_ALG = "AES";
    private static final int APP_SECRET_KEY_SIZE = 256;
    public static final CryptUtils INSTANCE = new CryptUtils();
    private static final int IV_LENGTH = 16;

    private CryptUtils() {
    }

    private final byte[] decodeBase64Url(String str) {
        byte[] bArrDecode = Base64Url.decode(str);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return bArrDecode;
    }

    private final String encodeBase64Url(byte[] bArr) {
        String strEncode = Base64Url.encode(bArr);
        Intrinsics.checkNotNullExpressionValue(strEncode, "encode(...)");
        return strEncode;
    }

    private final Cipher initCipher(int mode, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
        byte[] encoded = secretKey.getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, "getEncoded(...)");
        new IvParameterSpec(ArraysKt.copyOfRange(encoded, 0, 16));
        cipher.init(mode, secretKey, ivParameterSpec);
        Intrinsics.checkNotNullExpressionValue(cipher, "apply(...)");
        return cipher;
    }

    @JvmStatic
    public static final void main(String[] args) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(args, "args");
        CryptUtils cryptUtils = INSTANCE;
        SecretKey secretKeyGenerateAppSecretKey = cryptUtils.generateAppSecretKey();
        String str = "encodedAppSecretKey = " + cryptUtils.encodeAppSecretKey(secretKeyGenerateAppSecretKey);
        PrintStream printStream = System.out;
        printStream.println((Object) str);
        printStream.println((Object) ("encryptedApiSecretKey = " + cryptUtils.encryptApiSecretKey(secretKeyGenerateAppSecretKey, "MTIzNDU2Nzg5MDEyMzQ1Njc4OTAxMjM0NTY3ODkwMTI")));
    }

    private final String unzip(byte[] bArr) {
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, UTF_8), 8192);
        try {
            String text = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            return text;
        } finally {
        }
    }

    private final byte[] zip(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream, UTF_8), 8192);
        try {
            bufferedWriter.write(str);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedWriter, null);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
            return byteArray;
        } finally {
        }
    }

    public final SecretKey decodeAppSecretKey(String encodedSecretKey) {
        Intrinsics.checkNotNullParameter(encodedSecretKey, "encodedSecretKey");
        byte[] bArrDecodeBase64Url = decodeBase64Url(unzip(decodeBase64Url(encodedSecretKey)));
        return new SecretKeySpec(bArrDecodeBase64Url, 0, bArrDecodeBase64Url.length, APP_SECRET_KEY_ALG);
    }

    public final String decryptApiSecretKey(SecretKey secretKey, String value) throws BadPaddingException, IllegalBlockSizeException {
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        Intrinsics.checkNotNullParameter(value, "value");
        byte[] bArrDoFinal = initCipher(2, secretKey).doFinal(decodeBase64Url(unzip(decodeBase64Url(value))));
        Intrinsics.checkNotNull(bArrDoFinal);
        return new String(bArrDoFinal, Charsets.UTF_8);
    }

    public final String encodeAppSecretKey(SecretKey secretKey) {
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        byte[] encoded = secretKey.getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, "getEncoded(...)");
        return encodeBase64Url(zip(encodeBase64Url(encoded)));
    }

    public final String encryptApiSecretKey(SecretKey secretKey, String value) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        Intrinsics.checkNotNullParameter(value, "value");
        Cipher cipherInitCipher = initCipher(1, secretKey);
        byte[] bytes = value.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrDoFinal = cipherInitCipher.doFinal(bytes);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
        return encodeBase64Url(zip(encodeBase64Url(bArrDoFinal)));
    }

    public final SecretKey generateAppSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(APP_SECRET_KEY_ALG);
        keyGenerator.init(256, new SecureRandom());
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        Intrinsics.checkNotNullExpressionValue(secretKeyGenerateKey, "generateKey(...)");
        return secretKeyGenerateKey;
    }
}
