package ru.yoomoney.sdk.yoopinning;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jose4j.base64url.Base64Url;

/* compiled from: CryptUtils.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001a\u00020\u0004*\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u0004*\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0013\u0010\u000b\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lru/yoomoney/sdk/yoopinning/CryptUtils;", "", "<init>", "()V", "", "", "zip", "(Ljava/lang/String;)[B", "unzip", "([B)Ljava/lang/String;", "encodeBase64Url", "decodeBase64Url", "", "mode", "Ljavax/crypto/SecretKey;", "secretKey", "Ljavax/crypto/Cipher;", "initCipher", "(ILjavax/crypto/SecretKey;)Ljavax/crypto/Cipher;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "encrypt$yoopinning_release", "(Ljava/lang/String;Ljavax/crypto/SecretKey;)Ljava/lang/String;", "encrypt", "decrypt$yoopinning_release", "decrypt", "encodedSecretKey", "decodeAppSecretKey$yoopinning_release", "(Ljava/lang/String;)Ljavax/crypto/SecretKey;", "decodeAppSecretKey", "decryptCertSecretKey$yoopinning_release", "(Ljavax/crypto/SecretKey;Ljava/lang/String;)Ljava/lang/String;", "decryptCertSecretKey", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CryptUtils {
    public static final CryptUtils INSTANCE = new CryptUtils();

    private CryptUtils() {
    }

    public final String encrypt$yoopinning_release(String value, SecretKey secretKey) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        Cipher cipherInitCipher = initCipher(1, secretKey);
        byte[] bytes = value.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrDoFinal = cipherInitCipher.doFinal(bytes);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
        return encodeBase64Url(zip(encodeBase64Url(bArrDoFinal)));
    }

    public final String decrypt$yoopinning_release(String value, SecretKey secretKey) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        byte[] bArrDoFinal = initCipher(2, secretKey).doFinal(decodeBase64Url(unzip(decodeBase64Url(value))));
        Intrinsics.checkNotNull(bArrDoFinal);
        return new String(bArrDoFinal, Charsets.UTF_8);
    }

    public final SecretKey decodeAppSecretKey$yoopinning_release(String encodedSecretKey) {
        Intrinsics.checkNotNullParameter(encodedSecretKey, "encodedSecretKey");
        byte[] bArrDecodeBase64Url = decodeBase64Url(unzip(decodeBase64Url(encodedSecretKey)));
        return new SecretKeySpec(bArrDecodeBase64Url, 0, bArrDecodeBase64Url.length, "AES");
    }

    public final String decryptCertSecretKey$yoopinning_release(SecretKey secretKey, String value) throws BadPaddingException, IllegalBlockSizeException {
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        Intrinsics.checkNotNullParameter(value, "value");
        byte[] bArrDoFinal = initCipher(2, secretKey).doFinal(decodeBase64Url(unzip(decodeBase64Url(value))));
        Intrinsics.checkNotNull(bArrDoFinal);
        return new String(bArrDoFinal, Charsets.UTF_8);
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

    private final String encodeBase64Url(byte[] bArr) {
        String strEncode = Base64Url.encode(bArr);
        Intrinsics.checkNotNullExpressionValue(strEncode, "encode(...)");
        return strEncode;
    }

    private final byte[] decodeBase64Url(String str) {
        byte[] bArrDecode = Base64Url.decode(str);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return bArrDecode;
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
}
